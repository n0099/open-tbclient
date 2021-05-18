package com.baidu.tieba.ala.personcenter;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import d.a.k0.t.j.c.a;
/* loaded from: classes4.dex */
public class AlaPersonCenterActivity extends BaseActivity<AlaPersonCenterActivity> {
    public TbPageContext mContext;
    public a mPersonCenterController;

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i2) {
        super.changeSkinType(i2);
        this.mPersonCenterController.m(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mPersonCenterController.m(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbPageContext<AlaPersonCenterActivity> pageContext = getPageContext();
        this.mContext = pageContext;
        a aVar = new a(pageContext, false);
        this.mPersonCenterController = aVar;
        setContentView(aVar.i());
        Intent intent = getIntent();
        if (intent != null) {
            this.mPersonCenterController.k(intent.getStringExtra("user_id"), intent.getStringExtra("user_name"), intent.getStringExtra(AlaPersonCenterActivityConfig.PORTRAIT_URL), intent.getBooleanExtra(AlaPersonCenterActivityConfig.IS_SELF, false));
        }
        this.mPersonCenterController.l();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mPersonCenterController.o();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.mPersonCenterController.k(intent.getStringExtra("user_id"), intent.getStringExtra("user_name"), intent.getStringExtra(AlaPersonCenterActivityConfig.PORTRAIT_URL), intent.getBooleanExtra(AlaPersonCenterActivityConfig.IS_SELF, false));
        }
        this.mPersonCenterController.l();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a aVar = this.mPersonCenterController;
        if (aVar != null) {
            aVar.p();
        }
    }
}
