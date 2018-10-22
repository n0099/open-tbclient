package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button eDE;
    Button eDF;
    TextView eDG;
    TextView eDH;
    CreateGroupMainActivity eDI;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aNQ() {
        return this.eDE;
    }

    public View aNR() {
        return this.eDF;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.eDE = null;
        this.eDF = null;
        this.eDG = null;
        this.eDH = null;
        this.eDI = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.eDE.setOnClickListener(createGroupMainActivity);
        this.eDF.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.eDE.setEnabled(z2);
        this.eDF.setEnabled(z);
        this.eDG.setText(str2);
        this.eDH.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.eDI = createGroupMainActivity;
        createGroupMainActivity.setContentView(e.h.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(e.g.parent);
        this.eDE = (Button) createGroupMainActivity.findViewById(e.g.create_group1);
        this.eDF = (Button) createGroupMainActivity.findViewById(e.g.create_group2);
        this.eDG = (TextView) createGroupMainActivity.findViewById(e.g.create_group1_text);
        this.eDH = (TextView) createGroupMainActivity.findViewById(e.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(e.j.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.eDI.getLayoutMode().setNightMode(i == 1);
        this.eDI.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
