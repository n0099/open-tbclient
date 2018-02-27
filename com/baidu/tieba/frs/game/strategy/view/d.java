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
    private com.baidu.tbadk.j.f bXa;
    private int bZI;
    private PbListView caY;
    private j.b chn;
    private com.baidu.tieba.frs.gametab.b cjU;
    private c dOE;
    private int dOF;
    private com.baidu.tieba.frs.game.strategy.tab.b dOb;
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
                bd WD;
                com.baidu.tieba.frs.game.strategy.tab.f no;
                if (iVar != null && (iVar instanceof com.baidu.tieba.frs.game.strategy.data.b) && (WD = ((com.baidu.tieba.frs.game.strategy.data.b) iVar).WD()) != null) {
                    if (d.this.dOb != null && (no = d.this.dOb.no(d.this.bZI)) != null && (no.extra instanceof LabelDataList)) {
                        String labelName = ((LabelDataList) no.extra).getLabelName(d.this.dOF);
                        if (labelName == null) {
                            labelName = "";
                        }
                        TiebaStatic.log(new ak("c12388").ab(ImageViewerConfig.FORUM_ID, d.this.dOb.getForumId()).ab("tid", WD.getId()).ab("obj_id", no.tabName).ab("obj_locate", labelName));
                    }
                    if (WD.zY() == null || WD.zY().getGroup_id() == 0 || ay.ba(d.this.mPageContext.getPageActivity())) {
                        if (WD.zR() != 1 || ay.ba(d.this.mPageContext.getPageActivity())) {
                            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.sW(WD.getId())) {
                                readThreadHistory.sV(WD.getId());
                                d.this.dOE.notifyDataSetChanged();
                            }
                            boolean z = false;
                            final String zv = WD.zv();
                            if (zv != null && !zv.equals("")) {
                                z = true;
                                new Thread(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.d.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        x xVar = new x(zv);
                                        xVar.Cy().Dv().mIsNeedAddCommenParam = false;
                                        xVar.Cy().Dv().mIsUseCurrentBDUSS = false;
                                        xVar.Cb();
                                    }
                                }).start();
                            }
                            String tid = WD.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (WD.zi() == 2 && !tid.startsWith("pb:")) {
                                aw.Dt().c(d.this.mPageContext, new String[]{tid, "", null});
                            } else if (WD.getThreadType() == 33 || (WD instanceof as)) {
                                if (WD.getThreadType() == 33) {
                                }
                                d.this.mPageContext.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(d.this.mPageContext.getPageActivity(), WD.getTid()).cR("from_frs").eC(18003).xD()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    WD.setId(tid.substring(3));
                                }
                                PbActivityConfig createFromThreadCfg = new PbActivityConfig(d.this.mPageContext.getPageActivity()).createFromThreadCfg(WD, null, "frs_page", 18003, true, false, z);
                                createFromThreadCfg.setForumId(String.valueOf(WD.getFid()));
                                createFromThreadCfg.setStartFrom(3);
                                d.this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                            }
                        }
                    }
                }
            }
        };
        this.chn = new j.b() { // from class: com.baidu.tieba.frs.game.strategy.view.d.2
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
                if (d.this.mHasMore && d.this.dOb != null) {
                    d.this.dOb.by(d.this.bZI, d.this.dOF);
                }
            }
        });
        this.mListView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.game.strategy.view.d.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (d.this.cjU != null) {
                    d.this.cjU.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        addView(this.mListView);
        this.dOE = new c(this.mPageContext, this.mListView);
        this.dOE.b(this.mAdapterItemClickListener);
        this.mPullView = new k(this.mPageContext);
        this.mPullView.setTag(this.mPageId);
        this.mPullView.a(this.chn);
        this.cjU = new com.baidu.tieba.frs.gametab.b(this.mPageContext.getPageActivity(), this.mPageId, true);
        this.mListView.setPullRefresh(this.mPullView);
        if (this.caY == null) {
            this.caY = new PbListView(this.mPageContext.getPageActivity());
            this.caY.st();
        }
        this.caY.gw(d.C0141d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.c
    public void a(int i, int i2, List<i> list, List<com.baidu.tieba.frs.game.strategy.tab.f> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.bZI && i2 == this.dOF)) {
            VU();
            this.mListView.completePullRefresh();
            if (v.E(list) && v.E(this.mData)) {
                lS(getContext().getString(d.j.no_data_text));
                XP();
                this.mHasMore = false;
                return;
            }
            if (!v.E(list)) {
                this.mData = list;
            }
            this.dOE.setData(this.mData);
            this.mHasMore = z;
            if (z) {
                XN();
            } else {
                XO();
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.tab.c
    public void e(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.bZI && i2 == this.dOF)) {
            this.mHasMore = false;
            VU();
            if (v.E(this.mData)) {
                lS(str);
                XP();
                return;
            }
            this.mPageContext.showToast(str);
            XO();
        }
    }

    private void XN() {
        this.mHasMore = true;
        this.mListView.setNextPage(this.caY);
        this.caY.Ef();
    }

    private void XO() {
        this.mHasMore = false;
        this.mListView.setNextPage(this.caY);
        this.caY.Eg();
        this.caY.setText(this.mPageContext.getResources().getString(d.j.list_no_more));
    }

    private void XP() {
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

    private void VT() {
        if (this.bXa == null) {
            this.bXa = new com.baidu.tbadk.j.f(getContext(), getContext().getResources().getDimensionPixelSize(d.e.ds120));
            this.bXa.onChangeSkinType();
        }
        this.bXa.j(this, false);
    }

    private void VU() {
        if (this.bXa != null) {
            this.bXa.bk(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        hideNoDataView();
        if (this.dOb != null) {
            this.dOb.bx(this.bZI, this.dOF);
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
        this.dOb = bVar;
    }

    public void bE(int i, int i2) {
        this.bZI = i;
        this.dOF = i2;
        XP();
        this.mData = new LinkedList();
        this.dOE.setData(this.mData);
        this.dOb.bz(i, i2);
    }

    public void axZ() {
        if (v.E(this.mData) && (this.bZI != 0 || this.dOF != 0)) {
            VT();
            this.dOb.bx(this.bZI, this.dOF);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getTabId() {
        return this.bZI;
    }

    public int getLabelId() {
        return this.dOF;
    }

    public void onDestory() {
    }
}
