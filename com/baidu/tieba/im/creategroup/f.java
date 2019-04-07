package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button gfh;
    Button gfi;
    TextView gfj;
    TextView gfk;
    CreateGroupMainActivity gfl;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bqU() {
        return this.gfh;
    }

    public View bqV() {
        return this.gfi;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.gfh = null;
        this.gfi = null;
        this.gfj = null;
        this.gfk = null;
        this.gfl = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.gfh.setOnClickListener(createGroupMainActivity);
        this.gfi.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.gfh.setEnabled(z2);
        this.gfi.setEnabled(z);
        this.gfj.setText(str2);
        this.gfk.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.gfl = createGroupMainActivity;
        createGroupMainActivity.setContentView(d.h.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(d.g.parent);
        this.gfh = (Button) createGroupMainActivity.findViewById(d.g.create_group1);
        this.gfi = (Button) createGroupMainActivity.findViewById(d.g.create_group2);
        this.gfj = (TextView) createGroupMainActivity.findViewById(d.g.create_group1_text);
        this.gfk = (TextView) createGroupMainActivity.findViewById(d.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(d.j.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.gfl.getLayoutMode().setNightMode(i == 1);
        this.gfl.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
