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
    private BdTypeRecyclerView Xc;
    private PbListView fTv;
    private final a jxR;
    private final b jxS;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes21.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.jxR = aVar;
        this.Xc = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.Xc.setLayoutManager(new LinearLayoutManager(this.Xc.getContext()));
        this.Xc.setFadingEdgeLength(0);
        this.Xc.setOverScrollMode(2);
        this.fTv = new PbListView(tbPageContext.getPageActivity());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.Xc.setNextPage(this.fTv);
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.endLoadData();
        this.fTv.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.jxS = new b(tbPageContext, this.Xc);
    }

    public void b(TbPageTag tbPageTag) {
        this.jxS.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.changeSkin(skinType);
        }
        if (this.Xc != null && this.Xc.getAdapter() != null) {
            this.Xc.getAdapter().notifyDataSetChanged();
        }
    }

    public void pq(boolean z) {
        if (z) {
            this.Xc.setVisibility(0);
        } else {
            this.Xc.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        v vVar = new v();
        vVar.tabId = 401;
        vVar.fzJ = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.Xc.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s());
        this.Xc.setData(arrayList);
    }

    public void csk() {
        this.Xc.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.Xc == null || y.isEmpty(this.Xc.getData())) ? false : true;
    }
}
