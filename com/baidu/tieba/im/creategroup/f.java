package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    CreateGroupMainActivity gwA;
    Button gww;
    Button gwx;
    TextView gwy;
    TextView gwz;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View byK() {
        return this.gww;
    }

    public View byL() {
        return this.gwx;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.gww = null;
        this.gwx = null;
        this.gwy = null;
        this.gwz = null;
        this.gwA = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.gww.setOnClickListener(createGroupMainActivity);
        this.gwx.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.gww.setEnabled(z2);
        this.gwx.setEnabled(z);
        this.gwy.setText(str2);
        this.gwz.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.gwA = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.gww = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.gwx = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.gwy = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.gwz = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.gwA.getLayoutMode().setNightMode(i == 1);
        this.gwA.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
