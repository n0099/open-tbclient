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
    private BaseActivity dXW;
    private BdListView gID;
    private NavigationBar huC;
    private d huD;
    private View huE;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dXW = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.dXW.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.dXW.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.huC = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.huC.setTitleText(R.string.officical_bar_info_history);
        this.huC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gID = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.huD = new d(this.dXW, this.dXW.getPageContext().getContext());
        this.gID.setAdapter((ListAdapter) this.huD);
        this.huE = View.inflate(this.dXW.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.gID.addHeaderView(this.huE);
        this.gID.addFooterView(this.huE);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.huD.setData(list);
        cL(list);
    }

    public void onChangeSkinType(int i) {
        this.dXW.getLayoutMode().setNightMode(i == 1);
        this.dXW.getLayoutMode().onModeChanged(this.mRoot);
        this.huC.onChangeSkinType(this.dXW.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.gID.setOnSrollToBottomListener(eVar);
    }

    public boolean bSy() {
        return this.huD.getCount() != 0 && this.gID.getLastVisiblePosition() - this.gID.getHeaderViewsCount() < this.huD.getCount() + (-1);
    }

    public void cL(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cM(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.dXW.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.lh(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.dXW.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
