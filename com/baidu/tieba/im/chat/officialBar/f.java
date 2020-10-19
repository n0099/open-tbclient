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
    private BaseActivity fCP;
    private BdListView iOg;
    private NavigationBar jGb;
    private e jGc;
    private View jGd;
    private NoDataView mNoDataView;
    private View mRoot;

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fCP = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.fCP.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.fCP.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.jGb = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.jGb.setTitleText(R.string.officical_bar_info_history);
        this.jGb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iOg = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.jGc = new e(this.fCP, this.fCP.getPageContext().getContext());
        this.iOg.setAdapter((ListAdapter) this.jGc);
        this.jGd = View.inflate(this.fCP.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.iOg.addHeaderView(this.jGd);
        this.iOg.addFooterView(this.jGd);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.jGc.setData(list);
        dG(list);
    }

    public void onChangeSkinType(int i) {
        this.fCP.getLayoutMode().setNightMode(i == 1);
        this.fCP.getLayoutMode().onModeChanged(this.mRoot);
        this.jGb.onChangeSkinType(this.fCP.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.iOg.setOnSrollToBottomListener(eVar);
    }

    public boolean cJx() {
        return this.jGc.getCount() != 0 && this.iOg.getLastVisiblePosition() - this.iOg.getHeaderViewsCount() < this.jGc.getCount() + (-1);
    }

    public void dG(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dH(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.fCP.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.pv(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.fCP.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
