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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private ab Wt;
    private com.baidu.tbadk.l.g gAg;
    private com.baidu.tieba.frs.gametab.b gLR;
    private BdTypeListView gpZ;
    private PbListView grg;
    private f.c gsl;
    private c jkP;
    private int jkQ;
    private int jkd;
    private com.baidu.tieba.frs.game.strategy.tab.a jkm;
    private List<q> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Wt = new ab() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                by bmn;
                com.baidu.tieba.frs.game.strategy.tab.e AO;
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (bmn = ((com.baidu.tieba.frs.game.strategy.data.b) qVar).bmn()) != null) {
                    if (FrsGameStrategyItemListView.this.jkm != null && (AO = FrsGameStrategyItemListView.this.jkm.AO(FrsGameStrategyItemListView.this.jkd)) != null && (AO.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) AO.extra).getLabelName(FrsGameStrategyItemListView.this.jkQ);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new ar("c12388").dY("fid", FrsGameStrategyItemListView.this.jkm.getForumId()).dY("tid", bmn.getId()).dY("obj_id", AO.tabName).dY("obj_locate", labelName));
                    }
                    if (bmn.bpR() == null || bmn.bpR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (bmn.bpC() != 1 || bh.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Ub(bmn.getId())) {
                                readThreadHistory.Ua(bmn.getId());
                                FrsGameStrategyItemListView.this.jkP.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String boV = bmn.boV();
                            if (boV != null && !boV.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(boV);
                                        aaVar.btv().bue().mIsNeedAddCommenParam = false;
                                        aaVar.btv().bue().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bmn.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bmn.boK() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bf.bua().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bmn.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(bmn, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bmn.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.gsl = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.J(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.gpZ = new BdTypeListView(getContext());
        this.gpZ.setDivider(new ColorDrawable(ap.getColor(R.color.CAM_X0204)));
        this.gpZ.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.gpZ.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.gpZ.setFadingEdgeLength(0);
        this.gpZ.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.gpZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.jkm != null) {
                    FrsGameStrategyItemListView.this.jkm.cx(FrsGameStrategyItemListView.this.jkd, FrsGameStrategyItemListView.this.jkQ);
                }
            }
        });
        this.gpZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.gLR != null) {
                    FrsGameStrategyItemListView.this.gLR.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.gpZ);
        this.jkP = new c(this.mPageContext, this.gpZ);
        this.jkP.b(this.Wt);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.gsl);
        this.gLR = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.gpZ.setPullRefresh(this.mPullView);
        if (this.grg == null) {
            this.grg = new PbListView(this.mPageContext.getPageActivity());
            this.grg.createView();
        }
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.jkd && i2 == this.jkQ)) {
            hideLoadingView();
            this.gpZ.completePullRefresh();
            if (y.isEmpty(list) && y.isEmpty(this.mData)) {
                Jk(getContext().getString(R.string.no_data_text));
                bTb();
                this.mHasMore = false;
                return;
            }
            if (!y.isEmpty(list)) {
                this.mData = list;
            }
            this.jkP.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                XZ();
            } else {
                Ya();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void m(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.jkd && i2 == this.jkQ)) {
            this.mHasMore = false;
            hideLoadingView();
            if (y.isEmpty(this.mData)) {
                Jk(str);
                bTb();
                return;
            }
            this.mPageContext.showToast(str);
            Ya();
        }
    }

    private void XZ() {
        this.mHasMore = true;
        this.gpZ.setNextPage(this.grg);
        this.grg.startLoadData();
    }

    private void Ya() {
        this.mHasMore = false;
        this.gpZ.setNextPage(this.grg);
        this.grg.endLoadData();
        this.grg.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bTb() {
        this.mHasMore = false;
        this.gpZ.setNextPage(null);
    }

    private void Jk(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.Cy(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.gAg == null) {
            this.gAg = new com.baidu.tbadk.l.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.gAg.onChangeSkinType();
        }
        this.gAg.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.jkm != null) {
            this.jkm.cw(this.jkd, this.jkQ);
        }
    }

    public void pullToRefresh() {
        this.gpZ.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.gpZ, R.color.CAM_X0204);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.jkm = aVar;
    }

    public void cC(int i, int i2) {
        this.jkd = i;
        this.jkQ = i2;
        bTb();
        this.mData = new LinkedList();
        this.jkP.setData(this.mData);
        this.jkm.cy(i, i2);
    }

    public void cHA() {
        if (y.isEmpty(this.mData) && (this.jkd != 0 || this.jkQ != 0)) {
            showLoadingView();
            this.jkm.cw(this.jkd, this.jkQ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.jkd;
    }

    public int getLabelId() {
        return this.jkQ;
    }

    public void onDestory() {
    }
}
