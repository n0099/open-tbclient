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
    private com.baidu.tbadk.j.f bhf;
    private int bkb;
    private PbListView blq;
    private e.b brQ;
    private com.baidu.tieba.frs.gametab.b buN;
    private com.baidu.tieba.frs.game.strategy.tab.a dhQ;
    private c dit;
    private int diu;
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
                bd Pb;
                com.baidu.tieba.frs.game.strategy.tab.e kA;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (Pb = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).Pb()) != null) {
                    if (FrsGameStrategyItemListView.this.dhQ != null && (kA = FrsGameStrategyItemListView.this.dhQ.kA(FrsGameStrategyItemListView.this.bkb)) != null && (kA.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) kA.extra).getLabelName(FrsGameStrategyItemListView.this.diu);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new al("c12388").ac(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.dhQ.getForumId()).ac("tid", Pb.getId()).ac(VideoPlayActivityConfig.OBJ_ID, kA.tabName).ac("obj_locate", labelName));
                    }
                    if (Pb.sy() == null || Pb.sy().getGroup_id() == 0 || az.aK(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (Pb.sr() != 1 || az.aK(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.tg(Pb.getId())) {
                                readThreadHistory.tf(Pb.getId());
                                FrsGameStrategyItemListView.this.dit.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String rW = Pb.rW();
                            if (rW != null && !rW.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(rW);
                                        xVar.vi().wh().mIsNeedAddCommenParam = false;
                                        xVar.vi().wh().mIsUseCurrentBDUSS = false;
                                        xVar.uL();
                                    }
                                }).start();
                            }
                            String tid = Pb.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (Pb.rK() == 2 && !tid.startsWith("pb:")) {
                                ax.wf().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                Pb.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(Pb, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(Pb.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.brQ = new e.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.dhQ != null) {
                    FrsGameStrategyItemListView.this.dhQ.aC(FrsGameStrategyItemListView.this.bkb, FrsGameStrategyItemListView.this.diu);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.buN != null) {
                    FrsGameStrategyItemListView.this.buN.d(view2, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dit = new c(this.mPageContext, this.mListView);
        this.dit.b(this.mAdapterItemClickListener);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.brQ);
        this.buN = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.blq == null) {
            this.blq = new PbListView(this.mPageContext.getPageActivity());
            this.blq.kz();
        }
        this.blq.dv(d.C0126d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bkb && i2 == this.diu)) {
            Os();
            this.mListView.completePullRefresh();
            if (v.w(list) && v.w(this.mData)) {
                lZ(getContext().getString(d.k.no_data_text));
                Qn();
                this.mHasMore = false;
                return;
            }
            if (!v.w(list)) {
                this.mData = list;
            }
            this.dit.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                Ql();
            } else {
                Qm();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bkb && i2 == this.diu)) {
            this.mHasMore = false;
            Os();
            if (v.w(this.mData)) {
                lZ(str);
                Qn();
                return;
            }
            this.mPageContext.showToast(str);
            Qm();
        }
    }

    private void Ql() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.blq);
        this.blq.wQ();
    }

    private void Qm() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.blq);
        this.blq.wR();
        this.blq.setText(this.mPageContext.getResources().getString(d.k.list_no_more));
    }

    private void Qn() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void lZ(String str) {
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
        if (this.bhf == null) {
            this.bhf = new com.baidu.tbadk.j.f(getContext(), getContext().getResources().getDimensionPixelSize(d.e.ds120));
            this.bhf.onChangeSkinType();
        }
        this.bhf.d(this, false);
    }

    private void Os() {
        if (this.bhf != null) {
            this.bhf.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dhQ != null) {
            this.dhQ.aB(this.bkb, this.diu);
        }
    }

    public void lf() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ak.j(this.mListView, d.C0126d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.dhQ = aVar;
    }

    public void aH(int i, int i2) {
        this.bkb = i;
        this.diu = i2;
        Qn();
        this.mData = new LinkedList();
        this.dit.setData(this.mData);
        this.dhQ.aD(i, i2);
    }

    public void asF() {
        if (v.w(this.mData) && (this.bkb != 0 || this.diu != 0)) {
            showLoadingView();
            this.dhQ.aB(this.bkb, this.diu);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bkb;
    }

    public int getLabelId() {
        return this.diu;
    }

    public void onDestory() {
    }
}
