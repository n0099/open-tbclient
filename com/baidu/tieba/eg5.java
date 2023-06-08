package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
@ModifyClass
/* loaded from: classes5.dex */
public class eg5 extends lb {
    public static /* synthetic */ Interceptable $ic;
    public static eg5 g;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public long c;
    public final SparseArray<b> d;
    public final HashSet<Integer> e;
    public int f;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public long c;

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

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a = 0;
                if (this.b) {
                    this.b = false;
                    this.c = 0L;
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = this.a + 1;
                this.a = i2;
                if (!this.b && i2 >= i) {
                    this.b = true;
                    this.c = System.currentTimeMillis();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947733398, "Lcom/baidu/tieba/eg5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947733398, "Lcom/baidu/tieba/eg5;");
                return;
            }
        }
        g = new eg5();
    }

    public static eg5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return g;
        }
        return (eg5) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    @Modify(description = "强制使用短连接", type = Constants.SHORT_PING_CMD_TYPE)
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (int i = 0; i < this.d.size(); i++) {
                this.d.valueAt(i).b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eg5() {
        super(1001);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.c = 300000L;
        this.d = new SparseArray<>();
        this.e = new HashSet<>();
        this.f = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    @Modify(description = "长连接是否可用", type = 32)
    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.f = 0;
            if (d()) {
                this.f = 3;
                return false;
            } else if (this.e.contains(Integer.valueOf(i))) {
                this.f = 6;
                return false;
            } else if (!MessageManager.getInstance().getSocketClient().u()) {
                this.f = 1;
                return false;
            } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().p() > gg5.j().i() + 20000) {
                oa.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
                this.f = 2;
                return false;
            } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
                return false;
            } else {
                b bVar = this.d.get(i);
                if (bVar != null && bVar.b) {
                    if (Math.abs(System.currentTimeMillis() - bVar.c) > this.c) {
                        bVar.b();
                    } else {
                        this.f = 4;
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            b bVar = this.d.get(i);
            if (bVar == null) {
                bVar = new b(null);
                this.d.append(i, bVar);
            }
            if (bVar != null) {
                bVar.a(this.b);
            }
            this.f = 5;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d.remove(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: g */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, socketResponsedMessage) != null) || !(socketResponsedMessage instanceof ResponseOnlineMessage) || ((ResponseOnlineMessage) socketResponsedMessage).getError() != 0) {
            return;
        }
        h();
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.a = z;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = i;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.c = j;
        }
    }

    public void l(int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, iArr) == null) && iArr != null && iArr.length > 0) {
            this.e.clear();
            for (int i : iArr) {
                this.e.add(Integer.valueOf(i));
            }
        }
    }
}
