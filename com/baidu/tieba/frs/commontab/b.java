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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.u;
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
    private BdTypeRecyclerView VT;
    private PbListView fsC;
    private a hNL;
    private d hNM;
    private RelativeLayout hNN;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a hNO;
    private aj hNP;
    private ItemInfo hNQ;
    private FrsCommonTabFragment hNr;
    private boolean hasMore;
    private i hoU;
    private View.OnClickListener hNR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.fLV.onScrollToBottom();
        }
    };
    private BdListView.e fLV = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.VT != null) {
                b.this.VT.stopScroll();
            }
            if (b.this.fsC != null && b.this.hNr != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.VT.setNextPage(b.this.fsC);
                    b.this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.fsC.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.fsC.showLoading();
                        b.this.fsC.setOnClickListener(null);
                        b.this.hNr.bQi();
                        return;
                    }
                    b.this.fsC.setText(b.this.hNr.getResources().getString(R.string.list_has_no_more));
                    b.this.fsC.endLoadData();
                    b.this.fsC.setOnClickListener(null);
                    return;
                }
                b.this.VT.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gPJ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean hoZ;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.hoU != null) {
                    b.this.hoU.a(b.this.VT.getFirstVisiblePosition(), b.this.VT.getLastVisiblePosition(), this.hoZ, true);
                }
                s.bRL().mH(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hoZ = false;
            } else {
                this.hoZ = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.hNr = frsCommonTabFragment;
            this.VT = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.VT.setLayoutManager(new LinearLayoutManager(this.hNr.getContext()));
            this.VT.setFadingEdgeLength(0);
            this.VT.setOverScrollMode(2);
            this.VT.setOnSrollToBottomListener(this.fLV);
            this.VT.addOnScrollListener(this.gPJ);
            this.VT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.hoU != null) {
                        b.this.hoU.cA(view2);
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
            this.fsC = new PbListView(this.hNr.getPageContext().getPageActivity());
            this.fsC.getView();
            this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fsC.setHeight(l.getDimens(this.hNr.getActivity(), R.dimen.tbds182));
            this.fsC.setLineGone();
            this.fsC.setTextSize(R.dimen.tbfontsize33);
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fsC.bbZ();
            this.hNL = new a(this.hNr, this.VT, frsViewData);
            jH(false);
            if (this.hoU == null) {
                this.hoU = new i(this.hNr.getPageContext(), this.VT);
            }
            this.hoU.Dm(1);
            this.hoU.setUniqueId(this.hNr.getUniqueId());
            if (ceE()) {
                this.hNN = new RelativeLayout(this.hNr.getContext());
                this.hNN.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.hNO = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.hNr, this.hNN);
                this.VT.addHeaderView(this.hNN, 0);
                this.hNO.setData(ceF());
            }
            if (this.hNr.tabType == 16) {
                this.hNP = new aj(this.hNr);
                this.VT.addHeaderView(this.hNP.getView(), 0);
                this.hNP.setData(this.hNQ);
            }
        }
    }

    private boolean ceE() {
        return this.hNr != null && (this.hNr.isGeneralTab == 1 || this.hNr.tabType == 16);
    }

    public void jH(boolean z) {
        if (this.hNr != null) {
            u uVar = new u();
            uVar.tabId = this.hNr.tabId;
            uVar.eZg = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hNL != null) {
            this.hNL.notifyDataSetChanged();
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
        if (this.hNO != null) {
            this.hNO.onChangeSkinType();
        }
        if (this.hNP != null) {
            this.hNP.onChangeSkinType();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (x.isEmpty(dVar.threadList)) {
                r rVar = new r();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(rVar);
                dVar.hasMore = false;
            }
            this.hNM = dVar;
            this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.VT.setNextPage(this.fsC);
            if (this.hasMore) {
                if (x.getCount(dVar.threadList) > 3) {
                    this.fsC.setOnClickListener(null);
                    this.fsC.showEndLoadData();
                } else {
                    this.fsC.showEndLoadData();
                    this.fsC.setOnClickListener(this.hNR);
                    this.fsC.setText(this.hNr.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.fsC.setText(this.hNr.getResources().getString(R.string.list_has_no_more));
                this.fsC.setOnClickListener(null);
                this.fsC.endLoadData();
            }
            this.hNL.setData(dVar.threadList);
            this.hNL.notifyDataSetChanged();
            if (this.hoU != null) {
                this.hoU.a(this.VT.getFirstVisiblePosition(), this.VT.getLastVisiblePosition(), false, true);
            }
            if (ceE() && this.hNO != null) {
                this.hNO.changeState(this.hNr.getSortType());
                this.hNO.setFid(this.hNr.forumId);
            }
            this.hNQ = dVar.itemInfo;
            if (this.hNr.getFragmentActivity() instanceof am) {
                ((am) this.hNr.getFragmentActivity()).a(this.hNQ);
            }
            if (this.hNr.tabType == 16 && this.hNP != null) {
                this.hNP.setData(this.hNQ);
            }
        }
    }

    private List<FrsTabInfo> ceF() {
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
        if (this.VT != null) {
            this.VT.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.hoU != null) {
            this.hoU.destroy();
        }
        if (this.hNL != null) {
            this.hNL.onDestory();
        }
    }

    public void resume() {
        if (this.hoU != null) {
            this.hoU.cCm();
        }
    }

    public void pause() {
        if (this.hoU != null) {
            this.hoU.cCl();
        }
    }

    public void og(boolean z) {
        if (this.VT != null) {
            this.VT.setVisibility(z ? 0 : 8);
        }
    }

    public void cea() {
        u uVar = new u();
        uVar.tabId = this.hNr.tabId;
        uVar.eZg = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void FW(String str) {
        bv bvVar;
        if (!StringUtils.isNull(str) && this.hNM != null && !x.isEmpty(this.hNM.threadList)) {
            Iterator<q> it = this.hNM.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bvVar = null;
                    break;
                }
                q next = it.next();
                if (next != null && (next instanceof bv) && TextUtils.equals(str, ((bv) next).getId())) {
                    bvVar = (bv) next;
                    break;
                }
            }
            if (bvVar != null) {
                this.hNM.threadList.remove(bvVar);
                if (x.isEmpty(this.hNM.threadList)) {
                    this.hNM.threadList.add(new r());
                }
                this.hNL.setData(this.hNM.threadList);
                this.hNL.notifyDataSetChanged();
            }
        }
    }

    public void cbd() {
        this.VT.scrollToPosition(0);
    }

    public void refreshView() {
        this.hNL.notifyDataSetChanged();
    }

    public void of(boolean z) {
        if (this.hNL != null) {
            this.hNL.of(z);
        }
    }

    public BdTypeRecyclerView ceG() {
        return this.VT;
    }

    public i ccy() {
        return this.hoU;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.VT.setOnScrollListener(onScrollListener);
    }
}
