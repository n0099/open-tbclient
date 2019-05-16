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
    private View bBg;
    private BdListView fIT;
    private NavigationBar guN;
    private d guO;
    private View guP;
    private BaseActivity mContext;
    private NoDataView mNoDataView;

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.bBg = View.inflate(this.mContext.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.bBg);
        this.guN = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.guN.setTitleText(R.string.officical_bar_info_history);
        this.guN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fIT = (BdListView) this.bBg.findViewById(R.id.bar_history_list);
        this.guO = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.fIT.setAdapter((ListAdapter) this.guO);
        this.guP = View.inflate(this.mContext.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.fIT.addHeaderView(this.guP);
        this.fIT.addFooterView(this.guP);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.guO.setData(list);
        cM(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.bBg);
        this.guN.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.fIT.setOnSrollToBottomListener(eVar);
    }

    public boolean byc() {
        return this.guO.getCount() != 0 && this.fIT.getLastVisiblePosition() - this.fIT.getHeaderViewsCount() < this.guO.getCount() + (-1);
    }

    public void cM(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cN(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.d.iH(R.string.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
