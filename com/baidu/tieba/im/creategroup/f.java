package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button gDA;
    TextView gDB;
    TextView gDC;
    CreateGroupMainActivity gDD;
    Button gDz;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View bBD() {
        return this.gDz;
    }

    public View bBE() {
        return this.gDA;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.gDz = null;
        this.gDA = null;
        this.gDB = null;
        this.gDC = null;
        this.gDD = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.gDz.setOnClickListener(createGroupMainActivity);
        this.gDA.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.gDz.setEnabled(z2);
        this.gDA.setEnabled(z);
        this.gDB.setText(str2);
        this.gDC.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.gDD = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.gDz = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.gDA = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.gDB = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.gDC = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.gDD.getLayoutMode().setNightMode(i == 1);
        this.gDD.getLayoutMode().onModeChanged(this.mParent);
        am.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
