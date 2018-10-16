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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private com.baidu.tbadk.k.f bFV;
    private int bIM;
    private PbListView bJY;
    private j.b bQW;
    private com.baidu.tieba.frs.gametab.b bTU;
    private com.baidu.tieba.frs.game.strategy.tab.a dLH;
    private c dMk;
    private int dMl;
    private n mAdapterItemClickListener;
    private List<h> mData;
    private boolean mHasMore;
    private BdTypeListView mListView;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private k mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.mAdapterItemClickListener = new n() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bb YA;
                com.baidu.tieba.frs.game.strategy.tab.e lX;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (YA = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).YA()) != null) {
                    if (FrsGameStrategyItemListView.this.dLH != null && (lX = FrsGameStrategyItemListView.this.dLH.lX(FrsGameStrategyItemListView.this.bIM)) != null && (lX.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) lX.extra).getLabelName(FrsGameStrategyItemListView.this.dMl);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new am("c12388").ax(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.dLH.getForumId()).ax("tid", YA.getId()).ax(VideoPlayActivityConfig.OBJ_ID, lX.tabName).ax("obj_locate", labelName));
                    }
                    if (YA.zh() == null || YA.zh().getGroup_id() == 0 || ba.bI(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (YA.yZ() != 1 || ba.bI(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.vl(YA.getId())) {
                                readThreadHistory.vk(YA.getId());
                                FrsGameStrategyItemListView.this.dMk.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String yD = YA.yD();
                            if (yD != null && !yD.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(yD);
                                        xVar.BY().CW().mIsNeedAddCommenParam = false;
                                        xVar.BY().CW().mIsUseCurrentBDUSS = false;
                                        xVar.BB();
                                    }
                                }).start();
                            }
                            String tid = YA.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (YA.yq() == 2 && !tid.startsWith("pb:")) {
                                ay.CU().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                YA.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(YA, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(YA.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.bQW = new j.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.aK(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(al.getColor(e.d.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(e.C0175e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(e.f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.dLH != null) {
                    FrsGameStrategyItemListView.this.dLH.aN(FrsGameStrategyItemListView.this.bIM, FrsGameStrategyItemListView.this.dMl);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.bTU != null) {
                    FrsGameStrategyItemListView.this.bTU.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dMk = new c(this.mPageContext, this.mListView);
        this.dMk.b(this.mAdapterItemClickListener);
        this.mPullView = new k(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.bQW);
        this.bTU = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.bJY == null) {
            this.bJY = new PbListView(this.mPageContext.getPageActivity());
            this.bJY.oG();
        }
        this.bJY.dV(e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bIM && i2 == this.dMl)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.J(list) && v.J(this.mData)) {
                nM(getContext().getString(e.j.no_data_text));
                ZK();
                this.mHasMore = false;
                return;
            }
            if (!v.J(list)) {
                this.mData = list;
            }
            this.dMk.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                ZI();
            } else {
                ZJ();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bIM && i2 == this.dMl)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.J(this.mData)) {
                nM(str);
                ZK();
                return;
            }
            this.mPageContext.showToast(str);
            ZJ();
        }
    }

    private void ZI() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.bJY);
        this.bJY.DO();
    }

    private void ZJ() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.bJY);
        this.bJY.DP();
        this.bJY.setText(this.mPageContext.getResources().getString(e.j.list_no_more));
    }

    private void ZK() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void nM(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0175e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(e.C0175e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.fU(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(e.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrsGameStrategyItemListView.this.refresh();
                }
            }), getResources().getDimensionPixelSize(e.C0175e.ds20)));
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
        if (this.bFV == null) {
            this.bFV = new com.baidu.tbadk.k.f(getContext(), getContext().getResources().getDimensionPixelSize(e.C0175e.ds120));
            this.bFV.onChangeSkinType();
        }
        this.bFV.c(this, false);
    }

    private void hideLoadingView() {
        if (this.bFV != null) {
            this.bFV.ad(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dLH != null) {
            this.dLH.aM(this.bIM, this.dMl);
        }
    }

    public void pullToRefresh() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, e.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.dLH = aVar;
    }

    public void aS(int i, int i2) {
        this.bIM = i;
        this.dMl = i2;
        ZK();
        this.mData = new LinkedList();
        this.dMk.setData(this.mData);
        this.dLH.aO(i, i2);
    }

    public void aDA() {
        if (v.J(this.mData) && (this.bIM != 0 || this.dMl != 0)) {
            showLoadingView();
            this.dLH.aM(this.bIM, this.dMl);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bIM;
    }

    public int getLabelId() {
        return this.dMl;
    }

    public void onDestory() {
    }
}
