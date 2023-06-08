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
public class fgb {
    public static /* synthetic */ Interceptable $ic;
    public static fgb b;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, egb> a;

    public fgb() {
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

    public static fgb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (fgb.class) {
                    if (b == null) {
                        b = new fgb();
                    }
                }
            }
            return b;
        }
        return (fgb) invokeV.objValue;
    }

    public void a(String str, egb egbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, egbVar) == null) {
            TLog.h("[VodPlayerManager]", "bindUniqueKeyForPlayer key:" + str + "-vodPlayer:" + egbVar);
            if (!TextUtils.isEmpty(str) && egbVar != null) {
                if (this.a.containsKey(str) && this.a.get(str) != null) {
                    TLog.h("[VodPlayerManager]", "bindUniqueKeyForPlayer contain key and player");
                    return;
                }
                if (this.a.containsValue(egbVar)) {
                    Iterator<Map.Entry<String, egb>> it = this.a.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, egb> next = it.next();
                        if (egbVar == next.getValue()) {
                            this.a.remove(next.getKey());
                            break;
                        }
                    }
                }
                this.a.put(str, egbVar);
                TLog.h("[VodPlayerManager]", "player bind suc, tastId:" + egbVar.d());
                return;
            }
            TLog.h("[VodPlayerManager]", "player or key is null");
        }
    }

    public egb c(String str, boolean z) {
        InterceptResult invokeLZ;
        xfb f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            TLog.h("[VodPlayerManager]", "obtainPlayer key:" + str);
            if (!TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                egb egbVar = this.a.get(str);
                TLog.h("[VodPlayerManager]", "TaskID:" + egbVar.d() + "-obtainPlayer vodPlayer:" + egbVar);
                if (z && (f = egbVar.f()) != null) {
                    f.onPlayerStateUpdate(egbVar, 10, 0);
                }
                return egbVar;
            }
            TLog.h("[VodPlayerManager]", "player is null");
            return null;
        }
        return (egb) invokeLZ.objValue;
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
