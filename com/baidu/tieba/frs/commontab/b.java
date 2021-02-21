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
    private PbListView gAw;
    private boolean hasMore;
    private i iPw;
    private a jpC;
    private d jpD;
    private RelativeLayout jpE;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a jpF;
    private ah jpG;
    private ItemInfo jpH;
    private FrsCommonTabFragment jpe;
    private View.OnClickListener jpI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.gWf.onScrollToBottom();
        }
    };
    private BdListView.e gWf = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.XW != null) {
                b.this.XW.stopScroll();
            }
            if (b.this.gAw != null && b.this.jpe != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.XW.setNextPage(b.this.gAw);
                    b.this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.gAw.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.gAw.showLoading();
                        b.this.gAw.setOnClickListener(null);
                        b.this.jpe.cqU();
                        return;
                    }
                    b.this.gAw.setText(b.this.jpe.getResources().getString(R.string.list_has_no_more));
                    b.this.gAw.endLoadData();
                    b.this.gAw.setOnClickListener(null);
                    return;
                }
                b.this.XW.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener ipZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.3
        private boolean fiZ;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.iPw != null) {
                    b.this.iPw.b(b.this.XW.getFirstVisiblePosition(), b.this.XW.getLastVisiblePosition(), this.fiZ, true);
                }
                t.csB().pB(true);
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
            this.jpe = frsCommonTabFragment;
            this.XW = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.XW.setLayoutManager(new LinearLayoutManager(this.jpe.getContext()));
            this.XW.setFadingEdgeLength(0);
            this.XW.setOverScrollMode(2);
            this.XW.setOnSrollToBottomListener(this.gWf);
            this.XW.addOnScrollListener(this.ipZ);
            this.XW.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.4
                @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.iPw != null) {
                        b.this.iPw.dt(view2);
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
            this.gAw = new PbListView(this.jpe.getPageContext().getPageActivity());
            this.gAw.getView();
            this.gAw.setContainerBackgroundColorResId(R.color.transparent);
            this.gAw.setHeight(l.getDimens(this.jpe.getActivity(), R.dimen.tbds182));
            this.gAw.setLineGone();
            this.gAw.setTextSize(R.dimen.tbfontsize33);
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gAw.bud();
            this.jpC = new a(this.jpe, this.XW, frsViewData, this.jpe.tabType == 16);
            lU(false);
            if (this.iPw == null) {
                this.iPw = new i(this.jpe.getPageContext(), this.XW);
            }
            this.iPw.Ho(1);
            this.iPw.setUniqueId(this.jpe.getUniqueId());
            if (cFT()) {
                this.jpE = new RelativeLayout(this.jpe.getContext());
                this.jpE.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.jpF = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.jpe, this.jpE);
                this.XW.addHeaderView(this.jpE, 0);
                this.jpF.setData(cFU());
            }
            if (this.jpe.tabType == 16) {
                this.jpG = new ah(this.jpe);
                this.XW.addHeaderView(this.jpG.getView(), 0);
                this.jpG.setData(this.jpH);
            }
        }
    }

    private boolean cFT() {
        return this.jpe != null && (this.jpe.isGeneralTab == 1 || this.jpe.tabType == 16);
    }

    public void lU(boolean z) {
        if (this.jpe != null) {
            com.baidu.tieba.frs.t tVar = new com.baidu.tieba.frs.t();
            tVar.tabId = this.jpe.tabId;
            tVar.gcC = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jpC != null) {
            this.jpC.notifyDataSetChanged();
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.changeSkin(i);
        }
        if (this.jpF != null) {
            this.jpF.onChangeSkinType();
        }
        if (this.jpG != null) {
            this.jpG.onChangeSkinType();
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
            this.jpD = dVar;
            this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.XW.setNextPage(this.gAw);
            if (this.hasMore) {
                if (y.getCount(dVar.threadList) > 3) {
                    this.gAw.setOnClickListener(null);
                    this.gAw.showEndLoadData();
                } else {
                    this.gAw.showEndLoadData();
                    this.gAw.setOnClickListener(this.jpI);
                    this.gAw.setText(this.jpe.getResources().getString(R.string.list_click_load_more));
                }
            } else {
                this.gAw.setText(this.jpe.getResources().getString(R.string.list_has_no_more));
                this.gAw.setOnClickListener(null);
                this.gAw.endLoadData();
            }
            this.jpC.setData(dVar.threadList);
            this.jpC.notifyDataSetChanged();
            if (this.iPw != null) {
                this.iPw.b(this.XW.getFirstVisiblePosition(), this.XW.getLastVisiblePosition(), false, true);
            }
            if (cFT() && this.jpF != null) {
                this.jpF.iF(this.jpe.getSortType());
                this.jpF.setFid(this.jpe.forumId);
            }
            this.jpH = dVar.itemInfo;
            if (this.jpe.getFragmentActivity() instanceof ak) {
                ((ak) this.jpe.getFragmentActivity()).a(this.jpH);
            }
            if (this.jpe.tabType == 16 && this.jpG != null) {
                this.jpG.setData(this.jpH);
            }
        }
    }

    private List<FrsTabInfo> cFU() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        builder.tab_type = Integer.valueOf(this.jpe.tabType);
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        builder2.tab_type = Integer.valueOf(this.jpe.tabType);
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
        if (this.iPw != null) {
            this.iPw.destroy();
        }
        if (this.jpC != null) {
            this.jpC.onDestory();
        }
    }

    public void resume() {
        if (this.iPw != null) {
            this.iPw.dcK();
        }
    }

    public void pause() {
        if (this.iPw != null) {
            this.iPw.dcJ();
        }
    }

    public void rc(boolean z) {
        if (this.XW != null) {
            this.XW.setVisibility(z ? 0 : 8);
        }
    }

    public void cFp() {
        com.baidu.tieba.frs.t tVar = new com.baidu.tieba.frs.t();
        tVar.tabId = this.jpe.tabId;
        tVar.gcC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void Kr(String str) {
        cb cbVar;
        if (!StringUtils.isNull(str) && this.jpD != null && !y.isEmpty(this.jpD.threadList)) {
            Iterator<n> it = this.jpD.threadList.iterator();
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
                this.jpD.threadList.remove(cbVar);
                if (y.isEmpty(this.jpD.threadList)) {
                    this.jpD.threadList.add(new s());
                }
                this.jpC.setData(this.jpD.threadList);
                this.jpC.notifyDataSetChanged();
            }
        }
    }

    public void cCg() {
        this.XW.scrollToPosition(0);
    }

    public void refreshView() {
        this.jpC.notifyDataSetChanged();
    }

    public void rb(boolean z) {
        if (this.jpC != null) {
            this.jpC.rb(z);
        }
    }

    public BdTypeRecyclerView cFV() {
        return this.XW;
    }

    public i cDF() {
        return this.iPw;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.XW.setOnScrollListener(onScrollListener);
    }
}
