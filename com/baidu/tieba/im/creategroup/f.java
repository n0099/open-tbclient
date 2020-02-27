package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button hwg;
    Button hwh;
    TextView hwi;
    TextView hwj;
    CreateGroupMainActivity hwk;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bTb() {
        return this.hwg;
    }

    public View bTc() {
        return this.hwh;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.hwg = null;
        this.hwh = null;
        this.hwi = null;
        this.hwj = null;
        this.hwk = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.hwg.setOnClickListener(createGroupMainActivity);
        this.hwh.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.hwg.setEnabled(z2);
        this.hwh.setEnabled(z);
        this.hwi.setText(str2);
        this.hwj.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.hwk = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.hwg = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.hwh = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.hwi = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.hwj = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.hwk.getLayoutMode().setNightMode(i == 1);
        this.hwk.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
