package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button ezT;
    Button ezU;
    TextView ezV;
    TextView ezW;
    CreateGroupMainActivity ezX;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View aGO() {
        return this.ezT;
    }

    public View aGP() {
        return this.ezU;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.ezT = null;
        this.ezU = null;
        this.ezV = null;
        this.ezW = null;
        this.ezX = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.ezT.setOnClickListener(createGroupMainActivity);
        this.ezU.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.ezT.setEnabled(z2);
        this.ezU.setEnabled(z);
        this.ezV.setText(str2);
        this.ezW.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.ezX = createGroupMainActivity;
        createGroupMainActivity.setContentView(d.h.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(d.g.parent);
        this.ezT = (Button) createGroupMainActivity.findViewById(d.g.create_group1);
        this.ezU = (Button) createGroupMainActivity.findViewById(d.g.create_group2);
        this.ezV = (TextView) createGroupMainActivity.findViewById(d.g.create_group1_text);
        this.ezW = (TextView) createGroupMainActivity.findViewById(d.g.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(d.j.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.ezX.getLayoutMode().aQ(i == 1);
        this.ezX.getLayoutMode().aM(this.mParent);
        aj.o(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
