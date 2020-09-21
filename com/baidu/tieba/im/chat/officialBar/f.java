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
/* loaded from: classes25.dex */
public class f extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private BaseActivity fqC;
    private BdListView izn;
    private NavigationBar jre;
    private e jrf;
    private View jrg;
    private NoDataView mNoDataView;
    private View mRoot;

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fqC = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.fqC.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.fqC.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.jre = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.jre.setTitleText(R.string.officical_bar_info_history);
        this.jre.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.izn = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.jrf = new e(this.fqC, this.fqC.getPageContext().getContext());
        this.izn.setAdapter((ListAdapter) this.jrf);
        this.jrg = View.inflate(this.fqC.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.izn.addHeaderView(this.jrg);
        this.izn.addFooterView(this.jrg);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.jrf.setData(list);
        dD(list);
    }

    public void onChangeSkinType(int i) {
        this.fqC.getLayoutMode().setNightMode(i == 1);
        this.fqC.getLayoutMode().onModeChanged(this.mRoot);
        this.jre.onChangeSkinType(this.fqC.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.izn.setOnSrollToBottomListener(eVar);
    }

    public boolean cFO() {
        return this.jrf.getCount() != 0 && this.izn.getLastVisiblePosition() - this.izn.getHeaderViewsCount() < this.jrf.getCount() + (-1);
    }

    public void dD(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dE(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.fqC.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.oW(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.fqC.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
