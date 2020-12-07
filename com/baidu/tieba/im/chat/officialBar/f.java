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
    private BaseActivity fYS;
    private BdListView juN;
    private NavigationBar kmL;
    private e kmM;
    private View kmN;
    private NoDataView mNoDataView;
    private View mRoot;

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fYS = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.fYS.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.fYS.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.kmL = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.kmL.setTitleText(R.string.officical_bar_info_history);
        this.kmL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.juN = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.kmM = new e(this.fYS, this.fYS.getPageContext().getContext());
        this.juN.setAdapter((ListAdapter) this.kmM);
        this.kmN = View.inflate(this.fYS.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.juN.addHeaderView(this.kmN);
        this.juN.addFooterView(this.kmN);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.kmM.setData(list);
        ei(list);
    }

    public void onChangeSkinType(int i) {
        this.fYS.getLayoutMode().setNightMode(i == 1);
        this.fYS.getLayoutMode().onModeChanged(this.mRoot);
        this.kmL.onChangeSkinType(this.fYS.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.juN.setOnSrollToBottomListener(eVar);
    }

    public boolean cTZ() {
        return this.kmM.getCount() != 0 && this.juN.getLastVisiblePosition() - this.juN.getHeaderViewsCount() < this.kmM.getCount() + (-1);
    }

    public void ei(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void ej(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.fYS.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.qP(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.fYS.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
