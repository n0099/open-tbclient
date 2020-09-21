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
/* loaded from: classes21.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private ab Vd;
    private BdTypeListView fGf;
    private PbListView fHm;
    private f.c fIp;
    private com.baidu.tbadk.k.g fQf;
    private com.baidu.tieba.frs.gametab.b gbb;
    private int ioE;
    private com.baidu.tieba.frs.game.strategy.tab.a ioN;
    private c ipq;
    private int ipr;
    private List<q> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Vd = new ab() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bw bcY;
                com.baidu.tieba.frs.game.strategy.tab.e yq;
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (bcY = ((com.baidu.tieba.frs.game.strategy.data.b) qVar).bcY()) != null) {
                    if (FrsGameStrategyItemListView.this.ioN != null && (yq = FrsGameStrategyItemListView.this.ioN.yq(FrsGameStrategyItemListView.this.ioE)) != null && (yq.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) yq.extra).getLabelName(FrsGameStrategyItemListView.this.ipr);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new aq("c12388").dF("fid", FrsGameStrategyItemListView.this.ioN.getForumId()).dF("tid", bcY.getId()).dF("obj_id", yq.tabName).dF("obj_locate", labelName));
                    }
                    if (bcY.bgy() == null || bcY.bgy().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (bcY.bgl() != 1 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Rx(bcY.getId())) {
                                readThreadHistory.Rw(bcY.getId());
                                FrsGameStrategyItemListView.this.ipq.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String bfE = bcY.bfE();
                            if (bfE != null && !bfE.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(bfE);
                                        aaVar.bjL().bkq().mIsNeedAddCommenParam = false;
                                        aaVar.bjL().bkq().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bcY.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bcY.bft() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                be.bkp().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bcY.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(bcY, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bcY.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.fIp = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.fGf = new BdTypeListView(getContext());
        this.fGf.setDivider(new ColorDrawable(ap.getColor(R.color.cp_bg_line_c)));
        this.fGf.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.fGf.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.fGf.setFadingEdgeLength(0);
        this.fGf.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.fGf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.ioN != null) {
                    FrsGameStrategyItemListView.this.ioN.co(FrsGameStrategyItemListView.this.ioE, FrsGameStrategyItemListView.this.ipr);
                }
            }
        });
        this.fGf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.gbb != null) {
                    FrsGameStrategyItemListView.this.gbb.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.fGf);
        this.ipq = new c(this.mPageContext, this.fGf);
        this.ipq.b(this.Vd);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.fIp);
        this.gbb = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.fGf.setPullRefresh(this.mPullView);
        if (this.fHm == null) {
            this.fHm = new PbListView(this.mPageContext.getPageActivity());
            this.fHm.createView();
        }
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.ioE && i2 == this.ipr)) {
            hideLoadingView();
            this.fGf.completePullRefresh();
            if (y.isEmpty(list) && y.isEmpty(this.mData)) {
                Hq(getContext().getString(R.string.no_data_text));
                bIk();
                this.mHasMore = false;
                return;
            }
            if (!y.isEmpty(list)) {
                this.mData = list;
            }
            this.ipq.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                bIi();
            } else {
                bIj();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void k(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.ioE && i2 == this.ipr)) {
            this.mHasMore = false;
            hideLoadingView();
            if (y.isEmpty(this.mData)) {
                Hq(str);
                bIk();
                return;
            }
            this.mPageContext.showToast(str);
            bIj();
        }
    }

    private void bIi() {
        this.mHasMore = true;
        this.fGf.setNextPage(this.fHm);
        this.fHm.startLoadData();
    }

    private void bIj() {
        this.mHasMore = false;
        this.fGf.setNextPage(this.fHm);
        this.fHm.endLoadData();
        this.fHm.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bIk() {
        this.mHasMore = false;
        this.fGf.setNextPage(null);
    }

    private void Hq(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.AY(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.fQf == null) {
            this.fQf = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.fQf.onChangeSkinType();
        }
        this.fQf.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.ioN != null) {
            this.ioN.cn(this.ioE, this.ipr);
        }
    }

    public void pullToRefresh() {
        this.fGf.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.fGf, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.ioN = aVar;
    }

    public void ct(int i, int i2) {
        this.ioE = i;
        this.ipr = i2;
        bIk();
        this.mData = new LinkedList();
        this.ipq.setData(this.mData);
        this.ioN.cp(i, i2);
    }

    public void ctF() {
        if (y.isEmpty(this.mData) && (this.ioE != 0 || this.ipr != 0)) {
            showLoadingView();
            this.ioN.cn(this.ioE, this.ipr);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.ioE;
    }

    public int getLabelId() {
        return this.ipr;
    }

    public void onDestory() {
    }
}
