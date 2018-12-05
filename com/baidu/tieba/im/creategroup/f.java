package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button eLM;
    Button eLN;
    TextView eLO;
    TextView eLP;
    CreateGroupMainActivity eLQ;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aPf() {
        return this.eLM;
    }

    public View aPg() {
        return this.eLN;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.eLM = null;
        this.eLN = null;
        this.eLO = null;
        this.eLP = null;
        this.eLQ = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.eLM.setOnClickListener(createGroupMainActivity);
        this.eLN.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.eLM.setEnabled(z2);
        this.eLN.setEnabled(z);
        this.eLO.setText(str2);
        this.eLP.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.eLQ = createGroupMainActivity;
        createGroupMainActivity.setContentView(e.h.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(e.g.parent);
        this.eLM = (Button) createGroupMainActivity.findViewById(e.g.create_group1);
        this.eLN = (Button) createGroupMainActivity.findViewById(e.g.create_group2);
        this.eLO = (TextView) createGroupMainActivity.findViewById(e.g.create_group1_text);
        this.eLP = (TextView) createGroupMainActivity.findViewById(e.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(e.j.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.eLQ.getLayoutMode().setNightMode(i == 1);
        this.eLQ.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
