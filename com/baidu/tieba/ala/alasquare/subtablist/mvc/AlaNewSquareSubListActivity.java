package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.content.Intent;
import android.os.Bundle;
import c.a.u0.a0.f.h.c.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class AlaNewSquareSubListActivity extends BaseActivity<AlaNewSquareSubListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mAlaNewSquareSubListController;
    public String mBitmapRatio;
    public String mEntryName;
    public String mLableName;
    public List<String> mSubTypeList;
    public AlaSquareTabInfo mTabInfo;

    public AlaNewSquareSubListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void handleIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, intent) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            a aVar = this.mAlaNewSquareSubListController;
            if (aVar != null) {
                aVar.h(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            this.mAlaNewSquareSubListController = new a(getPageContext(), true);
            if (getIntent() != null) {
                handleIntent(getIntent());
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            a aVar = this.mAlaNewSquareSubListController;
            if (aVar != null) {
                aVar.i();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            this.mAlaNewSquareSubListController.k();
        }
    }
}
