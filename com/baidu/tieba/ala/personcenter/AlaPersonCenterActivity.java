package com.baidu.tieba.ala.personcenter;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
/* loaded from: classes2.dex */
public class AlaPersonCenterActivity extends BaseActivity<AlaPersonCenterActivity> {
    private TbPageContext cRe;
    private com.baidu.tieba.ala.personcenter.b.a frc;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cRe = getPageContext();
        this.frc = new com.baidu.tieba.ala.personcenter.b.a(this.cRe, false);
        setContentView(this.frc.getView());
        Intent intent = getIntent();
        if (intent != null) {
            this.frc.f(intent.getStringExtra("user_id"), intent.getStringExtra("user_name"), intent.getStringExtra(AlaPersonCenterActivityConfig.PORTRAIT_URL), intent.getBooleanExtra(AlaPersonCenterActivityConfig.IS_SELF, false));
        }
        this.frc.loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.frc.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.frc.onDestory();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.frc.f(intent.getStringExtra("user_id"), intent.getStringExtra("user_name"), intent.getStringExtra(AlaPersonCenterActivityConfig.PORTRAIT_URL), intent.getBooleanExtra(AlaPersonCenterActivityConfig.IS_SELF, false));
        }
        this.frc.loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.frc != null) {
            this.frc.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.frc.onChangeSkinType(i);
    }
}
