package com.baidu.tieba;

import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class f4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(PbModel pbModel) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbModel)) == null) {
            String nowForumName = "";
            if (pbModel == null) {
                return "";
            }
            if (pbModel.getErrorNo() == 4) {
                String R0 = pbModel.R0();
                if (R0 != null && R0.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && pbModel.H0() != null) {
                    nowForumName = pbModel.H0().b;
                }
            } else {
                nowForumName = pbModel.s1().n().getName();
            }
            Intrinsics.checkNotNullExpressionValue(nowForumName, "nowForumName");
            return nowForumName;
        }
        return (String) invokeL.objValue;
    }
}
