package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.guide.NewUserGuideActivity;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends com.baidu.tbadk.a {
    private ImageView a = null;
    private Bitmap b = null;
    private Button c = null;
    private Button d = null;
    private String e = null;

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.ad.class, NotLoginGuideActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.core.g.a(this, "not_login_guide_page_pv");
        if (bundle != null) {
            this.e = bundle.getString(com.baidu.tbadk.core.b.ad.a);
        } else {
            this.e = getIntent().getStringExtra(com.baidu.tbadk.core.b.ad.a);
        }
        setContentView(com.baidu.tieba.a.i.not_login_guide_activity);
        this.a = (ImageView) findViewById(com.baidu.tieba.a.h.guide_bg);
        this.c = (Button) findViewById(com.baidu.tieba.a.h.guide_regist);
        this.d = (Button) findViewById(com.baidu.tieba.a.h.guide_login);
        this.b = com.baidu.tbadk.core.util.g.a(this, com.baidu.tieba.a.g.not_login_guide_bg);
        this.a.setImageBitmap(this.b);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        int i;
        super.onResume();
        if (TbadkApplication.j().T()) {
            i = 2;
        } else {
            i = 1;
        }
        com.baidu.tbadk.core.a.a.a().a(new t(this));
        if (this.e != null && this.e.equals(com.baidu.tbadk.core.b.ad.c)) {
            com.baidu.tbadk.core.a.a.a().a(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (TbadkApplication.j().T()) {
            sendMessage(new com.baidu.adp.framework.message.a(2015000, new com.baidu.tbadk.core.b.p(this).a("from_logo_page")));
        } else {
            sendMessage(new com.baidu.adp.framework.message.a(2015001, new com.baidu.tbadk.core.b.aa(this).a(1, false)));
        }
        finish();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.c) {
            com.baidu.tbadk.core.g.a(this, "sapi_fast_regist_click");
            SapiFastRegActivity.a(this, 22002);
            return;
        }
        com.baidu.tbadk.core.g.a(this, "sapi_go_to_login_click");
        LoginActivity.a((Activity) this, (String) null, true, 11003);
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
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
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.setImageBitmap(null);
        }
        if (this.b == null || this.b.isRecycled()) {
            return;
        }
        this.b.recycle();
        this.b = null;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                a();
            } else if (i == 22002 && intent != null) {
                String stringExtra = intent.getStringExtra("fast_reg_user_type");
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals("login_user")) {
                        a();
                    } else if (stringExtra.equals("regist_user")) {
                        if (UtilHelper.a()) {
                            com.baidu.tieba.r.c().a(true);
                            NewUserGuideActivity.a(this, true, false);
                        } else {
                            a();
                        }
                        if (TbadkApplication.j().T()) {
                            TbadkApplication.j();
                            TbadkApplication.U();
                        }
                        finish();
                    }
                }
            }
        }
    }
}
