package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.ala.personcenter.AlaPersonCenterFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b16 extends qa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaPersonCenterFragment c;

    @Override // com.baidu.tieba.qa5
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public b16() {
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
        this.c = new AlaPersonCenterFragment();
        b().a = this.c;
    }

    @Override // com.baidu.tieba.qa5
    public ra5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ra5 ra5Var = new ra5();
            ra5Var.e = 5;
            ra5Var.b = R.string.ala_live;
            ra5Var.i = ra5.k;
            return ra5Var;
        }
        return (ra5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qa5
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            this.b = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.b;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    public void g(cl6 cl6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, cl6Var) != null) || cl6Var == null || !cl6Var.h(5)) {
            return;
        }
        cl6Var.a(this);
    }

    public void h(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (alaPersonCenterFragment = this.c) != null) {
            alaPersonCenterFragment.x1(str);
        }
    }

    public void i(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (alaPersonCenterFragment = this.c) != null) {
            alaPersonCenterFragment.y1(str);
        }
    }

    public void j(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (alaPersonCenterFragment = this.c) != null) {
            alaPersonCenterFragment.z1(str);
        }
    }

    public void k(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (alaPersonCenterFragment = this.c) != null) {
            alaPersonCenterFragment.A1(str);
        }
    }
}
