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
/* loaded from: classes11.dex */
public class e extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private BaseActivity dTQ;
    private BdListView gGC;
    private NavigationBar hsB;
    private d hsC;
    private View hsD;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dTQ = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.dTQ.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.dTQ.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.hsB = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.hsB.setTitleText(R.string.officical_bar_info_history);
        this.hsB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gGC = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.hsC = new d(this.dTQ, this.dTQ.getPageContext().getContext());
        this.gGC.setAdapter((ListAdapter) this.hsC);
        this.hsD = View.inflate(this.dTQ.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.gGC.addHeaderView(this.hsD);
        this.gGC.addFooterView(this.hsD);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.hsC.setData(list);
        cP(list);
    }

    public void onChangeSkinType(int i) {
        this.dTQ.getLayoutMode().setNightMode(i == 1);
        this.dTQ.getLayoutMode().onModeChanged(this.mRoot);
        this.hsB.onChangeSkinType(this.dTQ.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.gGC.setOnSrollToBottomListener(eVar);
    }

    public boolean bQV() {
        return this.hsC.getCount() != 0 && this.gGC.getLastVisiblePosition() - this.gGC.getHeaderViewsCount() < this.hsC.getCount() + (-1);
    }

    public void cP(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cQ(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.dTQ.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.kQ(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.dTQ.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
