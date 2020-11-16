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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.s;
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
    private BdTypeRecyclerView Xi;
    private PbListView giV;
    private boolean hasMore;
    private FrsCommonTabFragment iQJ;
    private a iRd;
    private d iRe;
    private RelativeLayout iRf;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a iRg;
    private al iRh;
    private ItemInfo iRi;
    private i irb;
    private View.OnClickListener iRj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gDc.onScrollToBottom();
        }
    };
    private BdListView.e gDc = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Xi != null) {
                b.this.Xi.stopScroll();
            }
            if (b.this.giV != null && b.this.iQJ != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Xi.setNextPage(b.this.giV);
                    b.this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.giV.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.giV.showLoading();
                        b.this.giV.setOnClickListener(null);
                        b.this.iQJ.cmn();
                        return;
                    }
                    b.this.giV.setText(b.this.iQJ.getResources().getString(R.string.list_has_no_more));
                    b.this.giV.endLoadData();
                    b.this.giV.setOnClickListener(null);
                    return;
                }
                b.this.Xi.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hRq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean eUl;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.irb != null) {
                    b.this.irb.a(b.this.Xi.getFirstVisiblePosition(), b.this.Xi.getLastVisiblePosition(), this.eUl, true);
                }
                t.cnT().oB(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.eUl = false;
            } else {
                this.eUl = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.iQJ = frsCommonTabFragment;
            this.Xi = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Xi.setLayoutManager(new LinearLayoutManager(this.iQJ.getContext()));
            this.Xi.setFadingEdgeLength(0);
            this.Xi.setOverScrollMode(2);
            this.Xi.setOnSrollToBottomListener(this.gDc);
            this.Xi.addOnScrollListener(this.hRq);
            this.Xi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.irb != null) {
                        b.this.irb.de(view2);
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
            this.Xi.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.frs.commontab.b.5
                @Override // android.support.v7.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                    if (com.baidu.tbadk.a.d.bhw()) {
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
            if (!com.baidu.tbadk.a.d.bhw()) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                this.Xi.setPadding(dimenPixelSize, this.Xi.getTop(), dimenPixelSize, this.Xi.getBottom());
            }
            this.giV = new PbListView(this.iQJ.getPageContext().getPageActivity());
            this.giV.getView();
            this.giV.setContainerBackgroundColorResId(R.color.transparent);
            this.giV.setHeight(l.getDimens(this.iQJ.getActivity(), R.dimen.tbds182));
            this.giV.setLineGone();
            this.giV.setTextSize(R.dimen.tbfontsize33);
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
            this.giV.brI();
            this.iRd = new a(this.iQJ, this.Xi, frsViewData);
            ld(false);
            if (this.irb == null) {
                this.irb = new i(this.iQJ.getPageContext(), this.Xi);
            }
            this.irb.HS(1);
            this.irb.setUniqueId(this.iQJ.getUniqueId());
            if (cBe()) {
                this.iRf = new RelativeLayout(this.iQJ.getContext());
                this.iRf.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.iRg = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.iQJ, this.iRf);
                this.Xi.addHeaderView(this.iRf, 0);
                this.iRg.setData(cBf());
            }
            if (this.iQJ.tabType == 16) {
                this.iRh = new al(this.iQJ);
                this.Xi.addHeaderView(this.iRh.getView(), 0);
                this.iRh.setData(this.iRi);
            }
        }
    }

    private boolean cBe() {
        return this.iQJ != null && (this.iQJ.isGeneralTab == 1 || this.iQJ.tabType == 16);
    }

    public void ld(boolean z) {
        if (this.iQJ != null) {
            v vVar = new v();
            vVar.tabId = this.iQJ.tabId;
            vVar.fNx = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iRd != null) {
            this.iRd.notifyDataSetChanged();
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.changeSkin(i);
        }
        if (this.iRg != null) {
            this.iRg.onChangeSkinType();
        }
        if (this.iRh != null) {
            this.iRh.onChangeSkinType();
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
            this.iRe = dVar;
            this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Xi.setNextPage(this.giV);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.giV.setOnClickListener(null);
                    this.giV.showEndLoadData();
                } else {
                    this.giV.showEndLoadData();
                    this.giV.setOnClickListener(this.iRj);
                    this.giV.setText(this.iQJ.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.giV.setText(this.iQJ.getResources().getString(R.string.list_has_no_more));
                this.giV.setOnClickListener(null);
                this.giV.endLoadData();
            }
            this.iRd.setData(dVar.threadList);
            this.iRd.notifyDataSetChanged();
            if (this.irb != null) {
                this.irb.a(this.Xi.getFirstVisiblePosition(), this.Xi.getLastVisiblePosition(), false, true);
            }
            if (cBe() && this.iRg != null) {
                this.iRg.jL(this.iQJ.getSortType());
                this.iRg.setFid(this.iQJ.forumId);
            }
            this.iRi = dVar.itemInfo;
            if (this.iQJ.getFragmentActivity() instanceof ao) {
                ((ao) this.iQJ.getFragmentActivity()).a(this.iRi);
            }
            if (this.iQJ.tabType == 16 && this.iRh != null) {
                this.iRh.setData(this.iRi);
            }
        }
    }

    private List<FrsTabInfo> cBf() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.iQJ.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.iQJ.tabType);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.Xi != null) {
            this.Xi.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.irb != null) {
            this.irb.destroy();
        }
        if (this.iRd != null) {
            this.iRd.onDestory();
        }
    }

    public void resume() {
        if (this.irb != null) {
            this.irb.cZz();
        }
    }

    public void pause() {
        if (this.irb != null) {
            this.irb.cZy();
        }
    }

    public void qb(boolean z) {
        if (this.Xi != null) {
            this.Xi.setVisibility(z ? 0 : 8);
        }
    }

    public void cAB() {
        v vVar = new v();
        vVar.tabId = this.iQJ.tabId;
        vVar.fNx = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void Ka(String str) {
        bx bxVar;
        if (!StringUtils.isNull(str) && this.iRe != null && !y.isEmpty(this.iRe.threadList)) {
            Iterator<q> it = this.iRe.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bxVar = null;
                    break;
                }
                q next = it.next();
                if (next != null && (next instanceof bx) && TextUtils.equals(str, ((bx) next).getId())) {
                    bxVar = (bx) next;
                    break;
                }
            }
            if (bxVar != null) {
                this.iRe.threadList.remove(bxVar);
                if (y.isEmpty(this.iRe.threadList)) {
                    this.iRe.threadList.add(new s());
                }
                this.iRd.setData(this.iRe.threadList);
                this.iRd.notifyDataSetChanged();
            }
        }
    }

    public void cxv() {
        this.Xi.scrollToPosition(0);
    }

    public void refreshView() {
        this.iRd.notifyDataSetChanged();
    }

    public void qa(boolean z) {
        if (this.iRd != null) {
            this.iRd.qa(z);
        }
    }

    public BdTypeRecyclerView cBg() {
        return this.Xi;
    }

    public i cyR() {
        return this.irb;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Xi.setOnScrollListener(onScrollListener);
    }
}
