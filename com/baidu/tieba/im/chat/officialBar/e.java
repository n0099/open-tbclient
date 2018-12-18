package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private View amM;
    private NavigationBar eKh;
    private d eKi;
    private View eKj;
    private BdListView eaY;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.amM = View.inflate(this.mContext.getPageContext().getContext(), e.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.amM);
        this.eKh = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.eKh.setTitleText(e.j.officical_bar_info_history);
        this.eKh.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eaY = (BdListView) this.amM.findViewById(e.g.bar_history_list);
        this.eKi = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.eaY.setAdapter((ListAdapter) this.eKi);
        this.eKj = View.inflate(this.mContext.getPageContext().getContext(), e.h.official_bar_history_item_occupy, null);
        this.eaY.addHeaderView(this.eKj);
        this.eaY.addFooterView(this.eKj);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.eKi.setData(list);
        ct(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.amM);
        this.eKh.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.eaY.setOnSrollToBottomListener(eVar);
    }

    public boolean aOA() {
        return this.eKi.getCount() != 0 && this.eaY.getLastVisiblePosition() - this.eaY.getHeaderViewsCount() < this.eKi.getCount() + (-1);
    }

    public void ct(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cu(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.eq(e.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
