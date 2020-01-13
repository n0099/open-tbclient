package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button huh;
    Button hui;
    TextView huj;
    TextView huk;
    CreateGroupMainActivity hul;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bRA() {
        return this.huh;
    }

    public View bRB() {
        return this.hui;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.huh = null;
        this.hui = null;
        this.huj = null;
        this.huk = null;
        this.hul = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.huh.setOnClickListener(createGroupMainActivity);
        this.hui.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.huh.setEnabled(z2);
        this.hui.setEnabled(z);
        this.huj.setText(str2);
        this.huk.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.hul = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.huh = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.hui = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.huj = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.huk = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.hul.getLayoutMode().setNightMode(i == 1);
        this.hul.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
