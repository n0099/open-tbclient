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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private com.baidu.tbadk.j.f bha;
    private int bjL;
    private PbListView blb;
    private e.b brB;
    private com.baidu.tieba.frs.gametab.b buc;
    private com.baidu.tieba.frs.game.strategy.tab.a dgJ;
    private c dhm;
    private int dhn;
    private n mAdapterItemClickListener;
    private List<h> mData;
    private boolean mHasMore;
    private BdTypeListView mListView;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.f mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.mAdapterItemClickListener = new n() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view2, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bd Pe;
                com.baidu.tieba.frs.game.strategy.tab.e kB;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (Pe = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).Pe()) != null) {
                    if (FrsGameStrategyItemListView.this.dgJ != null && (kB = FrsGameStrategyItemListView.this.dgJ.kB(FrsGameStrategyItemListView.this.bjL)) != null && (kB.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) kB.extra).getLabelName(FrsGameStrategyItemListView.this.dhn);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new al("c12388").ac(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.dgJ.getForumId()).ac("tid", Pe.getId()).ac(VideoPlayActivityConfig.OBJ_ID, kB.tabName).ac("obj_locate", labelName));
                    }
                    if (Pe.sz() == null || Pe.sz().getGroup_id() == 0 || az.aK(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (Pe.ss() != 1 || az.aK(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.td(Pe.getId())) {
                                readThreadHistory.tc(Pe.getId());
                                FrsGameStrategyItemListView.this.dhm.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String rX = Pe.rX();
                            if (rX != null && !rX.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(rX);
                                        xVar.vj().wi().mIsNeedAddCommenParam = false;
                                        xVar.vj().wi().mIsUseCurrentBDUSS = false;
                                        xVar.uM();
                                    }
                                }).start();
                            }
                            String tid = Pe.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (Pe.rL() == 2 && !tid.startsWith("pb:")) {
                                ax.wg().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                Pe.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(Pe, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(Pe.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.brB = new e.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.ab(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(ak.getColor(d.C0126d.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(d.e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(d.f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.dgJ != null) {
                    FrsGameStrategyItemListView.this.dgJ.aC(FrsGameStrategyItemListView.this.bjL, FrsGameStrategyItemListView.this.dhn);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.buc != null) {
                    FrsGameStrategyItemListView.this.buc.d(view2, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dhm = new c(this.mPageContext, this.mListView);
        this.dhm.b(this.mAdapterItemClickListener);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.brB);
        this.buc = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.blb == null) {
            this.blb = new PbListView(this.mPageContext.getPageActivity());
            this.blb.kA();
        }
        this.blb.du(d.C0126d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bjL && i2 == this.dhn)) {
            Ou();
            this.mListView.completePullRefresh();
            if (v.w(list) && v.w(this.mData)) {
                lW(getContext().getString(d.k.no_data_text));
                Qq();
                this.mHasMore = false;
                return;
            }
            if (!v.w(list)) {
                this.mData = list;
            }
            this.dhm.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                Qo();
            } else {
                Qp();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bjL && i2 == this.dhn)) {
            this.mHasMore = false;
            Ou();
            if (v.w(this.mData)) {
                lW(str);
                Qq();
                return;
            }
            this.mPageContext.showToast(str);
            Qp();
        }
    }

    private void Qo() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.blb);
        this.blb.wR();
    }

    private void Qp() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.blb);
        this.blb.wS();
        this.blb.setText(this.mPageContext.getResources().getString(d.k.list_no_more));
    }

    private void Qq() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void lW(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.eL(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(d.k.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
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
        if (this.bha == null) {
            this.bha = new com.baidu.tbadk.j.f(getContext(), getContext().getResources().getDimensionPixelSize(d.e.ds120));
            this.bha.onChangeSkinType();
        }
        this.bha.d(this, false);
    }

    private void Ou() {
        if (this.bha != null) {
            this.bha.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dgJ != null) {
            this.dgJ.aB(this.bjL, this.dhn);
        }
    }

    public void lg() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ak.j(this.mListView, d.C0126d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.dgJ = aVar;
    }

    public void aH(int i, int i2) {
        this.bjL = i;
        this.dhn = i2;
        Qq();
        this.mData = new LinkedList();
        this.dhm.setData(this.mData);
        this.dgJ.aD(i, i2);
    }

    public void asG() {
        if (v.w(this.mData) && (this.bjL != 0 || this.dhn != 0)) {
            showLoadingView();
            this.dgJ.aB(this.bjL, this.dhn);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bjL;
    }

    public int getLabelId() {
        return this.dhn;
    }

    public void onDestory() {
    }
}
