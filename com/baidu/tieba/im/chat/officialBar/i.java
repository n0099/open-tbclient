package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public class i extends com.baidu.adp.base.c<OfficialBarHistoryActivity> {
    private View aHT;
    private BdListView eyn;
    private NavigationBar eyo;
    private h eyp;
    private View eyq;
    private BaseActivity mContext;
    private com.baidu.tbadk.core.view.h mNoDataView;

    public i(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity;
        initView();
    }

    private void initView() {
        this.aHT = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_activity, null);
        this.mContext.getPageContext().getPageActivity().setContentView(this.aHT);
        this.eyo = (NavigationBar) this.aHT.findViewById(d.g.view_navigation_bar);
        this.eyo.setTitleText(d.j.officical_bar_info_history);
        this.eyo.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eyn = (BdListView) this.aHT.findViewById(d.g.bar_history_list);
        this.eyp = new h(this.mContext, this.mContext.getPageContext().getContext());
        this.eyn.setAdapter((ListAdapter) this.eyp);
        this.eyq = View.inflate(this.mContext.getPageContext().getContext(), d.h.official_bar_history_item_occupy, null);
        this.eyn.addHeaderView(this.eyq);
        this.eyn.addFooterView(this.eyq);
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.eyp.setData(list);
        bW(list);
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().aQ(i == 1);
        this.mContext.getLayoutMode().aM(this.aHT);
        this.eyo.onChangeSkinType(this.mContext.getPageContext(), i);
    }

    public void c(BdListView.e eVar) {
        this.eyn.setOnSrollToBottomListener(eVar);
    }

    public boolean aGj() {
        return this.eyp.getCount() != 0 && this.eyn.getLastVisiblePosition() - this.eyn.getHeaderViewsCount() < this.eyp.getCount() + (-1);
    }

    public void bW(List<ResponseHistoryMessage.a> list) {
        if (list != null && list.size() > 0 && this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void bX(List<ResponseHistoryMessage.a> list) {
        if (list == null || list.size() == 0) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageContext().getPageActivity(), this.aHT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, HttpStatus.SC_BAD_REQUEST), NoDataViewFactory.d.gp(d.j.no_data_text), null);
            }
            this.mNoDataView.onChangeSkinType(this.mContext.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
        }
    }
}
