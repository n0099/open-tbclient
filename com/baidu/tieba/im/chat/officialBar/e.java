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
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private BdListView fNU;
    private NavigationBar gBb;
    private d gBc;
    private View gBd;
    private BaseActivity mContext;
    private NoDataView mNoDataView;
    private View mRoot;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.mContext.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.gBb = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.gBb.setTitleText(R.string.officical_bar_info_history);
        this.gBb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fNU = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.gBc = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.fNU.setAdapter((ListAdapter) this.gBc);
        this.gBd = View.inflate(this.mContext.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.fNU.addHeaderView(this.gBd);
        this.fNU.addFooterView(this.gBd);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.gBc.setData(list);
        cO(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mRoot);
        this.gBb.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.fNU.setOnSrollToBottomListener(eVar);
    }

    public boolean bAK() {
        return this.gBc.getCount() != 0 && this.fNU.getLastVisiblePosition() - this.fNU.getHeaderViewsCount() < this.gBc.getCount() + (-1);
    }

    public void cO(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cP(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.iN(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
