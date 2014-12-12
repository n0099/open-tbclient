package com.baidu.tieba.account.forbid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    private RadioGroup anC;
    private String anD;
    private TextView anE;
    private e anF;
    private View.OnClickListener anG = new a(this);
    private String mForumId;
    private String mForumName;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private String mThreadId;
    private String mUserName;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(z.login_to_use), true, 11018)));
            return;
        }
        this.mNavigationBar = (NavigationBar) findViewById(w.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(z.forbid_page_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(z.forbid_btn_txt), this.anG);
        this.anE = (TextView) findViewById(w.forbid_id);
        this.mListView = (BdListView) findViewById(w.listview_forbid_reason);
        this.anC = (RadioGroup) findViewById(w.forbid_days);
        this.anC.setOnCheckedChangeListener(new c(this));
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.anD = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        l.a(this.mForumId, this.anD, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eb(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            RadioButton radioButton = (RadioButton) this.anC.getChildAt(i2);
            if (radioButton.getId() == i) {
                ax.i((View) radioButton, v.btn_prohibit_day_s);
                ax.b(radioButton, t.cp_cont_i, 3);
            } else {
                ax.i((View) radioButton, v.btn_prohibit_day_n);
                ax.b(radioButton, t.appeal_com_text, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(w.root);
        getLayoutMode().ab(z);
        getLayoutMode().h(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mListView.setDivider(ax.getDrawable(v.forbid_list_divider));
        this.mListView.setDividerHeight(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 1.0f));
    }
}
