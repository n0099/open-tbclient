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
/* loaded from: classes7.dex */
public class a {
    private PbListView gxy;
    private boolean hasMore;
    private String jqc;
    private String jqd;
    private final com.baidu.tieba.im.forum.broadcast.a kxG;
    private BdRecyclerView kxL;
    private FroumBroadMajorHistoryAdapter kxM;
    private ImageView kxO;
    private LinearLayout kxP;
    private TextView kxQ;
    private TextView kxR;
    private RelativeLayout kxS;
    private boolean kxT;
    private ScreenTopToast kxU;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private List<b> kxN = new ArrayList();
    private BdListView.e gTh = new BdListView.e() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.kxL != null) {
                a.this.kxL.stopScroll();
            }
            a.this.Vo();
        }
    };
    private f<b> kxV = new f<b>() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, b bVar, int i, long j) {
            if (bVar != null) {
                TiebaStatic.log(new aq("c13875").w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("fid", a.this.jqc).w("tid", bVar.cUd() != null ? bVar.cUd().tid.longValue() : 0L));
                if (view.getId() == R.id.forum_fail_edit) {
                    if (!k.isFastDoubleClick()) {
                        if (a.this.kxT) {
                            a.this.cUh();
                            return;
                        }
                        o oVar = new o(a.this.mPageContext.getPageActivity());
                        oVar.b(bVar.cUb() + "", a.this.jqd, a.this.jqc, bVar.cUd() != null ? bVar.cUd().tid + "" : "", bVar.getTitle(), bVar.getContent(), bVar.getPicUrl(), "failed_broadcast", "2");
                        oVar.start();
                    }
                } else if (bVar.cUd() == null || bVar.cUd().is_deleted.intValue() == 1) {
                    new BdTopToast(a.this.mPageContext.getPageActivity()).yS(false).TQ(a.this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).aR((ViewGroup) a.this.mRootView.findViewById(R.id.forum_major_history));
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.mPageContext.getPageActivity());
                    pbActivityConfig.createNormalCfg(bVar.cUd().tid + "", null, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, b bVar, int i, long j) {
        }
    };
    private View.OnClickListener kxW = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13873").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.cUi();
        }
    };
    private View.OnClickListener kxX = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isFastDoubleClick()) {
                o oVar = new o(a.this.mPageContext.getPageActivity());
                oVar.an(a.this.jqc, a.this.jqd, "2");
                oVar.start();
                TiebaStatic.log(new aq("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    };
    private View.OnClickListener kxY = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13874").w("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (!k.isFastDoubleClick()) {
                a.this.cUh();
            }
        }
    };
    private View.OnClickListener iJC = new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kxL != null) {
                a.this.kxL.stopScroll();
            }
            if (a.this.gxy != null && a.this.kxG != null && j.isNetWorkAvailable()) {
                a.this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gxy.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gxy.showLoading();
                    a.this.kxG.bQy();
                }
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.im.forum.broadcast.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kxG = aVar;
        this.jqc = str;
        this.jqd = str2;
        h(view, str3);
        TiebaStatic.log(new aq("c13872").w("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void cUh() {
        if (this.kxU == null || !this.kxU.isShow()) {
            this.kxU = new ScreenTopToast(this.mPageContext.getPageActivity()).TU(this.mPageContext.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).TW(this.mPageContext.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", a.this.jqc);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.mPageContext.getPageActivity(), "ForumGradePage", hashMap)));
                }
            });
            this.kxU.aR((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.kxS = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kxO = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kxP = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        this.kxP.setGravity(16);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ao.setNavbarIconSrc(this.kxO, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        this.mNavigationBar.showBottomLine();
        this.kxR = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.subscribe_bar_title));
        this.kxO.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kxR.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kxO.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = 0;
        this.kxR.setLayoutParams(layoutParams);
        layoutParams2.width = dimens2 + dimens + dimens;
        layoutParams2.height = dimens2 + dimens + dimens;
        this.kxO.setLayoutParams(layoutParams2);
        this.kxO.setVisibility(0);
        this.kxO.setOnClickListener(this.kxW);
        this.kxL = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.kxL.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.kxL.setOverScrollMode(2);
        this.kxL.setOnSrollToBottomListener(this.gTh);
        ao.setBackgroundColor(this.kxL, R.color.CAM_X0204);
        this.kxM = new FroumBroadMajorHistoryAdapter(this.mPageContext.getPageActivity());
        this.kxM.a(this.kxV);
        this.kxL.setAdapter(this.kxM);
        this.gxy = new PbListView(this.mPageContext.getPageActivity());
        this.gxy.getView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.btJ();
        this.gxy.setOnClickListener(this.iJC);
        if ("broadcast_publish_success".equals(str)) {
            cUj();
            int size = com.baidu.adp.base.b.kC().getSize();
            Activity aa = com.baidu.adp.base.b.kC().aa(size - 2);
            Activity aa2 = com.baidu.adp.base.b.kC().aa(size - 3);
            if (aa != null && aa2 != null && "FlutterPageActivity".equals(aa.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(aa2.getClass().getSimpleName())) {
                aa2.finish();
            }
        }
    }

    public void Vo() {
        if (this.gxy != null && this.kxG != null) {
            if (j.isNetWorkAvailable()) {
                this.kxL.setNextPage(this.gxy);
                this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gxy.setOnClickListener(null);
                if (this.hasMore) {
                    this.gxy.showLoading();
                    this.kxG.bQy();
                    return;
                }
                this.gxy.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
                this.gxy.endLoadData();
                return;
            }
            this.kxL.setNextPage(null);
        }
    }

    public void b(com.baidu.tieba.im.forum.broadcast.data.a aVar) {
        if (aVar != null && aVar.cTV() != null) {
            if (!x.isEmpty(aVar.cTV()) && StringUtils.isEmpty(this.jqc)) {
                b bVar = aVar.cTV().get(0);
                if (bVar.cUc() != null) {
                    this.jqc = bVar.cUc().forum_id + "";
                }
            }
            this.hasMore = aVar.cTU();
            if (aVar.bJk()) {
                if (!x.isEmpty(aVar.cTV())) {
                    this.kxN.clear();
                    this.kxN.addAll(aVar.cTV());
                }
            } else if (!x.isEmpty(aVar.cTV())) {
                this.kxN.addAll(aVar.cTV());
            }
            this.kxM.eA(this.kxN);
            if (aVar.bJk() && this.kxL != null && this.kxL.getChildCount() > 0) {
                this.kxL.scrollToPosition(0);
            }
        }
    }

    public void b(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.kxQ == null) {
            if (forumBroadcastMajorResidueData == null) {
                this.kxQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kxX);
                ao.a((View) this.kxQ, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.cUe() >= forumBroadcastMajorResidueData.cUf()) {
                this.kxT = true;
                this.kxQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kxY);
                ao.a((View) this.kxQ, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.kxQ.setAlpha(0.33f);
            } else {
                this.kxQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getString(R.string.dynamic_publish), this.kxX);
                ao.a((View) this.kxQ, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        ao.setBackgroundColor(this.kxL, R.color.CAM_X0204);
        this.gxy.changeSkin(i);
        this.kxM.notifyDataSetChanged();
    }

    public void aR(String str, boolean z) {
        if (this.mRefreshView == null || !this.mRefreshView.isViewAttached()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.view.a.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && a.this.kxG != null) {
                            a.this.Vq();
                            a.this.kxG.refresh();
                        }
                    }
                });
            }
            this.mRefreshView.setSubText(null);
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.mRefreshView.attachView(this.kxS, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kxS);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUi() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nx(2);
        aVar.jE(false);
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
        aVar.b(this.mPageContext).bqe();
    }

    public void cUj() {
        if (this.mRootView != null) {
            new BdTopToast(this.mPageContext.getPageActivity()).yS(true).TQ(this.mPageContext.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).aR((ViewGroup) this.mRootView.findViewById(R.id.forum_major_history));
        }
    }

    public void onDestory() {
        this.kxN = null;
        this.kxU = null;
    }
}
