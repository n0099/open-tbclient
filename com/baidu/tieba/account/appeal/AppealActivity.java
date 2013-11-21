package com.baidu.tieba.account.appeal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AppealActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private NavigationBar f1043a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private String f;
    private String g;
    private String h;
    private TextWatcher i = new a(this);
    private View.OnClickListener j = new c(this);

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, AppealActivity.class);
        intent.putExtra("forum_id", str);
        intent.putExtra(PushConstants.EXTRA_USER_ID, str2);
        intent.putExtra("user_name", str3);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_appeal_activity);
        this.f1043a = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.f1043a.a(getString(R.string.appeal_title));
        this.f1043a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f1043a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.appeal_submit_btn), this.j);
        this.b = (TextView) findViewById(R.id.forbid_id);
        this.c = (TextView) findViewById(R.id.forbid_reason);
        this.d = (TextView) findViewById(R.id.appeal_reason);
        this.e = (TextView) findViewById(R.id.remain_text_count);
        this.e.setText(String.valueOf(150));
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.requestFocus();
        UtilHelper.b(this, this.d);
        this.d.addTextChangedListener(this.i);
        a();
    }

    private void a() {
        Intent intent = getIntent();
        this.f = intent.getStringExtra("forum_id");
        this.g = intent.getStringExtra(PushConstants.EXTRA_USER_ID);
        this.h = intent.getStringExtra("user_name");
        j.a(this.f, this.g, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.anti_title));
        builder.setMessage(str);
        builder.setPositiveButton(getString(R.string.anti_no_chance_pos), new e(this, z));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        boolean z = i == 1;
        getLayoutMode().a(z);
        getLayoutMode().a(findViewById(R.id.root));
        this.f1043a.c(i);
        this.d.setHintTextColor(getResources().getColor(z ? R.color.appeal_hint_1 : R.color.appeal_hint));
    }
}
