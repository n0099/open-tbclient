package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public class i extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private View aHS;
    private BdListView exW;
    private NavigationBar exX;
    private h exY;
    private View exZ;
    private BaseActivity mContext;
    private com.baidu.tbadk.core.view.h mNoDataView;

    public i(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.aHS = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.aHS);
        this.exX = (NavigationBar) this.aHS.findViewById(d.g.view_navigation_bar);
        this.exX.setTitleText(d.j.officical_bar_info_history);
        this.exX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.exW = (BdListView) this.aHS.findViewById(d.g.bar_history_list);
        this.exY = new h(this.mContext, this.mContext.getPageContext().getContext());
        this.exW.setAdapter((ListAdapter) this.exY);
        this.exZ = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_item_occupy, null);
        this.exW.addHeaderView(this.exZ);
        this.exW.addFooterView(this.exZ);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.exY.setData(list);
        bW(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().aQ(i == 1);
        this.mContext.getLayoutMode().aM(this.aHS);
        this.exX.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.exW.setOnSrollToBottomListener(eVar);
    }

    public boolean aGi() {
        return this.exY.getCount() != 0 && this.exW.getLastVisiblePosition() - this.exW.getHeaderViewsCount() < this.exY.getCount() + (-1);
    }

    public void bW(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void bX(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.aHS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, HttpStatus.SC_BAD_REQUEST), NoDataViewFactory.d.gp(d.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
