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
    private com.baidu.tieba.frs.gametab.b eCf;
    private BdTypeListView ekb;
    private PbListView elj;
    private g.c emj;
    private com.baidu.tbadk.k.g etX;
    private c gAF;
    private int gAG;
    private com.baidu.tieba.frs.game.strategy.tab.a gAb;
    private int gzS;
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
                bj aAg;
                com.baidu.tieba.frs.game.strategy.tab.e tq;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (aAg = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).aAg()) != null) {
                    if (FrsGameStrategyItemListView.this.gAb != null && (tq = FrsGameStrategyItemListView.this.gAb.tq(FrsGameStrategyItemListView.this.gzS)) != null && (tq.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) tq.extra).getLabelName(FrsGameStrategyItemListView.this.gAG);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").cy("fid", FrsGameStrategyItemListView.this.gAb.getForumId()).cy("tid", aAg.getId()).cy("obj_id", tq.tabName).cy("obj_locate", labelName));
                    }
                    if (aAg.aDl() == null || aAg.aDl().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (aAg.aCY() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Jo(aAg.getId())) {
                                readThreadHistory.Jn(aAg.getId());
                                FrsGameStrategyItemListView.this.gAF.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aCv = aAg.aCv();
                            if (aCv != null && !aCv.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aCv);
                                        xVar.aGg().aGH().mIsNeedAddCommenParam = false;
                                        xVar.aGg().aGH().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = aAg.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (aAg.aCj() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aGG().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                aAg.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(aAg, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(aAg.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.emj = new g.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.ekb = new BdTypeListView(getContext());
        this.ekb.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.ekb.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.ekb.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.ekb.setFadingEdgeLength(0);
        this.ekb.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.ekb.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.gAb != null) {
                    FrsGameStrategyItemListView.this.gAb.bI(FrsGameStrategyItemListView.this.gzS, FrsGameStrategyItemListView.this.gAG);
                }
            }
        });
        this.ekb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.eCf != null) {
                    FrsGameStrategyItemListView.this.eCf.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.ekb);
        this.gAF = new c(this.mPageContext, this.ekb);
        this.gAF.b(this.Ae);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.emj);
        this.eCf = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.ekb.setPullRefresh(this.mPullView);
        if (this.elj == null) {
            this.elj = new PbListView(this.mPageContext.getPageActivity());
            this.elj.createView();
        }
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.gzS && i2 == this.gAG)) {
            hideLoadingView();
            this.ekb.completePullRefresh();
            if (v.isEmpty(list) && v.isEmpty(this.mData)) {
                zM(getContext().getString(R.string.no_data_text));
                bdt();
                this.mHasMore = false;
                return;
            }
            if (!v.isEmpty(list)) {
                this.mData = list;
            }
            this.gAF.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                bdr();
            } else {
                bds();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void j(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.gzS && i2 == this.gAG)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.isEmpty(this.mData)) {
                zM(str);
                bdt();
                return;
            }
            this.mPageContext.showToast(str);
            bds();
        }
    }

    private void bdr() {
        this.mHasMore = true;
        this.ekb.setNextPage(this.elj);
        this.elj.startLoadData();
    }

    private void bds() {
        this.mHasMore = false;
        this.ekb.setNextPage(this.elj);
        this.elj.endLoadData();
        this.elj.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bdt() {
        this.mHasMore = false;
        this.ekb.setNextPage(null);
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
        if (this.etX == null) {
            this.etX = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.etX.onChangeSkinType();
        }
        this.etX.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.gAb != null) {
            this.gAb.bH(this.gzS, this.gAG);
        }
    }

    public void pullToRefresh() {
        this.ekb.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.ekb, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.gAb = aVar;
    }

    public void bN(int i, int i2) {
        this.gzS = i;
        this.gAG = i2;
        bdt();
        this.mData = new LinkedList();
        this.gAF.setData(this.mData);
        this.gAb.bJ(i, i2);
    }

    public void bHJ() {
        if (v.isEmpty(this.mData) && (this.gzS != 0 || this.gAG != 0)) {
            showLoadingView();
            this.gAb.bH(this.gzS, this.gAG);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.gzS;
    }

    public int getLabelId() {
        return this.gAG;
    }

    public void onDestory() {
    }
}
