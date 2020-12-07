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
    private PbListView gre;
    private boolean hasMore;
    private String jih;
    private String jii;
    private com.baidu.tieba.im.forum.broadcast.a.a krA;
    private ImageView krC;
    private LinearLayout krD;
    private TextView krE;
    private TextView krF;
    private RelativeLayout krG;
    private boolean krH;
    private ScreenTopToast krI;
    private final com.baidu.tieba.im.forum.broadcast.a kru;
    private BdRecyclerView krz;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> krB = new ArrayList();
    private BdListView.e gLZ = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.krz != null) {
                a.this.krz.stopScroll();
            }
            a.this.XZ();
        }
    };
    private f<b> krJ = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new ar("c13875").w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("fid", a.this.jih).w("tid", bVar.cWx() != null ? bVar.cWx().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!l.isFastDoubleClick()) {
                        if (a.this.krH) {
                            a.this.cWB();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cWv() + "", a.this.jii, a.this.jih, bVar.cWx() != null ? bVar.cWx().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cWx() == null || bVar.cWx().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).yW(false).Vt(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aF((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cWx().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener krK = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13873").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cWC();
        }
    };
    private View.OnClickListener krL = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.al(a.this.jih, a.this.jii, "2");
                oVar.start();
                TiebaStatic.log(new ar("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener krM = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!l.isFastDoubleClick()) {
                a.this.cWB();
            }
        }
    };
    private View.OnClickListener iBV = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.krz != null) {
                a.this.krz.stopScroll();
            }
            if (a.this.gre != null && a.this.kru != null && j.isNetWorkAvailable()) {
                a.this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gre.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gre.showLoading();
                    a.this.kru.bRM();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kru = aVar;
        this.jih = str;
        this.jii = str2;
        h(view, str3);
        TiebaStatic.log(new ar("c13872").w("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cWB() {
        if (this.krI == null || !this.krI.isShow()) {
            this.krI = new ScreenTopToast(this.mPageContext.getPageActivity()).Vx(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Vz(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jih);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.krI.aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.krG = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.krC = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.krD = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.krD.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.krC, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.krF = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.krC.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.krF.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.krC.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.krF.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.krC.setLayoutParams(layoutParams2);
        this.krC.setVisibility(0);
        this.krC.setOnClickListener(this.krK);
        this.krz = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.krz.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.krz.setOverScrollMode(2);
        this.krz.setOnSrollToBottomListener(this.gLZ);
        ap.setBackgroundColor(this.krz, R.color.CAM_X0204);
        this.krA = new com.baidu.tieba.im.forum.broadcast.a.a(this.mPageContext.getPageActivity());
        this.krA.a(this.krJ);
        this.krz.setAdapter(this.krA);
        this.gre = new PbListView(this.mPageContext.getPageActivity());
        this.gre.getView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gre.setHeight(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.bvh();
        this.gre.setOnClickListener(this.iBV);
        if ("broadcast_publish_success".equals(str)) {
            cWD();
            int size = com.baidu.adp.base.a.lg().getSize();
            Activity aa = com.baidu.adp.base.a.lg().aa(size - 2);
            Activity aa2 = com.baidu.adp.base.a.lg().aa(size - 3);
            if (aa != null && aa2 != null && "FlutterPageActivity".equals(aa.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(aa2.getClass().getSimpleName())) {
                aa2.finish();
            }
        }
    }

    public void XZ() {
        if (this.gre != null && this.kru != null) {
            if (j.isNetWorkAvailable()) {
                this.krz.setNextPage(this.gre);
                this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gre.setOnClickListener(null);
                if (this.hasMore) {
                    this.gre.showLoading();
                    this.kru.bRM();
                    return;
                }
                this.gre.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.gre.endLoadData();
                return;
            }
            this.krz.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cWp() != null) {
            if (!y.isEmpty(aVar.cWp()) && StringUtils.isEmpty(this.jih)) {
                b bVar = aVar.cWp().get(0);
                if (bVar.cWw() != null) {
                    this.jih = bVar.cWw().forum_id + "";
                }
            }
            this.hasMore = aVar.cWo();
            if (aVar.bKJ()) {
                if (!y.isEmpty(aVar.cWp())) {
                    this.krB.clear();
                    this.krB.addAll(aVar.cWp());
                }
            } else if (!y.isEmpty(aVar.cWp())) {
                this.krB.addAll(aVar.cWp());
            }
            this.krA.et(this.krB);
            if (aVar.bKJ() && this.krz != null && this.krz.getChildCount() > 0) {
                this.krz.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.krE == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.krE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.krL);
                ap.a((View) this.krE, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cWy() >= forumBroadcastMajorResidueData.cWz()) {
                this.krH = true;
                this.krE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.krM);
                ap.a((View) this.krE, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.krE.setAlpha(0.33f);
            } else {
                this.krE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.krL);
                ap.a((View) this.krE, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.krz, R.color.CAM_X0204);
        this.gre.changeSkin(i);
        this.krA.notifyDataSetChanged();
    }

    public void aR(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.kru != null) {
                            a.this.Yb();
                            a.this.kru.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.krG, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.krG);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWC() {
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

    public void cWD() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).yW(true).Vt(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aF((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.krB = null;
        this.krI = null;
    }
}
