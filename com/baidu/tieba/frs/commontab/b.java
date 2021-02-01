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
    private BdTypeRecyclerView XW;
    private PbListView gAi;
    private boolean hasMore;
    private i iPi;
    private FrsCommonTabFragment joQ;
    private a jpo;
    private d jpp;
    private RelativeLayout jpq;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jpr;
    private ah jps;
    private ItemInfo jpt;
    private View.OnClickListener jpu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gVR.onScrollToBottom();
        }
    };
    private BdListView.e gVR = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.XW != null) {
                b.this.XW.stopScroll();
            }
            if (b.this.gAi != null && b.this.joQ != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.XW.setNextPage(b.this.gAi);
                    b.this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.gAi.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.gAi.showLoading();
                        b.this.gAi.setOnClickListener(null);
                        b.this.joQ.cqN();
                        return;
                    }
                    b.this.gAi.setText(b.this.joQ.getResources().getString(R.string.list_has_no_more));
                    b.this.gAi.endLoadData();
                    b.this.gAi.setOnClickListener(null);
                    return;
                }
                b.this.XW.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener ipL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean fiZ;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.iPi != null) {
                    b.this.iPi.b(b.this.XW.getFirstVisiblePosition(), b.this.XW.getLastVisiblePosition(), this.fiZ, true);
                }
                t.csu().pB(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fiZ = false;
            } else {
                this.fiZ = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.joQ = frsCommonTabFragment;
            this.XW = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.XW.setLayoutManager(new LinearLayoutManager(this.joQ.getContext()));
            this.XW.setFadingEdgeLength(0);
            this.XW.setOverScrollMode(2);
            this.XW.setOnSrollToBottomListener(this.gVR);
            this.XW.addOnScrollListener(this.ipL);
            this.XW.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.iPi != null) {
                        b.this.iPi.dt(view2);
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
            this.XW.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.baidu.tieba.frs.commontab.b.5
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                    rect.set(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
                    if ((view2 instanceof BaseLegoCardView) || view2.getVisibility() == 8) {
                        rect.set(0, 0, 0, 0);
                    }
                }
            });
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.XW.setPadding(dimenPixelSize, this.XW.getPaddingTop(), dimenPixelSize, this.XW.getPaddingBottom());
            this.gAi = new PbListView(this.joQ.getPageContext().getPageActivity());
            this.gAi.getView();
            this.gAi.setContainerBackgroundColorResId(R.color.transparent);
            this.gAi.setHeight(l.getDimens(this.joQ.getActivity(), R.dimen.tbds182));
            this.gAi.setLineGone();
            this.gAi.setTextSize(R.dimen.tbfontsize33);
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gAi.bud();
            this.jpo = new a(this.joQ, this.XW, frsViewData, this.joQ.tabType == 16);
            lU(false);
            if (this.iPi == null) {
                this.iPi = new i(this.joQ.getPageContext(), this.XW);
            }
            this.iPi.Ho(1);
            this.iPi.setUniqueId(this.joQ.getUniqueId());
            if (cFM()) {
                this.jpq = new RelativeLayout(this.joQ.getContext());
                this.jpq.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.jpr = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.joQ, this.jpq);
                this.XW.addHeaderView(this.jpq, 0);
                this.jpr.setData(cFN());
            }
            if (this.joQ.tabType == 16) {
                this.jps = new ah(this.joQ);
                this.XW.addHeaderView(this.jps.getView(), 0);
                this.jps.setData(this.jpt);
            }
        }
    }

    private boolean cFM() {
        return this.joQ != null && (this.joQ.isGeneralTab == 1 || this.joQ.tabType == 16);
    }

    public void lU(boolean z) {
        if (this.joQ != null) {
            com.baidu.tieba.frs.t tVar = new com.baidu.tieba.frs.t();
            tVar.tabId = this.joQ.tabId;
            tVar.gcx = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jpo != null) {
            this.jpo.notifyDataSetChanged();
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.changeSkin(i);
        }
        if (this.jpr != null) {
            this.jpr.onChangeSkinType();
        }
        if (this.jps != null) {
            this.jps.onChangeSkinType();
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
            this.jpp = dVar;
            this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.XW.setNextPage(this.gAi);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.gAi.setOnClickListener(null);
                    this.gAi.showEndLoadData();
                } else {
                    this.gAi.showEndLoadData();
                    this.gAi.setOnClickListener(this.jpu);
                    this.gAi.setText(this.joQ.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.gAi.setText(this.joQ.getResources().getString(R.string.list_has_no_more));
                this.gAi.setOnClickListener(null);
                this.gAi.endLoadData();
            }
            this.jpo.setData(dVar.threadList);
            this.jpo.notifyDataSetChanged();
            if (this.iPi != null) {
                this.iPi.b(this.XW.getFirstVisiblePosition(), this.XW.getLastVisiblePosition(), false, true);
            }
            if (cFM() && this.jpr != null) {
                this.jpr.iF(this.joQ.getSortType());
                this.jpr.setFid(this.joQ.forumId);
            }
            this.jpt = dVar.itemInfo;
            if (this.joQ.getFragmentActivity() instanceof ak) {
                ((ak) this.joQ.getFragmentActivity()).a(this.jpt);
            }
            if (this.joQ.tabType == 16 && this.jps != null) {
                this.jps.setData(this.jpt);
            }
        }
    }

    private List<FrsTabInfo> cFN() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.joQ.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.joQ.tabType);
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.XW != null) {
            this.XW.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.iPi != null) {
            this.iPi.destroy();
        }
        if (this.jpo != null) {
            this.jpo.onDestory();
        }
    }

    public void resume() {
        if (this.iPi != null) {
            this.iPi.dcD();
        }
    }

    public void pause() {
        if (this.iPi != null) {
            this.iPi.dcC();
        }
    }

    public void rc(boolean z) {
        if (this.XW != null) {
            this.XW.setVisibility(z ? 0 : 8);
        }
    }

    public void cFi() {
        com.baidu.tieba.frs.t tVar = new com.baidu.tieba.frs.t();
        tVar.tabId = this.joQ.tabId;
        tVar.gcx = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void Kq(String str) {
        cb cbVar;
        if (!StringUtils.isNull(str) && this.jpp != null && !y.isEmpty(this.jpp.threadList)) {
            Iterator<n> it = this.jpp.threadList.iterator();
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
                this.jpp.threadList.remove(cbVar);
                if (y.isEmpty(this.jpp.threadList)) {
                    this.jpp.threadList.add(new s());
                }
                this.jpo.setData(this.jpp.threadList);
                this.jpo.notifyDataSetChanged();
            }
        }
    }

    public void cBZ() {
        this.XW.scrollToPosition(0);
    }

    public void refreshView() {
        this.jpo.notifyDataSetChanged();
    }

    public void rb(boolean z) {
        if (this.jpo != null) {
            this.jpo.rb(z);
        }
    }

    public BdTypeRecyclerView cFO() {
        return this.XW;
    }

    public i cDy() {
        return this.iPi;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.XW.setOnScrollListener(onScrollListener);
    }
}
