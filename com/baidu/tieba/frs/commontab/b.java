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
    private PbListView gjo;
    private boolean hasMore;
    private FrsCommonTabFragment iPW;
    private a iQq;
    private d iQr;
    private RelativeLayout iQs;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a iQt;
    private al iQu;
    private ItemInfo iQv;
    private i iqn;
    private View.OnClickListener iQw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gDv.onScrollToBottom();
        }
    };
    private BdListView.e gDv = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Xe != null) {
                b.this.Xe.stopScroll();
            }
            if (b.this.gjo != null && b.this.iPW != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Xe.setNextPage(b.this.gjo);
                    b.this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.gjo.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.gjo.showLoading();
                        b.this.gjo.setOnClickListener(null);
                        b.this.iPW.cmL();
                        return;
                    }
                    b.this.gjo.setText(b.this.iPW.getResources().getString(R.string.list_has_no_more));
                    b.this.gjo.endLoadData();
                    b.this.gjo.setOnClickListener(null);
                    return;
                }
                b.this.Xe.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hQQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean iqs;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.iqn != null) {
                    b.this.iqn.a(b.this.Xe.getFirstVisiblePosition(), b.this.Xe.getLastVisiblePosition(), this.iqs, true);
                }
                t.cor().oy(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.iqs = false;
            } else {
                this.iqs = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.iPW = frsCommonTabFragment;
            this.Xe = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Xe.setLayoutManager(new LinearLayoutManager(this.iPW.getContext()));
            this.Xe.setFadingEdgeLength(0);
            this.Xe.setOverScrollMode(2);
            this.Xe.setOnSrollToBottomListener(this.gDv);
            this.Xe.addOnScrollListener(this.hQQ);
            this.Xe.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.iqn != null) {
                        b.this.iqn.da(view2);
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
            this.gjo = new PbListView(this.iPW.getPageContext().getPageActivity());
            this.gjo.getView();
            this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.gjo.setHeight(l.getDimens(this.iPW.getActivity(), R.dimen.tbds182));
            this.gjo.setLineGone();
            this.gjo.setTextSize(R.dimen.tbfontsize33);
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gjo.bst();
            this.iQq = new a(this.iPW, this.Xe, frsViewData);
            lc(false);
            if (this.iqn == null) {
                this.iqn = new i(this.iPW.getPageContext(), this.Xe);
            }
            this.iqn.Hu(1);
            this.iqn.setUniqueId(this.iPW.getUniqueId());
            if (cBB()) {
                this.iQs = new RelativeLayout(this.iPW.getContext());
                this.iQs.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.iQt = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.iPW, this.iQs);
                this.Xe.addHeaderView(this.iQs, 0);
                this.iQt.setData(cBC());
            }
            if (this.iPW.tabType == 16) {
                this.iQu = new al(this.iPW);
                this.Xe.addHeaderView(this.iQu.getView(), 0);
                this.iQu.setData(this.iQv);
            }
        }
    }

    private boolean cBB() {
        return this.iPW != null && (this.iPW.isGeneralTab == 1 || this.iPW.tabType == 16);
    }

    public void lc(boolean z) {
        if (this.iPW != null) {
            v vVar = new v();
            vVar.tabId = this.iPW.tabId;
            vVar.fNU = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iQq != null) {
            this.iQq.notifyDataSetChanged();
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
        if (this.iQt != null) {
            this.iQt.onChangeSkinType();
        }
        if (this.iQu != null) {
            this.iQu.onChangeSkinType();
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
            this.iQr = dVar;
            this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Xe.setNextPage(this.gjo);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.gjo.setOnClickListener(null);
                    this.gjo.showEndLoadData();
                } else {
                    this.gjo.showEndLoadData();
                    this.gjo.setOnClickListener(this.iQw);
                    this.gjo.setText(this.iPW.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.gjo.setText(this.iPW.getResources().getString(R.string.list_has_no_more));
                this.gjo.setOnClickListener(null);
                this.gjo.endLoadData();
            }
            this.iQq.setData(dVar.threadList);
            this.iQq.notifyDataSetChanged();
            if (this.iqn != null) {
                this.iqn.a(this.Xe.getFirstVisiblePosition(), this.Xe.getLastVisiblePosition(), false, true);
            }
            if (cBB() && this.iQt != null) {
                this.iQt.jP(this.iPW.getSortType());
                this.iQt.setFid(this.iPW.forumId);
            }
            this.iQv = dVar.itemInfo;
            if (this.iPW.getFragmentActivity() instanceof ao) {
                ((ao) this.iPW.getFragmentActivity()).a(this.iQv);
            }
            if (this.iPW.tabType == 16 && this.iQu != null) {
                this.iQu.setData(this.iQv);
            }
        }
    }

    private List<FrsTabInfo> cBC() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.iPW.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.iPW.tabType);
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
        if (this.iqn != null) {
            this.iqn.destroy();
        }
        if (this.iQq != null) {
            this.iQq.onDestory();
        }
    }

    public void resume() {
        if (this.iqn != null) {
            this.iqn.dac();
        }
    }

    public void pause() {
        if (this.iqn != null) {
            this.iqn.dab();
        }
    }

    public void pY(boolean z) {
        if (this.Xe != null) {
            this.Xe.setVisibility(z ? 0 : 8);
        }
    }

    public void cAY() {
        v vVar = new v();
        vVar.tabId = this.iPW.tabId;
        vVar.fNU = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void Kz(String str) {
        bw bwVar;
        if (!StringUtils.isNull(str) && this.iQr != null && !y.isEmpty(this.iQr.threadList)) {
            Iterator<q> it = this.iQr.threadList.iterator();
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
                this.iQr.threadList.remove(bwVar);
                if (y.isEmpty(this.iQr.threadList)) {
                    this.iQr.threadList.add(new s());
                }
                this.iQq.setData(this.iQr.threadList);
                this.iQq.notifyDataSetChanged();
            }
        }
    }

    public void cxS() {
        this.Xe.scrollToPosition(0);
    }

    public void refreshView() {
        this.iQq.notifyDataSetChanged();
    }

    public void pX(boolean z) {
        if (this.iQq != null) {
            this.iQq.pX(z);
        }
    }

    public BdTypeRecyclerView cBD() {
        return this.Xe;
    }

    public i czo() {
        return this.iqn;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Xe.setOnScrollListener(onScrollListener);
    }
}
