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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
    private com.baidu.tieba.frs.gametab.b dEj;
    private com.baidu.tbadk.m.g dly;
    private int dor;
    private h.c dpL;
    private PbListView dpz;
    private com.baidu.tieba.frs.game.strategy.tab.a fHX;
    private c fIA;
    private int fIB;
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
                bh acC;
                com.baidu.tieba.frs.game.strategy.tab.e sh;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (acC = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).acC()) != null) {
                    if (FrsGameStrategyItemListView.this.fHX != null && (sh = FrsGameStrategyItemListView.this.fHX.sh(FrsGameStrategyItemListView.this.dor)) != null && (sh.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) sh.extra).getLabelName(FrsGameStrategyItemListView.this.fIB);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").bT("fid", FrsGameStrategyItemListView.this.fHX.getForumId()).bT("tid", acC.getId()).bT(VideoPlayActivityConfig.OBJ_ID, sh.tabName).bT("obj_locate", labelName));
                    }
                    if (acC.afu() == null || acC.afu().getGroup_id() == 0 || bc.cF(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (acC.afm() != 1 || bc.cF(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Fy(acC.getId())) {
                                readThreadHistory.Fx(acC.getId());
                                FrsGameStrategyItemListView.this.fIA.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aeJ = acC.aeJ();
                            if (aeJ != null && !aeJ.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aeJ);
                                        xVar.aiK().ajM().mIsNeedAddCommenParam = false;
                                        xVar.aiK().ajM().mIsUseCurrentBDUSS = false;
                                        xVar.ain();
                                    }
                                }).start();
                            }
                            String tid = acC.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (acC.aex() == 2 && !tid.startsWith("pb:")) {
                                ba.ajK().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                acC.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(acC, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(acC.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.dpL = new h.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.fHX != null) {
                    FrsGameStrategyItemListView.this.fHX.bw(FrsGameStrategyItemListView.this.dor, FrsGameStrategyItemListView.this.fIB);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.dEj != null) {
                    FrsGameStrategyItemListView.this.dEj.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.fIA = new c(this.mPageContext, this.mListView);
        this.fIA.a(this.mAdapterItemClickListener);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.dpL);
        this.dEj = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.dpz == null) {
            this.dpz = new PbListView(this.mPageContext.getPageActivity());
            this.dpz.nZ();
        }
        this.dpz.iX(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.dor && i2 == this.fIB)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.aa(list) && v.aa(this.mData)) {
                vP(getContext().getString(R.string.no_data_text));
                aKQ();
                this.mHasMore = false;
                return;
            }
            if (!v.aa(list)) {
                this.mData = list;
            }
            this.fIA.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                aKO();
            } else {
                aKP();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void f(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.dor && i2 == this.fIB)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.aa(this.mData)) {
                vP(str);
                aKQ();
                return;
            }
            this.mPageContext.showToast(str);
            aKP();
        }
    }

    private void aKO() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.dpz);
        this.dpz.akR();
    }

    private void aKP() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.dpz);
        this.dpz.akS();
        this.dpz.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void aKQ() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void vP(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.oX(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.dly == null) {
            this.dly = new com.baidu.tbadk.m.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.dly.onChangeSkinType();
        }
        this.dly.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.dly != null) {
            this.dly.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.fHX != null) {
            this.fHX.bv(this.dor, this.fIB);
        }
    }

    public void pullToRefresh() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.l(this.mListView, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.fHX = aVar;
    }

    public void bB(int i, int i2) {
        this.dor = i;
        this.fIB = i2;
        aKQ();
        this.mData = new LinkedList();
        this.fIA.setData(this.mData);
        this.fHX.bx(i, i2);
    }

    public void bqD() {
        if (v.aa(this.mData) && (this.dor != 0 || this.fIB != 0)) {
            showLoadingView();
            this.fHX.bv(this.dor, this.fIB);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.dor;
    }

    public int getLabelId() {
        return this.fIB;
    }

    public void onDestory() {
    }
}
