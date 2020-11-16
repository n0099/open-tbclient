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
    private BaseActivity fQJ;
    private NavigationBar jZg;
    private e jZh;
    private View jZi;
    private BdListView jhk;
    private NoDataView mNoDataView;
    private View mRoot;

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fQJ = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.fQJ.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.fQJ.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.jZg = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.jZg.setTitleText(R.string.officical_bar_info_history);
        this.jZg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jhk = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.jZh = new e(this.fQJ, this.fQJ.getPageContext().getContext());
        this.jhk.setAdapter((ListAdapter) this.jZh);
        this.jZi = View.inflate(this.fQJ.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.jhk.addHeaderView(this.jZi);
        this.jhk.addFooterView(this.jZi);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.jZh.setData(list);
        dX(list);
    }

    public void onChangeSkinType(int i) {
        this.fQJ.getLayoutMode().setNightMode(i == 1);
        this.fQJ.getLayoutMode().onModeChanged(this.mRoot);
        this.jZg.onChangeSkinType(this.fQJ.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.jhk.setOnSrollToBottomListener(eVar);
    }

    public boolean cOL() {
        return this.jZh.getCount() != 0 && this.jhk.getLastVisiblePosition() - this.jhk.getHeaderViewsCount() < this.jZh.getCount() + (-1);
    }

    public void dX(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dY(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.fQJ.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.qo(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.fQJ.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
