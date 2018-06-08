package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button egO;
    Button egP;
    TextView egQ;
    TextView egR;
    CreateGroupMainActivity egS;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aGH() {
        return this.egO;
    }

    public View aGI() {
        return this.egP;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.egO = null;
        this.egP = null;
        this.egQ = null;
        this.egR = null;
        this.egS = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.egO.setOnClickListener(createGroupMainActivity);
        this.egP.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.egO.setEnabled(z2);
        this.egP.setEnabled(z);
        this.egQ.setText(str2);
        this.egR.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.egS = createGroupMainActivity;
        createGroupMainActivity.setContentView(d.i.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(d.g.parent);
        this.egO = (Button) createGroupMainActivity.findViewById(d.g.create_group1);
        this.egP = (Button) createGroupMainActivity.findViewById(d.g.create_group2);
        this.egQ = (TextView) createGroupMainActivity.findViewById(d.g.create_group1_text);
        this.egR = (TextView) createGroupMainActivity.findViewById(d.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(d.k.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.egS.getLayoutMode().setNightMode(i == 1);
        this.egS.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
