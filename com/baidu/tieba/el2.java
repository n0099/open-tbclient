package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes4.dex */
public class el2 extends yh2<al2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yh2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pageScrollUp" : (String) invokeV.objValue;
    }

    public el2() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yh2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull al2 al2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, al2Var) == null) {
            int i = command.arg1;
            int g = vh3.g(command.arg2);
            int i2 = command.arg3;
            int i3 = command.arg4;
            String str = command.what;
            d(al2Var, str, "(top, inputHeight, keyboardHeight, cursorSpacing) " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + g + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3, false);
            al2Var.y0(i, g, i2, i3);
        }
    }
}
