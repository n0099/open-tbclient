package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button iOo;
    Button iOp;
    TextView iOq;
    TextView iOr;
    CreateGroupMainActivity iOs;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cos() {
        return this.iOo;
    }

    public View cot() {
        return this.iOp;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.iOo = null;
        this.iOp = null;
        this.iOq = null;
        this.iOr = null;
        this.iOs = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.iOo.setOnClickListener(createGroupMainActivity);
        this.iOp.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.iOo.setEnabled(z2);
        this.iOp.setEnabled(z);
        this.iOq.setText(str2);
        this.iOr.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.iOs = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.iOo = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.iOp = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.iOq = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.iOr = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.iOs.getLayoutMode().setNightMode(i == 1);
        this.iOs.getLayoutMode().onModeChanged(this.mParent);
        an.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
