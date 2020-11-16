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
    private BdTypeRecyclerView Xi;
    private PbListView giV;
    private final a jQY;
    private final b jQZ;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes20.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.jQY = aVar;
        this.Xi = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.Xi.setLayoutManager(new LinearLayoutManager(this.Xi.getContext()));
        this.Xi.setFadingEdgeLength(0);
        this.Xi.setOverScrollMode(2);
        this.giV = new PbListView(tbPageContext.getPageActivity());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.Xi.setNextPage(this.giV);
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.endLoadData();
        this.giV.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.jQZ = new b(tbPageContext, this.Xi);
    }

    public void b(TbPageTag tbPageTag) {
        this.jQZ.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.changeSkin(skinType);
        }
        if (this.Xi != null && this.Xi.getAdapter() != null) {
            this.Xi.getAdapter().notifyDataSetChanged();
        }
    }

    public void pU(boolean z) {
        if (z) {
            this.Xi.setVisibility(0);
        } else {
            this.Xi.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        v vVar = new v();
        vVar.tabId = 401;
        vVar.fNx = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.Xi.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s());
        this.Xi.setData(arrayList);
    }

    public void cxv() {
        this.Xi.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.Xi == null || y.isEmpty(this.Xi.getData())) ? false : true;
    }
}
