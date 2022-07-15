package com.baidu.tbadk.growth;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i45;
import com.repackage.st4;
import com.repackage.z8;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes3.dex */
public class ActivityChangeSchemeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpMessageListener a;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityChangeSchemeModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ActivityChangeSchemeModel activityChangeSchemeModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityChangeSchemeModel, Integer.valueOf(i)};
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
            this.a = activityChangeSchemeModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003512 && (httpResponsedMessage instanceof ActivityChangeSchemeHttpResMsg)) {
                ActivityChangeSchemeHttpResMsg activityChangeSchemeHttpResMsg = (ActivityChangeSchemeHttpResMsg) httpResponsedMessage;
                if (activityChangeSchemeHttpResMsg.getData() == null) {
                    return;
                }
                String scheme = activityChangeSchemeHttpResMsg.getScheme();
                if (TextUtils.isEmpty(scheme) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
                    return;
                }
                String simpleName = currentActivity.getClass().getSimpleName();
                TbPageContext<?> pageContext = ((TbPageContextSupport) currentActivity).getPageContext();
                if (pageContext == null) {
                    return;
                }
                if ("NewUserRedPackageActivity".equals(simpleName)) {
                    UrlManager.getInstance().dealOneLink(pageContext, new String[]{scheme});
                    i45.c(scheme);
                } else if (!"MainTabActivity".equalsIgnoreCase(simpleName)) {
                    this.a.C();
                } else {
                    int a = st4.a();
                    if (a != 2) {
                        this.a.D(a);
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(pageContext, new String[]{scheme});
                    i45.c(scheme);
                }
            }
        }
    }

    public ActivityChangeSchemeModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this, CmdConfigHttp.CMD_SPLASH_CHANGE_SCHEME);
        setUniqueId(BdUniqueId.gen());
        E();
        this.a.setTag(getUniqueId());
        this.a.setSelfListener(true);
        registerListener(this.a);
    }

    public static void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SPLASH_CHANGE_SCHEME, TbConfig.SERVER_ADDRESS + TbConfig.URL_GET_DEEPLINK_SCHEME);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ActivityChangeSchemeHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                Object invoke = z8.g().b().getClass().getMethod("getCurrentPageKey", new Class[0]).invoke(z8.g().b(), new Object[0]);
                i45.b(invoke != null ? (String) invoke : null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == 1) {
                i45.b("a025");
            } else if (i == 22) {
                i45.b("a088");
            } else if (i == 3) {
                i45.b("a079");
            } else if (i == 8) {
                i45.b("a011");
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void request() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_SPLASH_CHANGE_SCHEME));
        }
    }
}
