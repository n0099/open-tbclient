package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button iVt;
    Button iVu;
    TextView iVv;
    TextView iVw;
    CreateGroupMainActivity iVx;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View crX() {
        return this.iVt;
    }

    public View crY() {
        return this.iVu;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.iVt = null;
        this.iVu = null;
        this.iVv = null;
        this.iVw = null;
        this.iVx = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.iVt.setOnClickListener(createGroupMainActivity);
        this.iVu.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.iVt.setEnabled(z2);
        this.iVu.setEnabled(z);
        this.iVv.setText(str2);
        this.iVw.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.iVx = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.iVt = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.iVu = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.iVv = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.iVw = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.iVx.getLayoutMode().setNightMode(i == 1);
        this.iVx.getLayoutMode().onModeChanged(this.mParent);
        ao.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
