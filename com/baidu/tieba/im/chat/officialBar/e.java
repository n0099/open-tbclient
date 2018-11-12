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
    private View ajk;
    private BdListView dUv;
    private NavigationBar eDs;
    private d eDt;
    private View eDu;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.ajk = View.inflate(this.mContext.getPageContext().getContext(), e.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.ajk);
        this.eDs = (NavigationBar) this.ajk.findViewById(e.g.view_navigation_bar);
        this.eDs.setTitleText(e.j.officical_bar_info_history);
        this.eDs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dUv = (BdListView) this.ajk.findViewById(e.g.bar_history_list);
        this.eDt = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.dUv.setAdapter((ListAdapter) this.eDt);
        this.eDu = View.inflate(this.mContext.getPageContext().getContext(), e.h.official_bar_history_item_occupy, null);
        this.dUv.addHeaderView(this.eDu);
        this.dUv.addFooterView(this.eDu);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.eDt.setData(list);
        cp(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.ajk);
        this.eDs.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.dUv.setOnSrollToBottomListener(eVar);
    }

    public boolean aMJ() {
        return this.eDt.getCount() != 0 && this.dUv.getLastVisiblePosition() - this.dUv.getHeaderViewsCount() < this.eDt.getCount() + (-1);
    }

    public void cp(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cq(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.ajk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.ec(e.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
