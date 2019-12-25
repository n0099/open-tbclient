package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button hqE;
    Button hqF;
    TextView hqG;
    TextView hqH;
    CreateGroupMainActivity hqI;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bQr() {
        return this.hqE;
    }

    public View bQs() {
        return this.hqF;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.hqE = null;
        this.hqF = null;
        this.hqG = null;
        this.hqH = null;
        this.hqI = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.hqE.setOnClickListener(createGroupMainActivity);
        this.hqF.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.hqE.setEnabled(z2);
        this.hqF.setEnabled(z);
        this.hqG.setText(str2);
        this.hqH.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.hqI = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.hqE = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.hqF = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.hqG = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.hqH = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.hqI.getLayoutMode().setNightMode(i == 1);
        this.hqI.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
