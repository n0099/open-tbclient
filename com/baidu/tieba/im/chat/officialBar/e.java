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
    private View abt;
    private BdListView dCN;
    private NavigationBar ejc;
    private d ejd;
    private View eje;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.abt = View.inflate(this.mContext.getPageContext().getContext(), d.i.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.abt);
        this.ejc = (NavigationBar) this.abt.findViewById(d.g.view_navigation_bar);
        this.ejc.setTitleText(d.k.officical_bar_info_history);
        this.ejc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dCN = (BdListView) this.abt.findViewById(d.g.bar_history_list);
        this.ejd = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.dCN.setAdapter((ListAdapter) this.ejd);
        this.eje = View.inflate(this.mContext.getPageContext().getContext(), d.i.official_bar_history_item_occupy, null);
        this.dCN.addHeaderView(this.eje);
        this.dCN.addFooterView(this.eje);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.ejd.setData(list);
        cb(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.abt);
        this.ejc.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.dCN.setOnSrollToBottomListener(eVar);
    }

    public boolean aGK() {
        return this.ejd.getCount() != 0 && this.dCN.getLastVisiblePosition() - this.dCN.getHeaderViewsCount() < this.ejd.getCount() + (-1);
    }

    public void cb(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cc(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.abt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, HttpStatus.SC_BAD_REQUEST), NoDataViewFactory.d.ds(d.k.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
