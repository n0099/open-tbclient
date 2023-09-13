package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.HeadCardCover;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public final class axa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zwa a;
    public ThemeColorInfo b;
    public cxa c;

    public axa() {
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
        this.a = new zwa();
    }

    public final ThemeColorInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public final zwa b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (zwa) invokeV.objValue;
    }

    public final cxa c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (cxa) invokeV.objValue;
    }

    public final void d(HeadCardCover headCardCover) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, headCardCover) != null) || headCardCover == null) {
            return;
        }
        zwa zwaVar = new zwa();
        this.a = zwaVar;
        zwaVar.d(headCardCover.freq);
        this.b = headCardCover.card_background;
        cxa cxaVar = new cxa();
        this.c = cxaVar;
        if (cxaVar != null) {
            cxaVar.q(headCardCover.match_info);
        }
    }

    public final void e(tbclient.Personalized.HeadCardCover headCardCover) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, headCardCover) != null) || headCardCover == null) {
            return;
        }
        zwa zwaVar = new zwa();
        this.a = zwaVar;
        zwaVar.e(headCardCover.freq);
        this.b = headCardCover.card_background;
        cxa cxaVar = new cxa();
        this.c = cxaVar;
        if (cxaVar != null) {
            cxaVar.r(headCardCover.match_info);
        }
    }
}
