package com.baidu.tieba.im.forum.broadcast.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.data.b;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidubce.util.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private PbListView gCf;
    private boolean hasMore;
    private String juI;
    private String juJ;
    private final com.baidu.tieba.im.forum.broadcast.a kCl;
    private BdRecyclerView kCq;
    private FroumBroadMajorHistoryAdapter kCr;
    private ImageView kCt;
    private LinearLayout kCu;
    private TextView kCv;
    private TextView kCw;
    private RelativeLayout kCx;
    private boolean kCy;
    private ScreenTopToast kCz;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> kCs = new ArrayList();
    private BdListView.e gXN = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.kCq != null) {
                a.this.kCq.stopScroll();
            }
            a.this.Zh();
        }
    };
    private f<b> kCA = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new aq("c13875").w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("fid", a.this.juI).w("tid", bVar.cXV() != null ? bVar.cXV().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!k.isFastDoubleClick()) {
                        if (a.this.kCy) {
                            a.this.cXZ();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cXT() + "", a.this.juJ, a.this.juI, bVar.cXV() != null ? bVar.cXV().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cXV() == null || bVar.cXV().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).yW(false).UX(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aR((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cXV().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener kCB = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13873").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cYa();
        }
    };
    private View.OnClickListener kCC = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.ao(a.this.juI, a.this.juJ, "2");
                oVar.start();
                TiebaStatic.log(new aq("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener kCD = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!k.isFastDoubleClick()) {
                a.this.cXZ();
            }
        }
    };
    private View.OnClickListener iOj = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kCq != null) {
                a.this.kCq.stopScroll();
            }
            if (a.this.gCf != null && a.this.kCl != null && j.isNetWorkAvailable()) {
                a.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gCf.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gCf.showLoading();
                    a.this.kCl.bUq();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kCl = aVar;
        this.juI = str;
        this.juJ = str2;
        h(view, str3);
        TiebaStatic.log(new aq("c13872").w("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cXZ() {
        if (this.kCz == null || !this.kCz.isShow()) {
            this.kCz = new ScreenTopToast(this.mPageContext.getPageActivity()).Vb(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).Vd(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.juI);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.kCz.aR((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.kCx = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kCt = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kCu = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.kCu.setGravity(16);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ao.setNavbarIconSrc(this.kCt, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.kCw = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.kCt.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kCw.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kCt.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.kCw.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.kCt.setLayoutParams(layoutParams2);
        this.kCt.setVisibility(0);
        this.kCt.setOnClickListener(this.kCB);
        this.kCq = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.kCq.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.kCq.setOverScrollMode(2);
        this.kCq.setOnSrollToBottomListener(this.gXN);
        ao.setBackgroundColor(this.kCq, R.color.CAM_X0204);
        this.kCr = new FroumBroadMajorHistoryAdapter(this.mPageContext.getPageActivity());
        this.kCr.a(this.kCA);
        this.kCq.setAdapter(this.kCr);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bxD();
        this.gCf.setOnClickListener(this.iOj);
        if ("broadcast_publish_success".equals(str)) {
            cYb();
            int size = com.baidu.adp.base.b.kC().getSize();
            Activity aa = com.baidu.adp.base.b.kC().aa(size - 2);
            Activity aa2 = com.baidu.adp.base.b.kC().aa(size - 3);
            if (aa != null && aa2 != null && "FlutterPageActivity".equals(aa.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(aa2.getClass().getSimpleName())) {
                aa2.finish();
            }
        }
    }

    public void Zh() {
        if (this.gCf != null && this.kCl != null) {
            if (j.isNetWorkAvailable()) {
                this.kCq.setNextPage(this.gCf);
                this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gCf.setOnClickListener(null);
                if (this.hasMore) {
                    this.gCf.showLoading();
                    this.kCl.bUq();
                    return;
                }
                this.gCf.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.gCf.endLoadData();
                return;
            }
            this.kCq.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cXN() != null) {
            if (!x.isEmpty(aVar.cXN()) && StringUtils.isEmpty(this.juI)) {
                b bVar = aVar.cXN().get(0);
                if (bVar.cXU() != null) {
                    this.juI = bVar.cXU().forum_id + "";
                }
            }
            this.hasMore = aVar.cXM();
            if (aVar.bNc()) {
                if (!x.isEmpty(aVar.cXN())) {
                    this.kCs.clear();
                    this.kCs.addAll(aVar.cXN());
                }
            } else if (!x.isEmpty(aVar.cXN())) {
                this.kCs.addAll(aVar.cXN());
            }
            this.kCr.eA(this.kCs);
            if (aVar.bNc() && this.kCq != null && this.kCq.getChildCount() > 0) {
                this.kCq.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.kCv == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.kCv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kCC);
                ao.a((View) this.kCv, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cXW() >= forumBroadcastMajorResidueData.cXX()) {
                this.kCy = true;
                this.kCv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kCD);
                ao.a((View) this.kCv, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.kCv.setAlpha(0.33f);
            } else {
                this.kCv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kCC);
                ao.a((View) this.kCv, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ao.setBackgroundColor(this.kCq, R.color.CAM_X0204);
        this.gCf.changeSkin(i);
        this.kCr.notifyDataSetChanged();
    }

    public void aR(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.kCl != null) {
                            a.this.Zj();
                            a.this.kCl.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.kCx, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Zj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kCx);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYa() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.pd(2);
        aVar.jI(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.br(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).btY();
    }

    public void cYb() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).yW(true).UX(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aR((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.kCs = null;
        this.kCz = null;
    }
}
