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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
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
    private z Uf;
    private com.baidu.tbadk.k.g fBv;
    private com.baidu.tieba.frs.gametab.b fLL;
    private BdTypeListView frv;
    private PbListView fsC;
    private f.c ftG;
    private c hTZ;
    private int hTm;
    private com.baidu.tieba.frs.game.strategy.tab.a hTv;
    private int hUa;
    private List<q> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Uf = new z() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bv aTN;
                com.baidu.tieba.frs.game.strategy.tab.e vy;
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (aTN = ((com.baidu.tieba.frs.game.strategy.data.b) qVar).aTN()) != null) {
                    if (FrsGameStrategyItemListView.this.hTv != null && (vy = FrsGameStrategyItemListView.this.hTv.vy(FrsGameStrategyItemListView.this.hTm)) != null && (vy.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) vy.extra).getLabelName(FrsGameStrategyItemListView.this.hUa);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new ap("c12388").dn("fid", FrsGameStrategyItemListView.this.hTv.getForumId()).dn("tid", aTN.getId()).dn("obj_id", vy.tabName).dn("obj_locate", labelName));
                    }
                    if (aTN.aXl() == null || aTN.aXl().getGroup_id() == 0 || bf.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (aTN.aWY() != 1 || bf.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.NZ(aTN.getId())) {
                                readThreadHistory.NY(aTN.getId());
                                FrsGameStrategyItemListView.this.hTZ.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aWr = aTN.aWr();
                            if (aWr != null && !aWr.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(aWr);
                                        zVar.bav().baW().mIsNeedAddCommenParam = false;
                                        zVar.bav().baW().mIsUseCurrentBDUSS = false;
                                        zVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = aTN.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (aTN.aWg() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bd.baV().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                aTN.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(aTN, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(aTN.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.ftG = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) i.G(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.frv = new BdTypeListView(getContext());
        this.frv.setDivider(new ColorDrawable(ao.getColor(R.color.cp_bg_line_c)));
        this.frv.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.frv.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.frv.setFadingEdgeLength(0);
        this.frv.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.frv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.hTv != null) {
                    FrsGameStrategyItemListView.this.hTv.cd(FrsGameStrategyItemListView.this.hTm, FrsGameStrategyItemListView.this.hUa);
                }
            }
        });
        this.frv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.fLL != null) {
                    FrsGameStrategyItemListView.this.fLL.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.frv);
        this.hTZ = new c(this.mPageContext, this.frv);
        this.hTZ.b(this.Uf);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.ftG);
        this.fLL = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.frv.setPullRefresh(this.mPullView);
        if (this.fsC == null) {
            this.fsC = new PbListView(this.mPageContext.getPageActivity());
            this.fsC.createView();
        }
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.hTm && i2 == this.hUa)) {
            hideLoadingView();
            this.frv.completePullRefresh();
            if (x.isEmpty(list) && x.isEmpty(this.mData)) {
                Et(getContext().getString(R.string.no_data_text));
                bxU();
                this.mHasMore = false;
                return;
            }
            if (!x.isEmpty(list)) {
                this.mData = list;
            }
            this.hTZ.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                bxS();
            } else {
                bxT();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void k(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.hTm && i2 == this.hUa)) {
            this.mHasMore = false;
            hideLoadingView();
            if (x.isEmpty(this.mData)) {
                Et(str);
                bxU();
                return;
            }
            this.mPageContext.showToast(str);
            bxT();
        }
    }

    private void bxS() {
        this.mHasMore = true;
        this.frv.setNextPage(this.fsC);
        this.fsC.startLoadData();
    }

    private void bxT() {
        this.mHasMore = false;
        this.frv.setNextPage(this.fsC);
        this.fsC.endLoadData();
        this.fsC.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bxU() {
        this.mHasMore = false;
        this.frv.setNextPage(null);
    }

    private void Et(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.yn(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.fBv == null) {
            this.fBv = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.fBv.onChangeSkinType();
        }
        this.fBv.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.hTv != null) {
            this.hTv.cc(this.hTm, this.hUa);
        }
    }

    public void pullToRefresh() {
        this.frv.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.frv, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.hTv = aVar;
    }

    public void ci(int i, int i2) {
        this.hTm = i;
        this.hUa = i2;
        bxU();
        this.mData = new LinkedList();
        this.hTZ.setData(this.mData);
        this.hTv.ce(i, i2);
    }

    public void cfM() {
        if (x.isEmpty(this.mData) && (this.hTm != 0 || this.hUa != 0)) {
            showLoadingView();
            this.hTv.cc(this.hTm, this.hUa);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.hTm;
    }

    public int getLabelId() {
        return this.hUa;
    }

    public void onDestory() {
    }
}
