package com.baidu.tieba;

import android.annotation.TargetApi;
import android.app.Activity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@TargetApi(23)
/* loaded from: classes5.dex */
public class f81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static boolean a(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, activity, str)) == null) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return invokeLL.booleanValue;
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, activity, strArr, i) == null) {
            if (activity instanceof a) {
                ((a) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        }
    }
}
