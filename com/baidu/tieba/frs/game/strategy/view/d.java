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
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends FrameLayout implements com.baidu.tieba.frs.game.strategy.tab.c {
    private com.baidu.tbadk.j.f bXd;
    private int bZL;
    private PbListView cbb;
    private j.b chq;
    private com.baidu.tieba.frs.gametab.b cjX;
    private c dOJ;
    private int dOK;
    private com.baidu.tieba.frs.game.strategy.tab.b dOg;
    private o mAdapterItemClickListener;
    private List<i> mData;
    private boolean mHasMore;
    private BdTypeListView mListView;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private k mPullView;

    public d(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.mAdapterItemClickListener = new o() { // from class: com.baidu.tieba.frs.game.strategy.view.d.1
            @Override // com.baidu.adp.widget.ListView.o
            public void a(View view, i iVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                bd WE;
                com.baidu.tieba.frs.game.strategy.tab.f no;
                if (iVar != null && (iVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (WE = ((com.baidu.tieba.frs.game.strategy.data.b) iVar).WE()) != null) {
                    if (d.this.dOg != null && (no = d.this.dOg.no(d.this.bZL)) != null && (no.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) no.extra).getLabelName(d.this.dOK);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new ak("c12388").ab(ImageViewerConfig.FORUM_ID, d.this.dOg.getForumId()).ab("tid", WE.getId()).ab("obj_id", no.tabName).ab("obj_locate", labelName));
                    }
                    if (WE.zY() == null || WE.zY().getGroup_id() == 0 || ay.ba(d.this.mPageContext.getPageActivity())) {
                        if (WE.zR() != 1 || ay.ba(d.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.sW(WE.getId())) {
                                readThreadHistory.sV(WE.getId());
                                d.this.dOJ.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String zv = WE.zv();
                            if (zv != null && !zv.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.d.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(zv);
                                        xVar.Cz().Dw().mIsNeedAddCommenParam = false;
                                        xVar.Cz().Dw().mIsUseCurrentBDUSS = false;
                                        xVar.Cc();
                                    }
                                }).start();
                            }
                            String tid = WE.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (WE.zi() == 2 && !tid.startsWith("pb:")) {
                                aw.Du().c(d.this.mPageContext, new String[]{tid, "", null});
                            } else if (WE.getThreadType() == 33 || (WE instanceof as)) {
                                if (WE.getThreadType() == 33) {
                                }
                                d.this.mPageContext.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(d.this.mPageContext.getPageActivity(), WE.getTid()).cR("from_frs").eC(18003).xD()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    WE.setId(tid.substring(3));
                                }
                                PbActivityConfig createFromThreadCfg = new PbActivityConfig(d.this.mPageContext.getPageActivity()).createFromThreadCfg(WE, null, "frs_page", 18003, true, false, z);
                                createFromThreadCfg.setForumId(String.valueOf(WE.getFid()));
                                createFromThreadCfg.setStartFrom(3);
                                d.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                            }
                        }
                    }
                }
            }
        };
        this.chq = new j.b() { // from class: com.baidu.tieba.frs.game.strategy.view.d.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                d.this.refresh();
            }
        };
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ak(context);
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        this.mListView = new BdTypeListView(getContext());
        this.mListView.setDivider(new ColorDrawable(aj.getColor(d.C0141d.cp_bg_line_c)));
        this.mListView.setDividerHeight(getContext().getResources().getDimensionPixelSize(d.e.ds1));
        this.mListView.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(getContext().getResources().getDrawable(d.f.list_selector_transparent));
        this.mListView.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.frs.game.strategy.view.d.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (d.this.mHasMore && d.this.dOg != null) {
                    d.this.dOg.by(d.this.bZL, d.this.dOK);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.d.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (d.this.cjX != null) {
                    d.this.cjX.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dOJ = new c(this.mPageContext, this.mListView);
        this.dOJ.b(this.mAdapterItemClickListener);
        this.mPullView = new k(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.chq);
        this.cjX = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.cbb == null) {
            this.cbb = new PbListView(this.mPageContext.getPageActivity());
            this.cbb.st();
        }
        this.cbb.gw(d.C0141d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.c
    public void a(int i, int i2, List<i> list, List<com.baidu.tieba.frs.game.strategy.tab.f> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bZL && i2 == this.dOK)) {
            VV();
            this.mListView.completePullRefresh();
            if (v.E(list) && v.E(this.mData)) {
                lS(getContext().getString(d.j.no_data_text));
                XQ();
                this.mHasMore = false;
                return;
            }
            if (!v.E(list)) {
                this.mData = list;
            }
            this.dOJ.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                XO();
            } else {
                XP();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.c
    public void e(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bZL && i2 == this.dOK)) {
            this.mHasMore = false;
            VV();
            if (v.E(this.mData)) {
                lS(str);
                XQ();
                return;
            }
            this.mPageContext.showToast(str);
            XP();
        }
    }

    private void XO() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.cbb);
        this.cbb.Eg();
    }

    private void XP() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.cbb);
        this.cbb.Eh();
        this.cbb.setText(this.mPageContext.getResources().getString(d.j.list_no_more));
    }

    private void XQ() {
        this.mHasMore = false;
        this.mListView.setNextPage(null);
    }

    private void lS(String str) {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.eT(str), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getString(d.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.view.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.refresh();
                }
            }), getResources().getDimensionPixelSize(d.e.ds20)));
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

    private void VU() {
        if (this.bXd == null) {
            this.bXd = new com.baidu.tbadk.j.f(getContext(), getContext().getResources().getDimensionPixelSize(d.e.ds120));
            this.bXd.onChangeSkinType();
        }
        this.bXd.j(this, false);
    }

    private void VV() {
        if (this.bXd != null) {
            this.bXd.bk(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dOg != null) {
            this.dOg.bx(this.bZL, this.dOK);
        }
    }

    public void sU() {
        this.mListView.startPullRefresh();
    }

    public void onChangeSkinType(int i) {
        aj.t(this.mListView, d.C0141d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void setFrsGameTabDataLoadListener(com.baidu.tieba.frs.game.strategy.tab.b bVar) {
        this.dOg = bVar;
    }

    public void bE(int i, int i2) {
        this.bZL = i;
        this.dOK = i2;
        XQ();
        this.mData = new LinkedList();
        this.dOJ.setData(this.mData);
        this.dOg.bz(i, i2);
    }

    public void ayb() {
        if (v.E(this.mData) && (this.bZL != 0 || this.dOK != 0)) {
            VU();
            this.dOg.bx(this.bZL, this.dOK);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bZL;
    }

    public int getLabelId() {
        return this.dOK;
    }

    public void onDestory() {
    }
}
