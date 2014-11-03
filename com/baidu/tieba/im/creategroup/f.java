package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    CreateGroupMainActivity aTA;
    Button aTw;
    Button aTx;
    TextView aTy;
    TextView aTz;
    View agI;
    private int mForumId;
    NavigationBar mNavigationBar;

    public int getForumId() {
        return this.mForumId;
    }

    public View Lj() {
        return this.aTw;
    }

    public View Lk() {
        return this.aTx;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity);
        this.mNavigationBar = null;
        this.agI = null;
        this.aTw = null;
        this.aTx = null;
        this.aTy = null;
        this.aTz = null;
        this.aTA = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.aTw.setOnClickListener(createGroupMainActivity);
        this.aTx.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.aTw.setEnabled(z2);
        this.aTx.setEnabled(z);
        this.aTy.setText(str2);
        this.aTz.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.aTA = createGroupMainActivity;
        createGroupMainActivity.setContentView(com.baidu.tieba.w.create_group_main_activity);
        this.agI = createGroupMainActivity.findViewById(com.baidu.tieba.v.parent);
        this.aTw = (Button) createGroupMainActivity.findViewById(com.baidu.tieba.v.create_group1);
        this.aTx = (Button) createGroupMainActivity.findViewById(com.baidu.tieba.v.create_group2);
        this.aTy = (TextView) createGroupMainActivity.findViewById(com.baidu.tieba.v.create_group1_text);
        this.aTz = (TextView) createGroupMainActivity.findViewById(com.baidu.tieba.v.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(com.baidu.tieba.y.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.aTA.getLayoutMode().L(i == 1);
        this.aTA.getLayoutMode().h(this.agI);
        aw.d(this.agI, i);
        this.mNavigationBar.onChangeSkinType(i);
    }
}
