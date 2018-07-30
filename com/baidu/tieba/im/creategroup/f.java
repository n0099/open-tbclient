package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button eoA;
    Button eoB;
    TextView eoC;
    TextView eoD;
    CreateGroupMainActivity eoE;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aIo() {
        return this.eoA;
    }

    public View aIp() {
        return this.eoB;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.eoA = null;
        this.eoB = null;
        this.eoC = null;
        this.eoD = null;
        this.eoE = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.eoA.setOnClickListener(createGroupMainActivity);
        this.eoB.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.eoA.setEnabled(z2);
        this.eoB.setEnabled(z);
        this.eoC.setText(str2);
        this.eoD.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.eoE = createGroupMainActivity;
        createGroupMainActivity.setContentView(d.h.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(d.g.parent);
        this.eoA = (Button) createGroupMainActivity.findViewById(d.g.create_group1);
        this.eoB = (Button) createGroupMainActivity.findViewById(d.g.create_group2);
        this.eoC = (TextView) createGroupMainActivity.findViewById(d.g.create_group1_text);
        this.eoD = (TextView) createGroupMainActivity.findViewById(d.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(d.j.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.eoE.getLayoutMode().setNightMode(i == 1);
        this.eoE.getLayoutMode().onModeChanged(this.mParent);
        am.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
