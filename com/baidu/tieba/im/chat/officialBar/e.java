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
    private BdListView fIU;
    private NavigationBar guO;
    private d guP;
    private View guQ;
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
        this.guO = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.guO.setTitleText(R.string.officical_bar_info_history);
        this.guO.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fIU = (BdListView) this.bBg.findViewById(R.id.bar_history_list);
        this.guP = new d(this.mContext, this.mContext.getPageContext().getContext());
        this.fIU.setAdapter((ListAdapter) this.guP);
        this.guQ = View.inflate(this.mContext.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
        this.fIU.addHeaderView(this.guQ);
        this.fIU.addFooterView(this.guQ);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.guP.setData(list);
        cM(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.bBg);
        this.guO.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void d(BdListView.e eVar) {
        this.fIU.setOnSrollToBottomListener(eVar);
    }

    public boolean byf() {
        return this.guP.getCount() != 0 && this.fIU.getLastVisiblePosition() - this.fIU.getHeaderViewsCount() < this.guP.getCount() + (-1);
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
