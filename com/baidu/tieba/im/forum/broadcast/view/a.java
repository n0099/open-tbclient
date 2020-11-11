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
    private PbListView gjo;
    private boolean hasMore;
    private final com.baidu.tieba.im.forum.broadcast.a kdj;
    private BdRecyclerView kdo;
    private com.baidu.tieba.im.forum.broadcast.a.a kdp;
    private ImageView kdr;
    private LinearLayout kds;
    private TextView kdt;
    private TextView kdu;
    private String kdv;
    private String kdw;
    private RelativeLayout kdx;
    private boolean kdy;
    private ScreenTopToast kdz;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> kdq = new ArrayList();
    private BdListView.e gDv = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.kdo != null) {
                a.this.kdo.stopScroll();
            }
            a.this.Wi();
        }
    };
    private f<b> kdA = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new aq("c13875").w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", a.this.kdv).w("tid", bVar.cRE() != null ? bVar.cRE().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!l.isFastDoubleClick()) {
                        if (a.this.kdy) {
                            a.this.cRI();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cRB() + "", a.this.kdw, a.this.kdv, bVar.cRE() != null ? bVar.cRE().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cRE() == null || bVar.cRE().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).yk(false).Ut(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aJ((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cRE().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener kdB = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13873").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cRJ();
        }
    };
    private View.OnClickListener kdC = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.aj(a.this.kdv, a.this.kdw, "2");
                oVar.start();
                TiebaStatic.log(new aq("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener kdD = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!l.isFastDoubleClick()) {
                a.this.cRI();
            }
        }
    };
    private View.OnClickListener iqp = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kdo != null) {
                a.this.kdo.stopScroll();
            }
            if (a.this.gjo != null && a.this.kdj != null && j.isNetWorkAvailable()) {
                a.this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gjo.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gjo.showLoading();
                    a.this.kdj.bOI();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kdj = aVar;
        this.kdv = str;
        this.kdw = str2;
        h(view, str3);
        TiebaStatic.log(new aq("c13872").w("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cRI() {
        if (this.kdz == null || !this.kdz.isShow()) {
            this.kdz = new ScreenTopToast(this.mPageContext.getPageActivity()).Ux(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Uz(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.kdv);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.kdz.aJ((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.kdx = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kdr = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kds = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.kds.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.kdr, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.kdu = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.kdr.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kdu.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kdr.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.kdu.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.kdr.setLayoutParams(layoutParams2);
        this.kdr.setVisibility(0);
        this.kdr.setOnClickListener(this.kdB);
        this.kdo = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.kdo.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.kdo.setOverScrollMode(2);
        this.kdo.setOnSrollToBottomListener(this.gDv);
        ap.setBackgroundColor(this.kdo, R.color.cp_bg_line_c);
        this.kdp = new com.baidu.tieba.im.forum.broadcast.a.a(this.mPageContext.getPageActivity());
        this.kdp.a(this.kdA);
        this.kdo.setAdapter(this.kdp);
        this.gjo = new PbListView(this.mPageContext.getPageActivity());
        this.gjo.getView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.gjo.setHeight(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.bst();
        this.gjo.setOnClickListener(this.iqp);
        if ("broadcast_publish_success".equals(str)) {
            cRK();
            int size = com.baidu.adp.base.a.lg().getSize();
            Activity X = com.baidu.adp.base.a.lg().X(size - 2);
            Activity X2 = com.baidu.adp.base.a.lg().X(size - 3);
            if (X != null && X2 != null && "FlutterPageActivity".equals(X.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(X2.getClass().getSimpleName())) {
                X2.finish();
            }
        }
    }

    public void Wi() {
        if (this.gjo != null && this.kdj != null) {
            if (j.isNetWorkAvailable()) {
                this.kdo.setNextPage(this.gjo);
                this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gjo.setOnClickListener(null);
                if (this.hasMore) {
                    this.gjo.showLoading();
                    this.kdj.bOI();
                    return;
                }
                this.gjo.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.gjo.endLoadData();
                return;
            }
            this.kdo.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cRv() != null) {
            if (!y.isEmpty(aVar.cRv()) && StringUtils.isEmpty(this.kdv)) {
                b bVar = aVar.cRv().get(0);
                if (bVar.cRD() != null) {
                    this.kdv = bVar.cRD().forum_id + "";
                }
            }
            this.hasMore = aVar.cRu();
            if (aVar.bHQ()) {
                if (!y.isEmpty(aVar.cRv())) {
                    this.kdq.clear();
                    this.kdq.addAll(aVar.cRv());
                }
            } else if (!y.isEmpty(aVar.cRv())) {
                this.kdq.addAll(aVar.cRv());
            }
            this.kdp.ei(this.kdq);
            if (aVar.bHQ() && this.kdo != null && this.kdo.getChildCount() > 0) {
                this.kdo.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.kdt == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.kdt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kdC);
                ap.a((View) this.kdt, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cRF() >= forumBroadcastMajorResidueData.cRG()) {
                this.kdy = true;
                this.kdt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kdD);
                ap.a((View) this.kdt, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
                this.kdt.setAlpha(0.33f);
            } else {
                this.kdt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kdC);
                ap.a((View) this.kdt, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.kdo, R.color.cp_bg_line_c);
        this.gjo.changeSkin(i);
        this.kdp.notifyDataSetChanged();
    }

    public void aQ(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.kdj != null) {
                            a.this.Wk();
                            a.this.kdj.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.kdx, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kdx);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRJ() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.oz(2);
        aVar.iW(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.bf(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).bpc();
    }

    public void cRK() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).yk(true).Ut(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aJ((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.kdq = null;
        this.kdz = null;
    }
}
