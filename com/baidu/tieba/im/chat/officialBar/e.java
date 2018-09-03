package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private View aaW;
    private BdListView dFw;
    private NavigationBar emP;
    private d emQ;
    private View emR;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.aaW = View.inflate(this.mContext.getPageContext().getContext(), f.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.aaW);
        this.emP = (NavigationBar) this.aaW.findViewById(f.g.view_navigation_bar);
        this.emP.setTitleText(f.j.officical_bar_info_history);
        this.emP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFw = (BdListView) this.aaW.findViewById(f.g.bar_history_list);
        this.emQ = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.dFw.setAdapter((ListAdapter) this.emQ);
        this.emR = View.inflate(this.mContext.getPageContext().getContext(), f.h.official_bar_history_item_occupy, null);
        this.dFw.addHeaderView(this.emR);
        this.dFw.addFooterView(this.emR);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.emQ.setData(list);
        cb(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.aaW);
        this.emP.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.dFw.setOnSrollToBottomListener(eVar);
    }

    public boolean aHH() {
        return this.emQ.getCount() != 0 && this.dFw.getLastVisiblePosition() - this.dFw.getHeaderViewsCount() < this.emQ.getCount() + (-1);
    }

    public void cb(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cc(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.aaW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, HttpStatus.SC_BAD_REQUEST), NoDataViewFactory.d.dt(f.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
