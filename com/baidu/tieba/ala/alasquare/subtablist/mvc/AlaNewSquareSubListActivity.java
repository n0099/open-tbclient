package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.BaseActivity;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaNewSquareSubListActivity extends BaseActivity<AlaNewSquareSubListActivity> {
    private String eRX;
    private String eWq;
    private a eXA;
    private AlaSquareTabInfo eXB;
    private String eXC;
    private List<String> eXD;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXA = new a(getPageContext(), true);
        if (getIntent() != null) {
            M(getIntent());
        } else {
            finish();
        }
    }

    private void M(Intent intent) {
        this.eXB = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.eRX = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.eWq = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.eXC = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.eXD = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.eXB != null) {
            if (this.eXB.iconType == 1) {
                this.eRX = this.eXB.name;
            } else if (this.eXB.iconType == 2) {
                this.eRX = "游戏";
                this.eWq = this.eXB.name;
            }
            this.eXC = this.eXB.bitmapWHRatio;
            this.eXA.a(this.eXC, this.eRX, this.eWq, this.eXB.sortTypeList);
        } else if (!StringUtils.isNull(this.eRX)) {
            this.eXA.a(this.eXC, this.eRX, this.eWq, this.eXD);
        } else {
            finish();
        }
        if (this.eXA.getRootView() != null) {
            setContentView(this.eXA.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eXA.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eXA != null) {
            this.eXA.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eXA != null) {
            this.eXA.onDestroy();
        }
    }
}
