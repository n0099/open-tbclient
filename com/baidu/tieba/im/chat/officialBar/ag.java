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
    private ae aZA;
    private View aZB;
    private BdListView aZy;
    private NavigationBar aZz;
    private BaseActivity auI;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private View mRoot;

    public ag(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.auI = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.auI.getPageContext().getContext(), com.baidu.tieba.w.official_bar_history_activity, null);
        this.auI.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.aZz = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aZz.setTitleText(com.baidu.tieba.y.officical_bar_info_history);
        this.aZz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aZy = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.bar_history_list);
        this.aZA = new ae(this.auI, this.auI.getPageContext().getContext());
        this.aZy.setAdapter((ListAdapter) this.aZA);
        this.aZB = View.inflate(this.auI.getPageContext().getContext(), com.baidu.tieba.w.official_bar_history_item_occupy, null);
        this.aZy.addHeaderView(this.aZB);
        this.aZy.addFooterView(this.aZB);
    }

    public void setData(List<au> list) {
        this.aZA.setData(list);
        aw(list);
    }

    public void onChangeSkinType(int i) {
        this.auI.getLayoutMode().X(i == 1);
        this.auI.getLayoutMode().h(this.mRoot);
        this.aZz.onChangeSkinType(this.auI.getPageContext(), i);
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        this.aZy.setOnSrollToBottomListener(xVar);
    }

    public boolean On() {
        return this.aZA.getCount() != 0 && this.aZy.getLastVisiblePosition() - this.aZy.getHeaderViewsCount() < this.aZA.getCount() + (-1);
    }

    public void aw(List<au> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void ax(List<au> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.auI.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.auI.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
