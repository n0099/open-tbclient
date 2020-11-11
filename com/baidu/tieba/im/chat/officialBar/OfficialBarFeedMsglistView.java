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
    private View.OnClickListener fii;
    private NoDataView fun;
    private RecyclerView gRY;
    private boolean jXt;
    private ImageView jYe;
    private d jYf;
    private TextView jYg;
    private View jYh;
    private View jYi;
    private h jYj;
    private String jYk;
    private TextView jYl;
    private FrameLayout jYm;
    private TbPageContext<OfficialBarFeedActivity> jys;
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
        this.jYi = null;
        this.jYj = null;
        this.mLisMsg = null;
        this.fii = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarFeedMsglistView.this.b(view, OfficialBarFeedMsglistView.this.jys.getPageActivity());
            }
        };
        this.mActivity = baseActivity;
        this.jXt = z;
        this.jys = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        this.jYi = baseActivity.findViewById(R.id.msg_root_view);
        baseActivity.showLoadingView(this.jYi);
        b(baseActivity);
        c(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fii);
        this.mImgBack.setOnClickListener(this.fii);
        this.jYk = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
        this.mNavigationBar.setCenterTextTitle(this.jXt ? this.jYk + baseActivity.getString(R.string.forum) : baseActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.showBottomLine();
        if (this.jXt) {
            this.jYl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
            this.jYl.setOnClickListener(this.fii);
            return;
        }
        this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.fii);
        this.jYe = (ImageView) this.mBtnGroupInfo.findViewById(R.id.feed_header_icon);
        this.jYe.setClickable(true);
        this.jYe.setOnClickListener(this.fii);
    }

    private void c(BaseActivity baseActivity) {
        this.jYm = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        if (this.jXt) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLisMsg.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.mLisMsg.setLayoutParams(layoutParams);
        }
        this.jYj = new h(this.jys, this.mLisMsg, this);
        this.jYj.rE(this.jXt);
        ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        if (!this.jXt) {
            this.rootView = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
            this.jYh = this.rootView.findViewById(R.id.official_bar_feed_header_view);
            this.jYg = (TextView) this.rootView.findViewById(R.id.official_feed_recent);
            this.gRY = (RecyclerView) this.rootView.findViewById(R.id.official_feed_recent_recyclerview);
            this.gRY.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            this.jYf = new d(baseActivity.getPageContext(), this);
            this.gRY.setAdapter(this.jYf);
            this.gRY.setClipChildren(false);
            this.gRY.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.1
                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    super.getItemOffsets(rect, view, recyclerView, state);
                    if (recyclerView.getChildLayoutPosition(view) == 0) {
                        rect.left = l.getDimens(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
                    }
                }
            }, 0);
        }
        this.mLisMsg.setAdapter((ListAdapter) this.jYj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.jYj.setData(list);
        if (this.jXt) {
            this.mLisMsg.setSelection(this.mLisMsg.getBottom());
        }
        this.mActivity.hideLoadingView(this.jYi);
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
                aVar2.Me(aVar.cRt());
                aVar2.Mf(aVar.getForumName());
                aVar2.setUnReadCount(aVar.getUnReadCount());
                aVar2.setUserType(aVar.getUserType());
                aVar2.setGroupId(Long.parseLong(aVar.getGid()));
                aVar2.ge(aVar.cPe());
                arrayList.add(aVar2);
            }
            this.jYf.setData(arrayList);
            if (this.rootView != null && this.mLisMsg.getHeaderViewsCount() <= 0) {
                this.mLisMsg.addHeaderView(this.rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() > 0) {
            this.jYj.b(longSparseArray);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.onBackBtnOnChangeSkin();
        ap.setViewTextColor(this.jYe, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jYg, R.color.cp_cont_b);
        ap.setViewTextColor(this.jYl, R.color.cp_cont_b);
        ap.setBackgroundColor(this.jYm, R.color.cp_bg_line_c);
        if (this.jYh != null) {
            com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_bg_line_e).pv(l.getDimens(this.jys.getPageActivity(), R.dimen.tbds31)).pw(R.color.cp_shadow_a_alpha16).pu(4369).px(l.getDimens(this.jys.getPageActivity(), R.dimen.tbds10)).py(0).pz(l.getDimens(this.jys.getPageActivity(), R.dimen.tbds5)).bk(this.jYh);
        }
        if (this.fun != null) {
            this.fun.onChangeSkinType(this.jys, i);
        }
        if (this.jYe != null) {
            SvgManager.brn().a(this.jYe, R.drawable.icon_pure_more_administration44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jYj != null) {
            this.jYj.notifyDataSetChanged();
        }
    }

    public void b(View view, Activity activity) {
        if (view == this.jYe) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mImgBack) {
            activity.finish();
        } else if (view == this.jYl) {
            this.mContext.sendMessage(new CustomMessage<>((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.jYk, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            if (activity.getIntent() != null) {
                aq aqVar = new aq("c13867");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dR("fid", activity.getIntent().getStringExtra("key_uid"));
                TiebaStatic.log(aqVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.officialBar.d.c
    public void a(View view, Object obj, int i, long j) {
        if (obj instanceof d.a) {
            d.a aVar = (d.a) obj;
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.jys.getPageActivity(), String.valueOf(aVar.getGroupId()), aVar.cJa());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleForumBroadcastFeedActivityConfig));
            aq aqVar = new aq("c13862");
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.w("fid", aVar.getGroupId());
            TiebaStatic.log(aqVar);
        } else if (obj instanceof a.C0764a) {
            a((a.C0764a) obj, this.jys.getPageActivity());
        }
    }

    private void a(a.C0764a c0764a, Context context) {
        if (c0764a != null) {
            J(c0764a.fid, System.currentTimeMillis());
            if (!StringUtils.isNull(c0764a.url)) {
                if (c0764a.url.startsWith("web:http")) {
                    c0764a.url = c0764a.url.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
                }
                if (c0764a.url.contains("?")) {
                    c0764a.url = String.format(Locale.US, "%s&broadcast_id=%d", c0764a.url, Long.valueOf(c0764a.kmq));
                } else {
                    c0764a.url = String.format(Locale.US, "%s?broadcast_id=%d", c0764a.url, Long.valueOf(c0764a.kmq));
                }
                if (c0764a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        context.startActivity(Intent.parseUri(c0764a.url, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (URLUtil.isHttpUrl(c0764a.url) || URLUtil.isHttpsUrl(c0764a.url) || c0764a.url.startsWith("flt://")) {
                    be.brr().b(this.jys, new String[]{c0764a.url});
                } else {
                    Uri parse = Uri.parse(c0764a.url);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(context, parse.toString());
                    }
                }
                aq aqVar = new aq(this.jXt ? "c13866" : "c13864");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dR("fid", c0764a.fid);
                aqVar.dR("tid", c0764a.tid == null ? "" : c0764a.tid);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void hideNoDataView() {
        if (this.fun != null && this.fun.getVisibility() == 0) {
            this.fun.setVisibility(8);
        }
    }

    private void showNoDataView() {
        if (this.fun == null) {
            this.fun = NoDataViewFactory.a(this.jys.getPageActivity(), this.jYi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 454), NoDataViewFactory.d.pQ(R.string.official_feed_no_data), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.fun.setImgOption(aVar.bsq());
        }
        if (this.fun.getVisibility() != 0) {
            this.fun.onChangeSkinType(this.jys, TbadkApplication.getInst().getSkinType());
            this.fun.setVisibility(0);
        }
    }

    public void J(final String str, final long j) {
        ae.b(new ad<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bJS */
            public Void doInBackground() {
                if (!StringUtils.isNull(str)) {
                    com.baidu.tieba.im.db.l.cRl().B(Long.parseLong(str), j);
                    return null;
                }
                return null;
            }
        }, null);
    }
}
