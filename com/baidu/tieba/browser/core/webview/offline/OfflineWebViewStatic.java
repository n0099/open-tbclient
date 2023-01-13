package com.baidu.tieba.browser.core.webview.offline;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.browser.core.webview.offline.message.OfflineResourceResHttpMsg;
import com.baidu.tieba.browser.core.webview.offline.message.OfflineResourceResSocketMsg;
import com.baidu.tieba.qw8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class OfflineWebViewStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-816445382, "Lcom/baidu/tieba/browser/core/webview/offline/OfflineWebViewStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-816445382, "Lcom/baidu/tieba/browser/core/webview/offline/OfflineWebViewStatic;");
                return;
            }
        }
        qw8.h(309485, OfflineResourceResSocketMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.WEBVIEW_CACHE_INFO, qw8.a(TbConfig.WEBVIEW_CACHE_URL, 309485));
        tbHttpMessageTask.setResponsedClass(OfflineResourceResHttpMsg.class);
        if (TbSingleton.getInstance().isDebugToolMode()) {
            if (MessageManager.getInstance().findTask(tbHttpMessageTask.getCmd()) == null) {
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                return;
            }
            return;
        }
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public OfflineWebViewStatic() {
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
