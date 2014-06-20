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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.aj;
import com.baidu.tbadk.core.atomData.ak;
import com.baidu.tbadk.core.atomData.ap;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.ai;
import com.baidu.tieba.guide.NewUserGuideActivity;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends BaseActivity {
    private ImageView a = null;
    private Bitmap b = null;
    private Button c = null;
    private Button d = null;
    private String e = null;

    static {
        TbadkApplication.m252getInst().RegisterIntent(ap.class, NotLoginGuideActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!b()) {
            com.baidu.tbadk.core.f.a(this, "not_login_guide_page_pv");
            a(bundle);
            a();
        }
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.e = bundle.getString(ap.a);
        } else {
            this.e = getIntent().getStringExtra(ap.a);
        }
    }

    private void a() {
        setContentView(com.baidu.tieba.w.not_login_guide_activity);
        this.a = (ImageView) findViewById(com.baidu.tieba.v.guide_bg);
        this.c = (Button) findViewById(com.baidu.tieba.v.guide_regist);
        this.d = (Button) findViewById(com.baidu.tieba.v.guide_login);
        this.b = com.baidu.tbadk.core.util.g.a(this, com.baidu.tieba.u.not_login_guide_bg);
        this.a.setImageBitmap(this.b);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    private boolean b() {
        if (ap.d.equals(getIntent().getStringExtra(ap.a)) && com.baidu.tieba.util.r.a((Activity) this)) {
            new Intent().putExtra("class", 20);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new aj((Context) this, false)));
            finish();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private void c() {
        if (TbadkApplication.m252getInst().getIsFirstUse()) {
            sendMessage(new CustomMessage(2017000, new com.baidu.tbadk.core.atomData.r(this).a("from_logo_page")));
        } else {
            sendMessage(new CustomMessage(2017001, new ak(this).a(1)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.c) {
            com.baidu.tbadk.core.f.a(this, "sapi_fast_regist_click");
            SapiFastRegActivity.a(this, 22002);
            return;
        }
        com.baidu.tbadk.core.f.a(this, "sapi_go_to_login_click");
        LoginActivity.a((Activity) this, (String) null, true, 11003);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (ap.b.equals(this.e)) {
                    com.baidu.tbadk.core.b.b.a(this, Constants.MEDIA_INFO);
                } else {
                    closeActivity();
                }
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    private void d() {
        if (this.a != null) {
            this.a.setImageBitmap(null);
        }
        if (this.b != null && !this.b.isRecycled()) {
            this.b.recycle();
            this.b = null;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                c();
            } else if (i == 22002 && intent != null) {
                String stringExtra = intent.getStringExtra("fast_reg_user_type");
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals("login_user")) {
                        c();
                    } else if (stringExtra.equals("regist_user")) {
                        if (UtilHelper.isNetOk()) {
                            ai.c().a(true);
                            NewUserGuideActivity.a(this, true, false);
                        } else {
                            c();
                        }
                        if (TbadkApplication.m252getInst().getIsFirstUse()) {
                            TbadkApplication.m252getInst().setUsed();
                        }
                        finish();
                    }
                }
            }
        }
    }
}
