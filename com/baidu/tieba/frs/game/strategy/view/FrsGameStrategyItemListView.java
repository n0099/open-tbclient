package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private w XE;
    private BdTypeListView gAY;
    private PbListView gCf;
    private f.c gDk;
    private g gLk;
    private com.baidu.tieba.frs.gametab.b gXE;
    private c jAl;
    private int jAm;
    private com.baidu.tieba.frs.game.strategy.tab.a jzI;
    private int jzz;
    private List<n> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.XE = new w() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                cb blp;
                com.baidu.tieba.frs.game.strategy.tab.e zF;
                if (nVar != null && (nVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (blp = ((com.baidu.tieba.frs.game.strategy.data.b) nVar).blp()) != null) {
                    if (FrsGameStrategyItemListView.this.jzI != null && (zF = FrsGameStrategyItemListView.this.jzI.zF(FrsGameStrategyItemListView.this.jzz)) != null && (zF.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) zF.extra).getLabelName(FrsGameStrategyItemListView.this.jAm);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new ar("c12388").dR("fid", FrsGameStrategyItemListView.this.jzI.getForumId()).dR("tid", blp.getId()).dR("obj_id", zF.tabName).dR("obj_locate", labelName));
                    }
                    if (blp.boT() == null || blp.boT().getGroup_id() == 0 || bh.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (blp.boE() != 1 || bh.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.TT(blp.getId())) {
                                readThreadHistory.TS(blp.getId());
                                FrsGameStrategyItemListView.this.jAl.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String bnY = blp.bnY();
                            if (bnY != null && !bnY.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(bnY);
                                        aaVar.bsu().btd().mIsNeedAddCommenParam = false;
                                        aaVar.bsu().btd().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = blp.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (blp.bnN() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bf.bsY().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                blp.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(blp, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(blp.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.gDk = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) j.J(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.gAY = new BdTypeListView(getContext());
        this.gAY.setDivider(new ColorDrawable(ap.getColor(R.color.CAM_X0204)));
        this.gAY.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.gAY.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.gAY.setFadingEdgeLength(0);
        this.gAY.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.gAY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.jzI != null) {
                    FrsGameStrategyItemListView.this.jzI.cs(FrsGameStrategyItemListView.this.jzz, FrsGameStrategyItemListView.this.jAm);
                }
            }
        });
        this.gAY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.gXE != null) {
                    FrsGameStrategyItemListView.this.gXE.i(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.gAY);
        this.jAl = new c(this.mPageContext, this.gAY);
        this.jAl.b(this.XE);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.gDk);
        this.gXE = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.gAY.setPullRefresh(this.mPullView);
        if (this.gCf == null) {
            this.gCf = new PbListView(this.mPageContext.getPageActivity());
            this.gCf.createView();
        }
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<n> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.jzz && i2 == this.jAm)) {
            hideLoadingView();
            this.gAY.completePullRefresh();
            if (y.isEmpty(list) && y.isEmpty(this.mData)) {
                IQ(getContext().getString(R.string.no_data_text));
                bSE();
                this.mHasMore = false;
                return;
            }
            if (!y.isEmpty(list)) {
                this.mData = list;
            }
            this.jAl.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                Xa();
            } else {
                Xb();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void m(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.jzz && i2 == this.jAm)) {
            this.mHasMore = false;
            hideLoadingView();
            if (y.isEmpty(this.mData)) {
                IQ(str);
                bSE();
                return;
            }
            this.mPageContext.showToast(str);
            Xb();
        }
    }

    private void Xa() {
        this.mHasMore = true;
        this.gAY.setNextPage(this.gCf);
        this.gCf.startLoadData();
    }

    private void Xb() {
        this.mHasMore = false;
        this.gAY.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bSE() {
        this.mHasMore = false;
        this.gAY.setNextPage(null);
    }

    private void IQ(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.BI(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.gLk == null) {
            this.gLk = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.gLk.onChangeSkinType();
        }
        this.gLk.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.jzI != null) {
            this.jzI.cr(this.jzz, this.jAm);
        }
    }

    public void pullToRefresh() {
        this.gAY.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.gAY, R.color.CAM_X0204);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.jzI = aVar;
    }

    public void cx(int i, int i2) {
        this.jzz = i;
        this.jAm = i2;
        bSE();
        this.mData = new LinkedList();
        this.jAl.setData(this.mData);
        this.jzI.ct(i, i2);
    }

    public void cIj() {
        if (y.isEmpty(this.mData) && (this.jzz != 0 || this.jAm != 0)) {
            showLoadingView();
            this.jzI.cr(this.jzz, this.jAm);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.jzz;
    }

    public int getLabelId() {
        return this.jAm;
    }

    public void onDestory() {
    }
}
