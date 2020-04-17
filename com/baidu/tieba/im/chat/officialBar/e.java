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
/* loaded from: classes13.dex */
public class e extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private BaseActivity eyw;
    private BdListView huR;
    private NavigationBar igb;
    private d igc;
    private View igd;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eyw = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.eyw.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.eyw.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.igb = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.igb.setTitleText(R.string.officical_bar_info_history);
        this.igb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.huR = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.igc = new d(this.eyw, this.eyw.getPageContext().getContext());
        this.huR.setAdapter((ListAdapter) this.igc);
        this.igd = View.inflate(this.eyw.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.huR.addHeaderView(this.igd);
        this.huR.addFooterView(this.igd);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.igc.setData(list);
        cW(list);
    }

    public void onChangeSkinType(int i) {
        this.eyw.getLayoutMode().setNightMode(i == 1);
        this.eyw.getLayoutMode().onModeChanged(this.mRoot);
        this.igb.onChangeSkinType(this.eyw.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.huR.setOnSrollToBottomListener(eVar);
    }

    public boolean cdq() {
        return this.igc.getCount() != 0 && this.huR.getLastVisiblePosition() - this.huR.getHeaderViewsCount() < this.igc.getCount() + (-1);
    }

    public void cW(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cX(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.eyw.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.lr(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.eyw.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
