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
/* loaded from: classes8.dex */
public class e extends com.baidu.adp.base.d<OfficialBarHistoryActivity> {
    private BaseActivity ggh;
    private BdListView jIi;
    private NavigationBar kCU;
    private d kCV;
    private View kCW;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ggh = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.ggh.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.ggh.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.kCU = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.kCU.setTitleText(R.string.officical_bar_info_history);
        this.kCU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jIi = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.kCV = new d(this.ggh, this.ggh.getPageContext().getContext());
        this.jIi.setAdapter((ListAdapter) this.kCV);
        this.kCW = View.inflate(this.ggh.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.jIi.addHeaderView(this.kCW);
        this.jIi.addFooterView(this.kCW);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.kCV.setData(list);
        en(list);
    }

    public void onChangeSkinType(int i) {
        this.ggh.getLayoutMode().setNightMode(i == 1);
        this.ggh.getLayoutMode().onModeChanged(this.mRoot);
        this.kCU.onChangeSkinType(this.ggh.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.jIi.setOnSrollToBottomListener(eVar);
    }

    public boolean cUT() {
        return this.kCV.getCount() != 0 && this.jIi.getLastVisiblePosition() - this.jIi.getHeaderViewsCount() < this.kCV.getCount() + (-1);
    }

    public void en(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void eo(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.ggh.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.pz(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.ggh.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
