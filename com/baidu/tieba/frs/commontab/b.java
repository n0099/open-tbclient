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
/* loaded from: classes22.dex */
public class b {
    private BdTypeRecyclerView Xc;
    private PbListView fTv;
    private i hXO;
    private boolean hasMore;
    private FrsCommonTabFragment ixD;
    private a ixX;
    private d ixY;
    private RelativeLayout ixZ;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a iya;
    private al iyb;
    private ItemInfo iyc;
    private View.OnClickListener iyd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gnC.onScrollToBottom();
        }
    };
    private BdListView.e gnC = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Xc != null) {
                b.this.Xc.stopScroll();
            }
            if (b.this.fTv != null && b.this.ixD != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Xc.setNextPage(b.this.fTv);
                    b.this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.fTv.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.fTv.showLoading();
                        b.this.fTv.setOnClickListener(null);
                        b.this.ixD.chc();
                        return;
                    }
                    b.this.fTv.setText(b.this.ixD.getResources().getString(R.string.list_has_no_more));
                    b.this.fTv.endLoadData();
                    b.this.fTv.setOnClickListener(null);
                    return;
                }
                b.this.Xc.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hyx = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean hXT;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.hXO != null) {
                    b.this.hXO.a(b.this.Xc.getFirstVisiblePosition(), b.this.Xc.getLastVisiblePosition(), this.hXT, true);
                }
                s.ciJ().nX(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hXT = false;
            } else {
                this.hXT = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.ixD = frsCommonTabFragment;
            this.Xc = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Xc.setLayoutManager(new LinearLayoutManager(this.ixD.getContext()));
            this.Xc.setFadingEdgeLength(0);
            this.Xc.setOverScrollMode(2);
            this.Xc.setOnSrollToBottomListener(this.gnC);
            this.Xc.addOnScrollListener(this.hyx);
            this.Xc.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.hXO != null) {
                        b.this.hXO.cR(view2);
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
            this.fTv = new PbListView(this.ixD.getPageContext().getPageActivity());
            this.fTv.getView();
            this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fTv.setHeight(l.getDimens(this.ixD.getActivity(), R.dimen.tbds182));
            this.fTv.setLineGone();
            this.fTv.setTextSize(R.dimen.tbfontsize33);
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fTv.boa();
            this.ixX = new a(this.ixD, this.Xc, frsViewData);
            kG(false);
            if (this.hXO == null) {
                this.hXO = new i(this.ixD.getPageContext(), this.Xc);
            }
            this.hXO.GO(1);
            this.hXO.setUniqueId(this.ixD.getUniqueId());
            if (cvT()) {
                this.ixZ = new RelativeLayout(this.ixD.getContext());
                this.ixZ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.iya = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.ixD, this.ixZ);
                this.Xc.addHeaderView(this.ixZ, 0);
                this.iya.setData(cvU());
            }
            if (this.ixD.tabType == 16) {
                this.iyb = new al(this.ixD);
                this.Xc.addHeaderView(this.iyb.getView(), 0);
                this.iyb.setData(this.iyc);
            }
        }
    }

    private boolean cvT() {
        return this.ixD != null && (this.ixD.isGeneralTab == 1 || this.ixD.tabType == 16);
    }

    public void kG(boolean z) {
        if (this.ixD != null) {
            v vVar = new v();
            vVar.tabId = this.ixD.tabId;
            vVar.fzJ = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ixX != null) {
            this.ixX.notifyDataSetChanged();
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.changeSkin(i);
        }
        if (this.iya != null) {
            this.iya.onChangeSkinType();
        }
        if (this.iyb != null) {
            this.iyb.onChangeSkinType();
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
            this.ixY = dVar;
            this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Xc.setNextPage(this.fTv);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.fTv.setOnClickListener(null);
                    this.fTv.showEndLoadData();
                } else {
                    this.fTv.showEndLoadData();
                    this.fTv.setOnClickListener(this.iyd);
                    this.fTv.setText(this.ixD.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.fTv.setText(this.ixD.getResources().getString(R.string.list_has_no_more));
                this.fTv.setOnClickListener(null);
                this.fTv.endLoadData();
            }
            this.ixX.setData(dVar.threadList);
            this.ixX.notifyDataSetChanged();
            if (this.hXO != null) {
                this.hXO.a(this.Xc.getFirstVisiblePosition(), this.Xc.getLastVisiblePosition(), false, true);
            }
            if (cvT() && this.iya != null) {
                this.iya.ju(this.ixD.getSortType());
                this.iya.setFid(this.ixD.forumId);
            }
            this.iyc = dVar.itemInfo;
            if (this.ixD.getFragmentActivity() instanceof ao) {
                ((ao) this.ixD.getFragmentActivity()).a(this.iyc);
            }
            if (this.ixD.tabType == 16 && this.iyb != null) {
                this.iyb.setData(this.iyc);
            }
        }
    }

    private List<FrsTabInfo> cvU() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.ixD.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.ixD.tabType);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.Xc != null) {
            this.Xc.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.hXO != null) {
            this.hXO.destroy();
        }
        if (this.ixX != null) {
            this.ixX.onDestory();
        }
    }

    public void resume() {
        if (this.hXO != null) {
            this.hXO.cUu();
        }
    }

    public void pause() {
        if (this.hXO != null) {
            this.hXO.cUt();
        }
    }

    public void px(boolean z) {
        if (this.Xc != null) {
            this.Xc.setVisibility(z ? 0 : 8);
        }
    }

    public void cvq() {
        v vVar = new v();
        vVar.tabId = this.ixD.tabId;
        vVar.fzJ = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void JJ(String str) {
        bw bwVar;
        if (!StringUtils.isNull(str) && this.ixY != null && !y.isEmpty(this.ixY.threadList)) {
            Iterator<q> it = this.ixY.threadList.iterator();
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
                this.ixY.threadList.remove(bwVar);
                if (y.isEmpty(this.ixY.threadList)) {
                    this.ixY.threadList.add(new com.baidu.tieba.frs.s());
                }
                this.ixX.setData(this.ixY.threadList);
                this.ixX.notifyDataSetChanged();
            }
        }
    }

    public void csk() {
        this.Xc.scrollToPosition(0);
    }

    public void refreshView() {
        this.ixX.notifyDataSetChanged();
    }

    public void pw(boolean z) {
        if (this.ixX != null) {
            this.ixX.pw(z);
        }
    }

    public BdTypeRecyclerView cvV() {
        return this.Xc;
    }

    public i ctG() {
        return this.hXO;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Xc.setOnScrollListener(onScrollListener);
    }
}
