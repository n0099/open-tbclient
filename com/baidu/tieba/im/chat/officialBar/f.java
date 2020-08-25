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
/* loaded from: classes20.dex */
public class f extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private BaseActivity fnt;
    private BdListView irR;
    private NavigationBar jiu;
    private e jiv;
    private View jiw;
    private NoDataView mNoDataView;
    private View mRoot;

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fnt = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.fnt.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.fnt.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.jiu = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.jiu.setTitleText(R.string.officical_bar_info_history);
        this.jiu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.irR = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.jiv = new e(this.fnt, this.fnt.getPageContext().getContext());
        this.irR.setAdapter((ListAdapter) this.jiv);
        this.jiw = View.inflate(this.fnt.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.irR.addHeaderView(this.jiw);
        this.irR.addFooterView(this.jiw);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.jiv.setData(list);
        dv(list);
    }

    public void onChangeSkinType(int i) {
        this.fnt.getLayoutMode().setNightMode(i == 1);
        this.fnt.getLayoutMode().onModeChanged(this.mRoot);
        this.jiu.onChangeSkinType(this.fnt.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.irR.setOnSrollToBottomListener(eVar);
    }

    public boolean cCh() {
        return this.jiv.getCount() != 0 && this.irR.getLastVisiblePosition() - this.irR.getHeaderViewsCount() < this.jiv.getCount() + (-1);
    }

    public void dv(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dw(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.fnt.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.oK(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.fnt.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
