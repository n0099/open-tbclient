package com.baidu.tbadk.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tieba.sc;
import com.baidu.tieba.zi5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class AppLaunchInfoFetcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface a {
        void onFinish(zi5 zi5Var);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type ACTIVITY;
        public static final Type BROADCAST;
        public static final Type PROVIDER;
        public static final Type SERVICE;
        public static final Type UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2015997268, "Lcom/baidu/tbadk/util/AppLaunchInfoFetcher$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2015997268, "Lcom/baidu/tbadk/util/AppLaunchInfoFetcher$Type;");
                    return;
                }
            }
            ACTIVITY = new Type("ACTIVITY", 0);
            SERVICE = new Type("SERVICE", 1);
            BROADCAST = new Type("BROADCAST", 2);
            PROVIDER = new Type("PROVIDER", 3);
            Type type = new Type(RomUtils.UNKNOWN, 4);
            UNKNOWN = type;
            $VALUES = new Type[]{ACTIVITY, SERVICE, BROADCAST, PROVIDER, type};
        }

        public Type(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Type) Enum.valueOf(Type.class, str);
            }
            return (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Type[]) $VALUES.clone();
            }
            return (Type[]) invokeV.objValue;
        }
    }

    public static Intent a(Message message) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, message)) == null) {
            if (message != null && (obj = message.obj) != null) {
                Object d = sc.d(obj, IntentData.KEY);
                if (d instanceof Intent) {
                    return (Intent) d;
                }
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }

    @TargetApi(23)
    public static zi5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            List<ActivityManager.AppTask> appTasks = ((ActivityManager) context.getSystemService("activity")).getAppTasks();
            if (appTasks != null) {
                for (ActivityManager.AppTask appTask : appTasks) {
                    if (appTask != null && appTask.getTaskInfo() != null && appTask.getTaskInfo().baseIntent != null && appTask.getTaskInfo().baseIntent.getComponent() != null) {
                        return new zi5(Type.ACTIVITY, appTask.getTaskInfo().baseIntent);
                    }
                }
                return null;
            }
            return null;
        }
        return (zi5) invokeL.objValue;
    }

    public static Type d(Message message) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, message)) == null) {
            if (message != null && (obj = message.obj) != null) {
                String name = obj.getClass().getName();
                if (name.contains("ReceiverData")) {
                    return Type.BROADCAST;
                }
                if (name.contains("CreateServiceData")) {
                    return Type.SERVICE;
                }
                if (name.contains("BindServiceData")) {
                    return Type.SERVICE;
                }
                return Type.UNKNOWN;
            }
            return Type.UNKNOWN;
        }
        return (Type) invokeL.objValue;
    }

    public static zi5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Object d = sc.d(Looper.myQueue(), "mMessages");
            if (d instanceof Message) {
                Message message = (Message) d;
                int i = 0;
                while (message != null && i < 10) {
                    i++;
                    Intent a2 = a(message);
                    Type d2 = d(message);
                    if (a2 != null && a2.getComponent() != null) {
                        return new zi5(Type.ACTIVITY, a2);
                    }
                    if (d2 != Type.UNKNOWN) {
                        return new zi5(d2, null);
                    }
                    Object d3 = sc.d(message, UnitedSchemeConstants.UNITED_SCHEME_NEXT);
                    if (d3 instanceof Message) {
                        message = (Message) d3;
                    } else {
                        message = null;
                    }
                }
            }
            return null;
        }
        return (zi5) invokeV.objValue;
    }

    public static void e(Context context, List<a> list) {
        zi5 zi5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, list) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    zi5Var = b(context);
                } else {
                    zi5Var = null;
                }
                if (zi5Var == null) {
                    zi5Var = c();
                }
                if (zi5Var == null) {
                    zi5Var = new zi5(Type.UNKNOWN, null);
                }
                for (a aVar : list) {
                    aVar.onFinish(zi5Var);
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }
}
