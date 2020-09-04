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
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
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
/* loaded from: classes16.dex */
public class b {
    private BdTypeRecyclerView Wu;
    private PbListView fEa;
    private i hBR;
    private boolean hasMore;
    private FrsCommonTabFragment ibC;
    private a ibW;
    private d ibX;
    private RelativeLayout ibY;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a ibZ;
    private al ica;
    private ItemInfo icb;
    private View.OnClickListener icc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.fXX.onScrollToBottom();
        }
    };
    private BdListView.e fXX = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Wu != null) {
                b.this.Wu.stopScroll();
            }
            if (b.this.fEa != null && b.this.ibC != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Wu.setNextPage(b.this.fEa);
                    b.this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.fEa.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.fEa.showLoading();
                        b.this.fEa.setOnClickListener(null);
                        b.this.ibC.cau();
                        return;
                    }
                    b.this.fEa.setText(b.this.ibC.getResources().getString(R.string.list_has_no_more));
                    b.this.fEa.endLoadData();
                    b.this.fEa.setOnClickListener(null);
                    return;
                }
                b.this.Wu.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hcD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean hBW;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.hBR != null) {
                    b.this.hBR.a(b.this.Wu.getFirstVisiblePosition(), b.this.Wu.getLastVisiblePosition(), this.hBW, true);
                }
                s.cbY().nm(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hBW = false;
            } else {
                this.hBW = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.ibC = frsCommonTabFragment;
            this.Wu = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Wu.setLayoutManager(new LinearLayoutManager(this.ibC.getContext()));
            this.Wu.setFadingEdgeLength(0);
            this.Wu.setOverScrollMode(2);
            this.Wu.setOnSrollToBottomListener(this.fXX);
            this.Wu.addOnScrollListener(this.hcD);
            this.Wu.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.hBR != null) {
                        b.this.hBR.cE(view2);
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
            this.fEa = new PbListView(this.ibC.getPageContext().getPageActivity());
            this.fEa.getView();
            this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fEa.setHeight(l.getDimens(this.ibC.getActivity(), R.dimen.tbds182));
            this.fEa.setLineGone();
            this.fEa.setTextSize(R.dimen.tbfontsize33);
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fEa.bkv();
            this.ibW = new a(this.ibC, this.Wu, frsViewData);
            kh(false);
            if (this.hBR == null) {
                this.hBR = new i(this.ibC.getPageContext(), this.Wu);
            }
            this.hBR.FH(1);
            this.hBR.setUniqueId(this.ibC.getUniqueId());
            if (cpj()) {
                this.ibY = new RelativeLayout(this.ibC.getContext());
                this.ibY.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.ibZ = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.ibC, this.ibY);
                this.Wu.addHeaderView(this.ibY, 0);
                this.ibZ.setData(cpk());
            }
            if (this.ibC.tabType == 16) {
                this.ica = new al(this.ibC);
                this.Wu.addHeaderView(this.ica.getView(), 0);
                this.ica.setData(this.icb);
            }
        }
    }

    private boolean cpj() {
        return this.ibC != null && (this.ibC.isGeneralTab == 1 || this.ibC.tabType == 16);
    }

    public void kh(boolean z) {
        if (this.ibC != null) {
            v vVar = new v();
            vVar.tabId = this.ibC.tabId;
            vVar.fkC = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ibW != null) {
            this.ibW.notifyDataSetChanged();
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.changeSkin(i);
        }
        if (this.ibZ != null) {
            this.ibZ.onChangeSkinType();
        }
        if (this.ica != null) {
            this.ica.onChangeSkinType();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (y.isEmpty(dVar.threadList)) {
                com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(sVar);
                dVar.hasMore = false;
            }
            this.ibX = dVar;
            this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Wu.setNextPage(this.fEa);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.fEa.setOnClickListener(null);
                    this.fEa.showEndLoadData();
                } else {
                    this.fEa.showEndLoadData();
                    this.fEa.setOnClickListener(this.icc);
                    this.fEa.setText(this.ibC.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.fEa.setText(this.ibC.getResources().getString(R.string.list_has_no_more));
                this.fEa.setOnClickListener(null);
                this.fEa.endLoadData();
            }
            this.ibW.setData(dVar.threadList);
            this.ibW.notifyDataSetChanged();
            if (this.hBR != null) {
                this.hBR.a(this.Wu.getFirstVisiblePosition(), this.Wu.getLastVisiblePosition(), false, true);
            }
            if (cpj() && this.ibZ != null) {
                this.ibZ.changeState(this.ibC.getSortType());
                this.ibZ.setFid(this.ibC.forumId);
            }
            this.icb = dVar.itemInfo;
            if (this.ibC.getFragmentActivity() instanceof ao) {
                ((ao) this.ibC.getFragmentActivity()).a(this.icb);
            }
            if (this.ibC.tabType == 16 && this.ica != null) {
                this.ica.setData(this.icb);
            }
        }
    }

    private List<FrsTabInfo> cpk() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.ibC.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.ibC.tabType);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.Wu != null) {
            this.Wu.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.hBR != null) {
            this.hBR.destroy();
        }
        if (this.ibW != null) {
            this.ibW.onDestory();
        }
    }

    public void resume() {
        if (this.hBR != null) {
            this.hBR.cNf();
        }
    }

    public void pause() {
        if (this.hBR != null) {
            this.hBR.cNe();
        }
    }

    public void oM(boolean z) {
        if (this.Wu != null) {
            this.Wu.setVisibility(z ? 0 : 8);
        }
    }

    public void coF() {
        v vVar = new v();
        vVar.tabId = this.ibC.tabId;
        vVar.fkC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void Iz(String str) {
        bw bwVar;
        if (!StringUtils.isNull(str) && this.ibX != null && !y.isEmpty(this.ibX.threadList)) {
            Iterator<q> it = this.ibX.threadList.iterator();
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
                this.ibX.threadList.remove(bwVar);
                if (y.isEmpty(this.ibX.threadList)) {
                    this.ibX.threadList.add(new com.baidu.tieba.frs.s());
                }
                this.ibW.setData(this.ibX.threadList);
                this.ibW.notifyDataSetChanged();
            }
        }
    }

    public void clA() {
        this.Wu.scrollToPosition(0);
    }

    public void refreshView() {
        this.ibW.notifyDataSetChanged();
    }

    public void oL(boolean z) {
        if (this.ibW != null) {
            this.ibW.oL(z);
        }
    }

    public BdTypeRecyclerView cpl() {
        return this.Wu;
    }

    public i cmW() {
        return this.hBR;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Wu.setOnScrollListener(onScrollListener);
    }
}
