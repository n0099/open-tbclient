package com.baidu.tieba.ala.personcenter;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
/* loaded from: classes4.dex */
public class AlaPersonCenterActivity extends BaseActivity<AlaPersonCenterActivity> {
    private TbPageContext dVN;
    private com.baidu.tieba.ala.personcenter.b.a gGn;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dVN = getPageContext();
        this.gGn = new com.baidu.tieba.ala.personcenter.b.a(this.dVN, false);
        setContentView(this.gGn.getView());
        Intent intent = getIntent();
        if (intent != null) {
            this.gGn.f(intent.getStringExtra("user_id"), intent.getStringExtra("user_name"), intent.getStringExtra(AlaPersonCenterActivityConfig.PORTRAIT_URL), intent.getBooleanExtra(AlaPersonCenterActivityConfig.IS_SELF, false));
        }
        this.gGn.loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gGn.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.gGn.onDestory();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.gGn.f(intent.getStringExtra("user_id"), intent.getStringExtra("user_name"), intent.getStringExtra(AlaPersonCenterActivityConfig.PORTRAIT_URL), intent.getBooleanExtra(AlaPersonCenterActivityConfig.IS_SELF, false));
        }
        this.gGn.loadData();
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
        if (this.gGn != null) {
            this.gGn.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.gGn.onChangeSkinType(i);
    }
}
