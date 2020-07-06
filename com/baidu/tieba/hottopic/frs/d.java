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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private BdTypeRecyclerView Wa;
    private PbListView fnt;
    private final a iFd;
    private final b iFe;
    private final TbPageContext mPageContext;
    private View mRootView;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.iFd = aVar;
        this.Wa = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.Wa.setLayoutManager(new LinearLayoutManager(this.Wa.getContext()));
        this.Wa.setFadingEdgeLength(0);
        this.Wa.setOverScrollMode(2);
        this.fnt = new PbListView(tbPageContext.getPageActivity());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.Wa.setNextPage(this.fnt);
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.endLoadData();
        this.fnt.setText(tbPageContext.getResources().getString(R.string.list_no_more));
        onChangeSkinType();
        this.iFe = new b(tbPageContext, this.Wa);
    }

    public void b(TbPageTag tbPageTag) {
        this.iFe.b(tbPageTag);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.changeSkin(skinType);
        }
        if (this.Wa != null && this.Wa.getAdapter() != null) {
            this.Wa.getAdapter().notifyDataSetChanged();
        }
    }

    public void nu(boolean z) {
        if (z) {
            this.Wa.setVisibility(0);
        } else {
            this.Wa.setVisibility(8);
        }
    }

    public void setRefreshing(boolean z) {
        u uVar = new u();
        uVar.tabId = 401;
        uVar.eSL = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setData(List<q> list) {
        if (!w.isEmpty(list)) {
            this.Wa.setData(list);
        }
    }

    public void showNoDataView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new r());
        this.Wa.setData(arrayList);
    }

    public void bXH() {
        this.Wa.scrollToPosition(0);
    }

    public boolean hasData() {
        return (this.Wa == null || w.isEmpty(this.Wa.getData())) ? false : true;
    }
}
