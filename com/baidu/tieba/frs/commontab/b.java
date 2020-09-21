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
/* loaded from: classes21.dex */
public class b {
    private BdTypeRecyclerView WM;
    private PbListView fHm;
    private i hIT;
    private boolean hasMore;
    private FrsCommonTabFragment iiG;
    private a ija;
    private d ijb;
    private RelativeLayout ijc;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a ijd;
    private al ije;
    private ItemInfo ijf;
    private View.OnClickListener ijg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gbl.onScrollToBottom();
        }
    };
    private BdListView.e gbl = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.WM != null) {
                b.this.WM.stopScroll();
            }
            if (b.this.fHm != null && b.this.iiG != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.WM.setNextPage(b.this.fHm);
                    b.this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.fHm.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.fHm.showLoading();
                        b.this.fHm.setOnClickListener(null);
                        b.this.iiG.cdG();
                        return;
                    }
                    b.this.fHm.setText(b.this.iiG.getResources().getString(R.string.list_has_no_more));
                    b.this.fHm.endLoadData();
                    b.this.fHm.setOnClickListener(null);
                    return;
                }
                b.this.WM.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hjC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean hIY;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.hIT != null) {
                    b.this.hIT.a(b.this.WM.getFirstVisiblePosition(), b.this.WM.getLastVisiblePosition(), this.hIY, true);
                }
                s.cfn().ns(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hIY = false;
            } else {
                this.hIY = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.iiG = frsCommonTabFragment;
            this.WM = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.WM.setLayoutManager(new LinearLayoutManager(this.iiG.getContext()));
            this.WM.setFadingEdgeLength(0);
            this.WM.setOverScrollMode(2);
            this.WM.setOnSrollToBottomListener(this.gbl);
            this.WM.addOnScrollListener(this.hjC);
            this.WM.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.hIT != null) {
                        b.this.hIT.cN(view2);
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
            this.fHm = new PbListView(this.iiG.getPageContext().getPageActivity());
            this.fHm.getView();
            this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fHm.setHeight(l.getDimens(this.iiG.getActivity(), R.dimen.tbds182));
            this.fHm.setLineGone();
            this.fHm.setTextSize(R.dimen.tbfontsize33);
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fHm.blq();
            this.ija = new a(this.iiG, this.WM, frsViewData);
            ki(false);
            if (this.hIT == null) {
                this.hIT = new i(this.iiG.getPageContext(), this.WM);
            }
            this.hIT.Gi(1);
            this.hIT.setUniqueId(this.iiG.getUniqueId());
            if (csw()) {
                this.ijc = new RelativeLayout(this.iiG.getContext());
                this.ijc.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.ijd = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.iiG, this.ijc);
                this.WM.addHeaderView(this.ijc, 0);
                this.ijd.setData(csx());
            }
            if (this.iiG.tabType == 16) {
                this.ije = new al(this.iiG);
                this.WM.addHeaderView(this.ije.getView(), 0);
                this.ije.setData(this.ijf);
            }
        }
    }

    private boolean csw() {
        return this.iiG != null && (this.iiG.isGeneralTab == 1 || this.iiG.tabType == 16);
    }

    public void ki(boolean z) {
        if (this.iiG != null) {
            v vVar = new v();
            vVar.tabId = this.iiG.tabId;
            vVar.fnv = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ija != null) {
            this.ija.notifyDataSetChanged();
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(i);
        }
        if (this.ijd != null) {
            this.ijd.onChangeSkinType();
        }
        if (this.ije != null) {
            this.ije.onChangeSkinType();
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
            this.ijb = dVar;
            this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.WM.setNextPage(this.fHm);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.fHm.setOnClickListener(null);
                    this.fHm.showEndLoadData();
                } else {
                    this.fHm.showEndLoadData();
                    this.fHm.setOnClickListener(this.ijg);
                    this.fHm.setText(this.iiG.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.fHm.setText(this.iiG.getResources().getString(R.string.list_has_no_more));
                this.fHm.setOnClickListener(null);
                this.fHm.endLoadData();
            }
            this.ija.setData(dVar.threadList);
            this.ija.notifyDataSetChanged();
            if (this.hIT != null) {
                this.hIT.a(this.WM.getFirstVisiblePosition(), this.WM.getLastVisiblePosition(), false, true);
            }
            if (csw() && this.ijd != null) {
                this.ijd.iX(this.iiG.getSortType());
                this.ijd.setFid(this.iiG.forumId);
            }
            this.ijf = dVar.itemInfo;
            if (this.iiG.getFragmentActivity() instanceof ao) {
                ((ao) this.iiG.getFragmentActivity()).a(this.ijf);
            }
            if (this.iiG.tabType == 16 && this.ije != null) {
                this.ije.setData(this.ijf);
            }
        }
    }

    private List<FrsTabInfo> csx() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.iiG.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.iiG.tabType);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.WM != null) {
            this.WM.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.hIT != null) {
            this.hIT.destroy();
        }
        if (this.ija != null) {
            this.ija.onDestory();
        }
    }

    public void resume() {
        if (this.hIT != null) {
            this.hIT.cQK();
        }
    }

    public void pause() {
        if (this.hIT != null) {
            this.hIT.cQJ();
        }
    }

    public void oS(boolean z) {
        if (this.WM != null) {
            this.WM.setVisibility(z ? 0 : 8);
        }
    }

    public void crS() {
        v vVar = new v();
        vVar.tabId = this.iiG.tabId;
        vVar.fnv = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void IW(String str) {
        bw bwVar;
        if (!StringUtils.isNull(str) && this.ijb != null && !y.isEmpty(this.ijb.threadList)) {
            Iterator<q> it = this.ijb.threadList.iterator();
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
                this.ijb.threadList.remove(bwVar);
                if (y.isEmpty(this.ijb.threadList)) {
                    this.ijb.threadList.add(new com.baidu.tieba.frs.s());
                }
                this.ija.setData(this.ijb.threadList);
                this.ija.notifyDataSetChanged();
            }
        }
    }

    public void coM() {
        this.WM.scrollToPosition(0);
    }

    public void refreshView() {
        this.ija.notifyDataSetChanged();
    }

    public void oR(boolean z) {
        if (this.ija != null) {
            this.ija.oR(z);
        }
    }

    public BdTypeRecyclerView csy() {
        return this.WM;
    }

    public i cqi() {
        return this.hIT;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.WM.setOnScrollListener(onScrollListener);
    }
}
