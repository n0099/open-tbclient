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
    private com.baidu.tieba.frs.gametab.b gDl;
    private BdTypeListView gih;
    private PbListView gjo;
    private f.c gkt;
    private com.baidu.tbadk.k.g gso;
    private int iVQ;
    private com.baidu.tieba.frs.game.strategy.tab.a iVZ;
    private c iWC;
    private int iWD;
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
                bw bjZ;
                com.baidu.tieba.frs.game.strategy.tab.e zC;
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (bjZ = ((com.baidu.tieba.frs.game.strategy.data.b) qVar).bjZ()) != null) {
                    if (FrsGameStrategyItemListView.this.iVZ != null && (zC = FrsGameStrategyItemListView.this.iVZ.zC(FrsGameStrategyItemListView.this.iVQ)) != null && (zC.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) zC.extra).getLabelName(FrsGameStrategyItemListView.this.iWD);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new aq("c12388").dR("fid", FrsGameStrategyItemListView.this.iVZ.getForumId()).dR("tid", bjZ.getId()).dR("obj_id", zC.tabName).dR("obj_locate", labelName));
                    }
                    if (bjZ.bnA() == null || bjZ.bnA().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (bjZ.bnn() != 1 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Tb(bjZ.getId())) {
                                readThreadHistory.Ta(bjZ.getId());
                                FrsGameStrategyItemListView.this.iWC.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String bmG = bjZ.bmG();
                            if (bmG != null && !bmG.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(bmG);
                                        aaVar.bqN().brt().mIsNeedAddCommenParam = false;
                                        aaVar.bqN().brt().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bjZ.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bjZ.bmv() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                be.brr().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bjZ.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(bjZ, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bjZ.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.gkt = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.gih = new BdTypeListView(getContext());
        this.gih.setDivider(new ColorDrawable(ap.getColor(R.color.cp_bg_line_c)));
        this.gih.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.gih.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.gih.setFadingEdgeLength(0);
        this.gih.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.gih.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.iVZ != null) {
                    FrsGameStrategyItemListView.this.iVZ.cs(FrsGameStrategyItemListView.this.iVQ, FrsGameStrategyItemListView.this.iWD);
                }
            }
        });
        this.gih.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.gDl != null) {
                    FrsGameStrategyItemListView.this.gDl.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.gih);
        this.iWC = new c(this.mPageContext, this.gih);
        this.iWC.b(this.Vu);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.gkt);
        this.gDl = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.gih.setPullRefresh(this.mPullView);
        if (this.gjo == null) {
            this.gjo = new PbListView(this.mPageContext.getPageActivity());
            this.gjo.createView();
        }
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.iVQ && i2 == this.iWD)) {
            hideLoadingView();
            this.gih.completePullRefresh();
            if (y.isEmpty(list) && y.isEmpty(this.mData)) {
                IT(getContext().getString(R.string.no_data_text));
                bPW();
                this.mHasMore = false;
                return;
            }
            if (!y.isEmpty(list)) {
                this.mData = list;
            }
            this.iWC.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                Wi();
            } else {
                Wj();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void m(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.iVQ && i2 == this.iWD)) {
            this.mHasMore = false;
            hideLoadingView();
            if (y.isEmpty(this.mData)) {
                IT(str);
                bPW();
                return;
            }
            this.mPageContext.showToast(str);
            Wj();
        }
    }

    private void Wi() {
        this.mHasMore = true;
        this.gih.setNextPage(this.gjo);
        this.gjo.startLoadData();
    }

    private void Wj() {
        this.mHasMore = false;
        this.gih.setNextPage(this.gjo);
        this.gjo.endLoadData();
        this.gjo.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bPW() {
        this.mHasMore = false;
        this.gih.setNextPage(null);
    }

    private void IT(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.Cr(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.gso == null) {
            this.gso = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.gso.onChangeSkinType();
        }
        this.gso.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.iVZ != null) {
            this.iVZ.cr(this.iVQ, this.iWD);
        }
    }

    public void pullToRefresh() {
        this.gih.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.gih, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.iVZ = aVar;
    }

    public void cx(int i, int i2) {
        this.iVQ = i;
        this.iWD = i2;
        bPW();
        this.mData = new LinkedList();
        this.iWC.setData(this.mData);
        this.iVZ.ct(i, i2);
    }

    public void cCK() {
        if (y.isEmpty(this.mData) && (this.iVQ != 0 || this.iWD != 0)) {
            showLoadingView();
            this.iVZ.cr(this.iVQ, this.iWD);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.iVQ;
    }

    public int getLabelId() {
        return this.iWD;
    }

    public void onDestory() {
    }
}
