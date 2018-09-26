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
    private int bAe;
    private PbListView bBr;
    private j.b bIt;
    private com.baidu.tieba.frs.gametab.b bLs;
    private com.baidu.tbadk.k.f bxm;
    private com.baidu.tieba.frs.game.strategy.tab.a dDI;
    private c dEl;
    private int dEm;
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
                bb UT;
                com.baidu.tieba.frs.game.strategy.tab.e lz;
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (UT = ((com.baidu.tieba.frs.game.strategy.data.b) hVar).UT()) != null) {
                    if (FrsGameStrategyItemListView.this.dDI != null && (lz = FrsGameStrategyItemListView.this.dDI.lz(FrsGameStrategyItemListView.this.bAe)) != null && (lz.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) lz.extra).getLabelName(FrsGameStrategyItemListView.this.dEm);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new am("c12388").al(ImageViewerConfig.FORUM_ID, FrsGameStrategyItemListView.this.dDI.getForumId()).al("tid", UT.getId()).al(VideoPlayActivityConfig.OBJ_ID, lz.tabName).al("obj_locate", labelName));
                    }
                    if (UT.wY() == null || UT.wY().getGroup_id() == 0 || ba.bA(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (UT.wQ() != 1 || ba.bA(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.uJ(UT.getId())) {
                                readThreadHistory.uI(UT.getId());
                                FrsGameStrategyItemListView.this.dEl.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String wu = UT.wu();
                            if (wu != null && !wu.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(wu);
                                        xVar.zR().AP().mIsNeedAddCommenParam = false;
                                        xVar.zR().AP().mIsUseCurrentBDUSS = false;
                                        xVar.zu();
                                    }
                                }).start();
                            }
                            String tid = UT.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (UT.wh() == 2 && !tid.startsWith("pb:")) {
                                ay.AN().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                UT.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(UT, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(UT.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.bIt = new j.b() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
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
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(e.C0141e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(e.f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.dDI != null) {
                    FrsGameStrategyItemListView.this.dDI.aK(FrsGameStrategyItemListView.this.bAe, FrsGameStrategyItemListView.this.dEm);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.bLs != null) {
                    FrsGameStrategyItemListView.this.bLs.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dEl = new c(this.mPageContext, this.mListView);
        this.dEl.b(this.mAdapterItemClickListener);
        this.mPullView = new k(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.bIt);
        this.bLs = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.bBr == null) {
            this.bBr = new PbListView(this.mPageContext.getPageActivity());
            this.bBr.ov();
        }
        this.bBr.dL(e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bAe && i2 == this.dEm)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.z(list) && v.z(this.mData)) {
                nk(getContext().getString(e.j.no_data_text));
                Wd();
                this.mHasMore = false;
                return;
            }
            if (!v.z(list)) {
                this.mData = list;
            }
            this.dEl.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                Wb();
            } else {
                Wc();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void c(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bAe && i2 == this.dEm)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.z(this.mData)) {
                nk(str);
                Wd();
                return;
            }
            this.mPageContext.showToast(str);
            Wc();
        }
    }

    private void Wb() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.bBr);
        this.bBr.BI();
    }

    private void Wc() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.bBr);
        this.bBr.BJ();
        this.bBr.setText(this.mPageContext.getResources().getString(e.j.list_no_more));
    }

    private void Wd() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void nk(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0141e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0141e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(e.C0141e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.fG(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(e.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrsGameStrategyItemListView.this.refresh();
                }
            }), getResources().getDimensionPixelSize(e.C0141e.ds20)));
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
        if (this.bxm == null) {
            this.bxm = new com.baidu.tbadk.k.f(getContext(), getContext().getResources().getDimensionPixelSize(e.C0141e.ds120));
            this.bxm.onChangeSkinType();
        }
        this.bxm.c(this, false);
    }

    private void hideLoadingView() {
        if (this.bxm != null) {
            this.bxm.ad(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dDI != null) {
            this.dDI.aJ(this.bAe, this.dEm);
        }
    }

    public void pullToRefresh() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, e.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.dDI = aVar;
    }

    public void aP(int i, int i2) {
        this.bAe = i;
        this.dEm = i2;
        Wd();
        this.mData = new LinkedList();
        this.dEl.setData(this.mData);
        this.dDI.aL(i, i2);
    }

    public void aAh() {
        if (v.z(this.mData) && (this.bAe != 0 || this.dEm != 0)) {
            showLoadingView();
            this.dDI.aJ(this.bAe, this.dEm);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bAe;
    }

    public int getLabelId() {
        return this.dEm;
    }

    public void onDestory() {
    }
}
