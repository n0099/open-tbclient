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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private com.baidu.tieba.frs.gametab.b bCQ;
    private com.baidu.tbadk.j.f bpl;
    private int bsf;
    private PbListView btv;
    private f.b bzV;
    private c drI;
    private int drJ;
    private com.baidu.tieba.frs.game.strategy.tab.a drf;
    private n mAdapterItemClickListener;
    private List<h> mData;
    private boolean mHasMore;
    private BdTypeListView mListView;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.mAdapterItemClickListener = new n() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bd Sz;
                com.baidu.tieba.frs.game.strategy.tab.e kF;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (Sz = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).Sz()) != null) {
                    if (FrsGameStrategyItemListView.this.drf != null && (kF = FrsGameStrategyItemListView.this.drf.kF(FrsGameStrategyItemListView.this.bsf)) != null && (kF.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) kF.extra).getLabelName(FrsGameStrategyItemListView.this.drJ);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new am("c12388").ah(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.drf.getForumId()).ah("tid", Sz.getId()).ah(VideoPlayActivityConfig.OBJ_ID, kF.tabName).ah("obj_locate", labelName));
                    }
                    if (Sz.vV() == null || Sz.vV().getGroup_id() == 0 || ba.aU(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (Sz.vO() != 1 || ba.aU(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.ua(Sz.getId())) {
                                readThreadHistory.tZ(Sz.getId());
                                FrsGameStrategyItemListView.this.drI.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String vt = Sz.vt();
                            if (vt != null && !vt.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        y yVar = new y(vt);
                                        yVar.yJ().zI().mIsNeedAddCommenParam = false;
                                        yVar.yJ().zI().mIsUseCurrentBDUSS = false;
                                        yVar.ym();
                                    }
                                }).start();
                            }
                            String tid = Sz.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (Sz.vh() == 2 && !tid.startsWith("pb:")) {
                                ay.zG().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                Sz.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(Sz, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(Sz.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.bzV = new f.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.ad(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(al.getColor(d.C0141d.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(d.e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(d.f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.drf != null) {
                    FrsGameStrategyItemListView.this.drf.aE(FrsGameStrategyItemListView.this.bsf, FrsGameStrategyItemListView.this.drJ);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.bCQ != null) {
                    FrsGameStrategyItemListView.this.bCQ.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.drI = new c(this.mPageContext, this.mListView);
        this.drI.b(this.mAdapterItemClickListener);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.bzV);
        this.bCQ = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.btv == null) {
            this.btv = new PbListView(this.mPageContext.getPageActivity());
            this.btv.nn();
        }
        this.btv.dx(d.C0141d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bsf && i2 == this.drJ)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (w.z(list) && w.z(this.mData)) {
                mG(getContext().getString(d.k.no_data_text));
                TL();
                this.mHasMore = false;
                return;
            }
            if (!w.z(list)) {
                this.mData = list;
            }
            this.drI.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                TJ();
            } else {
                TK();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bsf && i2 == this.drJ)) {
            this.mHasMore = false;
            hideLoadingView();
            if (w.z(this.mData)) {
                mG(str);
                TL();
                return;
            }
            this.mPageContext.showToast(str);
            TK();
        }
    }

    private void TJ() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.btv);
        this.btv.Ar();
    }

    private void TK() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.btv);
        this.btv.As();
        this.btv.setText(this.mPageContext.getResources().getString(d.k.list_no_more));
    }

    private void TL() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void mG(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.fk(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(d.k.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.bpl == null) {
            this.bpl = new com.baidu.tbadk.j.f(getContext(), getContext().getResources().getDimensionPixelSize(d.e.ds120));
            this.bpl.onChangeSkinType();
        }
        this.bpl.d(this, false);
    }

    private void hideLoadingView() {
        if (this.bpl != null) {
            this.bpl.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.drf != null) {
            this.drf.aD(this.bsf, this.drJ);
        }
    }

    public void nV() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, d.C0141d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.drf = aVar;
    }

    public void aJ(int i, int i2) {
        this.bsf = i;
        this.drJ = i2;
        TL();
        this.mData = new LinkedList();
        this.drI.setData(this.mData);
        this.drf.aF(i, i2);
    }

    public void awL() {
        if (w.z(this.mData) && (this.bsf != 0 || this.drJ != 0)) {
            showLoadingView();
            this.drf.aD(this.bsf, this.drJ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bsf;
    }

    public int getLabelId() {
        return this.drJ;
    }

    public void onDestory() {
    }
}
