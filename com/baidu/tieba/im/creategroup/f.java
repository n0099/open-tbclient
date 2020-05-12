package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.base.c<CreateGroupMainActivity> {
    Button ihN;
    Button ihO;
    TextView ihP;
    TextView ihQ;
    CreateGroupMainActivity ihR;
    private int mForumId;
    NavigationBar mNavigationBar;
    View mParent;

    public int getForumId() {
        return this.mForumId;
    }

    public View cdV() {
        return this.ihN;
    }

    public View cdW() {
        return this.ihO;
    }

    public f(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity.getPageContext());
        this.mNavigationBar = null;
        this.mParent = null;
        this.ihN = null;
        this.ihO = null;
        this.ihP = null;
        this.ihQ = null;
        this.ihR = null;
        this.mForumId = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.ihN.setOnClickListener(createGroupMainActivity);
        this.ihO.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.ihN.setEnabled(z2);
        this.ihO.setEnabled(z);
        this.ihP.setText(str2);
        this.ihQ.setText(str);
        this.mForumId = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.ihR = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.mParent = createGroupMainActivity.findViewById(R.id.parent);
        this.ihN = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.ihO = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.ihP = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.ihQ = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.mNavigationBar = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void onChangeSkinType(int i) {
        this.ihR.getLayoutMode().setNightMode(i == 1);
        this.ihR.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
    }
}
