package com.baidu.tieba;

import androidx.core.util.Pair;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.core.webview.offline.message.OfflineResourceReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public final class de6 extends BdAsyncTask<Void, Void, Map<String, ee6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public de6() {
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

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            de6 de6Var = new de6();
            de6Var.setPriority(4);
            de6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Map<String, ee6> doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            Set<String> o = ud6.l().o();
            if (ef6.a(o)) {
                gf6.b(ud6.l().k());
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str : o) {
                String n = ud6.l().n(str);
                zd6 a = ce6.a(str, n);
                if (a != null && a.c()) {
                    hashMap.putAll(a.a());
                    ud6.i(ud6.l().k(), n, str);
                } else {
                    ud6.l().g(str);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            OfflineResourceReqMsg offlineResourceReqMsg = new OfflineResourceReqMsg("0.0.0.0");
            MessageManager.getInstance().sendMessage(offlineResourceReqMsg);
            ud6.t("request webCacheInfo", "start", hf6.a(Pair.create("offline_version", offlineResourceReqMsg.getWebViewVersion())), "", "");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(Map<String, ee6> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            xd6.d().i(map);
            d();
        }
    }
}
