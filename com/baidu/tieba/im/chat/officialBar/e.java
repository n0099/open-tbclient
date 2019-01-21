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
    private View anp;
    private NavigationBar eNL;
    private d eNM;
    private View eNN;
    private BdListView eew;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.anp = View.inflate(this.mContext.getPageContext().getContext(), e.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.anp);
        this.eNL = (NavigationBar) this.anp.findViewById(e.g.view_navigation_bar);
        this.eNL.setTitleText(e.j.officical_bar_info_history);
        this.eNL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eew = (BdListView) this.anp.findViewById(e.g.bar_history_list);
        this.eNM = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.eew.setAdapter((ListAdapter) this.eNM);
        this.eNN = View.inflate(this.mContext.getPageContext().getContext(), e.h.official_bar_history_item_occupy, null);
        this.eew.addHeaderView(this.eNN);
        this.eew.addFooterView(this.eNN);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.eNM.setData(list);
        cv(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.anp);
        this.eNL.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.eew.setOnSrollToBottomListener(eVar);
    }

    public boolean aPO() {
        return this.eNM.getCount() != 0 && this.eew.getLastVisiblePosition() - this.eew.getHeaderViewsCount() < this.eNM.getCount() + (-1);
    }

    public void cv(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cw(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.anp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.eq(e.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
