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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.l.h;
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
    private PbListView grg;
    private boolean hasMore;
    private String jij;
    private String jik;
    private BdRecyclerView krB;
    private com.baidu.tieba.im.forum.broadcast.a.a krC;
    private ImageView krE;
    private LinearLayout krF;
    private TextView krG;
    private TextView krH;
    private RelativeLayout krI;
    private boolean krJ;
    private ScreenTopToast krK;
    private final com.baidu.tieba.im.forum.broadcast.a krw;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> krD = new ArrayList();
    private BdListView.e gMb = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.krB != null) {
                a.this.krB.stopScroll();
            }
            a.this.XZ();
        }
    };
    private f<b> krL = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new ar("c13875").w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("fid", a.this.jij).w("tid", bVar.cWy() != null ? bVar.cWy().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!l.isFastDoubleClick()) {
                        if (a.this.krJ) {
                            a.this.cWC();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cWw() + "", a.this.jik, a.this.jij, bVar.cWy() != null ? bVar.cWy().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cWy() == null || bVar.cWy().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).yW(false).Vt(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aF((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cWy().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener krM = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13873").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cWD();
        }
    };
    private View.OnClickListener krN = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.al(a.this.jij, a.this.jik, "2");
                oVar.start();
                TiebaStatic.log(new ar("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener krO = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!l.isFastDoubleClick()) {
                a.this.cWC();
            }
        }
    };
    private View.OnClickListener iBX = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.krB != null) {
                a.this.krB.stopScroll();
            }
            if (a.this.grg != null && a.this.krw != null && j.isNetWorkAvailable()) {
                a.this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.grg.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.grg.showLoading();
                    a.this.krw.bRN();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.krw = aVar;
        this.jij = str;
        this.jik = str2;
        h(view, str3);
        TiebaStatic.log(new ar("c13872").w("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cWC() {
        if (this.krK == null || !this.krK.isShow()) {
            this.krK = new ScreenTopToast(this.mPageContext.getPageActivity()).Vx(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Vz(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jij);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.krK.aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.krI = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.krE = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.krF = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.krF.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.krE, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.krH = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.krE.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.krH.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.krE.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.krH.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.krE.setLayoutParams(layoutParams2);
        this.krE.setVisibility(0);
        this.krE.setOnClickListener(this.krM);
        this.krB = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.krB.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.krB.setOverScrollMode(2);
        this.krB.setOnSrollToBottomListener(this.gMb);
        ap.setBackgroundColor(this.krB, R.color.CAM_X0204);
        this.krC = new com.baidu.tieba.im.forum.broadcast.a.a(this.mPageContext.getPageActivity());
        this.krC.a(this.krL);
        this.krB.setAdapter(this.krC);
        this.grg = new PbListView(this.mPageContext.getPageActivity());
        this.grg.getView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.grg.setHeight(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.bvh();
        this.grg.setOnClickListener(this.iBX);
        if ("broadcast_publish_success".equals(str)) {
            cWE();
            int size = com.baidu.adp.base.a.lg().getSize();
            Activity aa = com.baidu.adp.base.a.lg().aa(size - 2);
            Activity aa2 = com.baidu.adp.base.a.lg().aa(size - 3);
            if (aa != null && aa2 != null && "FlutterPageActivity".equals(aa.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(aa2.getClass().getSimpleName())) {
                aa2.finish();
            }
        }
    }

    public void XZ() {
        if (this.grg != null && this.krw != null) {
            if (j.isNetWorkAvailable()) {
                this.krB.setNextPage(this.grg);
                this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.grg.setOnClickListener(null);
                if (this.hasMore) {
                    this.grg.showLoading();
                    this.krw.bRN();
                    return;
                }
                this.grg.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.grg.endLoadData();
                return;
            }
            this.krB.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cWq() != null) {
            if (!y.isEmpty(aVar.cWq()) && StringUtils.isEmpty(this.jij)) {
                b bVar = aVar.cWq().get(0);
                if (bVar.cWx() != null) {
                    this.jij = bVar.cWx().forum_id + "";
                }
            }
            this.hasMore = aVar.cWp();
            if (aVar.bKJ()) {
                if (!y.isEmpty(aVar.cWq())) {
                    this.krD.clear();
                    this.krD.addAll(aVar.cWq());
                }
            } else if (!y.isEmpty(aVar.cWq())) {
                this.krD.addAll(aVar.cWq());
            }
            this.krC.et(this.krD);
            if (aVar.bKJ() && this.krB != null && this.krB.getChildCount() > 0) {
                this.krB.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.krG == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.krG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.krN);
                ap.a((View) this.krG, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cWz() >= forumBroadcastMajorResidueData.cWA()) {
                this.krJ = true;
                this.krG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.krO);
                ap.a((View) this.krG, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.krG.setAlpha(0.33f);
            } else {
                this.krG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.krN);
                ap.a((View) this.krG, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.krB, R.color.CAM_X0204);
        this.grg.changeSkin(i);
        this.krC.notifyDataSetChanged();
    }

    public void aR(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.krw != null) {
                            a.this.Yb();
                            a.this.krw.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.krI, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.krI);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWD() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.oT(2);
        aVar.jm(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.bi(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).brv();
    }

    public void cWE() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).yW(true).Vt(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.krD = null;
        this.krK = null;
    }
}
