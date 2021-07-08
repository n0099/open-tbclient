package com.baidu.tieba.flutter.plugin.commonPlatformView;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class CommonPlatformViewFactory extends PlatformViewFactory {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, CommonPlatformView> viewMap;
    public transient /* synthetic */ FieldHolder $fh;
    public final BinaryMessenger messenger;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-168034747, "Lcom/baidu/tieba/flutter/plugin/commonPlatformView/CommonPlatformViewFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-168034747, "Lcom/baidu/tieba/flutter/plugin/commonPlatformView/CommonPlatformViewFactory;");
                return;
            }
        }
        viewMap = new HashMap<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonPlatformViewFactory(BinaryMessenger binaryMessenger) {
        super(StandardMessageCodec.INSTANCE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binaryMessenger};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((MessageCodec) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.messenger = binaryMessenger;
    }

    public static void removePlatformViewByPersistentViewId(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65538, null, i2) == null) && viewMap.containsKey(String.valueOf(i2))) {
            viewMap.remove(Integer.valueOf(i2));
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewFactory
    public PlatformView create(Context context, int i2, Object obj) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i2, obj)) == null) {
            Map map = (obj == null || !(obj instanceof Map)) ? null : (Map) obj;
            String valueOf = map == null ? "0" : String.valueOf(map.get("persistentViewId"));
            if (Integer.parseInt(valueOf) < 0) {
                CommonPlatformView commonPlatformView = viewMap.get(valueOf);
                if (commonPlatformView == null) {
                    CommonPlatformView commonPlatformView2 = new CommonPlatformView(context, this.messenger, i2, map);
                    viewMap.put(valueOf, commonPlatformView2);
                    return commonPlatformView2;
                }
                return commonPlatformView;
            }
            return new CommonPlatformView(context, this.messenger, i2, map);
        }
        return (PlatformView) invokeLIL.objValue;
    }
}
