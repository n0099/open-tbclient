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
/* loaded from: classes6.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private BdTypeListView efM;
    private PbListView egU;
    private g.c ehg;
    private com.baidu.tbadk.k.g eoy;
    private com.baidu.tieba.frs.gametab.b ewJ;
    private int guG;
    private com.baidu.tieba.frs.game.strategy.tab.a guP;
    private c gvt;
    private int gvu;
    private List<m> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private h mPullView;
    private s zH;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.zH = new s() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bj axx;
                com.baidu.tieba.frs.game.strategy.tab.e tf;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (axx = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).axx()) != null) {
                    if (FrsGameStrategyItemListView.this.guP != null && (tf = FrsGameStrategyItemListView.this.guP.tf(FrsGameStrategyItemListView.this.guG)) != null && (tf.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) tf.extra).getLabelName(FrsGameStrategyItemListView.this.gvu);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").cp("fid", FrsGameStrategyItemListView.this.guP.getForumId()).cp("tid", axx.getId()).cp("obj_id", tf.tabName).cp("obj_locate", labelName));
                    }
                    if (axx.aAC() == null || axx.aAC().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (axx.aAo() != 1 || bc.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.IR(axx.getId())) {
                                readThreadHistory.IQ(axx.getId());
                                FrsGameStrategyItemListView.this.gvt.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String azL = axx.azL();
                            if (azL != null && !azL.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(azL);
                                        xVar.aDB().aEb().mIsNeedAddCommenParam = false;
                                        xVar.aDB().aEb().mIsUseCurrentBDUSS = false;
                                        xVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = axx.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (axx.azz() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                ba.aEa().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                axx.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(axx, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(axx.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.ehg = new g.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.efM = new BdTypeListView(getContext());
        this.efM.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.efM.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.efM.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.efM.setFadingEdgeLength(0);
        this.efM.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.efM.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.guP != null) {
                    FrsGameStrategyItemListView.this.guP.bI(FrsGameStrategyItemListView.this.guG, FrsGameStrategyItemListView.this.gvu);
                }
            }
        });
        this.efM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.ewJ != null) {
                    FrsGameStrategyItemListView.this.ewJ.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.efM);
        this.gvt = new c(this.mPageContext, this.efM);
        this.gvt.b(this.zH);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.ehg);
        this.ewJ = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.efM.setPullRefresh(this.mPullView);
        if (this.egU == null) {
            this.egU = new PbListView(this.mPageContext.getPageActivity());
            this.egU.createView();
        }
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.guG && i2 == this.gvu)) {
            hideLoadingView();
            this.efM.completePullRefresh();
            if (v.isEmpty(list) && v.isEmpty(this.mData)) {
                zm(getContext().getString(R.string.no_data_text));
                baH();
                this.mHasMore = false;
                return;
            }
            if (!v.isEmpty(list)) {
                this.mData = list;
            }
            this.gvt.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                baF();
            } else {
                baG();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void h(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.guG && i2 == this.gvu)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.isEmpty(this.mData)) {
                zm(str);
                baH();
                return;
            }
            this.mPageContext.showToast(str);
            baG();
        }
    }

    private void baF() {
        this.mHasMore = true;
        this.efM.setNextPage(this.egU);
        this.egU.startLoadData();
    }

    private void baG() {
        this.mHasMore = false;
        this.efM.setNextPage(this.egU);
        this.egU.endLoadData();
        this.egU.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void baH() {
        this.mHasMore = false;
        this.efM.setNextPage(null);
    }

    private void zm(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.tA(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.eoy == null) {
            this.eoy = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.eoy.onChangeSkinType();
        }
        this.eoy.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.guP != null) {
            this.guP.bH(this.guG, this.gvu);
        }
    }

    public void pullToRefresh() {
        this.efM.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.efM, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.guP = aVar;
    }

    public void bN(int i, int i2) {
        this.guG = i;
        this.gvu = i2;
        baH();
        this.mData = new LinkedList();
        this.gvt.setData(this.mData);
        this.guP.bJ(i, i2);
    }

    public void bFd() {
        if (v.isEmpty(this.mData) && (this.guG != 0 || this.gvu != 0)) {
            showLoadingView();
            this.guP.bH(this.guG, this.gvu);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.guG;
    }

    public int getLabelId() {
        return this.gvu;
    }

    public void onDestory() {
    }
}
