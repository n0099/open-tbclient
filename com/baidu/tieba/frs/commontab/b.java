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
    private PbListView bOy;
    private BdTypeRecyclerView bRk;
    private BdSwipeRefreshLayout bRl;
    private m dKi;
    private FrsCommonTabFragment dOC;
    private a dOR;
    private d dOS;
    private boolean hasMore;
    private k mPullView;
    private BdListView.e bVt = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.bRk != null) {
                b.this.bRk.stopScroll();
            }
            if (b.this.bOy != null && b.this.dOC != null) {
                if (j.kV()) {
                    b.this.bRk.setNextPage(b.this.bOy);
                    b.this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.bOy.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.bOy.showLoading();
                        b.this.dOC.aDi();
                        return;
                    }
                    b.this.bOy.setText(b.this.dOC.getResources().getString(e.j.list_has_no_more));
                    b.this.bOy.Fd();
                    return;
                }
                b.this.bRk.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener dOT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean dOV;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.dKi != null) {
                    b.this.dKi.b(b.this.bRk.getFirstVisiblePosition(), b.this.bRk.getLastVisiblePosition(), this.dOV, true);
                }
                v.apD().ft(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.dOV = false;
            } else {
                this.dOV = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view) {
        if (frsCommonTabFragment != null && view != null) {
            this.dOC = frsCommonTabFragment;
            this.bRk = (BdTypeRecyclerView) view.findViewById(e.g.frs_common_tab_recycler_view);
            this.bRk.setLayoutManager(new LinearLayoutManager(this.dOC.getContext()));
            this.bRk.setFadingEdgeLength(0);
            this.bRk.setOverScrollMode(2);
            this.bRk.setOnSrollToBottomListener(this.bVt);
            this.bRk.addOnScrollListener(this.dOT);
            this.mPullView = new k(this.dOC.getPageContext());
            this.mPullView.a(this.dOC);
            this.bRk.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.dKi != null) {
                        b.this.dKi.bj(view2);
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
            this.bOy = new PbListView(this.dOC.getPageContext().getPageActivity());
            this.bOy.oD();
            this.bOy.ex(e.d.cp_bg_line_e);
            this.bOy.setHeight(l.h(this.dOC.getActivity(), e.C0210e.tbds182));
            this.bOy.EZ();
            this.bOy.setTextSize(e.C0210e.tbfontsize33);
            this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bOy.ew(e.d.cp_cont_e);
            if (this.bRl == null) {
                this.bRl = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_common_tab_pull_refresh_layout);
                this.bRl.setProgressView(this.mPullView);
                al.j(this.bRl, e.d.cp_bg_line_e);
            }
            this.dOR = new a(this.dOC, this.bRk);
            di(false);
            if (this.dKi == null) {
                this.dKi = new m(this.dOC.getPageContext(), this.bRk);
            }
            this.dKi.setUniqueId(this.dOC.getUniqueId());
        }
    }

    public void di(boolean z) {
        if (this.bRl != null) {
            this.bRl.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dOR != null) {
            this.dOR.notifyDataSetChanged();
        }
        if (this.bOy != null) {
            this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bOy.ey(i);
        }
        al.j(this.bRl, e.d.cp_bg_line_e);
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
            this.dOS = dVar;
            this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.bRk.setNextPage(this.bOy);
            if (this.hasMore) {
                this.bOy.Ff();
            } else {
                this.bOy.setText(this.dOC.getResources().getString(e.j.list_has_no_more));
                this.bOy.Fd();
            }
            this.dOR.setData(dVar.threadList);
            this.dOR.notifyDataSetChanged();
            if (this.dKi != null) {
                this.dKi.b(this.bRk.getFirstVisiblePosition(), this.bRk.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.bRk != null) {
            this.bRk.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.dKi != null) {
            this.dKi.destroy();
        }
        if (this.dOR != null) {
            this.dOR.onDestory();
        }
    }

    public void resume() {
        if (this.dKi != null) {
            this.dKi.aZd();
        }
    }

    public void pause() {
        if (this.dKi != null) {
            this.dKi.aZc();
        }
    }

    public void gY(boolean z) {
        if (this.bRl != null) {
            this.bRl.setVisibility(z ? 0 : 8);
        }
    }

    public void ok(String str) {
        bb bbVar;
        if (!StringUtils.isNull(str) && this.dOS != null && !com.baidu.tbadk.core.util.v.I(this.dOS.threadList)) {
            Iterator<h> it = this.dOS.threadList.iterator();
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
                this.dOS.threadList.remove(bbVar);
                if (com.baidu.tbadk.core.util.v.I(this.dOS.threadList)) {
                    this.dOS.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.dOR.notifyDataSetChanged();
            }
        }
    }
}
