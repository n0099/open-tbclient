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
/* loaded from: classes10.dex */
public class e extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private BaseActivity dTH;
    private BdListView gDn;
    private NavigationBar hoY;
    private d hoZ;
    private View hpa;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dTH = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.dTH.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.dTH.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.hoY = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.hoY.setTitleText(R.string.officical_bar_info_history);
        this.hoY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gDn = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.hoZ = new d(this.dTH, this.dTH.getPageContext().getContext());
        this.gDn.setAdapter((ListAdapter) this.hoZ);
        this.hpa = View.inflate(this.dTH.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.gDn.addHeaderView(this.hpa);
        this.gDn.addFooterView(this.hpa);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.hoZ.setData(list);
        cP(list);
    }

    public void onChangeSkinType(int i) {
        this.dTH.getLayoutMode().setNightMode(i == 1);
        this.dTH.getLayoutMode().onModeChanged(this.mRoot);
        this.hoY.onChangeSkinType(this.dTH.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.gDn.setOnSrollToBottomListener(eVar);
    }

    public boolean bPM() {
        return this.hoZ.getCount() != 0 && this.gDn.getLastVisiblePosition() - this.gDn.getHeaderViewsCount() < this.hoZ.getCount() + (-1);
    }

    public void cP(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cQ(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.dTH.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.kQ(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.dTH.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
