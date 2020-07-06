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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private z Ul;
    private com.baidu.tieba.frs.gametab.b fGq;
    private BdTypeListView fml;
    private PbListView fnt;
    private f.c fov;
    private com.baidu.tbadk.k.g fwo;
    private int hNn;
    private com.baidu.tieba.frs.game.strategy.tab.a hNw;
    private c hOa;
    private int hOb;
    private List<q> mData;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private com.baidu.tbadk.core.view.g mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.Ul = new z() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bu aPS;
                com.baidu.tieba.frs.game.strategy.tab.e vg;
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (aPS = ((com.baidu.tieba.frs.game.strategy.data.b) qVar).aPS()) != null) {
                    if (FrsGameStrategyItemListView.this.hNw != null && (vg = FrsGameStrategyItemListView.this.hNw.vg(FrsGameStrategyItemListView.this.hNn)) != null && (vg.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) vg.extra).getLabelName(FrsGameStrategyItemListView.this.hOb);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new ao("c12388").dk("fid", FrsGameStrategyItemListView.this.hNw.getForumId()).dk("tid", aPS.getId()).dk("obj_id", vg.tabName).dk("obj_locate", labelName));
                    }
                    if (aPS.aTp() == null || aPS.aTp().getGroup_id() == 0 || be.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (aPS.aTc() != 1 || be.checkUpIsLogin(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.Nr(aPS.getId())) {
                                readThreadHistory.Nq(aPS.getId());
                                FrsGameStrategyItemListView.this.hOa.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aSv = aPS.aSv();
                            if (aSv != null && !aSv.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        y yVar = new y(aSv);
                                        yVar.aWu().aWV().mIsNeedAddCommenParam = false;
                                        yVar.aWu().aWV().mIsUseCurrentBDUSS = false;
                                        yVar.getNetData();
                                    }
                                }).start();
                            }
                            String tid = aPS.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (aPS.aSk() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                bc.aWU().b(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                aPS.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(aPS, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(aPS.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.fov = new f.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
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
        this.fml = new BdTypeListView(getContext());
        this.fml.setDivider(new ColorDrawable(an.getColor(R.color.cp_bg_line_c)));
        this.fml.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.fml.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.fml.setFadingEdgeLength(0);
        this.fml.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.fml.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.hNw != null) {
                    FrsGameStrategyItemListView.this.hNw.ca(FrsGameStrategyItemListView.this.hNn, FrsGameStrategyItemListView.this.hOb);
                }
            }
        });
        this.fml.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.fGq != null) {
                    FrsGameStrategyItemListView.this.fGq.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.fml);
        this.hOa = new c(this.mPageContext, this.fml);
        this.hOa.b(this.Ul);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.fov);
        this.fGq = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.fml.setPullRefresh(this.mPullView);
        if (this.fnt == null) {
            this.fnt = new PbListView(this.mPageContext.getPageActivity());
            this.fnt.createView();
        }
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.hNn && i2 == this.hOb)) {
            hideLoadingView();
            this.fml.completePullRefresh();
            if (w.isEmpty(list) && w.isEmpty(this.mData)) {
                DI(getContext().getString(R.string.no_data_text));
                buL();
                this.mHasMore = false;
                return;
            }
            if (!w.isEmpty(list)) {
                this.mData = list;
            }
            this.hOa.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                buJ();
            } else {
                buK();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void j(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.hNn && i2 == this.hOb)) {
            this.mHasMore = false;
            hideLoadingView();
            if (w.isEmpty(this.mData)) {
                DI(str);
                buL();
                return;
            }
            this.mPageContext.showToast(str);
            buK();
        }
    }

    private void buJ() {
        this.mHasMore = true;
        this.fml.setNextPage(this.fnt);
        this.fnt.startLoadData();
    }

    private void buK() {
        this.mHasMore = false;
        this.fml.setNextPage(this.fnt);
        this.fnt.endLoadData();
        this.fnt.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void buL() {
        this.mHasMore = false;
        this.fml.setNextPage(null);
    }

    private void DI(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.xi(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.fwo == null) {
            this.fwo = new com.baidu.tbadk.k.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.fwo.onChangeSkinType();
        }
        this.fwo.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.hNw != null) {
            this.hNw.bZ(this.hNn, this.hOb);
        }
    }

    public void pullToRefresh() {
        this.fml.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.fml, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.hNw = aVar;
    }

    public void cf(int i, int i2) {
        this.hNn = i;
        this.hOb = i2;
        buL();
        this.mData = new LinkedList();
        this.hOa.setData(this.mData);
        this.hNw.cb(i, i2);
    }

    public void cco() {
        if (w.isEmpty(this.mData) && (this.hNn != 0 || this.hOb != 0)) {
            showLoadingView();
            this.hNw.bZ(this.hNn, this.hOb);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.hNn;
    }

    public int getLabelId() {
        return this.hOb;
    }

    public void onDestory() {
    }
}
