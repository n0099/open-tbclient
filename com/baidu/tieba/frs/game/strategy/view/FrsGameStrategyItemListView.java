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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
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
    private ab Vu;
    private BdTypeListView gcr;
    private PbListView gdy;
    private f.c geE;
    private com.baidu.tbadk.k.g gmB;
    private com.baidu.tieba.frs.gametab.b gxx;
    private int iPT;
    private c iQF;
    private int iQG;
    private com.baidu.tieba.frs.game.strategy.tab.a iQc;
    private List<q> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Vu = new ab() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bw bhz;
                com.baidu.tieba.frs.game.strategy.tab.e zp;
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (bhz = ((com.baidu.tieba.frs.game.strategy.data.b) qVar).bhz()) != null) {
                    if (FrsGameStrategyItemListView.this.iQc != null && (zp = FrsGameStrategyItemListView.this.iQc.zp(FrsGameStrategyItemListView.this.iPT)) != null && (zp.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) zp.extra).getLabelName(FrsGameStrategyItemListView.this.iQG);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new aq("c12388").dR("fid", FrsGameStrategyItemListView.this.iQc.getForumId()).dR("tid", bhz.getId()).dR("obj_id", zp.tabName).dR("obj_locate", labelName));
                    }
                    if (bhz.bla() == null || bhz.bla().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (bhz.bkN() != 1 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.SK(bhz.getId())) {
                                readThreadHistory.SJ(bhz.getId());
                                FrsGameStrategyItemListView.this.iQF.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String bkg = bhz.bkg();
                            if (bkg != null && !bkg.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(bkg);
                                        aaVar.bon().boT().mIsNeedAddCommenParam = false;
                                        aaVar.bon().boT().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bhz.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bhz.bjV() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                be.boR().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bhz.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(bhz, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bhz.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.geE = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.I(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.gcr = new BdTypeListView(getContext());
        this.gcr.setDivider(new ColorDrawable(ap.getColor(R.color.cp_bg_line_c)));
        this.gcr.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.gcr.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.gcr.setFadingEdgeLength(0);
        this.gcr.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.gcr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.iQc != null) {
                    FrsGameStrategyItemListView.this.iQc.cq(FrsGameStrategyItemListView.this.iPT, FrsGameStrategyItemListView.this.iQG);
                }
            }
        });
        this.gcr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.gxx != null) {
                    FrsGameStrategyItemListView.this.gxx.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.gcr);
        this.iQF = new c(this.mPageContext, this.gcr);
        this.iQF.b(this.Vu);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.geE);
        this.gxx = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.gcr.setPullRefresh(this.mPullView);
        if (this.gdy == null) {
            this.gdy = new PbListView(this.mPageContext.getPageActivity());
            this.gdy.createView();
        }
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.iPT && i2 == this.iQG)) {
            hideLoadingView();
            this.gcr.completePullRefresh();
            if (y.isEmpty(list) && y.isEmpty(this.mData)) {
                IC(getContext().getString(R.string.no_data_text));
                bNw();
                this.mHasMore = false;
                return;
            }
            if (!y.isEmpty(list)) {
                this.mData = list;
            }
            this.iQF.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                TI();
            } else {
                TJ();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void m(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.iPT && i2 == this.iQG)) {
            this.mHasMore = false;
            hideLoadingView();
            if (y.isEmpty(this.mData)) {
                IC(str);
                bNw();
                return;
            }
            this.mPageContext.showToast(str);
            TJ();
        }
    }

    private void TI() {
        this.mHasMore = true;
        this.gcr.setNextPage(this.gdy);
        this.gdy.startLoadData();
    }

    private void TJ() {
        this.mHasMore = false;
        this.gcr.setNextPage(this.gdy);
        this.gdy.endLoadData();
        this.gdy.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bNw() {
        this.mHasMore = false;
        this.gcr.setNextPage(null);
    }

    private void IC(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.Cd(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.gmB == null) {
            this.gmB = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.gmB.onChangeSkinType();
        }
        this.gmB.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.iQc != null) {
            this.iQc.cp(this.iPT, this.iQG);
        }
    }

    public void pullToRefresh() {
        this.gcr.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.gcr, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.iQc = aVar;
    }

    public void cv(int i, int i2) {
        this.iPT = i;
        this.iQG = i2;
        bNw();
        this.mData = new LinkedList();
        this.iQF.setData(this.mData);
        this.iQc.cr(i, i2);
    }

    public void cAj() {
        if (y.isEmpty(this.mData) && (this.iPT != 0 || this.iQG != 0)) {
            showLoadingView();
            this.iQc.cp(this.iPT, this.iQG);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.iPT;
    }

    public int getLabelId() {
        return this.iQG;
    }

    public void onDestory() {
    }
}
