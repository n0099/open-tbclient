package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ef6 extends FragmentDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaGameFrsLiveTabFragment a;

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public ef6() {
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
        this.a = new AlaGameFrsLiveTabFragment();
        getFragmentTabStructure().frag = this.a;
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public FragmentTabStructure createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
            fragmentTabStructure.type = 2;
            fragmentTabStructure.textResId = R.string.ala_live;
            fragmentTabStructure.showIconType = FragmentTabStructure.SHOWTEXT;
            return fragmentTabStructure;
        }
        return (FragmentTabStructure) invokeV.objValue;
    }

    public void a(fj7 fj7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, fj7Var) != null) || fj7Var == null || !fj7Var.h(2)) {
            return;
        }
        fj7Var.a(this);
    }

    public void b(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (alaGameFrsLiveTabFragment = this.a) != null) {
            alaGameFrsLiveTabFragment.g2(str);
        }
    }

    public void c(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (alaGameFrsLiveTabFragment = this.a) != null) {
            alaGameFrsLiveTabFragment.h2(str);
        }
    }

    public void d(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (alaGameFrsLiveTabFragment = this.a) != null) {
            alaGameFrsLiveTabFragment.i2(str);
        }
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            this.mIndicator = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }
}
