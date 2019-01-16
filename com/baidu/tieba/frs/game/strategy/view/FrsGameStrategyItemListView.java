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
    private com.baidu.tbadk.k.f bLl;
    private int bOb;
    private PbListView bPm;
    private j.b bWm;
    private com.baidu.tieba.frs.gametab.b bZo;
    private com.baidu.tieba.frs.game.strategy.tab.a dWL;
    private c dXo;
    private int dXp;
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
                bb aaq;
                com.baidu.tieba.frs.game.strategy.tab.e mS;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (aaq = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).aaq()) != null) {
                    if (FrsGameStrategyItemListView.this.dWL != null && (mS = FrsGameStrategyItemListView.this.dWL.mS(FrsGameStrategyItemListView.this.bOb)) != null && (mS.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) mS.extra).getLabelName(FrsGameStrategyItemListView.this.dXp);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new am("c12388").aB(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.dWL.getForumId()).aB("tid", aaq.getId()).aB(VideoPlayActivityConfig.OBJ_ID, mS.tabName).aB("obj_locate", labelName));
                    }
                    if (aaq.AF() == null || aaq.AF().getGroup_id() == 0 || ba.bJ(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (aaq.Ax() != 1 || ba.bJ(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.wk(aaq.getId())) {
                                readThreadHistory.wj(aaq.getId());
                                FrsGameStrategyItemListView.this.dXo.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String Ab = aaq.Ab();
                            if (Ab != null && !Ab.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(Ab);
                                        xVar.Dw().Eu().mIsNeedAddCommenParam = false;
                                        xVar.Dw().Eu().mIsUseCurrentBDUSS = false;
                                        xVar.CZ();
                                    }
                                }).start();
                            }
                            String tid = aaq.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (aaq.zO() == 2 && !tid.startsWith("pb:")) {
                                ay.Es().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                aaq.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(aaq, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(aaq.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.bWm = new j.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
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
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(e.C0210e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(e.f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.dWL != null) {
                    FrsGameStrategyItemListView.this.dWL.aP(FrsGameStrategyItemListView.this.bOb, FrsGameStrategyItemListView.this.dXp);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.bZo != null) {
                    FrsGameStrategyItemListView.this.bZo.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dXo = new c(this.mPageContext, this.mListView);
        this.dXo.b(this.mAdapterItemClickListener);
        this.mPullView = new k(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.bWm);
        this.bZo = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.bPm == null) {
            this.bPm = new PbListView(this.mPageContext.getPageActivity());
            this.bPm.oH();
        }
        this.bPm.ex(e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bOb && i2 == this.dXp)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.I(list) && v.I(this.mData)) {
                oH(getContext().getString(e.j.no_data_text));
                abA();
                this.mHasMore = false;
                return;
            }
            if (!v.I(list)) {
                this.mData = list;
            }
            this.dXo.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                aby();
            } else {
                abz();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bOb && i2 == this.dXp)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.I(this.mData)) {
                oH(str);
                abA();
                return;
            }
            this.mPageContext.showToast(str);
            abz();
        }
    }

    private void aby() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.bPm);
        this.bPm.Fp();
    }

    private void abz() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.bPm);
        this.bPm.Fq();
        this.bPm.setText(this.mPageContext.getResources().getString(e.j.list_no_more));
    }

    private void abA() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void oH(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0210e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(e.C0210e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.gC(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(e.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrsGameStrategyItemListView.this.refresh();
                }
            }), getResources().getDimensionPixelSize(e.C0210e.ds20)));
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
        if (this.bLl == null) {
            this.bLl = new com.baidu.tbadk.k.f(getContext(), getContext().getResources().getDimensionPixelSize(e.C0210e.ds120));
            this.bLl.onChangeSkinType();
        }
        this.bLl.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.bLl != null) {
            this.bLl.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dWL != null) {
            this.dWL.aO(this.bOb, this.dXp);
        }
    }

    public void pullToRefresh() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, e.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.dWL = aVar;
    }

    public void aU(int i, int i2) {
        this.bOb = i;
        this.dXp = i2;
        abA();
        this.mData = new LinkedList();
        this.dXo.setData(this.mData);
        this.dWL.aQ(i, i2);
    }

    public void aFT() {
        if (v.I(this.mData) && (this.bOb != 0 || this.dXp != 0)) {
            showLoadingView();
            this.dWL.aO(this.bOb, this.dXp);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bOb;
    }

    public int getLabelId() {
        return this.dXp;
    }

    public void onDestory() {
    }
}
