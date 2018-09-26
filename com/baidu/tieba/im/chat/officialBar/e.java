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
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private View adA;
    private BdListView dLs;
    private NavigationBar euk;
    private d eul;
    private View eum;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.adA = View.inflate(this.mContext.getPageContext().getContext(), e.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.adA);
        this.euk = (NavigationBar) this.adA.findViewById(e.g.view_navigation_bar);
        this.euk.setTitleText(e.j.officical_bar_info_history);
        this.euk.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dLs = (BdListView) this.adA.findViewById(e.g.bar_history_list);
        this.eul = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.dLs.setAdapter((ListAdapter) this.eul);
        this.eum = View.inflate(this.mContext.getPageContext().getContext(), e.h.official_bar_history_item_occupy, null);
        this.dLs.addHeaderView(this.eum);
        this.dLs.addFooterView(this.eum);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.eul.setData(list);
        cc(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.adA);
        this.euk.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.dLs.setOnSrollToBottomListener(eVar);
    }

    public boolean aJW() {
        return this.eul.getCount() != 0 && this.dLs.getLastVisiblePosition() - this.dLs.getHeaderViewsCount() < this.eul.getCount() + (-1);
    }

    public void cc(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cd(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.adA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, HttpStatus.SC_BAD_REQUEST), NoDataViewFactory.d.dE(e.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
