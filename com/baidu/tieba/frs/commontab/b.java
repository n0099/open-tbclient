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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView Wa;
    private PbListView fnt;
    private a hHK;
    private d hHL;
    private RelativeLayout hHM;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a hHN;
    private aj hHO;
    private ItemInfo hHP;
    private FrsCommonTabFragment hHq;
    private boolean hasMore;
    private m hjm;
    private BdListView.e fGA = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Wa != null) {
                b.this.Wa.stopScroll();
            }
            if (b.this.fnt != null && b.this.hHq != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Wa.setNextPage(b.this.fnt);
                    b.this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.fnt.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.fnt.showLoading();
                        b.this.hHq.bMX();
                        return;
                    }
                    b.this.fnt.setText(b.this.hHq.getResources().getString(R.string.list_has_no_more));
                    b.this.fnt.endLoadData();
                    return;
                }
                b.this.Wa.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gKd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean hjr;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.hjm != null) {
                    b.this.hjm.a(b.this.Wa.getFirstVisiblePosition(), b.this.Wa.getLastVisiblePosition(), this.hjr, true);
                }
                s.bOB().mc(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hjr = false;
            } else {
                this.hjr = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.hHq = frsCommonTabFragment;
            this.Wa = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Wa.setLayoutManager(new LinearLayoutManager(this.hHq.getContext()));
            this.Wa.setFadingEdgeLength(0);
            this.Wa.setOverScrollMode(2);
            this.Wa.setOnSrollToBottomListener(this.fGA);
            this.Wa.addOnScrollListener(this.gKd);
            this.Wa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.hjm != null) {
                        b.this.hjm.cu(view2);
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
            this.fnt = new PbListView(this.hHq.getPageContext().getPageActivity());
            this.fnt.getView();
            this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fnt.setHeight(l.getDimens(this.hHq.getActivity(), R.dimen.tbds182));
            this.fnt.setLineGone();
            this.fnt.setTextSize(R.dimen.tbfontsize33);
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fnt.aXZ();
            this.hHK = new a(this.hHq, this.Wa, frsViewData);
            jc(false);
            if (this.hjm == null) {
                this.hjm = new m(this.hHq.getPageContext(), this.Wa);
            }
            this.hjm.CN(1);
            this.hjm.setUniqueId(this.hHq.getUniqueId());
            if (cbg()) {
                this.hHM = new RelativeLayout(this.hHq.getContext());
                this.hHM.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.hHN = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.hHq, this.hHM);
                this.Wa.addHeaderView(this.hHM, 0);
                this.hHN.setData(cbh());
            }
            if (this.hHq.tabType == 16) {
                this.hHO = new aj(this.hHq);
                this.Wa.addHeaderView(this.hHO.getView(), 0);
                this.hHO.setData(this.hHP);
            }
        }
    }

    private boolean cbg() {
        return this.hHq != null && (this.hHq.isGeneralTab == 1 || this.hHq.tabType == 16);
    }

    public void jc(boolean z) {
        if (this.hHq != null) {
            u uVar = new u();
            uVar.tabId = this.hHq.tabId;
            uVar.eSL = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hHK != null) {
            this.hHK.notifyDataSetChanged();
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.changeSkin(i);
        }
        if (this.hHN != null) {
            this.hHN.onChangeSkinType();
        }
        if (this.hHO != null) {
            this.hHO.onChangeSkinType();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (w.isEmpty(dVar.threadList)) {
                r rVar = new r();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(rVar);
                dVar.hasMore = false;
            }
            this.hHL = dVar;
            this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Wa.setNextPage(this.fnt);
            if (this.hasMore) {
                this.fnt.showEndLoadData();
            } else {
                this.fnt.setText(this.hHq.getResources().getString(R.string.list_has_no_more));
                this.fnt.endLoadData();
            }
            this.hHK.setData(dVar.threadList);
            this.hHK.notifyDataSetChanged();
            if (this.hjm != null) {
                this.hjm.a(this.Wa.getFirstVisiblePosition(), this.Wa.getLastVisiblePosition(), false, true);
            }
            if (cbg() && this.hHN != null) {
                this.hHN.changeState(this.hHq.getSortType());
                this.hHN.setFid(this.hHq.forumId);
            }
            this.hHP = dVar.itemInfo;
            if (this.hHq.getFragmentActivity() instanceof am) {
                ((am) this.hHq.getFragmentActivity()).a(this.hHP);
            }
            if (this.hHq.tabType == 16 && this.hHO != null) {
                this.hHO.setData(this.hHP);
            }
        }
    }

    private List<FrsTabInfo> cbh() {
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
        if (this.Wa != null) {
            this.Wa.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.hjm != null) {
            this.hjm.destroy();
        }
        if (this.hHK != null) {
            this.hHK.onDestory();
        }
    }

    public void resume() {
        if (this.hjm != null) {
            this.hjm.cyo();
        }
    }

    public void pause() {
        if (this.hjm != null) {
            this.hjm.cyn();
        }
    }

    public void nB(boolean z) {
        if (this.Wa != null) {
            this.Wa.setVisibility(z ? 0 : 8);
        }
    }

    public void caC() {
        u uVar = new u();
        uVar.tabId = this.hHq.tabId;
        uVar.eSL = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void Fk(String str) {
        bu buVar;
        if (!StringUtils.isNull(str) && this.hHL != null && !w.isEmpty(this.hHL.threadList)) {
            Iterator<q> it = this.hHL.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    buVar = null;
                    break;
                }
                q next = it.next();
                if (next != null && (next instanceof bu) && TextUtils.equals(str, ((bu) next).getId())) {
                    buVar = (bu) next;
                    break;
                }
            }
            if (buVar != null) {
                this.hHL.threadList.remove(buVar);
                if (w.isEmpty(this.hHL.threadList)) {
                    this.hHL.threadList.add(new r());
                }
                this.hHK.setData(this.hHL.threadList);
                this.hHK.notifyDataSetChanged();
            }
        }
    }

    public void bXH() {
        this.Wa.scrollToPosition(0);
    }

    public void refreshView() {
        this.hHK.notifyDataSetChanged();
    }

    public void nA(boolean z) {
        if (this.hHK != null) {
            this.hHK.nA(z);
        }
    }

    public BdTypeRecyclerView cbi() {
        return this.Wa;
    }

    public m bZb() {
        return this.hjm;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Wa.setOnScrollListener(onScrollListener);
    }
}
