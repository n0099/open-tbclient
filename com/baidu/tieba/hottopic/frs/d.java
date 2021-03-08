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
/* loaded from: classes7.dex */
public class d {
    private BdTypeRecyclerView Zq;
    private PbListView gCf;
    private final a kxI;
    private final b kxJ;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes7.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.kxI = aVar;
        this.Zq = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.Zq.setLayoutManager(new LinearLayoutManager(this.Zq.getContext()));
        this.Zq.setFadingEdgeLength(0);
        this.Zq.setOverScrollMode(2);
        this.gCf = new PbListView(tbPageContext.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.Zq.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.endLoadData();
        this.gCf.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.kxJ = new b(tbPageContext, this.Zq);
    }

    public void b(TbPageTag tbPageTag) {
        this.kxJ.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(skinType);
        }
        if (this.Zq != null && this.Zq.getAdapter() != null) {
            this.Zq.getAdapter().notifyDataSetChanged();
        }
    }

    public void qV(boolean z) {
        if (z) {
            this.Zq.setVisibility(0);
        } else {
            this.Zq.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        t tVar = new t();
        tVar.tabId = 401;
        tVar.gec = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<n> list) {
        if (!y.isEmpty(list)) {
            this.Zq.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s());
        this.Zq.setData(arrayList);
    }

    public void cCm() {
        this.Zq.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.Zq == null || y.isEmpty(this.Zq.getData())) ? false : true;
    }
}
