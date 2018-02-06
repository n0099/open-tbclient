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
    private View aId;
    private BdListView eyi;
    private NavigationBar eyj;
    private h eyk;
    private View eyl;
    private BaseActivity mContext;
    private com.baidu.tbadk.core.view.h mNoDataView;

    public i(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.aId = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.aId);
        this.eyj = (NavigationBar) this.aId.findViewById(d.g.view_navigation_bar);
        this.eyj.setTitleText(d.j.officical_bar_info_history);
        this.eyj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eyi = (BdListView) this.aId.findViewById(d.g.bar_history_list);
        this.eyk = new h(this.mContext, this.mContext.getPageContext().getContext());
        this.eyi.setAdapter((ListAdapter) this.eyk);
        this.eyl = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_item_occupy, null);
        this.eyi.addHeaderView(this.eyl);
        this.eyi.addFooterView(this.eyl);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.eyk.setData(list);
        bW(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().aQ(i == 1);
        this.mContext.getLayoutMode().aM(this.aId);
        this.eyj.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.eyi.setOnSrollToBottomListener(eVar);
    }

    public boolean aGj() {
        return this.eyk.getCount() != 0 && this.eyi.getLastVisiblePosition() - this.eyi.getHeaderViewsCount() < this.eyk.getCount() + (-1);
    }

    public void bW(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void bX(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.aId, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, HttpStatus.SC_BAD_REQUEST), NoDataViewFactory.d.gp(d.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
