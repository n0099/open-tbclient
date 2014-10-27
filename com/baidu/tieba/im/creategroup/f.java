package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    Button aTi;
    Button aTj;
    TextView aTk;
    TextView aTl;
    CreateGroupMainActivity aTm;
    View agA;
    private int mForumId;
    NavigationBar mNavigationBar;

    public int getForumId() {
        return this.mForumId;
    }

    public View Lf() {
        return this.aTi;
    }

    public View Lg() {
        return this.aTj;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity);
        this.mNavigationBar = null;
        this.agA = null;
        this.aTi = null;
        this.aTj = null;
        this.aTk = null;
        this.aTl = null;
        this.aTm = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.aTi.setOnClickListener(createGroupMainActivity);
        this.aTj.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.aTi.setEnabled(z2);
        this.aTj.setEnabled(z);
        this.aTk.setText(str2);
        this.aTl.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.aTm = createGroupMainActivity;
        createGroupMainActivity.setContentView(com.baidu.tieba.w.create_group_main_activity);
        this.agA = createGroupMainActivity.findViewById(com.baidu.tieba.v.parent);
        this.aTi = (Button) createGroupMainActivity.findViewById(com.baidu.tieba.v.create_group1);
        this.aTj = (Button) createGroupMainActivity.findViewById(com.baidu.tieba.v.create_group2);
        this.aTk = (TextView) createGroupMainActivity.findViewById(com.baidu.tieba.v.create_group1_text);
        this.aTl = (TextView) createGroupMainActivity.findViewById(com.baidu.tieba.v.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(com.baidu.tieba.y.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.aTm.getLayoutMode().L(i == 1);
        this.aTm.getLayoutMode().h(this.agA);
        aw.d(this.agA, i);
        this.mNavigationBar.onChangeSkinType(i);
    }
}
