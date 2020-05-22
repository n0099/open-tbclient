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
    private BdTypeListView faQ;
    private PbListView fbY;
    private f.c fda;
    private com.baidu.tbadk.k.g fkQ;
    private com.baidu.tieba.frs.gametab.b fuV;
    private c hAf;
    private int hAg;
    private com.baidu.tieba.frs.game.strategy.tab.a hzB;
    private int hzs;
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
                com.baidu.tieba.frs.game.strategy.tab.e uz;
                if (oVar != null && (oVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (aOi = ((com.baidu.tieba.frs.game.strategy.data.b) oVar).aOi()) != null) {
                    if (FrsGameStrategyItemListView.this.hzB != null && (uz = FrsGameStrategyItemListView.this.hzB.uz(FrsGameStrategyItemListView.this.hzs)) != null && (uz.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) uz.extra).getLabelName(FrsGameStrategyItemListView.this.hAg);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").dh("fid", FrsGameStrategyItemListView.this.hzB.getForumId()).dh("tid", aOi.getId()).dh("obj_id", uz.tabName).dh("obj_locate", labelName));
                    }
                    if (aOi.aRy() == null || aOi.aRy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (aOi.aRl() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.MO(aOi.getId())) {
                                readThreadHistory.MN(aOi.getId());
                                FrsGameStrategyItemListView.this.hAf.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aQE = aOi.aQE();
                            if (aQE != null && !aQE.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aQE);
                                        xVar.aUA().aVa().mIsNeedAddCommenParam = false;
                                        xVar.aUA().aVa().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = aOi.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (aOi.aQs() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aUZ().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
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
        this.fda = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.faQ = new BdTypeListView(getContext());
        this.faQ.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.faQ.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.faQ.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.faQ.setFadingEdgeLength(0);
        this.faQ.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.faQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.hzB != null) {
                    FrsGameStrategyItemListView.this.hzB.bU(FrsGameStrategyItemListView.this.hzs, FrsGameStrategyItemListView.this.hAg);
                }
            }
        });
        this.faQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.fuV != null) {
                    FrsGameStrategyItemListView.this.fuV.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.faQ);
        this.hAf = new c(this.mPageContext, this.faQ);
        this.hAf.b(this.TI);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.fda);
        this.fuV = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.faQ.setPullRefresh(this.mPullView);
        if (this.fbY == null) {
            this.fbY = new PbListView(this.mPageContext.getPageActivity());
            this.fbY.createView();
        }
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<o> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.hzs && i2 == this.hAg)) {
            hideLoadingView();
            this.faQ.completePullRefresh();
            if (v.isEmpty(list) && v.isEmpty(this.mData)) {
                Dh(getContext().getString(R.string.no_data_text));
                brM();
                this.mHasMore = false;
                return;
            }
            if (!v.isEmpty(list)) {
                this.mData = list;
            }
            this.hAf.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                brK();
            } else {
                brL();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void j(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.hzs && i2 == this.hAg)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.isEmpty(this.mData)) {
                Dh(str);
                brM();
                return;
            }
            this.mPageContext.showToast(str);
            brL();
        }
    }

    private void brK() {
        this.mHasMore = true;
        this.faQ.setNextPage(this.fbY);
        this.fbY.startLoadData();
    }

    private void brL() {
        this.mHasMore = false;
        this.faQ.setNextPage(this.fbY);
        this.fbY.endLoadData();
        this.fbY.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void brM() {
        this.mHasMore = false;
        this.faQ.setNextPage(null);
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
        if (this.fkQ == null) {
            this.fkQ = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.fkQ.onChangeSkinType();
        }
        this.fkQ.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.hzB != null) {
            this.hzB.bT(this.hzs, this.hAg);
        }
    }

    public void pullToRefresh() {
        this.faQ.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.faQ, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.hzB = aVar;
    }

    public void bZ(int i, int i2) {
        this.hzs = i;
        this.hAg = i2;
        brM();
        this.mData = new LinkedList();
        this.hAf.setData(this.mData);
        this.hzB.bV(i, i2);
    }

    public void bYP() {
        if (v.isEmpty(this.mData) && (this.hzs != 0 || this.hAg != 0)) {
            showLoadingView();
            this.hzB.bT(this.hzs, this.hAg);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.hzs;
    }

    public int getLabelId() {
        return this.hAg;
    }

    public void onDestory() {
    }
}
