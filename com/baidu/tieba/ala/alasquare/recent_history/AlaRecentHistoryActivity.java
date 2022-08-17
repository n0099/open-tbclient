package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import com.baidu.ala.widget.multicolumn.absView.AbsTabActivity;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AlaRecentHistoryActivity extends AbsTabActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbsTabPagerAdapter a;

    /* loaded from: classes3.dex */
    public class a extends AbsTabActivity.CustomOnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaRecentHistoryActivity a;

        public a(AlaRecentHistoryActivity alaRecentHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecentHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaRecentHistoryActivity;
        }

        @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
        public void onPageScrolled(int i, float f, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
        public void onPageSelected(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                if (100 == i2) {
                    TiebaStatic.log("c12650");
                } else if (200 == i2) {
                    TiebaStatic.log("c12652");
                }
            }
        }
    }

    public AlaRecentHistoryActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AlaRecentHistoryAdapter(getSupportFragmentManager());
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public AbsTabPagerAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (AbsTabPagerAdapter) invokeV.objValue;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public void onPreInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPreInit();
            setOnPagerChangeListener(new a(this));
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, navigationBar) == null) {
            navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f11d3);
        }
    }
}
