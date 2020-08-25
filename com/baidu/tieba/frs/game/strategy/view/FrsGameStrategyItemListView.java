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
/* loaded from: classes16.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private ab UJ;
    private BdTypeListView fCP;
    private PbListView fDW;
    private f.c fEZ;
    private com.baidu.tbadk.k.g fMN;
    private com.baidu.tieba.frs.gametab.b fXJ;
    private com.baidu.tieba.frs.game.strategy.tab.a ihF;
    private int ihw;
    private c iii;
    private int iij;
    private List<q> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.UJ = new ab() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bw bce;
                com.baidu.tieba.frs.game.strategy.tab.e xR;
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (bce = ((com.baidu.tieba.frs.game.strategy.data.b) qVar).bce()) != null) {
                    if (FrsGameStrategyItemListView.this.ihF != null && (xR = FrsGameStrategyItemListView.this.ihF.xR(FrsGameStrategyItemListView.this.ihw)) != null && (xR.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) xR.extra).getLabelName(FrsGameStrategyItemListView.this.iij);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new aq("c12388").dD("fid", FrsGameStrategyItemListView.this.ihF.getForumId()).dD("tid", bce.getId()).dD("obj_id", xR.tabName).dD("obj_locate", labelName));
                    }
                    if (bce.bfE() == null || bce.bfE().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (bce.bfr() != 1 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.QX(bce.getId())) {
                                readThreadHistory.QW(bce.getId());
                                FrsGameStrategyItemListView.this.iii.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String beK = bce.beK();
                            if (beK != null && !beK.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(beK);
                                        aaVar.biQ().bjv().mIsNeedAddCommenParam = false;
                                        aaVar.biQ().bjv().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bce.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bce.bez() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                be.bju().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bce.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(bce, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bce.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.fEZ = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.fCP = new BdTypeListView(getContext());
        this.fCP.setDivider(new ColorDrawable(ap.getColor(R.color.cp_bg_line_c)));
        this.fCP.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.fCP.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.fCP.setFadingEdgeLength(0);
        this.fCP.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.fCP.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.ihF != null) {
                    FrsGameStrategyItemListView.this.ihF.cl(FrsGameStrategyItemListView.this.ihw, FrsGameStrategyItemListView.this.iij);
                }
            }
        });
        this.fCP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.fXJ != null) {
                    FrsGameStrategyItemListView.this.fXJ.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.fCP);
        this.iii = new c(this.mPageContext, this.fCP);
        this.iii.b(this.UJ);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.fEZ);
        this.fXJ = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.fCP.setPullRefresh(this.mPullView);
        if (this.fDW == null) {
            this.fDW = new PbListView(this.mPageContext.getPageActivity());
            this.fDW.createView();
        }
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.ihw && i2 == this.iij)) {
            hideLoadingView();
            this.fCP.completePullRefresh();
            if (y.isEmpty(list) && y.isEmpty(this.mData)) {
                GS(getContext().getString(R.string.no_data_text));
                bGT();
                this.mHasMore = false;
                return;
            }
            if (!y.isEmpty(list)) {
                this.mData = list;
            }
            this.iii.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                bGR();
            } else {
                bGS();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void j(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.ihw && i2 == this.iij)) {
            this.mHasMore = false;
            hideLoadingView();
            if (y.isEmpty(this.mData)) {
                GS(str);
                bGT();
                return;
            }
            this.mPageContext.showToast(str);
            bGS();
        }
    }

    private void bGR() {
        this.mHasMore = true;
        this.fCP.setNextPage(this.fDW);
        this.fDW.startLoadData();
    }

    private void bGS() {
        this.mHasMore = false;
        this.fCP.setNextPage(this.fDW);
        this.fDW.endLoadData();
        this.fDW.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bGT() {
        this.mHasMore = false;
        this.fCP.setNextPage(null);
    }

    private void GS(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.AB(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.fMN == null) {
            this.fMN = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.fMN.onChangeSkinType();
        }
        this.fMN.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.ihF != null) {
            this.ihF.ck(this.ihw, this.iij);
        }
    }

    public void pullToRefresh() {
        this.fCP.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.fCP, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.ihF = aVar;
    }

    public void cq(int i, int i2) {
        this.ihw = i;
        this.iij = i2;
        bGT();
        this.mData = new LinkedList();
        this.iii.setData(this.mData);
        this.ihF.cm(i, i2);
    }

    public void cqr() {
        if (y.isEmpty(this.mData) && (this.ihw != 0 || this.iij != 0)) {
            showLoadingView();
            this.ihF.ck(this.ihw, this.iij);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.ihw;
    }

    public int getLabelId() {
        return this.iij;
    }

    public void onDestory() {
    }
}
