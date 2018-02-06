package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button ezP;
    Button ezQ;
    TextView ezR;
    TextView ezS;
    CreateGroupMainActivity ezT;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aGO() {
        return this.ezP;
    }

    public View aGP() {
        return this.ezQ;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.ezP = null;
        this.ezQ = null;
        this.ezR = null;
        this.ezS = null;
        this.ezT = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.ezP.setOnClickListener(createGroupMainActivity);
        this.ezQ.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.ezP.setEnabled(z2);
        this.ezQ.setEnabled(z);
        this.ezR.setText(str2);
        this.ezS.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.ezT = createGroupMainActivity;
        createGroupMainActivity.setContentView(d.h.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(d.g.parent);
        this.ezP = (Button) createGroupMainActivity.findViewById(d.g.create_group1);
        this.ezQ = (Button) createGroupMainActivity.findViewById(d.g.create_group2);
        this.ezR = (TextView) createGroupMainActivity.findViewById(d.g.create_group1_text);
        this.ezS = (TextView) createGroupMainActivity.findViewById(d.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(d.j.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.ezT.getLayoutMode().aQ(i == 1);
        this.ezT.getLayoutMode().aM(this.mParent);
        aj.o(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
