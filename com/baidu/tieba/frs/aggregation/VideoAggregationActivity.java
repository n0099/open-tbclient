package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kg;
import com.repackage.p85;
/* loaded from: classes3.dex */
public class VideoAggregationActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoAggregationFragment mFragment;
    public String mFrom;
    public String mId;

    public VideoAggregationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.m85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom) ? "a023" : "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public p85 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            p85 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && StringUtils.isNull(this.mId) && VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom)) {
                pageStayDurationItem.C(kg.g(this.mId, 0L));
            }
            return pageStayDurationItem;
        }
        return (p85) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.mFragment == null) {
            return;
        }
        getLayoutMode().k(i == 1);
        getLayoutMode().j(this.mFragment.getView());
        this.mFragment.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                setSwipeBackEnabled(false);
            } else {
                setSwipeBackEnabled(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d005e);
            this.mFrom = getIntent().getStringExtra("PARAM_FROM");
            this.mId = getIntent().getStringExtra("PARAM_FID");
            String stringExtra = getIntent().getStringExtra("st_type");
            String stringExtra2 = getIntent().getStringExtra("yuelaou_locate");
            if (TextUtils.isEmpty(this.mId)) {
                finish();
            }
            this.mFragment = VideoAggregationFragment.G0(this.mId, this.mFrom, stringExtra, stringExtra2);
            getSupportFragmentManager().beginTransaction().replace(R.id.obfuscated_res_0x7f0906cd, this.mFragment).commit();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        VideoAggregationFragment videoAggregationFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, keyEvent)) == null) {
            if (keyEvent != null && (videoAggregationFragment = this.mFragment) != null) {
                if (videoAggregationFragment.K0(i)) {
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
