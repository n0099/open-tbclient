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
    private com.baidu.tbadk.l.g gAe;
    private com.baidu.tieba.frs.gametab.b gLP;
    private BdTypeListView gpX;
    private PbListView gre;
    private f.c gsj;
    private c jkN;
    private int jkO;
    private int jkb;
    private com.baidu.tieba.frs.game.strategy.tab.a jkk;
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
                    if (FrsGameStrategyItemListView.this.jkk != null && (AO = FrsGameStrategyItemListView.this.jkk.AO(FrsGameStrategyItemListView.this.jkb)) != null && (AO.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) AO.extra).getLabelName(FrsGameStrategyItemListView.this.jkO);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new ar("c12388").dY("fid", FrsGameStrategyItemListView.this.jkk.getForumId()).dY("tid", bmn.getId()).dY("obj_id", AO.tabName).dY("obj_locate", labelName));
                    }
                    if (bmn.bpR() == null || bmn.bpR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (bmn.bpC() != 1 || bh.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Ub(bmn.getId())) {
                                readThreadHistory.Ua(bmn.getId());
                                FrsGameStrategyItemListView.this.jkN.notifyDataSetChanged();
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
        this.gsj = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.gpX = new BdTypeListView(getContext());
        this.gpX.setDivider(new ColorDrawable(ap.getColor(R.color.CAM_X0204)));
        this.gpX.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.gpX.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.gpX.setFadingEdgeLength(0);
        this.gpX.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.gpX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.jkk != null) {
                    FrsGameStrategyItemListView.this.jkk.cx(FrsGameStrategyItemListView.this.jkb, FrsGameStrategyItemListView.this.jkO);
                }
            }
        });
        this.gpX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.gLP != null) {
                    FrsGameStrategyItemListView.this.gLP.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.gpX);
        this.jkN = new c(this.mPageContext, this.gpX);
        this.jkN.b(this.Wt);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.gsj);
        this.gLP = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.gpX.setPullRefresh(this.mPullView);
        if (this.gre == null) {
            this.gre = new PbListView(this.mPageContext.getPageActivity());
            this.gre.createView();
        }
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.jkb && i2 == this.jkO)) {
            hideLoadingView();
            this.gpX.completePullRefresh();
            if (y.isEmpty(list) && y.isEmpty(this.mData)) {
                Jk(getContext().getString(R.string.no_data_text));
                bTa();
                this.mHasMore = false;
                return;
            }
            if (!y.isEmpty(list)) {
                this.mData = list;
            }
            this.jkN.setData(this.mData);
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
        if ((i == 0 && i2 == 0) || (i == this.jkb && i2 == this.jkO)) {
            this.mHasMore = false;
            hideLoadingView();
            if (y.isEmpty(this.mData)) {
                Jk(str);
                bTa();
                return;
            }
            this.mPageContext.showToast(str);
            Ya();
        }
    }

    private void XZ() {
        this.mHasMore = true;
        this.gpX.setNextPage(this.gre);
        this.gre.startLoadData();
    }

    private void Ya() {
        this.mHasMore = false;
        this.gpX.setNextPage(this.gre);
        this.gre.endLoadData();
        this.gre.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bTa() {
        this.mHasMore = false;
        this.gpX.setNextPage(null);
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
        if (this.gAe == null) {
            this.gAe = new com.baidu.tbadk.l.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.gAe.onChangeSkinType();
        }
        this.gAe.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.jkk != null) {
            this.jkk.cw(this.jkb, this.jkO);
        }
    }

    public void pullToRefresh() {
        this.gpX.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.gpX, R.color.CAM_X0204);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.jkk = aVar;
    }

    public void cC(int i, int i2) {
        this.jkb = i;
        this.jkO = i2;
        bTa();
        this.mData = new LinkedList();
        this.jkN.setData(this.mData);
        this.jkk.cy(i, i2);
    }

    public void cHz() {
        if (y.isEmpty(this.mData) && (this.jkb != 0 || this.jkO != 0)) {
            showLoadingView();
            this.jkk.cw(this.jkb, this.jkO);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.jkb;
    }

    public int getLabelId() {
        return this.jkO;
    }

    public void onDestory() {
    }
}
