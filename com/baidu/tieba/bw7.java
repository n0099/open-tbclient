package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.interfaces.PermissionService;
import com.baidu.tieba.gameassist.permission.PermissionFragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class bw7 implements PermissionService {
    public static /* synthetic */ Interceptable $ic;
    public static Map<Integer, Object> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659463, "Lcom/baidu/tieba/bw7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659463, "Lcom/baidu/tieba/bw7;");
                return;
            }
        }
        a = new HashMap();
    }

    public bw7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.yy.gameassist.interfaces.PermissionService
    public void requestFloatWindowPermission(@NonNull Activity activity, @Nullable PermissionService.IGrantCallback iGrantCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, iGrantCallback) == null) && iGrantCallback != null) {
            a.put(Integer.valueOf(iGrantCallback.hashCode()), iGrantCallback);
            Intent intent = new Intent(activity, PermissionFragmentActivity.class);
            intent.putExtra("request", "requestFloatPermission");
            intent.putExtra(WebChromeClient.KEY_ARG_CALLBACK, iGrantCallback.hashCode());
            activity.startActivity(intent);
        }
    }

    @Override // com.baidu.searchbox.yy.gameassist.interfaces.PermissionService
    public void requestPermission(@NonNull Activity activity, @NonNull String[] strArr, @Nullable PermissionService.IGrantCallback iGrantCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, strArr, iGrantCallback) == null) && iGrantCallback != null) {
            a.put(Integer.valueOf(iGrantCallback.hashCode()), iGrantCallback);
            Intent intent = new Intent(activity, PermissionFragmentActivity.class);
            intent.putExtra("request", "requestPermissions");
            intent.putExtra("permissions", strArr);
            intent.putExtra(WebChromeClient.KEY_ARG_CALLBACK, iGrantCallback.hashCode());
            activity.startActivity(intent);
        }
    }
}
