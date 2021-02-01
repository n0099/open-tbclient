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
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private w Wk;
    private PbListView gAi;
    private f.c gBn;
    private g gJn;
    private com.baidu.tieba.frs.gametab.b gVH;
    private BdTypeListView gzb;
    private int jxC;
    private com.baidu.tieba.frs.game.strategy.tab.a jxL;
    private c jyo;
    private int jyp;
    private List<n> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Wk = new w() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                cb bln;
                com.baidu.tieba.frs.game.strategy.tab.e zE;
                if (nVar != null && (nVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (bln = ((com.baidu.tieba.frs.game.strategy.data.b) nVar).bln()) != null) {
                    if (FrsGameStrategyItemListView.this.jxL != null && (zE = FrsGameStrategyItemListView.this.jxL.zE(FrsGameStrategyItemListView.this.jxC)) != null && (zE.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) zE.extra).getLabelName(FrsGameStrategyItemListView.this.jyp);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new ar("c12388").dR("fid", FrsGameStrategyItemListView.this.jxL.getForumId()).dR("tid", bln.getId()).dR("obj_id", zE.tabName).dR("obj_locate", labelName));
                    }
                    if (bln.boR() == null || bln.boR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (bln.boC() != 1 || bh.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.TA(bln.getId())) {
                                readThreadHistory.Tz(bln.getId());
                                FrsGameStrategyItemListView.this.jyo.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String bnW = bln.bnW();
                            if (bnW != null && !bnW.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(bnW);
                                        aaVar.bsr().bta().mIsNeedAddCommenParam = false;
                                        aaVar.bsr().bta().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bln.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bln.bnL() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bf.bsV().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bln.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(bln, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bln.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.gBn = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.gzb = new BdTypeListView(getContext());
        this.gzb.setDivider(new ColorDrawable(ap.getColor(R.color.CAM_X0204)));
        this.gzb.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.gzb.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.gzb.setFadingEdgeLength(0);
        this.gzb.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.gzb.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.jxL != null) {
                    FrsGameStrategyItemListView.this.jxL.cr(FrsGameStrategyItemListView.this.jxC, FrsGameStrategyItemListView.this.jyp);
                }
            }
        });
        this.gzb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.gVH != null) {
                    FrsGameStrategyItemListView.this.gVH.i(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.gzb);
        this.jyo = new c(this.mPageContext, this.gzb);
        this.jyo.b(this.Wk);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.gBn);
        this.gVH = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.gzb.setPullRefresh(this.mPullView);
        if (this.gAi == null) {
            this.gAi = new PbListView(this.mPageContext.getPageActivity());
            this.gAi.createView();
        }
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<n> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.jxC && i2 == this.jyp)) {
            hideLoadingView();
            this.gzb.completePullRefresh();
            if (y.isEmpty(list) && y.isEmpty(this.mData)) {
                IG(getContext().getString(R.string.no_data_text));
                bSr();
                this.mHasMore = false;
                return;
            }
            if (!y.isEmpty(list)) {
                this.mData = list;
            }
            this.jyo.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                WX();
            } else {
                WY();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void m(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.jxC && i2 == this.jyp)) {
            this.mHasMore = false;
            hideLoadingView();
            if (y.isEmpty(this.mData)) {
                IG(str);
                bSr();
                return;
            }
            this.mPageContext.showToast(str);
            WY();
        }
    }

    private void WX() {
        this.mHasMore = true;
        this.gzb.setNextPage(this.gAi);
        this.gAi.startLoadData();
    }

    private void WY() {
        this.mHasMore = false;
        this.gzb.setNextPage(this.gAi);
        this.gAi.endLoadData();
        this.gAi.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bSr() {
        this.mHasMore = false;
        this.gzb.setNextPage(null);
    }

    private void IG(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.BB(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.gJn == null) {
            this.gJn = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.gJn.onChangeSkinType();
        }
        this.gJn.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.jxL != null) {
            this.jxL.cq(this.jxC, this.jyp);
        }
    }

    public void pullToRefresh() {
        this.gzb.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.gzb, R.color.CAM_X0204);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.jxL = aVar;
    }

    public void cw(int i, int i2) {
        this.jxC = i;
        this.jyp = i2;
        bSr();
        this.mData = new LinkedList();
        this.jyo.setData(this.mData);
        this.jxL.cs(i, i2);
    }

    public void cHW() {
        if (y.isEmpty(this.mData) && (this.jxC != 0 || this.jyp != 0)) {
            showLoadingView();
            this.jxL.cq(this.jxC, this.jyp);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.jxC;
    }

    public int getLabelId() {
        return this.jyp;
    }

    public void onDestory() {
    }
}
