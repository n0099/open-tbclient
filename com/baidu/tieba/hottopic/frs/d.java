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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class d {
    private BdTypeRecyclerView VT;
    private PbListView fsC;
    private final a iLh;
    private final b iLi;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes15.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.iLh = aVar;
        this.VT = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.VT.setLayoutManager(new LinearLayoutManager(this.VT.getContext()));
        this.VT.setFadingEdgeLength(0);
        this.VT.setOverScrollMode(2);
        this.fsC = new PbListView(tbPageContext.getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.VT.setNextPage(this.fsC);
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.endLoadData();
        this.fsC.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.iLi = new b(tbPageContext, this.VT);
    }

    public void b(TbPageTag tbPageTag) {
        this.iLi.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(skinType);
        }
        if (this.VT != null && this.VT.getAdapter() != null) {
            this.VT.getAdapter().notifyDataSetChanged();
        }
    }

    public void nZ(boolean z) {
        if (z) {
            this.VT.setVisibility(0);
        } else {
            this.VT.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        u uVar = new u();
        uVar.tabId = 401;
        uVar.eZg = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<q> list) {
        if (!x.isEmpty(list)) {
            this.VT.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new r());
        this.VT.setData(arrayList);
    }

    public void cbd() {
        this.VT.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.VT == null || x.isEmpty(this.VT.getData())) ? false : true;
    }
}
