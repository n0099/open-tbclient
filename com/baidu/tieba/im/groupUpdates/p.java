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
    private UpdatesActivity bhk;
    private h bht;
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
        this.bhk = updatesActivity;
        initView();
        this.bht = new h(this.bhk);
        this.updates_list.setAdapter((ListAdapter) this.bht);
        this.updates_list.setOnScrollListener(this.bhk);
    }

    void initView() {
        this.parent = View.inflate(this.bhk.getPageContext().getPageActivity(), x.updates_activity, null);
        this.bhk.setContentView(this.parent);
        this.mNavigationBar = (NavigationBar) this.bhk.findViewById(w.view_navigation_bar);
        this.back = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bhk.getPageContext().getString(z.updates_activity_title));
        this.leftView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, x.updates_activity_nav_left, (View.OnClickListener) null);
        this.rightView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.updates_activity_nav_right, (View.OnClickListener) null);
        this.btn_delete = (Button) this.leftView.findViewById(w.btn_delete);
        this.btn_delete.setOnClickListener(this.bhk);
        this.back.setOnClickListener(this.bhk);
        this.updates_list = (BdListView) this.parent.findViewById(w.updates_list);
        this.pro_load = (ProgressBar) this.parent.findViewById(w.pro_load);
        this.btn_edit = (Button) this.rightView.findViewById(w.btn_edit);
        this.btn_edit.setOnClickListener(this.bhk);
        this.btn_cancel = (Button) this.rightView.findViewById(w.btn_cancel);
        this.btn_cancel.setOnClickListener(this.bhk);
        setDelCount(0);
        setLoadProgressBarVisable(false);
    }

    @Override // com.baidu.adp.base.g
    public void destroy() {
        super.destroy();
        if (this.bht != null) {
            this.bht.destroy();
            this.bht = null;
        }
        this.bhk = null;
    }

    public h Qu() {
        return this.bht;
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
        if (this.bht != null) {
            this.bht.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.bht != null) {
            this.bht.setData(list);
        }
    }

    public void setDelCount(int i) {
        if (this.btn_delete != null && this.bhk != null) {
            this.btn_delete.setText(String.format(this.bhk.getPageContext().getString(z.del_count), Integer.valueOf(i)));
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
        this.bhk.getLayoutMode().ab(i == 1);
        this.bhk.getLayoutMode().h(this.parent);
        this.mNavigationBar.onChangeSkinType(this.bhk.getPageContext(), i);
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
