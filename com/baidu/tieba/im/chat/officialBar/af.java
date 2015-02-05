package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.g<OfficialBarHistoryActivity> {
    private BaseActivity UG;
    private ad aUy;
    private View aUz;
    private BdListView auo;
    private NavigationBar aup;
    private View mRoot;

    public af(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.UG = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.UG.getPageContext().getContext(), com.baidu.tieba.x.official_bar_history_activity, null);
        this.UG.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.aup = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.aup.setTitleText(com.baidu.tieba.z.officical_bar_info_history);
        this.aup.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.auo = (BdListView) this.mRoot.findViewById(com.baidu.tieba.w.bar_history_list);
        this.aUy = new ad(this.UG, this.UG.getPageContext().getContext());
        this.auo.setAdapter((ListAdapter) this.aUy);
        this.aUz = View.inflate(this.UG.getPageContext().getContext(), com.baidu.tieba.x.official_bar_history_item_occupy, null);
        this.auo.addHeaderView(this.aUz);
        this.auo.addFooterView(this.aUz);
    }

    public void setData(List<aq> list) {
        this.aUy.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.UG.getLayoutMode().ab(i == 1);
        this.UG.getLayoutMode().h(this.mRoot);
        this.aup.onChangeSkinType(this.UG.getPageContext(), i);
    }

    public void b(com.baidu.adp.widget.ListView.ab abVar) {
        this.auo.setOnSrollToBottomListener(abVar);
    }

    public boolean KU() {
        return this.aUy.getCount() != 0 && this.auo.getLastVisiblePosition() < this.aUy.getCount() + (-1);
    }
}
