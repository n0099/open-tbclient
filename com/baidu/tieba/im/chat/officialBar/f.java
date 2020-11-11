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
    private BaseActivity fRa;
    private NavigationBar jYw;
    private e jYx;
    private View jYy;
    private BdListView jgz;
    private NoDataView mNoDataView;
    private View mRoot;

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fRa = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.fRa.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.fRa.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.jYw = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.jYw.setTitleText(R.string.officical_bar_info_history);
        this.jYw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jgz = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.jYx = new e(this.fRa, this.fRa.getPageContext().getContext());
        this.jgz.setAdapter((ListAdapter) this.jYx);
        this.jYy = View.inflate(this.fRa.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.jgz.addHeaderView(this.jYy);
        this.jgz.addFooterView(this.jYy);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.jYx.setData(list);
        dX(list);
    }

    public void onChangeSkinType(int i) {
        this.fRa.getLayoutMode().setNightMode(i == 1);
        this.fRa.getLayoutMode().onModeChanged(this.mRoot);
        this.jYw.onChangeSkinType(this.fRa.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.jgz.setOnSrollToBottomListener(eVar);
    }

    public boolean cPf() {
        return this.jYx.getCount() != 0 && this.jgz.getLastVisiblePosition() - this.jgz.getHeaderViewsCount() < this.jYx.getCount() + (-1);
    }

    public void dX(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dY(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.fRa.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.pQ(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.fRa.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
