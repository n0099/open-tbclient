package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.g<UpdatesActivity> {
    private View back;
    private UpdatesActivity biP;
    private h biY;
    private Button btn_cancel;
    private Button btn_delete;
    private Button btn_edit;
    private View leftView;
    private NavigationBar mNavigationBar;
    private View parent;
    private ProgressBar pro_load;
    private View rightView;
    private BdListView updates_list;

    public s(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.biP = updatesActivity;
        initView();
        this.biY = new h(this.biP);
        this.updates_list.setAdapter((ListAdapter) this.biY);
        this.updates_list.setOnScrollListener(this.biP);
    }

    void initView() {
        this.parent = View.inflate(this.biP.getPageContext().getPageActivity(), w.updates_activity, null);
        this.biP.setContentView(this.parent);
        this.mNavigationBar = (NavigationBar) this.biP.findViewById(v.view_navigation_bar);
        this.back = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.biP.getPageContext().getString(y.updates_activity_title));
        this.leftView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.updates_activity_nav_left, (View.OnClickListener) null);
        this.rightView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.updates_activity_nav_right, (View.OnClickListener) null);
        this.btn_delete = (Button) this.leftView.findViewById(v.btn_delete);
        this.btn_delete.setOnClickListener(this.biP);
        this.back.setOnClickListener(this.biP);
        this.updates_list = (BdListView) this.parent.findViewById(v.updates_list);
        this.pro_load = (ProgressBar) this.parent.findViewById(v.pro_load);
        this.btn_edit = (Button) this.rightView.findViewById(v.btn_edit);
        this.btn_edit.setOnClickListener(this.biP);
        this.btn_cancel = (Button) this.rightView.findViewById(v.btn_cancel);
        this.btn_cancel.setOnClickListener(this.biP);
        setDelCount(0);
        setLoadProgressBarVisable(false);
    }

    @Override // com.baidu.adp.base.g
    public void destroy() {
        super.destroy();
        if (this.biY != null) {
            this.biY.destroy();
            this.biY = null;
        }
        this.biP = null;
    }

    public h RW() {
        return this.biY;
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
        if (this.biY != null) {
            this.biY.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.biY != null) {
            this.biY.setData(list);
        }
    }

    public void setDelCount(int i) {
        if (this.btn_delete != null && this.biP != null) {
            this.btn_delete.setText(String.format(this.biP.getPageContext().getString(y.del_count), Integer.valueOf(i)));
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
        this.biP.getLayoutMode().X(i == 1);
        this.biP.getLayoutMode().h(this.parent);
        this.mNavigationBar.onChangeSkinType(this.biP.getPageContext(), i);
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
