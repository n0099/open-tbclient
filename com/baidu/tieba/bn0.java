package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public interface bn0 {

    /* loaded from: classes3.dex */
    public interface a {
    }

    void a(@Nullable String str, @Nullable String str2, @Nullable a aVar);

    @Autowired
    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Singleton
        @Inject(force = false)
        public static bn0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return jw0.a();
            }
            return (bn0) invokeV.objValue;
        }
    }
}
