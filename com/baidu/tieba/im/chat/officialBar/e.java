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
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.base.d<OfficialBarHistoryActivity> {
    private BaseActivity ghP;
    private BdListView jKf;
    private NavigationBar kFk;
    private d kFl;
    private View kFm;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ghP = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.ghP.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.ghP.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.kFk = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.kFk.setTitleText(R.string.officical_bar_info_history);
        this.kFk.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jKf = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.kFl = new d(this.ghP, this.ghP.getPageContext().getContext());
        this.jKf.setAdapter((ListAdapter) this.kFl);
        this.kFm = View.inflate(this.ghP.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.jKf.addHeaderView(this.kFm);
        this.jKf.addFooterView(this.kFm);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.kFl.setData(list);
        en(list);
    }

    public void onChangeSkinType(int i) {
        this.ghP.getLayoutMode().setNightMode(i == 1);
        this.ghP.getLayoutMode().onModeChanged(this.mRoot);
        this.kFk.onChangeSkinType(this.ghP.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.jKf.setOnSrollToBottomListener(eVar);
    }

    public boolean cVh() {
        return this.kFl.getCount() != 0 && this.jKf.getLastVisiblePosition() - this.jKf.getHeaderViewsCount() < this.kFl.getCount() + (-1);
    }

    public void en(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void eo(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.ghP.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.pA(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.ghP.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
