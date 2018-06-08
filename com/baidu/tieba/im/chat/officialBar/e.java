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
    private View abp;
    private BdListView dzA;
    private NavigationBar efi;
    private d efj;
    private View efk;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.abp = View.inflate(this.mContext.getPageContext().getContext(), d.i.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.abp);
        this.efi = (NavigationBar) this.abp.findViewById(d.g.view_navigation_bar);
        this.efi.setTitleText(d.k.officical_bar_info_history);
        this.efi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dzA = (BdListView) this.abp.findViewById(d.g.bar_history_list);
        this.efj = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.dzA.setAdapter((ListAdapter) this.efj);
        this.efk = View.inflate(this.mContext.getPageContext().getContext(), d.i.official_bar_history_item_occupy, null);
        this.dzA.addHeaderView(this.efk);
        this.dzA.addFooterView(this.efk);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.efj.setData(list);
        bX(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.abp);
        this.efi.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.dzA.setOnSrollToBottomListener(eVar);
    }

    public boolean aGc() {
        return this.efj.getCount() != 0 && this.dzA.getLastVisiblePosition() - this.dzA.getHeaderViewsCount() < this.efj.getCount() + (-1);
    }

    public void bX(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void bY(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.abp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, HttpStatus.SC_BAD_REQUEST), NoDataViewFactory.d.dr(d.k.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
