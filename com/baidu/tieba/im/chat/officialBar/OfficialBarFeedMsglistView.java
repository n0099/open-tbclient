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
/* loaded from: classes26.dex */
public class OfficialBarFeedMsglistView extends com.baidu.adp.base.c<OfficialBarFeedActivity> implements d.c {
    private NoDataView fBi;
    private View.OnClickListener foP;
    private RecyclerView haU;
    private TbPageContext<OfficialBarFeedActivity> jMN;
    private boolean klK;
    private h kmA;
    private String kmB;
    private TextView kmC;
    private FrameLayout kmD;
    private ImageView kmv;
    private d kmw;
    private TextView kmx;
    private View kmy;
    private View kmz;
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
        this.kmz = null;
        this.kmA = null;
        this.mLisMsg = null;
        this.foP = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarFeedMsglistView.this.b(view, OfficialBarFeedMsglistView.this.jMN.getPageActivity());
            }
        };
        this.mActivity = baseActivity;
        this.klK = z;
        this.jMN = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        this.kmz = baseActivity.findViewById(R.id.msg_root_view);
        baseActivity.showLoadingView(this.kmz);
        b(baseActivity);
        c(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.foP);
        this.mImgBack.setOnClickListener(this.foP);
        this.kmB = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
        this.mNavigationBar.setCenterTextTitle(this.klK ? this.kmB + baseActivity.getString(R.string.forum) : baseActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.showBottomLine();
        if (this.klK) {
            this.kmC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
            this.kmC.setOnClickListener(this.foP);
            return;
        }
        this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.foP);
        this.kmv = (ImageView) this.mBtnGroupInfo.findViewById(R.id.feed_header_icon);
        this.kmv.setClickable(true);
        this.kmv.setOnClickListener(this.foP);
    }

    private void c(BaseActivity baseActivity) {
        this.kmD = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        if (this.klK) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLisMsg.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.mLisMsg.setLayoutParams(layoutParams);
        }
        this.kmA = new h(this.jMN, this.mLisMsg, this);
        this.kmA.sj(this.klK);
        ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        if (!this.klK) {
            this.rootView = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
            this.kmy = this.rootView.findViewById(R.id.official_bar_feed_header_view);
            this.kmx = (TextView) this.rootView.findViewById(R.id.official_feed_recent);
            this.haU = (RecyclerView) this.rootView.findViewById(R.id.official_feed_recent_recyclerview);
            this.haU.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            this.kmw = new d(baseActivity.getPageContext(), this);
            this.haU.setAdapter(this.kmw);
            this.haU.setClipChildren(false);
            this.haU.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.1
                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    super.getItemOffsets(rect, view, recyclerView, state);
                    if (recyclerView.getChildLayoutPosition(view) == 0) {
                        rect.left = l.getDimens(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
                    }
                }
            }, 0);
        }
        this.mLisMsg.setAdapter((ListAdapter) this.kmA);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.kmA.setData(list);
        if (this.klK) {
            this.mLisMsg.setSelection(this.mLisMsg.getBottom());
        }
        this.mActivity.hideLoadingView(this.kmz);
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
                aVar2.MM(aVar.cWo());
                aVar2.MN(aVar.getForumName());
                aVar2.setUnReadCount(aVar.getUnReadCount());
                aVar2.setUserType(aVar.getUserType());
                aVar2.setGroupId(Long.parseLong(aVar.getGid()));
                aVar2.gM(aVar.cTZ());
                arrayList.add(aVar2);
            }
            this.kmw.setData(arrayList);
            if (this.rootView != null && this.mLisMsg.getHeaderViewsCount() <= 0) {
                this.mLisMsg.addHeaderView(this.rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() > 0) {
            this.kmA.b(longSparseArray);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.onBackBtnOnChangeSkin();
        ap.setViewTextColor(this.kmv, R.color.CAM_X0302, 1);
        ap.setViewTextColor(this.kmx, R.color.CAM_X0105);
        ap.setViewTextColor(this.kmC, R.color.CAM_X0105);
        ap.setBackgroundColor(this.kmD, R.color.CAM_X0204);
        if (this.kmy != null) {
            com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0205).qs(l.getDimens(this.jMN.getPageActivity(), R.dimen.tbds31)).qt(R.color.CAM_X0804).qr(4369).qu(l.getDimens(this.jMN.getPageActivity(), R.dimen.tbds10)).qv(0).qw(l.getDimens(this.jMN.getPageActivity(), R.dimen.tbds5)).bq(this.kmy);
        }
        if (this.fBi != null) {
            this.fBi.onChangeSkinType(this.jMN, i);
        }
        if (this.kmv != null) {
            SvgManager.btW().a(this.kmv, R.drawable.icon_pure_more_administration44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kmA != null) {
            this.kmA.notifyDataSetChanged();
        }
    }

    public void b(View view, Activity activity) {
        if (view == this.kmv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mImgBack) {
            activity.finish();
        } else if (view == this.kmC) {
            this.mContext.sendMessage(new CustomMessage<>((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.kmB, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            if (activity.getIntent() != null) {
                ar arVar = new ar("c13867");
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.dY("fid", activity.getIntent().getStringExtra("key_uid"));
                TiebaStatic.log(arVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.officialBar.d.c
    public void a(View view, Object obj, int i, long j) {
        if (obj instanceof d.a) {
            d.a aVar = (d.a) obj;
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.jMN.getPageActivity(), String.valueOf(aVar.getGroupId()), aVar.cNV());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleForumBroadcastFeedActivityConfig));
            ar arVar = new ar("c13862");
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.w("fid", aVar.getGroupId());
            TiebaStatic.log(arVar);
        } else if (obj instanceof a.C0782a) {
            a((a.C0782a) obj, this.jMN.getPageActivity());
        }
    }

    private void a(a.C0782a c0782a, Context context) {
        if (c0782a != null) {
            J(c0782a.fid, System.currentTimeMillis());
            if (!StringUtils.isNull(c0782a.url)) {
                if (c0782a.url.startsWith("web:http")) {
                    c0782a.url = c0782a.url.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
                }
                if (c0782a.url.contains("?")) {
                    c0782a.url = String.format(Locale.US, "%s&broadcast_id=%d", c0782a.url, Long.valueOf(c0782a.kAy));
                } else {
                    c0782a.url = String.format(Locale.US, "%s?broadcast_id=%d", c0782a.url, Long.valueOf(c0782a.kAy));
                }
                if (c0782a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        context.startActivity(Intent.parseUri(c0782a.url, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (URLUtil.isHttpUrl(c0782a.url) || URLUtil.isHttpsUrl(c0782a.url) || c0782a.url.startsWith("flt://")) {
                    bf.bua().b(this.jMN, new String[]{c0782a.url});
                } else {
                    Uri parse = Uri.parse(c0782a.url);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(context, parse.toString());
                    }
                }
                ar arVar = new ar(this.klK ? "c13866" : "c13864");
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.dY("fid", c0782a.fid);
                arVar.dY("tid", c0782a.tid == null ? "" : c0782a.tid);
                TiebaStatic.log(arVar);
            }
        }
    }

    private void hideNoDataView() {
        if (this.fBi != null && this.fBi.getVisibility() == 0) {
            this.fBi.setVisibility(8);
        }
    }

    private void showNoDataView() {
        if (this.fBi == null) {
            this.fBi = NoDataViewFactory.a(this.jMN.getPageActivity(), this.kmz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 454), NoDataViewFactory.d.qP(R.string.official_feed_no_data), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.fBi.setImgOption(aVar.bve());
        }
        if (this.fBi.getVisibility() != 0) {
            this.fBi.onChangeSkinType(this.jMN, TbadkApplication.getInst().getSkinType());
            this.fBi.setVisibility(0);
        }
    }

    public void J(final String str, final long j) {
        ad.b(new ac<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bMU */
            public Void doInBackground() {
                if (!StringUtils.isNull(str)) {
                    com.baidu.tieba.im.db.l.cWg().A(Long.parseLong(str), j);
                    return null;
                }
                return null;
            }
        }, null);
    }
}
