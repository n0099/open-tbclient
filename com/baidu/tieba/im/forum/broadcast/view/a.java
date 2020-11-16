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
    private PbListView giV;
    private boolean hasMore;
    private final com.baidu.tieba.im.forum.broadcast.a kdT;
    private BdRecyclerView kdY;
    private com.baidu.tieba.im.forum.broadcast.a.a kdZ;
    private ImageView keb;
    private LinearLayout kec;
    private TextView ked;
    private TextView kee;
    private String kef;
    private String keg;
    private RelativeLayout keh;
    private boolean kei;
    private ScreenTopToast kej;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> kea = new ArrayList();
    private BdListView.e gDc = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.kdY != null) {
                a.this.kdY.stopScroll();
            }
            a.this.Vz();
        }
    };
    private f<b> kek = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new ar("c13875").w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", a.this.kef).w("tid", bVar.cRk() != null ? bVar.cRk().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!l.isFastDoubleClick()) {
                        if (a.this.kei) {
                            a.this.cRo();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cRh() + "", a.this.keg, a.this.kef, bVar.cRk() != null ? bVar.cRk().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cRk() == null || bVar.cRk().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).yr(false).Ue(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aF((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cRk().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener kel = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13873").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cRp();
        }
    };
    private View.OnClickListener kem = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.aj(a.this.kef, a.this.keg, "2");
                oVar.start();
                TiebaStatic.log(new ar("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener ken = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!l.isFastDoubleClick()) {
                a.this.cRo();
            }
        }
    };
    private View.OnClickListener ird = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kdY != null) {
                a.this.kdY.stopScroll();
            }
            if (a.this.giV != null && a.this.kdT != null && j.isNetWorkAvailable()) {
                a.this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.giV.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.giV.showLoading();
                    a.this.kdT.bOb();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kdT = aVar;
        this.kef = str;
        this.keg = str2;
        h(view, str3);
        TiebaStatic.log(new ar("c13872").w("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cRo() {
        if (this.kej == null || !this.kej.isShow()) {
            this.kej = new ScreenTopToast(this.mPageContext.getPageActivity()).Ui(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Uk(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.kef);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.kej.aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.keh = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.keb = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kec = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.kec.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.keb, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.kee = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.keb.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kee.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.keb.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.kee.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.keb.setLayoutParams(layoutParams2);
        this.keb.setVisibility(0);
        this.keb.setOnClickListener(this.kel);
        this.kdY = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.kdY.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.kdY.setOverScrollMode(2);
        this.kdY.setOnSrollToBottomListener(this.gDc);
        ap.setBackgroundColor(this.kdY, R.color.CAM_X0204);
        this.kdZ = new com.baidu.tieba.im.forum.broadcast.a.a(this.mPageContext.getPageActivity());
        this.kdZ.a(this.kek);
        this.kdY.setAdapter(this.kdZ);
        this.giV = new PbListView(this.mPageContext.getPageActivity());
        this.giV.getView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.giV.setHeight(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.brI();
        this.giV.setOnClickListener(this.ird);
        if ("broadcast_publish_success".equals(str)) {
            cRq();
            int size = com.baidu.adp.base.a.lg().getSize();
            Activity X = com.baidu.adp.base.a.lg().X(size - 2);
            Activity X2 = com.baidu.adp.base.a.lg().X(size - 3);
            if (X != null && X2 != null && "FlutterPageActivity".equals(X.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(X2.getClass().getSimpleName())) {
                X2.finish();
            }
        }
    }

    public void Vz() {
        if (this.giV != null && this.kdT != null) {
            if (j.isNetWorkAvailable()) {
                this.kdY.setNextPage(this.giV);
                this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.giV.setOnClickListener(null);
                if (this.hasMore) {
                    this.giV.showLoading();
                    this.kdT.bOb();
                    return;
                }
                this.giV.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.giV.endLoadData();
                return;
            }
            this.kdY.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cRb() != null) {
            if (!y.isEmpty(aVar.cRb()) && StringUtils.isEmpty(this.kef)) {
                b bVar = aVar.cRb().get(0);
                if (bVar.cRj() != null) {
                    this.kef = bVar.cRj().forum_id + "";
                }
            }
            this.hasMore = aVar.cRa();
            if (aVar.bHj()) {
                if (!y.isEmpty(aVar.cRb())) {
                    this.kea.clear();
                    this.kea.addAll(aVar.cRb());
                }
            } else if (!y.isEmpty(aVar.cRb())) {
                this.kea.addAll(aVar.cRb());
            }
            this.kdZ.ei(this.kea);
            if (aVar.bHj() && this.kdY != null && this.kdY.getChildCount() > 0) {
                this.kdY.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.ked == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.ked = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kem);
                ap.a((View) this.ked, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cRl() >= forumBroadcastMajorResidueData.cRm()) {
                this.kei = true;
                this.ked = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.ken);
                ap.a((View) this.ked, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.ked.setAlpha(0.33f);
            } else {
                this.ked = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kem);
                ap.a((View) this.ked, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.kdY, R.color.CAM_X0204);
        this.giV.changeSkin(i);
        this.kdZ.notifyDataSetChanged();
    }

    public void aQ(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.kdT != null) {
                            a.this.VB();
                            a.this.kdT.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.keh, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.keh);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRp() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.ov(2);
        aVar.iX(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.bg(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).bog();
    }

    public void cRq() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).yr(true).Ue(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.kea = null;
        this.kej = null;
    }
}
