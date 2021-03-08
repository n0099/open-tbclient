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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.s;
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
    private BdTypeRecyclerView Zq;
    private PbListView gCf;
    private boolean hasMore;
    private i iRf;
    private FrsCommonTabFragment jqN;
    private a jrl;
    private d jrm;
    private RelativeLayout jrn;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jro;
    private ah jrp;
    private ItemInfo jrq;
    private View.OnClickListener jrr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gXO.onScrollToBottom();
        }
    };
    private BdListView.e gXO = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Zq != null) {
                b.this.Zq.stopScroll();
            }
            if (b.this.gCf != null && b.this.jqN != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Zq.setNextPage(b.this.gCf);
                    b.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.gCf.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.gCf.showLoading();
                        b.this.gCf.setOnClickListener(null);
                        b.this.jqN.cra();
                        return;
                    }
                    b.this.gCf.setText(b.this.jqN.getResources().getString(R.string.list_has_no_more));
                    b.this.gCf.endLoadData();
                    b.this.gCf.setOnClickListener(null);
                    return;
                }
                b.this.Zq.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener irI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean fky;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.iRf != null) {
                    b.this.iRf.b(b.this.Zq.getFirstVisiblePosition(), b.this.Zq.getLastVisiblePosition(), this.fky, true);
                }
                t.csH().pB(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fky = false;
            } else {
                this.fky = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.jqN = frsCommonTabFragment;
            this.Zq = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Zq.setLayoutManager(new LinearLayoutManager(this.jqN.getContext()));
            this.Zq.setFadingEdgeLength(0);
            this.Zq.setOverScrollMode(2);
            this.Zq.setOnSrollToBottomListener(this.gXO);
            this.Zq.addOnScrollListener(this.irI);
            this.Zq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.iRf != null) {
                        b.this.iRf.dt(view2);
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
            this.Zq.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.frs.commontab.b.5
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                    rect.set(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
                    if ((view2 instanceof BaseLegoCardView) || view2.getVisibility() == 8) {
                        rect.set(0, 0, 0, 0);
                    }
                }
            });
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.Zq.setPadding(dimenPixelSize, this.Zq.getPaddingTop(), dimenPixelSize, this.Zq.getPaddingBottom());
            this.gCf = new PbListView(this.jqN.getPageContext().getPageActivity());
            this.gCf.getView();
            this.gCf.setContainerBackgroundColorResId(R.color.transparent);
            this.gCf.setHeight(l.getDimens(this.jqN.getActivity(), R.dimen.tbds182));
            this.gCf.setLineGone();
            this.gCf.setTextSize(R.dimen.tbfontsize33);
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gCf.bug();
            this.jrl = new a(this.jqN, this.Zq, frsViewData, this.jqN.tabType == 16);
            lU(false);
            if (this.iRf == null) {
                this.iRf = new i(this.jqN.getPageContext(), this.Zq);
            }
            this.iRf.Hr(1);
            this.iRf.setUniqueId(this.jqN.getUniqueId());
            if (cFZ()) {
                this.jrn = new RelativeLayout(this.jqN.getContext());
                this.jrn.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.jro = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jqN, this.jrn);
                this.Zq.addHeaderView(this.jrn, 0);
                this.jro.setData(cGa());
            }
            if (this.jqN.tabType == 16) {
                this.jrp = new ah(this.jqN);
                this.Zq.addHeaderView(this.jrp.getView(), 0);
                this.jrp.setData(this.jrq);
            }
        }
    }

    private boolean cFZ() {
        return this.jqN != null && (this.jqN.isGeneralTab == 1 || this.jqN.tabType == 16);
    }

    public void lU(boolean z) {
        if (this.jqN != null) {
            com.baidu.tieba.frs.t tVar = new com.baidu.tieba.frs.t();
            tVar.tabId = this.jqN.tabId;
            tVar.gec = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jrl != null) {
            this.jrl.notifyDataSetChanged();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.jro != null) {
            this.jro.onChangeSkinType();
        }
        if (this.jrp != null) {
            this.jrp.onChangeSkinType();
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
            this.jrm = dVar;
            this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Zq.setNextPage(this.gCf);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.gCf.setOnClickListener(null);
                    this.gCf.showEndLoadData();
                } else {
                    this.gCf.showEndLoadData();
                    this.gCf.setOnClickListener(this.jrr);
                    this.gCf.setText(this.jqN.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.gCf.setText(this.jqN.getResources().getString(R.string.list_has_no_more));
                this.gCf.setOnClickListener(null);
                this.gCf.endLoadData();
            }
            this.jrl.setData(dVar.threadList);
            this.jrl.notifyDataSetChanged();
            if (this.iRf != null) {
                this.iRf.b(this.Zq.getFirstVisiblePosition(), this.Zq.getLastVisiblePosition(), false, true);
            }
            if (cFZ() && this.jro != null) {
                this.jro.iG(this.jqN.getSortType());
                this.jro.setFid(this.jqN.forumId);
            }
            this.jrq = dVar.itemInfo;
            if (this.jqN.getFragmentActivity() instanceof ak) {
                ((ak) this.jqN.getFragmentActivity()).a(this.jrq);
            }
            if (this.jqN.tabType == 16 && this.jrp != null) {
                this.jrp.setData(this.jrq);
            }
        }
    }

    private List<FrsTabInfo> cGa() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.jqN.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.jqN.tabType);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.Zq != null) {
            this.Zq.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.iRf != null) {
            this.iRf.destroy();
        }
        if (this.jrl != null) {
            this.jrl.onDestory();
        }
    }

    public void resume() {
        if (this.iRf != null) {
            this.iRf.dcT();
        }
    }

    public void pause() {
        if (this.iRf != null) {
            this.iRf.dcS();
        }
    }

    public void rc(boolean z) {
        if (this.Zq != null) {
            this.Zq.setVisibility(z ? 0 : 8);
        }
    }

    public void cFv() {
        com.baidu.tieba.frs.t tVar = new com.baidu.tieba.frs.t();
        tVar.tabId = this.jqN.tabId;
        tVar.gec = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void KA(String str) {
        cb cbVar;
        if (!StringUtils.isNull(str) && this.jrm != null && !y.isEmpty(this.jrm.threadList)) {
            Iterator<n> it = this.jrm.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cbVar = null;
                    break;
                }
                n next = it.next();
                if (next != null && (next instanceof cb) && TextUtils.equals(str, ((cb) next).getId())) {
                    cbVar = (cb) next;
                    break;
                }
            }
            if (cbVar != null) {
                this.jrm.threadList.remove(cbVar);
                if (y.isEmpty(this.jrm.threadList)) {
                    this.jrm.threadList.add(new s());
                }
                this.jrl.setData(this.jrm.threadList);
                this.jrl.notifyDataSetChanged();
            }
        }
    }

    public void cCm() {
        this.Zq.scrollToPosition(0);
    }

    public void refreshView() {
        this.jrl.notifyDataSetChanged();
    }

    public void rb(boolean z) {
        if (this.jrl != null) {
            this.jrl.rb(z);
        }
    }

    public BdTypeRecyclerView cGb() {
        return this.Zq;
    }

    public i cDL() {
        return this.iRf;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Zq.setOnScrollListener(onScrollListener);
    }
}
