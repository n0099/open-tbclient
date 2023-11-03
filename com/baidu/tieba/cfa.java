package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.ci8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class cfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cfa() {
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

    public final String a(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                List<String> b = b();
                if (true ^ b.isEmpty()) {
                    return e(b);
                }
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<qe8> b = tla.d.a().b();
            if (b.isEmpty()) {
                return arrayList;
            }
            for (qe8 qe8Var : b) {
                arrayList.add(qe8Var.b());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void c(List<qe8> originList, List<ci8.b> confirmList) {
        qe8 qe8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, originList, confirmList) == null) {
            Intrinsics.checkNotNullParameter(originList, "originList");
            Intrinsics.checkNotNullParameter(confirmList, "confirmList");
            if (!originList.isEmpty() && !confirmList.isEmpty()) {
                HashMap hashMap = new HashMap();
                for (qe8 qe8Var2 : originList) {
                    if (qe8Var2 != null && qe8Var2.j()) {
                        hashMap.put(qe8Var2.b(), qe8Var2);
                    }
                }
                if (hashMap.isEmpty()) {
                    return;
                }
                for (ci8.b bVar : confirmList) {
                    if (hashMap.containsKey(String.valueOf(bVar.a())) && bVar.b().c().b() && (qe8Var = (qe8) hashMap.get(String.valueOf(bVar.a()))) != null) {
                        qe8Var.n(true);
                    }
                }
            }
        }
    }

    public final void d(String str, BdUniqueId mPageUniqueId) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, mPageUniqueId) == null) {
            Intrinsics.checkNotNullParameter(mPageUniqueId, "mPageUniqueId");
            String a = a(str);
            if (a.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
            httpMessage.addParam("scene_from", "recom");
            httpMessage.addParam("forum_ids", a);
            httpMessage.setTag(mPageUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final String e(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (list.isEmpty()) {
                return "";
            }
            return CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
        }
        return (String) invokeL.objValue;
    }
}
