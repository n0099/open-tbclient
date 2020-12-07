package com.baidu.tieba.frs.commontab;

import android.graphics.Rect;
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
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.s;
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
/* loaded from: classes22.dex */
public class b {
    private BdTypeRecyclerView Yf;
    private PbListView gre;
    private boolean hasMore;
    private i iBT;
    private FrsCommonTabFragment jbA;
    private a jbV;
    private d jbW;
    private RelativeLayout jbX;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jbY;
    private ak jbZ;
    private ItemInfo jca;
    private View.OnClickListener jcb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gLZ.onScrollToBottom();
        }
    };
    private BdListView.e gLZ = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Yf != null) {
                b.this.Yf.stopScroll();
            }
            if (b.this.gre != null && b.this.jbA != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Yf.setNextPage(b.this.gre);
                    b.this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.gre.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.gre.showLoading();
                        b.this.gre.setOnClickListener(null);
                        b.this.jbA.cqA();
                        return;
                    }
                    b.this.gre.setText(b.this.jbA.getResources().getString(R.string.list_has_no_more));
                    b.this.gre.endLoadData();
                    b.this.gre.setOnClickListener(null);
                    return;
                }
                b.this.Yf.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener ick = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean fbI;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.iBT != null) {
                    b.this.iBT.a(b.this.Yf.getFirstVisiblePosition(), b.this.Yf.getLastVisiblePosition(), this.fbI, true);
                }
                t.csg().oX(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fbI = false;
            } else {
                this.fbI = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.jbA = frsCommonTabFragment;
            this.Yf = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Yf.setLayoutManager(new LinearLayoutManager(this.jbA.getContext()));
            this.Yf.setFadingEdgeLength(0);
            this.Yf.setOverScrollMode(2);
            this.Yf.setOnSrollToBottomListener(this.gLZ);
            this.Yf.addOnScrollListener(this.ick);
            this.Yf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.iBT != null) {
                        b.this.iBT.dl(view2);
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
            this.Yf.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.frs.commontab.b.5
                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                    if (com.baidu.tbadk.a.d.bkA()) {
                        rect.set(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X002));
                        int viewLayoutPosition = ((RecyclerView.LayoutParams) view2.getLayoutParams()).getViewLayoutPosition();
                        if (recyclerView instanceof BdRecyclerView) {
                            int headerViewsCount = ((BdRecyclerView) recyclerView).getHeaderViewsCount();
                            if (viewLayoutPosition >= 0 && viewLayoutPosition <= headerViewsCount - 1) {
                                rect.set(0, 0, 0, 0);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    rect.set(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
                }
            });
            if (!com.baidu.tbadk.a.d.bkA()) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                this.Yf.setPadding(dimenPixelSize, this.Yf.getPaddingTop(), dimenPixelSize, this.Yf.getPaddingBottom());
            }
            this.gre = new PbListView(this.jbA.getPageContext().getPageActivity());
            this.gre.getView();
            this.gre.setContainerBackgroundColorResId(R.color.transparent);
            this.gre.setHeight(l.getDimens(this.jbA.getActivity(), R.dimen.tbds182));
            this.gre.setLineGone();
            this.gre.setTextSize(R.dimen.tbfontsize33);
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gre.bvh();
            this.jbV = new a(this.jbA, this.Yf, frsViewData, this.jbA.tabType == 16);
            lx(false);
            if (this.iBT == null) {
                this.iBT = new i(this.jbA.getPageContext(), this.Yf);
            }
            this.iBT.IJ(1);
            this.iBT.setUniqueId(this.jbA.getUniqueId());
            if (cFu()) {
                this.jbX = new RelativeLayout(this.jbA.getContext());
                this.jbX.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.jbY = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jbA, this.jbX);
                this.Yf.addHeaderView(this.jbX, 0);
                this.jbY.setData(cFv());
            }
            if (this.jbA.tabType == 16) {
                this.jbZ = new ak(this.jbA);
                this.Yf.addHeaderView(this.jbZ.getView(), 0);
                this.jbZ.setData(this.jca);
            }
        }
    }

    private boolean cFu() {
        return this.jbA != null && (this.jbA.isGeneralTab == 1 || this.jbA.tabType == 16);
    }

    public void lx(boolean z) {
        if (this.jbA != null) {
            u uVar = new u();
            uVar.tabId = this.jbA.tabId;
            uVar.fVi = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jbV != null) {
            this.jbV.notifyDataSetChanged();
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.changeSkin(i);
        }
        if (this.jbY != null) {
            this.jbY.onChangeSkinType();
        }
        if (this.jbZ != null) {
            this.jbZ.onChangeSkinType();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (y.isEmpty(dVar.threadList)) {
                s sVar = new s();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(sVar);
                dVar.hasMore = false;
            }
            this.jbW = dVar;
            this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Yf.setNextPage(this.gre);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.gre.setOnClickListener(null);
                    this.gre.showEndLoadData();
                } else {
                    this.gre.showEndLoadData();
                    this.gre.setOnClickListener(this.jcb);
                    this.gre.setText(this.jbA.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.gre.setText(this.jbA.getResources().getString(R.string.list_has_no_more));
                this.gre.setOnClickListener(null);
                this.gre.endLoadData();
            }
            this.jbV.setData(dVar.threadList);
            this.jbV.notifyDataSetChanged();
            if (this.iBT != null) {
                this.iBT.a(this.Yf.getFirstVisiblePosition(), this.Yf.getLastVisiblePosition(), false, true);
            }
            if (cFu() && this.jbY != null) {
                this.jbY.kj(this.jbA.getSortType());
                this.jbY.setFid(this.jbA.forumId);
            }
            this.jca = dVar.itemInfo;
            if (this.jbA.getFragmentActivity() instanceof an) {
                ((an) this.jbA.getFragmentActivity()).a(this.jca);
            }
            if (this.jbA.tabType == 16 && this.jbZ != null) {
                this.jbZ.setData(this.jca);
            }
        }
    }

    private List<FrsTabInfo> cFv() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.jbA.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.jbA.tabType);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.Yf != null) {
            this.Yf.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.iBT != null) {
            this.iBT.destroy();
        }
        if (this.jbV != null) {
            this.jbV.onDestory();
        }
    }

    public void resume() {
        if (this.iBT != null) {
            this.iBT.deK();
        }
    }

    public void pause() {
        if (this.iBT != null) {
            this.iBT.deJ();
        }
    }

    public void qy(boolean z) {
        if (this.Yf != null) {
            this.Yf.setVisibility(z ? 0 : 8);
        }
    }

    public void cER() {
        u uVar = new u();
        uVar.tabId = this.jbA.tabId;
        uVar.fVi = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void KR(String str) {
        by byVar;
        if (!StringUtils.isNull(str) && this.jbW != null && !y.isEmpty(this.jbW.threadList)) {
            Iterator<q> it = this.jbW.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    byVar = null;
                    break;
                }
                q next = it.next();
                if (next != null && (next instanceof by) && TextUtils.equals(str, ((by) next).getId())) {
                    byVar = (by) next;
                    break;
                }
            }
            if (byVar != null) {
                this.jbW.threadList.remove(byVar);
                if (y.isEmpty(this.jbW.threadList)) {
                    this.jbW.threadList.add(new s());
                }
                this.jbV.setData(this.jbW.threadList);
                this.jbV.notifyDataSetChanged();
            }
        }
    }

    public void cBL() {
        this.Yf.scrollToPosition(0);
    }

    public void refreshView() {
        this.jbV.notifyDataSetChanged();
    }

    public void qx(boolean z) {
        if (this.jbV != null) {
            this.jbV.qx(z);
        }
    }

    public BdTypeRecyclerView cFw() {
        return this.Yf;
    }

    public i cDi() {
        return this.iBT;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Yf.setOnScrollListener(onScrollListener);
    }
}
