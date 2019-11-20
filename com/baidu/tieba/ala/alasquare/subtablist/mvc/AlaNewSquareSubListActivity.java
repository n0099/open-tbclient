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
    private String dBT;
    private a dCT;
    private AlaSquareTabInfo dCU;
    private String dCV;
    private List<String> dCW;
    private String dxP;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dCT = new a(getPageContext(), true);
        if (getIntent() != null) {
            ai(getIntent());
        } else {
            finish();
        }
    }

    private void ai(Intent intent) {
        this.dCU = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.dxP = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.dBT = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.dCV = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.dCW = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.dCU != null) {
            if (this.dCU.iconType == 1) {
                this.dxP = this.dCU.name;
            } else if (this.dCU.iconType == 2) {
                this.dxP = "游戏";
                this.dBT = this.dCU.name;
            }
            this.dCV = this.dCU.bitmapWHRatio;
            this.dCT.a(this.dCV, this.dxP, this.dBT, this.dCU.sortTypeList);
        } else if (!StringUtils.isNull(this.dxP)) {
            this.dCT.a(this.dCV, this.dxP, this.dBT, this.dCW);
        } else {
            finish();
        }
        if (this.dCT.getRootView() != null) {
            setContentView(this.dCT.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dCT.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dCT != null) {
            this.dCT.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dCT != null) {
            this.dCT.onDestroy();
        }
    }
}
