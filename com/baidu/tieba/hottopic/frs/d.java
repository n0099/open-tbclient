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
/* loaded from: classes21.dex */
public class d {
    private BdTypeRecyclerView Xe;
    private PbListView gjo;
    private final a jQo;
    private final b jQp;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes21.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.jQo = aVar;
        this.Xe = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.Xe.getContext()));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.gjo = new PbListView(tbPageContext.getPageActivity());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.Xe.setNextPage(this.gjo);
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.endLoadData();
        this.gjo.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.jQp = new b(tbPageContext, this.Xe);
    }

    public void b(TbPageTag tbPageTag) {
        this.jQp.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(skinType);
        }
        if (this.Xe != null && this.Xe.getAdapter() != null) {
            this.Xe.getAdapter().notifyDataSetChanged();
        }
    }

    public void pR(boolean z) {
        if (z) {
            this.Xe.setVisibility(0);
        } else {
            this.Xe.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        v vVar = new v();
        vVar.tabId = 401;
        vVar.fNU = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.Xe.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s());
        this.Xe.setData(arrayList);
    }

    public void cxS() {
        this.Xe.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.Xe == null || y.isEmpty(this.Xe.getData())) ? false : true;
    }
}
