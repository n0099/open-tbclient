package com.baidu.tbadk.pluginUtils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ResourcesUtil {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, Resources> sResources;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2106164952, "Lcom/baidu/tbadk/pluginUtils/ResourcesUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2106164952, "Lcom/baidu/tbadk/pluginUtils/ResourcesUtil;");
                return;
            }
        }
        sResources = new HashMap<>();
    }

    public ResourcesUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Resources getResources(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null) {
                if (TextUtils.isEmpty(str)) {
                    return context.getResources();
                }
                Resources resources = sResources.get(str);
                if (resources == null) {
                    try {
                        AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                        assetManager.getClass().getMethod(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, String.class).invoke(assetManager, str);
                        resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
                    } catch (Exception unused) {
                        resources = context.getResources();
                    }
                }
                sResources.put(str, resources);
                return resources;
            }
            throw new IllegalArgumentException("context can not be null.");
        }
        return (Resources) invokeLL.objValue;
    }
}
