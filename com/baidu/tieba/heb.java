package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.leb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.yy.render.ITransDataListener;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class heb {
    public static /* synthetic */ Interceptable $ic;
    public static heb e;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final ConcurrentHashMap<String, ieb> b;
    public final ConcurrentHashMap<String, String> c;
    public ConcurrentHashMap<String, RemoteCallbackList<ITransDataListener>> d;

    /* loaded from: classes6.dex */
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

        public final heb a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return heb.e;
            }
            return (heb) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947822244, "Lcom/baidu/tieba/heb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947822244, "Lcom/baidu/tieba/heb;");
                return;
            }
        }
        f = new a(null);
        e = new heb();
    }

    public heb() {
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
        this.a = "MessageChannel";
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
    }

    public final ieb b(String str, Context context, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, context, str2)) == null) {
            try {
                Object newInstance = Class.forName(str).getConstructor(Context.class, String.class).newInstance(context, str2);
                if (newInstance != null) {
                    return (ieb) newInstance;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.yy.render.trans.ServerMessageHandler");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (ieb) invokeLLL.objValue;
    }

    public final void c(String str, Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bundle != null) {
                ieb iebVar = this.b.get(str);
                if (iebVar == null) {
                    leb.a aVar = leb.b;
                    String str2 = this.a;
                    aVar.g(str2, "onBundleFromClient " + str + " no handler");
                    return;
                }
                iebVar.f(bundle);
                return;
            }
            leb.b.g(this.a, "onBundleFromClient null");
        }
    }

    public final boolean d(String str, Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bundle != null) {
                ieb iebVar = this.b.get(str);
                if (iebVar == null) {
                    leb.a aVar = leb.b;
                    String str2 = this.a;
                    aVar.g(str2, "onBundleFromClientForBoolean " + str + " no handler");
                    return false;
                }
                return iebVar.g(bundle);
            }
            leb.b.g(this.a, "onBundleFromClientForBoolean null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final String e(String str, Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bundle != null) {
                ieb iebVar = this.b.get(str);
                if (iebVar == null) {
                    leb.a aVar = leb.b;
                    String str2 = this.a;
                    aVar.g(str2, "onBundleFromClientForStr " + str + " no handler");
                    return "";
                }
                return iebVar.h(bundle);
            }
            leb.b.g(this.a, "onBundleFromClientForStr null");
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final void f(String str, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                    ieb iebVar = this.b.get(str);
                    if (iebVar == null) {
                        leb.a aVar = leb.b;
                        String str3 = this.a;
                        aVar.g(str3, "onDataFromClient " + str + " no handler");
                        return;
                    }
                    iebVar.i(str2);
                    return;
                }
            }
            leb.b.g(this.a, "onDataFromClient null");
        }
    }

    public final boolean k(String str, ITransDataListener iTransDataListener) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, iTransDataListener)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && iTransDataListener != null) {
                ieb remove = this.b.remove(str);
                if (remove != null) {
                    remove.l();
                }
                this.c.remove(str);
                RemoteCallbackList<ITransDataListener> remoteCallbackList = this.d.get(str);
                if (remoteCallbackList == null) {
                    return true;
                }
                return remoteCallbackList.unregister(iTransDataListener);
            }
            leb.b.g(this.a, "registerDataListener null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean g(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            boolean z2 = true;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (str2 != null && str2.length() != 0) {
                    z2 = false;
                }
                if (!z2) {
                    ieb iebVar = this.b.get(str);
                    if (iebVar == null) {
                        leb.a aVar = leb.b;
                        String str3 = this.a;
                        aVar.g(str3, "onDataFromClientForBoolean " + str + " no handler");
                        return false;
                    }
                    return iebVar.j(str2);
                }
            }
            leb.b.g(this.a, "onDataFromClientForBoolean null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final String h(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                    ieb iebVar = this.b.get(str);
                    if (iebVar == null) {
                        leb.a aVar = leb.b;
                        String str3 = this.a;
                        aVar.g(str3, "onDataFromClientForStr " + str + " no handler");
                        return "";
                    }
                    return iebVar.k(str2);
                }
            }
            leb.b.g(this.a, "onDataFromClientForStr null");
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final boolean i(Context context, String str, String str2, ITransDataListener iTransDataListener) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, str, str2, iTransDataListener)) == null) {
            boolean z2 = true;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (str2 != null && str2.length() != 0) {
                    z2 = false;
                }
                if (!z2 && iTransDataListener != null) {
                    if (this.b.get(str) != null) {
                        leb.a aVar = leb.b;
                        String str3 = this.a;
                        aVar.g(str3, "registerDataListener " + str + " has handler");
                        return false;
                    }
                    if (context == null) {
                        Intrinsics.throwNpe();
                    }
                    ieb b = b(str2, context, str);
                    if (b == null) {
                        leb.b.g(this.a, "registerDataListener reflect fail");
                        return false;
                    }
                    this.b.put(str, b);
                    this.c.put(str, str2);
                    RemoteCallbackList<ITransDataListener> remoteCallbackList = this.d.get(str);
                    if (remoteCallbackList == null) {
                        remoteCallbackList = new RemoteCallbackList<>();
                        this.d.put(str, remoteCallbackList);
                    }
                    return remoteCallbackList.register(iTransDataListener);
                }
            }
            leb.b.g(this.a, "registerDataListener null");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final jeb<String> j(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        boolean z2;
        jeb<String> jebVar;
        String transDataForStr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (str2.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (!this.d.containsKey(str)) {
                        return new jeb<>(false, str + " no handler");
                    }
                    RemoteCallbackList<ITransDataListener> remoteCallbackList = this.d.get(str);
                    if (remoteCallbackList == null) {
                        return new jeb<>(false, str + "  handler is null");
                    } else if (remoteCallbackList.getRegisteredCallbackCount() == 0) {
                        return new jeb<>(false, str + " callback count = 0");
                    } else {
                        try {
                            synchronized (remoteCallbackList) {
                                int beginBroadcast = remoteCallbackList.beginBroadcast();
                                String str3 = "";
                                leb.a aVar = leb.b;
                                String str4 = this.a;
                                aVar.g(str4, "sendData2MainProcessForStr callback count = " + beginBroadcast + WebvttCueParser.CHAR_SPACE);
                                if (1 <= beginBroadcast) {
                                    int i = 1;
                                    while (true) {
                                        transDataForStr = remoteCallbackList.getBroadcastItem(i - 1).transDataForStr(str, str2);
                                        Intrinsics.checkExpressionValueIsNotNull(transDataForStr, "listener.transDataForStr(channelId, data)");
                                        if (i == beginBroadcast) {
                                            break;
                                        }
                                        i++;
                                    }
                                    str3 = transDataForStr;
                                }
                                remoteCallbackList.finishBroadcast();
                                jebVar = new jeb<>(true, str3);
                            }
                            return jebVar;
                        } catch (Exception e2) {
                            leb.a aVar2 = leb.b;
                            String str5 = this.a;
                            aVar2.d(str5, "sendData2MainProcessForStr ex: " + e2.getMessage());
                            return new jeb<>(false, "");
                        }
                    }
                }
            }
            return new jeb<>(false, "channelId, data is null or empty");
        }
        return (jeb) invokeLL.objValue;
    }
}
