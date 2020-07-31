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
    private BaseActivity fbZ;
    private NavigationBar iTu;
    private e iTv;
    private View iTw;
    private BdListView idL;
    private NoDataView mNoDataView;
    private View mRoot;

    public f(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fbZ = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.fbZ.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.fbZ.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.iTu = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.iTu.setTitleText(R.string.officical_bar_info_history);
        this.iTu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.idL = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.iTv = new e(this.fbZ, this.fbZ.getPageContext().getContext());
        this.idL.setAdapter((ListAdapter) this.iTv);
        this.iTw = View.inflate(this.fbZ.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.idL.addHeaderView(this.iTw);
        this.idL.addFooterView(this.iTw);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.iTv.setData(list);
        m36do(list);
    }

    public void onChangeSkinType(int i) {
        this.fbZ.getLayoutMode().setNightMode(i == 1);
        this.fbZ.getLayoutMode().onModeChanged(this.mRoot);
        this.iTu.onChangeSkinType(this.fbZ.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.idL.setOnSrollToBottomListener(eVar);
    }

    public boolean crp() {
        return this.iTv.getCount() != 0 && this.idL.getLastVisiblePosition() - this.idL.getHeaderViewsCount() < this.iTv.getCount() + (-1);
    }

    /* renamed from: do  reason: not valid java name */
    public void m36do(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dp(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.fbZ.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.mF(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.fbZ.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
