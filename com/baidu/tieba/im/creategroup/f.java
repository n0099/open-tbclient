package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button jHZ;
    Button jIa;
    TextView jIb;
    TextView jIc;
    CreateGroupMainActivity jId;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cKe() {
        return this.jHZ;
    }

    public View cKf() {
        return this.jIa;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.jHZ = null;
        this.jIa = null;
        this.jIb = null;
        this.jIc = null;
        this.jId = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.jHZ.setOnClickListener(createGroupMainActivity);
        this.jIa.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.jHZ.setEnabled(z2);
        this.jIa.setEnabled(z);
        this.jIb.setText(str2);
        this.jIc.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.jId = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.jHZ = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.jIa = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.jIb = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.jIc = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.jId.getLayoutMode().setNightMode(i == 1);
        this.jId.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
