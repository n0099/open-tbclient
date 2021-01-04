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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
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
    private NoDataView fKO;
    private RecyclerView hmG;
    private TbPageContext<OfficialBarFeedActivity> kab;
    private boolean kyq;
    private ImageView kzb;
    private OfficialBarFeedMsglistAdapter kzc;
    private TextView kzd;
    private View kze;
    private ViewGroup kzf;
    private g kzg;
    private String kzh;
    private TextView kzi;
    private FrameLayout kzj;
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
        this.kzf = null;
        this.kzg = null;
        this.mLisMsg = null;
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarFeedMsglistView.this.b(view, OfficialBarFeedMsglistView.this.kab.getPageActivity());
            }
        };
        this.mActivity = baseActivity;
        this.kyq = z;
        this.kab = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        this.kzf = (ViewGroup) baseActivity.findViewById(R.id.msg_root_view);
        baseActivity.showLoadingView(this.kzf);
        b(baseActivity);
        c(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onClickListener);
        this.mImgBack.setOnClickListener(this.onClickListener);
        this.kzh = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
        this.mNavigationBar.setCenterTextTitle(this.kyq ? this.kzh + baseActivity.getString(R.string.forum) : baseActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.showBottomLine();
        if (this.kyq) {
            this.kzi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
            this.kzi.setOnClickListener(this.onClickListener);
            return;
        }
        this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.onClickListener);
        this.kzb = (ImageView) this.mBtnGroupInfo.findViewById(R.id.feed_header_icon);
        this.kzb.setClickable(true);
        this.kzb.setOnClickListener(this.onClickListener);
    }

    private void c(BaseActivity baseActivity) {
        this.kzj = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        if (this.kyq) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLisMsg.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.mLisMsg.setLayoutParams(layoutParams);
        }
        this.kzg = new g(this.kab, this.mLisMsg, this);
        this.kzg.sC(this.kyq);
        ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        if (!this.kyq) {
            this.rootView = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
            this.kze = this.rootView.findViewById(R.id.official_bar_feed_header_view);
            this.kzd = (TextView) this.rootView.findViewById(R.id.official_feed_recent);
            this.hmG = (RecyclerView) this.rootView.findViewById(R.id.official_feed_recent_recyclerview);
            this.hmG.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            this.kzc = new OfficialBarFeedMsglistAdapter(baseActivity.getPageContext(), this);
            this.hmG.setAdapter(this.kzc);
            this.hmG.setClipChildren(false);
            this.hmG.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    super.getItemOffsets(rect, view, recyclerView, state);
                    if (recyclerView.getChildLayoutPosition(view) == 0) {
                        rect.left = l.getDimens(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
                    }
                }
            }, 0);
        }
        this.mLisMsg.setAdapter((ListAdapter) this.kzg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.kzg.setData(list);
        if (this.kyq) {
            this.mLisMsg.setSelection(this.mLisMsg.getBottom());
        }
        this.mActivity.hideLoadingView(this.kzf);
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
                aVar2.MM(aVar.cXK());
                aVar2.MN(aVar.getForumName());
                aVar2.setUnReadCount(aVar.getUnReadCount());
                aVar2.setUserType(aVar.getUserType());
                aVar2.setGroupId(Long.parseLong(aVar.getGid()));
                aVar2.gK(aVar.cWL());
                arrayList.add(aVar2);
            }
            this.kzc.setData(arrayList);
            if (this.rootView != null && this.mLisMsg.getHeaderViewsCount() <= 0) {
                this.mLisMsg.addHeaderView(this.rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() > 0) {
            this.kzg.b(longSparseArray);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.onBackBtnOnChangeSkin();
        ao.setViewTextColor(this.kzb, R.color.CAM_X0302, 1);
        ao.setViewTextColor(this.kzd, R.color.CAM_X0105);
        ao.setViewTextColor(this.kzi, R.color.CAM_X0105);
        ao.setBackgroundColor(this.kzj, R.color.CAM_X0204);
        if (this.kze != null) {
            com.baidu.tbadk.core.util.f.a.bwT().qI(R.color.CAM_X0205).qD(l.getDimens(this.kab.getPageActivity(), R.dimen.tbds31)).qE(R.color.CAM_X0804).qC(4369).qF(l.getDimens(this.kab.getPageActivity(), R.dimen.tbds10)).qG(0).qH(l.getDimens(this.kab.getPageActivity(), R.dimen.tbds5)).bz(this.kze);
        }
        if (this.fKO != null) {
            this.fKO.onChangeSkinType(this.kab, i);
        }
        if (this.kzb != null) {
            SvgManager.bwq().a(this.kzb, R.drawable.icon_pure_more_administration44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kzg != null) {
            this.kzg.notifyDataSetChanged();
        }
    }

    public void b(View view, Activity activity) {
        if (view == this.kzb) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mImgBack) {
            activity.finish();
        } else if (view == this.kzi) {
            this.mContext.sendMessage(new CustomMessage<>((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.kzh, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            if (activity.getIntent() != null) {
                aq aqVar = new aq("c13867");
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dX("fid", activity.getIntent().getStringExtra("key_uid"));
                TiebaStatic.log(aqVar);
            }
        }
    }

    public void showTipToast(boolean z, String str) {
        new BdTopToast(this.mActivity).yW(z).UY(str).aR(this.kzf);
    }

    @Override // com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter.c
    public void a(View view, Object obj, int i, long j) {
        if (obj instanceof OfficialBarFeedMsglistAdapter.a) {
            OfficialBarFeedMsglistAdapter.a aVar = (OfficialBarFeedMsglistAdapter.a) obj;
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.kab.getPageActivity(), String.valueOf(aVar.getGroupId()), aVar.cRb());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleForumBroadcastFeedActivityConfig));
            aq aqVar = new aq("c13862");
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.w("fid", aVar.getGroupId());
            TiebaStatic.log(aqVar);
        } else if (obj instanceof a.C0766a) {
            a((a.C0766a) obj, this.kab.getPageActivity());
        }
    }

    private void a(a.C0766a c0766a, Context context) {
        if (c0766a != null) {
            K(c0766a.fid, System.currentTimeMillis());
            if (!StringUtils.isNull(c0766a.url)) {
                if (c0766a.url.startsWith("web:http")) {
                    c0766a.url = c0766a.url.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
                }
                if (c0766a.url.contains("?")) {
                    c0766a.url = String.format(Locale.US, "%s&broadcast_id=%d", c0766a.url, Long.valueOf(c0766a.kFM));
                } else {
                    c0766a.url = String.format(Locale.US, "%s?broadcast_id=%d", c0766a.url, Long.valueOf(c0766a.kFM));
                }
                if (c0766a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        context.startActivity(Intent.parseUri(c0766a.url, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (URLUtil.isHttpUrl(c0766a.url) || URLUtil.isHttpsUrl(c0766a.url) || c0766a.url.startsWith("flt://")) {
                    be.bwu().b(this.kab, new String[]{c0766a.url});
                } else {
                    Uri parse = Uri.parse(c0766a.url);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(context, parse.toString());
                    }
                }
                aq aqVar = new aq(this.kyq ? "c13866" : "c13864");
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dX("fid", c0766a.fid);
                aqVar.dX("tid", c0766a.tid == null ? "" : c0766a.tid);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void hideNoDataView() {
        if (this.fKO != null && this.fKO.getVisibility() == 0) {
            this.fKO.setVisibility(8);
        }
    }

    private void showNoDataView() {
        if (this.fKO == null) {
            this.fKO = NoDataViewFactory.a(this.kab.getPageActivity(), this.kzf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 454), NoDataViewFactory.d.ra(R.string.official_feed_no_data), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.fKO.setImgOption(aVar.bxz());
        }
        if (this.fKO.getVisibility() != 0) {
            this.fKO.onChangeSkinType(this.kab, TbadkApplication.getInst().getSkinType());
            this.fKO.setVisibility(0);
        }
    }

    public void K(final String str, final long j) {
        ac.b(new ab<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bPm */
            public Void doInBackground() {
                if (!StringUtils.isNull(str)) {
                    com.baidu.tieba.im.db.l.cXC().D(Long.parseLong(str), j);
                    return null;
                }
                return null;
            }
        }, null);
    }
}
