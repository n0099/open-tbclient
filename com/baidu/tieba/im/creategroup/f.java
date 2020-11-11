package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button kau;
    Button kaw;
    TextView kax;
    TextView kay;
    CreateGroupMainActivity kaz;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cPM() {
        return this.kau;
    }

    public View cPN() {
        return this.kaw;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.kau = null;
        this.kaw = null;
        this.kax = null;
        this.kay = null;
        this.kaz = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.kau.setOnClickListener(createGroupMainActivity);
        this.kaw.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.kau.setEnabled(z2);
        this.kaw.setEnabled(z);
        this.kax.setText(str2);
        this.kay.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.kaz = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.kau = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.kaw = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.kax = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.kay = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.kaz.getLayoutMode().setNightMode(i == 1);
        this.kaz.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
