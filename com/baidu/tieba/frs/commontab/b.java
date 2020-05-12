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
    private BdTypeRecyclerView Vi;
    private PbListView ePr;
    private m gHB;
    private boolean hasMore;
    private FrsCommonTabFragment hfB;
    private a hfV;
    private d hfW;
    private RelativeLayout hfX;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a hfY;
    private BdListView.e fhw = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Vi != null) {
                b.this.Vi.stopScroll();
            }
            if (b.this.ePr != null && b.this.hfB != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Vi.setNextPage(b.this.ePr);
                    b.this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.ePr.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.ePr.showLoading();
                        b.this.hfB.bDy();
                        return;
                    }
                    b.this.ePr.setText(b.this.hfB.getResources().getString(R.string.list_has_no_more));
                    b.this.ePr.endLoadData();
                    return;
                }
                b.this.Vi.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gio = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean gHF;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.gHB != null) {
                    b.this.gHB.a(b.this.Vi.getFirstVisiblePosition(), b.this.Vi.getLastVisiblePosition(), this.gHF, true);
                }
                r.bEX().lx(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gHF = false;
            } else {
                this.gHF = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.hfB = frsCommonTabFragment;
            this.Vi = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Vi.setLayoutManager(new LinearLayoutManager(this.hfB.getContext()));
            this.Vi.setFadingEdgeLength(0);
            this.Vi.setOverScrollMode(2);
            this.Vi.setOnSrollToBottomListener(this.fhw);
            this.Vi.addOnScrollListener(this.gio);
            this.Vi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.gHB != null) {
                        b.this.gHB.ct(view2);
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
            this.ePr = new PbListView(this.hfB.getPageContext().getPageActivity());
            this.ePr.getView();
            this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.ePr.setHeight(l.getDimens(this.hfB.getActivity(), R.dimen.tbds182));
            this.ePr.setLineGone();
            this.ePr.setTextSize(R.dimen.tbfontsize33);
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ePr.aQa();
            this.hfV = new a(this.hfB, this.Vi, frsViewData);
            it(false);
            if (this.gHB == null) {
                this.gHB = new m(this.hfB.getPageContext(), this.Vi);
            }
            this.gHB.AZ(1);
            this.gHB.setUniqueId(this.hfB.getUniqueId());
            if (this.hfB.isGeneralTab == 1) {
                this.hfX = new RelativeLayout(this.hfB.getContext());
                this.hfX.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.hfY = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.hfB, this.hfX);
                this.Vi.addHeaderView(this.hfX, 0);
                this.hfY.setData(bRu());
            }
        }
    }

    public void it(boolean z) {
        if (this.hfB != null) {
            s sVar = new s();
            sVar.tabId = this.hfB.tabId;
            sVar.etP = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hfV != null) {
            this.hfV.notifyDataSetChanged();
        }
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePr.changeSkin(i);
        }
        if (this.hfY != null) {
            this.hfY.onChangeSkinType();
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
            this.hfW = dVar;
            this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Vi.setNextPage(this.ePr);
            if (this.hasMore) {
                this.ePr.showEndLoadData();
            } else {
                this.ePr.setText(this.hfB.getResources().getString(R.string.list_has_no_more));
                this.ePr.endLoadData();
            }
            this.hfV.setData(dVar.threadList);
            this.hfV.notifyDataSetChanged();
            if (this.gHB != null) {
                this.gHB.a(this.Vi.getFirstVisiblePosition(), this.Vi.getLastVisiblePosition(), false, true);
            }
            if (this.hfB.isGeneralTab == 1 && this.hfY != null) {
                this.hfY.changeState(this.hfB.getSortType());
                this.hfY.setFid(this.hfB.forumId);
            }
        }
    }

    private List<FrsTabInfo> bRu() {
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
        if (this.Vi != null) {
            this.Vi.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.gHB != null) {
            this.gHB.destroy();
        }
        if (this.hfV != null) {
            this.hfV.onDestory();
        }
    }

    public void resume() {
        if (this.gHB != null) {
            this.gHB.cnN();
        }
    }

    public void pause() {
        if (this.gHB != null) {
            this.gHB.cnM();
        }
    }

    public void mV(boolean z) {
        if (this.Vi != null) {
            this.Vi.setVisibility(z ? 0 : 8);
        }
    }

    public void bQS() {
        s sVar = new s();
        sVar.tabId = this.hfB.tabId;
        sVar.etP = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void Da(String str) {
        bj bjVar;
        if (!StringUtils.isNull(str) && this.hfW != null && !v.isEmpty(this.hfW.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hfW.threadList.iterator();
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
                this.hfW.threadList.remove(bjVar);
                if (v.isEmpty(this.hfW.threadList)) {
                    this.hfW.threadList.add(new p());
                }
                this.hfV.setData(this.hfW.threadList);
                this.hfV.notifyDataSetChanged();
            }
        }
    }

    public void bOd() {
        this.Vi.scrollToPosition(0);
    }

    public void refreshView() {
        this.hfV.notifyDataSetChanged();
    }

    public void mU(boolean z) {
        if (this.hfV != null) {
            this.hfV.mU(z);
        }
    }

    public BdTypeRecyclerView bRv() {
        return this.Vi;
    }

    public m bPu() {
        return this.gHB;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Vi.setOnScrollListener(onScrollListener);
    }
}
