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
    private PbListView dlX;
    private BdSwipeRefreshLayout dnh;
    private BdListView.e dvR = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.NZ != null) {
                b.this.NZ.stopScroll();
            }
            if (b.this.dlX != null && b.this.fvY != null) {
                if (j.jS()) {
                    b.this.NZ.setNextPage(b.this.dlX);
                    b.this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.dlX.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.dlX.showLoading();
                        b.this.fvY.aWp();
                        return;
                    }
                    b.this.dlX.setText(b.this.fvY.getResources().getString(R.string.list_has_no_more));
                    b.this.dlX.ajz();
                    return;
                }
                b.this.NZ.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener eqq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean fwt;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.frl != null) {
                    b.this.frl.c(b.this.NZ.getFirstVisiblePosition(), b.this.NZ.getLastVisiblePosition(), this.fwt, true);
                }
                t.aXM().iv(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fwt = false;
            } else {
                this.fwt = true;
            }
        }
    };
    private m frl;
    private FrsCommonTabFragment fvY;
    private a fwq;
    private d fwr;
    private boolean hasMore;
    private i mPullView;

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.fvY = frsCommonTabFragment;
            this.NZ = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.NZ.setLayoutManager(new LinearLayoutManager(this.fvY.getContext()));
            this.NZ.setFadingEdgeLength(0);
            this.NZ.setOverScrollMode(2);
            this.NZ.setOnSrollToBottomListener(this.dvR);
            this.NZ.addOnScrollListener(this.eqq);
            this.mPullView = new i(this.fvY.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fvY);
            this.NZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.frl != null) {
                        b.this.frl.cj(view2);
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
            this.dlX = new PbListView(this.fvY.getPageContext().getPageActivity());
            this.dlX.getView();
            this.dlX.iO(R.color.cp_bg_line_e);
            this.dlX.setHeight(l.g(this.fvY.getActivity(), R.dimen.tbds182));
            this.dlX.ajv();
            this.dlX.setTextSize(R.dimen.tbfontsize33);
            this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
            this.dlX.iN(R.color.cp_cont_e);
            this.dlX.ajC();
            if (this.dnh == null) {
                this.dnh = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.dnh.setProgressView(this.mPullView);
                al.l(this.dnh, R.color.cp_bg_line_e);
            }
            this.fwq = new a(this.fvY, this.NZ, frsViewData);
            fY(false);
            if (this.frl == null) {
                this.frl = new m(this.fvY.getPageContext(), this.NZ);
            }
            this.frl.setUniqueId(this.fvY.getUniqueId());
        }
    }

    public void fY(boolean z) {
        if (this.dnh != null) {
            this.dnh.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.fwq != null) {
            this.fwq.notifyDataSetChanged();
        }
        if (this.dlX != null) {
            this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
            this.dlX.iP(i);
        }
        al.l(this.dnh, R.color.cp_bg_line_e);
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
            this.fwr = dVar;
            this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.NZ.setNextPage(this.dlX);
            if (this.hasMore) {
                this.dlX.ajB();
            } else {
                this.dlX.setText(this.fvY.getResources().getString(R.string.list_has_no_more));
                this.dlX.ajz();
            }
            this.fwq.setData(dVar.threadList);
            this.fwq.notifyDataSetChanged();
            if (this.frl != null) {
                this.frl.c(this.NZ.getFirstVisiblePosition(), this.NZ.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.NZ != null) {
            this.NZ.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.frl != null) {
            this.frl.destroy();
        }
        if (this.fwq != null) {
            this.fwq.onDestory();
        }
    }

    public void resume() {
        if (this.frl != null) {
            this.frl.bIC();
        }
    }

    public void pause() {
        if (this.frl != null) {
            this.frl.bIB();
        }
    }

    public void km(boolean z) {
        if (this.dnh != null) {
            this.dnh.setVisibility(z ? 0 : 8);
        }
    }

    public void wA(String str) {
        bg bgVar;
        if (!StringUtils.isNull(str) && this.fwr != null && !v.aa(this.fwr.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fwr.threadList.iterator();
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
                this.fwr.threadList.remove(bgVar);
                if (v.aa(this.fwr.threadList)) {
                    this.fwr.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.fwq.setData(this.fwr.threadList);
                this.fwq.notifyDataSetChanged();
            }
        }
    }

    public void bjv() {
        this.NZ.scrollToPosition(0);
    }

    public void refreshView() {
        this.fwq.notifyDataSetChanged();
    }

    public void aID() {
        this.mPullView.ao(false);
    }

    public void kl(boolean z) {
        if (this.fwq != null) {
            this.fwq.kl(z);
        }
    }

    public BdTypeRecyclerView bmx() {
        return this.NZ;
    }

    public m bkE() {
        return this.frl;
    }
}
