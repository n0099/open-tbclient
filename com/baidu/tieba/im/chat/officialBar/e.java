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
    private BaseActivity dYz;
    private BdListView gJU;
    private NavigationBar hwo;
    private d hwp;
    private View hwq;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dYz = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.dYz.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.dYz.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.hwo = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.hwo.setTitleText(R.string.officical_bar_info_history);
        this.hwo.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gJU = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.hwp = new d(this.dYz, this.dYz.getPageContext().getContext());
        this.gJU.setAdapter((ListAdapter) this.hwp);
        this.hwq = View.inflate(this.dYz.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.gJU.addHeaderView(this.hwq);
        this.gJU.addFooterView(this.hwq);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.hwp.setData(list);
        cL(list);
    }

    public void onChangeSkinType(int i) {
        this.dYz.getLayoutMode().setNightMode(i == 1);
        this.dYz.getLayoutMode().onModeChanged(this.mRoot);
        this.hwo.onChangeSkinType(this.dYz.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.gJU.setOnSrollToBottomListener(eVar);
    }

    public boolean bSR() {
        return this.hwp.getCount() != 0 && this.gJU.getLastVisiblePosition() - this.gJU.getHeaderViewsCount() < this.hwp.getCount() + (-1);
    }

    public void cL(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cM(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.dYz.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.lh(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.dYz.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
