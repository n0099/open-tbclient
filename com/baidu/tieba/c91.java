package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public interface c91 {
    public static final c91 a = new a();

    boolean a(Context context, String str, String str2, @Nullable jk0 jk0Var);

    /* loaded from: classes5.dex */
    public class a implements c91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.c91
        public boolean a(Context context, String str, String str2, @Nullable jk0 jk0Var) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, str2, jk0Var)) == null) {
                if (str != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("refer", str2);
                    hashMap.put("from_web_view", Boolean.TRUE);
                    return ak0.e(str, context, hashMap, jk0Var);
                }
                return false;
            }
            return invokeLLLL.booleanValue;
        }
    }

    @Autowired
    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @NonNull
        @Inject(force = false)
        public static c91 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return c91.a;
            }
            return (c91) invokeV.objValue;
        }
    }
}
