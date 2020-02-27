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
/* loaded from: classes9.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private s Ae;
    private com.baidu.tieba.frs.gametab.b eCe;
    private BdTypeListView eka;
    private PbListView eli;
    private g.c emi;
    private com.baidu.tbadk.k.g etW;
    private c gAD;
    private int gAE;
    private int gzQ;
    private com.baidu.tieba.frs.game.strategy.tab.a gzZ;
    private List<m> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private h mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Ae = new s() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bj aAe;
                com.baidu.tieba.frs.game.strategy.tab.e tq;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (aAe = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).aAe()) != null) {
                    if (FrsGameStrategyItemListView.this.gzZ != null && (tq = FrsGameStrategyItemListView.this.gzZ.tq(FrsGameStrategyItemListView.this.gzQ)) != null && (tq.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) tq.extra).getLabelName(FrsGameStrategyItemListView.this.gAE);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").cy("fid", FrsGameStrategyItemListView.this.gzZ.getForumId()).cy("tid", aAe.getId()).cy("obj_id", tq.tabName).cy("obj_locate", labelName));
                    }
                    if (aAe.aDj() == null || aAe.aDj().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (aAe.aCW() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Jo(aAe.getId())) {
                                readThreadHistory.Jn(aAe.getId());
                                FrsGameStrategyItemListView.this.gAD.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aCt = aAe.aCt();
                            if (aCt != null && !aCt.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aCt);
                                        xVar.aGe().aGF().mIsNeedAddCommenParam = false;
                                        xVar.aGe().aGF().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = aAe.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (aAe.aCh() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aGE().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                aAe.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(aAe, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(aAe.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.emi = new g.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.eka = new BdTypeListView(getContext());
        this.eka.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.eka.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eka.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.eka.setFadingEdgeLength(0);
        this.eka.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.eka.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.gzZ != null) {
                    FrsGameStrategyItemListView.this.gzZ.bI(FrsGameStrategyItemListView.this.gzQ, FrsGameStrategyItemListView.this.gAE);
                }
            }
        });
        this.eka.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.eCe != null) {
                    FrsGameStrategyItemListView.this.eCe.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.eka);
        this.gAD = new c(this.mPageContext, this.eka);
        this.gAD.b(this.Ae);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.emi);
        this.eCe = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.eka.setPullRefresh(this.mPullView);
        if (this.eli == null) {
            this.eli = new PbListView(this.mPageContext.getPageActivity());
            this.eli.createView();
        }
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.gzQ && i2 == this.gAE)) {
            hideLoadingView();
            this.eka.completePullRefresh();
            if (v.isEmpty(list) && v.isEmpty(this.mData)) {
                zM(getContext().getString(R.string.no_data_text));
                bdr();
                this.mHasMore = false;
                return;
            }
            if (!v.isEmpty(list)) {
                this.mData = list;
            }
            this.gAD.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                bdp();
            } else {
                bdq();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void j(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.gzQ && i2 == this.gAE)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.isEmpty(this.mData)) {
                zM(str);
                bdr();
                return;
            }
            this.mPageContext.showToast(str);
            bdq();
        }
    }

    private void bdp() {
        this.mHasMore = true;
        this.eka.setNextPage(this.eli);
        this.eli.startLoadData();
    }

    private void bdq() {
        this.mHasMore = false;
        this.eka.setNextPage(this.eli);
        this.eli.endLoadData();
        this.eli.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bdr() {
        this.mHasMore = false;
        this.eka.setNextPage(null);
    }

    private void zM(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.tU(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.etW == null) {
            this.etW = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.etW.onChangeSkinType();
        }
        this.etW.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.gzZ != null) {
            this.gzZ.bH(this.gzQ, this.gAE);
        }
    }

    public void pullToRefresh() {
        this.eka.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.eka, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.gzZ = aVar;
    }

    public void bN(int i, int i2) {
        this.gzQ = i;
        this.gAE = i2;
        bdr();
        this.mData = new LinkedList();
        this.gAD.setData(this.mData);
        this.gzZ.bJ(i, i2);
    }

    public void bHH() {
        if (v.isEmpty(this.mData) && (this.gzQ != 0 || this.gAE != 0)) {
            showLoadingView();
            this.gzZ.bH(this.gzQ, this.gAE);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.gzQ;
    }

    public int getLabelId() {
        return this.gAE;
    }

    public void onDestory() {
    }
}
