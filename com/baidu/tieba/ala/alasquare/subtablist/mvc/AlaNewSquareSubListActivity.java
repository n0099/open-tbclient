package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.BaseActivity;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaNewSquareSubListActivity extends BaseActivity<AlaNewSquareSubListActivity> {
    private String dCK;
    private a dDK;
    private AlaSquareTabInfo dDL;
    private String dDM;
    private List<String> dDN;
    private String dyG;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dDK = new a(getPageContext(), true);
        if (getIntent() != null) {
            ai(getIntent());
        } else {
            finish();
        }
    }

    private void ai(Intent intent) {
        this.dDL = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.dyG = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.dCK = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.dDM = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.dDN = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.dDL != null) {
            if (this.dDL.iconType == 1) {
                this.dyG = this.dDL.name;
            } else if (this.dDL.iconType == 2) {
                this.dyG = "游戏";
                this.dCK = this.dDL.name;
            }
            this.dDM = this.dDL.bitmapWHRatio;
            this.dDK.a(this.dDM, this.dyG, this.dCK, this.dDL.sortTypeList);
        } else if (!StringUtils.isNull(this.dyG)) {
            this.dDK.a(this.dDM, this.dyG, this.dCK, this.dDN);
        } else {
            finish();
        }
        if (this.dDK.getRootView() != null) {
            setContentView(this.dDK.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dDK.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dDK != null) {
            this.dDK.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dDK != null) {
            this.dDK.onDestroy();
        }
    }
}
