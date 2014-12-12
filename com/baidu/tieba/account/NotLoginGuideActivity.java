package com.baidu.tieba.account;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.SapiFastRegActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    private ImageView akv = null;
    private Bitmap mBitmap = null;
    private Button amx = null;
    private Button amy = null;
    private String mFrom = null;
    private boolean amz = false;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(NotLoginGuideActivityConfig.class, NotLoginGuideActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!AA()) {
            com.baidu.tbadk.core.i.B(getPageContext().getContext(), "not_login_guide_page_pv");
            initData(bundle);
            initView();
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mFrom = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
        } else {
            this.mFrom = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
        }
    }

    private void initView() {
        setContentView(com.baidu.tieba.x.not_login_guide_activity);
        this.akv = (ImageView) findViewById(com.baidu.tieba.w.guide_bg);
        this.amx = (Button) findViewById(com.baidu.tieba.w.guide_regist);
        this.amy = (Button) findViewById(com.baidu.tieba.w.guide_login);
        this.mBitmap = com.baidu.tbadk.core.util.d.f(getPageContext().getContext(), com.baidu.tieba.v.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.akv.setImageBitmap(this.mBitmap);
        }
        this.amx.setOnClickListener(this);
        this.amy.setOnClickListener(this);
    }

    private boolean AA() {
        if (NotLoginGuideActivityConfig.FROM_HAO123.equals(getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE)) && UtilHelper.FirstStartActivity(getPageContext().getPageActivity())) {
            new Intent().putExtra("class", 20);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig((Context) getPageContext().getPageActivity(), false)));
            finish();
            return true;
        }
        return false;
    }

    private void rq() {
        if (TbadkCoreApplication.m255getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(2015000) != null) {
                sendMessage(new CustomMessage(2015000, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
            } else {
                sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.og().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.og().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.amx) {
            com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "sapi_fast_regist_click");
            sendMessage(new CustomMessage(2002001, new SapiFastRegActivityConfig(getPageContext().getPageActivity(), 22002)));
        } else if (!this.amz) {
            this.amz = true;
            com.baidu.tbadk.core.i.B(getPageContext().getContext(), "sapi_go_to_login_click");
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.amz = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.mFrom)) {
                    com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), Constants.MEDIA_INFO);
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
        Ak();
    }

    private void Ak() {
        if (this.akv != null) {
            this.akv.setImageDrawable(null);
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
                rq();
            } else if (i == 22002 && intent != null) {
                String stringExtra = intent.getStringExtra("fast_reg_user_type");
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals("login_user")) {
                        rq();
                    } else if (stringExtra.equals("regist_user")) {
                        if (UtilHelper.isNetOk() && MessageManager.getInstance().findTask(2012116) != null) {
                            TbadkCoreApplication.m255getInst().setIsNewRegUser(true);
                            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), true, false)));
                        } else {
                            rq();
                        }
                        if (TbadkCoreApplication.m255getInst().getIsFirstUse()) {
                            TbadkCoreApplication.m255getInst().setUsed();
                        }
                        finish();
                    }
                }
            }
        }
    }
}
