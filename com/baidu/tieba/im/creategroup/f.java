package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button jtc;
    Button jtd;
    TextView jte;
    TextView jtf;
    CreateGroupMainActivity jtg;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cGv() {
        return this.jtc;
    }

    public View cGw() {
        return this.jtd;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.jtc = null;
        this.jtd = null;
        this.jte = null;
        this.jtf = null;
        this.jtg = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.jtc.setOnClickListener(createGroupMainActivity);
        this.jtd.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.jtc.setEnabled(z2);
        this.jtd.setEnabled(z);
        this.jte.setText(str2);
        this.jtf.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.jtg = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.jtc = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.jtd = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.jte = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.jtf = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.jtg.getLayoutMode().setNightMode(i == 1);
        this.jtg.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
