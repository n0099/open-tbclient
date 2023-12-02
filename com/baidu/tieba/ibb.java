package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.HeadCardCover;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public final class ibb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hbb a;
    public ThemeColorInfo b;
    public lbb c;

    public ibb() {
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
        this.a = new hbb();
    }

    public final ThemeColorInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public final hbb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (hbb) invokeV.objValue;
    }

    public final lbb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (lbb) invokeV.objValue;
    }

    public final void d(HeadCardCover headCardCover) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, headCardCover) != null) || headCardCover == null) {
            return;
        }
        hbb hbbVar = new hbb();
        this.a = hbbVar;
        hbbVar.d(headCardCover.freq);
        this.b = headCardCover.card_background;
        lbb lbbVar = new lbb();
        this.c = lbbVar;
        if (lbbVar != null) {
            lbbVar.q(headCardCover.match_info);
        }
    }

    public final void e(tbclient.Personalized.HeadCardCover headCardCover) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, headCardCover) != null) || headCardCover == null) {
            return;
        }
        hbb hbbVar = new hbb();
        this.a = hbbVar;
        hbbVar.e(headCardCover.freq);
        this.b = headCardCover.card_background;
        lbb lbbVar = new lbb();
        this.c = lbbVar;
        if (lbbVar != null) {
            lbbVar.r(headCardCover.match_info);
        }
    }
}
