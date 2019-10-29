package com.baidu.tieba.ala.personcenter;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
/* loaded from: classes6.dex */
public class AlaPersonCenterActivity extends BaseActivity<AlaPersonCenterActivity> {
    private TbPageContext cfl;
    private com.baidu.tieba.ala.personcenter.b.a exk;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cfl = getPageContext();
        this.exk = new com.baidu.tieba.ala.personcenter.b.a(this.cfl, false);
        setContentView(this.exk.getView());
        Intent intent = getIntent();
        if (intent != null) {
            this.exk.d(intent.getStringExtra("user_id"), intent.getStringExtra("user_name"), intent.getStringExtra(AlaPersonCenterActivityConfig.PORTRAIT_URL), intent.getBooleanExtra(AlaPersonCenterActivityConfig.IS_SELF, false));
        }
        this.exk.loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.exk.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.exk.onDestory();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.exk.d(intent.getStringExtra("user_id"), intent.getStringExtra("user_name"), intent.getStringExtra(AlaPersonCenterActivityConfig.PORTRAIT_URL), intent.getBooleanExtra(AlaPersonCenterActivityConfig.IS_SELF, false));
        }
        this.exk.loadData();
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
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.exk.onChangeSkinType(i);
    }
}
