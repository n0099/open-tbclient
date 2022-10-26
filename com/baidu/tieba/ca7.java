package com.baidu.tieba;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class ca7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static ca7 c = null;
    public static long d = -1;
    public static int e;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public c b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947668112, "Lcom/baidu/tieba/ca7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947668112, "Lcom/baidu/tieba/ca7;");
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ca7 ca7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ca7Var, Integer.valueOf(i)};
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
            this.a = ca7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage)) {
                return;
            }
            if (((Boolean) ((BackgroundSwitchMessage) customResponsedMessage).getData()).booleanValue()) {
                this.a.a.sendMessageDelayed(this.a.a.obtainMessage(1), 30000L);
                return;
            }
            this.a.a.removeMessages(1);
            this.a.j();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    ca7.i().a.removeMessages(1);
                    ca7.i().h();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ca7 ca7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ca7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(ca7 ca7Var, a aVar) {
            this(ca7Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                LinkedList<ImMessageCenterPojo> h = da7.f().h();
                if (h != null && h.size() != 0) {
                    if (ca7.d < 0) {
                        try {
                            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                            long unused = ca7.d = statFs.getAvailableBlocks() * statFs.getBlockSize();
                            if (ca7.d > 2147483648L) {
                                int unused2 = ca7.e = 5000;
                            } else if (ca7.d > 1073741824) {
                                int unused3 = ca7.e = 3000;
                            } else {
                                int unused4 = ca7.e = 1000;
                            }
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                    }
                    if (ca7.e < 1000) {
                        int unused5 = ca7.e = 1000;
                    }
                    try {
                        try {
                            ba7.d().f();
                            for (ImMessageCenterPojo imMessageCenterPojo : h) {
                                if (isCancelled()) {
                                    ba7.d().b();
                                    return Boolean.FALSE;
                                } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                                    w97.h().n(imMessageCenterPojo.getGid(), ca7.e);
                                } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                                    ga7.w().r(imMessageCenterPojo.getGid(), ca7.e);
                                } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                                    fa7.w().r(imMessageCenterPojo.getGid(), ca7.e);
                                } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                                    x97.c().g(imMessageCenterPojo.getGid(), ca7.e);
                                }
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                        ba7.d().b();
                        return Boolean.TRUE;
                    } finally {
                        ba7.d().b();
                    }
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }
    }

    public ca7() {
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
        this.a = new b(null);
        this.b = null;
        MessageManager.getInstance().registerListener(new a(this, 2001011));
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.cancel();
                this.b = null;
            }
            c cVar2 = new c(this, null);
            this.b = cVar2;
            cVar2.setParallel(TiebaIMConfig.getParallel());
            this.b.setPriority(4);
            this.b.execute(new String[0]);
        }
    }

    public static ca7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (c == null) {
                synchronized (ca7.class) {
                    if (c == null) {
                        c = new ca7();
                    }
                }
            }
            return c;
        }
        return (ca7) invokeV.objValue;
    }

    public final void j() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cVar = this.b) != null) {
            cVar.cancel();
            this.b = null;
        }
    }
}
