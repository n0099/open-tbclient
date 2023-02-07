package com.baidu.tieba;

import android.text.TextUtils;
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
/* loaded from: classes4.dex */
public class hb6 extends BdAsyncTask<Void, Void, ib6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hb6() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public ib6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        HashMap<String, db6> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            ib6 ib6Var = new ib6();
            for (String str : za6.h().j()) {
                String i = za6.h().i(str);
                jb6 c = gb6.c(str, i);
                if (c != null && !TextUtils.isEmpty(c.a) && (hashMap = c.b) != null && hashMap.size() != 0) {
                    if (ib6Var.a == null) {
                        ib6Var.a = new HashMap();
                    }
                    ib6Var.a.put(str, c);
                    if (ib6Var.b == null) {
                        ib6Var.b = new HashMap<>();
                    }
                    ib6Var.b.putAll(c.b);
                    gb6.b(c.c, str);
                } else {
                    e35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", str, "hybridVersion", i, "hybridResult", "bundle incomplete");
                    gb6.a(str);
                }
            }
            return ib6Var;
        }
        return (ib6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ib6 ib6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ib6Var) == null) {
            if (ib6Var == null) {
                e35.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
            } else {
                cb6.a().g(ib6Var.b);
            }
            ac6.b("lt-log", "ReadRouterFinalResult:" + ib6Var);
            MessageManager.getInstance().sendMessage(new OfflineResourceReqMsg("0.0.0.0"));
        }
    }
}
