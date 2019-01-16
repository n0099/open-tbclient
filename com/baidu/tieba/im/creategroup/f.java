package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button ePp;
    Button ePq;
    TextView ePr;
    TextView ePs;
    CreateGroupMainActivity ePt;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aQs() {
        return this.ePp;
    }

    public View aQt() {
        return this.ePq;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.ePp = null;
        this.ePq = null;
        this.ePr = null;
        this.ePs = null;
        this.ePt = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.ePp.setOnClickListener(createGroupMainActivity);
        this.ePq.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.ePp.setEnabled(z2);
        this.ePq.setEnabled(z);
        this.ePr.setText(str2);
        this.ePs.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.ePt = createGroupMainActivity;
        createGroupMainActivity.setContentView(e.h.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(e.g.parent);
        this.ePp = (Button) createGroupMainActivity.findViewById(e.g.create_group1);
        this.ePq = (Button) createGroupMainActivity.findViewById(e.g.create_group2);
        this.ePr = (TextView) createGroupMainActivity.findViewById(e.g.create_group1_text);
        this.ePs = (TextView) createGroupMainActivity.findViewById(e.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(e.j.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.ePt.getLayoutMode().setNightMode(i == 1);
        this.ePt.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
