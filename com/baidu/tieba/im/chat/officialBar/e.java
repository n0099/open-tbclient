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
/* loaded from: classes8.dex */
public class e extends com.baidu.adp.base.d<OfficialBarHistoryActivity> {
    private BaseActivity ggm;
    private BdListView jIw;
    private NavigationBar kDi;
    private d kDj;
    private View kDk;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ggm = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.ggm.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.ggm.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.kDi = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.kDi.setTitleText(R.string.officical_bar_info_history);
        this.kDi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jIw = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.kDj = new d(this.ggm, this.ggm.getPageContext().getContext());
        this.jIw.setAdapter((ListAdapter) this.kDj);
        this.kDk = View.inflate(this.ggm.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.jIw.addHeaderView(this.kDk);
        this.jIw.addFooterView(this.kDk);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.kDj.setData(list);
        en(list);
    }

    public void onChangeSkinType(int i) {
        this.ggm.getLayoutMode().setNightMode(i == 1);
        this.ggm.getLayoutMode().onModeChanged(this.mRoot);
        this.kDi.onChangeSkinType(this.ggm.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.jIw.setOnSrollToBottomListener(eVar);
    }

    public boolean cVa() {
        return this.kDj.getCount() != 0 && this.jIw.getLastVisiblePosition() - this.jIw.getHeaderViewsCount() < this.kDj.getCount() + (-1);
    }

    public void en(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void eo(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.ggm.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.pz(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.ggm.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
