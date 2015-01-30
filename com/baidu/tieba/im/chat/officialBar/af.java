package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.g<OfficialBarHistoryActivity> {
    private BaseActivity UJ;
    private View aUA;
    private ad aUz;
    private BdListView aur;
    private NavigationBar aus;
    private View mRoot;

    public af(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.UJ = baseActivity;
        initView();
    }

    private void initView() {
        this.mRoot = View.inflate(this.UJ.getPageContext().getContext(), com.baidu.tieba.x.official_bar_history_activity, null);
        this.UJ.getPageContext().getPageActivity().setContentView(this.mRoot);
        this.aus = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.aus.setTitleText(com.baidu.tieba.z.officical_bar_info_history);
        this.aus.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aur = (BdListView) this.mRoot.findViewById(com.baidu.tieba.w.bar_history_list);
        this.aUz = new ad(this.UJ, this.UJ.getPageContext().getContext());
        this.aur.setAdapter((ListAdapter) this.aUz);
        this.aUA = View.inflate(this.UJ.getPageContext().getContext(), com.baidu.tieba.x.official_bar_history_item_occupy, null);
        this.aur.addHeaderView(this.aUA);
        this.aur.addFooterView(this.aUA);
    }

    public void setData(List<aq> list) {
        this.aUz.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.UJ.getLayoutMode().ab(i == 1);
        this.UJ.getLayoutMode().h(this.mRoot);
        this.aus.onChangeSkinType(this.UJ.getPageContext(), i);
    }

    public void b(com.baidu.adp.widget.ListView.ab abVar) {
        this.aur.setOnSrollToBottomListener(abVar);
    }

    public boolean KZ() {
        return this.aUz.getCount() != 0 && this.aur.getLastVisiblePosition() < this.aUz.getCount() + (-1);
    }
}
