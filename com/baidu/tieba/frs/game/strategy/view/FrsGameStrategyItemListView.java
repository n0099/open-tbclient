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
    private com.baidu.tieba.frs.gametab.b eCO;
    private BdTypeListView ekE;
    private PbListView elM;
    private g.c emN;
    private com.baidu.tbadk.k.g euG;
    private c gBP;
    private int gBQ;
    private int gBc;
    private com.baidu.tieba.frs.game.strategy.tab.a gBl;
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
                bj aAj;
                com.baidu.tieba.frs.game.strategy.tab.e tw;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (aAj = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).aAj()) != null) {
                    if (FrsGameStrategyItemListView.this.gBl != null && (tw = FrsGameStrategyItemListView.this.gBl.tw(FrsGameStrategyItemListView.this.gBc)) != null && (tw.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) tw.extra).getLabelName(FrsGameStrategyItemListView.this.gBQ);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").cx("fid", FrsGameStrategyItemListView.this.gBl.getForumId()).cx("tid", aAj.getId()).cx("obj_id", tw.tabName).cx("obj_locate", labelName));
                    }
                    if (aAj.aDo() == null || aAj.aDo().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (aAj.aDb() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Jp(aAj.getId())) {
                                readThreadHistory.Jo(aAj.getId());
                                FrsGameStrategyItemListView.this.gBP.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aCy = aAj.aCy();
                            if (aCy != null && !aCy.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aCy);
                                        xVar.aGk().aGL().mIsNeedAddCommenParam = false;
                                        xVar.aGk().aGL().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = aAj.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (aAj.aCm() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aGK().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                aAj.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(aAj, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(aAj.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.emN = new g.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.ekE = new BdTypeListView(getContext());
        this.ekE.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.ekE.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.ekE.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.ekE.setFadingEdgeLength(0);
        this.ekE.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.ekE.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.gBl != null) {
                    FrsGameStrategyItemListView.this.gBl.bJ(FrsGameStrategyItemListView.this.gBc, FrsGameStrategyItemListView.this.gBQ);
                }
            }
        });
        this.ekE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.eCO != null) {
                    FrsGameStrategyItemListView.this.eCO.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.ekE);
        this.gBP = new c(this.mPageContext, this.ekE);
        this.gBP.b(this.Ae);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.emN);
        this.eCO = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.ekE.setPullRefresh(this.mPullView);
        if (this.elM == null) {
            this.elM = new PbListView(this.mPageContext.getPageActivity());
            this.elM.createView();
        }
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.gBc && i2 == this.gBQ)) {
            hideLoadingView();
            this.ekE.completePullRefresh();
            if (v.isEmpty(list) && v.isEmpty(this.mData)) {
                zP(getContext().getString(R.string.no_data_text));
                bdz();
                this.mHasMore = false;
                return;
            }
            if (!v.isEmpty(list)) {
                this.mData = list;
            }
            this.gBP.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                bdx();
            } else {
                bdy();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void j(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.gBc && i2 == this.gBQ)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.isEmpty(this.mData)) {
                zP(str);
                bdz();
                return;
            }
            this.mPageContext.showToast(str);
            bdy();
        }
    }

    private void bdx() {
        this.mHasMore = true;
        this.ekE.setNextPage(this.elM);
        this.elM.startLoadData();
    }

    private void bdy() {
        this.mHasMore = false;
        this.ekE.setNextPage(this.elM);
        this.elM.endLoadData();
        this.elM.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bdz() {
        this.mHasMore = false;
        this.ekE.setNextPage(null);
    }

    private void zP(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.tV(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.euG == null) {
            this.euG = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.euG.onChangeSkinType();
        }
        this.euG.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.gBl != null) {
            this.gBl.bI(this.gBc, this.gBQ);
        }
    }

    public void pullToRefresh() {
        this.ekE.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.ekE, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.gBl = aVar;
    }

    public void bO(int i, int i2) {
        this.gBc = i;
        this.gBQ = i2;
        bdz();
        this.mData = new LinkedList();
        this.gBP.setData(this.mData);
        this.gBl.bK(i, i2);
    }

    public void bHW() {
        if (v.isEmpty(this.mData) && (this.gBc != 0 || this.gBQ != 0)) {
            showLoadingView();
            this.gBl.bI(this.gBc, this.gBQ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.gBc;
    }

    public int getLabelId() {
        return this.gBQ;
    }

    public void onDestory() {
    }
}
