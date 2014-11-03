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
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.aj;
import com.baidu.tieba.guide.NewUserGuideActivity;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends BaseActivity {
    private ImageView acK = null;
    private Bitmap mBitmap = null;
    private Button afh = null;
    private Button afi = null;
    private String Gp = null;

    static {
        TbadkApplication.m251getInst().RegisterIntent(NotLoginGuideActivityConfig.class, NotLoginGuideActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!xh()) {
            com.baidu.tbadk.core.j.l(this, "not_login_guide_page_pv");
            d(bundle);
            nu();
        }
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.Gp = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
        } else {
            this.Gp = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
        }
    }

    private void nu() {
        setContentView(com.baidu.tieba.w.not_login_guide_activity);
        this.acK = (ImageView) findViewById(com.baidu.tieba.v.guide_bg);
        this.afh = (Button) findViewById(com.baidu.tieba.v.guide_regist);
        this.afi = (Button) findViewById(com.baidu.tieba.v.guide_login);
        this.mBitmap = com.baidu.tbadk.core.util.d.e(this, com.baidu.tieba.u.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.acK.setImageBitmap(this.mBitmap);
        }
        this.afh.setOnClickListener(this);
        this.afi.setOnClickListener(this);
    }

    private boolean xh() {
        if (NotLoginGuideActivityConfig.FROM_HAO123.equals(getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE)) && com.baidu.tieba.util.q.l(this)) {
            new Intent().putExtra("class", 20);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig((Context) this, false)));
            finish();
            return true;
        }
        return false;
    }

    private void oq() {
        int i = 1;
        if (TbadkApplication.m251getInst().getIsFirstUse()) {
            sendMessage(new CustomMessage(2015000, new GuildActivityConfig(this).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("account_first_login_" + TbadkApplication.getCurrentAccount(), true)) {
                i = 4;
                com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("account_first_login_" + TbadkApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(this).createNormalCfg(i)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.afh) {
            com.baidu.tbadk.core.j.l(this, "sapi_fast_regist_click");
            SapiFastRegActivity.b(this, 22002);
            return;
        }
        com.baidu.tbadk.core.j.l(this, "sapi_go_to_login_click");
        LoginActivity.a((Activity) this, (String) null, true, 11003);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.Gp)) {
                    com.baidu.tbadk.core.b.b.d(this, Constants.MEDIA_INFO);
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
        wd();
    }

    private void wd() {
        if (this.acK != null) {
            this.acK.setImageDrawable(null);
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                oq();
            } else if (i == 22002 && intent != null) {
                String stringExtra = intent.getStringExtra("fast_reg_user_type");
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals("login_user")) {
                        oq();
                    } else if (stringExtra.equals("regist_user")) {
                        if (UtilHelper.isNetOk()) {
                            aj.wm().aN(true);
                            NewUserGuideActivity.a(this, true, false);
                        } else {
                            oq();
                        }
                        if (TbadkApplication.m251getInst().getIsFirstUse()) {
                            TbadkApplication.m251getInst().setUsed();
                        }
                        finish();
                    }
                }
            }
        }
    }
}
