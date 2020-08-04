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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
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
    private NoDataView eGk;
    private View.OnClickListener eve;
    private boolean iSr;
    private ImageView iTd;
    private d iTe;
    private RecyclerView iTf;
    private TextView iTg;
    private View iTh;
    private View iTi;
    private h iTj;
    private String iTk;
    private TextView iTl;
    private FrameLayout iTm;
    private TbPageContext<BaseActivity> iuh;
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
        this.iTi = null;
        this.iTj = null;
        this.mLisMsg = null;
        this.eve = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarFeedMsglistView.this.b(view, OfficialBarFeedMsglistView.this.iuh.getPageActivity());
            }
        };
        this.mActivity = baseActivity;
        this.iSr = z;
        this.iuh = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        this.iTi = baseActivity.findViewById(R.id.msg_root_view);
        baseActivity.showLoadingView(this.iTi);
        b(baseActivity);
        c(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void b(BaseActivity baseActivity) {
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eve);
        this.mImgBack.setOnClickListener(this.eve);
        this.iTk = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
        this.mNavigationBar.setCenterTextTitle(this.iSr ? this.iTk + baseActivity.getString(R.string.forum) : baseActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.showBottomLine();
        if (this.iSr) {
            this.iTl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
            this.iTl.setOnClickListener(this.eve);
            return;
        }
        this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.eve);
        this.iTd = (ImageView) this.mBtnGroupInfo.findViewById(R.id.feed_header_icon);
        this.iTd.setClickable(true);
        this.iTd.setOnClickListener(this.eve);
    }

    private void c(BaseActivity baseActivity) {
        this.iTm = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        if (this.iSr) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLisMsg.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.mLisMsg.setLayoutParams(layoutParams);
        }
        this.iTj = new h(this.iuh, this.mLisMsg, this);
        this.iTj.pH(this.iSr);
        ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        if (!this.iSr) {
            this.rootView = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
            this.iTh = this.rootView.findViewById(R.id.official_bar_feed_header_view);
            this.iTg = (TextView) this.rootView.findViewById(R.id.official_feed_recent);
            this.iTf = (RecyclerView) this.rootView.findViewById(R.id.official_feed_recent_recyclerview);
            this.iTf.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            this.iTe = new d(baseActivity.getPageContext(), this);
            this.iTf.setAdapter(this.iTe);
            this.iTf.setClipChildren(false);
            this.iTf.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.1
                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    super.getItemOffsets(rect, view, recyclerView, state);
                    if (recyclerView.getChildLayoutPosition(view) == 0) {
                        rect.left = l.getDimens(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
                    }
                }
            }, 0);
        }
        this.mLisMsg.setAdapter((ListAdapter) this.iTj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.iTj.setData(list);
        if (this.iSr) {
            this.mLisMsg.setSelection(this.mLisMsg.getBottom());
        }
        this.mActivity.hideLoadingView(this.iTi);
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
                aVar2.Hf(aVar.ctE());
                aVar2.Hg(aVar.getForumName());
                aVar2.setUnReadCount(aVar.getUnReadCount());
                aVar2.setUserType(aVar.getUserType());
                aVar2.setGroupId(Long.parseLong(aVar.getGid()));
                aVar2.eP(aVar.cro());
                arrayList.add(aVar2);
            }
            this.iTe.setData(arrayList);
            if (this.rootView != null && this.mLisMsg.getHeaderViewsCount() <= 0) {
                this.mLisMsg.addHeaderView(this.rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() > 0) {
            this.iTj.b(longSparseArray);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.onBackBtnOnChangeSkin();
        ao.setViewTextColor(this.iTd, R.color.cp_link_tip_a, 1);
        ao.setViewTextColor(this.iTg, R.color.cp_cont_b);
        ao.setViewTextColor(this.iTl, R.color.cp_cont_b);
        ao.setBackgroundColor(this.iTm, R.color.cp_bg_line_c);
        if (this.iTh != null) {
            com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_bg_line_e).ml(l.getDimens(this.iuh.getPageActivity(), R.dimen.tbds31)).mm(R.color.cp_shadow_a_alpha16).mk(4369).mn(l.getDimens(this.iuh.getPageActivity(), R.dimen.tbds10)).mo(0).mp(l.getDimens(this.iuh.getPageActivity(), R.dimen.tbds5)).aX(this.iTh);
        }
        if (this.eGk != null) {
            this.eGk.onChangeSkinType(this.iuh, i);
        }
        if (this.iTd != null) {
            SvgManager.baR().a(this.iTd, R.drawable.icon_pure_more_administration44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iTj != null) {
            this.iTj.notifyDataSetChanged();
        }
    }

    public void b(View view, Activity activity) {
        if (view == this.iTd) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mImgBack) {
            activity.finish();
        } else if (view == this.iTl) {
            this.mContext.sendMessage(new CustomMessage<>((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.iTk, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            if (activity.getIntent() != null) {
                ap apVar = new ap("c13867");
                if (com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
                    apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
                }
                apVar.dn("fid", activity.getIntent().getStringExtra("key_uid"));
                TiebaStatic.log(apVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.officialBar.d.c
    public void a(View view, Object obj, int i, long j) {
        if (obj instanceof d.a) {
            d.a aVar = (d.a) obj;
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.iuh.getPageActivity(), String.valueOf(aVar.getGroupId()), aVar.crn());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleForumBroadcastFeedActivityConfig));
            ap apVar = new ap("c13862");
            if (com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
                apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
            }
            apVar.t("fid", aVar.getGroupId());
            TiebaStatic.log(apVar);
        } else if (obj instanceof a.C0667a) {
            a((a.C0667a) obj, this.iuh.getPageActivity());
        }
    }

    private void a(a.C0667a c0667a, Context context) {
        if (c0667a != null) {
            E(c0667a.fid, System.currentTimeMillis());
            if (!StringUtils.isNull(c0667a.url)) {
                if (c0667a.url.startsWith("web:http")) {
                    c0667a.url = c0667a.url.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
                }
                if (c0667a.url.contains("?")) {
                    c0667a.url = String.format(Locale.US, "%s&broadcast_id=%d", c0667a.url, Long.valueOf(c0667a.jho));
                } else {
                    c0667a.url = String.format(Locale.US, "%s?broadcast_id=%d", c0667a.url, Long.valueOf(c0667a.jho));
                }
                if (c0667a.url.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    try {
                        context.startActivity(Intent.parseUri(c0667a.url, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (URLUtil.isHttpUrl(c0667a.url) || URLUtil.isHttpsUrl(c0667a.url) || c0667a.url.startsWith("flt://")) {
                    bd.baV().b(this.iuh, new String[]{c0667a.url});
                } else {
                    Uri parse = Uri.parse(c0667a.url);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(context, parse.toString());
                    }
                }
                ap apVar = new ap(this.iSr ? "c13866" : "c13864");
                if (com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
                    apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
                }
                apVar.dn("fid", c0667a.fid);
                apVar.dn("tid", c0667a.tid == null ? "" : c0667a.tid);
                TiebaStatic.log(apVar);
            }
        }
    }

    private void hideNoDataView() {
        if (this.eGk != null && this.eGk.getVisibility() == 0) {
            this.eGk.setVisibility(8);
        }
    }

    private void showNoDataView() {
        if (this.eGk == null) {
            this.eGk = NoDataViewFactory.a(this.iuh.getPageActivity(), this.iTi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 454), NoDataViewFactory.d.mF(R.string.official_feed_no_data), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.eGk.setImgOption(aVar.bbW());
        }
        if (this.eGk.getVisibility() != 0) {
            this.eGk.onChangeSkinType(this.iuh, TbadkApplication.getInst().getSkinType());
            this.eGk.setVisibility(0);
        }
    }

    public void E(final String str, final long j) {
        ad.b(new ac<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bsE */
            public Void doInBackground() {
                if (!StringUtils.isNull(str)) {
                    com.baidu.tieba.im.db.l.ctw().C(Long.parseLong(str), j);
                    return null;
                }
                return null;
            }
        }, null);
    }
}
