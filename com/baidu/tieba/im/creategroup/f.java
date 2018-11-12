package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button eEX;
    Button eEY;
    TextView eEZ;
    TextView eFa;
    CreateGroupMainActivity eFb;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aNn() {
        return this.eEX;
    }

    public View aNo() {
        return this.eEY;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.eEX = null;
        this.eEY = null;
        this.eEZ = null;
        this.eFa = null;
        this.eFb = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.eEX.setOnClickListener(createGroupMainActivity);
        this.eEY.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.eEX.setEnabled(z2);
        this.eEY.setEnabled(z);
        this.eEZ.setText(str2);
        this.eFa.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.eFb = createGroupMainActivity;
        createGroupMainActivity.setContentView(e.h.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(e.g.parent);
        this.eEX = (Button) createGroupMainActivity.findViewById(e.g.create_group1);
        this.eEY = (Button) createGroupMainActivity.findViewById(e.g.create_group2);
        this.eEZ = (TextView) createGroupMainActivity.findViewById(e.g.create_group1_text);
        this.eFa = (TextView) createGroupMainActivity.findViewById(e.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(e.j.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.eFb.getLayoutMode().setNightMode(i == 1);
        this.eFb.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
