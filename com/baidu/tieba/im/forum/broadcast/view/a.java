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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.util.k;
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
/* loaded from: classes20.dex */
public class a {
    private PbListView fEa;
    private boolean hasMore;
    private String jnA;
    private String jnB;
    private RelativeLayout jnC;
    private boolean jnD;
    private ScreenTopToast jnE;
    private final com.baidu.tieba.im.forum.broadcast.a jno;
    private BdRecyclerView jnt;
    private com.baidu.tieba.im.forum.broadcast.a.a jnu;
    private ImageView jnw;
    private LinearLayout jnx;
    private TextView jny;
    private TextView jnz;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> jnv = new ArrayList();
    private BdListView.e fXX = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.jnt != null) {
                a.this.jnt.stopScroll();
            }
            a.this.bGS();
        }
    };
    private f<b> jnF = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new aq("c13875").u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("fid", a.this.jnA).u("tid", bVar.cEH() != null ? bVar.cEH().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!k.isFastDoubleClick()) {
                        if (a.this.jnD) {
                            a.this.cEL();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cEE() + "", a.this.jnB, a.this.jnA, bVar.cEH() != null ? bVar.cEH().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cEH() == null || bVar.cEH().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).wU(false).Sp(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aE((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cEH().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener jnG = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13873").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cEM();
        }
    };
    private View.OnClickListener jnH = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.ab(a.this.jnA, a.this.jnB, "2");
                oVar.start();
                TiebaStatic.log(new aq("c13874").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener jnI = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13874").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!k.isFastDoubleClick()) {
                a.this.cEL();
            }
        }
    };
    private View.OnClickListener hBT = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jnt != null) {
                a.this.jnt.stopScroll();
            }
            if (a.this.fEa != null && a.this.jno != null && j.isNetWorkAvailable()) {
                a.this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fEa.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fEa.showLoading();
                    a.this.jno.bFE();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jno = aVar;
        this.jnA = str;
        this.jnB = str2;
        h(view, str3);
        TiebaStatic.log(new aq("c13872").u("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cEL() {
        if (this.jnE == null) {
            this.jnE = new ScreenTopToast(this.mPageContext.getPageActivity()).St(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Sv(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jnA);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.jnE.aE((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        } else if (!this.jnE.isShow()) {
            this.jnE = new ScreenTopToast(this.mPageContext.getPageActivity()).St(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Sv(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jnA);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.jnE.aE((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.jnC = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jnw = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jnx = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.jnx.setGravity(16);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.jnw, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.jnz = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.jnw.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jnz.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jnw.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.jnz.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.jnw.setLayoutParams(layoutParams2);
        this.jnw.setVisibility(0);
        this.jnw.setOnClickListener(this.jnG);
        this.jnt = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.jnt.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.jnt.setOverScrollMode(2);
        this.jnt.setOnSrollToBottomListener(this.fXX);
        ap.setBackgroundColor(this.jnt, R.color.cp_bg_line_c);
        this.jnu = new com.baidu.tieba.im.forum.broadcast.a.a(this.mPageContext.getPageActivity());
        this.jnu.a(this.jnF);
        this.jnt.setAdapter(this.jnu);
        this.fEa = new PbListView(this.mPageContext.getPageActivity());
        this.fEa.getView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.bkv();
        this.fEa.setOnClickListener(this.hBT);
        if ("broadcast_publish_success".equals(str)) {
            cEN();
            int size = com.baidu.adp.base.a.lb().getSize();
            Activity W = com.baidu.adp.base.a.lb().W(size - 2);
            Activity W2 = com.baidu.adp.base.a.lb().W(size - 3);
            if (W != null && W2 != null && "FlutterPageActivity".equals(W.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(W2.getClass().getSimpleName())) {
                W2.finish();
            }
        }
    }

    public void bGS() {
        if (this.fEa != null && this.jno != null) {
            if (j.isNetWorkAvailable()) {
                this.jnt.setNextPage(this.fEa);
                this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fEa.setOnClickListener(null);
                if (this.hasMore) {
                    this.fEa.showLoading();
                    this.jno.bFE();
                    return;
                }
                this.fEa.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.fEa.endLoadData();
                return;
            }
            this.jnt.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cEy() != null) {
            if (!y.isEmpty(aVar.cEy()) && StringUtils.isEmpty(this.jnA)) {
                b bVar = aVar.cEy().get(0);
                if (bVar.cEG() != null) {
                    this.jnA = bVar.cEG().forum_id + "";
                }
            }
            this.hasMore = aVar.cEx();
            if (aVar.bzD()) {
                if (!y.isEmpty(aVar.cEy())) {
                    this.jnv.clear();
                    this.jnv.addAll(aVar.cEy());
                }
            } else if (!y.isEmpty(aVar.cEy())) {
                this.jnv.addAll(aVar.cEy());
            }
            this.jnu.dG(this.jnv);
            if (aVar.bzD() && this.jnt != null && this.jnt.getChildCount() > 0) {
                this.jnt.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.jny == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.jny = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jnH);
                ap.a((View) this.jny, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cEI() >= forumBroadcastMajorResidueData.cEJ()) {
                this.jnD = true;
                this.jny = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jnI);
                ap.a((View) this.jny, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
                this.jny.setAlpha(0.33f);
            } else {
                this.jny = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jnH);
                ap.a((View) this.jny, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.jnt, R.color.cp_bg_line_c);
        this.fEa.changeSkin(i);
        this.jnu.notifyDataSetChanged();
    }

    public void aK(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.jno != null) {
                            a.this.bFX();
                            a.this.jno.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.jnC, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jnC);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEM() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nw(2);
        aVar.ih(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.aX(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).bhg();
    }

    public void cEN() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).wU(true).Sp(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aE((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.jnv = null;
        this.jnE = null;
    }
}
