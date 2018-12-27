package com.baidu.tieba.frs.commontab;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class b {
    private PbListView bOB;
    private BdTypeRecyclerView bRn;
    private BdSwipeRefreshLayout bRo;
    private m dMW;
    private a dRF;
    private d dRG;
    private FrsCommonTabFragment dRq;
    private boolean hasMore;
    private k mPullView;
    private BdListView.e bVw = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.bRn != null) {
                b.this.bRn.stopScroll();
            }
            if (b.this.bOB != null && b.this.dRq != null) {
                if (j.kV()) {
                    b.this.bRn.setNextPage(b.this.bOB);
                    b.this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.bOB.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.bOB.showLoading();
                        b.this.dRq.aDX();
                        return;
                    }
                    b.this.bOB.setText(b.this.dRq.getResources().getString(e.j.list_has_no_more));
                    b.this.bOB.Fd();
                    return;
                }
                b.this.bRn.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener dRH = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean dRJ;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.dMW != null) {
                    b.this.dMW.b(b.this.bRn.getFirstVisiblePosition(), b.this.bRn.getLastVisiblePosition(), this.dRJ, true);
                }
                v.aqs().fv(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.dRJ = false;
            } else {
                this.dRJ = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view) {
        if (frsCommonTabFragment != null && view != null) {
            this.dRq = frsCommonTabFragment;
            this.bRn = (BdTypeRecyclerView) view.findViewById(e.g.frs_common_tab_recycler_view);
            this.bRn.setLayoutManager(new LinearLayoutManager(this.dRq.getContext()));
            this.bRn.setFadingEdgeLength(0);
            this.bRn.setOverScrollMode(2);
            this.bRn.setOnSrollToBottomListener(this.bVw);
            this.bRn.addOnScrollListener(this.dRH);
            this.mPullView = new k(this.dRq.getPageContext());
            this.mPullView.a(this.dRq);
            this.bRn.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.dMW != null) {
                        b.this.dMW.bm(view2);
                    }
                    if (view2 != null) {
                        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(e.g.abstract_voice);
                        if (playVoiceBnt != null) {
                            playVoiceBnt.reset();
                        }
                        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(e.g.abstract_img_layout);
                        if (frsCommonImageLayout != null) {
                            frsCommonImageLayout.reset();
                        }
                        if (view2 instanceof UserPhotoLayout) {
                            ((UserPhotoLayout) view2).reset();
                        }
                    }
                }
            });
            this.bOB = new PbListView(this.dRq.getPageContext().getPageActivity());
            this.bOB.oD();
            this.bOB.ex(e.d.cp_bg_line_e);
            this.bOB.setHeight(l.h(this.dRq.getActivity(), e.C0210e.tbds182));
            this.bOB.EZ();
            this.bOB.setTextSize(e.C0210e.tbfontsize33);
            this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bOB.ew(e.d.cp_cont_e);
            if (this.bRo == null) {
                this.bRo = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_common_tab_pull_refresh_layout);
                this.bRo.setProgressView(this.mPullView);
                al.j(this.bRo, e.d.cp_bg_line_e);
            }
            this.dRF = new a(this.dRq, this.bRn);
            di(false);
            if (this.dMW == null) {
                this.dMW = new m(this.dRq.getPageContext(), this.bRn);
            }
            this.dMW.setUniqueId(this.dRq.getUniqueId());
        }
    }

    public void di(boolean z) {
        if (this.bRo != null) {
            this.bRo.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dRF != null) {
            this.dRF.notifyDataSetChanged();
        }
        if (this.bOB != null) {
            this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bOB.ey(i);
        }
        al.j(this.bRo, e.d.cp_bg_line_e);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (com.baidu.tbadk.core.util.v.I(dVar.threadList)) {
                com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(mVar);
                dVar.hasMore = false;
            }
            this.dRG = dVar;
            this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.bRn.setNextPage(this.bOB);
            if (this.hasMore) {
                this.bOB.Ff();
            } else {
                this.bOB.setText(this.dRq.getResources().getString(e.j.list_has_no_more));
                this.bOB.Fd();
            }
            this.dRF.setData(dVar.threadList);
            this.dRF.notifyDataSetChanged();
            if (this.dMW != null) {
                this.dMW.b(this.bRn.getFirstVisiblePosition(), this.bRn.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.bRn != null) {
            this.bRn.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.dMW != null) {
            this.dMW.destroy();
        }
        if (this.dRF != null) {
            this.dRF.onDestory();
        }
    }

    public void resume() {
        if (this.dMW != null) {
            this.dMW.aZR();
        }
    }

    public void pause() {
        if (this.dMW != null) {
            this.dMW.aZQ();
        }
    }

    public void hb(boolean z) {
        if (this.bRo != null) {
            this.bRo.setVisibility(z ? 0 : 8);
        }
    }

    public void oo(String str) {
        bb bbVar;
        if (!StringUtils.isNull(str) && this.dRG != null && !com.baidu.tbadk.core.util.v.I(this.dRG.threadList)) {
            Iterator<h> it = this.dRG.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bbVar = null;
                    break;
                }
                h next = it.next();
                if (next != null && (next instanceof bb) && TextUtils.equals(str, ((bb) next).getId())) {
                    bbVar = (bb) next;
                    break;
                }
            }
            if (bbVar != null) {
                this.dRG.threadList.remove(bbVar);
                if (com.baidu.tbadk.core.util.v.I(this.dRG.threadList)) {
                    this.dRG.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.dRF.notifyDataSetChanged();
            }
        }
    }
}
