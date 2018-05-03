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
    private View Tl;
    private NavigationBar dSO;
    private d dSP;
    private View dSQ;
    private BdListView dpg;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.Tl = View.inflate(this.mContext.getPageContext().getContext(), d.i.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.Tl);
        this.dSO = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
        this.dSO.setTitleText(d.k.officical_bar_info_history);
        this.dSO.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dpg = (BdListView) this.Tl.findViewById(d.g.bar_history_list);
        this.dSP = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.dpg.setAdapter((ListAdapter) this.dSP);
        this.dSQ = View.inflate(this.mContext.getPageContext().getContext(), d.i.official_bar_history_item_occupy, null);
        this.dpg.addHeaderView(this.dSQ);
        this.dpg.addFooterView(this.dSQ);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.dSP.setData(list);
        bP(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().u(this.Tl);
        this.dSO.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.dpg.setOnSrollToBottomListener(eVar);
    }

    public boolean aBj() {
        return this.dSP.getCount() != 0 && this.dpg.getLastVisiblePosition() - this.dpg.getHeaderViewsCount() < this.dSP.getCount() + (-1);
    }

    public void bP(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void bQ(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.Tl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, HttpStatus.SC_BAD_REQUEST), NoDataViewFactory.d.m16do(d.k.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
