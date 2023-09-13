package com.baidu.tieba;

import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.x73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class h83 implements x73.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Deque<Message>> a;

    public h83() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
    }

    @Override // com.baidu.tieba.x73.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (String str : this.a.keySet()) {
                c(str);
            }
        }
    }

    @Override // com.baidu.tieba.x73.c
    public void b(@NonNull z73 z73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z73Var) == null) {
            Message h = z73Var.h();
            if (z73Var.m()) {
                h(h);
            }
            Set<SwanAppProcessInfo> l = z73Var.l();
            Set<String> k = z73Var.k();
            if (z73Var.n()) {
                Iterator<g83> it = i83.k().q().iterator();
                while (it.hasNext()) {
                    g83 next = it.next();
                    boolean g = g(next, k);
                    if (l.contains(next.b) || g) {
                        next.g0(h);
                        if (g) {
                            k.remove(next.getAppId());
                        }
                    }
                }
                f(k, h);
                return;
            }
            Iterator<g83> it2 = i83.k().q().iterator();
            while (it2.hasNext()) {
                g83 next2 = it2.next();
                if (next2 != null && next2.T() && (l.contains(next2.b) || g(next2, k))) {
                    next2.g0(h);
                }
            }
        }
    }

    @Override // com.baidu.tieba.x73.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Deque<Message> deque = this.a.get(str);
            x73.f("flushMsg:: appid=" + str + " msgQueue=" + deque);
            if (deque != null && !deque.isEmpty()) {
                List<g83> j = i83.k().j(str);
                x73.f("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + j.size());
                if (j.isEmpty()) {
                    return;
                }
                for (g83 g83Var : j) {
                    g83Var.i0(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.tieba.x73.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a.remove(str);
        }
    }

    public final void h(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
            try {
                i83.k().e.send(message);
            } catch (RemoteException e) {
                x73.f(Log.getStackTraceString(e));
            }
        }
    }

    public final void e(String str, @NonNull Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, message) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        Deque<Message> deque = this.a.get(str);
        if (deque == null) {
            deque = new ArrayDeque<>();
            this.a.put(str, deque);
        }
        deque.offer(message);
    }

    public final void f(Set<String> set, @NonNull Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, set, message) == null) {
            for (String str : set) {
                e(str, message);
            }
        }
    }

    public boolean g(@NonNull g83 g83Var, @NonNull Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, g83Var, set)) == null) {
            if (g83Var.E() && set.contains(g83Var.getAppId())) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
