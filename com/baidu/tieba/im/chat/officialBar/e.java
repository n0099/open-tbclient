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
    private BaseActivity giB;
    private BdListView jHk;
    private NavigationBar kzt;
    private d kzu;
    private View kzv;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.giB = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.giB.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.giB.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.kzt = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.kzt.setTitleText(R.string.officical_bar_info_history);
        this.kzt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jHk = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.kzu = new d(this.giB, this.giB.getPageContext().getContext());
        this.jHk.setAdapter((ListAdapter) this.kzu);
        this.kzv = View.inflate(this.giB.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.jHk.addHeaderView(this.kzv);
        this.jHk.addFooterView(this.kzv);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.kzu.setData(list);
        ep(list);
    }

    public void onChangeSkinType(int i) {
        this.giB.getLayoutMode().setNightMode(i == 1);
        this.giB.getLayoutMode().onModeChanged(this.mRoot);
        this.kzt.onChangeSkinType(this.giB.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.jHk.setOnSrollToBottomListener(eVar);
    }

    public boolean cWN() {
        return this.kzu.getCount() != 0 && this.jHk.getLastVisiblePosition() - this.jHk.getHeaderViewsCount() < this.kzu.getCount() + (-1);
    }

    public void ep(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void eq(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.giB.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.ra(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.giB.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
