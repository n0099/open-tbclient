package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private View aaV;
    private BdListView dFz;
    private NavigationBar emT;
    private d emU;
    private View emV;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.aaV = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.aaV);
        this.emT = (NavigationBar) this.aaV.findViewById(d.g.view_navigation_bar);
        this.emT.setTitleText(d.j.officical_bar_info_history);
        this.emT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFz = (BdListView) this.aaV.findViewById(d.g.bar_history_list);
        this.emU = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.dFz.setAdapter((ListAdapter) this.emU);
        this.emV = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_item_occupy, null);
        this.dFz.addHeaderView(this.emV);
        this.dFz.addFooterView(this.emV);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.emU.setData(list);
        cb(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.aaV);
        this.emT.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.dFz.setOnSrollToBottomListener(eVar);
    }

    public boolean aHK() {
        return this.emU.getCount() != 0 && this.dFz.getLastVisiblePosition() - this.dFz.getHeaderViewsCount() < this.emU.getCount() + (-1);
    }

    public void cb(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cc(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.aaV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, HttpStatus.SC_BAD_REQUEST), NoDataViewFactory.d.du(d.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
