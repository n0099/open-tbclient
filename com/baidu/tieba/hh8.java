package com.baidu.tieba;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.utils.LiveActivityHelper;
import com.baidu.tieba.push.PushExtData;
import com.baidu.tieba.push.PushRemindInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class hh8 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Activity> a;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hh8 hh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            xu4 xu4Var;
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof xu4) && (xu4Var = (xu4) customResponsedMessage.getData()) != null && (activity = xu4Var.b) != null && xu4Var.c != null) {
                if (this.a.e(activity.getClass().getName())) {
                    if (!Lifecycle.Event.ON_START.equals(xu4Var.c)) {
                        if (Lifecycle.Event.ON_DESTROY.equals(xu4Var.c)) {
                            this.a.a.remove(xu4Var.b);
                        }
                    } else if (this.a.a.contains(xu4Var.b)) {
                    } else {
                        this.a.a.add(xu4Var.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final hh8 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-747064237, "Lcom/baidu/tieba/hh8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-747064237, "Lcom/baidu/tieba/hh8$b;");
                    return;
                }
            }
            a = new hh8();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947823825, "Lcom/baidu/tieba/hh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947823825, "Lcom/baidu/tieba/hh8;");
                return;
            }
        }
        b = new String[]{LiveActivityHelper.MIX_ACTIVITY_NAME, LiveActivityHelper.MIX_TRANSLUCENT_ACTIVITY_NAME};
    }

    public hh8() {
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

    public static hh8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return b.a;
        }
        return (hh8) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().registerListener(new a(this, 2921698));
        }
    }

    public void f(PushExtData pushExtData, PushRemindInfo pushRemindInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pushExtData, pushRemindInfo) == null) && !this.a.isEmpty()) {
            new gh8((Activity) this.a.toArray()[0], pushExtData, pushRemindInfo).t();
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            for (String str2 : b) {
                if (str2.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
