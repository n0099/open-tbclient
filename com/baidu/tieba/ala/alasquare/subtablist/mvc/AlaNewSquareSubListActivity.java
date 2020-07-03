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
    private String fqb;
    private String fuy;
    private a fvI;
    private AlaSquareTabInfo fvJ;
    private String fvK;
    private List<String> fvL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fvI = new a(getPageContext(), true);
        if (getIntent() != null) {
            J(getIntent());
        } else {
            finish();
        }
    }

    private void J(Intent intent) {
        this.fvJ = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.fqb = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.fuy = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.fvK = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.fvL = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        if (this.fvJ != null) {
            if (this.fvJ.iconType == 1) {
                this.fqb = this.fvJ.name;
            } else if (this.fvJ.iconType == 2) {
                this.fqb = "游戏";
                this.fuy = this.fvJ.name;
            }
            this.fvK = this.fvJ.bitmapWHRatio;
            this.fvI.a(this.fvK, this.fqb, this.fuy, this.fvJ.sortTypeList);
        } else if (!StringUtils.isNull(this.fqb)) {
            this.fvI.a(this.fvK, this.fqb, this.fuy, this.fvL);
        } else {
            finish();
        }
        if (this.fvI.getRootView() != null) {
            setContentView(this.fvI.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fvI.refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fvI != null) {
            this.fvI.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fvI != null) {
            this.fvI.onDestroy();
        }
    }
}
