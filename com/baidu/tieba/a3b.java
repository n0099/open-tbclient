package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public ArrayList<d2b> b;

    public a3b() {
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

    public ArrayList<d2b> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public void c(ThemeCardInMain themeCardInMain) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themeCardInMain) != null) || themeCardInMain == null) {
            return;
        }
        this.a = themeCardInMain.card_category;
        List<ThemeCardPropMain> list = themeCardInMain.props;
        if (list != null && list.size() > 0) {
            this.b = new ArrayList<>();
            for (ThemeCardPropMain themeCardPropMain : list) {
                if (themeCardPropMain != null) {
                    d2b d2bVar = new d2b();
                    d2bVar.k(themeCardPropMain);
                    this.b.add(d2bVar);
                }
            }
        }
    }
}
