package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button gCH;
    Button gCI;
    TextView gCJ;
    TextView gCK;
    CreateGroupMainActivity gCL;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bBp() {
        return this.gCH;
    }

    public View bBq() {
        return this.gCI;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.gCH = null;
        this.gCI = null;
        this.gCJ = null;
        this.gCK = null;
        this.gCL = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.gCH.setOnClickListener(createGroupMainActivity);
        this.gCI.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.gCH.setEnabled(z2);
        this.gCI.setEnabled(z);
        this.gCJ.setText(str2);
        this.gCK.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.gCL = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.gCH = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.gCI = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.gCJ = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.gCK = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.gCL.getLayoutMode().setNightMode(i == 1);
        this.gCL.getLayoutMode().onModeChanged(this.mParent);
        am.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
