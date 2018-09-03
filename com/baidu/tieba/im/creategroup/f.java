package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    CreateGroupMainActivity eoA;
    Button eow;
    Button eox;
    TextView eoy;
    TextView eoz;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aIl() {
        return this.eow;
    }

    public View aIm() {
        return this.eox;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.eow = null;
        this.eox = null;
        this.eoy = null;
        this.eoz = null;
        this.eoA = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.eow.setOnClickListener(createGroupMainActivity);
        this.eox.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.eow.setEnabled(z2);
        this.eox.setEnabled(z);
        this.eoy.setText(str2);
        this.eoz.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.eoA = createGroupMainActivity;
        createGroupMainActivity.setContentView(f.h.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(f.g.parent);
        this.eow = (Button) createGroupMainActivity.findViewById(f.g.create_group1);
        this.eox = (Button) createGroupMainActivity.findViewById(f.g.create_group2);
        this.eoy = (TextView) createGroupMainActivity.findViewById(f.g.create_group1_text);
        this.eoz = (TextView) createGroupMainActivity.findViewById(f.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(f.j.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.eoA.getLayoutMode().setNightMode(i == 1);
        this.eoA.getLayoutMode().onModeChanged(this.mParent);
        am.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
