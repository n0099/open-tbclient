package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.channel.GdtHelper;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class d3a implements GdtHelper.GdtNativeContainerCreator {
    public static /* synthetic */ Interceptable $ic;
    public static final d3a b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<WeakReference<NativeAdContainer>> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947654999, "Lcom/baidu/tieba/d3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947654999, "Lcom/baidu/tieba/d3a;");
                return;
            }
        }
        b = new d3a();
    }

    public d3a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashSet();
    }

    @Override // com.fun.ad.sdk.internal.api.channel.GdtHelper.GdtNativeContainerCreator
    public ViewGroup generateGdtNativeContainer(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            NativeAdContainer nativeAdContainer = new NativeAdContainer(context);
            this.a.add(new WeakReference<>(nativeAdContainer));
            return nativeAdContainer;
        }
        return (ViewGroup) invokeL.objValue;
    }
}
