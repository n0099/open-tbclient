package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    TextView jkA;
    TextView jkB;
    CreateGroupMainActivity jkC;
    Button jky;
    Button jkz;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cCP() {
        return this.jky;
    }

    public View cCQ() {
        return this.jkz;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.jky = null;
        this.jkz = null;
        this.jkA = null;
        this.jkB = null;
        this.jkC = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.jky.setOnClickListener(createGroupMainActivity);
        this.jkz.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.jky.setEnabled(z2);
        this.jkz.setEnabled(z);
        this.jkA.setText(str2);
        this.jkB.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.jkC = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.jky = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.jkz = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.jkA = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.jkB = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.jkC.getLayoutMode().setNightMode(i == 1);
        this.jkC.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
