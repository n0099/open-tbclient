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
    private com.baidu.tbadk.m.g dEq;
    private com.baidu.tieba.frs.gametab.b dJn;
    private BdTypeListView dvB;
    private PbListView dwJ;
    private h.c dwV;
    private c fHR;
    private int fHS;
    private int fHe;
    private com.baidu.tieba.frs.game.strategy.tab.a fHn;
    private List<m> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private i mPullView;
    private s xJ;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.xJ = new s() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bh agI;
                com.baidu.tieba.frs.game.strategy.tab.e ra;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (agI = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).agI()) != null) {
                    if (FrsGameStrategyItemListView.this.fHn != null && (ra = FrsGameStrategyItemListView.this.fHn.ra(FrsGameStrategyItemListView.this.fHe)) != null && (ra.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) ra.extra).getLabelName(FrsGameStrategyItemListView.this.fHS);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").bS("fid", FrsGameStrategyItemListView.this.fHn.getForumId()).bS("tid", agI.getId()).bS("obj_id", ra.tabName).bS("obj_locate", labelName));
                    }
                    if (agI.ajy() == null || agI.ajy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (agI.ajq() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Ec(agI.getId())) {
                                readThreadHistory.Eb(agI.getId());
                                FrsGameStrategyItemListView.this.fHR.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aiN = agI.aiN();
                            if (aiN != null && !aiN.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aiN);
                                        xVar.amr().amR().mIsNeedAddCommenParam = false;
                                        xVar.amr().amR().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = agI.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (agI.aiB() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.amQ().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                agI.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(agI, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(agI.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.dwV = new h.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.dvB = new BdTypeListView(getContext());
        this.dvB.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.dvB.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.dvB.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.dvB.setFadingEdgeLength(0);
        this.dvB.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.dvB.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.fHn != null) {
                    FrsGameStrategyItemListView.this.fHn.bs(FrsGameStrategyItemListView.this.fHe, FrsGameStrategyItemListView.this.fHS);
                }
            }
        });
        this.dvB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.dJn != null) {
                    FrsGameStrategyItemListView.this.dJn.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.dvB);
        this.fHR = new c(this.mPageContext, this.dvB);
        this.fHR.b(this.xJ);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.dwV);
        this.dJn = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.dvB.setPullRefresh(this.mPullView);
        if (this.dwJ == null) {
            this.dwJ = new PbListView(this.mPageContext.getPageActivity());
            this.dwJ.createView();
        }
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.fHe && i2 == this.fHS)) {
            hideLoadingView();
            this.dvB.completePullRefresh();
            if (v.isEmpty(list) && v.isEmpty(this.mData)) {
                us(getContext().getString(R.string.no_data_text));
                aKk();
                this.mHasMore = false;
                return;
            }
            if (!v.isEmpty(list)) {
                this.mData = list;
            }
            this.fHR.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                aKi();
            } else {
                aKj();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void f(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.fHe && i2 == this.fHS)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.isEmpty(this.mData)) {
                us(str);
                aKk();
                return;
            }
            this.mPageContext.showToast(str);
            aKj();
        }
    }

    private void aKi() {
        this.mHasMore = true;
        this.dvB.setNextPage(this.dwJ);
        this.dwJ.startLoadData();
    }

    private void aKj() {
        this.mHasMore = false;
        this.dvB.setNextPage(this.dwJ);
        this.dwJ.endLoadData();
        this.dwJ.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void aKk() {
        this.mHasMore = false;
        this.dvB.setNextPage(null);
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
        if (this.dEq == null) {
            this.dEq = new com.baidu.tbadk.m.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.dEq.onChangeSkinType();
        }
        this.dEq.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.dEq != null) {
            this.dEq.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.fHn != null) {
            this.fHn.br(this.fHe, this.fHS);
        }
    }

    public void pullToRefresh() {
        this.dvB.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.dvB, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.fHn = aVar;
    }

    public void bx(int i, int i2) {
        this.fHe = i;
        this.fHS = i2;
        aKk();
        this.mData = new LinkedList();
        this.fHR.setData(this.mData);
        this.fHn.bt(i, i2);
    }

    public void bnI() {
        if (v.isEmpty(this.mData) && (this.fHe != 0 || this.fHS != 0)) {
            showLoadingView();
            this.fHn.br(this.fHe, this.fHS);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.fHe;
    }

    public int getLabelId() {
        return this.fHS;
    }

    public void onDestory() {
    }
}
