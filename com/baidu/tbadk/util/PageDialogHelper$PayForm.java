package com.baidu.tbadk.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class PageDialogHelper$PayForm {
    public static final /* synthetic */ PageDialogHelper$PayForm[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PageDialogHelper$PayForm DIALOG;
    public static final PageDialogHelper$PayForm NORMAL;
    public static final PageDialogHelper$PayForm NOT_SET;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1561503780, "Lcom/baidu/tbadk/util/PageDialogHelper$PayForm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1561503780, "Lcom/baidu/tbadk/util/PageDialogHelper$PayForm;");
                return;
            }
        }
        NOT_SET = new PageDialogHelper$PayForm("NOT_SET", 0);
        DIALOG = new PageDialogHelper$PayForm("DIALOG", 1);
        PageDialogHelper$PayForm pageDialogHelper$PayForm = new PageDialogHelper$PayForm("NORMAL", 2);
        NORMAL = pageDialogHelper$PayForm;
        $VALUES = new PageDialogHelper$PayForm[]{NOT_SET, DIALOG, pageDialogHelper$PayForm};
    }

    public PageDialogHelper$PayForm(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PageDialogHelper$PayForm valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PageDialogHelper$PayForm) Enum.valueOf(PageDialogHelper$PayForm.class, str) : (PageDialogHelper$PayForm) invokeL.objValue;
    }

    public static PageDialogHelper$PayForm[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PageDialogHelper$PayForm[]) $VALUES.clone() : (PageDialogHelper$PayForm[]) invokeV.objValue;
    }
}
