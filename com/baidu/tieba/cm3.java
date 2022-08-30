package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public interface cm3 {

    /* loaded from: classes3.dex */
    public static class a implements cm3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final cm3 a;

        public a(cm3 delegation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {delegation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(delegation, "delegation");
            this.a = delegation;
        }

        @Override // com.baidu.tieba.cm3
        public String a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return this.a.a(context);
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.cm3
        public String b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return this.a.b(context);
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.cm3
        public String c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return this.a.c(context);
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.cm3
        public String d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return this.a.d(context);
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.cm3
        public String getDeviceId(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return this.a.getDeviceId(context);
            }
            return (String) invokeL.objValue;
        }
    }

    String a(Context context);

    String b(Context context);

    String c(Context context);

    String d(Context context);

    String getDeviceId(Context context);
}
