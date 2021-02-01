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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.l;
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
    private PbListView gAi;
    private boolean hasMore;
    private String jvI;
    private String jvJ;
    private final com.baidu.tieba.im.forum.broadcast.a kFM;
    private BdRecyclerView kFR;
    private FroumBroadMajorHistoryAdapter kFS;
    private ImageView kFU;
    private LinearLayout kFV;
    private TextView kFW;
    private TextView kFX;
    private RelativeLayout kFY;
    private boolean kFZ;
    private ScreenTopToast kGa;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> kFT = new ArrayList();
    private BdListView.e gVR = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.kFR != null) {
                a.this.kFR.stopScroll();
            }
            a.this.WX();
        }
    };
    private f<b> kGb = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new ar("c13875").v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", a.this.jvI).v("tid", bVar.cWb() != null ? bVar.cWb().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!l.isFastDoubleClick()) {
                        if (a.this.kFZ) {
                            a.this.cWf();
                            return;
                        }
                        p pVar = new p(a.this.mPageContext.getPageActivity());
                        pVar.b(bVar.cVZ() + "", a.this.jvJ, a.this.jvI, bVar.cWb() != null ? bVar.cWb().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        pVar.start();
                    }
                } else if (bVar.cWb() == null || bVar.cWb().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).zn(false).UN(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aR((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cWb().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener kGc = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13873").v("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cWg();
        }
    };
    private View.OnClickListener kGd = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick()) {
                p pVar = new p(a.this.mPageContext.getPageActivity());
                pVar.ap(a.this.jvI, a.this.jvJ, "2");
                pVar.start();
                TiebaStatic.log(new ar("c13874").v("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener kGe = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13874").v("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!l.isFastDoubleClick()) {
                a.this.cWf();
            }
        }
    };
    private View.OnClickListener iPk = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kFR != null) {
                a.this.kFR.stopScroll();
            }
            if (a.this.gAi != null && a.this.kFM != null && j.isNetWorkAvailable()) {
                a.this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gAi.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gAi.showLoading();
                    a.this.kFM.bRc();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kFM = aVar;
        this.jvI = str;
        this.jvJ = str2;
        i(view, str3);
        TiebaStatic.log(new ar("c13872").v("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cWf() {
        if (this.kGa == null || !this.kGa.isShow()) {
            this.kGa = new ScreenTopToast(this.mPageContext.getPageActivity()).US(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).UU(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jvI);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.kGa.aR((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void i(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.kFY = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kFU = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kFV = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.kFV.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ap.setNavbarIconSrc(this.kFU, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.kFX = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.kFU.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kFX.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kFU.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.kFX.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.kFU.setLayoutParams(layoutParams2);
        this.kFU.setVisibility(0);
        this.kFU.setOnClickListener(this.kGc);
        this.kFR = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.kFR.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.kFR.setOverScrollMode(2);
        this.kFR.setOnSrollToBottomListener(this.gVR);
        ap.setBackgroundColor(this.kFR, R.color.CAM_X0204);
        this.kFS = new FroumBroadMajorHistoryAdapter(this.mPageContext.getPageActivity());
        this.kFS.a(this.kGb);
        this.kFR.setAdapter(this.kFS);
        this.gAi = new PbListView(this.mPageContext.getPageActivity());
        this.gAi.getView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAi.setHeight(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.bud();
        this.gAi.setOnClickListener(this.iPk);
        if ("broadcast_publish_success".equals(str)) {
            cWh();
            int size = com.baidu.adp.base.b.kB().getSize();
            Activity aa = com.baidu.adp.base.b.kB().aa(size - 2);
            Activity aa2 = com.baidu.adp.base.b.kB().aa(size - 3);
            if (aa != null && aa2 != null && "FlutterPageActivity".equals(aa.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(aa2.getClass().getSimpleName())) {
                aa2.finish();
            }
        }
    }

    public void WX() {
        if (this.gAi != null && this.kFM != null) {
            if (j.isNetWorkAvailable()) {
                this.kFR.setNextPage(this.gAi);
                this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gAi.setOnClickListener(null);
                if (this.hasMore) {
                    this.gAi.showLoading();
                    this.kFM.bRc();
                    return;
                }
                this.gAi.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.gAi.endLoadData();
                return;
            }
            this.kFR.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cVT() != null) {
            if (!y.isEmpty(aVar.cVT()) && StringUtils.isEmpty(this.jvI)) {
                b bVar = aVar.cVT().get(0);
                if (bVar.cWa() != null) {
                    this.jvI = bVar.cWa().forum_id + "";
                }
            }
            this.hasMore = aVar.cVS();
            if (aVar.bJE()) {
                if (!y.isEmpty(aVar.cVT())) {
                    this.kFT.clear();
                    this.kFT.addAll(aVar.cVT());
                }
            } else if (!y.isEmpty(aVar.cVT())) {
                this.kFT.addAll(aVar.cVT());
            }
            this.kFS.ey(this.kFT);
            if (aVar.bJE() && this.kFR != null && this.kFR.getChildCount() > 0) {
                this.kFR.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.kFW == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.kFW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kGd);
                ap.a((View) this.kFW, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cWc() >= forumBroadcastMajorResidueData.cWd()) {
                this.kFZ = true;
                this.kFW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kGe);
                ap.a((View) this.kFW, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.kFW.setAlpha(0.33f);
            } else {
                this.kFW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kGd);
                ap.a((View) this.kFW, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ap.setBackgroundColor(this.kFR, R.color.CAM_X0204);
        this.gAi.changeSkin(i);
        this.kFS.notifyDataSetChanged();
    }

    public void aQ(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.kFM != null) {
                            a.this.WZ();
                            a.this.kFM.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.kFY, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kFY);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWg() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nA(2);
        aVar.jG(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.mPageContext.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.bn(forumBroadcastMajorQuestionDialogView);
        aVar.b(this.mPageContext).bqx();
    }

    public void cWh() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).zn(true).UN(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aR((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.kFT = null;
        this.kGa = null;
    }
}
