package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private w Wo;
    private g gGD;
    private com.baidu.tieba.frs.gametab.b gSX;
    private BdTypeListView gwr;
    private PbListView gxy;
    private f.c gyD;
    private int jrW;
    private c jsI;
    private int jsJ;
    private com.baidu.tieba.frs.game.strategy.tab.a jsf;
    private List<n> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Wo = new w() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bz bkV;
                com.baidu.tieba.frs.game.strategy.tab.e zu;
                if (nVar != null && (nVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (bkV = ((com.baidu.tieba.frs.game.strategy.data.b) nVar).bkV()) != null) {
                    if (FrsGameStrategyItemListView.this.jsf != null && (zu = FrsGameStrategyItemListView.this.jsf.zu(FrsGameStrategyItemListView.this.jrW)) != null && (zu.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) zu.extra).getLabelName(FrsGameStrategyItemListView.this.jsJ);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new aq("c12388").dW("fid", FrsGameStrategyItemListView.this.jsf.getForumId()).dW("tid", bkV.getId()).dW("obj_id", zu.tabName).dW("obj_locate", labelName));
                    }
                    if (bkV.boz() == null || bkV.boz().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (bkV.bok() != 1 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.SD(bkV.getId())) {
                                readThreadHistory.SC(bkV.getId());
                                FrsGameStrategyItemListView.this.jsI.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String bnD = bkV.bnD();
                            if (bnD != null && !bnD.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        z zVar = new z(bnD);
                                        zVar.brX().bsG().mIsNeedAddCommenParam = false;
                                        zVar.brX().bsG().mIsUseCurrentBDUSS = false;
                                        zVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bkV.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bkV.bns() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                be.bsB().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bkV.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(bkV, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bkV.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.gyD = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) j.K(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.gwr = new BdTypeListView(getContext());
        this.gwr.setDivider(new ColorDrawable(ao.getColor(R.color.CAM_X0204)));
        this.gwr.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.gwr.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.gwr.setFadingEdgeLength(0);
        this.gwr.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.gwr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.jsf != null) {
                    FrsGameStrategyItemListView.this.jsf.cu(FrsGameStrategyItemListView.this.jrW, FrsGameStrategyItemListView.this.jsJ);
                }
            }
        });
        this.gwr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.gSX != null) {
                    FrsGameStrategyItemListView.this.gSX.i(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.gwr);
        this.jsI = new c(this.mPageContext, this.gwr);
        this.jsI.b(this.Wo);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.gyD);
        this.gSX = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.gwr.setPullRefresh(this.mPullView);
        if (this.gxy == null) {
            this.gxy = new PbListView(this.mPageContext.getPageActivity());
            this.gxy.createView();
        }
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<n> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.jrW && i2 == this.jsJ)) {
            hideLoadingView();
            this.gwr.completePullRefresh();
            if (x.isEmpty(list) && x.isEmpty(this.mData)) {
                HW(getContext().getString(R.string.no_data_text));
                bRO();
                this.mHasMore = false;
                return;
            }
            if (!x.isEmpty(list)) {
                this.mData = list;
            }
            this.jsI.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                Vo();
            } else {
                Vp();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void n(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.jrW && i2 == this.jsJ)) {
            this.mHasMore = false;
            hideLoadingView();
            if (x.isEmpty(this.mData)) {
                HW(str);
                bRO();
                return;
            }
            this.mPageContext.showToast(str);
            Vp();
        }
    }

    private void Vo() {
        this.mHasMore = true;
        this.gwr.setNextPage(this.gxy);
        this.gxy.startLoadData();
    }

    private void Vp() {
        this.mHasMore = false;
        this.gwr.setNextPage(this.gxy);
        this.gxy.endLoadData();
        this.gxy.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bRO() {
        this.mHasMore = false;
        this.gwr.setNextPage(null);
    }

    private void HW(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.Bk(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.gGD == null) {
            this.gGD = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.gGD.onChangeSkinType();
        }
        this.gGD.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.jsf != null) {
            this.jsf.ct(this.jrW, this.jsJ);
        }
    }

    public void pullToRefresh() {
        this.gwr.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.gwr, R.color.CAM_X0204);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.jsf = aVar;
    }

    public void cz(int i, int i2) {
        this.jrW = i;
        this.jsJ = i2;
        bRO();
        this.mData = new LinkedList();
        this.jsI.setData(this.mData);
        this.jsf.cv(i, i2);
    }

    public void cGJ() {
        if (x.isEmpty(this.mData) && (this.jrW != 0 || this.jsJ != 0)) {
            showLoadingView();
            this.jsf.ct(this.jrW, this.jsJ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.jrW;
    }

    public int getLabelId() {
        return this.jsJ;
    }

    public void onDestory() {
    }
}
