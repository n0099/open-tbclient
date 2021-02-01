package com.baidu.tieba.im.chat.officialBar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.tieba.im.message.chat.a;
import com.baidu.tieba.view.BdTopToast;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes8.dex */
public class OfficialBarFeedMsglistView extends com.baidu.adp.base.d<OfficialBarFeedActivity> implements OfficialBarFeedMsglistAdapter.c {
    private NoDataView fIt;
    private RecyclerView hmn;
    private boolean kBS;
    private ImageView kCD;
    private OfficialBarFeedMsglistAdapter kCE;
    private TextView kCF;
    private View kCG;
    private ViewGroup kCH;
    private g kCI;
    private String kCJ;
    private TextView kCK;
    private FrameLayout kCL;
    private TbPageContext<OfficialBarFeedActivity> kcX;
    private BaseActivity<OfficialBarFeedActivity> mActivity;
    private View mBtnGroupInfo;
    private View mImgBack;
    private BdTypeListView mLisMsg;
    private NavigationBar mNavigationBar;
    private View.OnClickListener onClickListener;
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
        this.kCH = null;
        this.kCI = null;
        this.mLisMsg = null;
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarFeedMsglistView.this.b(view, OfficialBarFeedMsglistView.this.kcX.getPageActivity());
            }
        };
        this.mActivity = baseActivity;
        this.kBS = z;
        this.kcX = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        this.kCH = (ViewGroup) baseActivity.findViewById(R.id.msg_root_view);
        baseActivity.showLoadingView(this.kCH);
        b(baseActivity);
        c(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onClickListener);
        this.mImgBack.setOnClickListener(this.onClickListener);
        this.kCJ = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
        this.mNavigationBar.setCenterTextTitle(this.kBS ? this.kCJ + baseActivity.getString(R.string.forum) : baseActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.showBottomLine();
        if (this.kBS) {
            this.kCK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
            this.kCK.setOnClickListener(this.onClickListener);
            return;
        }
        this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.onClickListener);
        this.kCD = (ImageView) this.mBtnGroupInfo.findViewById(R.id.feed_header_icon);
        this.kCD.setClickable(true);
        this.kCD.setOnClickListener(this.onClickListener);
    }

    private void c(BaseActivity baseActivity) {
        this.kCL = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        if (this.kBS) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLisMsg.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.mLisMsg.setLayoutParams(layoutParams);
        }
        this.kCI = new g(this.kcX, this.mLisMsg, this);
        this.kCI.sL(this.kBS);
        ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        if (!this.kBS) {
            this.rootView = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
            this.kCG = this.rootView.findViewById(R.id.official_bar_feed_header_view);
            this.kCF = (TextView) this.rootView.findViewById(R.id.official_feed_recent);
            this.hmn = (RecyclerView) this.rootView.findViewById(R.id.official_feed_recent_recyclerview);
            this.hmn.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            this.kCE = new OfficialBarFeedMsglistAdapter(baseActivity.getPageContext(), this);
            this.hmn.setAdapter(this.kCE);
            this.hmn.setClipChildren(false);
            this.hmn.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    super.getItemOffsets(rect, view, recyclerView, state);
                    if (recyclerView.getChildLayoutPosition(view) == 0) {
                        rect.left = l.getDimens(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
                    }
                }
            }, 0);
        }
        this.mLisMsg.setAdapter((ListAdapter) this.kCI);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.kCI.setData(list);
        if (this.kBS) {
            this.mLisMsg.setSelection(this.mLisMsg.getBottom());
        }
        this.mActivity.hideLoadingView(this.kCH);
        if (list != null && list.size() > 0) {
            hideNoDataView();
        } else {
            showNoDataView();
        }
        if (list2 != null && list2.size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>(10);
            for (int i = 0; i < 10 && i < list2.size(); i++) {
                com.baidu.tieba.im.db.pojo.a aVar = list2.get(i);
                OfficialBarFeedMsglistAdapter.a aVar2 = new OfficialBarFeedMsglistAdapter.a();
                aVar2.Ms(aVar.cVR());
                aVar2.Mt(aVar.getForumName());
                aVar2.setUnReadCount(aVar.getUnReadCount());
                aVar2.setUserType(aVar.getUserType());
                aVar2.setGroupId(Long.parseLong(aVar.getGid()));
                aVar2.gP(aVar.cUS());
                arrayList.add(aVar2);
            }
            this.kCE.setData(arrayList);
            if (this.rootView != null && this.mLisMsg.getHeaderViewsCount() <= 0) {
                this.mLisMsg.addHeaderView(this.rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() > 0) {
            this.kCI.b(longSparseArray);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.onBackBtnOnChangeSkin();
        ap.setViewTextColor(this.kCD, R.color.CAM_X0302, 1);
        ap.setViewTextColor(this.kCF, R.color.CAM_X0105);
        ap.setViewTextColor(this.kCK, R.color.CAM_X0105);
        ap.setBackgroundColor(this.kCL, R.color.CAM_X0204);
        if (this.kCG != null) {
            com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0205).pb(l.getDimens(this.kcX.getPageActivity(), R.dimen.tbds31)).pc(R.color.CAM_X0804).pa(4369).pd(l.getDimens(this.kcX.getPageActivity(), R.dimen.tbds10)).pe(0).pf(l.getDimens(this.kcX.getPageActivity(), R.dimen.tbds5)).bv(this.kCG);
        }
        if (this.fIt != null) {
            this.fIt.onChangeSkinType(this.kcX, i);
        }
        if (this.kCD != null) {
            SvgManager.bsR().a(this.kCD, R.drawable.icon_pure_more_administration44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kCI != null) {
            this.kCI.notifyDataSetChanged();
        }
    }

    public void b(View view, Activity activity) {
        if (view == this.kCD) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mImgBack) {
            activity.finish();
        } else if (view == this.kCK) {
            this.mContext.sendMessage(new CustomMessage<>((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.kCJ, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            if (activity.getIntent() != null) {
                ar arVar = new ar("c13867");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.dR("fid", activity.getIntent().getStringExtra("key_uid"));
                TiebaStatic.log(arVar);
            }
        }
    }

    public void showTipToast(boolean z, String str) {
        new BdTopToast(this.mActivity).zn(z).UN(str).aR(this.kCH);
    }

    @Override // com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter.c
    public void a(View view, Object obj, int i, long j) {
        if (obj instanceof OfficialBarFeedMsglistAdapter.a) {
            OfficialBarFeedMsglistAdapter.a aVar = (OfficialBarFeedMsglistAdapter.a) obj;
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.kcX.getPageActivity(), String.valueOf(aVar.getGroupId()), aVar.cPg());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleForumBroadcastFeedActivityConfig));
            ar arVar = new ar("c13862");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.v("fid", aVar.getGroupId());
            TiebaStatic.log(arVar);
        } else if (obj instanceof a.C0760a) {
            a((a.C0760a) obj, this.kcX.getPageActivity());
        }
    }

    private void a(a.C0760a c0760a, Context context) {
        if (c0760a != null) {
            J(c0760a.fid, System.currentTimeMillis());
            if (!StringUtils.isNull(c0760a.url)) {
                if (c0760a.url.startsWith("web:http")) {
                    c0760a.url = c0760a.url.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
                }
                if (c0760a.url.contains("?")) {
                    c0760a.url = String.format(Locale.US, "%s&broadcast_id=%d", c0760a.url, Long.valueOf(c0760a.kJm));
                } else {
                    c0760a.url = String.format(Locale.US, "%s?broadcast_id=%d", c0760a.url, Long.valueOf(c0760a.kJm));
                }
                if (c0760a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        context.startActivity(Intent.parseUri(c0760a.url, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (URLUtil.isHttpUrl(c0760a.url) || URLUtil.isHttpsUrl(c0760a.url) || c0760a.url.startsWith("flt://")) {
                    bf.bsV().b(this.kcX, new String[]{c0760a.url});
                } else {
                    Uri parse = Uri.parse(c0760a.url);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(context, parse.toString());
                    }
                }
                ar arVar = new ar(this.kBS ? "c13866" : "c13864");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.dR("fid", c0760a.fid);
                arVar.dR("tid", c0760a.tid == null ? "" : c0760a.tid);
                TiebaStatic.log(arVar);
            }
        }
    }

    private void hideNoDataView() {
        if (this.fIt != null && this.fIt.getVisibility() == 0) {
            this.fIt.setVisibility(8);
        }
    }

    private void showNoDataView() {
        if (this.fIt == null) {
            this.fIt = NoDataViewFactory.a(this.kcX.getPageActivity(), this.kCH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 454), NoDataViewFactory.d.pz(R.string.official_feed_no_data), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.fIt.setImgOption(aVar.bua());
        }
        if (this.fIt.getVisibility() != 0) {
            this.fIt.onChangeSkinType(this.kcX, TbadkApplication.getInst().getSkinType());
            this.fIt.setVisibility(0);
        }
    }

    public void J(final String str, final long j) {
        af.b(new ae<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: bLP */
            public Void doInBackground() {
                if (!StringUtils.isNull(str)) {
                    com.baidu.tieba.im.db.l.cVJ().H(Long.parseLong(str), j);
                    return null;
                }
                return null;
            }
        }, null);
    }
}
