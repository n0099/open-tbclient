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
    private com.baidu.tbadk.k.f bKy;
    private int bNp;
    private PbListView bOB;
    private j.b bVB;
    private com.baidu.tieba.frs.gametab.b bYD;
    private c dWI;
    private int dWJ;
    private com.baidu.tieba.frs.game.strategy.tab.a dWf;
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
                bb ZT;
                com.baidu.tieba.frs.game.strategy.tab.e mR;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (ZT = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).ZT()) != null) {
                    if (FrsGameStrategyItemListView.this.dWf != null && (mR = FrsGameStrategyItemListView.this.dWf.mR(FrsGameStrategyItemListView.this.bNp)) != null && (mR.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) mR.extra).getLabelName(FrsGameStrategyItemListView.this.dWJ);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new am("c12388").aA(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.dWf.getForumId()).aA("tid", ZT.getId()).aA(VideoPlayActivityConfig.OBJ_ID, mR.tabName).aA("obj_locate", labelName));
                    }
                    if (ZT.As() == null || ZT.As().getGroup_id() == 0 || ba.bJ(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (ZT.Ak() != 1 || ba.bJ(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.vU(ZT.getId())) {
                                readThreadHistory.vT(ZT.getId());
                                FrsGameStrategyItemListView.this.dWI.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String zO = ZT.zO();
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
                            String tid = ZT.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (ZT.zB() == 2 && !tid.startsWith("pb:")) {
                                ay.Ef().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                ZT.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(ZT, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(ZT.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.bVB = new j.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.dWf != null) {
                    FrsGameStrategyItemListView.this.dWf.aP(FrsGameStrategyItemListView.this.bNp, FrsGameStrategyItemListView.this.dWJ);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.bYD != null) {
                    FrsGameStrategyItemListView.this.bYD.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dWI = new c(this.mPageContext, this.mListView);
        this.dWI.b(this.mAdapterItemClickListener);
        this.mPullView = new k(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.bVB);
        this.bYD = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.bOB == null) {
            this.bOB = new PbListView(this.mPageContext.getPageActivity());
            this.bOB.oD();
        }
        this.bOB.ex(e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bNp && i2 == this.dWJ)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.I(list) && v.I(this.mData)) {
                or(getContext().getString(e.j.no_data_text));
                abd();
                this.mHasMore = false;
                return;
            }
            if (!v.I(list)) {
                this.mData = list;
            }
            this.dWI.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                abb();
            } else {
                abc();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bNp && i2 == this.dWJ)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.I(this.mData)) {
                or(str);
                abd();
                return;
            }
            this.mPageContext.showToast(str);
            abc();
        }
    }

    private void abb() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.bOB);
        this.bOB.Fc();
    }

    private void abc() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.bOB);
        this.bOB.Fd();
        this.bOB.setText(this.mPageContext.getResources().getString(e.j.list_no_more));
    }

    private void abd() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void or(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0210e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(e.C0210e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.go(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(e.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.bKy == null) {
            this.bKy = new com.baidu.tbadk.k.f(getContext(), getContext().getResources().getDimensionPixelSize(e.C0210e.ds120));
            this.bKy.onChangeSkinType();
        }
        this.bKy.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.bKy != null) {
            this.bKy.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dWf != null) {
            this.dWf.aO(this.bNp, this.dWJ);
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
        this.dWf = aVar;
    }

    public void aU(int i, int i2) {
        this.bNp = i;
        this.dWJ = i2;
        abd();
        this.mData = new LinkedList();
        this.dWI.setData(this.mData);
        this.dWf.aQ(i, i2);
    }

    public void aFw() {
        if (v.I(this.mData) && (this.bNp != 0 || this.dWJ != 0)) {
            showLoadingView();
            this.dWf.aO(this.bNp, this.dWJ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bNp;
    }

    public int getLabelId() {
        return this.dWJ;
    }

    public void onDestory() {
    }
}
