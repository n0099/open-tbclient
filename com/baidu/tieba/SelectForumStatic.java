package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.attention.AttentionResMsg;
import com.baidu.tieba.related.GameRelatedForumsResMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SelectForumStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-995198794, "Lcom/baidu/tieba/SelectForumStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-995198794, "Lcom/baidu/tieba/SelectForumStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(SelectForumConfig.class, SelectForumActivity.class);
        a();
        b();
    }

    public SelectForumStatic() {
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
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION, TbConfig.SERVER_ADDRESS + "c/f/forum/like");
            tbHttpMessageTask.setResponsedClass(AttentionResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_RELATED_FORUMS, TbConfig.SERVER_ADDRESS + "c/f/forum/getRecreationForum");
            tbHttpMessageTask.setResponsedClass(GameRelatedForumsResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
