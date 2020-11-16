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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private ab Vv;
    private com.baidu.tieba.frs.gametab.b gCS;
    private BdTypeListView ghN;
    private PbListView giV;
    private f.c gka;
    private com.baidu.tbadk.k.g grV;
    private int iWC;
    private com.baidu.tieba.frs.game.strategy.tab.a iWL;
    private c iXo;
    private int iXp;
    private List<q> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Vv = new ab() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bx bjd;
                com.baidu.tieba.frs.game.strategy.tab.e Aa;
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (bjd = ((com.baidu.tieba.frs.game.strategy.data.b) qVar).bjd()) != null) {
                    if (FrsGameStrategyItemListView.this.iWL != null && (Aa = FrsGameStrategyItemListView.this.iWL.Aa(FrsGameStrategyItemListView.this.iWC)) != null && (Aa.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) Aa.extra).getLabelName(FrsGameStrategyItemListView.this.iXp);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new ar("c12388").dR("fid", FrsGameStrategyItemListView.this.iWL.getForumId()).dR("tid", bjd.getId()).dR("obj_id", Aa.tabName).dR("obj_locate", labelName));
                    }
                    if (bjd.bmE() == null || bjd.bmE().getGroup_id() == 0 || bh.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (bjd.bmp() != 1 || bh.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.SM(bjd.getId())) {
                                readThreadHistory.SL(bjd.getId());
                                FrsGameStrategyItemListView.this.iXo.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String blI = bjd.blI();
                            if (blI != null && !blI.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(blI);
                                        aaVar.bqa().bqH().mIsNeedAddCommenParam = false;
                                        aaVar.bqa().bqH().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bjd.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bjd.blx() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bf.bqF().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bjd.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(bjd, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bjd.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.gka = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.ghN = new BdTypeListView(getContext());
        this.ghN.setDivider(new ColorDrawable(ap.getColor(R.color.CAM_X0204)));
        this.ghN.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.ghN.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.ghN.setFadingEdgeLength(0);
        this.ghN.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.ghN.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.iWL != null) {
                    FrsGameStrategyItemListView.this.iWL.cs(FrsGameStrategyItemListView.this.iWC, FrsGameStrategyItemListView.this.iXp);
                }
            }
        });
        this.ghN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.gCS != null) {
                    FrsGameStrategyItemListView.this.gCS.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.ghN);
        this.iXo = new c(this.mPageContext, this.ghN);
        this.iXo.b(this.Vv);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.gka);
        this.gCS = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.ghN.setPullRefresh(this.mPullView);
        if (this.giV == null) {
            this.giV = new PbListView(this.mPageContext.getPageActivity());
            this.giV.createView();
        }
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.iWC && i2 == this.iXp)) {
            hideLoadingView();
            this.ghN.completePullRefresh();
            if (y.isEmpty(list) && y.isEmpty(this.mData)) {
                Iu(getContext().getString(R.string.no_data_text));
                bPp();
                this.mHasMore = false;
                return;
            }
            if (!y.isEmpty(list)) {
                this.mData = list;
            }
            this.iXo.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                Vz();
            } else {
                VA();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void l(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.iWC && i2 == this.iXp)) {
            this.mHasMore = false;
            hideLoadingView();
            if (y.isEmpty(this.mData)) {
                Iu(str);
                bPp();
                return;
            }
            this.mPageContext.showToast(str);
            VA();
        }
    }

    private void Vz() {
        this.mHasMore = true;
        this.ghN.setNextPage(this.giV);
        this.giV.startLoadData();
    }

    private void VA() {
        this.mHasMore = false;
        this.ghN.setNextPage(this.giV);
        this.giV.endLoadData();
        this.giV.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bPp() {
        this.mHasMore = false;
        this.ghN.setNextPage(null);
    }

    private void Iu(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.BQ(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.grV == null) {
            this.grV = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.grV.onChangeSkinType();
        }
        this.grV.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.iWL != null) {
            this.iWL.cr(this.iWC, this.iXp);
        }
    }

    public void pullToRefresh() {
        this.ghN.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.ghN, R.color.CAM_X0204);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.iWL = aVar;
    }

    public void cx(int i, int i2) {
        this.iWC = i;
        this.iXp = i2;
        bPp();
        this.mData = new LinkedList();
        this.iXo.setData(this.mData);
        this.iWL.ct(i, i2);
    }

    public void cCo() {
        if (y.isEmpty(this.mData) && (this.iWC != 0 || this.iXp != 0)) {
            showLoadingView();
            this.iWL.cr(this.iWC, this.iXp);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.iWC;
    }

    public int getLabelId() {
        return this.iXp;
    }

    public void onDestory() {
    }
}
