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
    private BaseActivity eNm;
    private BdListView hKx;
    private NavigationBar ivD;
    private d ivE;
    private View ivF;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eNm = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.eNm.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.eNm.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.ivD = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.ivD.setTitleText(R.string.officical_bar_info_history);
        this.ivD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hKx = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.ivE = new d(this.eNm, this.eNm.getPageContext().getContext());
        this.hKx.setAdapter((ListAdapter) this.ivE);
        this.ivF = View.inflate(this.eNm.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.hKx.addHeaderView(this.ivF);
        this.hKx.addFooterView(this.ivF);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.ivE.setData(list);
        cV(list);
    }

    public void onChangeSkinType(int i) {
        this.eNm.getLayoutMode().setNightMode(i == 1);
        this.eNm.getLayoutMode().onModeChanged(this.mRoot);
        this.ivD.onChangeSkinType(this.eNm.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.hKx.setOnSrollToBottomListener(eVar);
    }

    public boolean cjW() {
        return this.ivE.getCount() != 0 && this.hKx.getLastVisiblePosition() - this.hKx.getHeaderViewsCount() < this.ivE.getCount() + (-1);
    }

    public void cV(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cW(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.eNm.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.lV(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.eNm.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
