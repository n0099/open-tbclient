package com.baidu.tieba.account.appeal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity {
    private NavigationBar a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private String f;
    private String g;
    private String h;
    private TextWatcher i = new a(this);
    private View.OnClickListener j = new b(this);

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, AppealActivity.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, str);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID, str2);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME, str3);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.account_appeal_activity);
        this.a = (NavigationBar) findViewById(v.view_navigation_bar);
        this.a.a(getString(y.appeal_title));
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(y.appeal_submit_btn), this.j);
        this.b = (TextView) findViewById(v.forbid_id);
        this.c = (TextView) findViewById(v.forbid_reason);
        this.d = (TextView) findViewById(v.appeal_reason);
        this.e = (TextView) findViewById(v.remain_text_count);
        this.e.setText(String.valueOf(150));
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.requestFocus();
        com.baidu.adp.lib.util.j.b(this, this.d);
        this.d.addTextChangedListener(this.i);
        a();
    }

    private void a() {
        Intent intent = getIntent();
        this.f = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID);
        this.g = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID);
        this.h = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
        j.a(this.f, this.g, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(y.anti_title));
        builder.setMessage(str);
        builder.setPositiveButton(getString(y.anti_no_chance_pos), new e(this, z));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        getLayoutMode().a(z);
        getLayoutMode().a(findViewById(v.root));
        this.a.c(i);
        this.d.setHintTextColor(getResources().getColor(z ? s.appeal_hint_1 : s.appeal_hint));
    }
}
