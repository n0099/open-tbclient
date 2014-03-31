package com.baidu.tieba.account.appeal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class AppealActivity extends com.baidu.tbadk.a {
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
        intent.putExtra("forum_id", str);
        intent.putExtra("user_id", str2);
        intent.putExtra("user_name", str3);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.account_appeal_activity);
        this.a = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.a.a(getString(com.baidu.tieba.a.k.appeal_title));
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.a.k.appeal_submit_btn), this.j);
        this.b = (TextView) findViewById(com.baidu.tieba.a.h.forbid_id);
        this.c = (TextView) findViewById(com.baidu.tieba.a.h.forbid_reason);
        this.d = (TextView) findViewById(com.baidu.tieba.a.h.appeal_reason);
        this.e = (TextView) findViewById(com.baidu.tieba.a.h.remain_text_count);
        this.e.setText(String.valueOf(150));
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.requestFocus();
        com.baidu.adp.lib.util.i.b(this, this.d);
        this.d.addTextChangedListener(this.i);
        Intent intent = getIntent();
        this.f = intent.getStringExtra("forum_id");
        this.g = intent.getStringExtra("user_id");
        this.h = intent.getStringExtra("user_name");
        j.a(this.f, this.g, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(AppealActivity appealActivity, String str, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(appealActivity);
        builder.setTitle(appealActivity.getString(com.baidu.tieba.a.k.anti_title));
        builder.setMessage(str);
        builder.setPositiveButton(appealActivity.getString(com.baidu.tieba.a.k.anti_no_chance_pos), new e(appealActivity, z));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        getLayoutMode().a(z);
        getLayoutMode().a(findViewById(com.baidu.tieba.a.h.root));
        this.a.b(i);
        this.d.setHintTextColor(getResources().getColor(z ? com.baidu.tieba.a.e.appeal_hint_1 : com.baidu.tieba.a.e.appeal_hint));
    }
}
