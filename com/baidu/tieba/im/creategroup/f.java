package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button hwi;
    Button hwj;
    TextView hwk;
    TextView hwl;
    CreateGroupMainActivity hwm;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bTd() {
        return this.hwi;
    }

    public View bTe() {
        return this.hwj;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.hwi = null;
        this.hwj = null;
        this.hwk = null;
        this.hwl = null;
        this.hwm = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.hwi.setOnClickListener(createGroupMainActivity);
        this.hwj.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.hwi.setEnabled(z2);
        this.hwj.setEnabled(z);
        this.hwk.setText(str2);
        this.hwl.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.hwm = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.hwi = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.hwj = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.hwk = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.hwl = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.hwm.getLayoutMode().setNightMode(i == 1);
        this.hwm.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
