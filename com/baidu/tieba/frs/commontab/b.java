package com.baidu.tieba.frs.commontab;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView Vw;
    private PbListView fcj;
    private m gWx;
    private boolean hasMore;
    private FrsCommonTabFragment huA;
    private a huU;
    private d huV;
    private RelativeLayout huW;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a huX;
    private BdListView.e fvq = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Vw != null) {
                b.this.Vw.stopScroll();
            }
            if (b.this.fcj != null && b.this.huA != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Vw.setNextPage(b.this.fcj);
                    b.this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.fcj.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.fcj.showLoading();
                        b.this.huA.bJR();
                        return;
                    }
                    b.this.fcj.setText(b.this.huA.getResources().getString(R.string.list_has_no_more));
                    b.this.fcj.endLoadData();
                    return;
                }
                b.this.Vw.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gxp = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean gWB;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.gWx != null) {
                    b.this.gWx.a(b.this.Vw.getFirstVisiblePosition(), b.this.Vw.getLastVisiblePosition(), this.gWB, true);
                }
                s.bLs().lT(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gWB = false;
            } else {
                this.gWB = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.huA = frsCommonTabFragment;
            this.Vw = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Vw.setLayoutManager(new LinearLayoutManager(this.huA.getContext()));
            this.Vw.setFadingEdgeLength(0);
            this.Vw.setOverScrollMode(2);
            this.Vw.setOnSrollToBottomListener(this.fvq);
            this.Vw.addOnScrollListener(this.gxp);
            this.Vw.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.gWx != null) {
                        b.this.gWx.ct(view2);
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
            this.fcj = new PbListView(this.huA.getPageContext().getPageActivity());
            this.fcj.getView();
            this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fcj.setHeight(l.getDimens(this.huA.getActivity(), R.dimen.tbds182));
            this.fcj.setLineGone();
            this.fcj.setTextSize(R.dimen.tbfontsize33);
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fcj.aWf();
            this.huU = new a(this.huA, this.Vw, frsViewData);
            iQ(false);
            if (this.gWx == null) {
                this.gWx = new m(this.huA.getPageContext(), this.Vw);
            }
            this.gWx.BL(1);
            this.gWx.setUniqueId(this.huA.getUniqueId());
            if (bXS()) {
                this.huW = new RelativeLayout(this.huA.getContext());
                this.huW.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.huX = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.huA, this.huW);
                this.Vw.addHeaderView(this.huW, 0);
                this.huX.setData(bXT());
            }
        }
    }

    private boolean bXS() {
        return this.huA != null && (this.huA.isGeneralTab == 1 || this.huA.tabType == 16);
    }

    public void iQ(boolean z) {
        if (this.huA != null) {
            com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
            sVar.tabId = this.huA.tabId;
            sVar.eIz = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.huU != null) {
            this.huU.notifyDataSetChanged();
        }
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.changeSkin(i);
        }
        if (this.huX != null) {
            this.huX.onChangeSkinType();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (v.isEmpty(dVar.threadList)) {
                p pVar = new p();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(pVar);
                dVar.hasMore = false;
            }
            this.huV = dVar;
            this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Vw.setNextPage(this.fcj);
            if (this.hasMore) {
                this.fcj.showEndLoadData();
            } else {
                this.fcj.setText(this.huA.getResources().getString(R.string.list_has_no_more));
                this.fcj.endLoadData();
            }
            this.huU.setData(dVar.threadList);
            this.huU.notifyDataSetChanged();
            if (this.gWx != null) {
                this.gWx.a(this.Vw.getFirstVisiblePosition(), this.Vw.getLastVisiblePosition(), false, true);
            }
            if (bXS() && this.huX != null) {
                this.huX.changeState(this.huA.getSortType());
                this.huX.setFid(this.huA.forumId);
            }
        }
    }

    private List<FrsTabInfo> bXT() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.Vw != null) {
            this.Vw.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.gWx != null) {
            this.gWx.destroy();
        }
        if (this.huU != null) {
            this.huU.onDestory();
        }
    }

    public void resume() {
        if (this.gWx != null) {
            this.gWx.cuy();
        }
    }

    public void pause() {
        if (this.gWx != null) {
            this.gWx.cux();
        }
    }

    public void nq(boolean z) {
        if (this.Vw != null) {
            this.Vw.setVisibility(z ? 0 : 8);
        }
    }

    public void bXq() {
        com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
        sVar.tabId = this.huA.tabId;
        sVar.eIz = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void EJ(String str) {
        bk bkVar;
        if (!StringUtils.isNull(str) && this.huV != null && !v.isEmpty(this.huV.threadList)) {
            Iterator<o> it = this.huV.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bkVar = null;
                    break;
                }
                o next = it.next();
                if (next != null && (next instanceof bk) && TextUtils.equals(str, ((bk) next).getId())) {
                    bkVar = (bk) next;
                    break;
                }
            }
            if (bkVar != null) {
                this.huV.threadList.remove(bkVar);
                if (v.isEmpty(this.huV.threadList)) {
                    this.huV.threadList.add(new p());
                }
                this.huU.setData(this.huV.threadList);
                this.huU.notifyDataSetChanged();
            }
        }
    }

    public void bUA() {
        this.Vw.scrollToPosition(0);
    }

    public void refreshView() {
        this.huU.notifyDataSetChanged();
    }

    public void np(boolean z) {
        if (this.huU != null) {
            this.huU.np(z);
        }
    }

    public BdTypeRecyclerView bXU() {
        return this.Vw;
    }

    public m bVS() {
        return this.gWx;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Vw.setOnScrollListener(onScrollListener);
    }
}
