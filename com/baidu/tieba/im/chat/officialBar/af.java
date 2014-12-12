package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.g<OfficialBarHistoryActivity> {
    private BaseActivity Ud;
    private ad aTj;
    private View aTk;
    private BdListView ats;
    private NavigationBar att;
    private View mRoot;

    public af(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.Ud = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.Ud.getPageContext().getContext(), com.baidu.tieba.x.official_bar_history_activity, null);
        this.Ud.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.att = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.att.setTitleText(com.baidu.tieba.z.officical_bar_info_history);
        this.att.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ats = (BdListView) this.mRoot.findViewById(com.baidu.tieba.w.bar_history_list);
        this.aTj = new ad(this.Ud, this.Ud.getPageContext().getContext());
        this.ats.setAdapter((ListAdapter) this.aTj);
        this.aTk = View.inflate(this.Ud.getPageContext().getContext(), com.baidu.tieba.x.official_bar_history_item_occupy, null);
        this.ats.addHeaderView(this.aTk);
        this.ats.addFooterView(this.aTk);
    }

    public void setData(List<aq> list) {
        this.aTj.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.Ud.getLayoutMode().ab(i == 1);
        this.Ud.getLayoutMode().h(this.mRoot);
        this.att.onChangeSkinType(this.Ud.getPageContext(), i);
    }

    public void b(com.baidu.adp.widget.ListView.ab abVar) {
        this.ats.setOnSrollToBottomListener(abVar);
    }

    public boolean KE() {
        return this.aTj.getCount() != 0 && this.ats.getLastVisiblePosition() < this.aTj.getCount() + (-1);
    }
}
