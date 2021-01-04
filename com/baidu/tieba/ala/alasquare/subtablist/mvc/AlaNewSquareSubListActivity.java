package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.BaseActivity;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaNewSquareSubListActivity extends BaseActivity<AlaNewSquareSubListActivity> {
    private String gEU;
    private String gJt;
    private a gKD;
    private AlaSquareTabInfo gKE;
    private String gKF;
    private List<String> gKG;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gKD = new a(getPageContext(), true);
        if (getIntent() != null) {
            N(getIntent());
        } else {
            finish();
        }
    }

    private void N(Intent intent) {
        this.gKE = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.gEU = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.gJt = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.gKF = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.gKG = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.gKE != null) {
            if (this.gKE.iconType == 1) {
                this.gEU = this.gKE.name;
            } else if (this.gKE.iconType == 2) {
                this.gEU = "游戏";
                this.gJt = this.gKE.name;
            }
            this.gKF = this.gKE.bitmapWHRatio;
            this.gKD.a(this.gKF, this.gEU, this.gJt, this.gKE.sortTypeList);
        } else if (!StringUtils.isNull(this.gEU)) {
            this.gKD.a(this.gKF, this.gEU, this.gJt, this.gKG);
        } else {
            finish();
        }
        if (this.gKD.getRootView() != null) {
            setContentView(this.gKD.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gKD.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gKD != null) {
            this.gKD.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gKD != null) {
            this.gKD.onDestroy();
        }
    }
}
