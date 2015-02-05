package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.g<UpdatesActivity> {
    private View back;
    private UpdatesActivity bhj;
    private h bhs;
    private Button btn_cancel;
    private Button btn_delete;
    private Button btn_edit;
    private View leftView;
    private NavigationBar mNavigationBar;
    private View parent;
    private ProgressBar pro_load;
    private View rightView;
    private BdListView updates_list;

    public p(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.bhj = updatesActivity;
        initView();
        this.bhs = new h(this.bhj);
        this.updates_list.setAdapter((ListAdapter) this.bhs);
        this.updates_list.setOnScrollListener(this.bhj);
    }

    void initView() {
        this.parent = View.inflate(this.bhj.getPageContext().getPageActivity(), x.updates_activity, null);
        this.bhj.setContentView(this.parent);
        this.mNavigationBar = (NavigationBar) this.bhj.findViewById(w.view_navigation_bar);
        this.back = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bhj.getPageContext().getString(z.updates_activity_title));
        this.leftView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, x.updates_activity_nav_left, (View.OnClickListener) null);
        this.rightView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.updates_activity_nav_right, (View.OnClickListener) null);
        this.btn_delete = (Button) this.leftView.findViewById(w.btn_delete);
        this.btn_delete.setOnClickListener(this.bhj);
        this.back.setOnClickListener(this.bhj);
        this.updates_list = (BdListView) this.parent.findViewById(w.updates_list);
        this.pro_load = (ProgressBar) this.parent.findViewById(w.pro_load);
        this.btn_edit = (Button) this.rightView.findViewById(w.btn_edit);
        this.btn_edit.setOnClickListener(this.bhj);
        this.btn_cancel = (Button) this.rightView.findViewById(w.btn_cancel);
        this.btn_cancel.setOnClickListener(this.bhj);
        setDelCount(0);
        setLoadProgressBarVisable(false);
    }

    @Override // com.baidu.adp.base.g
    public void destroy() {
        super.destroy();
        if (this.bhs != null) {
            this.bhs.destroy();
            this.bhs = null;
        }
        this.bhj = null;
    }

    public h Qp() {
        return this.bhs;
    }

    public void changeToEditMode() {
        this.btn_edit.setVisibility(8);
        this.back.setVisibility(8);
        this.btn_cancel.setVisibility(0);
        this.leftView.setVisibility(0);
        refreshList();
    }

    public void cancelEditMode() {
        this.btn_edit.setVisibility(0);
        this.back.setVisibility(0);
        this.btn_cancel.setVisibility(8);
        this.leftView.setVisibility(8);
        setDelCount(0);
        refreshList();
    }

    public void refreshList() {
        if (this.bhs != null) {
            this.bhs.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.bhs != null) {
            this.bhs.setData(list);
        }
    }

    public void setDelCount(int i) {
        if (this.btn_delete != null && this.bhj != null) {
            this.btn_delete.setText(String.format(this.bhj.getPageContext().getString(z.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.btn_delete.setEnabled(false);
            } else {
                this.btn_delete.setEnabled(true);
            }
        }
    }

    public void setLoadProgressBarVisable(boolean z) {
        this.pro_load.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.bhj.getLayoutMode().ab(i == 1);
        this.bhj.getLayoutMode().h(this.parent);
        this.mNavigationBar.onChangeSkinType(this.bhj.getPageContext(), i);
    }

    public View getBack() {
        return this.back;
    }

    public BdListView getValidate_list() {
        return this.updates_list;
    }

    public Button getBtn_edit() {
        return this.btn_edit;
    }

    public Button getBtn_cancel() {
        return this.btn_cancel;
    }

    public Button getBtn_delete() {
        return this.btn_delete;
    }
}
