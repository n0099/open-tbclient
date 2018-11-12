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
    private com.baidu.tbadk.k.f bGG;
    private int bJx;
    private PbListView bKJ;
    private j.b bRH;
    private com.baidu.tieba.frs.gametab.b bUI;
    private com.baidu.tieba.frs.game.strategy.tab.a dML;
    private c dNo;
    private int dNp;
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
                bb YL;
                com.baidu.tieba.frs.game.strategy.tab.e mo;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (YL = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).YL()) != null) {
                    if (FrsGameStrategyItemListView.this.dML != null && (mo = FrsGameStrategyItemListView.this.dML.mo(FrsGameStrategyItemListView.this.bJx)) != null && (mo.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) mo.extra).getLabelName(FrsGameStrategyItemListView.this.dNp);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new am("c12388").ax(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.dML.getForumId()).ax("tid", YL.getId()).ax(VideoPlayActivityConfig.OBJ_ID, mo.tabName).ax("obj_locate", labelName));
                    }
                    if (YL.zo() == null || YL.zo().getGroup_id() == 0 || ba.bG(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (YL.zg() != 1 || ba.bG(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.vq(YL.getId())) {
                                readThreadHistory.vp(YL.getId());
                                FrsGameStrategyItemListView.this.dNo.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String yK = YL.yK();
                            if (yK != null && !yK.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(yK);
                                        xVar.Cf().Dd().mIsNeedAddCommenParam = false;
                                        xVar.Cf().Dd().mIsUseCurrentBDUSS = false;
                                        xVar.BI();
                                    }
                                }).start();
                            }
                            String tid = YL.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (YL.yx() == 2 && !tid.startsWith("pb:")) {
                                ay.Db().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                YL.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(YL, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(YL.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.bRH = new j.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
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
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(e.C0200e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(e.f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.dML != null) {
                    FrsGameStrategyItemListView.this.dML.aO(FrsGameStrategyItemListView.this.bJx, FrsGameStrategyItemListView.this.dNp);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.bUI != null) {
                    FrsGameStrategyItemListView.this.bUI.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dNo = new c(this.mPageContext, this.mListView);
        this.dNo.b(this.mAdapterItemClickListener);
        this.mPullView = new k(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.bRH);
        this.bUI = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.bKJ == null) {
            this.bKJ = new PbListView(this.mPageContext.getPageActivity());
            this.bKJ.oE();
        }
        this.bKJ.ej(e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bJx && i2 == this.dNp)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.I(list) && v.I(this.mData)) {
                nN(getContext().getString(e.j.no_data_text));
                ZV();
                this.mHasMore = false;
                return;
            }
            if (!v.I(list)) {
                this.mData = list;
            }
            this.dNo.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                ZT();
            } else {
                ZU();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bJx && i2 == this.dNp)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.I(this.mData)) {
                nN(str);
                ZV();
                return;
            }
            this.mPageContext.showToast(str);
            ZU();
        }
    }

    private void ZT() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.bKJ);
        this.bKJ.DY();
    }

    private void ZU() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.bKJ);
        this.bKJ.DZ();
        this.bKJ.setText(this.mPageContext.getResources().getString(e.j.list_no_more));
    }

    private void ZV() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void nN(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0200e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0200e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(e.C0200e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.fV(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(e.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrsGameStrategyItemListView.this.refresh();
                }
            }), getResources().getDimensionPixelSize(e.C0200e.ds20)));
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
        if (this.bGG == null) {
            this.bGG = new com.baidu.tbadk.k.f(getContext(), getContext().getResources().getDimensionPixelSize(e.C0200e.ds120));
            this.bGG.onChangeSkinType();
        }
        this.bGG.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.bGG != null) {
            this.bGG.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dML != null) {
            this.dML.aN(this.bJx, this.dNp);
        }
    }

    public void pullToRefresh() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, e.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.dML = aVar;
    }

    public void aT(int i, int i2) {
        this.bJx = i;
        this.dNp = i2;
        ZV();
        this.mData = new LinkedList();
        this.dNo.setData(this.mData);
        this.dML.aP(i, i2);
    }

    public void aCV() {
        if (v.I(this.mData) && (this.bJx != 0 || this.dNp != 0)) {
            showLoadingView();
            this.dML.aN(this.bJx, this.dNp);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bJx;
    }

    public int getLabelId() {
        return this.dNp;
    }

    public void onDestory() {
    }
}
