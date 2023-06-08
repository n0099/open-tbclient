package com.baidu.tieba;

import android.graphics.Bitmap;
import android.os.RemoteCallbackList;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.leb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.render.IRemoteListener;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class deb {
    public static /* synthetic */ Interceptable $ic;
    public static deb b;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public RemoteCallbackList<IRemoteListener> a;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final deb a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return deb.b;
            }
            return (deb) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947703080, "Lcom/baidu/tieba/deb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947703080, "Lcom/baidu/tieba/deb;");
                return;
            }
        }
        c = new a(null);
        b = new deb();
    }

    public deb() {
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
        this.a = new RemoteCallbackList<>();
    }

    public final synchronized void b(String str, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this) {
                if (!Intrinsics.areEqual(str, "")) {
                    int i = 1;
                    if (str2 != null && str2.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        try {
                            int beginBroadcast = this.a.beginBroadcast();
                            leb.a aVar = leb.b;
                            aVar.a("listener size = " + beginBroadcast);
                            if (1 <= beginBroadcast) {
                                while (true) {
                                    this.a.getBroadcastItem(i - 1).action(str, str2);
                                    if (i == beginBroadcast) {
                                        break;
                                    }
                                    i++;
                                }
                            }
                            this.a.finishBroadcast();
                        } catch (Exception e) {
                            leb.a aVar2 = leb.b;
                            aVar2.c("(executeAction) ex: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final synchronized boolean c(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            synchronized (this) {
                if (!Intrinsics.areEqual(str, "")) {
                    if (str2 != null && str2.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        try {
                            int beginBroadcast = this.a.beginBroadcast();
                            if (1 <= beginBroadcast) {
                                int i = 1;
                                while (true) {
                                    this.a.getBroadcastItem(i - 1).transData(str, str2);
                                    if (i == beginBroadcast) {
                                        break;
                                    }
                                    i++;
                                }
                            }
                            this.a.finishBroadcast();
                            return true;
                        } catch (Exception e) {
                            leb.a aVar = leb.b;
                            aVar.c("(executeData) ex: " + e.getMessage());
                            e.printStackTrace();
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean f(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bitmap)) == null) {
            synchronized (this) {
                if (Intrinsics.areEqual(str, "")) {
                    return false;
                }
                try {
                    int beginBroadcast = this.a.beginBroadcast();
                    leb.a aVar = leb.b;
                    aVar.f("(sendBitmap) channelId: " + str + ", size = " + beginBroadcast);
                    if (1 <= beginBroadcast) {
                        int i = 1;
                        while (true) {
                            this.a.getBroadcastItem(i - 1).transBitmap(str, bitmap);
                            if (i == beginBroadcast) {
                                break;
                            }
                            i++;
                        }
                    }
                    this.a.finishBroadcast();
                    return true;
                } catch (Exception e) {
                    leb.a aVar2 = leb.b;
                    aVar2.c("(sendBitmap) ex: " + e.getMessage());
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public final void d(IRemoteListener iRemoteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iRemoteListener) == null) {
            this.a.register(iRemoteListener);
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            b("reportCrash", str);
        }
    }

    public final boolean g(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, bitmap)) == null) {
            return f(str, bitmap);
        }
        return invokeLL.booleanValue;
    }

    public final boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            return c(str, str2);
        }
        return invokeLL.booleanValue;
    }
}
