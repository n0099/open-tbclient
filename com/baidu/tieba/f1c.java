package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class f1c {
    public static /* synthetic */ Interceptable $ic;
    public static f1c b;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, e1c> a;

    public f1c() {
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
        this.a = new ConcurrentHashMap<>();
    }

    public static f1c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (f1c.class) {
                    if (b == null) {
                        b = new f1c();
                    }
                }
            }
            return b;
        }
        return (f1c) invokeV.objValue;
    }

    public void a(String str, e1c e1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, e1cVar) == null) {
            TLog.h("[VodPlayerManager]", "bindUniqueKeyForPlayer key:" + str + "-vodPlayer:" + e1cVar);
            if (!TextUtils.isEmpty(str) && e1cVar != null) {
                if (this.a.containsKey(str) && this.a.get(str) != null) {
                    TLog.h("[VodPlayerManager]", "bindUniqueKeyForPlayer contain key and player");
                    return;
                }
                if (this.a.containsValue(e1cVar)) {
                    Iterator<Map.Entry<String, e1c>> it = this.a.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, e1c> next = it.next();
                        if (e1cVar == next.getValue()) {
                            this.a.remove(next.getKey());
                            break;
                        }
                    }
                }
                this.a.put(str, e1cVar);
                TLog.h("[VodPlayerManager]", "player bind suc, tastId:" + e1cVar.d());
                return;
            }
            TLog.h("[VodPlayerManager]", "player or key is null");
        }
    }

    public e1c c(String str, boolean z) {
        InterceptResult invokeLZ;
        x0c f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            TLog.h("[VodPlayerManager]", "obtainPlayer key:" + str);
            if (!TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                e1c e1cVar = this.a.get(str);
                TLog.h("[VodPlayerManager]", "TaskID:" + e1cVar.d() + "-obtainPlayer vodPlayer:" + e1cVar);
                if (z && (f = e1cVar.f()) != null) {
                    f.onPlayerStateUpdate(e1cVar, 10, 0);
                }
                return e1cVar;
            }
            TLog.h("[VodPlayerManager]", "player is null");
            return null;
        }
        return (e1c) invokeLZ.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            e(str, "");
        }
    }

    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            TLog.h("[VodPlayerManager]", "removePlayerUniqueKey key:" + str + ", source:" + str2);
            if (!TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                this.a.remove(str);
            }
        }
    }
}
