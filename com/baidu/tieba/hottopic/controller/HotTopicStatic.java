package com.baidu.tieba.hottopic.controller;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.b1.t0;
import c.a.p0.s.q.c2;
import c.a.q0.v0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.frs.FrsHottopicFragment;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newlist.HotTopicListActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class HotTopicStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            String lowerCase;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null || tbPageContext == null || (lowerCase = strArr[0].toLowerCase()) == null || c.a.p0.r0.b.c(tbPageContext, false, true) || !(lowerCase.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC) || lowerCase.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || lowerCase.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC) || lowerCase.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW))) {
                    return 3;
                }
                String c2 = t0.c(lowerCase, "topic_id=");
                String c3 = t0.c(lowerCase, "topic_name=");
                if (!StringUtils.isNull(c2) && !StringUtils.isNull(c3, true)) {
                    tbPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(c2, c3, (strArr == null || strArr.length <= 1 || StringUtils.isNull(strArr[1])) ? "" : strArr[1])));
                    return 1;
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new c.a.q0.h1.d.c(null, c2.D3));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements UrlManager.UrlSchemaHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlSchemaHandler
        public void deal(TbPageContext<?> tbPageContext, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, map) == null) || tbPageContext == null || map == null) {
                return;
            }
            new HotRanklistActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(map.get(IntentConfig.CALL_FROM), map.get(IntentConfig.LIST_TYPE)).start();
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a extends c.a.p0.g0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f52544a;

            public a(d dVar, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52544a = gVar;
            }

            @Override // c.a.p0.g0.b
            public c.a.p0.g0.c createFragmentTabStructure() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsHottopicFragment frsHottopicFragment = new FrsHottopicFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("fid", this.f52544a.b());
                    bundle.putString("from", this.f52544a.d());
                    frsHottopicFragment.setArguments(bundle);
                    c.a.p0.g0.c cVar = new c.a.p0.g0.c();
                    cVar.f13476a = frsHottopicFragment;
                    cVar.f13480e = 401;
                    cVar.f13484i = c.a.p0.g0.c.k;
                    return cVar;
                }
                return (c.a.p0.g0.c) invokeV.objValue;
            }

            @Override // c.a.p0.g0.b
            public TbFragmentTabIndicator getTabIndicator(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return null;
                }
                return (TbFragmentTabIndicator) invokeL.objValue;
            }

            @Override // c.a.p0.g0.b
            public boolean isAvailable() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                gVar.a(new a(this, gVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2114097239, "Lcom/baidu/tieba/hottopic/controller/HotTopicStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2114097239, "Lcom/baidu/tieba/hottopic/controller/HotTopicStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(HotTopicActivityConfig.class, HotTopicDetailActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(RelateTopicForumActivityConfig.class, RelateTopicForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(HotRanklistActivityConfig.class, HotTopicListActivity.class);
        f();
        h();
        c();
        b();
        a();
        e();
        g();
        d();
    }

    public HotTopicStatic() {
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
            MessageManager.getInstance().registerListener(new b(2003008));
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            UrlManager.getInstance().addListener(new a());
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c.a.q0.i3.d0.a.h(309085, BlessSocketResponseMessage.class, false, false);
            c.a.q0.i3.d0.a.c(309085, CmdConfigHttp.CMD_TOPIC_BLESS, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            d dVar = new d(2001623);
            dVar.setPriority(1);
            MessageManager.getInstance().registerListener(dVar);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            c.a.q0.i3.d0.a.h(309289, ResponseSocketHotRanklistMessage.class, false, false);
            c.a.q0.i3.d0.a.c(309289, CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, TbConfig.URL_GET_HOT_RANKLIST_DATA, ResponseHttpHotRanklistMessage.class, false, false, true, false);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            c.a.q0.i3.d0.a.h(303050, ResponseSocketHotTopicMessage.class, false, false);
            c.a.q0.i3.d0.a.c(303050, CmdConfigHttp.CMD_HOT_TOPIC, TbConfig.URL_GET_HOT_TOPIC_DATA, ResponseHttpHotTopicMessage.class, false, false, true, false);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            UrlManager.getInstance().registerSchema(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST, new c());
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            c.a.q0.i3.d0.a.h(309005, ResponseSocketGetTopicRelateThreadMessage.class, false, false);
            c.a.q0.i3.d0.a.c(309005, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, TbConfig.URL_GET_TOPIC_RELATE_THREAD, ResponseHttpGetTopicRelateThreadMessage.class, false, false, true, false);
        }
    }
}
