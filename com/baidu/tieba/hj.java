package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes4.dex */
public class hj {
    public static /* synthetic */ Interceptable $ic;
    public static hj h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<BasicNameValuePair> b;
    public String[] c;
    public String d;
    public ij e;
    public ArrayList<gj> f;
    public gj g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448306411, "Lcom/baidu/tieba/hj;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448306411, "Lcom/baidu/tieba/hj;");
        }
    }

    /* loaded from: classes4.dex */
    public class a implements gj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hj a;

        public a(hj hjVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hjVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hjVar;
        }

        @Override // com.baidu.tieba.gj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((gj) it.next()).a(str);
                }
            }
        }

        @Override // com.baidu.tieba.gj
        public void c(cj cjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cjVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((gj) it.next()).c(cjVar);
                }
            }
        }

        @Override // com.baidu.tieba.gj
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((gj) it.next()).d(bArr);
                }
            }
        }

        @Override // com.baidu.tieba.gj
        public void f(kj kjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, kjVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((gj) it.next()).f(kjVar);
                }
            }
        }

        @Override // com.baidu.tieba.gj
        public void h(cj cjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, cjVar) == null) && cjVar != null) {
                cjVar.c();
            }
        }

        @Override // com.baidu.tieba.gj
        public void i(cj cjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cjVar) == null) && cjVar != null) {
                cjVar.b();
            }
        }

        @Override // com.baidu.tieba.gj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((gj) it.next()).onOpen(map);
                }
            }
        }

        @Override // com.baidu.tieba.gj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) != null) {
                return;
            }
            this.a.e = null;
            Iterator it = this.a.f.iterator();
            while (it.hasNext()) {
                ((gj) it.next()).b(i, str);
            }
        }

        @Override // com.baidu.tieba.gj
        public void g(int i, cj cjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048582, this, i, cjVar) == null) && cjVar != null) {
                cjVar.a(i);
            }
        }

        @Override // com.baidu.tieba.gj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((gj) it.next()).e();
                }
            }
        }
    }

    public hj() {
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

    public boolean c(gj gjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gjVar)) == null) {
            if (gjVar != null) {
                synchronized (hj.class) {
                    if (!this.f.contains(gjVar)) {
                        return this.f.add(gjVar);
                    }
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean v(cj cjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, cjVar)) == null) {
            synchronized (this) {
                if (cjVar == null) {
                    return false;
                }
                hi.c();
                if (this.e != null) {
                    return this.e.I(cjVar);
                }
                if (cjVar != null) {
                    cjVar.a(1);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void f(int i, String str) {
        ij ijVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (ijVar = this.e) != null) {
            this.e = null;
            ijVar.q(i, str);
            if (this.e != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.e = null;
            }
        }
    }

    public static hj j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (hj.class) {
                    if (h == null) {
                        h = new hj();
                    }
                }
            }
            return h;
        }
        return (hj) invokeV.objValue;
    }

    public void d() {
        ij ijVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ijVar = this.e) != null) {
            ijVar.o();
        }
    }

    public void e() {
        ij ijVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ijVar = this.e) != null) {
            ijVar.p();
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ij ijVar = this.e;
            if (ijVar != null) {
                return ijVar.z();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ij ijVar = this.e;
            if (ijVar != null) {
                return ijVar.A();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ij ijVar = this.e;
            if (ijVar != null) {
                return ijVar.v();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (t()) {
                hi.c();
            }
            ij ijVar = this.e;
            if (ijVar != null && ijVar.E() && !this.e.F()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (t()) {
                hi.c();
            }
            ij ijVar = this.e;
            if (ijVar != null && ijVar.E()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ij ijVar = this.e;
            if (ijVar != null) {
                return ijVar.w();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ij ijVar = this.e;
            if (ijVar != null) {
                return ijVar.x();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ij ijVar = this.e;
            if (ijVar != null) {
                return ijVar.B();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ij ijVar = this.e;
            if (ijVar != null) {
                return ijVar.y();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (t()) {
                hi.c();
            }
            ij ijVar = this.e;
            if (ijVar != null && ijVar.C()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public void r(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, strArr, list) == null) {
            this.a = str;
            this.d = str2;
            this.c = strArr;
            this.b = list;
            t();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (t()) {
                hi.c();
            }
            ij ijVar = this.e;
            if (ijVar != null) {
                if (!ijVar.C() && !this.e.E()) {
                    this.e.q(1, null);
                    this.e = null;
                } else {
                    t();
                    return true;
                }
            }
            this.e = new ij();
            try {
                dk dkVar = new dk();
                dkVar.j(this.d);
                this.e.r(this.a, this.c, this.g, dkVar, this.b);
                return true;
            } catch (WebSocketException unused) {
                this.e = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
