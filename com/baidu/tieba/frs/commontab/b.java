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
    private PbListView fbY;
    private m gWm;
    private boolean hasMore;
    private a huJ;
    private d huK;
    private RelativeLayout huL;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a huM;
    private FrsCommonTabFragment hup;
    private BdListView.e fvf = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Vw != null) {
                b.this.Vw.stopScroll();
            }
            if (b.this.fbY != null && b.this.hup != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Vw.setNextPage(b.this.fbY);
                    b.this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.fbY.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.fbY.showLoading();
                        b.this.hup.bJP();
                        return;
                    }
                    b.this.fbY.setText(b.this.hup.getResources().getString(R.string.list_has_no_more));
                    b.this.fbY.endLoadData();
                    return;
                }
                b.this.Vw.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gxe = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean gWq;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.gWm != null) {
                    b.this.gWm.a(b.this.Vw.getFirstVisiblePosition(), b.this.Vw.getLastVisiblePosition(), this.gWq, true);
                }
                s.bLq().lT(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gWq = false;
            } else {
                this.gWq = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.hup = frsCommonTabFragment;
            this.Vw = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Vw.setLayoutManager(new LinearLayoutManager(this.hup.getContext()));
            this.Vw.setFadingEdgeLength(0);
            this.Vw.setOverScrollMode(2);
            this.Vw.setOnSrollToBottomListener(this.fvf);
            this.Vw.addOnScrollListener(this.gxe);
            this.Vw.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.gWm != null) {
                        b.this.gWm.ct(view2);
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
            this.fbY = new PbListView(this.hup.getPageContext().getPageActivity());
            this.fbY.getView();
            this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fbY.setHeight(l.getDimens(this.hup.getActivity(), R.dimen.tbds182));
            this.fbY.setLineGone();
            this.fbY.setTextSize(R.dimen.tbfontsize33);
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fbY.aWe();
            this.huJ = new a(this.hup, this.Vw, frsViewData);
            iQ(false);
            if (this.gWm == null) {
                this.gWm = new m(this.hup.getPageContext(), this.Vw);
            }
            this.gWm.BJ(1);
            this.gWm.setUniqueId(this.hup.getUniqueId());
            if (this.hup.isGeneralTab == 1) {
                this.huL = new RelativeLayout(this.hup.getContext());
                this.huL.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.huM = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.hup, this.huL);
                this.Vw.addHeaderView(this.huL, 0);
                this.huM.setData(bXQ());
            }
        }
    }

    public void iQ(boolean z) {
        if (this.hup != null) {
            com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
            sVar.tabId = this.hup.tabId;
            sVar.eIo = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.huJ != null) {
            this.huJ.notifyDataSetChanged();
        }
        if (this.fbY != null) {
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fbY.changeSkin(i);
        }
        if (this.huM != null) {
            this.huM.onChangeSkinType();
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
            this.huK = dVar;
            this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Vw.setNextPage(this.fbY);
            if (this.hasMore) {
                this.fbY.showEndLoadData();
            } else {
                this.fbY.setText(this.hup.getResources().getString(R.string.list_has_no_more));
                this.fbY.endLoadData();
            }
            this.huJ.setData(dVar.threadList);
            this.huJ.notifyDataSetChanged();
            if (this.gWm != null) {
                this.gWm.a(this.Vw.getFirstVisiblePosition(), this.Vw.getLastVisiblePosition(), false, true);
            }
            if (this.hup.isGeneralTab == 1 && this.huM != null) {
                this.huM.changeState(this.hup.getSortType());
                this.huM.setFid(this.hup.forumId);
            }
        }
    }

    private List<FrsTabInfo> bXQ() {
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
        if (this.gWm != null) {
            this.gWm.destroy();
        }
        if (this.huJ != null) {
            this.huJ.onDestory();
        }
    }

    public void resume() {
        if (this.gWm != null) {
            this.gWm.cup();
        }
    }

    public void pause() {
        if (this.gWm != null) {
            this.gWm.cuo();
        }
    }

    public void nq(boolean z) {
        if (this.Vw != null) {
            this.Vw.setVisibility(z ? 0 : 8);
        }
    }

    public void bXo() {
        com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
        sVar.tabId = this.hup.tabId;
        sVar.eIo = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void EJ(String str) {
        bk bkVar;
        if (!StringUtils.isNull(str) && this.huK != null && !v.isEmpty(this.huK.threadList)) {
            Iterator<o> it = this.huK.threadList.iterator();
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
                this.huK.threadList.remove(bkVar);
                if (v.isEmpty(this.huK.threadList)) {
                    this.huK.threadList.add(new p());
                }
                this.huJ.setData(this.huK.threadList);
                this.huJ.notifyDataSetChanged();
            }
        }
    }

    public void bUy() {
        this.Vw.scrollToPosition(0);
    }

    public void refreshView() {
        this.huJ.notifyDataSetChanged();
    }

    public void np(boolean z) {
        if (this.huJ != null) {
            this.huJ.np(z);
        }
    }

    public BdTypeRecyclerView bXR() {
        return this.Vw;
    }

    public m bVQ() {
        return this.gWm;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Vw.setOnScrollListener(onScrollListener);
    }
}
