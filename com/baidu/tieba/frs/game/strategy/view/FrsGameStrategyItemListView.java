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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private g.b bCE;
    private com.baidu.tieba.frs.gametab.b bFD;
    private com.baidu.tbadk.k.f brv;
    private int bup;
    private PbListView bvC;
    private com.baidu.tieba.frs.game.strategy.tab.a dwY;
    private c dxB;
    private int dxC;
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
                bb Tg;
                com.baidu.tieba.frs.game.strategy.tab.e kW;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (Tg = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).Tg()) != null) {
                    if (FrsGameStrategyItemListView.this.dwY != null && (kW = FrsGameStrategyItemListView.this.dwY.kW(FrsGameStrategyItemListView.this.bup)) != null && (kW.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) kW.extra).getLabelName(FrsGameStrategyItemListView.this.dxC);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").ae(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.dwY.getForumId()).ae("tid", Tg.getId()).ae(VideoPlayActivityConfig.OBJ_ID, kW.tabName).ae("obj_locate", labelName));
                    }
                    if (Tg.vT() == null || Tg.vT().getGroup_id() == 0 || com.baidu.tbadk.core.util.bb.aU(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (Tg.vM() != 1 || com.baidu.tbadk.core.util.bb.aU(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.uc(Tg.getId())) {
                                readThreadHistory.ub(Tg.getId());
                                FrsGameStrategyItemListView.this.dxB.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String vr = Tg.vr();
                            if (vr != null && !vr.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        y yVar = new y(vr);
                                        yVar.yM().zK().mIsNeedAddCommenParam = false;
                                        yVar.yM().zK().mIsUseCurrentBDUSS = false;
                                        yVar.yp();
                                    }
                                }).start();
                            }
                            String tid = Tg.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (Tg.ve() == 2 && !tid.startsWith("pb:")) {
                                az.zI().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                Tg.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(Tg, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(Tg.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.bCE = new g.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.ad(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(am.getColor(f.d.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(f.e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(f.C0146f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.dwY != null) {
                    FrsGameStrategyItemListView.this.dwY.aG(FrsGameStrategyItemListView.this.bup, FrsGameStrategyItemListView.this.dxC);
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
        this.dxB = new c(this.mPageContext, this.mListView);
        this.dxB.b(this.mAdapterItemClickListener);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.bCE);
        this.bFD = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.bvC == null) {
            this.bvC = new PbListView(this.mPageContext.getPageActivity());
            this.bvC.np();
        }
        this.bvC.dA(f.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bup && i2 == this.dxC)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (w.z(list) && w.z(this.mData)) {
                mH(getContext().getString(f.j.no_data_text));
                Uq();
                this.mHasMore = false;
                return;
            }
            if (!w.z(list)) {
                this.mData = list;
            }
            this.dxB.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                Uo();
            } else {
                Up();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bup && i2 == this.dxC)) {
            this.mHasMore = false;
            hideLoadingView();
            if (w.z(this.mData)) {
                mH(str);
                Uq();
                return;
            }
            this.mPageContext.showToast(str);
            Up();
        }
    }

    private void Uo() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.bvC);
        this.bvC.Av();
    }

    private void Up() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.bvC);
        this.bvC.Aw();
        this.bvC.setText(this.mPageContext.getResources().getString(f.j.list_no_more));
    }

    private void Uq() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void mH(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(f.e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(f.e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(f.e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, f.C0146f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.fm(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(f.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrsGameStrategyItemListView.this.refresh();
                }
            }), getResources().getDimensionPixelSize(f.e.ds20)));
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
        if (this.brv == null) {
            this.brv = new com.baidu.tbadk.k.f(getContext(), getContext().getResources().getDimensionPixelSize(f.e.ds120));
            this.brv.onChangeSkinType();
        }
        this.brv.c(this, false);
    }

    private void hideLoadingView() {
        if (this.brv != null) {
            this.brv.Q(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dwY != null) {
            this.dwY.aF(this.bup, this.dxC);
        }
    }

    public void pullToRefresh() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.j(this.mListView, f.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.dwY = aVar;
    }

    public void aL(int i, int i2) {
        this.bup = i;
        this.dxC = i2;
        Uq();
        this.mData = new LinkedList();
        this.dxB.setData(this.mData);
        this.dwY.aH(i, i2);
    }

    public void axS() {
        if (w.z(this.mData) && (this.bup != 0 || this.dxC != 0)) {
            showLoadingView();
            this.dwY.aF(this.bup, this.dxC);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bup;
    }

    public int getLabelId() {
        return this.dxC;
    }

    public void onDestory() {
    }
}
