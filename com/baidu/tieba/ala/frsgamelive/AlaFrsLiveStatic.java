package com.baidu.tieba.ala.frsgamelive;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.ala.atomdata.AlaAllGameLiveEntryActivityConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaFrsStoryLiveGatherActivityConfig;
import com.baidu.tbadk.core.atomData.AlaGameFrsLiveListActivityConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRespMessage;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity;
import com.baidu.tieba.ala.gamefrslivelist.AlaGameFrsLiveListActivity;
import com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity;
import com.baidu.tieba.cl6;
import com.baidu.tieba.dl6;
import com.baidu.tieba.g06;
import com.baidu.tieba.h06;
import com.baidu.tieba.zz5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AlaFrsLiveStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof dl6)) {
                return;
            }
            dl6 dl6Var = (dl6) data;
            zz5 zz5Var = new zz5(true);
            zz5Var.b().e = 2;
            zz5Var.h(dl6Var.c());
            zz5Var.i(dl6Var.d());
            zz5Var.g(dl6Var.b());
            zz5Var.j(1);
            zz5Var.k(false);
            dl6Var.a(zz5Var);
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof cl6)) {
                return;
            }
            cl6 cl6Var = (cl6) data;
            zz5 zz5Var = new zz5(true);
            zz5Var.b().e = 9;
            zz5Var.h(cl6Var.c());
            zz5Var.i(cl6Var.d());
            zz5Var.g(cl6Var.b());
            zz5Var.j(1);
            zz5Var.k(true);
            if (cl6Var.h(9)) {
                cl6Var.a(zz5Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof dl6)) {
                return;
            }
            dl6 dl6Var = (dl6) data;
            zz5 zz5Var = new zz5(false);
            zz5Var.b().e = 1;
            zz5Var.h(dl6Var.c());
            zz5Var.i(dl6Var.d());
            zz5Var.g(dl6Var.b());
            zz5Var.j(2);
            zz5Var.k(false);
            dl6Var.a(zz5Var);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof dl6)) {
                return;
            }
            dl6 dl6Var = (dl6) data;
            h06 h06Var = new h06();
            h06Var.b().e = 3;
            h06Var.g(dl6Var.c());
            h06Var.h(dl6Var.d());
            h06Var.i(false);
            dl6Var.a(h06Var);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof cl6)) {
                return;
            }
            cl6 cl6Var = (cl6) data;
            h06 h06Var = new h06();
            h06Var.b().e = 8;
            h06Var.b().b = R.string.obfuscated_res_0x7f0f0256;
            h06Var.g(cl6Var.c());
            h06Var.h(cl6Var.d());
            h06Var.i(true);
            if (cl6Var.h(8)) {
                cl6Var.a(h06Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof cl6)) {
                return;
            }
            cl6 cl6Var = (cl6) data;
            g06 g06Var = new g06();
            g06Var.i(cl6Var.c());
            g06Var.j(cl6Var.d());
            g06Var.h(cl6Var.b());
            g06Var.g(cl6Var);
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements CustomMessageTask.CustomRunnable<AlaAllGameLiveEntryActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<AlaAllGameLiveEntryActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(AlaAllGameLiveEntryActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(477880351, "Lcom/baidu/tieba/ala/frsgamelive/AlaFrsLiveStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(477880351, "Lcom/baidu/tieba/ala/frsgamelive/AlaFrsLiveStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(AlaFrsStoryLiveGatherActivityConfig.class, AlaFrsStoryLiveGatherActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaGameFrsLiveListActivityConfig.class, AlaGameFrsLiveListActivity.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_FRS_STORY_LIVE_LIST);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaFrsStoryLiveGatherRespMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask2.setIsNeedLogin(true);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask2.setResponsedClass(AlaGameFrsLiveThreadsRespMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        MessageManager.getInstance().registerListener(new a(2001619));
        MessageManager.getInstance().registerListener(new b(2001616));
        MessageManager.getInstance().registerListener(new c(2001620));
        MessageManager.getInstance().registerListener(new d(2001619));
        MessageManager.getInstance().registerListener(new e(2001616));
        MessageManager.getInstance().registerListener(new f(2001616));
        CustomMessageTask customMessageTask = new CustomMessageTask(AlaCmdConfigCustom.CMD_ALA_ALL_GAME_LIVE_ENTRY, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public AlaFrsLiveStatic() {
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
}
