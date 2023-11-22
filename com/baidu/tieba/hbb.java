package com.baidu.tieba;

import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface hbb {

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Function1<JSONObject, Unit> a(hbb hbbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hbbVar)) == null) {
                return null;
            }
            return (Function1) invokeL.objValue;
        }
    }

    WrapListener[] a();

    fbb[] b();

    Function1<JSONObject, Unit> e();

    ebb[] f();
}
