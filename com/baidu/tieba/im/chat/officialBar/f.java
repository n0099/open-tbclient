package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import java.util.List;
/* loaded from: classes26.dex */
public class f extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private BaseActivity fYU;
    private BdListView juP;
    private NavigationBar kmN;
    private e kmO;
    private View kmP;
    private NoDataView mNoDataView;
    private View mRoot;

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fYU = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.fYU.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.fYU.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.kmN = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.kmN.setTitleText(R.string.officical_bar_info_history);
        this.kmN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.juP = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.kmO = new e(this.fYU, this.fYU.getPageContext().getContext());
        this.juP.setAdapter((ListAdapter) this.kmO);
        this.kmP = View.inflate(this.fYU.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.juP.addHeaderView(this.kmP);
        this.juP.addFooterView(this.kmP);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.kmO.setData(list);
        ei(list);
    }

    public void onChangeSkinType(int i) {
        this.fYU.getLayoutMode().setNightMode(i == 1);
        this.fYU.getLayoutMode().onModeChanged(this.mRoot);
        this.kmN.onChangeSkinType(this.fYU.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.juP.setOnSrollToBottomListener(eVar);
    }

    public boolean cUa() {
        return this.kmO.getCount() != 0 && this.juP.getLastVisiblePosition() - this.juP.getHeaderViewsCount() < this.kmO.getCount() + (-1);
    }

    public void ei(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void ej(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.fYU.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.qP(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.fYU.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
