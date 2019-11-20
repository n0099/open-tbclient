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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
    private com.baidu.tbadk.m.g dDz;
    private com.baidu.tieba.frs.gametab.b dIw;
    private BdTypeListView duK;
    private PbListView dvS;
    private h.c dwe;
    private int fGn;
    private com.baidu.tieba.frs.game.strategy.tab.a fGw;
    private c fHa;
    private int fHb;
    private List<m> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private i mPullView;
    private s xj;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.xj = new s() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bh agG;
                com.baidu.tieba.frs.game.strategy.tab.e qZ;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (agG = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).agG()) != null) {
                    if (FrsGameStrategyItemListView.this.fGw != null && (qZ = FrsGameStrategyItemListView.this.fGw.qZ(FrsGameStrategyItemListView.this.fGn)) != null && (qZ.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) qZ.extra).getLabelName(FrsGameStrategyItemListView.this.fHb);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").bS("fid", FrsGameStrategyItemListView.this.fGw.getForumId()).bS("tid", agG.getId()).bS("obj_id", qZ.tabName).bS("obj_locate", labelName));
                    }
                    if (agG.ajw() == null || agG.ajw().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (agG.ajo() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Ec(agG.getId())) {
                                readThreadHistory.Eb(agG.getId());
                                FrsGameStrategyItemListView.this.fHa.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aiL = agG.aiL();
                            if (aiL != null && !aiL.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aiL);
                                        xVar.amp().amP().mIsNeedAddCommenParam = false;
                                        xVar.amp().amP().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = agG.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (agG.aiz() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.amO().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                agG.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(agG, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(agG.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.dwe = new h.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.duK = new BdTypeListView(getContext());
        this.duK.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.duK.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.duK.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.duK.setFadingEdgeLength(0);
        this.duK.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.duK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.fGw != null) {
                    FrsGameStrategyItemListView.this.fGw.bq(FrsGameStrategyItemListView.this.fGn, FrsGameStrategyItemListView.this.fHb);
                }
            }
        });
        this.duK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.dIw != null) {
                    FrsGameStrategyItemListView.this.dIw.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.duK);
        this.fHa = new c(this.mPageContext, this.duK);
        this.fHa.b(this.xj);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.dwe);
        this.dIw = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.duK.setPullRefresh(this.mPullView);
        if (this.dvS == null) {
            this.dvS = new PbListView(this.mPageContext.getPageActivity());
            this.dvS.createView();
        }
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.fGn && i2 == this.fHb)) {
            hideLoadingView();
            this.duK.completePullRefresh();
            if (v.isEmpty(list) && v.isEmpty(this.mData)) {
                us(getContext().getString(R.string.no_data_text));
                aKi();
                this.mHasMore = false;
                return;
            }
            if (!v.isEmpty(list)) {
                this.mData = list;
            }
            this.fHa.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                aKg();
            } else {
                aKh();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void f(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.fGn && i2 == this.fHb)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.isEmpty(this.mData)) {
                us(str);
                aKi();
                return;
            }
            this.mPageContext.showToast(str);
            aKh();
        }
    }

    private void aKg() {
        this.mHasMore = true;
        this.duK.setNextPage(this.dvS);
        this.dvS.startLoadData();
    }

    private void aKh() {
        this.mHasMore = false;
        this.duK.setNextPage(this.dvS);
        this.dvS.endLoadData();
        this.dvS.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void aKi() {
        this.mHasMore = false;
        this.duK.setNextPage(null);
    }

    private void us(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.ow(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.dDz == null) {
            this.dDz = new com.baidu.tbadk.m.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.dDz.onChangeSkinType();
        }
        this.dDz.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.fGw != null) {
            this.fGw.bp(this.fGn, this.fHb);
        }
    }

    public void pullToRefresh() {
        this.duK.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.duK, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.fGw = aVar;
    }

    public void bv(int i, int i2) {
        this.fGn = i;
        this.fHb = i2;
        aKi();
        this.mData = new LinkedList();
        this.fHa.setData(this.mData);
        this.fGw.br(i, i2);
    }

    public void bnG() {
        if (v.isEmpty(this.mData) && (this.fGn != 0 || this.fHb != 0)) {
            showLoadingView();
            this.fGw.bp(this.fGn, this.fHb);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.fGn;
    }

    public int getLabelId() {
        return this.fHb;
    }

    public void onDestory() {
    }
}
