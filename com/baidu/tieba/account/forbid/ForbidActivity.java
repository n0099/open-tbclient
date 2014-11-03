package com.baidu.tieba.account.forbid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity {
    private RadioGroup agl;
    private String agm;
    private TextView agn;
    private e ago;
    private View.OnClickListener agp = new a(this);
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private String mThreadId;
    private String mUserName;
    private BdListView vl;

    public static void startActivity(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, ForbidActivity.class);
        intent.putExtra("forum_id", str);
        intent.putExtra("forum_name", str2);
        intent.putExtra("thread_id", str3);
        intent.putExtra("bar_manager_user_id", str4);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME, str5);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.account_forbid_activity);
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(y.login_to_use), true, 11018);
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(getString(y.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(y.forbid_btn_txt), this.agp);
        this.agn = (TextView) findViewById(v.forbid_id);
        this.vl = (BdListView) findViewById(v.listview_forbid_reason);
        this.agl = (RadioGroup) findViewById(v.forbid_days);
        this.agl.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.agm = intent.getStringExtra("bar_manager_user_id");
        this.mUserName = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
        l.a(this.mForumId, this.agm, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.agl.getChildAt(i2);
            if (radioButton.getId() == i) {
                aw.h((View) radioButton, u.btn_prohibit_day_s);
                aw.b(radioButton, s.cp_cont_i, 3);
            } else {
                aw.h((View) radioButton, u.btn_prohibit_day_n);
                aw.b(radioButton, s.appeal_com_text, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(v.root);
        getLayoutMode().L(z);
        getLayoutMode().h(findViewById);
        this.mNavigationBar.onChangeSkinType(i);
        this.vl.setDivider(aw.getDrawable(u.forbid_list_divider));
        this.vl.setDividerHeight(com.baidu.adp.lib.util.m.dip2px(this, 1.0f));
    }
}
