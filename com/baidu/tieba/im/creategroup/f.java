package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button iVr;
    Button iVs;
    TextView iVt;
    TextView iVu;
    CreateGroupMainActivity iVv;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View crX() {
        return this.iVr;
    }

    public View crY() {
        return this.iVs;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.iVr = null;
        this.iVs = null;
        this.iVt = null;
        this.iVu = null;
        this.iVv = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.iVr.setOnClickListener(createGroupMainActivity);
        this.iVs.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.iVr.setEnabled(z2);
        this.iVs.setEnabled(z);
        this.iVt.setText(str2);
        this.iVu.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.iVv = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.iVr = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.iVs = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.iVt = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.iVu = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.iVv.getLayoutMode().setNightMode(i == 1);
        this.iVv.getLayoutMode().onModeChanged(this.mParent);
        ao.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
