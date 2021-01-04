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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private BdTypeRecyclerView Yc;
    private PbListView gCf;
    private final a krQ;
    private final b krR;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.krQ = aVar;
        this.Yc = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.Yc.setLayoutManager(new LinearLayoutManager(this.Yc.getContext()));
        this.Yc.setFadingEdgeLength(0);
        this.Yc.setOverScrollMode(2);
        this.gCf = new PbListView(tbPageContext.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.Yc.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.endLoadData();
        this.gCf.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.krR = new b(tbPageContext, this.Yc);
    }

    public void b(TbPageTag tbPageTag) {
        this.krR.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(skinType);
        }
        if (this.Yc != null && this.Yc.getAdapter() != null) {
            this.Yc.getAdapter().notifyDataSetChanged();
        }
    }

    public void qP(boolean z) {
        if (z) {
            this.Yc.setVisibility(0);
        } else {
            this.Yc.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        t tVar = new t();
        tVar.tabId = 401;
        tVar.geO = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<n> list) {
        if (!x.isEmpty(list)) {
            this.Yc.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s());
        this.Yc.setData(arrayList);
    }

    public void cEF() {
        this.Yc.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.Yc == null || x.isEmpty(this.Yc.getData())) ? false : true;
    }
}
