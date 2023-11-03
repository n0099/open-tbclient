package com.baidu.tieba;

import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.tieba.y30;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* loaded from: classes5.dex */
public class bf8 {
    public static /* synthetic */ Interceptable $ic;
    public static final bf8 d;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile DataRes a;
    public volatile boolean b;
    public volatile boolean c;

    /* loaded from: classes5.dex */
    public class a implements y30.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;

        public a(bf8 bf8Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf8Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = runnable;
        }

        @Override // com.baidu.tieba.y30.b
        public void a(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                RecPersonalizePageModel.e().l(responsedMessage);
            }
        }

        @Override // com.baidu.tieba.y30.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SafeHandler.getInst().post(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;

        public b(bf8 bf8Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf8Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = runnable;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    this.a.run();
                    return false;
                } catch (Exception e) {
                    BdLog.e(e);
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947643157, "Lcom/baidu/tieba/bf8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947643157, "Lcom/baidu/tieba/bf8;");
                return;
            }
        }
        d = new bf8();
    }

    public bf8() {
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
        this.b = false;
        this.c = false;
    }

    public static synchronized bf8 c() {
        InterceptResult invokeV;
        bf8 bf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (bf8.class) {
                bf8Var = d;
            }
            return bf8Var;
        }
        return (bf8) invokeV.objValue;
    }

    public synchronized DataRes a() {
        InterceptResult invokeV;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.b) {
                    f();
                }
                this.b = true;
                dataRes = this.a;
            }
            return dataRes;
        }
        return (DataRes) invokeV.objValue;
    }

    public synchronized boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                z = this.c;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            synchronized (this) {
                y30.d(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, new a(this, runnable));
            }
        }
    }

    public synchronized void h(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            synchronized (this) {
                if (!d()) {
                    this.c = false;
                    return;
                }
                this.c = true;
                Looper.myQueue().addIdleHandler(new b(this, runnable));
            }
        }
    }

    public synchronized boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                long j = SharedPrefHelper.getInstance().getLong("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                long j2 = sharedPrefHelper.getLong("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (j2 != 0) {
                    if (Math.abs(System.currentTimeMillis() - j2) <= j) {
                        z = false;
                    }
                }
                z = true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        ca<byte[]> k;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                ov4.t().z();
            }
            if ((!o45.q().u() || o45.q().o() < o45.q().p()) && (k = yz4.k("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())) != null && (bArr = k.get("0")) != null && bArr.length != 0) {
                try {
                    DataRes dataRes = (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    if (dataRes != null && dataRes.thread_list != null && dataRes.thread_list.size() > 0) {
                        this.a = dataRes;
                    }
                } catch (IOException e) {
                    BdLog.e(e);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921687, null));
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!PermissionUtil.isAgreePrivacyPolicy()) {
                    return;
                }
                f();
                if (this.a == null || d()) {
                    ms5 ms5Var = new ms5();
                    ms5Var.b = "";
                    ms5Var.a = 0;
                    RecPersonalizePageModel.e().m(1, 0, ms5Var, 1, 0);
                }
            }
        }
    }
}
