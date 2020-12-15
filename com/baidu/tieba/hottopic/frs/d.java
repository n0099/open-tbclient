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
import com.baidu.tieba.frs.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class d {
    private BdTypeRecyclerView Yf;
    private PbListView grg;
    private final a keE;
    private final b keF;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes21.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.keE = aVar;
        this.Yf = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.Yf.getContext()));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        this.grg = new PbListView(tbPageContext.getPageActivity());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.Yf.setNextPage(this.grg);
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.endLoadData();
        this.grg.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.keF = new b(tbPageContext, this.Yf);
    }

    public void b(TbPageTag tbPageTag) {
        this.keF.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(skinType);
        }
        if (this.Yf != null && this.Yf.getAdapter() != null) {
            this.Yf.getAdapter().notifyDataSetChanged();
        }
    }

    public void qr(boolean z) {
        if (z) {
            this.Yf.setVisibility(0);
        } else {
            this.Yf.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        u uVar = new u();
        uVar.tabId = 401;
        uVar.fVi = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.Yf.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s());
        this.Yf.setData(arrayList);
    }

    public void cBM() {
        this.Yf.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.Yf == null || y.isEmpty(this.Yf.getData())) ? false : true;
    }
}
