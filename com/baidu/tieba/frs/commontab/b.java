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
    private PbListView grg;
    private boolean hasMore;
    private i iBV;
    private FrsCommonTabFragment jbC;
    private a jbX;
    private d jbY;
    private RelativeLayout jbZ;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jca;
    private ak jcb;
    private ItemInfo jcc;
    private View.OnClickListener jcd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gMb.onScrollToBottom();
        }
    };
    private BdListView.e gMb = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Yf != null) {
                b.this.Yf.stopScroll();
            }
            if (b.this.grg != null && b.this.jbC != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Yf.setNextPage(b.this.grg);
                    b.this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.grg.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.grg.showLoading();
                        b.this.grg.setOnClickListener(null);
                        b.this.jbC.cqB();
                        return;
                    }
                    b.this.grg.setText(b.this.jbC.getResources().getString(R.string.list_has_no_more));
                    b.this.grg.endLoadData();
                    b.this.grg.setOnClickListener(null);
                    return;
                }
                b.this.Yf.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener icm = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean fbI;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.iBV != null) {
                    b.this.iBV.a(b.this.Yf.getFirstVisiblePosition(), b.this.Yf.getLastVisiblePosition(), this.fbI, true);
                }
                t.csh().oX(true);
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
            this.jbC = frsCommonTabFragment;
            this.Yf = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Yf.setLayoutManager(new LinearLayoutManager(this.jbC.getContext()));
            this.Yf.setFadingEdgeLength(0);
            this.Yf.setOverScrollMode(2);
            this.Yf.setOnSrollToBottomListener(this.gMb);
            this.Yf.addOnScrollListener(this.icm);
            this.Yf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.iBV != null) {
                        b.this.iBV.dl(view2);
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
            this.grg = new PbListView(this.jbC.getPageContext().getPageActivity());
            this.grg.getView();
            this.grg.setContainerBackgroundColorResId(R.color.transparent);
            this.grg.setHeight(l.getDimens(this.jbC.getActivity(), R.dimen.tbds182));
            this.grg.setLineGone();
            this.grg.setTextSize(R.dimen.tbfontsize33);
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
            this.grg.bvh();
            this.jbX = new a(this.jbC, this.Yf, frsViewData, this.jbC.tabType == 16);
            lx(false);
            if (this.iBV == null) {
                this.iBV = new i(this.jbC.getPageContext(), this.Yf);
            }
            this.iBV.IJ(1);
            this.iBV.setUniqueId(this.jbC.getUniqueId());
            if (cFv()) {
                this.jbZ = new RelativeLayout(this.jbC.getContext());
                this.jbZ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.jca = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jbC, this.jbZ);
                this.Yf.addHeaderView(this.jbZ, 0);
                this.jca.setData(cFw());
            }
            if (this.jbC.tabType == 16) {
                this.jcb = new ak(this.jbC);
                this.Yf.addHeaderView(this.jcb.getView(), 0);
                this.jcb.setData(this.jcc);
            }
        }
    }

    private boolean cFv() {
        return this.jbC != null && (this.jbC.isGeneralTab == 1 || this.jbC.tabType == 16);
    }

    public void lx(boolean z) {
        if (this.jbC != null) {
            u uVar = new u();
            uVar.tabId = this.jbC.tabId;
            uVar.fVi = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jbX != null) {
            this.jbX.notifyDataSetChanged();
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(i);
        }
        if (this.jca != null) {
            this.jca.onChangeSkinType();
        }
        if (this.jcb != null) {
            this.jcb.onChangeSkinType();
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
            this.jbY = dVar;
            this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Yf.setNextPage(this.grg);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.grg.setOnClickListener(null);
                    this.grg.showEndLoadData();
                } else {
                    this.grg.showEndLoadData();
                    this.grg.setOnClickListener(this.jcd);
                    this.grg.setText(this.jbC.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.grg.setText(this.jbC.getResources().getString(R.string.list_has_no_more));
                this.grg.setOnClickListener(null);
                this.grg.endLoadData();
            }
            this.jbX.setData(dVar.threadList);
            this.jbX.notifyDataSetChanged();
            if (this.iBV != null) {
                this.iBV.a(this.Yf.getFirstVisiblePosition(), this.Yf.getLastVisiblePosition(), false, true);
            }
            if (cFv() && this.jca != null) {
                this.jca.kj(this.jbC.getSortType());
                this.jca.setFid(this.jbC.forumId);
            }
            this.jcc = dVar.itemInfo;
            if (this.jbC.getFragmentActivity() instanceof an) {
                ((an) this.jbC.getFragmentActivity()).a(this.jcc);
            }
            if (this.jbC.tabType == 16 && this.jcb != null) {
                this.jcb.setData(this.jcc);
            }
        }
    }

    private List<FrsTabInfo> cFw() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.jbC.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.jbC.tabType);
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
        if (this.iBV != null) {
            this.iBV.destroy();
        }
        if (this.jbX != null) {
            this.jbX.onDestory();
        }
    }

    public void resume() {
        if (this.iBV != null) {
            this.iBV.deL();
        }
    }

    public void pause() {
        if (this.iBV != null) {
            this.iBV.deK();
        }
    }

    public void qy(boolean z) {
        if (this.Yf != null) {
            this.Yf.setVisibility(z ? 0 : 8);
        }
    }

    public void cES() {
        u uVar = new u();
        uVar.tabId = this.jbC.tabId;
        uVar.fVi = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void KR(String str) {
        by byVar;
        if (!StringUtils.isNull(str) && this.jbY != null && !y.isEmpty(this.jbY.threadList)) {
            Iterator<q> it = this.jbY.threadList.iterator();
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
                this.jbY.threadList.remove(byVar);
                if (y.isEmpty(this.jbY.threadList)) {
                    this.jbY.threadList.add(new s());
                }
                this.jbX.setData(this.jbY.threadList);
                this.jbX.notifyDataSetChanged();
            }
        }
    }

    public void cBM() {
        this.Yf.scrollToPosition(0);
    }

    public void refreshView() {
        this.jbX.notifyDataSetChanged();
    }

    public void qx(boolean z) {
        if (this.jbX != null) {
            this.jbX.qx(z);
        }
    }

    public BdTypeRecyclerView cFx() {
        return this.Yf;
    }

    public i cDj() {
        return this.iBV;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Yf.setOnScrollListener(onScrollListener);
    }
}
