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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private x TI;
    private BdTypeListView fbb;
    private PbListView fcj;
    private f.c fdl;
    private com.baidu.tbadk.k.g flb;
    private com.baidu.tieba.frs.gametab.b fvg;
    private c hAS;
    private int hAT;
    private int hAf;
    private com.baidu.tieba.frs.game.strategy.tab.a hAo;
    private List<o> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.TI = new x() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bk aOi;
                com.baidu.tieba.frs.game.strategy.tab.e uB;
                if (oVar != null && (oVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (aOi = ((com.baidu.tieba.frs.game.strategy.data.b) oVar).aOi()) != null) {
                    if (FrsGameStrategyItemListView.this.hAo != null && (uB = FrsGameStrategyItemListView.this.hAo.uB(FrsGameStrategyItemListView.this.hAf)) != null && (uB.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) uB.extra).getLabelName(FrsGameStrategyItemListView.this.hAT);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").dh("fid", FrsGameStrategyItemListView.this.hAo.getForumId()).dh("tid", aOi.getId()).dh("obj_id", uB.tabName).dh("obj_locate", labelName));
                    }
                    if (aOi.aRy() == null || aOi.aRy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (aOi.aRl() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.MP(aOi.getId())) {
                                readThreadHistory.MO(aOi.getId());
                                FrsGameStrategyItemListView.this.hAS.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aQE = aOi.aQE();
                            if (aQE != null && !aQE.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aQE);
                                        xVar.aUA().aVb().mIsNeedAddCommenParam = false;
                                        xVar.aUA().aVb().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = aOi.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (aOi.aQs() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aVa().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                aOi.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(aOi, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(aOi.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.fdl = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.G(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.fbb = new BdTypeListView(getContext());
        this.fbb.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.fbb.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.fbb.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.fbb.setFadingEdgeLength(0);
        this.fbb.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.fbb.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.hAo != null) {
                    FrsGameStrategyItemListView.this.hAo.bU(FrsGameStrategyItemListView.this.hAf, FrsGameStrategyItemListView.this.hAT);
                }
            }
        });
        this.fbb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.fvg != null) {
                    FrsGameStrategyItemListView.this.fvg.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.fbb);
        this.hAS = new c(this.mPageContext, this.fbb);
        this.hAS.b(this.TI);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.fdl);
        this.fvg = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.fbb.setPullRefresh(this.mPullView);
        if (this.fcj == null) {
            this.fcj = new PbListView(this.mPageContext.getPageActivity());
            this.fcj.createView();
        }
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<o> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.hAf && i2 == this.hAT)) {
            hideLoadingView();
            this.fbb.completePullRefresh();
            if (v.isEmpty(list) && v.isEmpty(this.mData)) {
                Dh(getContext().getString(R.string.no_data_text));
                brO();
                this.mHasMore = false;
                return;
            }
            if (!v.isEmpty(list)) {
                this.mData = list;
            }
            this.hAS.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                brM();
            } else {
                brN();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void j(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.hAf && i2 == this.hAT)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.isEmpty(this.mData)) {
                Dh(str);
                brO();
                return;
            }
            this.mPageContext.showToast(str);
            brN();
        }
    }

    private void brM() {
        this.mHasMore = true;
        this.fbb.setNextPage(this.fcj);
        this.fcj.startLoadData();
    }

    private void brN() {
        this.mHasMore = false;
        this.fbb.setNextPage(this.fcj);
        this.fcj.endLoadData();
        this.fcj.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void brO() {
        this.mHasMore = false;
        this.fbb.setNextPage(null);
    }

    private void Dh(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.wR(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.flb == null) {
            this.flb = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.flb.onChangeSkinType();
        }
        this.flb.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.hAo != null) {
            this.hAo.bT(this.hAf, this.hAT);
        }
    }

    public void pullToRefresh() {
        this.fbb.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.fbb, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.hAo = aVar;
    }

    public void bZ(int i, int i2) {
        this.hAf = i;
        this.hAT = i2;
        brO();
        this.mData = new LinkedList();
        this.hAS.setData(this.mData);
        this.hAo.bV(i, i2);
    }

    public void bYX() {
        if (v.isEmpty(this.mData) && (this.hAf != 0 || this.hAT != 0)) {
            showLoadingView();
            this.hAo.bT(this.hAf, this.hAT);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.hAf;
    }

    public int getLabelId() {
        return this.hAT;
    }

    public void onDestory() {
    }
}
