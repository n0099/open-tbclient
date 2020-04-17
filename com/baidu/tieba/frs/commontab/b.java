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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.s;
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
    private BdTypeRecyclerView Vf;
    private PbListView ePm;
    private m gHv;
    private boolean hasMore;
    private a hfP;
    private d hfQ;
    private RelativeLayout hfR;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a hfS;
    private FrsCommonTabFragment hfv;
    private BdListView.e fhr = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Vf != null) {
                b.this.Vf.stopScroll();
            }
            if (b.this.ePm != null && b.this.hfv != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Vf.setNextPage(b.this.ePm);
                    b.this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.ePm.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.ePm.showLoading();
                        b.this.hfv.bDz();
                        return;
                    }
                    b.this.ePm.setText(b.this.hfv.getResources().getString(R.string.list_has_no_more));
                    b.this.ePm.endLoadData();
                    return;
                }
                b.this.Vf.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gii = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean gHz;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.gHv != null) {
                    b.this.gHv.a(b.this.Vf.getFirstVisiblePosition(), b.this.Vf.getLastVisiblePosition(), this.gHz, true);
                }
                r.bEY().lx(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gHz = false;
            } else {
                this.gHz = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.hfv = frsCommonTabFragment;
            this.Vf = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Vf.setLayoutManager(new LinearLayoutManager(this.hfv.getContext()));
            this.Vf.setFadingEdgeLength(0);
            this.Vf.setOverScrollMode(2);
            this.Vf.setOnSrollToBottomListener(this.fhr);
            this.Vf.addOnScrollListener(this.gii);
            this.Vf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.gHv != null) {
                        b.this.gHv.ct(view2);
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
            this.ePm = new PbListView(this.hfv.getPageContext().getPageActivity());
            this.ePm.getView();
            this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.ePm.setHeight(l.getDimens(this.hfv.getActivity(), R.dimen.tbds182));
            this.ePm.setLineGone();
            this.ePm.setTextSize(R.dimen.tbfontsize33);
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ePm.aQd();
            this.hfP = new a(this.hfv, this.Vf, frsViewData);
            it(false);
            if (this.gHv == null) {
                this.gHv = new m(this.hfv.getPageContext(), this.Vf);
            }
            this.gHv.AZ(1);
            this.gHv.setUniqueId(this.hfv.getUniqueId());
            if (this.hfv.isGeneralTab == 1) {
                this.hfR = new RelativeLayout(this.hfv.getContext());
                this.hfR.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.hfS = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.hfv, this.hfR);
                this.Vf.addHeaderView(this.hfR, 0);
                this.hfS.setData(bRv());
            }
        }
    }

    public void it(boolean z) {
        if (this.hfv != null) {
            s sVar = new s();
            sVar.tabId = this.hfv.tabId;
            sVar.etK = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hfP != null) {
            this.hfP.notifyDataSetChanged();
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.changeSkin(i);
        }
        if (this.hfS != null) {
            this.hfS.onChangeSkinType();
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
            this.hfQ = dVar;
            this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Vf.setNextPage(this.ePm);
            if (this.hasMore) {
                this.ePm.showEndLoadData();
            } else {
                this.ePm.setText(this.hfv.getResources().getString(R.string.list_has_no_more));
                this.ePm.endLoadData();
            }
            this.hfP.setData(dVar.threadList);
            this.hfP.notifyDataSetChanged();
            if (this.gHv != null) {
                this.gHv.a(this.Vf.getFirstVisiblePosition(), this.Vf.getLastVisiblePosition(), false, true);
            }
            if (this.hfv.isGeneralTab == 1 && this.hfS != null) {
                this.hfS.changeState(this.hfv.getSortType());
                this.hfS.setFid(this.hfv.forumId);
            }
        }
    }

    private List<FrsTabInfo> bRv() {
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
        if (this.Vf != null) {
            this.Vf.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.gHv != null) {
            this.gHv.destroy();
        }
        if (this.hfP != null) {
            this.hfP.onDestory();
        }
    }

    public void resume() {
        if (this.gHv != null) {
            this.gHv.cnP();
        }
    }

    public void pause() {
        if (this.gHv != null) {
            this.gHv.cnO();
        }
    }

    public void mV(boolean z) {
        if (this.Vf != null) {
            this.Vf.setVisibility(z ? 0 : 8);
        }
    }

    public void bQT() {
        s sVar = new s();
        sVar.tabId = this.hfv.tabId;
        sVar.etK = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void CX(String str) {
        bj bjVar;
        if (!StringUtils.isNull(str) && this.hfQ != null && !v.isEmpty(this.hfQ.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hfQ.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bjVar = null;
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && (next instanceof bj) && TextUtils.equals(str, ((bj) next).getId())) {
                    bjVar = (bj) next;
                    break;
                }
            }
            if (bjVar != null) {
                this.hfQ.threadList.remove(bjVar);
                if (v.isEmpty(this.hfQ.threadList)) {
                    this.hfQ.threadList.add(new p());
                }
                this.hfP.setData(this.hfQ.threadList);
                this.hfP.notifyDataSetChanged();
            }
        }
    }

    public void bOe() {
        this.Vf.scrollToPosition(0);
    }

    public void refreshView() {
        this.hfP.notifyDataSetChanged();
    }

    public void mU(boolean z) {
        if (this.hfP != null) {
            this.hfP.mU(z);
        }
    }

    public BdTypeRecyclerView bRw() {
        return this.Vf;
    }

    public m bPv() {
        return this.gHv;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Vf.setOnScrollListener(onScrollListener);
    }
}
