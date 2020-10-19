package com.baidu.tieba.im.forum.broadcast.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.data.b;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidubce.util.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes26.dex */
public class a {
    private PbListView fTv;
    private boolean hasMore;
    private final com.baidu.tieba.im.forum.broadcast.a jKO;
    private BdRecyclerView jKT;
    private com.baidu.tieba.im.forum.broadcast.a.a jKU;
    private ImageView jKW;
    private LinearLayout jKX;
    private TextView jKY;
    private TextView jKZ;
    private String jLa;
    private String jLb;
    private RelativeLayout jLc;
    private boolean jLd;
    private ScreenTopToast jLe;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> jKV = new ArrayList();
    private BdListView.e gnC = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.jKT != null) {
                a.this.jKT.stopScroll();
            }
            a.this.SI();
        }
    };
    private f<b> jLf = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new aq("c13875").u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("fid", a.this.jLa).u("tid", bVar.cLW() != null ? bVar.cLW().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!l.isFastDoubleClick()) {
                        if (a.this.jLd) {
                            a.this.cMa();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cLT() + "", a.this.jLb, a.this.jLa, bVar.cLW() != null ? bVar.cLW().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cLW() == null || bVar.cLW().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).xK(false).TD(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aH((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cLW().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener jLg = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13873").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cMb();
        }
    };
    private View.OnClickListener jLh = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.ac(a.this.jLa, a.this.jLb, "2");
                oVar.start();
                TiebaStatic.log(new aq("c13874").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener jLi = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13874").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!l.isFastDoubleClick()) {
                a.this.cMa();
            }
        }
    };
    private View.OnClickListener hXQ = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jKT != null) {
                a.this.jKT.stopScroll();
            }
            if (a.this.fTv != null && a.this.jKO != null && j.isNetWorkAvailable()) {
                a.this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fTv.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fTv.showLoading();
                    a.this.jKO.bJG();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jKO = aVar;
        this.jLa = str;
        this.jLb = str2;
        h(view, str3);
        TiebaStatic.log(new aq("c13872").u("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cMa() {
        if (this.jLe == null || !this.jLe.isShow()) {
            this.jLe = new ScreenTopToast(this.mPageContext.getPageActivity()).TH(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).TJ(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jLa);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.jLe.aH((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.jLc = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jKW = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jKX = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.jKX.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.jKW, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.jKZ = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.jKW.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jKZ.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jKW.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.jKZ.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.jKW.setLayoutParams(layoutParams2);
        this.jKW.setVisibility(0);
        this.jKW.setOnClickListener(this.jLg);
        this.jKT = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.jKT.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.jKT.setOverScrollMode(2);
        this.jKT.setOnSrollToBottomListener(this.gnC);
        ap.setBackgroundColor(this.jKT, R.color.cp_bg_line_c);
        this.jKU = new com.baidu.tieba.im.forum.broadcast.a.a(this.mPageContext.getPageActivity());
        this.jKU.a(this.jLf);
        this.jKT.setAdapter(this.jKU);
        this.fTv = new PbListView(this.mPageContext.getPageActivity());
        this.fTv.getView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fTv.setHeight(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.boa();
        this.fTv.setOnClickListener(this.hXQ);
        if ("broadcast_publish_success".equals(str)) {
            cMc();
            int size = com.baidu.adp.base.a.lg().getSize();
            Activity X = com.baidu.adp.base.a.lg().X(size - 2);
            Activity X2 = com.baidu.adp.base.a.lg().X(size - 3);
            if (X != null && X2 != null && "FlutterPageActivity".equals(X.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(X2.getClass().getSimpleName())) {
                X2.finish();
            }
        }
    }

    public void SI() {
        if (this.fTv != null && this.jKO != null) {
            if (j.isNetWorkAvailable()) {
                this.jKT.setNextPage(this.fTv);
                this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fTv.setOnClickListener(null);
                if (this.hasMore) {
                    this.fTv.showLoading();
                    this.jKO.bJG();
                    return;
                }
                this.fTv.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.fTv.endLoadData();
                return;
            }
            this.jKT.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cLN() != null) {
            if (!y.isEmpty(aVar.cLN()) && StringUtils.isEmpty(this.jLa)) {
                b bVar = aVar.cLN().get(0);
                if (bVar.cLV() != null) {
                    this.jLa = bVar.cLV().forum_id + "";
                }
            }
            this.hasMore = aVar.cLM();
            if (aVar.bDy()) {
                if (!y.isEmpty(aVar.cLN())) {
                    this.jKV.clear();
                    this.jKV.addAll(aVar.cLN());
                }
            } else if (!y.isEmpty(aVar.cLN())) {
                this.jKV.addAll(aVar.cLN());
            }
            this.jKU.dR(this.jKV);
            if (aVar.bDy() && this.jKT != null && this.jKT.getChildCount() > 0) {
                this.jKT.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.jKY == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.jKY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jLh);
                ap.a((View) this.jKY, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cLX() >= forumBroadcastMajorResidueData.cLY()) {
                this.jLd = true;
                this.jKY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jLi);
                ap.a((View) this.jKY, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
                this.jKY.setAlpha(0.33f);
            } else {
                this.jKY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jLh);
                ap.a((View) this.jKY, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.jKT, R.color.cp_bg_line_c);
        this.fTv.changeSkin(i);
        this.jKU.notifyDataSetChanged();
    }

    public void aO(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.jKO != null) {
                            a.this.SK();
                            a.this.jKO.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.jLc, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jLc);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMb() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.oe(2);
        aVar.iA(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.ba(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).bkJ();
    }

    public void cMc() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).xK(true).TD(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aH((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.jKV = null;
        this.jLe = null;
    }
}
