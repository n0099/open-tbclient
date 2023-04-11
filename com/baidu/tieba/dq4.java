package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.message.UserGrowthTaskResponseMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.CommonTaskInfo;
import tbclient.TaskProgress;
/* loaded from: classes4.dex */
public class dq4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String c = "TaskManager";
    public static dq4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public List<CommonTaskInfo> a;
    public final HttpMessageListener b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947713186, "Lcom/baidu/tieba/dq4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947713186, "Lcom/baidu/tieba/dq4;");
        }
    }

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dq4 dq4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq4Var, Integer.valueOf(i)};
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
            this.a = dq4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof UserGrowthTaskResponseMessage)) {
                return;
            }
            int errCode = ((UserGrowthTaskResponseMessage) httpResponsedMessage).getErrCode();
            ng8 defaultLog = DefaultLog.getInstance();
            String str = dq4.c;
            defaultLog.c(str, "任务完成：errCode=" + errCode);
            if (errCode == 0) {
                this.a.g();
            }
        }
    }

    public dq4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new a(this, CmdConfigHttp.CMD_YINJI_TASK_SHARE_REPORT);
    }

    public static dq4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (dq4.class) {
                    if (d == null) {
                        dq4 dq4Var = new dq4();
                        d = dq4Var;
                        dq4Var.f();
                    }
                }
            }
            return d;
        }
        return (dq4) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(this.b);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            aq4.w().I();
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return c(str, "");
        }
        return invokeL.booleanValue;
    }

    public void h(List<CommonTaskInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.a = list;
        }
    }

    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            ng8 defaultLog = DefaultLog.getInstance();
            String str3 = c;
            defaultLog.c(str3, "尝试完成任务：" + str);
            if (!e(str)) {
                return false;
            }
            ng8 defaultLog2 = DefaultLog.getInstance();
            String str4 = c;
            defaultLog2.c(str4, "开始完成任务：" + str + " data=" + str2);
            UserGrowthTaskRequestMessage userGrowthTaskRequestMessage = new UserGrowthTaskRequestMessage(str);
            userGrowthTaskRequestMessage.addActData(str2);
            MessageManager.getInstance().sendMessage(userGrowthTaskRequestMessage);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        TaskProgress taskProgress;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.a)) {
                StringBuilder sb = new StringBuilder();
                for (CommonTaskInfo commonTaskInfo : this.a) {
                    sb.append(commonTaskInfo.act_type);
                    sb.append("=");
                    sb.append(commonTaskInfo.dotask_status);
                    sb.append(",");
                    if (str.equals(commonTaskInfo.act_type) && commonTaskInfo.dotask_status.intValue() == 1 && ((taskProgress = commonTaskInfo.task_progress) == null || taskProgress.total.intValue() <= 0 || commonTaskInfo.task_progress.current.intValue() < commonTaskInfo.task_progress.total.intValue())) {
                        return true;
                    }
                }
                ng8 defaultLog = DefaultLog.getInstance();
                String str2 = c;
                defaultLog.b(str2, "任务列表中无此任务:" + sb.toString());
                return false;
            }
            DefaultLog.getInstance().b(c, "任务列表为空，无法完成");
            return false;
        }
        return invokeL.booleanValue;
    }
}
