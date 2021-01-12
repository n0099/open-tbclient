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
/* loaded from: classes7.dex */
public class d {
    private BdTypeRecyclerView Ya;
    private PbListView gxy;
    private final a knl;
    private final b knm;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes7.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.knl = aVar;
        this.Ya = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.Ya.setLayoutManager(new LinearLayoutManager(this.Ya.getContext()));
        this.Ya.setFadingEdgeLength(0);
        this.Ya.setOverScrollMode(2);
        this.gxy = new PbListView(tbPageContext.getPageActivity());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.Ya.setNextPage(this.gxy);
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.endLoadData();
        this.gxy.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.knm = new b(tbPageContext, this.Ya);
    }

    public void b(TbPageTag tbPageTag) {
        this.knm.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(skinType);
        }
        if (this.Ya != null && this.Ya.getAdapter() != null) {
            this.Ya.getAdapter().notifyDataSetChanged();
        }
    }

    public void qL(boolean z) {
        if (z) {
            this.Ya.setVisibility(0);
        } else {
            this.Ya.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        t tVar = new t();
        tVar.tabId = 401;
        tVar.gae = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<n> list) {
        if (!x.isEmpty(list)) {
            this.Ya.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s());
        this.Ya.setData(arrayList);
    }

    public void cAO() {
        this.Ya.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.Ya == null || x.isEmpty(this.Ya.getData())) ? false : true;
    }
}
