package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button gCA;
    TextView gCB;
    TextView gCC;
    CreateGroupMainActivity gCD;
    Button gCz;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bza() {
        return this.gCz;
    }

    public View bzb() {
        return this.gCA;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.gCz = null;
        this.gCA = null;
        this.gCB = null;
        this.gCC = null;
        this.gCD = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.gCz.setOnClickListener(createGroupMainActivity);
        this.gCA.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.gCz.setEnabled(z2);
        this.gCA.setEnabled(z);
        this.gCB.setText(str2);
        this.gCC.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.gCD = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.gCz = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.gCA = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.gCB = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.gCC = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.gCD.getLayoutMode().setNightMode(i == 1);
        this.gCD.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
