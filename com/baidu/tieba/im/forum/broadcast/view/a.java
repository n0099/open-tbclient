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
    private PbListView gdy;
    private boolean hasMore;
    private RelativeLayout jXA;
    private boolean jXB;
    private ScreenTopToast jXC;
    private final com.baidu.tieba.im.forum.broadcast.a jXm;
    private BdRecyclerView jXr;
    private com.baidu.tieba.im.forum.broadcast.a.a jXs;
    private ImageView jXu;
    private LinearLayout jXv;
    private TextView jXw;
    private TextView jXx;
    private String jXy;
    private String jXz;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> jXt = new ArrayList();
    private BdListView.e gxH = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.jXr != null) {
                a.this.jXr.stopScroll();
            }
            a.this.TI();
        }
    };
    private f<b> jXD = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new aq("c13875").w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", a.this.jXy).w("tid", bVar.cPd() != null ? bVar.cPd().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!l.isFastDoubleClick()) {
                        if (a.this.jXB) {
                            a.this.cPh();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cPa() + "", a.this.jXz, a.this.jXy, bVar.cPd() != null ? bVar.cPd().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cPd() == null || bVar.cPd().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).yb(false).Uc(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aH((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cPd().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener jXE = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13873").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cPi();
        }
    };
    private View.OnClickListener jXF = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.aj(a.this.jXy, a.this.jXz, "2");
                oVar.start();
                TiebaStatic.log(new aq("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener jXG = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!l.isFastDoubleClick()) {
                a.this.cPh();
            }
        }
    };
    private View.OnClickListener ikq = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jXr != null) {
                a.this.jXr.stopScroll();
            }
            if (a.this.gdy != null && a.this.jXm != null && j.isNetWorkAvailable()) {
                a.this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gdy.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gdy.showLoading();
                    a.this.jXm.bMi();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jXm = aVar;
        this.jXy = str;
        this.jXz = str2;
        h(view, str3);
        TiebaStatic.log(new aq("c13872").w("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cPh() {
        if (this.jXC == null || !this.jXC.isShow()) {
            this.jXC = new ScreenTopToast(this.mPageContext.getPageActivity()).Ug(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Ui(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jXy);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.jXC.aH((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.jXA = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jXu = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jXv = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.jXv.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.jXu, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.jXx = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.jXu.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jXx.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jXu.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.jXx.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.jXu.setLayoutParams(layoutParams2);
        this.jXu.setVisibility(0);
        this.jXu.setOnClickListener(this.jXE);
        this.jXr = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.jXr.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.jXr.setOverScrollMode(2);
        this.jXr.setOnSrollToBottomListener(this.gxH);
        ap.setBackgroundColor(this.jXr, R.color.cp_bg_line_c);
        this.jXs = new com.baidu.tieba.im.forum.broadcast.a.a(this.mPageContext.getPageActivity());
        this.jXs.a(this.jXD);
        this.jXr.setAdapter(this.jXs);
        this.gdy = new PbListView(this.mPageContext.getPageActivity());
        this.gdy.getView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.gdy.setHeight(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.bpT();
        this.gdy.setOnClickListener(this.ikq);
        if ("broadcast_publish_success".equals(str)) {
            cPj();
            int size = com.baidu.adp.base.a.lg().getSize();
            Activity X = com.baidu.adp.base.a.lg().X(size - 2);
            Activity X2 = com.baidu.adp.base.a.lg().X(size - 3);
            if (X != null && X2 != null && "FlutterPageActivity".equals(X.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(X2.getClass().getSimpleName())) {
                X2.finish();
            }
        }
    }

    public void TI() {
        if (this.gdy != null && this.jXm != null) {
            if (j.isNetWorkAvailable()) {
                this.jXr.setNextPage(this.gdy);
                this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gdy.setOnClickListener(null);
                if (this.hasMore) {
                    this.gdy.showLoading();
                    this.jXm.bMi();
                    return;
                }
                this.gdy.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.gdy.endLoadData();
                return;
            }
            this.jXr.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cOU() != null) {
            if (!y.isEmpty(aVar.cOU()) && StringUtils.isEmpty(this.jXy)) {
                b bVar = aVar.cOU().get(0);
                if (bVar.cPc() != null) {
                    this.jXy = bVar.cPc().forum_id + "";
                }
            }
            this.hasMore = aVar.cOT();
            if (aVar.bFr()) {
                if (!y.isEmpty(aVar.cOU())) {
                    this.jXt.clear();
                    this.jXt.addAll(aVar.cOU());
                }
            } else if (!y.isEmpty(aVar.cOU())) {
                this.jXt.addAll(aVar.cOU());
            }
            this.jXs.ea(this.jXt);
            if (aVar.bFr() && this.jXr != null && this.jXr.getChildCount() > 0) {
                this.jXr.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.jXw == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.jXw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jXF);
                ap.a((View) this.jXw, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cPe() >= forumBroadcastMajorResidueData.cPf()) {
                this.jXB = true;
                this.jXw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jXG);
                ap.a((View) this.jXw, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
                this.jXw.setAlpha(0.33f);
            } else {
                this.jXw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jXF);
                ap.a((View) this.jXw, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.jXr, R.color.cp_bg_line_c);
        this.gdy.changeSkin(i);
        this.jXs.notifyDataSetChanged();
    }

    public void aQ(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.jXm != null) {
                            a.this.TK();
                            a.this.jXm.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.jXA, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jXA);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPi() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.op(2);
        aVar.iN(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.bb(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).bmC();
    }

    public void cPj() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).yb(true).Uc(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aH((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.jXt = null;
        this.jXC = null;
    }
}
