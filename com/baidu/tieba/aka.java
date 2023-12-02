package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.helper.LiveEnterForumTestHelperKt;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.el8;
import com.baidu.tieba.impersonal.dispatcher.PersonalChatDispatcher;
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
public final class aka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aka() {
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
        List<sh8> list;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            ph8 b = mqa.e.a().b();
            if (b != null) {
                list = b.h();
            } else {
                list = null;
            }
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return arrayList;
            }
            for (sh8 sh8Var : list) {
                arrayList.add(sh8Var.b());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void c(ph8 forumData, List<el8.b> confirmList) {
        boolean z;
        sh8 sh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumData, confirmList) == null) {
            Intrinsics.checkNotNullParameter(forumData, "forumData");
            Intrinsics.checkNotNullParameter(confirmList, "confirmList");
            List<sh8> originList = forumData.h();
            if (originList != null && !originList.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z && !confirmList.isEmpty()) {
                HashMap hashMap = new HashMap();
                Intrinsics.checkNotNullExpressionValue(originList, "originList");
                for (sh8 sh8Var2 : originList) {
                    if (sh8Var2 != null && sh8Var2.l()) {
                        hashMap.put(sh8Var2.b(), sh8Var2);
                    }
                }
                if (hashMap.isEmpty()) {
                    return;
                }
                for (el8.b bVar : confirmList) {
                    if (hashMap.containsKey(String.valueOf(bVar.a())) && bVar.b().c().b() && (sh8Var = (sh8) hashMap.get(String.valueOf(bVar.a()))) != null) {
                        sh8Var.p(true);
                    }
                }
                xja.a.a().g(forumData, false);
                DefaultLog.getInstance().i(LiveEnterForumTestHelperKt.LIVE_ENTER_FORUM_TEST_LOG_TAGE, "群签到完成更新内存、磁盘缓存数据");
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
            httpMessage.addParam(PersonalChatDispatcher.OPEN_PAGE_FROM, "recom");
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
