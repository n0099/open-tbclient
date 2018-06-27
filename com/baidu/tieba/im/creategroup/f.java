package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button ekH;
    Button ekI;
    TextView ekJ;
    TextView ekK;
    CreateGroupMainActivity ekL;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aHo() {
        return this.ekH;
    }

    public View aHp() {
        return this.ekI;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.ekH = null;
        this.ekI = null;
        this.ekJ = null;
        this.ekK = null;
        this.ekL = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.ekH.setOnClickListener(createGroupMainActivity);
        this.ekI.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.ekH.setEnabled(z2);
        this.ekI.setEnabled(z);
        this.ekJ.setText(str2);
        this.ekK.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.ekL = createGroupMainActivity;
        createGroupMainActivity.setContentView(d.i.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(d.g.parent);
        this.ekH = (Button) createGroupMainActivity.findViewById(d.g.create_group1);
        this.ekI = (Button) createGroupMainActivity.findViewById(d.g.create_group2);
        this.ekJ = (TextView) createGroupMainActivity.findViewById(d.g.create_group1_text);
        this.ekK = (TextView) createGroupMainActivity.findViewById(d.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(d.k.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.ekL.getLayoutMode().setNightMode(i == 1);
        this.ekL.getLayoutMode().onModeChanged(this.mParent);
        am.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
