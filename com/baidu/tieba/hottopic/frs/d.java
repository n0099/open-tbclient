package com.baidu.tieba.hottopic.frs;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private BdTypeRecyclerView XW;
    private PbListView gAi;
    private final a kvs;
    private final b kvt;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.kvs = aVar;
        this.XW = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.XW.setLayoutManager(new LinearLayoutManager(this.XW.getContext()));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        this.gAi = new PbListView(tbPageContext.getPageActivity());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.XW.setNextPage(this.gAi);
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.endLoadData();
        this.gAi.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.kvt = new b(tbPageContext, this.XW);
    }

    public void b(TbPageTag tbPageTag) {
        this.kvt.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.changeSkin(skinType);
        }
        if (this.XW != null && this.XW.getAdapter() != null) {
            this.XW.getAdapter().notifyDataSetChanged();
        }
    }

    public void qV(boolean z) {
        if (z) {
            this.XW.setVisibility(0);
        } else {
            this.XW.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        t tVar = new t();
        tVar.tabId = 401;
        tVar.gcx = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<n> list) {
        if (!y.isEmpty(list)) {
            this.XW.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s());
        this.XW.setData(arrayList);
    }

    public void cBZ() {
        this.XW.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.XW == null || y.isEmpty(this.XW.getData())) ? false : true;
    }
}
