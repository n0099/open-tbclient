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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
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
    private g.b bCC;
    private com.baidu.tieba.frs.gametab.b bFD;
    private com.baidu.tbadk.k.f brt;
    private int bun;
    private PbListView bvA;
    private c dxE;
    private int dxF;
    private com.baidu.tieba.frs.game.strategy.tab.a dxb;
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
                bb Td;
                com.baidu.tieba.frs.game.strategy.tab.e kX;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (Td = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).Td()) != null) {
                    if (FrsGameStrategyItemListView.this.dxb != null && (kX = FrsGameStrategyItemListView.this.dxb.kX(FrsGameStrategyItemListView.this.bun)) != null && (kX.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) kX.extra).getLabelName(FrsGameStrategyItemListView.this.dxF);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").af(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.dxb.getForumId()).af("tid", Td.getId()).af(VideoPlayActivityConfig.OBJ_ID, kX.tabName).af("obj_locate", labelName));
                    }
                    if (Td.vU() == null || Td.vU().getGroup_id() == 0 || ba.aV(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (Td.vN() != 1 || ba.aV(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.tY(Td.getId())) {
                                readThreadHistory.tX(Td.getId());
                                FrsGameStrategyItemListView.this.dxE.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String vs = Td.vs();
                            if (vs != null && !vs.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        y yVar = new y(vs);
                                        yVar.yO().zM().mIsNeedAddCommenParam = false;
                                        yVar.yO().zM().mIsUseCurrentBDUSS = false;
                                        yVar.yr();
                                    }
                                }).start();
                            }
                            String tid = Td.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (Td.vf() == 2 && !tid.startsWith("pb:")) {
                                ay.zK().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                Td.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(Td, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(Td.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.bCC = new g.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.ad(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(am.getColor(d.C0140d.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(d.e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(d.f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.dxb != null) {
                    FrsGameStrategyItemListView.this.dxb.aG(FrsGameStrategyItemListView.this.bun, FrsGameStrategyItemListView.this.dxF);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.bFD != null) {
                    FrsGameStrategyItemListView.this.bFD.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dxE = new c(this.mPageContext, this.mListView);
        this.dxE.b(this.mAdapterItemClickListener);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.bCC);
        this.bFD = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.bvA == null) {
            this.bvA = new PbListView(this.mPageContext.getPageActivity());
            this.bvA.np();
        }
        this.bvA.dB(d.C0140d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bun && i2 == this.dxF)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (w.z(list) && w.z(this.mData)) {
                mF(getContext().getString(d.j.no_data_text));
                Un();
                this.mHasMore = false;
                return;
            }
            if (!w.z(list)) {
                this.mData = list;
            }
            this.dxE.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                Ul();
            } else {
                Um();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bun && i2 == this.dxF)) {
            this.mHasMore = false;
            hideLoadingView();
            if (w.z(this.mData)) {
                mF(str);
                Un();
                return;
            }
            this.mPageContext.showToast(str);
            Um();
        }
    }

    private void Ul() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.bvA);
        this.bvA.Ax();
    }

    private void Um() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.bvA);
        this.bvA.Ay();
        this.bvA.setText(this.mPageContext.getResources().getString(d.j.list_no_more));
    }

    private void Un() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void mF(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.fm(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(d.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.brt == null) {
            this.brt = new com.baidu.tbadk.k.f(getContext(), getContext().getResources().getDimensionPixelSize(d.e.ds120));
            this.brt.onChangeSkinType();
        }
        this.brt.c(this, false);
    }

    private void hideLoadingView() {
        if (this.brt != null) {
            this.brt.Q(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dxb != null) {
            this.dxb.aF(this.bun, this.dxF);
        }
    }

    public void nX() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.j(this.mListView, d.C0140d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.dxb = aVar;
    }

    public void aL(int i, int i2) {
        this.bun = i;
        this.dxF = i2;
        Un();
        this.mData = new LinkedList();
        this.dxE.setData(this.mData);
        this.dxb.aH(i, i2);
    }

    public void axU() {
        if (w.z(this.mData) && (this.bun != 0 || this.dxF != 0)) {
            showLoadingView();
            this.dxb.aF(this.bun, this.dxF);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bun;
    }

    public int getLabelId() {
        return this.dxF;
    }

    public void onDestory() {
    }
}
