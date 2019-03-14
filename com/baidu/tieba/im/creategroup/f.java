package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button gft;
    Button gfu;
    TextView gfv;
    TextView gfw;
    CreateGroupMainActivity gfx;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bqX() {
        return this.gft;
    }

    public View bqY() {
        return this.gfu;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.gft = null;
        this.gfu = null;
        this.gfv = null;
        this.gfw = null;
        this.gfx = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.gft.setOnClickListener(createGroupMainActivity);
        this.gfu.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.gft.setEnabled(z2);
        this.gfu.setEnabled(z);
        this.gfv.setText(str2);
        this.gfw.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.gfx = createGroupMainActivity;
        createGroupMainActivity.setContentView(d.h.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(d.g.parent);
        this.gft = (Button) createGroupMainActivity.findViewById(d.g.create_group1);
        this.gfu = (Button) createGroupMainActivity.findViewById(d.g.create_group2);
        this.gfv = (TextView) createGroupMainActivity.findViewById(d.g.create_group1_text);
        this.gfw = (TextView) createGroupMainActivity.findViewById(d.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(d.j.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.gfx.getLayoutMode().setNightMode(i == 1);
        this.gfx.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
