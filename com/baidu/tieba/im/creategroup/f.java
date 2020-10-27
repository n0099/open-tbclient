package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    TextView jUA;
    TextView jUB;
    CreateGroupMainActivity jUC;
    Button jUy;
    Button jUz;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cNl() {
        return this.jUy;
    }

    public View cNm() {
        return this.jUz;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.jUy = null;
        this.jUz = null;
        this.jUA = null;
        this.jUB = null;
        this.jUC = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.jUy.setOnClickListener(createGroupMainActivity);
        this.jUz.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.jUy.setEnabled(z2);
        this.jUz.setEnabled(z);
        this.jUA.setText(str2);
        this.jUB.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.jUC = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.jUy = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.jUz = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.jUA = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.jUB = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.jUC.getLayoutMode().setNightMode(i == 1);
        this.jUC.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
