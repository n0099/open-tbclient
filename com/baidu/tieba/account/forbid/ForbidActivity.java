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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class ForbidActivity extends BaseActivity {
    private NavigationBar a;
    private RadioGroup b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private TextView h;
    private BdListView i;
    private e j;
    private View.OnClickListener k = new a(this);

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, ForbidActivity.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, str);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, str2);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, str3);
        intent.putExtra("bar_manager_user_id", str4);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME, str5);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(v.account_forbid_activity);
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(x.login_to_use), true, 11018);
            return;
        }
        this.a = (NavigationBar) findViewById(u.view_navigation_bar);
        this.a.a(getString(x.forbid_page_title));
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(x.forbid_btn_txt), this.k);
        this.h = (TextView) findViewById(u.forbid_id);
        this.i = (BdListView) findViewById(u.listview_forbid_reason);
        this.b = (RadioGroup) findViewById(u.forbid_days);
        this.b.setOnCheckedChangeListener(new c(this));
        a();
    }

    private void a() {
        Intent intent = getIntent();
        this.c = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID);
        this.d = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
        this.e = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
        this.f = intent.getStringExtra("bar_manager_user_id");
        this.g = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
        l.a(this.c, this.f, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        int i2 = !z ? t.btn_prohibit_day_n : t.btn_prohibit_day_n_1;
        int i3 = !z ? r.appeal_com_text : r.appeal_com_text_1;
        int i4 = !z ? t.btn_prohibit_day_s : t.btn_prohibit_day_s_1;
        int i5 = !z ? r.forbid_time_selected : r.forbid_time_selected_1;
        for (int i6 = 0; i6 < 3; i6++) {
            RadioButton radioButton = (RadioButton) this.b.getChildAt(i6);
            if (radioButton.getId() == i) {
                ay.e((View) radioButton, i4);
                radioButton.setTextColor(getResources().getColor(i5));
            } else {
                ay.e((View) radioButton, i2);
                radioButton.setTextColor(getResources().getColor(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        View findViewById = findViewById(u.root);
        getLayoutMode().a(z);
        getLayoutMode().a(findViewById);
        this.a.c(i);
        this.i.setDivider(getResources().getDrawable(z ? t.forbid_list_divider_1 : t.forbid_list_divider));
        this.i.setDividerHeight(com.baidu.adp.lib.util.j.a((Context) this, 1.0f));
    }
}
