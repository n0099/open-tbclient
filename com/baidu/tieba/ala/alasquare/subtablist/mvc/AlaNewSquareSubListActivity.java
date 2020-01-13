package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.BaseActivity;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaNewSquareSubListActivity extends BaseActivity<AlaNewSquareSubListActivity> {
    private String ejF;
    private String enT;
    private a epf;
    private AlaSquareTabInfo epg;
    private String eph;
    private List<String> epi;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.epf = new a(getPageContext(), true);
        if (getIntent() != null) {
            aa(getIntent());
        } else {
            finish();
        }
    }

    private void aa(Intent intent) {
        this.epg = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.ejF = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.enT = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.eph = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.epi = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.epg != null) {
            if (this.epg.iconType == 1) {
                this.ejF = this.epg.name;
            } else if (this.epg.iconType == 2) {
                this.ejF = "游戏";
                this.enT = this.epg.name;
            }
            this.eph = this.epg.bitmapWHRatio;
            this.epf.a(this.eph, this.ejF, this.enT, this.epg.sortTypeList);
        } else if (!StringUtils.isNull(this.ejF)) {
            this.epf.a(this.eph, this.ejF, this.enT, this.epi);
        } else {
            finish();
        }
        if (this.epf.getRootView() != null) {
            setContentView(this.epf.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.epf.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.epf != null) {
            this.epf.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.epf != null) {
            this.epf.onDestroy();
        }
    }
}
