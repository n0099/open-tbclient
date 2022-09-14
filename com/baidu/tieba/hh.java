package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, intent)) == null) {
            try {
                context.sendBroadcast(intent);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65537, null, context, intent, serviceConnection, i)) == null) {
            try {
                context.bindService(intent, serviceConnection, i);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLLLI.booleanValue;
    }

    public static boolean startActivity(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
            try {
                if (!(context instanceof Activity) && intent != null) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean startActivityForResult(Activity activity, Intent intent, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, activity, intent, i)) == null) {
            try {
                activity.startActivityForResult(intent, i);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    public static boolean startService(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, intent)) == null) {
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean stopService(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, intent)) == null) {
            try {
                context.stopService(intent);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean unbindService(Context context, ServiceConnection serviceConnection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, serviceConnection)) == null) {
            try {
                context.unbindService(serviceConnection);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
