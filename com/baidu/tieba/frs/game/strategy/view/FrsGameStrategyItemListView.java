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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private com.baidu.tbadk.m.g dhX;
    private int dkO;
    private PbListView dlX;
    private h.c dmh;
    private com.baidu.tieba.frs.gametab.b dyW;
    private c fAY;
    private int fAZ;
    private com.baidu.tieba.frs.game.strategy.tab.a fAv;
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
                bg abv;
                com.baidu.tieba.frs.game.strategy.tab.e rJ;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (abv = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).abv()) != null) {
                    if (FrsGameStrategyItemListView.this.fAv != null && (rJ = FrsGameStrategyItemListView.this.fAv.rJ(FrsGameStrategyItemListView.this.dkO)) != null && (rJ.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) rJ.extra).getLabelName(FrsGameStrategyItemListView.this.fAZ);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new am("c12388").bT("fid", FrsGameStrategyItemListView.this.fAv.getForumId()).bT("tid", abv.getId()).bT(VideoPlayActivityConfig.OBJ_ID, rJ.tabName).bT("obj_locate", labelName));
                    }
                    if (abv.aen() == null || abv.aen().getGroup_id() == 0 || bc.cE(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (abv.aef() != 1 || bc.cE(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Ei(abv.getId())) {
                                readThreadHistory.Eh(abv.getId());
                                FrsGameStrategyItemListView.this.fAY.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String adC = abv.adC();
                            if (adC != null && !adC.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(adC);
                                        xVar.ahC().aiB().mIsNeedAddCommenParam = false;
                                        xVar.ahC().aiB().mIsUseCurrentBDUSS = false;
                                        xVar.ahf();
                                    }
                                }).start();
                            }
                            String tid = abv.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (abv.adq() == 2 && !tid.startsWith("pb:")) {
                                ba.aiz().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                abv.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(abv, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(abv.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.dmh = new h.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(al.getColor(R.color.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.fAv != null) {
                    FrsGameStrategyItemListView.this.fAv.br(FrsGameStrategyItemListView.this.dkO, FrsGameStrategyItemListView.this.fAZ);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.dyW != null) {
                    FrsGameStrategyItemListView.this.dyW.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.fAY = new c(this.mPageContext, this.mListView);
        this.fAY.a(this.mAdapterItemClickListener);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.dmh);
        this.dyW = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.dlX == null) {
            this.dlX = new PbListView(this.mPageContext.getPageActivity());
            this.dlX.nG();
        }
        this.dlX.iO(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.dkO && i2 == this.fAZ)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.aa(list) && v.aa(this.mData)) {
                uL(getContext().getString(R.string.no_data_text));
                aIG();
                this.mHasMore = false;
                return;
            }
            if (!v.aa(list)) {
                this.mData = list;
            }
            this.fAY.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                aIE();
            } else {
                aIF();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void f(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.dkO && i2 == this.fAZ)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.aa(this.mData)) {
                uL(str);
                aIG();
                return;
            }
            this.mPageContext.showToast(str);
            aIF();
        }
    }

    private void aIE() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.dlX);
        this.dlX.ajy();
    }

    private void aIF() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.dlX);
        this.dlX.ajz();
        this.dlX.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void aIG() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void uL(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.oz(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrsGameStrategyItemListView.this.refresh();
                }
            }), getResources().getDimensionPixelSize(R.dimen.ds20)));
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
        if (this.dhX == null) {
            this.dhX = new com.baidu.tbadk.m.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.dhX.onChangeSkinType();
        }
        this.dhX.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.dhX != null) {
            this.dhX.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.fAv != null) {
            this.fAv.bq(this.dkO, this.fAZ);
        }
    }

    public void pullToRefresh() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mListView, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.fAv = aVar;
    }

    public void bw(int i, int i2) {
        this.dkO = i;
        this.fAZ = i2;
        aIG();
        this.mData = new LinkedList();
        this.fAY.setData(this.mData);
        this.fAv.bs(i, i2);
    }

    public void bnA() {
        if (v.aa(this.mData) && (this.dkO != 0 || this.fAZ != 0)) {
            showLoadingView();
            this.fAv.bq(this.dkO, this.fAZ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.dkO;
    }

    public int getLabelId() {
        return this.fAZ;
    }

    public void onDestory() {
    }
}
