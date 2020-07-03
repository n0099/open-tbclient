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
    private BaseActivity eXy;
    private BdListView hXJ;
    private NavigationBar iMJ;
    private d iMK;
    private View iML;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eXy = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.eXy.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.eXy.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.iMJ = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.iMJ.setTitleText(R.string.officical_bar_info_history);
        this.iMJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hXJ = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.iMK = new d(this.eXy, this.eXy.getPageContext().getContext());
        this.hXJ.setAdapter((ListAdapter) this.iMK);
        this.iML = View.inflate(this.eXy.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.hXJ.addHeaderView(this.iML);
        this.hXJ.addFooterView(this.iML);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.iMK.setData(list);
        dj(list);
    }

    public void onChangeSkinType(int i) {
        this.eXy.getLayoutMode().setNightMode(i == 1);
        this.eXy.getLayoutMode().onModeChanged(this.mRoot);
        this.iMJ.onChangeSkinType(this.eXy.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.hXJ.setOnSrollToBottomListener(eVar);
    }

    public boolean cnL() {
        return this.iMK.getCount() != 0 && this.hXJ.getLastVisiblePosition() - this.hXJ.getHeaderViewsCount() < this.iMK.getCount() + (-1);
    }

    public void dj(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dk(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.eXy.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.mm(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.eXy.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
