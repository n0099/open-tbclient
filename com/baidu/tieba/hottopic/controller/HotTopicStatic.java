package com.baidu.tieba.hottopic.controller;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.dla;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.gca;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.frs.FrsHottopicFragment;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import com.baidu.tieba.io5;
import com.baidu.tieba.jo5;
import com.baidu.tieba.mb8;
import com.baidu.tieba.my5;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.pz5;
import com.baidu.tieba.uh7;
import com.baidu.tieba.zx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class HotTopicStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a extends io5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ uh7 c;

            @Override // com.baidu.tieba.io5
            public TbFragmentTabIndicator c(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return null;
                }
                return (TbFragmentTabIndicator) invokeL.objValue;
            }

            @Override // com.baidu.tieba.io5
            public boolean d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public a(e eVar, uh7 uh7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, uh7Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = uh7Var;
            }

            @Override // com.baidu.tieba.io5
            public jo5 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsHottopicFragment frsHottopicFragment = new FrsHottopicFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("fid", this.c.b());
                    bundle.putString("from", this.c.d());
                    frsHottopicFragment.setArguments(bundle);
                    jo5 jo5Var = new jo5();
                    jo5Var.a = frsHottopicFragment;
                    jo5Var.e = 401;
                    jo5Var.i = jo5.k;
                    return jo5Var;
                }
                return (jo5) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof uh7)) {
                uh7 uh7Var = (uh7) customResponsedMessage.getData();
                uh7Var.a(new a(this, uh7Var));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            String lowerCase;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0 && strArr[0] != null && tbPageContext != null && (lowerCase = strArr[0].toLowerCase()) != null && !zx5.c(tbPageContext, false, true)) {
                    String str = "";
                    if (!lowerCase.contains(UrlSchemaHelper.JUMP_TO_HOT_TOPIC) && !lowerCase.contains(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW)) {
                        if (lowerCase.contains(BdUniDispatchSchemeController.PATH_TOPIC_DETAIL)) {
                            String c = pz5.c(lowerCase, "topic_id=");
                            String c2 = pz5.c(lowerCase, "topic_name=");
                            String c3 = pz5.c(lowerCase, "is_video_topic=");
                            HotTopicStat.Locate valueOfIgnoreCase = HotTopicStat.Locate.valueOfIgnoreCase(pz5.c(lowerCase, "locate="));
                            if (!StringUtils.isNull(c) && !StringUtils.isNull(c2, true)) {
                                if (strArr.length > 1 && !StringUtils.isNull(strArr[1])) {
                                    str = strArr[1];
                                }
                                String str2 = str;
                                if (!StringHelper.equals(c3, "1") && NewWebHotTopicPageSwitch.isOn()) {
                                    my5.f(tbPageContext, c, c2);
                                } else {
                                    new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(c, c2, c3, str2, valueOfIgnoreCase).start();
                                }
                                return 0;
                            }
                        }
                        return 3;
                    }
                    String c4 = pz5.c(lowerCase, "topic_id=");
                    String c5 = pz5.c(lowerCase, "topic_name=");
                    String c6 = pz5.c(lowerCase, "is_video_topic=");
                    HotTopicStat.Locate valueOfIgnoreCase2 = HotTopicStat.Locate.valueOfIgnoreCase(pz5.c(lowerCase, "locate="));
                    if (!StringUtils.isNull(c4) && !StringUtils.isNull(c5, true)) {
                        if (strArr.length > 1 && !StringUtils.isNull(strArr[1])) {
                            str = strArr[1];
                        }
                        String str3 = str;
                        if (!StringHelper.equals(c6, "1") && NewWebHotTopicPageSwitch.isOn()) {
                            my5.f(tbPageContext, c4, c5);
                        } else {
                            new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(c4, c5, c6, str3, valueOfIgnoreCase2).start();
                        }
                        return 1;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new mb8(null, ThreadData.TYPE_FRS_HOTTOPIC));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements UrlManager.UrlSchemaHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlSchemaHandler
        public void deal(TbPageContext<?> tbPageContext, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, map) == null) && tbPageContext != null && map != null) {
                dla.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null || tbPageContext == null || !strArr[0].toLowerCase().contains(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_RANK_LIST)) {
                    return 3;
                }
                dla.b();
                return 0;
            }
            return invokeLL.intValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            gca.h(309085, BlessSocketResponseMessage.class, false, false);
            gca.c(309085, CmdConfigHttp.CMD_TOPIC_BLESS, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            e eVar = new e(2001623);
            eVar.setPriority(1);
            MessageManager.getInstance().registerListener(eVar);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            gca.h(309289, ResponseSocketHotRanklistMessage.class, false, false);
            gca.c(309289, CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, TbConfig.URL_GET_HOT_RANKLIST_DATA, ResponseHttpHotRanklistMessage.class, false, false, true, false);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            gca.h(303050, ResponseSocketHotTopicMessage.class, false, false);
            gca.c(303050, CmdConfigHttp.CMD_HOT_TOPIC, TbConfig.URL_GET_HOT_TOPIC_DATA, ResponseHttpHotTopicMessage.class, false, false, true, false);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            UrlManager.getInstance().registerSchema(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST, new c());
            UrlManager.getInstance().addListener(new d());
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            gca.h(309005, ResponseSocketGetTopicRelateThreadMessage.class, false, false);
            gca.c(309005, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, TbConfig.URL_GET_TOPIC_RELATE_THREAD, ResponseHttpGetTopicRelateThreadMessage.class, false, false, true, false);
        }
    }
}
