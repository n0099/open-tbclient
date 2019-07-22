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
    private BdTypeRecyclerView Op;
    private PbListView dnG;
    private BdSwipeRefreshLayout dpi;
    private BdListView.e dyR = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Op != null) {
                b.this.Op.stopScroll();
            }
            if (b.this.dnG != null && b.this.fAV != null) {
                if (j.kc()) {
                    b.this.Op.setNextPage(b.this.dnG);
                    b.this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.dnG.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.dnG.showLoading();
                        b.this.fAV.aYo();
                        return;
                    }
                    b.this.dnG.setText(b.this.fAV.getResources().getString(R.string.list_has_no_more));
                    b.this.dnG.akE();
                    return;
                }
                b.this.Op.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener evp = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean fBq;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.fwk != null) {
                    b.this.fwk.c(b.this.Op.getFirstVisiblePosition(), b.this.Op.getLastVisiblePosition(), this.fBq, true);
                }
                t.aZN().iE(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fBq = false;
            } else {
                this.fBq = true;
            }
        }
    };
    private FrsCommonTabFragment fAV;
    private a fBn;
    private d fBo;
    private m fwk;
    private boolean hasMore;
    private i mPullView;

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.fAV = frsCommonTabFragment;
            this.Op = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Op.setLayoutManager(new LinearLayoutManager(this.fAV.getContext()));
            this.Op.setFadingEdgeLength(0);
            this.Op.setOverScrollMode(2);
            this.Op.setOnSrollToBottomListener(this.dyR);
            this.Op.addOnScrollListener(this.evp);
            this.mPullView = new i(this.fAV.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fAV);
            this.Op.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.fwk != null) {
                        b.this.fwk.cm(view2);
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
            this.dnG = new PbListView(this.fAV.getPageContext().getPageActivity());
            this.dnG.getView();
            this.dnG.iU(R.color.cp_bg_line_e);
            this.dnG.setHeight(l.g(this.fAV.getActivity(), R.dimen.tbds182));
            this.dnG.akA();
            this.dnG.setTextSize(R.dimen.tbfontsize33);
            this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dnG.iT(R.color.cp_cont_e);
            this.dnG.akH();
            if (this.dpi == null) {
                this.dpi = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.dpi.setProgressView(this.mPullView);
                am.l(this.dpi, R.color.cp_bg_line_e);
            }
            this.fBn = new a(this.fAV, this.Op, frsViewData);
            gc(false);
            if (this.fwk == null) {
                this.fwk = new m(this.fAV.getPageContext(), this.Op);
            }
            this.fwk.setUniqueId(this.fAV.getUniqueId());
        }
    }

    public void gc(boolean z) {
        if (this.dpi != null) {
            this.dpi.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.fBn != null) {
            this.fBn.notifyDataSetChanged();
        }
        if (this.dnG != null) {
            this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dnG.iV(i);
        }
        am.l(this.dpi, R.color.cp_bg_line_e);
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
            this.fBo = dVar;
            this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Op.setNextPage(this.dnG);
            if (this.hasMore) {
                this.dnG.akG();
            } else {
                this.dnG.setText(this.fAV.getResources().getString(R.string.list_has_no_more));
                this.dnG.akE();
            }
            this.fBn.setData(dVar.threadList);
            this.fBn.notifyDataSetChanged();
            if (this.fwk != null) {
                this.fwk.c(this.Op.getFirstVisiblePosition(), this.Op.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.Op != null) {
            this.Op.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.fwk != null) {
            this.fwk.destroy();
        }
        if (this.fBn != null) {
            this.fBn.onDestory();
        }
    }

    public void resume() {
        if (this.fwk != null) {
            this.fwk.bLn();
        }
    }

    public void pause() {
        if (this.fwk != null) {
            this.fwk.bLm();
        }
    }

    public void kw(boolean z) {
        if (this.dpi != null) {
            this.dpi.setVisibility(z ? 0 : 8);
        }
    }

    public void xe(String str) {
        bg bgVar;
        if (!StringUtils.isNull(str) && this.fBo != null && !v.aa(this.fBo.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fBo.threadList.iterator();
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
                this.fBo.threadList.remove(bgVar);
                if (v.aa(this.fBo.threadList)) {
                    this.fBo.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.fBn.setData(this.fBo.threadList);
                this.fBn.notifyDataSetChanged();
            }
        }
    }

    public void blA() {
        this.Op.scrollToPosition(0);
    }

    public void refreshView() {
        this.fBn.notifyDataSetChanged();
    }

    public void aKh() {
        this.mPullView.ar(false);
    }

    public void kv(boolean z) {
        if (this.fBn != null) {
            this.fBn.kv(z);
        }
    }

    public BdTypeRecyclerView boB() {
        return this.Op;
    }

    public m bmJ() {
        return this.fwk;
    }
}
