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
/* loaded from: classes20.dex */
public class f extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private BaseActivity fnx;
    private BdListView irX;
    private NavigationBar jiA;
    private e jiB;
    private View jiC;
    private NoDataView mNoDataView;
    private View mRoot;

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fnx = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.fnx.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.fnx.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.jiA = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.jiA.setTitleText(R.string.officical_bar_info_history);
        this.jiA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.irX = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.jiB = new e(this.fnx, this.fnx.getPageContext().getContext());
        this.irX.setAdapter((ListAdapter) this.jiB);
        this.jiC = View.inflate(this.fnx.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.irX.addHeaderView(this.jiC);
        this.irX.addFooterView(this.jiC);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.jiB.setData(list);
        dv(list);
    }

    public void onChangeSkinType(int i) {
        this.fnx.getLayoutMode().setNightMode(i == 1);
        this.fnx.getLayoutMode().onModeChanged(this.mRoot);
        this.jiA.onChangeSkinType(this.fnx.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.irX.setOnSrollToBottomListener(eVar);
    }

    public boolean cCi() {
        return this.jiB.getCount() != 0 && this.irX.getLastVisiblePosition() - this.irX.getHeaderViewsCount() < this.jiB.getCount() + (-1);
    }

    public void dv(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dw(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.fnx.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.oK(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.fnx.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
