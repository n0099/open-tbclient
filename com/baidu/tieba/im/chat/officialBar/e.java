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
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private View bub;
    private BdListView fsx;
    private NavigationBar gdA;
    private d gdB;
    private View gdC;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.bub = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.bub);
        this.gdA = (NavigationBar) this.bub.findViewById(d.g.view_navigation_bar);
        this.gdA.setTitleText(d.j.officical_bar_info_history);
        this.gdA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fsx = (BdListView) this.bub.findViewById(d.g.bar_history_list);
        this.gdB = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.fsx.setAdapter((ListAdapter) this.gdB);
        this.gdC = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_item_occupy, null);
        this.fsx.addHeaderView(this.gdC);
        this.fsx.addFooterView(this.gdC);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.gdB.setData(list);
        cE(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.bub);
        this.gdA.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.fsx.setOnSrollToBottomListener(eVar);
    }

    public boolean bqq() {
        return this.gdB.getCount() != 0 && this.fsx.getLastVisiblePosition() - this.fsx.getHeaderViewsCount() < this.gdB.getCount() + (-1);
    }

    public void cE(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cF(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.bub, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.hT(d.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
