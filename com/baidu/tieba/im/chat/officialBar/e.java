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
    private BaseActivity dXV;
    private BdListView gIB;
    private NavigationBar huA;
    private d huB;
    private View huC;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dXV = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.dXV.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.dXV.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.huA = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.huA.setTitleText(R.string.officical_bar_info_history);
        this.huA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gIB = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.huB = new d(this.dXV, this.dXV.getPageContext().getContext());
        this.gIB.setAdapter((ListAdapter) this.huB);
        this.huC = View.inflate(this.dXV.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.gIB.addHeaderView(this.huC);
        this.gIB.addFooterView(this.huC);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.huB.setData(list);
        cL(list);
    }

    public void onChangeSkinType(int i) {
        this.dXV.getLayoutMode().setNightMode(i == 1);
        this.dXV.getLayoutMode().onModeChanged(this.mRoot);
        this.huA.onChangeSkinType(this.dXV.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.gIB.setOnSrollToBottomListener(eVar);
    }

    public boolean bSw() {
        return this.huB.getCount() != 0 && this.gIB.getLastVisiblePosition() - this.gIB.getHeaderViewsCount() < this.huB.getCount() + (-1);
    }

    public void cL(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cM(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.dXV.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.lh(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.dXV.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
