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
    private com.baidu.tbadk.m.g cXm;
    private int dad;
    private PbListView dbn;
    private h.c dby;
    private com.baidu.tieba.frs.gametab.b don;
    private c fkR;
    private int fkS;
    private com.baidu.tieba.frs.game.strategy.tab.a fko;
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
                bg WR;
                com.baidu.tieba.frs.game.strategy.tab.e qF;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (WR = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).WR()) != null) {
                    if (FrsGameStrategyItemListView.this.fko != null && (qF = FrsGameStrategyItemListView.this.fko.qF(FrsGameStrategyItemListView.this.dad)) != null && (qF.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) qF.extra).getLabelName(FrsGameStrategyItemListView.this.fkS);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new am("c12388").bJ(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.fko.getForumId()).bJ("tid", WR.getId()).bJ(VideoPlayActivityConfig.OBJ_ID, qF.tabName).bJ("obj_locate", labelName));
                    }
                    if (WR.ZJ() == null || WR.ZJ().getGroup_id() == 0 || bc.cZ(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (WR.ZB() != 1 || bc.cZ(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.CN(WR.getId())) {
                                readThreadHistory.CM(WR.getId());
                                FrsGameStrategyItemListView.this.fkR.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String YY = WR.YY();
                            if (YY != null && !YY.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(YY);
                                        xVar.acH().adF().mIsNeedAddCommenParam = false;
                                        xVar.acH().adF().mIsUseCurrentBDUSS = false;
                                        xVar.ack();
                                    }
                                }).start();
                            }
                            String tid = WR.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (WR.YM() == 2 && !tid.startsWith("pb:")) {
                                ba.adD().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                WR.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(WR, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(WR.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.dby = new h.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.fko != null) {
                    FrsGameStrategyItemListView.this.fko.bk(FrsGameStrategyItemListView.this.dad, FrsGameStrategyItemListView.this.fkS);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.don != null) {
                    FrsGameStrategyItemListView.this.don.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.fkR = new c(this.mPageContext, this.mListView);
        this.fkR.a(this.mAdapterItemClickListener);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.dby);
        this.don = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.dbn == null) {
            this.dbn = new PbListView(this.mPageContext.getPageActivity());
            this.dbn.oM();
        }
        this.dbn.ib(d.C0277d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.dad && i2 == this.fkS)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.T(list) && v.T(this.mData)) {
                vk(getContext().getString(d.j.no_data_text));
                aCw();
                this.mHasMore = false;
                return;
            }
            if (!v.T(list)) {
                this.mData = list;
            }
            this.fkR.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                aCu();
            } else {
                aCv();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void e(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.dad && i2 == this.fkS)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.T(this.mData)) {
                vk(str);
                aCw();
                return;
            }
            this.mPageContext.showToast(str);
            aCv();
        }
    }

    private void aCu() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.dbn);
        this.dbn.aeC();
    }

    private void aCv() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.dbn);
        this.dbn.aeD();
        this.dbn.setText(this.mPageContext.getResources().getString(d.j.list_no_more));
    }

    private void aCw() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void vk(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.no(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(d.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.cXm == null) {
            this.cXm = new com.baidu.tbadk.m.g(getContext(), getContext().getResources().getDimensionPixelSize(d.e.ds120));
            this.cXm.onChangeSkinType();
        }
        this.cXm.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.cXm != null) {
            this.cXm.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.fko != null) {
            this.fko.bj(this.dad, this.fkS);
        }
    }

    public void pullToRefresh() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mListView, d.C0277d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.fko = aVar;
    }

    public void bp(int i, int i2) {
        this.dad = i;
        this.fkS = i2;
        aCw();
        this.mData = new LinkedList();
        this.fkR.setData(this.mData);
        this.fko.bl(i, i2);
    }

    public void bgl() {
        if (v.T(this.mData) && (this.dad != 0 || this.fkS != 0)) {
            showLoadingView();
            this.fko.bj(this.dad, this.fkS);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.dad;
    }

    public int getLabelId() {
        return this.fkS;
    }

    public void onDestory() {
    }
}
