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
    private com.baidu.tbadk.k.f bKv;
    private int bNm;
    private PbListView bOy;
    private j.b bVy;
    private com.baidu.tieba.frs.gametab.b bYA;
    private c dTR;
    private int dTS;
    private com.baidu.tieba.frs.game.strategy.tab.a dTo;
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
                bb ZR;
                com.baidu.tieba.frs.game.strategy.tab.e mE;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (ZR = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).ZR()) != null) {
                    if (FrsGameStrategyItemListView.this.dTo != null && (mE = FrsGameStrategyItemListView.this.dTo.mE(FrsGameStrategyItemListView.this.bNm)) != null && (mE.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) mE.extra).getLabelName(FrsGameStrategyItemListView.this.dTS);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new am("c12388").aA(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.dTo.getForumId()).aA("tid", ZR.getId()).aA(VideoPlayActivityConfig.OBJ_ID, mE.tabName).aA("obj_locate", labelName));
                    }
                    if (ZR.As() == null || ZR.As().getGroup_id() == 0 || ba.bJ(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (ZR.Ak() != 1 || ba.bJ(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.vR(ZR.getId())) {
                                readThreadHistory.vQ(ZR.getId());
                                FrsGameStrategyItemListView.this.dTR.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String zO = ZR.zO();
                            if (zO != null && !zO.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(zO);
                                        xVar.Dj().Eh().mIsNeedAddCommenParam = false;
                                        xVar.Dj().Eh().mIsUseCurrentBDUSS = false;
                                        xVar.CM();
                                    }
                                }).start();
                            }
                            String tid = ZR.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (ZR.zB() == 2 && !tid.startsWith("pb:")) {
                                ay.Ef().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                ZR.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(ZR, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(ZR.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.bVy = new j.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
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
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.dTo != null) {
                    FrsGameStrategyItemListView.this.dTo.aO(FrsGameStrategyItemListView.this.bNm, FrsGameStrategyItemListView.this.dTS);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.bYA != null) {
                    FrsGameStrategyItemListView.this.bYA.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dTR = new c(this.mPageContext, this.mListView);
        this.dTR.b(this.mAdapterItemClickListener);
        this.mPullView = new k(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.bVy);
        this.bYA = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.bOy == null) {
            this.bOy = new PbListView(this.mPageContext.getPageActivity());
            this.bOy.oD();
        }
        this.bOy.ex(e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bNm && i2 == this.dTS)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.I(list) && v.I(this.mData)) {
                oo(getContext().getString(e.j.no_data_text));
                abb();
                this.mHasMore = false;
                return;
            }
            if (!v.I(list)) {
                this.mData = list;
            }
            this.dTR.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                aaZ();
            } else {
                aba();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bNm && i2 == this.dTS)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.I(this.mData)) {
                oo(str);
                abb();
                return;
            }
            this.mPageContext.showToast(str);
            aba();
        }
    }

    private void aaZ() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.bOy);
        this.bOy.Fc();
    }

    private void aba() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.bOy);
        this.bOy.Fd();
        this.bOy.setText(this.mPageContext.getResources().getString(e.j.list_no_more));
    }

    private void abb() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void oo(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0210e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(e.C0210e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.gn(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(e.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.bKv == null) {
            this.bKv = new com.baidu.tbadk.k.f(getContext(), getContext().getResources().getDimensionPixelSize(e.C0210e.ds120));
            this.bKv.onChangeSkinType();
        }
        this.bKv.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.bKv != null) {
            this.bKv.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dTo != null) {
            this.dTo.aN(this.bNm, this.dTS);
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
        this.dTo = aVar;
    }

    public void aT(int i, int i2) {
        this.bNm = i;
        this.dTS = i2;
        abb();
        this.mData = new LinkedList();
        this.dTR.setData(this.mData);
        this.dTo.aP(i, i2);
    }

    public void aEH() {
        if (v.I(this.mData) && (this.bNm != 0 || this.dTS != 0)) {
            showLoadingView();
            this.dTo.aN(this.bNm, this.dTS);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bNm;
    }

    public int getLabelId() {
        return this.dTS;
    }

    public void onDestory() {
    }
}
