package com.baidu.tbadk.novel;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class NovelResult {
    public static final /* synthetic */ NovelResult[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NovelResult DEPOSIT_CANCEL;
    public static final NovelResult DEPOSIT_FAIL;
    public static final NovelResult DEPOSIT_SUCC;
    public static final NovelResult PAY_NOVEL_CANCEL;
    public static final NovelResult PAY_NOVEL_CONFIRM_DIALOG;
    public static final NovelResult PAY_NOVEL_FAIL;
    public static final NovelResult PAY_NOVEL_SUCC;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(922631352, "Lcom/baidu/tbadk/novel/NovelResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(922631352, "Lcom/baidu/tbadk/novel/NovelResult;");
                return;
            }
        }
        DEPOSIT_SUCC = new NovelResult("DEPOSIT_SUCC", 0);
        DEPOSIT_FAIL = new NovelResult("DEPOSIT_FAIL", 1);
        DEPOSIT_CANCEL = new NovelResult("DEPOSIT_CANCEL", 2);
        PAY_NOVEL_SUCC = new NovelResult("PAY_NOVEL_SUCC", 3);
        PAY_NOVEL_FAIL = new NovelResult("PAY_NOVEL_FAIL", 4);
        PAY_NOVEL_CANCEL = new NovelResult("PAY_NOVEL_CANCEL", 5);
        NovelResult novelResult = new NovelResult("PAY_NOVEL_CONFIRM_DIALOG", 6);
        PAY_NOVEL_CONFIRM_DIALOG = novelResult;
        $VALUES = new NovelResult[]{DEPOSIT_SUCC, DEPOSIT_FAIL, DEPOSIT_CANCEL, PAY_NOVEL_SUCC, PAY_NOVEL_FAIL, PAY_NOVEL_CANCEL, novelResult};
    }

    public NovelResult(String str, int i) {
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

    public static NovelResult valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (NovelResult) Enum.valueOf(NovelResult.class, str);
        }
        return (NovelResult) invokeL.objValue;
    }

    public static NovelResult[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (NovelResult[]) $VALUES.clone();
        }
        return (NovelResult[]) invokeV.objValue;
    }
}
