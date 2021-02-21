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
    private String gDl;
    private String gHL;
    private a gIV;
    private AlaSquareTabInfo gIW;
    private String gIX;
    private List<String> gIY;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gIV = new a(getPageContext(), true);
        if (getIntent() != null) {
            N(getIntent());
        } else {
            finish();
        }
    }

    private void N(Intent intent) {
        this.gIW = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.gDl = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.gHL = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.gIX = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.gIY = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.gIW != null) {
            if (this.gIW.iconType == 1) {
                this.gDl = this.gIW.name;
            } else if (this.gIW.iconType == 2) {
                this.gDl = "游戏";
                this.gHL = this.gIW.name;
            }
            this.gIX = this.gIW.bitmapWHRatio;
            this.gIV.a(this.gIX, this.gDl, this.gHL, this.gIW.sortTypeList);
        } else if (!StringUtils.isNull(this.gDl)) {
            this.gIV.a(this.gIX, this.gDl, this.gHL, this.gIY);
        } else {
            finish();
        }
        if (this.gIV.getRootView() != null) {
            setContentView(this.gIV.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gIV.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gIV != null) {
            this.gIV.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gIV != null) {
            this.gIV.onDestroy();
        }
    }
}
