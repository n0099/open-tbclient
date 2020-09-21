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
/* loaded from: classes25.dex */
public class a {
    private PbListView fHm;
    private boolean hasMore;
    private final com.baidu.tieba.im.forum.broadcast.a jvR;
    private BdRecyclerView jvW;
    private com.baidu.tieba.im.forum.broadcast.a.a jvX;
    private ImageView jvZ;
    private LinearLayout jwa;
    private TextView jwb;
    private TextView jwc;
    private String jwd;
    private String jwe;
    private RelativeLayout jwf;
    private boolean jwg;
    private ScreenTopToast jwh;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> jvY = new ArrayList();
    private BdListView.e gbl = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.jvW != null) {
                a.this.jvW.stopScroll();
            }
            a.this.bIi();
        }
    };
    private f<b> jwi = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new aq("c13875").u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("fid", a.this.jwd).u("tid", bVar.cIn() != null ? bVar.cIn().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!l.isFastDoubleClick()) {
                        if (a.this.jwg) {
                            a.this.cIr();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cIk() + "", a.this.jwe, a.this.jwd, bVar.cIn() != null ? bVar.cIn().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cIn() == null || bVar.cIn().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).xd(false).SP(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aF((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cIn().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener jwj = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13873").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cIs();
        }
    };
    private View.OnClickListener jwk = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.ab(a.this.jwd, a.this.jwe, "2");
                oVar.start();
                TiebaStatic.log(new aq("c13874").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener jwl = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13874").u("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!l.isFastDoubleClick()) {
                a.this.cIr();
            }
        }
    };
    private View.OnClickListener hIV = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jvW != null) {
                a.this.jvW.stopScroll();
            }
            if (a.this.fHm != null && a.this.jvR != null && j.isNetWorkAvailable()) {
                a.this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fHm.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fHm.showLoading();
                    a.this.jvR.bGU();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jvR = aVar;
        this.jwd = str;
        this.jwe = str2;
        h(view, str3);
        TiebaStatic.log(new aq("c13872").u("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cIr() {
        if (this.jwh == null || !this.jwh.isShow()) {
            this.jwh = new ScreenTopToast(this.mPageContext.getPageActivity()).ST(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).SV(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jwd);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.jwh.aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.jwf = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jvZ = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jwa = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.jwa.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.jvZ, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.jwc = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.jvZ.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jwc.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jvZ.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.jwc.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.jvZ.setLayoutParams(layoutParams2);
        this.jvZ.setVisibility(0);
        this.jvZ.setOnClickListener(this.jwj);
        this.jvW = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.jvW.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.jvW.setOverScrollMode(2);
        this.jvW.setOnSrollToBottomListener(this.gbl);
        ap.setBackgroundColor(this.jvW, R.color.cp_bg_line_c);
        this.jvX = new com.baidu.tieba.im.forum.broadcast.a.a(this.mPageContext.getPageActivity());
        this.jvX.a(this.jwi);
        this.jvW.setAdapter(this.jvX);
        this.fHm = new PbListView(this.mPageContext.getPageActivity());
        this.fHm.getView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fHm.setHeight(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.blq();
        this.fHm.setOnClickListener(this.hIV);
        if ("broadcast_publish_success".equals(str)) {
            cIt();
            int size = com.baidu.adp.base.a.lf().getSize();
            Activity X = com.baidu.adp.base.a.lf().X(size - 2);
            Activity X2 = com.baidu.adp.base.a.lf().X(size - 3);
            if (X != null && X2 != null && "FlutterPageActivity".equals(X.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(X2.getClass().getSimpleName())) {
                X2.finish();
            }
        }
    }

    public void bIi() {
        if (this.fHm != null && this.jvR != null) {
            if (j.isNetWorkAvailable()) {
                this.jvW.setNextPage(this.fHm);
                this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fHm.setOnClickListener(null);
                if (this.hasMore) {
                    this.fHm.showLoading();
                    this.jvR.bGU();
                    return;
                }
                this.fHm.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.fHm.endLoadData();
                return;
            }
            this.jvW.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cIe() != null) {
            if (!y.isEmpty(aVar.cIe()) && StringUtils.isEmpty(this.jwd)) {
                b bVar = aVar.cIe().get(0);
                if (bVar.cIm() != null) {
                    this.jwd = bVar.cIm().forum_id + "";
                }
            }
            this.hasMore = aVar.cId();
            if (aVar.bAM()) {
                if (!y.isEmpty(aVar.cIe())) {
                    this.jvY.clear();
                    this.jvY.addAll(aVar.cIe());
                }
            } else if (!y.isEmpty(aVar.cIe())) {
                this.jvY.addAll(aVar.cIe());
            }
            this.jvX.dO(this.jvY);
            if (aVar.bAM() && this.jvW != null && this.jvW.getChildCount() > 0) {
                this.jvW.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.jwb == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.jwb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jwk);
                ap.a((View) this.jwb, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cIo() >= forumBroadcastMajorResidueData.cIp()) {
                this.jwg = true;
                this.jwb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jwl);
                ap.a((View) this.jwb, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
                this.jwb.setAlpha(0.33f);
            } else {
                this.jwb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.jwk);
                ap.a((View) this.jwb, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.jvW, R.color.cp_bg_line_c);
        this.fHm.changeSkin(i);
        this.jvX.notifyDataSetChanged();
    }

    public void aK(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.jvR != null) {
                            a.this.bHn();
                            a.this.jvR.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.jwf, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.jwf);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIs() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nH(2);
        aVar.ie(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.aZ(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).bia();
    }

    public void cIt() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).xd(true).SP(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.jvY = null;
        this.jwh = null;
    }
}
