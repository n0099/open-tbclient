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
    private View.OnClickListener fcr;
    private NoDataView fos;
    private boolean jRw;
    private ImageView jSh;
    private d jSi;
    private RecyclerView jSj;
    private TextView jSk;
    private View jSl;
    private View jSm;
    private h jSn;
    private String jSo;
    private TextView jSp;
    private FrameLayout jSq;
    private TbPageContext<OfficialBarFeedActivity> jsv;
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
        this.jSm = null;
        this.jSn = null;
        this.mLisMsg = null;
        this.fcr = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarFeedMsglistView.this.b(view, OfficialBarFeedMsglistView.this.jsv.getPageActivity());
            }
        };
        this.mActivity = baseActivity;
        this.jRw = z;
        this.jsv = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        this.jSm = baseActivity.findViewById(R.id.msg_root_view);
        baseActivity.showLoadingView(this.jSm);
        b(baseActivity);
        c(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fcr);
        this.mImgBack.setOnClickListener(this.fcr);
        this.jSo = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
        this.mNavigationBar.setCenterTextTitle(this.jRw ? this.jSo + baseActivity.getString(R.string.forum) : baseActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.showBottomLine();
        if (this.jRw) {
            this.jSp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
            this.jSp.setOnClickListener(this.fcr);
            return;
        }
        this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.fcr);
        this.jSh = (ImageView) this.mBtnGroupInfo.findViewById(R.id.feed_header_icon);
        this.jSh.setClickable(true);
        this.jSh.setOnClickListener(this.fcr);
    }

    private void c(BaseActivity baseActivity) {
        this.jSq = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        if (this.jRw) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLisMsg.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.mLisMsg.setLayoutParams(layoutParams);
        }
        this.jSn = new h(this.jsv, this.mLisMsg, this);
        this.jSn.rv(this.jRw);
        ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        if (!this.jRw) {
            this.rootView = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
            this.jSl = this.rootView.findViewById(R.id.official_bar_feed_header_view);
            this.jSk = (TextView) this.rootView.findViewById(R.id.official_feed_recent);
            this.jSj = (RecyclerView) this.rootView.findViewById(R.id.official_feed_recent_recyclerview);
            this.jSj.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            this.jSi = new d(baseActivity.getPageContext(), this);
            this.jSj.setAdapter(this.jSi);
            this.jSj.setClipChildren(false);
            this.jSj.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.1
                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    super.getItemOffsets(rect, view, recyclerView, state);
                    if (recyclerView.getChildLayoutPosition(view) == 0) {
                        rect.left = l.getDimens(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
                    }
                }
            }, 0);
        }
        this.mLisMsg.setAdapter((ListAdapter) this.jSn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.jSn.setData(list);
        if (this.jRw) {
            this.mLisMsg.setSelection(this.mLisMsg.getBottom());
        }
        this.mActivity.hideLoadingView(this.jSm);
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
                aVar2.LN(aVar.cOS());
                aVar2.LO(aVar.getForumName());
                aVar2.setUnReadCount(aVar.getUnReadCount());
                aVar2.setUserType(aVar.getUserType());
                aVar2.setGroupId(Long.parseLong(aVar.getGid()));
                aVar2.fI(aVar.cMD());
                arrayList.add(aVar2);
            }
            this.jSi.setData(arrayList);
            if (this.rootView != null && this.mLisMsg.getHeaderViewsCount() <= 0) {
                this.mLisMsg.addHeaderView(this.rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() > 0) {
            this.jSn.b(longSparseArray);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.onBackBtnOnChangeSkin();
        ap.setViewTextColor(this.jSh, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jSk, R.color.cp_cont_b);
        ap.setViewTextColor(this.jSp, R.color.cp_cont_b);
        ap.setBackgroundColor(this.jSq, R.color.cp_bg_line_c);
        if (this.jSl != null) {
            com.baidu.tbadk.core.util.e.a.bpn().pq(R.color.cp_bg_line_e).pk(l.getDimens(this.jsv.getPageActivity(), R.dimen.tbds31)).pl(R.color.cp_shadow_a_alpha16).pj(4369).pm(l.getDimens(this.jsv.getPageActivity(), R.dimen.tbds10)).po(0).pp(l.getDimens(this.jsv.getPageActivity(), R.dimen.tbds5)).bg(this.jSl);
        }
        if (this.fos != null) {
            this.fos.onChangeSkinType(this.jsv, i);
        }
        if (this.jSh != null) {
            SvgManager.boN().a(this.jSh, R.drawable.icon_pure_more_administration44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jSn != null) {
            this.jSn.notifyDataSetChanged();
        }
    }

    public void b(View view, Activity activity) {
        if (view == this.jSh) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mImgBack) {
            activity.finish();
        } else if (view == this.jSp) {
            this.mContext.sendMessage(new CustomMessage<>((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.jSo, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
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
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.jsv.getPageActivity(), String.valueOf(aVar.getGroupId()), aVar.cGz());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleForumBroadcastFeedActivityConfig));
            aq aqVar = new aq("c13862");
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.w("fid", aVar.getGroupId());
            TiebaStatic.log(aqVar);
        } else if (obj instanceof a.C0750a) {
            a((a.C0750a) obj, this.jsv.getPageActivity());
        }
    }

    private void a(a.C0750a c0750a, Context context) {
        if (c0750a != null) {
            J(c0750a.fid, System.currentTimeMillis());
            if (!StringUtils.isNull(c0750a.url)) {
                if (c0750a.url.startsWith("web:http")) {
                    c0750a.url = c0750a.url.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
                }
                if (c0750a.url.contains("?")) {
                    c0750a.url = String.format(Locale.US, "%s&broadcast_id=%d", c0750a.url, Long.valueOf(c0750a.kgt));
                } else {
                    c0750a.url = String.format(Locale.US, "%s?broadcast_id=%d", c0750a.url, Long.valueOf(c0750a.kgt));
                }
                if (c0750a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        context.startActivity(Intent.parseUri(c0750a.url, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (URLUtil.isHttpUrl(c0750a.url) || URLUtil.isHttpsUrl(c0750a.url) || c0750a.url.startsWith("flt://")) {
                    be.boR().b(this.jsv, new String[]{c0750a.url});
                } else {
                    Uri parse = Uri.parse(c0750a.url);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(context, parse.toString());
                    }
                }
                aq aqVar = new aq(this.jRw ? "c13866" : "c13864");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.dR("fid", c0750a.fid);
                aqVar.dR("tid", c0750a.tid == null ? "" : c0750a.tid);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void hideNoDataView() {
        if (this.fos != null && this.fos.getVisibility() == 0) {
            this.fos.setVisibility(8);
        }
    }

    private void showNoDataView() {
        if (this.fos == null) {
            this.fos = NoDataViewFactory.a(this.jsv.getPageActivity(), this.jSm, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 454), NoDataViewFactory.d.pG(R.string.official_feed_no_data), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.fos.setImgOption(aVar.bpQ());
        }
        if (this.fos.getVisibility() != 0) {
            this.fos.onChangeSkinType(this.jsv, TbadkApplication.getInst().getSkinType());
            this.fos.setVisibility(0);
        }
    }

    public void J(final String str, final long j) {
        ae.b(new ad<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bHt */
            public Void doInBackground() {
                if (!StringUtils.isNull(str)) {
                    com.baidu.tieba.im.db.l.cOK().A(Long.parseLong(str), j);
                    return null;
                }
                return null;
            }
        }, null);
    }
}
