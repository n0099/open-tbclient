package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button dVB;
    Button dVC;
    TextView dVD;
    TextView dVE;
    CreateGroupMainActivity dVF;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aBM() {
        return this.dVB;
    }

    public View aBN() {
        return this.dVC;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.dVB = null;
        this.dVC = null;
        this.dVD = null;
        this.dVE = null;
        this.dVF = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.dVB.setOnClickListener(createGroupMainActivity);
        this.dVC.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.dVB.setEnabled(z2);
        this.dVC.setEnabled(z);
        this.dVD.setText(str2);
        this.dVE.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.dVF = createGroupMainActivity;
        createGroupMainActivity.setContentView(d.i.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(d.g.parent);
        this.dVB = (Button) createGroupMainActivity.findViewById(d.g.create_group1);
        this.dVC = (Button) createGroupMainActivity.findViewById(d.g.create_group2);
        this.dVD = (TextView) createGroupMainActivity.findViewById(d.g.create_group1_text);
        this.dVE = (TextView) createGroupMainActivity.findViewById(d.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(d.k.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.dVF.getLayoutMode().setNightMode(i == 1);
        this.dVF.getLayoutMode().u(this.mParent);
        ak.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
