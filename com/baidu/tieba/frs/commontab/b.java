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
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.play.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes22.dex */
public class b {
    private BdTypeRecyclerView Xe;
    private PbListView gdy;
    private boolean hasMore;
    private FrsCommonTabFragment iJZ;
    private a iKt;
    private d iKu;
    private RelativeLayout iKv;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a iKw;
    private al iKx;
    private ItemInfo iKy;
    private i iko;
    private View.OnClickListener iKz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gxH.onScrollToBottom();
        }
    };
    private BdListView.e gxH = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Xe != null) {
                b.this.Xe.stopScroll();
            }
            if (b.this.gdy != null && b.this.iJZ != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Xe.setNextPage(b.this.gdy);
                    b.this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.gdy.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.gdy.showLoading();
                        b.this.gdy.setOnClickListener(null);
                        b.this.iJZ.ckj();
                        return;
                    }
                    b.this.gdy.setText(b.this.iJZ.getResources().getString(R.string.list_has_no_more));
                    b.this.gdy.endLoadData();
                    b.this.gdy.setOnClickListener(null);
                    return;
                }
                b.this.Xe.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hKT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean ikt;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.iko != null) {
                    b.this.iko.a(b.this.Xe.getFirstVisiblePosition(), b.this.Xe.getLastVisiblePosition(), this.ikt, true);
                }
                t.clQ().op(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.ikt = false;
            } else {
                this.ikt = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.iJZ = frsCommonTabFragment;
            this.Xe = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Xe.setLayoutManager(new LinearLayoutManager(this.iJZ.getContext()));
            this.Xe.setFadingEdgeLength(0);
            this.Xe.setOverScrollMode(2);
            this.Xe.setOnSrollToBottomListener(this.gxH);
            this.Xe.addOnScrollListener(this.hKT);
            this.Xe.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.iko != null) {
                        b.this.iko.cV(view2);
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
            this.gdy = new PbListView(this.iJZ.getPageContext().getPageActivity());
            this.gdy.getView();
            this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.gdy.setHeight(l.getDimens(this.iJZ.getActivity(), R.dimen.tbds182));
            this.gdy.setLineGone();
            this.gdy.setTextSize(R.dimen.tbfontsize33);
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gdy.bpT();
            this.iKt = new a(this.iJZ, this.Xe, frsViewData);
            kT(false);
            if (this.iko == null) {
                this.iko = new i(this.iJZ.getPageContext(), this.Xe);
            }
            this.iko.Hh(1);
            this.iko.setUniqueId(this.iJZ.getUniqueId());
            if (cza()) {
                this.iKv = new RelativeLayout(this.iJZ.getContext());
                this.iKv.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.iKw = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.iJZ, this.iKv);
                this.Xe.addHeaderView(this.iKv, 0);
                this.iKw.setData(czb());
            }
            if (this.iJZ.tabType == 16) {
                this.iKx = new al(this.iJZ);
                this.Xe.addHeaderView(this.iKx.getView(), 0);
                this.iKx.setData(this.iKy);
            }
        }
    }

    private boolean cza() {
        return this.iJZ != null && (this.iJZ.isGeneralTab == 1 || this.iJZ.tabType == 16);
    }

    public void kT(boolean z) {
        if (this.iJZ != null) {
            v vVar = new v();
            vVar.tabId = this.iJZ.tabId;
            vVar.fIe = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iKt != null) {
            this.iKt.notifyDataSetChanged();
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.changeSkin(i);
        }
        if (this.iKw != null) {
            this.iKw.onChangeSkinType();
        }
        if (this.iKx != null) {
            this.iKx.onChangeSkinType();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (y.isEmpty(dVar.threadList)) {
                s sVar = new s();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(sVar);
                dVar.hasMore = false;
            }
            this.iKu = dVar;
            this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Xe.setNextPage(this.gdy);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.gdy.setOnClickListener(null);
                    this.gdy.showEndLoadData();
                } else {
                    this.gdy.showEndLoadData();
                    this.gdy.setOnClickListener(this.iKz);
                    this.gdy.setText(this.iJZ.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.gdy.setText(this.iJZ.getResources().getString(R.string.list_has_no_more));
                this.gdy.setOnClickListener(null);
                this.gdy.endLoadData();
            }
            this.iKt.setData(dVar.threadList);
            this.iKt.notifyDataSetChanged();
            if (this.iko != null) {
                this.iko.a(this.Xe.getFirstVisiblePosition(), this.Xe.getLastVisiblePosition(), false, true);
            }
            if (cza() && this.iKw != null) {
                this.iKw.jF(this.iJZ.getSortType());
                this.iKw.setFid(this.iJZ.forumId);
            }
            this.iKy = dVar.itemInfo;
            if (this.iJZ.getFragmentActivity() instanceof ao) {
                ((ao) this.iJZ.getFragmentActivity()).a(this.iKy);
            }
            if (this.iJZ.tabType == 16 && this.iKx != null) {
                this.iKx.setData(this.iKy);
            }
        }
    }

    private List<FrsTabInfo> czb() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.iJZ.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.iJZ.tabType);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.Xe != null) {
            this.Xe.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.iko != null) {
            this.iko.destroy();
        }
        if (this.iKt != null) {
            this.iKt.onDestory();
        }
    }

    public void resume() {
        if (this.iko != null) {
            this.iko.cXB();
        }
    }

    public void pause() {
        if (this.iko != null) {
            this.iko.cXA();
        }
    }

    public void pP(boolean z) {
        if (this.Xe != null) {
            this.Xe.setVisibility(z ? 0 : 8);
        }
    }

    public void cyx() {
        v vVar = new v();
        vVar.tabId = this.iJZ.tabId;
        vVar.fIe = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void Ki(String str) {
        bw bwVar;
        if (!StringUtils.isNull(str) && this.iKu != null && !y.isEmpty(this.iKu.threadList)) {
            Iterator<q> it = this.iKu.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bwVar = null;
                    break;
                }
                q next = it.next();
                if (next != null && (next instanceof bw) && TextUtils.equals(str, ((bw) next).getId())) {
                    bwVar = (bw) next;
                    break;
                }
            }
            if (bwVar != null) {
                this.iKu.threadList.remove(bwVar);
                if (y.isEmpty(this.iKu.threadList)) {
                    this.iKu.threadList.add(new s());
                }
                this.iKt.setData(this.iKu.threadList);
                this.iKt.notifyDataSetChanged();
            }
        }
    }

    public void cvr() {
        this.Xe.scrollToPosition(0);
    }

    public void refreshView() {
        this.iKt.notifyDataSetChanged();
    }

    public void pO(boolean z) {
        if (this.iKt != null) {
            this.iKt.pO(z);
        }
    }

    public BdTypeRecyclerView czc() {
        return this.Xe;
    }

    public i cwN() {
        return this.iko;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Xe.setOnScrollListener(onScrollListener);
    }
}
