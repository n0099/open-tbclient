package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class ReLoginShareActivity extends com.baidu.tieba.j {
    private NavigationBar l;
    private aq b = null;
    private Button c = null;
    private Button d = null;
    private TextView e = null;
    private ProgressBar f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private AccountData j = null;
    private m k = null;

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f1024a = null;
    private View.OnClickListener m = new ap(this);

    public static void a(Activity activity, String str, String str2, String str3, int i) {
        Intent intent = new Intent(activity, ReLoginShareActivity.class);
        intent.putExtra("user_name", str);
        intent.putExtra(SocialConstants.PARAM_BDUSS, str2);
        intent.putExtra("ptoken", str3);
        intent.putExtra("locate_type", i);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        a();
        b();
        d();
    }

    private void a() {
        Intent intent = getIntent();
        this.g = intent.getStringExtra("user_name");
        this.h = intent.getStringExtra(SocialConstants.PARAM_BDUSS);
        this.i = intent.getStringExtra("ptoken");
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.g = bundle.getString("user_name");
        this.h = bundle.getString(SocialConstants.PARAM_BDUSS);
        this.i = bundle.getString("ptoken");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("user_name", this.g);
        bundle.putString(SocialConstants.PARAM_BDUSS, this.h);
        bundle.putString("ptoken", this.i);
    }

    private void b() {
        this.l = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c = (Button) findViewById(R.id.relogin_retry_button);
        this.c.setOnClickListener(this.m);
        this.d = (Button) findViewById(R.id.relogin_cacel_button);
        this.d.setOnClickListener(this.m);
        this.f = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.e = (TextView) findViewById(R.id.relogin_textview);
        this.f1024a = (LinearLayout) findViewById(R.id.container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        a(0, this.g);
        this.l.c(i);
        bd.a((TextView) this.d, i);
        bd.a(this.f1024a, i);
        bd.b(this.e, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        if (str == null) {
            str = "";
        }
        switch (i) {
            case 0:
                this.c.setVisibility(8);
                this.f.setVisibility(0);
                String string = getString(R.string.relogin_statement);
                int indexOf = string.indexOf(63);
                String replace = string.replace("?", str);
                this.e.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.e.setText(replace);
                    return;
                }
                SpannableString spannableString = new SpannableString(replace);
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb((int) Util.MASK_8BIT, 47, 47)), indexOf, str.length() + indexOf, 33);
                this.e.setText(spannableString);
                return;
            case 1:
                this.c.setVisibility(0);
                this.f.setVisibility(8);
                String string2 = getString(R.string.relogin_fail);
                this.e.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.e.setText(string2);
                    return;
                }
                String str2 = string2 + "\n\n";
                SpannableString spannableString2 = new SpannableString(str2 + str);
                int length = str2.length();
                if (this.mSkinType == 1) {
                    spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, length, 33);
                }
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb((int) Util.MASK_8BIT, 47, 47)), length, str.length() + length, 33);
                spannableString2.setSpan(new RelativeSizeSpan(0.9f), length, str.length() + length, 33);
                this.e.setText(spannableString2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            MainTabActivity.a(this, 0);
            return;
        }
        DatabaseService.k();
        TiebaApplication.a((AccountData) null, getBaseContext());
        MainTabActivity.b(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.b != null) {
            this.b.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.b == null && this.h != null && this.i != null) {
            this.b = new aq(this, null);
            this.b.setPriority(3);
            this.b.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int intExtra = getIntent().getIntExtra("locate_type", -1);
        DatabaseService.a(this.j);
        TiebaApplication.a(this.j, getBaseContext());
        MainTabActivity.b(this, intExtra);
        a.a().d();
    }
}
