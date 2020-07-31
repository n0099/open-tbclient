package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.BaseActivity;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaNewSquareSubListActivity extends BaseActivity<AlaNewSquareSubListActivity> {
    private a fAP;
    private AlaSquareTabInfo fAQ;
    private String fAR;
    private List<String> fAS;
    private String fvl;
    private String fzF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fAP = new a(getPageContext(), true);
        if (getIntent() != null) {
            K(getIntent());
        } else {
            finish();
        }
    }

    private void K(Intent intent) {
        this.fAQ = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.fvl = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.fzF = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.fAR = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.fAS = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.fAQ != null) {
            if (this.fAQ.iconType == 1) {
                this.fvl = this.fAQ.name;
            } else if (this.fAQ.iconType == 2) {
                this.fvl = "游戏";
                this.fzF = this.fAQ.name;
            }
            this.fAR = this.fAQ.bitmapWHRatio;
            this.fAP.a(this.fAR, this.fvl, this.fzF, this.fAQ.sortTypeList);
        } else if (!StringUtils.isNull(this.fvl)) {
            this.fAP.a(this.fAR, this.fvl, this.fzF, this.fAS);
        } else {
            finish();
        }
        if (this.fAP.getRootView() != null) {
            setContentView(this.fAP.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fAP.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fAP != null) {
            this.fAP.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fAP != null) {
            this.fAP.onDestroy();
        }
    }
}
