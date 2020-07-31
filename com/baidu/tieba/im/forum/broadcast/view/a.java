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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
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
    private PbListView fsC;
    private boolean hasMore;
    private final com.baidu.tieba.im.forum.broadcast.a iYg;
    private BdRecyclerView iYl;
    private com.baidu.tieba.im.forum.broadcast.a.a iYm;
    private ImageView iYo;
    private LinearLayout iYp;
    private TextView iYq;
    private TextView iYr;
    private String iYs;
    private String iYt;
    private RelativeLayout iYu;
    private boolean iYv;
    private ScreenTopToast iYw;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> iYn = new ArrayList();
    private BdListView.e fLV = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.iYl != null) {
                a.this.iYl.stopScroll();
            }
            a.this.bxS();
        }
    };
    private f<b> iYx = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new ap("c13875").t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("fid", a.this.iYs).t("tid", bVar.ctP() != null ? bVar.ctP().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!k.isFastDoubleClick()) {
                        if (a.this.iYv) {
                            a.this.ctT();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.ctM() + "", a.this.iYt, a.this.iYs, bVar.ctP() != null ? bVar.ctP().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.ctP() == null || bVar.ctP().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).wd(false).Pr(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aF((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.ctP().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener iYy = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ap("c13873").t("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.ctU();
        }
    };
    private View.OnClickListener iYz = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.ab(a.this.iYs, a.this.iYt, "2");
                oVar.start();
                TiebaStatic.log(new ap("c13874").t("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener iYA = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ap("c13874").t("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!k.isFastDoubleClick()) {
                a.this.ctT();
            }
        }
    };
    private View.OnClickListener hoW = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iYl != null) {
                a.this.iYl.stopScroll();
            }
            if (a.this.fsC != null && a.this.iYg != null && j.isNetWorkAvailable()) {
                a.this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fsC.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fsC.showLoading();
                    a.this.iYg.bwE();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.iYg = aVar;
        this.iYs = str;
        this.iYt = str2;
        h(view, str3);
        TiebaStatic.log(new ap("c13872").t("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void ctT() {
        if (this.iYw == null) {
            this.iYw = new ScreenTopToast(this.mPageContext.getPageActivity()).Pv(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Px(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).aj(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.iYs);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.iYw.aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        } else if (!this.iYw.isShow()) {
            this.iYw = new ScreenTopToast(this.mPageContext.getPageActivity()).Pv(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Px(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).aj(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.iYs);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.iYw.aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.iYu = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iYo = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.iYp = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.iYp.setGravity(16);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ao.setNavbarIconSrc(this.iYo, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.iYr = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.iYo.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iYr.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iYo.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.iYr.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.iYo.setLayoutParams(layoutParams2);
        this.iYo.setVisibility(0);
        this.iYo.setOnClickListener(this.iYy);
        this.iYl = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.iYl.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.iYl.setOverScrollMode(2);
        this.iYl.setOnSrollToBottomListener(this.fLV);
        ao.setBackgroundColor(this.iYl, R.color.cp_bg_line_c);
        this.iYm = new com.baidu.tieba.im.forum.broadcast.a.a(this.mPageContext.getPageActivity());
        this.iYm.a(this.iYx);
        this.iYl.setAdapter(this.iYm);
        this.fsC = new PbListView(this.mPageContext.getPageActivity());
        this.fsC.getView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.bbZ();
        this.fsC.setOnClickListener(this.hoW);
        if ("broadcast_publish_success".equals(str)) {
            ctV();
            int size = com.baidu.adp.base.a.jC().getSize();
            Activity U = com.baidu.adp.base.a.jC().U(size - 2);
            Activity U2 = com.baidu.adp.base.a.jC().U(size - 3);
            if (U != null && U2 != null && "FlutterPageActivity".equals(U.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(U2.getClass().getSimpleName())) {
                U2.finish();
            }
        }
    }

    public void bxS() {
        if (this.fsC != null && this.iYg != null) {
            if (j.isNetWorkAvailable()) {
                this.iYl.setNextPage(this.fsC);
                this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fsC.setOnClickListener(null);
                if (this.hasMore) {
                    this.fsC.showLoading();
                    this.iYg.bwE();
                    return;
                }
                this.fsC.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.fsC.endLoadData();
                return;
            }
            this.iYl.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.ctG() != null) {
            if (!x.isEmpty(aVar.ctG()) && StringUtils.isEmpty(this.iYs)) {
                b bVar = aVar.ctG().get(0);
                if (bVar.ctO() != null) {
                    this.iYs = bVar.ctO().forum_id + "";
                }
            }
            this.hasMore = aVar.ctF();
            if (aVar.bqE()) {
                if (!x.isEmpty(aVar.ctG())) {
                    this.iYn.clear();
                    this.iYn.addAll(aVar.ctG());
                }
            } else if (!x.isEmpty(aVar.ctG())) {
                this.iYn.addAll(aVar.ctG());
            }
            this.iYm.dz(this.iYn);
            if (aVar.bqE() && this.iYl != null && this.iYl.getChildCount() > 0) {
                this.iYl.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.iYq == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.iYq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.iYz);
                ao.a((View) this.iYq, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.ctQ() >= forumBroadcastMajorResidueData.ctR()) {
                this.iYv = true;
                this.iYq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.iYA);
                ao.a((View) this.iYq, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
                this.iYq.setAlpha(0.33f);
            } else {
                this.iYq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.iYz);
                ao.a((View) this.iYq, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ao.setBackgroundColor(this.iYl, R.color.cp_bg_line_c);
        this.fsC.changeSkin(i);
        this.iYm.notifyDataSetChanged();
    }

    public void aG(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.iYg != null) {
                            a.this.bwX();
                            a.this.iYg.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.iYu, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.iYu);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctU() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.lq(2);
        aVar.hK(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.aV(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).aYL();
    }

    public void ctV() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).wd(true).Pr(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.iYn = null;
        this.iYw = null;
    }
}
