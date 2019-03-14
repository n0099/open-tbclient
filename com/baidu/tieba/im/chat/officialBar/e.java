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
    private View btY;
    private BdListView fsL;
    private NavigationBar gdM;
    private d gdN;
    private View gdO;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.btY = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.btY);
        this.gdM = (NavigationBar) this.btY.findViewById(d.g.view_navigation_bar);
        this.gdM.setTitleText(d.j.officical_bar_info_history);
        this.gdM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fsL = (BdListView) this.btY.findViewById(d.g.bar_history_list);
        this.gdN = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.fsL.setAdapter((ListAdapter) this.gdN);
        this.gdO = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_item_occupy, null);
        this.fsL.addHeaderView(this.gdO);
        this.fsL.addFooterView(this.gdO);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.gdN.setData(list);
        cH(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.btY);
        this.gdM.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.fsL.setOnSrollToBottomListener(eVar);
    }

    public boolean bqt() {
        return this.gdN.getCount() != 0 && this.fsL.getLastVisiblePosition() - this.fsL.getHeaderViewsCount() < this.gdN.getCount() + (-1);
    }

    public void cH(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cI(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.btY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.hU(d.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
