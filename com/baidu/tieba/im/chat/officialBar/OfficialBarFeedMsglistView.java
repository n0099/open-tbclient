package com.baidu.tieba.im.chat.officialBar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.SingleForumBroadcastFeedActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.d;
import com.baidu.tieba.im.message.chat.a;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes25.dex */
public class OfficialBarFeedMsglistView extends com.baidu.adp.base.c<OfficialBarFeedActivity> implements d.c {
    private View.OnClickListener eHN;
    private NoDataView eTL;
    private TbPageContext<OfficialBarFeedActivity> iRd;
    private ImageView jqL;
    private d jqM;
    private RecyclerView jqN;
    private TextView jqO;
    private View jqP;
    private View jqQ;
    private h jqR;
    private String jqS;
    private TextView jqT;
    private FrameLayout jqU;
    private boolean jqa;
    private BaseActivity<OfficialBarFeedActivity> mActivity;
    private View mBtnGroupInfo;
    private View mImgBack;
    private BdTypeListView mLisMsg;
    private NavigationBar mNavigationBar;
    private View rootView;

    public OfficialBarFeedMsglistView(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this(baseActivity, false);
    }

    public OfficialBarFeedMsglistView(BaseActivity<OfficialBarFeedActivity> baseActivity, boolean z) {
        super(baseActivity.getPageContext());
        this.mNavigationBar = null;
        this.mBtnGroupInfo = null;
        this.mImgBack = null;
        this.rootView = null;
        this.jqQ = null;
        this.jqR = null;
        this.mLisMsg = null;
        this.eHN = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarFeedMsglistView.this.b(view, OfficialBarFeedMsglistView.this.iRd.getPageActivity());
            }
        };
        this.mActivity = baseActivity;
        this.jqa = z;
        this.iRd = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        this.jqQ = baseActivity.findViewById(R.id.msg_root_view);
        baseActivity.showLoadingView(this.jqQ);
        b(baseActivity);
        c(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eHN);
        this.mImgBack.setOnClickListener(this.eHN);
        this.jqS = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
        this.mNavigationBar.setCenterTextTitle(this.jqa ? this.jqS + baseActivity.getString(R.string.forum) : baseActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.showBottomLine();
        if (this.jqa) {
            this.jqT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
            this.jqT.setOnClickListener(this.eHN);
            return;
        }
        this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.eHN);
        this.jqL = (ImageView) this.mBtnGroupInfo.findViewById(R.id.feed_header_icon);
        this.jqL.setClickable(true);
        this.jqL.setOnClickListener(this.eHN);
    }

    private void c(BaseActivity baseActivity) {
        this.jqU = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        if (this.jqa) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLisMsg.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.mLisMsg.setLayoutParams(layoutParams);
        }
        this.jqR = new h(this.iRd, this.mLisMsg, this);
        this.jqR.qx(this.jqa);
        ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        if (!this.jqa) {
            this.rootView = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
            this.jqP = this.rootView.findViewById(R.id.official_bar_feed_header_view);
            this.jqO = (TextView) this.rootView.findViewById(R.id.official_feed_recent);
            this.jqN = (RecyclerView) this.rootView.findViewById(R.id.official_feed_recent_recyclerview);
            this.jqN.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            this.jqM = new d(baseActivity.getPageContext(), this);
            this.jqN.setAdapter(this.jqM);
            this.jqN.setClipChildren(false);
            this.jqN.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.1
                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    super.getItemOffsets(rect, view, recyclerView, state);
                    if (recyclerView.getChildLayoutPosition(view) == 0) {
                        rect.left = l.getDimens(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
                    }
                }
            }, 0);
        }
        this.mLisMsg.setAdapter((ListAdapter) this.jqR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.jqR.setData(list);
        if (this.jqa) {
            this.mLisMsg.setSelection(this.mLisMsg.getBottom());
        }
        this.mActivity.hideLoadingView(this.jqQ);
        if (list != null && list.size() > 0) {
            hideNoDataView();
        } else {
            showNoDataView();
        }
        if (list2 != null && list2.size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>(10);
            for (int i = 0; i < 10 && i < list2.size(); i++) {
                com.baidu.tieba.im.db.pojo.a aVar = list2.get(i);
                d.a aVar2 = new d.a();
                aVar2.KA(aVar.cIc());
                aVar2.KB(aVar.getForumName());
                aVar2.setUnReadCount(aVar.getUnReadCount());
                aVar2.setUserType(aVar.getUserType());
                aVar2.setGroupId(Long.parseLong(aVar.getGid()));
                aVar2.fp(aVar.cFN());
                arrayList.add(aVar2);
            }
            this.jqM.setData(arrayList);
            if (this.rootView != null && this.mLisMsg.getHeaderViewsCount() <= 0) {
                this.mLisMsg.addHeaderView(this.rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() > 0) {
            this.jqR.b(longSparseArray);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.onBackBtnOnChangeSkin();
        ap.setViewTextColor(this.jqL, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jqO, R.color.cp_cont_b);
        ap.setViewTextColor(this.jqT, R.color.cp_cont_b);
        ap.setBackgroundColor(this.jqU, R.color.cp_bg_line_c);
        if (this.jqP != null) {
            com.baidu.tbadk.core.util.e.a.bkK().oG(R.color.cp_bg_line_e).oB(l.getDimens(this.iRd.getPageActivity(), R.dimen.tbds31)).oC(R.color.cp_shadow_a_alpha16).oA(4369).oD(l.getDimens(this.iRd.getPageActivity(), R.dimen.tbds10)).oE(0).oF(l.getDimens(this.iRd.getPageActivity(), R.dimen.tbds5)).bb(this.jqP);
        }
        if (this.eTL != null) {
            this.eTL.onChangeSkinType(this.iRd, i);
        }
        if (this.jqL != null) {
            SvgManager.bkl().a(this.jqL, R.drawable.icon_pure_more_administration44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jqR != null) {
            this.jqR.notifyDataSetChanged();
        }
    }

    public void b(View view, Activity activity) {
        if (view == this.jqL) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mImgBack) {
            activity.finish();
        } else if (view == this.jqT) {
            this.mContext.sendMessage(new CustomMessage<>((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.jqS, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            if (activity.getIntent() != null) {
                aq aqVar = new aq("c13867");
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dF("fid", activity.getIntent().getStringExtra("key_uid"));
                TiebaStatic.log(aqVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.officialBar.d.c
    public void a(View view, Object obj, int i, long j) {
        if (obj instanceof d.a) {
            d.a aVar = (d.a) obj;
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.iRd.getPageActivity(), String.valueOf(aVar.getGroupId()), aVar.czO());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleForumBroadcastFeedActivityConfig));
            aq aqVar = new aq("c13862");
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.u("fid", aVar.getGroupId());
            TiebaStatic.log(aqVar);
        } else if (obj instanceof a.C0716a) {
            a((a.C0716a) obj, this.iRd.getPageActivity());
        }
    }

    private void a(a.C0716a c0716a, Context context) {
        if (c0716a != null) {
            G(c0716a.fid, System.currentTimeMillis());
            if (!StringUtils.isNull(c0716a.url)) {
                if (c0716a.url.startsWith("web:http")) {
                    c0716a.url = c0716a.url.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
                }
                if (c0716a.url.contains("?")) {
                    c0716a.url = String.format(Locale.US, "%s&broadcast_id=%d", c0716a.url, Long.valueOf(c0716a.jEW));
                } else {
                    c0716a.url = String.format(Locale.US, "%s?broadcast_id=%d", c0716a.url, Long.valueOf(c0716a.jEW));
                }
                if (c0716a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        context.startActivity(Intent.parseUri(c0716a.url, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (URLUtil.isHttpUrl(c0716a.url) || URLUtil.isHttpsUrl(c0716a.url) || c0716a.url.startsWith("flt://")) {
                    be.bkp().b(this.iRd, new String[]{c0716a.url});
                } else {
                    Uri parse = Uri.parse(c0716a.url);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(context, parse.toString());
                    }
                }
                aq aqVar = new aq(this.jqa ? "c13866" : "c13864");
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dF("fid", c0716a.fid);
                aqVar.dF("tid", c0716a.tid == null ? "" : c0716a.tid);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void hideNoDataView() {
        if (this.eTL != null && this.eTL.getVisibility() == 0) {
            this.eTL.setVisibility(8);
        }
    }

    private void showNoDataView() {
        if (this.eTL == null) {
            this.eTL = NoDataViewFactory.a(this.iRd.getPageActivity(), this.jqQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 454), NoDataViewFactory.d.oW(R.string.official_feed_no_data), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.eTL.setImgOption(aVar.bln());
        }
        if (this.eTL.getVisibility() != 0) {
            this.eTL.onChangeSkinType(this.iRd, TbadkApplication.getInst().getSkinType());
            this.eTL.setVisibility(0);
        }
    }

    public void G(final String str, final long j) {
        ae.b(new ad<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bCO */
            public Void doInBackground() {
                if (!StringUtils.isNull(str)) {
                    com.baidu.tieba.im.db.l.cHU().z(Long.parseLong(str), j);
                    return null;
                }
                return null;
            }
        }, null);
    }
}
