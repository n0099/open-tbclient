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
    private String gtV;
    private String gyq;
    private a gzA;
    private AlaSquareTabInfo gzB;
    private String gzC;
    private List<String> gzD;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gzA = new a(getPageContext(), true);
        if (getIntent() != null) {
            M(getIntent());
        } else {
            finish();
        }
    }

    private void M(Intent intent) {
        this.gzB = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.gtV = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.gyq = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.gzC = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.gzD = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.gzB != null) {
            if (this.gzB.iconType == 1) {
                this.gtV = this.gzB.name;
            } else if (this.gzB.iconType == 2) {
                this.gtV = "游戏";
                this.gyq = this.gzB.name;
            }
            this.gzC = this.gzB.bitmapWHRatio;
            this.gzA.a(this.gzC, this.gtV, this.gyq, this.gzB.sortTypeList);
        } else if (!StringUtils.isNull(this.gtV)) {
            this.gzA.a(this.gzC, this.gtV, this.gyq, this.gzD);
        } else {
            finish();
        }
        if (this.gzA.getRootView() != null) {
            setContentView(this.gzA.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gzA.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gzA != null) {
            this.gzA.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gzA != null) {
            this.gzA.onDestroy();
        }
    }
}
