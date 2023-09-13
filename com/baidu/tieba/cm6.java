package com.baidu.tieba;

import androidx.core.util.Pair;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.browser.core.webview.offline.message.OfflineResourceReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public final class cm6 extends BdAsyncTask<Void, Void, Map<String, dm6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cm6() {
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
            cm6 cm6Var = new cm6();
            cm6Var.setPriority(4);
            cm6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Map<String, dm6> doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            Set<String> q = sl6.n().q();
            if (mn6.a(q)) {
                on6.b(sl6.n().m());
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str : q) {
                String p = sl6.n().p(str);
                yl6 a = bm6.a(str, p);
                if (a != null && a.c()) {
                    hashMap.putAll(a.a());
                    sl6.j(sl6.n().m(), p, str);
                } else {
                    sl6.n().h(str);
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
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_type", "request webCacheInfo").param("obj_locate", "start").param(TiebaStatic.Params.OBJ_PARAM2, pn6.a(Pair.create("offline_version", offlineResourceReqMsg.getWebViewVersion()))));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(Map<String, dm6> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            tl6.e().j(map);
            d();
        }
    }
}
