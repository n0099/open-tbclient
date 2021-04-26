package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.BaseActivity;
import d.a.j0.t.d.g.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaNewSquareSubListActivity extends BaseActivity<AlaNewSquareSubListActivity> {
    public a mAlaNewSquareSubListController;
    public String mBitmapRatio;
    public String mEntryName;
    public String mLableName;
    public List<String> mSubTypeList;
    public AlaSquareTabInfo mTabInfo;

    private void handleIntent(Intent intent) {
        this.mTabInfo = (AlaSquareTabInfo) intent.getParcelableExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA);
        this.mEntryName = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME);
        this.mLableName = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME);
        this.mBitmapRatio = intent.getStringExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO);
        this.mSubTypeList = intent.getStringArrayListExtra(AlaNewSquareSubListActivityConfig.ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST);
        AlaSquareTabInfo alaSquareTabInfo = this.mTabInfo;
        if (alaSquareTabInfo != null) {
            int i2 = alaSquareTabInfo.iconType;
            if (i2 == 1) {
                this.mEntryName = alaSquareTabInfo.name;
            } else if (i2 == 2) {
                this.mEntryName = "游戏";
                this.mLableName = alaSquareTabInfo.name;
            }
            AlaSquareTabInfo alaSquareTabInfo2 = this.mTabInfo;
            String str = alaSquareTabInfo2.bitmapWHRatio;
            this.mBitmapRatio = str;
            this.mAlaNewSquareSubListController.l(str, this.mEntryName, this.mLableName, alaSquareTabInfo2.sortTypeList);
        } else if (!StringUtils.isNull(this.mEntryName)) {
            this.mAlaNewSquareSubListController.l(this.mBitmapRatio, this.mEntryName, this.mLableName, this.mSubTypeList);
        } else {
            finish();
        }
        if (this.mAlaNewSquareSubListController.f() != null) {
            setContentView(this.mAlaNewSquareSubListController.f());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.mAlaNewSquareSubListController;
        if (aVar != null) {
            aVar.h(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlaNewSquareSubListController = new a(getPageContext(), true);
        if (getIntent() != null) {
            handleIntent(getIntent());
        } else {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.mAlaNewSquareSubListController;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mAlaNewSquareSubListController.k();
    }
}
