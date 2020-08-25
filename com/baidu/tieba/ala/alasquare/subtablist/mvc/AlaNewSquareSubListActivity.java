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
    private String fGE;
    private String fKX;
    private a fMh;
    private AlaSquareTabInfo fMi;
    private String fMj;
    private List<String> fMk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fMh = new a(getPageContext(), true);
        if (getIntent() != null) {
            M(getIntent());
        } else {
            finish();
        }
    }

    private void M(Intent intent) {
        this.fMi = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.fGE = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.fKX = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.fMj = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.fMk = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.fMi != null) {
            if (this.fMi.iconType == 1) {
                this.fGE = this.fMi.name;
            } else if (this.fMi.iconType == 2) {
                this.fGE = "游戏";
                this.fKX = this.fMi.name;
            }
            this.fMj = this.fMi.bitmapWHRatio;
            this.fMh.a(this.fMj, this.fGE, this.fKX, this.fMi.sortTypeList);
        } else if (!StringUtils.isNull(this.fGE)) {
            this.fMh.a(this.fMj, this.fGE, this.fKX, this.fMk);
        } else {
            finish();
        }
        if (this.fMh.getRootView() != null) {
            setContentView(this.fMh.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fMh.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fMh != null) {
            this.fMh.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fMh != null) {
            this.fMh.onDestroy();
        }
    }
}
