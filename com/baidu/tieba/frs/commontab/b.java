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
    private BdTypeRecyclerView Yc;
    private PbListView gCf;
    private boolean hasMore;
    private i iOh;
    private FrsCommonTabFragment jnQ;
    private a joo;
    private d jop;
    private RelativeLayout joq;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jor;
    private ah jos;
    private ItemInfo jot;
    private View.OnClickListener jou = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gXN.onScrollToBottom();
        }
    };
    private BdListView.e gXN = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Yc != null) {
                b.this.Yc.stopScroll();
            }
            if (b.this.gCf != null && b.this.jnQ != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Yc.setNextPage(b.this.gCf);
                    b.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.gCf.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.gCf.showLoading();
                        b.this.gCf.setOnClickListener(null);
                        b.this.jnQ.ctu();
                        return;
                    }
                    b.this.gCf.setText(b.this.jnQ.getResources().getString(R.string.list_has_no_more));
                    b.this.gCf.endLoadData();
                    b.this.gCf.setOnClickListener(null);
                    return;
                }
                b.this.Yc.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener ioM = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean flr;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.iOh != null) {
                    b.this.iOh.b(b.this.Yc.getFirstVisiblePosition(), b.this.Yc.getLastVisiblePosition(), this.flr, true);
                }
                s.cva().pv(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.flr = false;
            } else {
                this.flr = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.jnQ = frsCommonTabFragment;
            this.Yc = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Yc.setLayoutManager(new LinearLayoutManager(this.jnQ.getContext()));
            this.Yc.setFadingEdgeLength(0);
            this.Yc.setOverScrollMode(2);
            this.Yc.setOnSrollToBottomListener(this.gXN);
            this.Yc.addOnScrollListener(this.ioM);
            this.Yc.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.iOh != null) {
                        b.this.iOh.dv(view2);
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
            this.Yc.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.frs.commontab.b.5
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                    rect.set(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
                    if ((view2 instanceof BaseLegoCardView) || view2.getVisibility() == 8) {
                        rect.set(0, 0, 0, 0);
                    }
                }
            });
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.Yc.setPadding(dimenPixelSize, this.Yc.getPaddingTop(), dimenPixelSize, this.Yc.getPaddingBottom());
            this.gCf = new PbListView(this.jnQ.getPageContext().getPageActivity());
            this.gCf.getView();
            this.gCf.setContainerBackgroundColorResId(R.color.transparent);
            this.gCf.setHeight(l.getDimens(this.jnQ.getActivity(), R.dimen.tbds182));
            this.gCf.setLineGone();
            this.gCf.setTextSize(R.dimen.tbfontsize33);
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gCf.bxC();
            this.joo = new a(this.jnQ, this.Yc, frsViewData, this.jnQ.tabType == 16);
            lU(false);
            if (this.iOh == null) {
                this.iOh = new i(this.jnQ.getPageContext(), this.Yc);
            }
            this.iOh.ID(1);
            this.iOh.setUniqueId(this.jnQ.getUniqueId());
            if (cIq()) {
                this.joq = new RelativeLayout(this.jnQ.getContext());
                this.joq.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.jor = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jnQ, this.joq);
                this.Yc.addHeaderView(this.joq, 0);
                this.jor.setData(cIr());
            }
            if (this.jnQ.tabType == 16) {
                this.jos = new ah(this.jnQ);
                this.Yc.addHeaderView(this.jos.getView(), 0);
                this.jos.setData(this.jot);
            }
        }
    }

    private boolean cIq() {
        return this.jnQ != null && (this.jnQ.isGeneralTab == 1 || this.jnQ.tabType == 16);
    }

    public void lU(boolean z) {
        if (this.jnQ != null) {
            t tVar = new t();
            tVar.tabId = this.jnQ.tabId;
            tVar.geO = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.joo != null) {
            this.joo.notifyDataSetChanged();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.jor != null) {
            this.jor.onChangeSkinType();
        }
        if (this.jos != null) {
            this.jos.onChangeSkinType();
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
            this.jop = dVar;
            this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Yc.setNextPage(this.gCf);
            if (this.hasMore) {
                if (x.getCount(dVar.threadList) > 3) {
                    this.gCf.setOnClickListener(null);
                    this.gCf.showEndLoadData();
                } else {
                    this.gCf.showEndLoadData();
                    this.gCf.setOnClickListener(this.jou);
                    this.gCf.setText(this.jnQ.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.gCf.setText(this.jnQ.getResources().getString(R.string.list_has_no_more));
                this.gCf.setOnClickListener(null);
                this.gCf.endLoadData();
            }
            this.joo.setData(dVar.threadList);
            this.joo.notifyDataSetChanged();
            if (this.iOh != null) {
                this.iOh.b(this.Yc.getFirstVisiblePosition(), this.Yc.getLastVisiblePosition(), false, true);
            }
            if (cIq() && this.jor != null) {
                this.jor.ki(this.jnQ.getSortType());
                this.jor.setFid(this.jnQ.forumId);
            }
            this.jot = dVar.itemInfo;
            if (this.jnQ.getFragmentActivity() instanceof ak) {
                ((ak) this.jnQ.getFragmentActivity()).a(this.jot);
            }
            if (this.jnQ.tabType == 16 && this.jos != null) {
                this.jos.setData(this.jot);
            }
        }
    }

    private List<FrsTabInfo> cIr() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.jnQ.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.jnQ.tabType);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.Yc != null) {
            this.Yc.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.iOh != null) {
            this.iOh.destroy();
        }
        if (this.joo != null) {
            this.joo.onDestory();
        }
    }

    public void resume() {
        if (this.iOh != null) {
            this.iOh.dew();
        }
    }

    public void pause() {
        if (this.iOh != null) {
            this.iOh.dev();
        }
    }

    public void qW(boolean z) {
        if (this.Yc != null) {
            this.Yc.setVisibility(z ? 0 : 8);
        }
    }

    public void cHN() {
        t tVar = new t();
        tVar.tabId = this.jnQ.tabId;
        tVar.geO = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void KQ(String str) {
        bz bzVar;
        if (!StringUtils.isNull(str) && this.jop != null && !x.isEmpty(this.jop.threadList)) {
            Iterator<n> it = this.jop.threadList.iterator();
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
                this.jop.threadList.remove(bzVar);
                if (x.isEmpty(this.jop.threadList)) {
                    this.jop.threadList.add(new com.baidu.tieba.frs.s());
                }
                this.joo.setData(this.jop.threadList);
                this.joo.notifyDataSetChanged();
            }
        }
    }

    public void cEF() {
        this.Yc.scrollToPosition(0);
    }

    public void refreshView() {
        this.joo.notifyDataSetChanged();
    }

    public void qV(boolean z) {
        if (this.joo != null) {
            this.joo.qV(z);
        }
    }

    public BdTypeRecyclerView cIs() {
        return this.Yc;
    }

    public i cGd() {
        return this.iOh;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Yc.setOnScrollListener(onScrollListener);
    }
}
