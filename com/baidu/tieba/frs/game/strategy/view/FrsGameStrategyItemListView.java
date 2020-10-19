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
    private ab Vt;
    private BdTypeListView fSo;
    private PbListView fTv;
    private f.c fUA;
    private com.baidu.tbadk.k.g gcx;
    private com.baidu.tieba.frs.gametab.b gns;
    private com.baidu.tieba.frs.game.strategy.tab.a iDG;
    private int iDx;
    private c iEj;
    private int iEk;
    private List<q> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Vt = new ab() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bw bfG;
                com.baidu.tieba.frs.game.strategy.tab.e yW;
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (bfG = ((com.baidu.tieba.frs.game.strategy.data.b) qVar).bfG()) != null) {
                    if (FrsGameStrategyItemListView.this.iDG != null && (yW = FrsGameStrategyItemListView.this.iDG.yW(FrsGameStrategyItemListView.this.iDx)) != null && (yW.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) yW.extra).getLabelName(FrsGameStrategyItemListView.this.iEk);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new aq("c12388").dK("fid", FrsGameStrategyItemListView.this.iDG.getForumId()).dK("tid", bfG.getId()).dK("obj_id", yW.tabName).dK("obj_locate", labelName));
                    }
                    if (bfG.bjh() == null || bfG.bjh().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (bfG.biU() != 1 || bg.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Sl(bfG.getId())) {
                                readThreadHistory.Sk(bfG.getId());
                                FrsGameStrategyItemListView.this.iEj.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String bin = bfG.bin();
                            if (bin != null && !bin.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        aa aaVar = new aa(bin);
                                        aaVar.bmu().bna().mIsNeedAddCommenParam = false;
                                        aaVar.bmu().bna().mIsUseCurrentBDUSS = false;
                                        aaVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = bfG.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bfG.bic() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                be.bmY().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bfG.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(bfG, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bfG.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.fUA = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.fSo = new BdTypeListView(getContext());
        this.fSo.setDivider(new ColorDrawable(ap.getColor(R.color.cp_bg_line_c)));
        this.fSo.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.fSo.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.fSo.setFadingEdgeLength(0);
        this.fSo.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.fSo.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.iDG != null) {
                    FrsGameStrategyItemListView.this.iDG.co(FrsGameStrategyItemListView.this.iDx, FrsGameStrategyItemListView.this.iEk);
                }
            }
        });
        this.fSo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.gns != null) {
                    FrsGameStrategyItemListView.this.gns.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.fSo);
        this.iEj = new c(this.mPageContext, this.fSo);
        this.iEj.b(this.Vt);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.fUA);
        this.gns = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.fSo.setPullRefresh(this.mPullView);
        if (this.fTv == null) {
            this.fTv = new PbListView(this.mPageContext.getPageActivity());
            this.fTv.createView();
        }
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.iDx && i2 == this.iEk)) {
            hideLoadingView();
            this.fSo.completePullRefresh();
            if (y.isEmpty(list) && y.isEmpty(this.mData)) {
                Id(getContext().getString(R.string.no_data_text));
                bKU();
                this.mHasMore = false;
                return;
            }
            if (!y.isEmpty(list)) {
                this.mData = list;
            }
            this.iEj.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                SI();
            } else {
                SJ();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void l(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.iDx && i2 == this.iEk)) {
            this.mHasMore = false;
            hideLoadingView();
            if (y.isEmpty(this.mData)) {
                Id(str);
                bKU();
                return;
            }
            this.mPageContext.showToast(str);
            SJ();
        }
    }

    private void SI() {
        this.mHasMore = true;
        this.fSo.setNextPage(this.fTv);
        this.fTv.startLoadData();
    }

    private void SJ() {
        this.mHasMore = false;
        this.fSo.setNextPage(this.fTv);
        this.fTv.endLoadData();
        this.fTv.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void bKU() {
        this.mHasMore = false;
        this.fSo.setNextPage(null);
    }

    private void Id(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.BK(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.gcx == null) {
            this.gcx = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.gcx.onChangeSkinType();
        }
        this.gcx.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.iDG != null) {
            this.iDG.cn(this.iDx, this.iEk);
        }
    }

    public void pullToRefresh() {
        this.fSo.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.fSo, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.iDG = aVar;
    }

    public void ct(int i, int i2) {
        this.iDx = i;
        this.iEk = i2;
        bKU();
        this.mData = new LinkedList();
        this.iEj.setData(this.mData);
        this.iDG.cp(i, i2);
    }

    public void cxc() {
        if (y.isEmpty(this.mData) && (this.iDx != 0 || this.iEk != 0)) {
            showLoadingView();
            this.iDG.cn(this.iDx, this.iEk);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.iDx;
    }

    public int getLabelId() {
        return this.iEk;
    }

    public void onDestory() {
    }
}
