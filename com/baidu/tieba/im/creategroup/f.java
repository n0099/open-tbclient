package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button kbf;
    Button kbg;
    TextView kbh;
    TextView kbi;
    CreateGroupMainActivity kbj;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cPs() {
        return this.kbf;
    }

    public View cPt() {
        return this.kbg;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.kbf = null;
        this.kbg = null;
        this.kbh = null;
        this.kbi = null;
        this.kbj = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.kbf.setOnClickListener(createGroupMainActivity);
        this.kbg.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.kbf.setEnabled(z2);
        this.kbg.setEnabled(z);
        this.kbh.setText(str2);
        this.kbi.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.kbj = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.kbf = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.kbg = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.kbh = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.kbi = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.kbj.getLayoutMode().setNightMode(i == 1);
        this.kbj.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
