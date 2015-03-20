package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.g<OfficialBarHistoryActivity> {
    private BdListView aZi;
    private NavigationBar aZj;
    private ae aZk;
    private View aZl;
    private BaseActivity auA;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private View mRoot;

    public ag(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.auA = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.auA.getPageContext().getContext(), com.baidu.tieba.w.official_bar_history_activity, null);
        this.auA.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.aZj = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aZj.setTitleText(com.baidu.tieba.y.officical_bar_info_history);
        this.aZj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aZi = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.bar_history_list);
        this.aZk = new ae(this.auA, this.auA.getPageContext().getContext());
        this.aZi.setAdapter((ListAdapter) this.aZk);
        this.aZl = View.inflate(this.auA.getPageContext().getContext(), com.baidu.tieba.w.official_bar_history_item_occupy, null);
        this.aZi.addHeaderView(this.aZl);
        this.aZi.addFooterView(this.aZl);
    }

    public void setData(List<au> list) {
        this.aZk.setData(list);
        au(list);
    }

    public void onChangeSkinType(int i) {
        this.auA.getLayoutMode().X(i == 1);
        this.auA.getLayoutMode().h(this.mRoot);
        this.aZj.onChangeSkinType(this.auA.getPageContext(), i);
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        this.aZi.setOnSrollToBottomListener(xVar);
    }

    public boolean Oa() {
        return this.aZk.getCount() != 0 && this.aZi.getLastVisiblePosition() - this.aZi.getHeaderViewsCount() < this.aZk.getCount() + (-1);
    }

    public void au(List<au> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void av(List<au> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.auA.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.auA.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
