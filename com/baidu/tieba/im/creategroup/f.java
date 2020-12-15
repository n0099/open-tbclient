package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button koL;
    Button koM;
    TextView koN;
    TextView koO;
    CreateGroupMainActivity koP;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cUH() {
        return this.koL;
    }

    public View cUI() {
        return this.koM;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.koL = null;
        this.koM = null;
        this.koN = null;
        this.koO = null;
        this.koP = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.koL.setOnClickListener(createGroupMainActivity);
        this.koM.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.koL.setEnabled(z2);
        this.koM.setEnabled(z);
        this.koN.setText(str2);
        this.koO.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.koP = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.koL = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.koM = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.koN = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.koO = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.koP.getLayoutMode().setNightMode(i == 1);
        this.koP.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
