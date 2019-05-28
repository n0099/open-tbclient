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
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b {
    private BdTypeRecyclerView NZ;
    private PbListView dlY;
    private BdSwipeRefreshLayout dni;
    private BdListView.e dvS = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.NZ != null) {
                b.this.NZ.stopScroll();
            }
            if (b.this.dlY != null && b.this.fvZ != null) {
                if (j.jS()) {
                    b.this.NZ.setNextPage(b.this.dlY);
                    b.this.dlY.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.dlY.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.dlY.showLoading();
                        b.this.fvZ.aWs();
                        return;
                    }
                    b.this.dlY.setText(b.this.fvZ.getResources().getString(R.string.list_has_no_more));
                    b.this.dlY.ajz();
                    return;
                }
                b.this.NZ.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener eqr = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean fwu;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.frm != null) {
                    b.this.frm.c(b.this.NZ.getFirstVisiblePosition(), b.this.NZ.getLastVisiblePosition(), this.fwu, true);
                }
                t.aXP().iv(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fwu = false;
            } else {
                this.fwu = true;
            }
        }
    };
    private m frm;
    private FrsCommonTabFragment fvZ;
    private a fwr;
    private d fws;
    private boolean hasMore;
    private i mPullView;

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.fvZ = frsCommonTabFragment;
            this.NZ = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.NZ.setLayoutManager(new LinearLayoutManager(this.fvZ.getContext()));
            this.NZ.setFadingEdgeLength(0);
            this.NZ.setOverScrollMode(2);
            this.NZ.setOnSrollToBottomListener(this.dvS);
            this.NZ.addOnScrollListener(this.eqr);
            this.mPullView = new i(this.fvZ.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fvZ);
            this.NZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.frm != null) {
                        b.this.frm.cj(view2);
                    }
                    if (view2 != null) {
                        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                        if (playVoiceBnt != null) {
                            playVoiceBnt.reset();
                        }
                        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                        if (frsCommonImageLayout != null) {
                            frsCommonImageLayout.reset();
                        }
                        if (view2 instanceof UserPhotoLayout) {
                            ((UserPhotoLayout) view2).reset();
                        }
                    }
                }
            });
            this.dlY = new PbListView(this.fvZ.getPageContext().getPageActivity());
            this.dlY.getView();
            this.dlY.iO(R.color.cp_bg_line_e);
            this.dlY.setHeight(l.g(this.fvZ.getActivity(), R.dimen.tbds182));
            this.dlY.ajv();
            this.dlY.setTextSize(R.dimen.tbfontsize33);
            this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
            this.dlY.iN(R.color.cp_cont_e);
            this.dlY.ajC();
            if (this.dni == null) {
                this.dni = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.dni.setProgressView(this.mPullView);
                al.l(this.dni, R.color.cp_bg_line_e);
            }
            this.fwr = new a(this.fvZ, this.NZ, frsViewData);
            fY(false);
            if (this.frm == null) {
                this.frm = new m(this.fvZ.getPageContext(), this.NZ);
            }
            this.frm.setUniqueId(this.fvZ.getUniqueId());
        }
    }

    public void fY(boolean z) {
        if (this.dni != null) {
            this.dni.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.fwr != null) {
            this.fwr.notifyDataSetChanged();
        }
        if (this.dlY != null) {
            this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
            this.dlY.iP(i);
        }
        al.l(this.dni, R.color.cp_bg_line_e);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (v.aa(dVar.threadList)) {
                com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(mVar);
                dVar.hasMore = false;
            }
            this.fws = dVar;
            this.dlY.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.NZ.setNextPage(this.dlY);
            if (this.hasMore) {
                this.dlY.ajB();
            } else {
                this.dlY.setText(this.fvZ.getResources().getString(R.string.list_has_no_more));
                this.dlY.ajz();
            }
            this.fwr.setData(dVar.threadList);
            this.fwr.notifyDataSetChanged();
            if (this.frm != null) {
                this.frm.c(this.NZ.getFirstVisiblePosition(), this.NZ.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.NZ != null) {
            this.NZ.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.frm != null) {
            this.frm.destroy();
        }
        if (this.fwr != null) {
            this.fwr.onDestory();
        }
    }

    public void resume() {
        if (this.frm != null) {
            this.frm.bIF();
        }
    }

    public void pause() {
        if (this.frm != null) {
            this.frm.bIE();
        }
    }

    public void km(boolean z) {
        if (this.dni != null) {
            this.dni.setVisibility(z ? 0 : 8);
        }
    }

    public void wA(String str) {
        bg bgVar;
        if (!StringUtils.isNull(str) && this.fws != null && !v.aa(this.fws.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fws.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bgVar = null;
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && (next instanceof bg) && TextUtils.equals(str, ((bg) next).getId())) {
                    bgVar = (bg) next;
                    break;
                }
            }
            if (bgVar != null) {
                this.fws.threadList.remove(bgVar);
                if (v.aa(this.fws.threadList)) {
                    this.fws.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.fwr.setData(this.fws.threadList);
                this.fwr.notifyDataSetChanged();
            }
        }
    }

    public void bjy() {
        this.NZ.scrollToPosition(0);
    }

    public void refreshView() {
        this.fwr.notifyDataSetChanged();
    }

    public void aIG() {
        this.mPullView.ao(false);
    }

    public void kl(boolean z) {
        if (this.fwr != null) {
            this.fwr.kl(z);
        }
    }

    public BdTypeRecyclerView bmA() {
        return this.NZ;
    }

    public m bkH() {
        return this.frm;
    }
}
