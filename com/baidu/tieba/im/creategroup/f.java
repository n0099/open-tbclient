package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button gDq;
    Button gDr;
    TextView gDs;
    TextView gDt;
    CreateGroupMainActivity gDu;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bzc() {
        return this.gDq;
    }

    public View bzd() {
        return this.gDr;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.gDq = null;
        this.gDr = null;
        this.gDs = null;
        this.gDt = null;
        this.gDu = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.gDq.setOnClickListener(createGroupMainActivity);
        this.gDr.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.gDq.setEnabled(z2);
        this.gDr.setEnabled(z);
        this.gDs.setText(str2);
        this.gDt.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.gDu = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.gDq = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.gDr = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.gDs = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.gDt = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.gDu.getLayoutMode().setNightMode(i == 1);
        this.gDu.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
