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
/* loaded from: classes26.dex */
public class OfficialBarFeedMsglistView extends com.baidu.adp.base.c<OfficialBarFeedActivity> implements d.c {
    private View.OnClickListener eTU;
    private NoDataView ffT;
    private boolean jEX;
    private ImageView jFI;
    private d jFJ;
    private RecyclerView jFK;
    private TextView jFL;
    private View jFM;
    private View jFN;
    private h jFO;
    private String jFP;
    private TextView jFQ;
    private FrameLayout jFR;
    private TbPageContext<OfficialBarFeedActivity> jfX;
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
        this.jFN = null;
        this.jFO = null;
        this.mLisMsg = null;
        this.eTU = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarFeedMsglistView.this.b(view, OfficialBarFeedMsglistView.this.jfX.getPageActivity());
            }
        };
        this.mActivity = baseActivity;
        this.jEX = z;
        this.jfX = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        this.jFN = baseActivity.findViewById(R.id.msg_root_view);
        baseActivity.showLoadingView(this.jFN);
        b(baseActivity);
        c(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eTU);
        this.mImgBack.setOnClickListener(this.eTU);
        this.jFP = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
        this.mNavigationBar.setCenterTextTitle(this.jEX ? this.jFP + baseActivity.getString(R.string.forum) : baseActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.showBottomLine();
        if (this.jEX) {
            this.jFQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
            this.jFQ.setOnClickListener(this.eTU);
            return;
        }
        this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.eTU);
        this.jFI = (ImageView) this.mBtnGroupInfo.findViewById(R.id.feed_header_icon);
        this.jFI.setClickable(true);
        this.jFI.setOnClickListener(this.eTU);
    }

    private void c(BaseActivity baseActivity) {
        this.jFR = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        if (this.jEX) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLisMsg.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.mLisMsg.setLayoutParams(layoutParams);
        }
        this.jFO = new h(this.jfX, this.mLisMsg, this);
        this.jFO.rd(this.jEX);
        ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        if (!this.jEX) {
            this.rootView = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
            this.jFM = this.rootView.findViewById(R.id.official_bar_feed_header_view);
            this.jFL = (TextView) this.rootView.findViewById(R.id.official_feed_recent);
            this.jFK = (RecyclerView) this.rootView.findViewById(R.id.official_feed_recent_recyclerview);
            this.jFK.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            this.jFJ = new d(baseActivity.getPageContext(), this);
            this.jFK.setAdapter(this.jFJ);
            this.jFK.setClipChildren(false);
            this.jFK.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.1
                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    super.getItemOffsets(rect, view, recyclerView, state);
                    if (recyclerView.getChildLayoutPosition(view) == 0) {
                        rect.left = l.getDimens(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
                    }
                }
            }, 0);
        }
        this.mLisMsg.setAdapter((ListAdapter) this.jFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.jFO.setData(list);
        if (this.jEX) {
            this.mLisMsg.setSelection(this.mLisMsg.getBottom());
        }
        this.mActivity.hideLoadingView(this.jFN);
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
                aVar2.Lp(aVar.cLL());
                aVar2.Lq(aVar.getForumName());
                aVar2.setUnReadCount(aVar.getUnReadCount());
                aVar2.setUserType(aVar.getUserType());
                aVar2.setGroupId(Long.parseLong(aVar.getGid()));
                aVar2.fH(aVar.cJw());
                arrayList.add(aVar2);
            }
            this.jFJ.setData(arrayList);
            if (this.rootView != null && this.mLisMsg.getHeaderViewsCount() <= 0) {
                this.mLisMsg.addHeaderView(this.rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() > 0) {
            this.jFO.b(longSparseArray);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.onBackBtnOnChangeSkin();
        ap.setViewTextColor(this.jFI, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jFL, R.color.cp_cont_b);
        ap.setViewTextColor(this.jFQ, R.color.cp_cont_b);
        ap.setBackgroundColor(this.jFR, R.color.cp_bg_line_c);
        if (this.jFM != null) {
            com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_bg_line_e).oZ(l.getDimens(this.jfX.getPageActivity(), R.dimen.tbds31)).pa(R.color.cp_shadow_a_alpha16).oY(4369).pb(l.getDimens(this.jfX.getPageActivity(), R.dimen.tbds10)).pc(0).pd(l.getDimens(this.jfX.getPageActivity(), R.dimen.tbds5)).bf(this.jFM);
        }
        if (this.ffT != null) {
            this.ffT.onChangeSkinType(this.jfX, i);
        }
        if (this.jFI != null) {
            SvgManager.bmU().a(this.jFI, R.drawable.icon_pure_more_administration44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jFO != null) {
            this.jFO.notifyDataSetChanged();
        }
    }

    public void b(View view, Activity activity) {
        if (view == this.jFI) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mImgBack) {
            activity.finish();
        } else if (view == this.jFQ) {
            this.mContext.sendMessage(new CustomMessage<>((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.jFP, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            if (activity.getIntent() != null) {
                aq aqVar = new aq("c13867");
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dK("fid", activity.getIntent().getStringExtra("key_uid"));
                TiebaStatic.log(aqVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.officialBar.d.c
    public void a(View view, Object obj, int i, long j) {
        if (obj instanceof d.a) {
            d.a aVar = (d.a) obj;
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.jfX.getPageActivity(), String.valueOf(aVar.getGroupId()), aVar.cDs());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleForumBroadcastFeedActivityConfig));
            aq aqVar = new aq("c13862");
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.u("fid", aVar.getGroupId());
            TiebaStatic.log(aqVar);
        } else if (obj instanceof a.C0734a) {
            a((a.C0734a) obj, this.jfX.getPageActivity());
        }
    }

    private void a(a.C0734a c0734a, Context context) {
        if (c0734a != null) {
            G(c0734a.fid, System.currentTimeMillis());
            if (!StringUtils.isNull(c0734a.url)) {
                if (c0734a.url.startsWith("web:http")) {
                    c0734a.url = c0734a.url.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
                }
                if (c0734a.url.contains("?")) {
                    c0734a.url = String.format(Locale.US, "%s&broadcast_id=%d", c0734a.url, Long.valueOf(c0734a.jTT));
                } else {
                    c0734a.url = String.format(Locale.US, "%s?broadcast_id=%d", c0734a.url, Long.valueOf(c0734a.jTT));
                }
                if (c0734a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        context.startActivity(Intent.parseUri(c0734a.url, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (URLUtil.isHttpUrl(c0734a.url) || URLUtil.isHttpsUrl(c0734a.url) || c0734a.url.startsWith("flt://")) {
                    be.bmY().b(this.jfX, new String[]{c0734a.url});
                } else {
                    Uri parse = Uri.parse(c0734a.url);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(context, parse.toString());
                    }
                }
                aq aqVar = new aq(this.jEX ? "c13866" : "c13864");
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dK("fid", c0734a.fid);
                aqVar.dK("tid", c0734a.tid == null ? "" : c0734a.tid);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void hideNoDataView() {
        if (this.ffT != null && this.ffT.getVisibility() == 0) {
            this.ffT.setVisibility(8);
        }
    }

    private void showNoDataView() {
        if (this.ffT == null) {
            this.ffT = NoDataViewFactory.a(this.jfX.getPageActivity(), this.jFN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 454), NoDataViewFactory.d.pv(R.string.official_feed_no_data), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.ffT.setImgOption(aVar.bnX());
        }
        if (this.ffT.getVisibility() != 0) {
            this.ffT.onChangeSkinType(this.jfX, TbadkApplication.getInst().getSkinType());
            this.ffT.setVisibility(0);
        }
    }

    public void G(final String str, final long j) {
        ae.b(new ad<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bFA */
            public Void doInBackground() {
                if (!StringUtils.isNull(str)) {
                    com.baidu.tieba.im.db.l.cLD().z(Long.parseLong(str), j);
                    return null;
                }
                return null;
            }
        }, null);
    }
}
