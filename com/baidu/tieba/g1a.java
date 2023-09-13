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
/* loaded from: classes6.dex */
public class g1a {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Activity> a;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g1a g1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g1aVar, Integer.valueOf(i)};
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
            this.a = g1aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            g45 g45Var;
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g45) && (g45Var = (g45) customResponsedMessage.getData()) != null && (activity = g45Var.b) != null && g45Var.c != null) {
                if (this.a.e(activity.getClass().getName())) {
                    if (!Lifecycle.Event.ON_START.equals(g45Var.c)) {
                        if (Lifecycle.Event.ON_DESTROY.equals(g45Var.c)) {
                            this.a.a.remove(g45Var.b);
                        }
                    } else if (this.a.a.contains(g45Var.b)) {
                    } else {
                        this.a.a.add(g45Var.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final g1a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-825265612, "Lcom/baidu/tieba/g1a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-825265612, "Lcom/baidu/tieba/g1a$b;");
                    return;
                }
            }
            a = new g1a();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947742450, "Lcom/baidu/tieba/g1a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947742450, "Lcom/baidu/tieba/g1a;");
                return;
            }
        }
        b = new String[]{LiveActivityHelper.MIX_ACTIVITY_NAME, LiveActivityHelper.MIX_TRANSLUCENT_ACTIVITY_NAME};
    }

    public g1a() {
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

    public static g1a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return b.a;
        }
        return (g1a) invokeV.objValue;
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
            new f1a((Activity) this.a.toArray()[0], pushExtData, pushRemindInfo).t();
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
