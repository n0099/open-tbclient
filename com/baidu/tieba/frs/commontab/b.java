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
    private PbListView fDW;
    private i hBL;
    private boolean hasMore;
    private a ibQ;
    private d ibR;
    private RelativeLayout ibS;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a ibT;
    private al ibU;
    private ItemInfo ibV;
    private FrsCommonTabFragment ibw;
    private View.OnClickListener ibW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.fXT.onScrollToBottom();
        }
    };
    private BdListView.e fXT = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Wu != null) {
                b.this.Wu.stopScroll();
            }
            if (b.this.fDW != null && b.this.ibw != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Wu.setNextPage(b.this.fDW);
                    b.this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.fDW.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.fDW.showLoading();
                        b.this.fDW.setOnClickListener(null);
                        b.this.ibw.cat();
                        return;
                    }
                    b.this.fDW.setText(b.this.ibw.getResources().getString(R.string.list_has_no_more));
                    b.this.fDW.endLoadData();
                    b.this.fDW.setOnClickListener(null);
                    return;
                }
                b.this.Wu.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hcz = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean hBQ;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.hBL != null) {
                    b.this.hBL.a(b.this.Wu.getFirstVisiblePosition(), b.this.Wu.getLastVisiblePosition(), this.hBQ, true);
                }
                s.cbX().nk(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hBQ = false;
            } else {
                this.hBQ = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.ibw = frsCommonTabFragment;
            this.Wu = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Wu.setLayoutManager(new LinearLayoutManager(this.ibw.getContext()));
            this.Wu.setFadingEdgeLength(0);
            this.Wu.setOverScrollMode(2);
            this.Wu.setOnSrollToBottomListener(this.fXT);
            this.Wu.addOnScrollListener(this.hcz);
            this.Wu.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.hBL != null) {
                        b.this.hBL.cE(view2);
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
            this.fDW = new PbListView(this.ibw.getPageContext().getPageActivity());
            this.fDW.getView();
            this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fDW.setHeight(l.getDimens(this.ibw.getActivity(), R.dimen.tbds182));
            this.fDW.setLineGone();
            this.fDW.setTextSize(R.dimen.tbfontsize33);
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fDW.bkv();
            this.ibQ = new a(this.ibw, this.Wu, frsViewData);
            kf(false);
            if (this.hBL == null) {
                this.hBL = new i(this.ibw.getPageContext(), this.Wu);
            }
            this.hBL.FH(1);
            this.hBL.setUniqueId(this.ibw.getUniqueId());
            if (cpi()) {
                this.ibS = new RelativeLayout(this.ibw.getContext());
                this.ibS.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.ibT = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.ibw, this.ibS);
                this.Wu.addHeaderView(this.ibS, 0);
                this.ibT.setData(cpj());
            }
            if (this.ibw.tabType == 16) {
                this.ibU = new al(this.ibw);
                this.Wu.addHeaderView(this.ibU.getView(), 0);
                this.ibU.setData(this.ibV);
            }
        }
    }

    private boolean cpi() {
        return this.ibw != null && (this.ibw.isGeneralTab == 1 || this.ibw.tabType == 16);
    }

    public void kf(boolean z) {
        if (this.ibw != null) {
            v vVar = new v();
            vVar.tabId = this.ibw.tabId;
            vVar.fky = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ibQ != null) {
            this.ibQ.notifyDataSetChanged();
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(i);
        }
        if (this.ibT != null) {
            this.ibT.onChangeSkinType();
        }
        if (this.ibU != null) {
            this.ibU.onChangeSkinType();
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
            this.ibR = dVar;
            this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Wu.setNextPage(this.fDW);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.fDW.setOnClickListener(null);
                    this.fDW.showEndLoadData();
                } else {
                    this.fDW.showEndLoadData();
                    this.fDW.setOnClickListener(this.ibW);
                    this.fDW.setText(this.ibw.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.fDW.setText(this.ibw.getResources().getString(R.string.list_has_no_more));
                this.fDW.setOnClickListener(null);
                this.fDW.endLoadData();
            }
            this.ibQ.setData(dVar.threadList);
            this.ibQ.notifyDataSetChanged();
            if (this.hBL != null) {
                this.hBL.a(this.Wu.getFirstVisiblePosition(), this.Wu.getLastVisiblePosition(), false, true);
            }
            if (cpi() && this.ibT != null) {
                this.ibT.changeState(this.ibw.getSortType());
                this.ibT.setFid(this.ibw.forumId);
            }
            this.ibV = dVar.itemInfo;
            if (this.ibw.getFragmentActivity() instanceof ao) {
                ((ao) this.ibw.getFragmentActivity()).a(this.ibV);
            }
            if (this.ibw.tabType == 16 && this.ibU != null) {
                this.ibU.setData(this.ibV);
            }
        }
    }

    private List<FrsTabInfo> cpj() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.ibw.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.ibw.tabType);
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
        if (this.hBL != null) {
            this.hBL.destroy();
        }
        if (this.ibQ != null) {
            this.ibQ.onDestory();
        }
    }

    public void resume() {
        if (this.hBL != null) {
            this.hBL.cNe();
        }
    }

    public void pause() {
        if (this.hBL != null) {
            this.hBL.cNd();
        }
    }

    public void oK(boolean z) {
        if (this.Wu != null) {
            this.Wu.setVisibility(z ? 0 : 8);
        }
    }

    public void coE() {
        v vVar = new v();
        vVar.tabId = this.ibw.tabId;
        vVar.fky = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void Iy(String str) {
        bw bwVar;
        if (!StringUtils.isNull(str) && this.ibR != null && !y.isEmpty(this.ibR.threadList)) {
            Iterator<q> it = this.ibR.threadList.iterator();
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
                this.ibR.threadList.remove(bwVar);
                if (y.isEmpty(this.ibR.threadList)) {
                    this.ibR.threadList.add(new com.baidu.tieba.frs.s());
                }
                this.ibQ.setData(this.ibR.threadList);
                this.ibQ.notifyDataSetChanged();
            }
        }
    }

    public void clz() {
        this.Wu.scrollToPosition(0);
    }

    public void refreshView() {
        this.ibQ.notifyDataSetChanged();
    }

    public void oJ(boolean z) {
        if (this.ibQ != null) {
            this.ibQ.oJ(z);
        }
    }

    public BdTypeRecyclerView cpk() {
        return this.Wu;
    }

    public i cmV() {
        return this.hBL;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Wu.setOnScrollListener(onScrollListener);
    }
}
