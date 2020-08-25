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
    private PbListView fDW;
    private boolean hasMore;
    private final com.baidu.tieba.im.forum.broadcast.a jni;
    private BdRecyclerView jnn;
    private com.baidu.tieba.im.forum.broadcast.a.a jno;
    private ImageView jnq;
    private LinearLayout jnr;
    private TextView jns;
    private TextView jnt;
    private String jnu;
    private String jnv;
    private RelativeLayout jnw;
    private boolean jnx;
    private ScreenTopToast jny;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> jnp = new ArrayList();
    private BdListView.e fXT = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.jnn != null) {
                a.this.jnn.stopScroll();
            }
            a.this.bGR();
        }
    };
    private f<b> jnz = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new aq("c13875").u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("fid", a.this.jnu).u("tid", bVar.cEG() != null ? bVar.cEG().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!k.isFastDoubleClick()) {
                        if (a.this.jnx) {
                            a.this.cEK();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cED() + "", a.this.jnv, a.this.jnu, bVar.cEG() != null ? bVar.cEG().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cEG() == null || bVar.cEG().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).wS(false).Sp(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aE((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cEG().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener jnA = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13873").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cEL();
        }
    };
    private View.OnClickListener jnB = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.ab(a.this.jnu, a.this.jnv, "2");
                oVar.start();
                TiebaStatic.log(new aq("c13874").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener jnC = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13874").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!k.isFastDoubleClick()) {
                a.this.cEK();
            }
        }
    };
    private View.OnClickListener hBN = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jnn != null) {
                a.this.jnn.stopScroll();
            }
            if (a.this.fDW != null && a.this.jni != null && j.isNetWorkAvailable()) {
                a.this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fDW.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fDW.showLoading();
                    a.this.jni.bFD();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jni = aVar;
        this.jnu = str;
        this.jnv = str2;
        h(view, str3);
        TiebaStatic.log(new aq("c13872").u("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cEK() {
        if (this.jny == null) {
            this.jny = new ScreenTopToast(this.mPageContext.getPageActivity()).St(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Sv(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jnu);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.jny.aE((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        } else if (!this.jny.isShow()) {
            this.jny = new ScreenTopToast(this.mPageContext.getPageActivity()).St(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Sv(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jnu);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.jny.aE((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.jnw = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jnq = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jnr = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.jnr.setGravity(16);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.jnq, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.jnt = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.jnq.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jnt.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jnq.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.jnt.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.jnq.setLayoutParams(layoutParams2);
        this.jnq.setVisibility(0);
        this.jnq.setOnClickListener(this.jnA);
        this.jnn = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.jnn.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.jnn.setOverScrollMode(2);
        this.jnn.setOnSrollToBottomListener(this.fXT);
        ap.setBackgroundColor(this.jnn, R.color.cp_bg_line_c);
        this.jno = new com.baidu.tieba.im.forum.broadcast.a.a(this.mPageContext.getPageActivity());
        this.jno.a(this.jnz);
        this.jnn.setAdapter(this.jno);
        this.fDW = new PbListView(this.mPageContext.getPageActivity());
        this.fDW.getView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.bkv();
        this.fDW.setOnClickListener(this.hBN);
        if ("broadcast_publish_success".equals(str)) {
            cEM();
            int size = com.baidu.adp.base.a.lb().getSize();
            Activity W = com.baidu.adp.base.a.lb().W(size - 2);
            Activity W2 = com.baidu.adp.base.a.lb().W(size - 3);
            if (W != null && W2 != null && "FlutterPageActivity".equals(W.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(W2.getClass().getSimpleName())) {
                W2.finish();
            }
        }
    }

    public void bGR() {
        if (this.fDW != null && this.jni != null) {
            if (j.isNetWorkAvailable()) {
                this.jnn.setNextPage(this.fDW);
                this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fDW.setOnClickListener(null);
                if (this.hasMore) {
                    this.fDW.showLoading();
                    this.jni.bFD();
                    return;
                }
                this.fDW.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.fDW.endLoadData();
                return;
            }
            this.jnn.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cEx() != null) {
            if (!y.isEmpty(aVar.cEx()) && StringUtils.isEmpty(this.jnu)) {
                b bVar = aVar.cEx().get(0);
                if (bVar.cEF() != null) {
                    this.jnu = bVar.cEF().forum_id + "";
                }
            }
            this.hasMore = aVar.cEw();
            if (aVar.bzC()) {
                if (!y.isEmpty(aVar.cEx())) {
                    this.jnp.clear();
                    this.jnp.addAll(aVar.cEx());
                }
            } else if (!y.isEmpty(aVar.cEx())) {
                this.jnp.addAll(aVar.cEx());
            }
            this.jno.dG(this.jnp);
            if (aVar.bzC() && this.jnn != null && this.jnn.getChildCount() > 0) {
                this.jnn.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.jns == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.jns = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jnB);
                ap.a((View) this.jns, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cEH() >= forumBroadcastMajorResidueData.cEI()) {
                this.jnx = true;
                this.jns = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jnC);
                ap.a((View) this.jns, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
                this.jns.setAlpha(0.33f);
            } else {
                this.jns = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jnB);
                ap.a((View) this.jns, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.jnn, R.color.cp_bg_line_c);
        this.fDW.changeSkin(i);
        this.jno.notifyDataSetChanged();
    }

    public void aK(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.jni != null) {
                            a.this.bFW();
                            a.this.jni.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.jnw, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jnw);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEL() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nw(2);
        aVar.ig(false);
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

    public void cEM() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).wS(true).Sp(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aE((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.jnp = null;
        this.jny = null;
    }
}
