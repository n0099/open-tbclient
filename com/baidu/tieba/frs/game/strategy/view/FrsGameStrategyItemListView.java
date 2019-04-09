package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private com.baidu.tbadk.m.g cXq;
    private int dah;
    private h.c dbD;
    private PbListView dbs;
    private com.baidu.tieba.frs.gametab.b dor;
    private c fkD;
    private int fkE;
    private com.baidu.tieba.frs.game.strategy.tab.a fka;
    private s mAdapterItemClickListener;
    private List<m> mData;
    private boolean mHasMore;
    private BdTypeListView mListView;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private i mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.mAdapterItemClickListener = new s() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bg WO;
                com.baidu.tieba.frs.game.strategy.tab.e qB;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (WO = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).WO()) != null) {
                    if (FrsGameStrategyItemListView.this.fka != null && (qB = FrsGameStrategyItemListView.this.fka.qB(FrsGameStrategyItemListView.this.dah)) != null && (qB.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) qB.extra).getLabelName(FrsGameStrategyItemListView.this.fkE);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new am("c12388").bJ(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.fka.getForumId()).bJ("tid", WO.getId()).bJ(VideoPlayActivityConfig.OBJ_ID, qB.tabName).bJ("obj_locate", labelName));
                    }
                    if (WO.ZG() == null || WO.ZG().getGroup_id() == 0 || bc.cZ(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (WO.Zy() != 1 || bc.cZ(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.CM(WO.getId())) {
                                readThreadHistory.CL(WO.getId());
                                FrsGameStrategyItemListView.this.fkD.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String YV = WO.YV();
                            if (YV != null && !YV.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(YV);
                                        xVar.acE().adC().mIsNeedAddCommenParam = false;
                                        xVar.acE().adC().mIsUseCurrentBDUSS = false;
                                        xVar.ach();
                                    }
                                }).start();
                            }
                            String tid = WO.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (WO.YJ() == 2 && !tid.startsWith("pb:")) {
                                ba.adA().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                WO.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(WO, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(WO.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.dbD = new h.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(al.getColor(d.C0277d.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(d.e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(d.f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.fka != null) {
                    FrsGameStrategyItemListView.this.fka.bk(FrsGameStrategyItemListView.this.dah, FrsGameStrategyItemListView.this.fkE);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.dor != null) {
                    FrsGameStrategyItemListView.this.dor.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.fkD = new c(this.mPageContext, this.mListView);
        this.fkD.a(this.mAdapterItemClickListener);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.dbD);
        this.dor = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.dbs == null) {
            this.dbs = new PbListView(this.mPageContext.getPageActivity());
            this.dbs.oM();
        }
        this.dbs.ia(d.C0277d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.dah && i2 == this.fkE)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.T(list) && v.T(this.mData)) {
                vj(getContext().getString(d.j.no_data_text));
                aCt();
                this.mHasMore = false;
                return;
            }
            if (!v.T(list)) {
                this.mData = list;
            }
            this.fkD.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                aCr();
            } else {
                aCs();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void e(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.dah && i2 == this.fkE)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.T(this.mData)) {
                vj(str);
                aCt();
                return;
            }
            this.mPageContext.showToast(str);
            aCs();
        }
    }

    private void aCr() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.dbs);
        this.dbs.aez();
    }

    private void aCs() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.dbs);
        this.dbs.aeA();
        this.dbs.setText(this.mPageContext.getResources().getString(d.j.list_no_more));
    }

    private void aCt() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void vj(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.np(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(d.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.cXq == null) {
            this.cXq = new com.baidu.tbadk.m.g(getContext(), getContext().getResources().getDimensionPixelSize(d.e.ds120));
            this.cXq.onChangeSkinType();
        }
        this.cXq.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.cXq != null) {
            this.cXq.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.fka != null) {
            this.fka.bj(this.dah, this.fkE);
        }
    }

    public void pullToRefresh() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mListView, d.C0277d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.fka = aVar;
    }

    public void bp(int i, int i2) {
        this.dah = i;
        this.fkE = i2;
        aCt();
        this.mData = new LinkedList();
        this.fkD.setData(this.mData);
        this.fka.bl(i, i2);
    }

    public void bgj() {
        if (v.T(this.mData) && (this.dah != 0 || this.fkE != 0)) {
            showLoadingView();
            this.fka.bj(this.dah, this.fkE);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.dah;
    }

    public int getLabelId() {
        return this.fkE;
    }

    public void onDestory() {
    }
}
