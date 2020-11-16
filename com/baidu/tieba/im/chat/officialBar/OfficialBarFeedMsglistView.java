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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.d;
import com.baidu.tieba.im.message.chat.a;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes25.dex */
public class OfficialBarFeedMsglistView extends com.baidu.adp.base.c<OfficialBarFeedActivity> implements d.c {
    private View.OnClickListener fhp;
    private NoDataView ftx;
    private RecyclerView gRF;
    private ImageView jYO;
    private d jYP;
    private TextView jYQ;
    private View jYR;
    private View jYS;
    private h jYT;
    private String jYU;
    private TextView jYV;
    private FrameLayout jYW;
    private boolean jYd;
    private TbPageContext<OfficialBarFeedActivity> jzj;
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
        this.jYS = null;
        this.jYT = null;
        this.mLisMsg = null;
        this.fhp = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarFeedMsglistView.this.b(view, OfficialBarFeedMsglistView.this.jzj.getPageActivity());
            }
        };
        this.mActivity = baseActivity;
        this.jYd = z;
        this.jzj = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        this.jYS = baseActivity.findViewById(R.id.msg_root_view);
        baseActivity.showLoadingView(this.jYS);
        b(baseActivity);
        c(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fhp);
        this.mImgBack.setOnClickListener(this.fhp);
        this.jYU = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
        this.mNavigationBar.setCenterTextTitle(this.jYd ? this.jYU + baseActivity.getString(R.string.forum) : baseActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.showBottomLine();
        if (this.jYd) {
            this.jYV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
            this.jYV.setOnClickListener(this.fhp);
            return;
        }
        this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.fhp);
        this.jYO = (ImageView) this.mBtnGroupInfo.findViewById(R.id.feed_header_icon);
        this.jYO.setClickable(true);
        this.jYO.setOnClickListener(this.fhp);
    }

    private void c(BaseActivity baseActivity) {
        this.jYW = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        if (this.jYd) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLisMsg.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.mLisMsg.setLayoutParams(layoutParams);
        }
        this.jYT = new h(this.jzj, this.mLisMsg, this);
        this.jYT.rH(this.jYd);
        ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        if (!this.jYd) {
            this.rootView = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
            this.jYR = this.rootView.findViewById(R.id.official_bar_feed_header_view);
            this.jYQ = (TextView) this.rootView.findViewById(R.id.official_feed_recent);
            this.gRF = (RecyclerView) this.rootView.findViewById(R.id.official_feed_recent_recyclerview);
            this.gRF.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            this.jYP = new d(baseActivity.getPageContext(), this);
            this.gRF.setAdapter(this.jYP);
            this.gRF.setClipChildren(false);
            this.gRF.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.1
                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    super.getItemOffsets(rect, view, recyclerView, state);
                    if (recyclerView.getChildLayoutPosition(view) == 0) {
                        rect.left = l.getDimens(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
                    }
                }
            }, 0);
        }
        this.mLisMsg.setAdapter((ListAdapter) this.jYT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.jYT.setData(list);
        if (this.jYd) {
            this.mLisMsg.setSelection(this.mLisMsg.getBottom());
        }
        this.mActivity.hideLoadingView(this.jYS);
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
                aVar2.LF(aVar.cQZ());
                aVar2.LG(aVar.getForumName());
                aVar2.setUnReadCount(aVar.getUnReadCount());
                aVar2.setUserType(aVar.getUserType());
                aVar2.setGroupId(Long.parseLong(aVar.getGid()));
                aVar2.gh(aVar.cOK());
                arrayList.add(aVar2);
            }
            this.jYP.setData(arrayList);
            if (this.rootView != null && this.mLisMsg.getHeaderViewsCount() <= 0) {
                this.mLisMsg.addHeaderView(this.rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() > 0) {
            this.jYT.b(longSparseArray);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.onBackBtnOnChangeSkin();
        ap.setViewTextColor(this.jYO, R.color.CAM_X0302, 1);
        ap.setViewTextColor(this.jYQ, R.color.CAM_X0105);
        ap.setViewTextColor(this.jYV, R.color.CAM_X0105);
        ap.setBackgroundColor(this.jYW, R.color.CAM_X0204);
        if (this.jYR != null) {
            com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0205).pS(l.getDimens(this.jzj.getPageActivity(), R.dimen.tbds31)).pT(R.color.CAM_X0804).pR(4369).pU(l.getDimens(this.jzj.getPageActivity(), R.dimen.tbds10)).pV(0).pW(l.getDimens(this.jzj.getPageActivity(), R.dimen.tbds5)).bn(this.jYR);
        }
        if (this.ftx != null) {
            this.ftx.onChangeSkinType(this.jzj, i);
        }
        if (this.jYO != null) {
            SvgManager.bqB().a(this.jYO, R.drawable.icon_pure_more_administration44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jYT != null) {
            this.jYT.notifyDataSetChanged();
        }
    }

    public void b(View view, Activity activity) {
        if (view == this.jYO) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mImgBack) {
            activity.finish();
        } else if (view == this.jYV) {
            this.mContext.sendMessage(new CustomMessage<>((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.jYU, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            if (activity.getIntent() != null) {
                ar arVar = new ar("c13867");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.dR("fid", activity.getIntent().getStringExtra("key_uid"));
                TiebaStatic.log(arVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.officialBar.d.c
    public void a(View view, Object obj, int i, long j) {
        if (obj instanceof d.a) {
            d.a aVar = (d.a) obj;
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.jzj.getPageActivity(), String.valueOf(aVar.getGroupId()), aVar.cIF());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleForumBroadcastFeedActivityConfig));
            ar arVar = new ar("c13862");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.w("fid", aVar.getGroupId());
            TiebaStatic.log(arVar);
        } else if (obj instanceof a.C0766a) {
            a((a.C0766a) obj, this.jzj.getPageActivity());
        }
    }

    private void a(a.C0766a c0766a, Context context) {
        if (c0766a != null) {
            J(c0766a.fid, System.currentTimeMillis());
            if (!StringUtils.isNull(c0766a.url)) {
                if (c0766a.url.startsWith("web:http")) {
                    c0766a.url = c0766a.url.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
                }
                if (c0766a.url.contains("?")) {
                    c0766a.url = String.format(Locale.US, "%s&broadcast_id=%d", c0766a.url, Long.valueOf(c0766a.kna));
                } else {
                    c0766a.url = String.format(Locale.US, "%s?broadcast_id=%d", c0766a.url, Long.valueOf(c0766a.kna));
                }
                if (c0766a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        context.startActivity(Intent.parseUri(c0766a.url, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (URLUtil.isHttpUrl(c0766a.url) || URLUtil.isHttpsUrl(c0766a.url) || c0766a.url.startsWith("flt://")) {
                    bf.bqF().b(this.jzj, new String[]{c0766a.url});
                } else {
                    Uri parse = Uri.parse(c0766a.url);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(context, parse.toString());
                    }
                }
                ar arVar = new ar(this.jYd ? "c13866" : "c13864");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.dR("fid", c0766a.fid);
                arVar.dR("tid", c0766a.tid == null ? "" : c0766a.tid);
                TiebaStatic.log(arVar);
            }
        }
    }

    private void hideNoDataView() {
        if (this.ftx != null && this.ftx.getVisibility() == 0) {
            this.ftx.setVisibility(8);
        }
    }

    private void showNoDataView() {
        if (this.ftx == null) {
            this.ftx = NoDataViewFactory.a(this.jzj.getPageActivity(), this.jYS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 454), NoDataViewFactory.d.qo(R.string.official_feed_no_data), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.ftx.setImgOption(aVar.brF());
        }
        if (this.ftx.getVisibility() != 0) {
            this.ftx.onChangeSkinType(this.jzj, TbadkApplication.getInst().getSkinType());
            this.ftx.setVisibility(0);
        }
    }

    public void J(final String str, final long j) {
        ad.b(new ac<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bJl */
            public Void doInBackground() {
                if (!StringUtils.isNull(str)) {
                    com.baidu.tieba.im.db.l.cQR().B(Long.parseLong(str), j);
                    return null;
                }
                return null;
            }
        }, null);
    }
}
