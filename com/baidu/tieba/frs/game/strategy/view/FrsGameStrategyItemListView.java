package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private g.b bBV;
    private com.baidu.tieba.frs.gametab.b bEN;
    private com.baidu.tbadk.j.f bqL;
    private int btG;
    private PbListView buU;
    private c duR;
    private int duS;
    private com.baidu.tieba.frs.game.strategy.tab.a duo;
    private n mAdapterItemClickListener;
    private List<h> mData;
    private boolean mHasMore;
    private BdTypeListView mListView;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.h mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.mAdapterItemClickListener = new n() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bc SV;
                com.baidu.tieba.frs.game.strategy.tab.e kM;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (SV = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).SV()) != null) {
                    if (FrsGameStrategyItemListView.this.duo != null && (kM = FrsGameStrategyItemListView.this.duo.kM(FrsGameStrategyItemListView.this.btG)) != null && (kM.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) kM.extra).getLabelName(FrsGameStrategyItemListView.this.duS);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").ah(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.duo.getForumId()).ah("tid", SV.getId()).ah(VideoPlayActivityConfig.OBJ_ID, kM.tabName).ah("obj_locate", labelName));
                    }
                    if (SV.wf() == null || SV.wf().getGroup_id() == 0 || bb.aU(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (SV.vY() != 1 || bb.aU(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.ua(SV.getId())) {
                                readThreadHistory.tZ(SV.getId());
                                FrsGameStrategyItemListView.this.duR.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String vD = SV.vD();
                            if (vD != null && !vD.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        y yVar = new y(vD);
                                        yVar.yX().zX().mIsNeedAddCommenParam = false;
                                        yVar.yX().zX().mIsUseCurrentBDUSS = false;
                                        yVar.yA();
                                    }
                                }).start();
                            }
                            String tid = SV.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (SV.vr() == 2 && !tid.startsWith("pb:")) {
                                az.zV().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                SV.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(SV, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(SV.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.bBV = new g.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.ad(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(am.getColor(d.C0142d.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(d.e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(d.f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.duo != null) {
                    FrsGameStrategyItemListView.this.duo.aD(FrsGameStrategyItemListView.this.btG, FrsGameStrategyItemListView.this.duS);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.bEN != null) {
                    FrsGameStrategyItemListView.this.bEN.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.duR = new c(this.mPageContext, this.mListView);
        this.duR.b(this.mAdapterItemClickListener);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.bBV);
        this.bEN = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.buU == null) {
            this.buU = new PbListView(this.mPageContext.getPageActivity());
            this.buU.nn();
        }
        this.buU.dy(d.C0142d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.btG && i2 == this.duS)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (w.A(list) && w.A(this.mData)) {
                mG(getContext().getString(d.k.no_data_text));
                Uf();
                this.mHasMore = false;
                return;
            }
            if (!w.A(list)) {
                this.mData = list;
            }
            this.duR.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                Ud();
            } else {
                Ue();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.btG && i2 == this.duS)) {
            this.mHasMore = false;
            hideLoadingView();
            if (w.A(this.mData)) {
                mG(str);
                Uf();
                return;
            }
            this.mPageContext.showToast(str);
            Ue();
        }
    }

    private void Ud() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.buU);
        this.buU.AH();
    }

    private void Ue() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.buU);
        this.buU.AI();
        this.buU.setText(this.mPageContext.getResources().getString(d.k.list_no_more));
    }

    private void Uf() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void mG(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.fo(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(d.k.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrsGameStrategyItemListView.this.refresh();
                }
            }), getResources().getDimensionPixelSize(d.e.ds20)));
        }
        this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.bringToFront();
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void showLoadingView() {
        if (this.bqL == null) {
            this.bqL = new com.baidu.tbadk.j.f(getContext(), getContext().getResources().getDimensionPixelSize(d.e.ds120));
            this.bqL.onChangeSkinType();
        }
        this.bqL.d(this, false);
    }

    private void hideLoadingView() {
        if (this.bqL != null) {
            this.bqL.Q(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.duo != null) {
            this.duo.aC(this.btG, this.duS);
        }
    }

    public void nV() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.j(this.mListView, d.C0142d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.duo = aVar;
    }

    public void aI(int i, int i2) {
        this.btG = i;
        this.duS = i2;
        Uf();
        this.mData = new LinkedList();
        this.duR.setData(this.mData);
        this.duo.aE(i, i2);
    }

    public void axp() {
        if (w.A(this.mData) && (this.btG != 0 || this.duS != 0)) {
            showLoadingView();
            this.duo.aC(this.btG, this.duS);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.btG;
    }

    public int getLabelId() {
        return this.duS;
    }

    public void onDestory() {
    }
}
