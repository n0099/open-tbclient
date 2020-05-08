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
import com.baidu.adp.widget.ListView.v;
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
    private v Tw;
    private BdTypeListView eOj;
    private PbListView ePr;
    private g.c eQs;
    private com.baidu.tbadk.k.g eYg;
    private com.baidu.tieba.frs.gametab.b fhm;
    private int hkE;
    private com.baidu.tieba.frs.game.strategy.tab.a hkN;
    private c hlr;
    private int hls;
    private List<m> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private h mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Tw = new v() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bj aIu;
                com.baidu.tieba.frs.game.strategy.tab.e tU;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (aIu = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).aIu()) != null) {
                    if (FrsGameStrategyItemListView.this.hkN != null && (tU = FrsGameStrategyItemListView.this.hkN.tU(FrsGameStrategyItemListView.this.hkE)) != null && (tU.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) tU.extra).getLabelName(FrsGameStrategyItemListView.this.hls);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").cI("fid", FrsGameStrategyItemListView.this.hkN.getForumId()).cI("tid", aIu.getId()).cI("obj_id", tU.tabName).cI("obj_locate", labelName));
                    }
                    if (aIu.aLz() == null || aIu.aLz().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (aIu.aLm() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Lb(aIu.getId())) {
                                readThreadHistory.La(aIu.getId());
                                FrsGameStrategyItemListView.this.hlr.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aKJ = aIu.aKJ();
                            if (aKJ != null && !aKJ.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aKJ);
                                        xVar.aOw().aOW().mIsNeedAddCommenParam = false;
                                        xVar.aOw().aOW().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = aIu.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (aIu.aKx() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aOV().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                aIu.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(aIu, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(aIu.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.eQs = new g.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.G(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.eOj = new BdTypeListView(getContext());
        this.eOj.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.eOj.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eOj.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.eOj.setFadingEdgeLength(0);
        this.eOj.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.eOj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.hkN != null) {
                    FrsGameStrategyItemListView.this.hkN.bP(FrsGameStrategyItemListView.this.hkE, FrsGameStrategyItemListView.this.hls);
                }
            }
        });
        this.eOj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.fhm != null) {
                    FrsGameStrategyItemListView.this.fhm.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.eOj);
        this.hlr = new c(this.mPageContext, this.eOj);
        this.hlr.b(this.Tw);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.eQs);
        this.fhm = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.eOj.setPullRefresh(this.mPullView);
        if (this.ePr == null) {
            this.ePr = new PbListView(this.mPageContext.getPageActivity());
            this.ePr.createView();
        }
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.hkE && i2 == this.hls)) {
            hideLoadingView();
            this.eOj.completePullRefresh();
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(this.mData)) {
                By(getContext().getString(R.string.no_data_text));
                bmo();
                this.mHasMore = false;
                return;
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
                this.mData = list;
            }
            this.hlr.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                bmm();
            } else {
                bmn();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void j(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.hkE && i2 == this.hls)) {
            this.mHasMore = false;
            hideLoadingView();
            if (com.baidu.tbadk.core.util.v.isEmpty(this.mData)) {
                By(str);
                bmo();
                return;
            }
            this.mPageContext.showToast(str);
            bmn();
        }
    }

    private void bmm() {
        this.mHasMore = true;
        this.eOj.setNextPage(this.ePr);
        this.ePr.startLoadData();
    }

    private void bmn() {
        this.mHasMore = false;
        this.eOj.setNextPage(this.ePr);
        this.ePr.endLoadData();
        this.ePr.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bmo() {
        this.mHasMore = false;
        this.eOj.setNextPage(null);
    }

    private void By(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.vl(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.eYg == null) {
            this.eYg = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.eYg.onChangeSkinType();
        }
        this.eYg.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.hkN != null) {
            this.hkN.bO(this.hkE, this.hls);
        }
    }

    public void pullToRefresh() {
        this.eOj.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.eOj, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.hkN = aVar;
    }

    public void bU(int i, int i2) {
        this.hkE = i;
        this.hls = i2;
        bmo();
        this.mData = new LinkedList();
        this.hlr.setData(this.mData);
        this.hkN.bQ(i, i2);
    }

    public void bSt() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.mData) && (this.hkE != 0 || this.hls != 0)) {
            showLoadingView();
            this.hkN.bO(this.hkE, this.hls);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.hkE;
    }

    public int getLabelId() {
        return this.hls;
    }

    public void onDestory() {
    }
}
