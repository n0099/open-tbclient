package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ce7 {
    public static /* synthetic */ Interceptable $ic;
    public static ce7 d;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public List<Long> b;
    public final CustomMessageListener c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947671956, "Lcom/baidu/tieba/ce7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947671956, "Lcom/baidu/tieba/ce7;");
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ce7 ce7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce7Var, Integer.valueOf(i)};
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
            this.a = ce7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.a.b();
            }
        }
    }

    public ce7() {
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
        this.a = 0L;
        this.b = new ArrayList();
        this.c = new a(this, 2005016);
        MessageManager.getInstance().registerListener(this.c);
    }

    public synchronized List<Long> g() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (Long l : this.b) {
                    if (l != null) {
                        arrayList.add(Long.valueOf(dg7.c(l.longValue())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static ce7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (ce7.class) {
                    if (d == null) {
                        d = new ce7();
                    }
                }
            }
            return d;
        }
        return (ce7) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.a = 0L;
                this.b.clear();
            }
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public Long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return pd7.o().r().get(this.a);
        }
        return (Long) invokeV.objValue;
    }

    public synchronized boolean i() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (this.a > 0) {
                    if (this.b.size() > 0) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                this.b.clear();
            }
        }
    }

    public synchronized void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                if (this.a != 0 && this.a != j) {
                    this.b.clear();
                    va.c("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + "-" + this.a);
                }
                this.a = j;
                for (Long l : this.b) {
                    if (l != null && l.longValue() == j2) {
                        return;
                    }
                }
                this.b.add(Long.valueOf(j2));
            }
        }
    }

    public synchronized boolean c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            synchronized (this) {
                for (Long l : this.b) {
                    if (l != null && l.longValue() == j) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public synchronized String h() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                str = "";
                for (Long l : this.b) {
                    if (l != null && l.longValue() != 0) {
                        str = (str + l.longValue()) + ",";
                    }
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            synchronized (this) {
                b();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        this.a = xg.g(str, 0L);
                        try {
                            String[] split = str2.split(",");
                            if (split != null && split.length > 0) {
                                for (int i = 0; i < split.length; i++) {
                                    if (!TextUtils.isEmpty(split[i])) {
                                        this.b.add(Long.valueOf(Long.parseLong(split[i])));
                                    }
                                }
                            }
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                }
            }
        }
    }
}
