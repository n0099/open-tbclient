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
    private BaseActivity eyB;
    private BdListView huX;
    private NavigationBar igh;
    private d igi;
    private View igj;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eyB = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.eyB.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.eyB.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.igh = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.igh.setTitleText(R.string.officical_bar_info_history);
        this.igh.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.huX = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.igi = new d(this.eyB, this.eyB.getPageContext().getContext());
        this.huX.setAdapter((ListAdapter) this.igi);
        this.igj = View.inflate(this.eyB.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.huX.addHeaderView(this.igj);
        this.huX.addFooterView(this.igj);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.igi.setData(list);
        cW(list);
    }

    public void onChangeSkinType(int i) {
        this.eyB.getLayoutMode().setNightMode(i == 1);
        this.eyB.getLayoutMode().onModeChanged(this.mRoot);
        this.igh.onChangeSkinType(this.eyB.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.huX.setOnSrollToBottomListener(eVar);
    }

    public boolean cdo() {
        return this.igi.getCount() != 0 && this.huX.getLastVisiblePosition() - this.huX.getHeaderViewsCount() < this.igi.getCount() + (-1);
    }

    public void cW(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cX(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.eyB.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.lr(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.eyB.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
