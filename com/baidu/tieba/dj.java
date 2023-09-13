package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes5.dex */
public class dj {
    public static /* synthetic */ Interceptable $ic;
    public static dj h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<BasicNameValuePair> b;
    public String[] c;
    public String d;
    public ej e;
    public ArrayList<cj> f;
    public cj g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448302567, "Lcom/baidu/tieba/dj;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448302567, "Lcom/baidu/tieba/dj;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements cj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj a;

        public a(dj djVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {djVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = djVar;
        }

        @Override // com.baidu.tieba.cj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((cj) it.next()).a(str);
                }
            }
        }

        @Override // com.baidu.tieba.cj
        public void c(yi yiVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yiVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((cj) it.next()).c(yiVar);
                }
            }
        }

        @Override // com.baidu.tieba.cj
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((cj) it.next()).d(bArr);
                }
            }
        }

        @Override // com.baidu.tieba.cj
        public void f(gj gjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gjVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((cj) it.next()).f(gjVar);
                }
            }
        }

        @Override // com.baidu.tieba.cj
        public void h(yi yiVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, yiVar) == null) && yiVar != null) {
                yiVar.c();
            }
        }

        @Override // com.baidu.tieba.cj
        public void i(yi yiVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yiVar) == null) && yiVar != null) {
                yiVar.b();
            }
        }

        @Override // com.baidu.tieba.cj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((cj) it.next()).onOpen(map);
                }
            }
        }

        @Override // com.baidu.tieba.cj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) != null) {
                return;
            }
            this.a.e = null;
            Iterator it = this.a.f.iterator();
            while (it.hasNext()) {
                ((cj) it.next()).b(i, str);
            }
        }

        @Override // com.baidu.tieba.cj
        public void g(int i, yi yiVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048582, this, i, yiVar) == null) && yiVar != null) {
                yiVar.a(i);
            }
        }

        @Override // com.baidu.tieba.cj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((cj) it.next()).e();
                }
            }
        }
    }

    public dj() {
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
        this.a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = new ArrayList<>();
        this.g = null;
        this.g = new a(this);
    }

    public boolean c(cj cjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cjVar)) == null) {
            if (cjVar != null) {
                synchronized (dj.class) {
                    if (!this.f.contains(cjVar)) {
                        return this.f.add(cjVar);
                    }
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean p(yi yiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, yiVar)) == null) {
            synchronized (this) {
                if (yiVar == null) {
                    return false;
                }
                BdUtilHelper.checkMainThread();
                if (this.e != null) {
                    return this.e.D(yiVar);
                }
                if (yiVar != null) {
                    yiVar.a(1);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void f(int i, String str) {
        ej ejVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (ejVar = this.e) != null) {
            this.e = null;
            ejVar.q(i, str);
            if (this.e != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.e = null;
            }
        }
    }

    public static dj h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (dj.class) {
                    if (h == null) {
                        h = new dj();
                    }
                }
            }
            return h;
        }
        return (dj) invokeV.objValue;
    }

    public void d() {
        ej ejVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ejVar = this.e) != null) {
            ejVar.o();
        }
    }

    public void e() {
        ej ejVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ejVar = this.e) != null) {
            ejVar.p();
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ej ejVar = this.e;
            if (ejVar != null) {
                return ejVar.v();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (n()) {
                BdUtilHelper.checkMainThread();
            }
            ej ejVar = this.e;
            if (ejVar != null && ejVar.z() && !this.e.A()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (n()) {
                BdUtilHelper.checkMainThread();
            }
            ej ejVar = this.e;
            if (ejVar != null && ejVar.z()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ej ejVar = this.e;
            if (ejVar != null) {
                return ejVar.w();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (n()) {
                BdUtilHelper.checkMainThread();
            }
            ej ejVar = this.e;
            if (ejVar != null && ejVar.x()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public void l(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, strArr, list) == null) {
            this.a = str;
            this.d = str2;
            this.c = strArr;
            this.b = list;
            n();
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (n()) {
                BdUtilHelper.checkMainThread();
            }
            ej ejVar = this.e;
            if (ejVar != null) {
                if (!ejVar.x() && !this.e.z()) {
                    this.e.q(1, null);
                    this.e = null;
                } else {
                    n();
                    return true;
                }
            }
            this.e = new ej();
            try {
                zj zjVar = new zj();
                zjVar.j(this.d);
                this.e.r(this.a, this.c, this.g, zjVar, this.b);
                return true;
            } catch (WebSocketException unused) {
                this.e = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
