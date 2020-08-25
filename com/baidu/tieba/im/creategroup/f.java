package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button jks;
    Button jkt;
    TextView jku;
    TextView jkv;
    CreateGroupMainActivity jkw;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cCO() {
        return this.jks;
    }

    public View cCP() {
        return this.jkt;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.jks = null;
        this.jkt = null;
        this.jku = null;
        this.jkv = null;
        this.jkw = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.jks.setOnClickListener(createGroupMainActivity);
        this.jkt.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.jks.setEnabled(z2);
        this.jkt.setEnabled(z);
        this.jku.setText(str2);
        this.jkv.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.jkw = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.jks = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.jkt = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.jku = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.jkv = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.jkw.getLayoutMode().setNightMode(i == 1);
        this.jkw.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
