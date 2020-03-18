package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button hxU;
    Button hxV;
    TextView hxW;
    TextView hxX;
    CreateGroupMainActivity hxY;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bTw() {
        return this.hxU;
    }

    public View bTx() {
        return this.hxV;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.hxU = null;
        this.hxV = null;
        this.hxW = null;
        this.hxX = null;
        this.hxY = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.hxU.setOnClickListener(createGroupMainActivity);
        this.hxV.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.hxU.setEnabled(z2);
        this.hxV.setEnabled(z);
        this.hxW.setText(str2);
        this.hxX.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.hxY = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.hxU = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.hxV = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.hxW = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.hxX = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.hxY.getLayoutMode().setNightMode(i == 1);
        this.hxY.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
