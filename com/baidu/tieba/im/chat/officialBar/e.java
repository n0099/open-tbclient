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
    private View Th;
    private NavigationBar dTV;
    private d dTW;
    private View dTX;
    private BdListView dqo;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.Th = View.inflate(this.mContext.getPageContext().getContext(), d.i.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.Th);
        this.dTV = (NavigationBar) this.Th.findViewById(d.g.view_navigation_bar);
        this.dTV.setTitleText(d.k.officical_bar_info_history);
        this.dTV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dqo = (BdListView) this.Th.findViewById(d.g.bar_history_list);
        this.dTW = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.dqo.setAdapter((ListAdapter) this.dTW);
        this.dTX = View.inflate(this.mContext.getPageContext().getContext(), d.i.official_bar_history_item_occupy, null);
        this.dqo.addHeaderView(this.dTX);
        this.dqo.addFooterView(this.dTX);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.dTW.setData(list);
        bS(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().u(this.Th);
        this.dTV.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.dqo.setOnSrollToBottomListener(eVar);
    }

    public boolean aBh() {
        return this.dTW.getCount() != 0 && this.dqo.getLastVisiblePosition() - this.dqo.getHeaderViewsCount() < this.dTW.getCount() + (-1);
    }

    public void bS(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void bT(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.Th, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, HttpStatus.SC_BAD_REQUEST), NoDataViewFactory.d.dp(d.k.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
