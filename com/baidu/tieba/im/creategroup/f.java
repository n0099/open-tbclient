package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button koJ;
    Button koK;
    TextView koL;
    TextView koM;
    CreateGroupMainActivity koN;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cUG() {
        return this.koJ;
    }

    public View cUH() {
        return this.koK;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.koJ = null;
        this.koK = null;
        this.koL = null;
        this.koM = null;
        this.koN = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.koJ.setOnClickListener(createGroupMainActivity);
        this.koK.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.koJ.setEnabled(z2);
        this.koK.setEnabled(z);
        this.koL.setText(str2);
        this.koM.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.koN = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.koJ = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.koK = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.koL = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.koM = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.koN.getLayoutMode().setNightMode(i == 1);
        this.koN.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
