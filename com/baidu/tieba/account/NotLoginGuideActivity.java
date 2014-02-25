package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.tieba.GuideActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.guide.NewUserGuideActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends com.baidu.tieba.f {
    private ImageView c = null;
    private Bitmap d = null;
    private Button e = null;
    private Button f = null;
    private String g = null;
    private static String h = "from_page";
    public static String a = "from_account";
    public static String b = "form_logo";

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, NotLoginGuideActivity.class);
        intent.putExtra(h, str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        a();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.g = bundle.getString(h);
        } else {
            this.g = getIntent().getStringExtra(h);
        }
    }

    private void a() {
        setContentView(R.layout.not_login_guide_activity);
        this.c = (ImageView) findViewById(R.id.guide_bg);
        this.e = (Button) findViewById(R.id.guide_regist);
        this.f = (Button) findViewById(R.id.guide_login);
        this.d = com.baidu.tieba.util.n.a(this, (int) R.drawable.not_login_guide_bg);
        this.c.setImageBitmap(this.d);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        int i;
        super.onResume();
        if (TiebaApplication.g().aE()) {
            i = 2;
        } else {
            i = 1;
        }
        a.a().a(new av(this));
        if (this.g != null && this.g.equals(b)) {
            a.a().a(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (TiebaApplication.g().aE()) {
            GuideActivity.a(this, "from_logo_page");
        } else {
            MainTabActivity.a(this, 1);
        }
        finish();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.e) {
            com.baidu.tieba.ai.a(this, "sapi_fast_regist_click");
            SapiFastRegActivity.a(this, 22002);
            return;
        }
        LoginActivity.a((Activity) this, (String) null, true, 11003);
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c();
    }

    private void c() {
        if (this.c != null) {
            this.c.setImageBitmap(null);
        }
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                b();
            } else if (i == 22002 && intent != null) {
                String stringExtra = intent.getStringExtra("fast_reg_user_type");
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals("login_user")) {
                        b();
                    } else if (stringExtra.equals("regist_user")) {
                        if (UtilHelper.b()) {
                            NewUserGuideActivity.a(this, true, false);
                        } else {
                            b();
                        }
                        if (TiebaApplication.g().aE()) {
                            TiebaApplication.g().aF();
                        }
                        finish();
                    }
                }
            }
        }
    }
}
