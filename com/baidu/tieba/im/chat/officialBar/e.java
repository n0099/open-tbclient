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
    private BaseActivity cGU;
    private BdListView fPR;
    private NavigationBar gBK;
    private d gBL;
    private View gBM;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cGU = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.cGU.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.cGU.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.gBK = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.gBK.setTitleText(R.string.officical_bar_info_history);
        this.gBK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fPR = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.gBL = new d(this.cGU, this.cGU.getPageContext().getContext());
        this.fPR.setAdapter((ListAdapter) this.gBL);
        this.gBM = View.inflate(this.cGU.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.fPR.addHeaderView(this.gBM);
        this.fPR.addFooterView(this.gBM);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.gBL.setData(list);
        da(list);
    }

    public void onChangeSkinType(int i) {
        this.cGU.getLayoutMode().setNightMode(i == 1);
        this.cGU.getLayoutMode().onModeChanged(this.mRoot);
        this.gBK.onChangeSkinType(this.cGU.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.fPR.setOnSrollToBottomListener(eVar);
    }

    public boolean byw() {
        return this.gBL.getCount() != 0 && this.fPR.getLastVisiblePosition() - this.fPR.getHeaderViewsCount() < this.gBL.getCount() + (-1);
    }

    public void da(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void db(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.cGU.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.iL(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.cGU.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
