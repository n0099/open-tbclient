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
/* loaded from: classes15.dex */
public class d {
    private BdTypeRecyclerView Wu;
    private PbListView fDW;
    private final a jah;
    private final b jai;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes15.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.jah = aVar;
        this.Wu = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.Wu.getContext()));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.fDW = new PbListView(tbPageContext.getPageActivity());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.Wu.setNextPage(this.fDW);
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.endLoadData();
        this.fDW.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.jai = new b(tbPageContext, this.Wu);
    }

    public void b(TbPageTag tbPageTag) {
        this.jai.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(skinType);
        }
        if (this.Wu != null && this.Wu.getAdapter() != null) {
            this.Wu.getAdapter().notifyDataSetChanged();
        }
    }

    public void oD(boolean z) {
        if (z) {
            this.Wu.setVisibility(0);
        } else {
            this.Wu.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        v vVar = new v();
        vVar.tabId = 401;
        vVar.fky = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.Wu.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s());
        this.Wu.setData(arrayList);
    }

    public void clz() {
        this.Wu.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.Wu == null || y.isEmpty(this.Wu.getData())) ? false : true;
    }
}
