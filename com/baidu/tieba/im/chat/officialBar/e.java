package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private BaseActivity cGd;
    private BdListView fPa;
    private NavigationBar gAT;
    private d gAU;
    private View gAV;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cGd = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.cGd.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.cGd.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.gAT = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.gAT.setTitleText(R.string.officical_bar_info_history);
        this.gAT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fPa = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.gAU = new d(this.cGd, this.cGd.getPageContext().getContext());
        this.fPa.setAdapter((ListAdapter) this.gAU);
        this.gAV = View.inflate(this.cGd.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.fPa.addHeaderView(this.gAV);
        this.fPa.addFooterView(this.gAV);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.gAU.setData(list);
        da(list);
    }

    public void onChangeSkinType(int i) {
        this.cGd.getLayoutMode().setNightMode(i == 1);
        this.cGd.getLayoutMode().onModeChanged(this.mRoot);
        this.gAT.onChangeSkinType(this.cGd.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.fPa.setOnSrollToBottomListener(eVar);
    }

    public boolean byu() {
        return this.gAU.getCount() != 0 && this.fPa.getLastVisiblePosition() - this.fPa.getHeaderViewsCount() < this.gAU.getCount() + (-1);
    }

    public void da(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void db(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.cGd.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.iK(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.cGd.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
