package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    TextView dUA;
    CreateGroupMainActivity dUB;
    Button dUx;
    Button dUy;
    TextView dUz;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aBO() {
        return this.dUx;
    }

    public View aBP() {
        return this.dUy;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.dUx = null;
        this.dUy = null;
        this.dUz = null;
        this.dUA = null;
        this.dUB = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.dUx.setOnClickListener(createGroupMainActivity);
        this.dUy.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.dUx.setEnabled(z2);
        this.dUy.setEnabled(z);
        this.dUz.setText(str2);
        this.dUA.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.dUB = createGroupMainActivity;
        createGroupMainActivity.setContentView(d.i.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(d.g.parent);
        this.dUx = (Button) createGroupMainActivity.findViewById(d.g.create_group1);
        this.dUy = (Button) createGroupMainActivity.findViewById(d.g.create_group2);
        this.dUz = (TextView) createGroupMainActivity.findViewById(d.g.create_group1_text);
        this.dUA = (TextView) createGroupMainActivity.findViewById(d.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(d.k.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.dUB.getLayoutMode().setNightMode(i == 1);
        this.dUB.getLayoutMode().u(this.mParent);
        ak.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
