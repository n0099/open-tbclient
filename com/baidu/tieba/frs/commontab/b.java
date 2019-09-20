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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
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
    private BdTypeRecyclerView Oo;
    private PbListView dpz;
    private BdSwipeRefreshLayout dra;
    private a fDO;
    private d fDP;
    private FrsCommonTabFragment fDw;
    private m fyw;
    private boolean hasMore;
    private i mPullView;
    private BdListView.e dAJ = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Oo != null) {
                b.this.Oo.stopScroll();
            }
            if (b.this.dpz != null && b.this.fDw != null) {
                if (j.kc()) {
                    b.this.Oo.setNextPage(b.this.dpz);
                    b.this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.dpz.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.dpz.showLoading();
                        b.this.fDw.aYU();
                        return;
                    }
                    b.this.dpz.setText(b.this.fDw.getResources().getString(R.string.list_has_no_more));
                    b.this.dpz.akS();
                    return;
                }
                b.this.Oo.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener exg = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean fDR;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.fyw != null) {
                    b.this.fyw.c(b.this.Oo.getFirstVisiblePosition(), b.this.Oo.getLastVisiblePosition(), this.fDR, true);
                }
                t.bat().iH(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fDR = false;
            } else {
                this.fDR = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.fDw = frsCommonTabFragment;
            this.Oo = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Oo.setLayoutManager(new LinearLayoutManager(this.fDw.getContext()));
            this.Oo.setFadingEdgeLength(0);
            this.Oo.setOverScrollMode(2);
            this.Oo.setOnSrollToBottomListener(this.dAJ);
            this.Oo.addOnScrollListener(this.exg);
            this.mPullView = new i(this.fDw.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fDw);
            this.Oo.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.fyw != null) {
                        b.this.fyw.cn(view2);
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
            this.dpz = new PbListView(this.fDw.getPageContext().getPageActivity());
            this.dpz.getView();
            this.dpz.iX(R.color.cp_bg_line_e);
            this.dpz.setHeight(l.g(this.fDw.getActivity(), R.dimen.tbds182));
            this.dpz.akO();
            this.dpz.setTextSize(R.dimen.tbfontsize33);
            this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dpz.iW(R.color.cp_cont_e);
            this.dpz.akV();
            if (this.dra == null) {
                this.dra = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.dra.setProgressView(this.mPullView);
                am.l(this.dra, R.color.cp_bg_line_e);
            }
            this.fDO = new a(this.fDw, this.Oo, frsViewData);
            gf(false);
            if (this.fyw == null) {
                this.fyw = new m(this.fDw.getPageContext(), this.Oo);
            }
            this.fyw.setUniqueId(this.fDw.getUniqueId());
        }
    }

    public void gf(boolean z) {
        if (this.dra != null) {
            this.dra.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        if (this.fDO != null) {
            this.fDO.notifyDataSetChanged();
        }
        if (this.dpz != null) {
            this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dpz.iY(i);
        }
        am.l(this.dra, R.color.cp_bg_line_e);
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
            this.fDP = dVar;
            this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Oo.setNextPage(this.dpz);
            if (this.hasMore) {
                this.dpz.akU();
            } else {
                this.dpz.setText(this.fDw.getResources().getString(R.string.list_has_no_more));
                this.dpz.akS();
            }
            this.fDO.setData(dVar.threadList);
            this.fDO.notifyDataSetChanged();
            if (this.fyw != null) {
                this.fyw.c(this.Oo.getFirstVisiblePosition(), this.Oo.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.Oo != null) {
            this.Oo.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.fyw != null) {
            this.fyw.destroy();
        }
        if (this.fDO != null) {
            this.fDO.onDestory();
        }
    }

    public void resume() {
        if (this.fyw != null) {
            this.fyw.bMo();
        }
    }

    public void pause() {
        if (this.fyw != null) {
            this.fyw.bMn();
        }
    }

    public void kz(boolean z) {
        if (this.dra != null) {
            this.dra.setVisibility(z ? 0 : 8);
        }
    }

    public void xE(String str) {
        bh bhVar;
        if (!StringUtils.isNull(str) && this.fDP != null && !v.aa(this.fDP.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fDP.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bhVar = null;
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && (next instanceof bh) && TextUtils.equals(str, ((bh) next).getId())) {
                    bhVar = (bh) next;
                    break;
                }
            }
            if (bhVar != null) {
                this.fDP.threadList.remove(bhVar);
                if (v.aa(this.fDP.threadList)) {
                    this.fDP.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.fDO.setData(this.fDP.threadList);
                this.fDO.notifyDataSetChanged();
            }
        }
    }

    public void bms() {
        this.Oo.scrollToPosition(0);
    }

    public void refreshView() {
        this.fDO.notifyDataSetChanged();
    }

    public void aKN() {
        this.mPullView.ar(false);
    }

    public void ky(boolean z) {
        if (this.fDO != null) {
            this.fDO.ky(z);
        }
    }

    public BdTypeRecyclerView bpz() {
        return this.Oo;
    }

    public m bnE() {
        return this.fyw;
    }
}
