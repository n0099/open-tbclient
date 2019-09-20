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
    private BdListView fQy;
    private NavigationBar gDK;
    private d gDL;
    private View gDM;
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
        this.gDK = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.gDK.setTitleText(R.string.officical_bar_info_history);
        this.gDK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fQy = (BdListView) this.mRoot.findViewById(R.id.bar_history_list);
        this.gDL = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.fQy.setAdapter((ListAdapter) this.gDL);
        this.gDM = View.inflate(this.mContext.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.fQy.addHeaderView(this.gDM);
        this.fQy.addFooterView(this.gDM);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.gDL.setData(list);
        cN(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mRoot);
        this.gDK.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.fQy.setOnSrollToBottomListener(eVar);
    }

    public boolean bBM() {
        return this.gDL.getCount() != 0 && this.fQy.getLastVisiblePosition() - this.fQy.getHeaderViewsCount() < this.gDL.getCount() + (-1);
    }

    public void cN(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cO(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.iQ(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
