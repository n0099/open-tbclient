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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.d;
import com.baidu.tieba.im.message.chat.a;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes20.dex */
public class OfficialBarFeedMsglistView extends com.baidu.adp.base.c<BaseActivity> implements d.c {
    private View.OnClickListener eFC;
    private NoDataView eQQ;
    private TbPageContext<BaseActivity> iIw;
    private boolean jho;
    private ImageView jia;
    private d jib;
    private RecyclerView jic;
    private TextView jie;
    private View jif;
    private View jig;
    private h jih;
    private String jii;
    private TextView jij;
    private FrameLayout jik;
    private BaseActivity<BaseActivity> mActivity;
    private View mBtnGroupInfo;
    private View mImgBack;
    private BdTypeListView mLisMsg;
    private NavigationBar mNavigationBar;
    private View rootView;

    public OfficialBarFeedMsglistView(BaseActivity<BaseActivity> baseActivity) {
        this(baseActivity, false);
    }

    public OfficialBarFeedMsglistView(BaseActivity<BaseActivity> baseActivity, boolean z) {
        super(baseActivity.getPageContext());
        this.mNavigationBar = null;
        this.mBtnGroupInfo = null;
        this.mImgBack = null;
        this.rootView = null;
        this.jig = null;
        this.jih = null;
        this.mLisMsg = null;
        this.eFC = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarFeedMsglistView.this.b(view, OfficialBarFeedMsglistView.this.iIw.getPageActivity());
            }
        };
        this.mActivity = baseActivity;
        this.jho = z;
        this.iIw = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        this.jig = baseActivity.findViewById(R.id.msg_root_view);
        baseActivity.showLoadingView(this.jig);
        b(baseActivity);
        c(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(BaseActivity baseActivity) {
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eFC);
        this.mImgBack.setOnClickListener(this.eFC);
        this.jii = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
        this.mNavigationBar.setCenterTextTitle(this.jho ? this.jii + baseActivity.getString(R.string.forum) : baseActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.showBottomLine();
        if (this.jho) {
            this.jij = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
            this.jij.setOnClickListener(this.eFC);
            return;
        }
        this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.eFC);
        this.jia = (ImageView) this.mBtnGroupInfo.findViewById(R.id.feed_header_icon);
        this.jia.setClickable(true);
        this.jia.setOnClickListener(this.eFC);
    }

    private void c(BaseActivity baseActivity) {
        this.jik = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        if (this.jho) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLisMsg.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.mLisMsg.setLayoutParams(layoutParams);
        }
        this.jih = new h(this.iIw, this.mLisMsg, this);
        this.jih.qn(this.jho);
        ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        if (!this.jho) {
            this.rootView = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
            this.jif = this.rootView.findViewById(R.id.official_bar_feed_header_view);
            this.jie = (TextView) this.rootView.findViewById(R.id.official_feed_recent);
            this.jic = (RecyclerView) this.rootView.findViewById(R.id.official_feed_recent_recyclerview);
            this.jic.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            this.jib = new d(baseActivity.getPageContext(), this);
            this.jic.setAdapter(this.jib);
            this.jic.setClipChildren(false);
            this.jic.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.1
                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    super.getItemOffsets(rect, view, recyclerView, state);
                    if (recyclerView.getChildLayoutPosition(view) == 0) {
                        rect.left = l.getDimens(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
                    }
                }
            }, 0);
        }
        this.mLisMsg.setAdapter((ListAdapter) this.jih);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.jih.setData(list);
        if (this.jho) {
            this.mLisMsg.setSelection(this.mLisMsg.getBottom());
        }
        this.mActivity.hideLoadingView(this.jig);
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
                aVar2.JX(aVar.cEv());
                aVar2.JY(aVar.getForumName());
                aVar2.setUnReadCount(aVar.getUnReadCount());
                aVar2.setUserType(aVar.getUserType());
                aVar2.setGroupId(Long.parseLong(aVar.getGid()));
                aVar2.fb(aVar.cCg());
                arrayList.add(aVar2);
            }
            this.jib.setData(arrayList);
            if (this.rootView != null && this.mLisMsg.getHeaderViewsCount() <= 0) {
                this.mLisMsg.addHeaderView(this.rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() > 0) {
            this.jih.b(longSparseArray);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.onBackBtnOnChangeSkin();
        ap.setViewTextColor(this.jia, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jie, R.color.cp_cont_b);
        ap.setViewTextColor(this.jij, R.color.cp_cont_b);
        ap.setBackgroundColor(this.jik, R.color.cp_bg_line_c);
        if (this.jif != null) {
            com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_bg_line_e).op(l.getDimens(this.iIw.getPageActivity(), R.dimen.tbds31)).oq(R.color.cp_shadow_a_alpha16).oo(4369).or(l.getDimens(this.iIw.getPageActivity(), R.dimen.tbds10)).os(0).ot(l.getDimens(this.iIw.getPageActivity(), R.dimen.tbds5)).aZ(this.jif);
        }
        if (this.eQQ != null) {
            this.eQQ.onChangeSkinType(this.iIw, i);
        }
        if (this.jia != null) {
            SvgManager.bjq().a(this.jia, R.drawable.icon_pure_more_administration44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jih != null) {
            this.jih.notifyDataSetChanged();
        }
    }

    public void b(View view, Activity activity) {
        if (view == this.jia) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mImgBack) {
            activity.finish();
        } else if (view == this.jij) {
            this.mContext.sendMessage(new CustomMessage<>((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.jii, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            if (activity.getIntent() != null) {
                aq aqVar = new aq("c13867");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dD("fid", activity.getIntent().getStringExtra("key_uid"));
                TiebaStatic.log(aqVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.officialBar.d.c
    public void a(View view, Object obj, int i, long j) {
        if (obj instanceof d.a) {
            d.a aVar = (d.a) obj;
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.iIw.getPageActivity(), String.valueOf(aVar.getGroupId()), aVar.cCf());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleForumBroadcastFeedActivityConfig));
            aq aqVar = new aq("c13862");
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.u("fid", aVar.getGroupId());
            TiebaStatic.log(aqVar);
        } else if (obj instanceof a.C0719a) {
            a((a.C0719a) obj, this.iIw.getPageActivity());
        }
    }

    private void a(a.C0719a c0719a, Context context) {
        if (c0719a != null) {
            F(c0719a.fid, System.currentTimeMillis());
            if (!StringUtils.isNull(c0719a.url)) {
                if (c0719a.url.startsWith("web:http")) {
                    c0719a.url = c0719a.url.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
                }
                if (c0719a.url.contains("?")) {
                    c0719a.url = String.format(Locale.US, "%s&broadcast_id=%d", c0719a.url, Long.valueOf(c0719a.jwo));
                } else {
                    c0719a.url = String.format(Locale.US, "%s?broadcast_id=%d", c0719a.url, Long.valueOf(c0719a.jwo));
                }
                if (c0719a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        context.startActivity(Intent.parseUri(c0719a.url, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (URLUtil.isHttpUrl(c0719a.url) || URLUtil.isHttpsUrl(c0719a.url) || c0719a.url.startsWith("flt://")) {
                    be.bju().b(this.iIw, new String[]{c0719a.url});
                } else {
                    Uri parse = Uri.parse(c0719a.url);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(context, parse.toString());
                    }
                }
                aq aqVar = new aq(this.jho ? "c13866" : "c13864");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dD("fid", c0719a.fid);
                aqVar.dD("tid", c0719a.tid == null ? "" : c0719a.tid);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void hideNoDataView() {
        if (this.eQQ != null && this.eQQ.getVisibility() == 0) {
            this.eQQ.setVisibility(8);
        }
    }

    private void showNoDataView() {
        if (this.eQQ == null) {
            this.eQQ = NoDataViewFactory.a(this.iIw.getPageActivity(), this.jig, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 454), NoDataViewFactory.d.oK(R.string.official_feed_no_data), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.eQQ.setImgOption(aVar.bks());
        }
        if (this.eQQ.getVisibility() != 0) {
            this.eQQ.onChangeSkinType(this.iIw, TbadkApplication.getInst().getSkinType());
            this.eQQ.setVisibility(0);
        }
    }

    public void F(final String str, final long j) {
        ad.b(new ac<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bBB */
            public Void doInBackground() {
                if (!StringUtils.isNull(str)) {
                    com.baidu.tieba.im.db.l.cEn().C(Long.parseLong(str), j);
                    return null;
                }
                return null;
            }
        }, null);
    }
}
