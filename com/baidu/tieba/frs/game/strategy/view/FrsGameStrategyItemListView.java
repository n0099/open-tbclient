package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.b {
    private com.baidu.tieba.frs.gametab.b dCr;
    private com.baidu.tbadk.m.g djG;
    private int dmx;
    private PbListView dnG;
    private h.c dnS;
    private c fFX;
    private int fFY;
    private com.baidu.tieba.frs.game.strategy.tab.a fFu;
    private s mAdapterItemClickListener;
    private List<m> mData;
    private boolean mHasMore;
    private BdTypeListView mListView;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private i mPullView;

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.mAdapterItemClickListener = new s() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bg acx;
                com.baidu.tieba.frs.game.strategy.tab.e sb;
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (acx = ((com.baidu.tieba.frs.game.strategy.data.b) mVar).acx()) != null) {
                    if (FrsGameStrategyItemListView.this.fFu != null && (sb = FrsGameStrategyItemListView.this.fFu.sb(FrsGameStrategyItemListView.this.dmx)) != null && (sb.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) sb.extra).getLabelName(FrsGameStrategyItemListView.this.fFY);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new an("c12388").bT("fid", FrsGameStrategyItemListView.this.fFu.getForumId()).bT("tid", acx.getId()).bT(VideoPlayActivityConfig.OBJ_ID, sb.tabName).bT("obj_locate", labelName));
                    }
                    if (acx.afp() == null || acx.afp().getGroup_id() == 0 || bd.cF(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                        if (acx.afh() != 1 || bd.cF(FrsGameStrategyItemListView.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.EX(acx.getId())) {
                                readThreadHistory.EW(acx.getId());
                                FrsGameStrategyItemListView.this.fFX.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String aeE = acx.aeE();
                            if (aeE != null && !aeE.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(aeE);
                                        xVar.aiE().ajE().mIsNeedAddCommenParam = false;
                                        xVar.aiE().ajE().mIsUseCurrentBDUSS = false;
                                        xVar.aih();
                                    }
                                }).start();
                            }
                            String tid = acx.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (acx.aes() == 2 && !tid.startsWith("pb:")) {
                                bb.ajC().c(FrsGameStrategyItemListView.this.mPageContext, new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                acx.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.mPageContext.getPageActivity()).createFromThreadCfg(acx, null, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(acx.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            FrsGameStrategyItemListView.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        };
        this.dnS = new h.c() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                FrsGameStrategyItemListView.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameStrategyItemListView.this.mHasMore && FrsGameStrategyItemListView.this.fFu != null) {
                    FrsGameStrategyItemListView.this.fFu.bw(FrsGameStrategyItemListView.this.dmx, FrsGameStrategyItemListView.this.fFY);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGameStrategyItemListView.this.dCr != null) {
                    FrsGameStrategyItemListView.this.dCr.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.fFX = new c(this.mPageContext, this.mListView);
        this.fFX.a(this.mAdapterItemClickListener);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.setListPullRefreshListener(this.dnS);
        this.dCr = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.dnG == null) {
            this.dnG = new PbListView(this.mPageContext.getPageActivity());
            this.dnG.nZ();
        }
        this.dnG.iU(R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.dmx && i2 == this.fFY)) {
            hideLoadingView();
            this.mListView.completePullRefresh();
            if (v.aa(list) && v.aa(this.mData)) {
                vp(getContext().getString(R.string.no_data_text));
                aKk();
                this.mHasMore = false;
                return;
            }
            if (!v.aa(list)) {
                this.mData = list;
            }
            this.fFX.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                aKi();
            } else {
                aKj();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.b
    public void f(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.dmx && i2 == this.fFY)) {
            this.mHasMore = false;
            hideLoadingView();
            if (v.aa(this.mData)) {
                vp(str);
                aKk();
                return;
            }
            this.mPageContext.showToast(str);
            aKj();
        }
    }

    private void aKi() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.dnG);
        this.dnG.akD();
    }

    private void aKj() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.dnG);
        this.dnG.akE();
        this.dnG.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
    }

    private void aKk() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void vp(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.oP(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView.5
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
        if (this.djG == null) {
            this.djG = new com.baidu.tbadk.m.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.djG.onChangeSkinType();
        }
        this.djG.attachView(this, false);
    }

    private void hideLoadingView() {
        if (this.djG != null) {
            this.djG.dettachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.fFu != null) {
            this.fFu.bv(this.dmx, this.fFY);
        }
    }

    public void pullToRefresh() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        am.l(this.mListView, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.a aVar) {
        this.fFu = aVar;
    }

    public void bB(int i, int i2) {
        this.dmx = i;
        this.fFY = i2;
        aKk();
        this.mData = new LinkedList();
        this.fFX.setData(this.mData);
        this.fFu.bx(i, i2);
    }

    public void bpE() {
        if (v.aa(this.mData) && (this.dmx != 0 || this.fFY != 0)) {
            showLoadingView();
            this.fFu.bv(this.dmx, this.fFY);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.dmx;
    }

    public int getLabelId() {
        return this.fFY;
    }

    public void onDestory() {
    }
}
