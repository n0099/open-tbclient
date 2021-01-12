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
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.base.d<OfficialBarHistoryActivity> {
    private BaseActivity gdS;
    private BdListView jCE;
    private NavigationBar kuO;
    private d kuP;
    private View kuQ;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gdS = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.gdS.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.gdS.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.kuO = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.kuO.setTitleText(R.string.officical_bar_info_history);
        this.kuO.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jCE = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.kuP = new d(this.gdS, this.gdS.getPageContext().getContext());
        this.jCE.setAdapter((ListAdapter) this.kuP);
        this.kuQ = View.inflate(this.gdS.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.jCE.addHeaderView(this.kuQ);
        this.jCE.addFooterView(this.kuQ);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.kuP.setData(list);
        ep(list);
    }

    public void onChangeSkinType(int i) {
        this.gdS.getLayoutMode().setNightMode(i == 1);
        this.gdS.getLayoutMode().onModeChanged(this.mRoot);
        this.kuO.onChangeSkinType(this.gdS.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.jCE.setOnSrollToBottomListener(eVar);
    }

    public boolean cSV() {
        return this.kuP.getCount() != 0 && this.jCE.getLastVisiblePosition() - this.jCE.getHeaderViewsCount() < this.kuP.getCount() + (-1);
    }

    public void ep(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void eq(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.gdS.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.pu(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.gdS.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
