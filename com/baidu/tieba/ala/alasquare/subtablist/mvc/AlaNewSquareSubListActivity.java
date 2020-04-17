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
    private String eRS;
    private String eWl;
    private a eXv;
    private AlaSquareTabInfo eXw;
    private String eXx;
    private List<String> eXy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXv = new a(getPageContext(), true);
        if (getIntent() != null) {
            Z(getIntent());
        } else {
            finish();
        }
    }

    private void Z(Intent intent) {
        this.eXw = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.eRS = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.eWl = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.eXx = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.eXy = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.eXw != null) {
            if (this.eXw.iconType == 1) {
                this.eRS = this.eXw.name;
            } else if (this.eXw.iconType == 2) {
                this.eRS = "游戏";
                this.eWl = this.eXw.name;
            }
            this.eXx = this.eXw.bitmapWHRatio;
            this.eXv.a(this.eXx, this.eRS, this.eWl, this.eXw.sortTypeList);
        } else if (!StringUtils.isNull(this.eRS)) {
            this.eXv.a(this.eXx, this.eRS, this.eWl, this.eXy);
        } else {
            finish();
        }
        if (this.eXv.getRootView() != null) {
            setContentView(this.eXv.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eXv.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eXv != null) {
            this.eXv.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eXv != null) {
            this.eXv.onDestroy();
        }
    }
}
