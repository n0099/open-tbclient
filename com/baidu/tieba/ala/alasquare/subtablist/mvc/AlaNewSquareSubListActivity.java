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
    private String gtT;
    private String gyo;
    private String gzA;
    private List<String> gzB;
    private a gzy;
    private AlaSquareTabInfo gzz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gzy = new a(getPageContext(), true);
        if (getIntent() != null) {
            M(getIntent());
        } else {
            finish();
        }
    }

    private void M(Intent intent) {
        this.gzz = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.gtT = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.gyo = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.gzA = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.gzB = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.gzz != null) {
            if (this.gzz.iconType == 1) {
                this.gtT = this.gzz.name;
            } else if (this.gzz.iconType == 2) {
                this.gtT = "游戏";
                this.gyo = this.gzz.name;
            }
            this.gzA = this.gzz.bitmapWHRatio;
            this.gzy.a(this.gzA, this.gtT, this.gyo, this.gzz.sortTypeList);
        } else if (!StringUtils.isNull(this.gtT)) {
            this.gzy.a(this.gzA, this.gtT, this.gyo, this.gzB);
        } else {
            finish();
        }
        if (this.gzy.getRootView() != null) {
            setContentView(this.gzy.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gzy.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gzy != null) {
            this.gzy.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gzy != null) {
            this.gzy.onDestroy();
        }
    }
}
