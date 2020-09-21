package com.baidu.tieba.hottopic.frs;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class d {
    private BdTypeRecyclerView WM;
    private PbListView fHm;
    private final a jiT;
    private final b jiU;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes20.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.jiT = aVar;
        this.WM = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.WM.setLayoutManager(new LinearLayoutManager(this.WM.getContext()));
        this.WM.setFadingEdgeLength(0);
        this.WM.setOverScrollMode(2);
        this.fHm = new PbListView(tbPageContext.getPageActivity());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.WM.setNextPage(this.fHm);
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.endLoadData();
        this.fHm.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.jiU = new b(tbPageContext, this.WM);
    }

    public void b(TbPageTag tbPageTag) {
        this.jiU.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(skinType);
        }
        if (this.WM != null && this.WM.getAdapter() != null) {
            this.WM.getAdapter().notifyDataSetChanged();
        }
    }

    public void oL(boolean z) {
        if (z) {
            this.WM.setVisibility(0);
        } else {
            this.WM.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        v vVar = new v();
        vVar.tabId = 401;
        vVar.fnv = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.WM.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s());
        this.WM.setData(arrayList);
    }

    public void coM() {
        this.WM.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.WM == null || y.isEmpty(this.WM.getData())) ? false : true;
    }
}
