package com.baidu.tbadk.growth;

import android.app.Activity;
import android.text.TextUtils;
import c.a.t0.b0.b;
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
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes11.dex */
public class ActivityChangeSchemeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f41273e;

    /* loaded from: classes11.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityChangeSchemeModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ActivityChangeSchemeModel activityChangeSchemeModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityChangeSchemeModel, Integer.valueOf(i2)};
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
                    b.c(scheme);
                } else if (!"MainTabActivity".equalsIgnoreCase(simpleName)) {
                    this.a.y();
                } else {
                    int a = c.a.t0.s.f0.b.a();
                    if (a != 2) {
                        this.a.z(a);
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(pageContext, new String[]{scheme});
                    b.c(scheme);
                }
            }
        }
    }

    public ActivityChangeSchemeModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41273e = new a(this, CmdConfigHttp.CMD_SPLASH_CHANGE_SCHEME);
        setUniqueId(BdUniqueId.gen());
        A();
        this.f41273e.setTag(getUniqueId());
        this.f41273e.setSelfListener(true);
        registerListener(this.f41273e);
    }

    public static void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SPLASH_CHANGE_SCHEME, TbConfig.SERVER_ADDRESS + TbConfig.URL_GET_DEEPLINK_SCHEME);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ActivityChangeSchemeHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_SPLASH_CHANGE_SCHEME));
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                Object invoke = c.a.d.a.b.f().b().getClass().getMethod("getCurrentPageKey", new Class[0]).invoke(c.a.d.a.b.f().b(), new Object[0]);
                b.b(invoke != null ? (String) invoke : null);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 == 1) {
                b.b("a025");
            } else if (i2 == 22) {
                b.b("a088");
            } else if (i2 == 3) {
                b.b("a079");
            } else if (i2 == 8) {
                b.b("a011");
            }
        }
    }
}
