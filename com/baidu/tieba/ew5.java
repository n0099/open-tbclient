package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.tracker.UploadLogResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ew5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ew5() {
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
        }
    }

    public final TbHttpMessageTask a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, str);
            tbHttpMessageTask.setPriority(4);
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            tbHttpMessageTask.setResponsedClass(UploadLogResponseMessage.class);
            return tbHttpMessageTask;
        }
        return (TbHttpMessageTask) invokeIL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            String URL_EXCEPTION_REPORT = TbConfig.URL_EXCEPTION_REPORT;
            Intrinsics.checkNotNullExpressionValue(URL_EXCEPTION_REPORT, "URL_EXCEPTION_REPORT");
            messageManager.registerTask(a(CmdConfigHttp.CMD_HTTP_EXCEPTION_REPORT, URL_EXCEPTION_REPORT));
            MessageManager messageManager2 = MessageManager.getInstance();
            String URL_STATISTICS_REPORT = TbConfig.URL_STATISTICS_REPORT;
            Intrinsics.checkNotNullExpressionValue(URL_STATISTICS_REPORT, "URL_STATISTICS_REPORT");
            messageManager2.registerTask(a(CmdConfigHttp.CMD_HTTP_STATISTICS_REPORT, URL_STATISTICS_REPORT));
        }
    }
}
