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
/* loaded from: classes26.dex */
public class f extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private BaseActivity fLk;
    private NavigationBar jSA;
    private e jSB;
    private View jSC;
    private BdListView jaC;
    private NoDataView mNoDataView;
    private View mRoot;

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fLk = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.fLk.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.fLk.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.jSA = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.jSA.setTitleText(R.string.officical_bar_info_history);
        this.jSA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jaC = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.jSB = new e(this.fLk, this.fLk.getPageContext().getContext());
        this.jaC.setAdapter((ListAdapter) this.jSB);
        this.jSC = View.inflate(this.fLk.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.jaC.addHeaderView(this.jSC);
        this.jaC.addFooterView(this.jSC);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.jSB.setData(list);
        dP(list);
    }

    public void onChangeSkinType(int i) {
        this.fLk.getLayoutMode().setNightMode(i == 1);
        this.fLk.getLayoutMode().onModeChanged(this.mRoot);
        this.jSA.onChangeSkinType(this.fLk.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.jaC.setOnSrollToBottomListener(eVar);
    }

    public boolean cME() {
        return this.jSB.getCount() != 0 && this.jaC.getLastVisiblePosition() - this.jaC.getHeaderViewsCount() < this.jSB.getCount() + (-1);
    }

    public void dP(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dQ(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.fLk.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.pG(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.fLk.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
