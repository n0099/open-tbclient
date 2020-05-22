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
    private BaseActivity eNb;
    private BdListView hJK;
    private NavigationBar iuQ;
    private d iuR;
    private View iuS;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eNb = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.eNb.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.eNb.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.iuQ = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.iuQ.setTitleText(R.string.officical_bar_info_history);
        this.iuQ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hJK = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.iuR = new d(this.eNb, this.eNb.getPageContext().getContext());
        this.hJK.setAdapter((ListAdapter) this.iuR);
        this.iuS = View.inflate(this.eNb.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.hJK.addHeaderView(this.iuS);
        this.hJK.addFooterView(this.iuS);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.iuR.setData(list);
        cU(list);
    }

    public void onChangeSkinType(int i) {
        this.eNb.getLayoutMode().setNightMode(i == 1);
        this.eNb.getLayoutMode().onModeChanged(this.mRoot);
        this.iuQ.onChangeSkinType(this.eNb.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.hJK.setOnSrollToBottomListener(eVar);
    }

    public boolean cjN() {
        return this.iuR.getCount() != 0 && this.hJK.getLastVisiblePosition() - this.hJK.getHeaderViewsCount() < this.iuR.getCount() + (-1);
    }

    public void cU(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cV(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.eNb.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.lT(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.eNb.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
