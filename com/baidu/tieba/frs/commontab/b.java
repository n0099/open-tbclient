package com.baidu.tieba.frs.commontab;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.play.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes2.dex */
public class b {
    private BdTypeRecyclerView Ya;
    private PbListView gxy;
    private boolean hasMore;
    private i iJA;
    private a jjH;
    private d jjI;
    private RelativeLayout jjJ;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jjK;
    private ah jjL;
    private ItemInfo jjM;
    private FrsCommonTabFragment jjj;
    private View.OnClickListener jjN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gTh.onScrollToBottom();
        }
    };
    private BdListView.e gTh = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Ya != null) {
                b.this.Ya.stopScroll();
            }
            if (b.this.gxy != null && b.this.jjj != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Ya.setNextPage(b.this.gxy);
                    b.this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.gxy.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.gxy.showLoading();
                        b.this.gxy.setOnClickListener(null);
                        b.this.jjj.cpD();
                        return;
                    }
                    b.this.gxy.setText(b.this.jjj.getResources().getString(R.string.list_has_no_more));
                    b.this.gxy.endLoadData();
                    b.this.gxy.setOnClickListener(null);
                    return;
                }
                b.this.Ya.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener ikd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean fgG;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.iJA != null) {
                    b.this.iJA.b(b.this.Ya.getFirstVisiblePosition(), b.this.Ya.getLastVisiblePosition(), this.fgG, true);
                }
                s.crj().pr(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fgG = false;
            } else {
                this.fgG = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.jjj = frsCommonTabFragment;
            this.Ya = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Ya.setLayoutManager(new LinearLayoutManager(this.jjj.getContext()));
            this.Ya.setFadingEdgeLength(0);
            this.Ya.setOverScrollMode(2);
            this.Ya.setOnSrollToBottomListener(this.gTh);
            this.Ya.addOnScrollListener(this.ikd);
            this.Ya.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.iJA != null) {
                        b.this.iJA.dv(view2);
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
            this.Ya.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.frs.commontab.b.5
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                    rect.set(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
                    if ((view2 instanceof BaseLegoCardView) || view2.getVisibility() == 8) {
                        rect.set(0, 0, 0, 0);
                    }
                }
            });
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.Ya.setPadding(dimenPixelSize, this.Ya.getPaddingTop(), dimenPixelSize, this.Ya.getPaddingBottom());
            this.gxy = new PbListView(this.jjj.getPageContext().getPageActivity());
            this.gxy.getView();
            this.gxy.setContainerBackgroundColorResId(R.color.transparent);
            this.gxy.setHeight(l.getDimens(this.jjj.getActivity(), R.dimen.tbds182));
            this.gxy.setLineGone();
            this.gxy.setTextSize(R.dimen.tbfontsize33);
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gxy.btJ();
            this.jjH = new a(this.jjj, this.Ya, frsViewData, this.jjj.tabType == 16);
            lQ(false);
            if (this.iJA == null) {
                this.iJA = new i(this.jjj.getPageContext(), this.Ya);
            }
            this.iJA.GW(1);
            this.iJA.setUniqueId(this.jjj.getUniqueId());
            if (cEz()) {
                this.jjJ = new RelativeLayout(this.jjj.getContext());
                this.jjJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.jjK = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jjj, this.jjJ);
                this.Ya.addHeaderView(this.jjJ, 0);
                this.jjK.setData(cEA());
            }
            if (this.jjj.tabType == 16) {
                this.jjL = new ah(this.jjj);
                this.Ya.addHeaderView(this.jjL.getView(), 0);
                this.jjL.setData(this.jjM);
            }
        }
    }

    private boolean cEz() {
        return this.jjj != null && (this.jjj.isGeneralTab == 1 || this.jjj.tabType == 16);
    }

    public void lQ(boolean z) {
        if (this.jjj != null) {
            t tVar = new t();
            tVar.tabId = this.jjj.tabId;
            tVar.gae = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jjH != null) {
            this.jjH.notifyDataSetChanged();
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(i);
        }
        if (this.jjK != null) {
            this.jjK.onChangeSkinType();
        }
        if (this.jjL != null) {
            this.jjL.onChangeSkinType();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (x.isEmpty(dVar.threadList)) {
                com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(sVar);
                dVar.hasMore = false;
            }
            this.jjI = dVar;
            this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Ya.setNextPage(this.gxy);
            if (this.hasMore) {
                if (x.getCount(dVar.threadList) > 3) {
                    this.gxy.setOnClickListener(null);
                    this.gxy.showEndLoadData();
                } else {
                    this.gxy.showEndLoadData();
                    this.gxy.setOnClickListener(this.jjN);
                    this.gxy.setText(this.jjj.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.gxy.setText(this.jjj.getResources().getString(R.string.list_has_no_more));
                this.gxy.setOnClickListener(null);
                this.gxy.endLoadData();
            }
            this.jjH.setData(dVar.threadList);
            this.jjH.notifyDataSetChanged();
            if (this.iJA != null) {
                this.iJA.b(this.Ya.getFirstVisiblePosition(), this.Ya.getLastVisiblePosition(), false, true);
            }
            if (cEz() && this.jjK != null) {
                this.jjK.iC(this.jjj.getSortType());
                this.jjK.setFid(this.jjj.forumId);
            }
            this.jjM = dVar.itemInfo;
            if (this.jjj.getFragmentActivity() instanceof ak) {
                ((ak) this.jjj.getFragmentActivity()).a(this.jjM);
            }
            if (this.jjj.tabType == 16 && this.jjL != null) {
                this.jjL.setData(this.jjM);
            }
        }
    }

    private List<FrsTabInfo> cEA() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.jjj.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.jjj.tabType);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.Ya != null) {
            this.Ya.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.iJA != null) {
            this.iJA.destroy();
        }
        if (this.jjH != null) {
            this.jjH.onDestory();
        }
    }

    public void resume() {
        if (this.iJA != null) {
            this.iJA.daF();
        }
    }

    public void pause() {
        if (this.iJA != null) {
            this.iJA.daE();
        }
    }

    public void qS(boolean z) {
        if (this.Ya != null) {
            this.Ya.setVisibility(z ? 0 : 8);
        }
    }

    public void cDW() {
        t tVar = new t();
        tVar.tabId = this.jjj.tabId;
        tVar.gae = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void JF(String str) {
        bz bzVar;
        if (!StringUtils.isNull(str) && this.jjI != null && !x.isEmpty(this.jjI.threadList)) {
            Iterator<n> it = this.jjI.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bzVar = null;
                    break;
                }
                n next = it.next();
                if (next != null && (next instanceof bz) && TextUtils.equals(str, ((bz) next).getId())) {
                    bzVar = (bz) next;
                    break;
                }
            }
            if (bzVar != null) {
                this.jjI.threadList.remove(bzVar);
                if (x.isEmpty(this.jjI.threadList)) {
                    this.jjI.threadList.add(new com.baidu.tieba.frs.s());
                }
                this.jjH.setData(this.jjI.threadList);
                this.jjH.notifyDataSetChanged();
            }
        }
    }

    public void cAO() {
        this.Ya.scrollToPosition(0);
    }

    public void refreshView() {
        this.jjH.notifyDataSetChanged();
    }

    public void qR(boolean z) {
        if (this.jjH != null) {
            this.jjH.qR(z);
        }
    }

    public BdTypeRecyclerView cEB() {
        return this.Ya;
    }

    public i cCm() {
        return this.iJA;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Ya.setOnScrollListener(onScrollListener);
    }
}
