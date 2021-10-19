package com.baidu.tieba.forumsearch.controller;

import c.a.r0.k3.e0.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forumsearch.message.SearchPostForumHttpResponseMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumSocketResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ForumSearchStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(863396611, "Lcom/baidu/tieba/forumsearch/controller/ForumSearchStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(863396611, "Lcom/baidu/tieba/forumsearch/controller/ForumSearchStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(ForumSearchActivityConfig.class, ForumSearchActivity.class);
        a();
    }

    public ForumSearchStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a.f(309466, SearchPostForumSocketResponseMessage.class, false);
            a.c(309466, CmdConfigHttp.CMD_SEARCH_POST_FORUM, TbConfig.SEARCH_POST_FORUM, SearchPostForumHttpResponseMessage.class, false, false, true, false);
        }
    }
}
