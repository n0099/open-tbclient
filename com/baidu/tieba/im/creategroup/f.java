package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button dUu;
    Button dUv;
    TextView dUw;
    TextView dUx;
    CreateGroupMainActivity dUy;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aBO() {
        return this.dUu;
    }

    public View aBP() {
        return this.dUv;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.dUu = null;
        this.dUv = null;
        this.dUw = null;
        this.dUx = null;
        this.dUy = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.dUu.setOnClickListener(createGroupMainActivity);
        this.dUv.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.dUu.setEnabled(z2);
        this.dUv.setEnabled(z);
        this.dUw.setText(str2);
        this.dUx.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.dUy = createGroupMainActivity;
        createGroupMainActivity.setContentView(d.i.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(d.g.parent);
        this.dUu = (Button) createGroupMainActivity.findViewById(d.g.create_group1);
        this.dUv = (Button) createGroupMainActivity.findViewById(d.g.create_group2);
        this.dUw = (TextView) createGroupMainActivity.findViewById(d.g.create_group1_text);
        this.dUx = (TextView) createGroupMainActivity.findViewById(d.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(d.k.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.dUy.getLayoutMode().setNightMode(i == 1);
        this.dUy.getLayoutMode().u(this.mParent);
        ak.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
