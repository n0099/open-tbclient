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
    private BaseActivity dYj;
    private BdListView gIP;
    private NavigationBar huO;
    private d huP;
    private View huQ;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dYj = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.dYj.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.dYj.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.huO = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.huO.setTitleText(R.string.officical_bar_info_history);
        this.huO.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gIP = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.huP = new d(this.dYj, this.dYj.getPageContext().getContext());
        this.gIP.setAdapter((ListAdapter) this.huP);
        this.huQ = View.inflate(this.dYj.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.gIP.addHeaderView(this.huQ);
        this.gIP.addFooterView(this.huQ);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.huP.setData(list);
        cL(list);
    }

    public void onChangeSkinType(int i) {
        this.dYj.getLayoutMode().setNightMode(i == 1);
        this.dYj.getLayoutMode().onModeChanged(this.mRoot);
        this.huO.onChangeSkinType(this.dYj.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.gIP.setOnSrollToBottomListener(eVar);
    }

    public boolean bSz() {
        return this.huP.getCount() != 0 && this.gIP.getLastVisiblePosition() - this.gIP.getHeaderViewsCount() < this.huP.getCount() + (-1);
    }

    public void cL(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cM(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.dYj.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.lh(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.dYj.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
