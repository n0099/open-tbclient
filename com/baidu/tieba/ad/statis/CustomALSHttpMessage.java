package com.baidu.tieba.ad.statis;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
/* loaded from: classes5.dex */
public class CustomALSHttpMessage extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public static final TbHttpMessageTask task;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mUIHandler;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CustomALSHttpMessage f13744e;

        public a(CustomALSHttpMessage customALSHttpMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {customALSHttpMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13744e = customALSHttpMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(this.f13744e, CustomALSHttpMessage.task);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1175391808, "Lcom/baidu/tieba/ad/statis/CustomALSHttpMessage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1175391808, "Lcom/baidu/tieba/ad/statis/CustomALSHttpMessage;");
                return;
            }
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CUSTOM_ALS, TbConfig.REPORT_PLOG);
        task = tbHttpMessageTask;
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        task.setIsNeedAddCommenParam(true);
        task.setResponsedClass(CustomALSResponseHttpMessage.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomALSHttpMessage() {
        super(CmdConfigHttp.CMD_CUSTOM_ALS);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUIHandler = null;
        addParam("productId", "2");
        addParam(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
        addParam(AdUploadHttpRequest.KEY_OS_TYPE, "ANDROID");
        addParam("net_type", String.valueOf(j.I()));
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public CustomALSHttpMessage init(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            addParam("c_id", str);
            addParam("c_type", str2);
            return this;
        }
        return (CustomALSHttpMessage) invokeLL.objValue;
    }

    public void send() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().sendMessage(this, task);
        }
    }

    public void sendBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mUIHandler.post(new a(this));
        }
    }
}
