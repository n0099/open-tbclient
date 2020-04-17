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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private v Tt;
    private BdTypeListView eOe;
    private PbListView ePm;
    private g.c eQn;
    private com.baidu.tbadk.k.g eYb;
    private com.baidu.tieba.frs.gametab.b fhh;
    private com.baidu.tieba.frs.game.strategy.tab.a hkH;
    private int hky;
    private c hll;
    private int hlm;
    private List<m> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private h mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Tt = new v() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bj aIw;
                com.baidu.tieba.frs.game.strategy.tab.e tU;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (aIw = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).aIw()) != null) {
                    if (FrsGameStrategyItemListView.this.hkH != null && (tU = FrsGameStrategyItemListView.this.hkH.tU(FrsGameStrategyItemListView.this.hky)) != null && (tU.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) tU.extra).getLabelName(FrsGameStrategyItemListView.this.hlm);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").cI("fid", FrsGameStrategyItemListView.this.hkH.getForumId()).cI("tid", aIw.getId()).cI("obj_id", tU.tabName).cI("obj_locate", labelName));
                    }
                    if (aIw.aLB() == null || aIw.aLB().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (aIw.aLo() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.KY(aIw.getId())) {
                                readThreadHistory.KX(aIw.getId());
                                FrsGameStrategyItemListView.this.hll.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aKL = aIw.aKL();
                            if (aKL != null && !aKL.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aKL);
                                        xVar.aOy().aOZ().mIsNeedAddCommenParam = false;
                                        xVar.aOy().aOZ().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = aIw.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (aIw.aKz() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aOY().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                aIw.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(aIw, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(aIw.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.eQn = new g.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.T(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.eOe = new BdTypeListView(getContext());
        this.eOe.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.eOe.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eOe.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.eOe.setFadingEdgeLength(0);
        this.eOe.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.eOe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.hkH != null) {
                    FrsGameStrategyItemListView.this.hkH.bP(FrsGameStrategyItemListView.this.hky, FrsGameStrategyItemListView.this.hlm);
                }
            }
        });
        this.eOe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.fhh != null) {
                    FrsGameStrategyItemListView.this.fhh.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.eOe);
        this.hll = new c(this.mPageContext, this.eOe);
        this.hll.b(this.Tt);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.eQn);
        this.fhh = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.eOe.setPullRefresh(this.mPullView);
        if (this.ePm == null) {
            this.ePm = new PbListView(this.mPageContext.getPageActivity());
            this.ePm.createView();
        }
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.hky && i2 == this.hlm)) {
            hideLoadingView();
            this.eOe.completePullRefresh();
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(this.mData)) {
                Bv(getContext().getString(R.string.no_data_text));
                bmq();
                this.mHasMore = false;
                return;
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
                this.mData = list;
            }
            this.hll.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                bmo();
            } else {
                bmp();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void j(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.hky && i2 == this.hlm)) {
            this.mHasMore = false;
            hideLoadingView();
            if (com.baidu.tbadk.core.util.v.isEmpty(this.mData)) {
                Bv(str);
                bmq();
                return;
            }
            this.mPageContext.showToast(str);
            bmp();
        }
    }

    private void bmo() {
        this.mHasMore = true;
        this.eOe.setNextPage(this.ePm);
        this.ePm.startLoadData();
    }

    private void bmp() {
        this.mHasMore = false;
        this.eOe.setNextPage(this.ePm);
        this.ePm.endLoadData();
        this.ePm.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bmq() {
        this.mHasMore = false;
        this.eOe.setNextPage(null);
    }

    private void Bv(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.vi(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.eYb == null) {
            this.eYb = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.eYb.onChangeSkinType();
        }
        this.eYb.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.hkH != null) {
            this.hkH.bO(this.hky, this.hlm);
        }
    }

    public void pullToRefresh() {
        this.eOe.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.eOe, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.hkH = aVar;
    }

    public void bU(int i, int i2) {
        this.hky = i;
        this.hlm = i2;
        bmq();
        this.mData = new LinkedList();
        this.hll.setData(this.mData);
        this.hkH.bQ(i, i2);
    }

    public void bSv() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.mData) && (this.hky != 0 || this.hlm != 0)) {
            showLoadingView();
            this.hkH.bO(this.hky, this.hlm);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.hky;
    }

    public int getLabelId() {
        return this.hlm;
    }

    public void onDestory() {
    }
}
