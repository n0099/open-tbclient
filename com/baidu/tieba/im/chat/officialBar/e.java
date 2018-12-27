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
    private NavigationBar eMY;
    private d eMZ;
    private View eNa;
    private BdListView edP;
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
        this.eMY = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.eMY.setTitleText(e.j.officical_bar_info_history);
        this.eMY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.edP = (BdListView) this.amM.findViewById(e.g.bar_history_list);
        this.eMZ = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.edP.setAdapter((ListAdapter) this.eMZ);
        this.eNa = View.inflate(this.mContext.getPageContext().getContext(), e.h.official_bar_history_item_occupy, null);
        this.edP.addHeaderView(this.eNa);
        this.edP.addFooterView(this.eNa);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.eMZ.setData(list);
        cu(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.amM);
        this.eMY.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.edP.setOnSrollToBottomListener(eVar);
    }

    public boolean aPo() {
        return this.eMZ.getCount() != 0 && this.edP.getLastVisiblePosition() - this.edP.getHeaderViewsCount() < this.eMZ.getCount() + (-1);
    }

    public void cu(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cv(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.eq(e.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
