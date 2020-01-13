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
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes7.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private BdTypeListView efW;
    private PbListView ehe;
    private g.c eib;
    private com.baidu.tbadk.k.g epL;
    private com.baidu.tieba.frs.gametab.b exV;
    private int gxQ;
    private com.baidu.tieba.frs.game.strategy.tab.a gxZ;
    private c gyD;
    private int gyE;
    private List<m> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private h mPullView;
    private s zL;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.zL = new s() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bj axQ;
                com.baidu.tieba.frs.game.strategy.tab.e tk;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (axQ = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).axQ()) != null) {
                    if (FrsGameStrategyItemListView.this.gxZ != null && (tk = FrsGameStrategyItemListView.this.gxZ.tk(FrsGameStrategyItemListView.this.gxQ)) != null && (tk.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) tk.extra).getLabelName(FrsGameStrategyItemListView.this.gyE);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").cp("fid", FrsGameStrategyItemListView.this.gxZ.getForumId()).cp("tid", axQ.getId()).cp("obj_id", tk.tabName).cp("obj_locate", labelName));
                    }
                    if (axQ.aAV() == null || axQ.aAV().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (axQ.aAH() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Jb(axQ.getId())) {
                                readThreadHistory.Ja(axQ.getId());
                                FrsGameStrategyItemListView.this.gyD.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aAe = axQ.aAe();
                            if (aAe != null && !aAe.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aAe);
                                        xVar.aDU().aEu().mIsNeedAddCommenParam = false;
                                        xVar.aDU().aEu().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = axQ.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (axQ.azS() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aEt().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                axQ.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(axQ, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(axQ.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.eib = new g.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.ab(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.efW = new BdTypeListView(getContext());
        this.efW.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.efW.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.efW.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.efW.setFadingEdgeLength(0);
        this.efW.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.efW.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.gxZ != null) {
                    FrsGameStrategyItemListView.this.gxZ.bH(FrsGameStrategyItemListView.this.gxQ, FrsGameStrategyItemListView.this.gyE);
                }
            }
        });
        this.efW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.exV != null) {
                    FrsGameStrategyItemListView.this.exV.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.efW);
        this.gyD = new c(this.mPageContext, this.efW);
        this.gyD.b(this.zL);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.eib);
        this.exV = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.efW.setPullRefresh(this.mPullView);
        if (this.ehe == null) {
            this.ehe = new PbListView(this.mPageContext.getPageActivity());
            this.ehe.createView();
        }
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.gxQ && i2 == this.gyE)) {
            hideLoadingView();
            this.efW.completePullRefresh();
            if (v.isEmpty(list) && v.isEmpty(this.mData)) {
                zw(getContext().getString(R.string.no_data_text));
                bbc();
                this.mHasMore = false;
                return;
            }
            if (!v.isEmpty(list)) {
                this.mData = list;
            }
            this.gyD.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                bba();
            } else {
                bbb();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void j(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.gxQ && i2 == this.gyE)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.isEmpty(this.mData)) {
                zw(str);
                bbc();
                return;
            }
            this.mPageContext.showToast(str);
            bbb();
        }
    }

    private void bba() {
        this.mHasMore = true;
        this.efW.setNextPage(this.ehe);
        this.ehe.startLoadData();
    }

    private void bbb() {
        this.mHasMore = false;
        this.efW.setNextPage(this.ehe);
        this.ehe.endLoadData();
        this.ehe.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bbc() {
        this.mHasMore = false;
        this.efW.setNextPage(null);
    }

    private void zw(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.tE(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.epL == null) {
            this.epL = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.epL.onChangeSkinType();
        }
        this.epL.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.gxZ != null) {
            this.gxZ.bG(this.gxQ, this.gyE);
        }
    }

    public void pullToRefresh() {
        this.efW.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.efW, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.gxZ = aVar;
    }

    public void bM(int i, int i2) {
        this.gxQ = i;
        this.gyE = i2;
        bbc();
        this.mData = new LinkedList();
        this.gyD.setData(this.mData);
        this.gxZ.bI(i, i2);
    }

    public void bGf() {
        if (v.isEmpty(this.mData) && (this.gxQ != 0 || this.gyE != 0)) {
            showLoadingView();
            this.gxZ.bG(this.gxQ, this.gyE);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.gxQ;
    }

    public int getLabelId() {
        return this.gyE;
    }

    public void onDestory() {
    }
}
