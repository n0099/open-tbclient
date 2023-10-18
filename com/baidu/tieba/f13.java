package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.lo2;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f13 extends d13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.d13
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d13
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d13
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d13
    public qx1 m(z03 z03Var, b72<a13> b72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, z03Var, b72Var)) == null) {
            return null;
        }
        return (qx1) invokeLL.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ z03 b;
        public final /* synthetic */ y42 c;

        public a(f13 f13Var, String str, z03 z03Var, y42 y42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f13Var, str, z03Var, y42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z03Var;
            this.c = y42Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pv2 pv2Var = new pv2();
                pv2Var.c = this.a;
                pv2Var.b = a13.a(this.b);
                y42.b i = this.c.i("navigateTo");
                i.n(y42.g, y42.i);
                i.k("pluginFunPage", pv2Var).a();
            }
        }
    }

    public f13() {
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

    @Override // com.baidu.tieba.d13
    public qx1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new qx1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new qx1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new qx1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (qx1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d13
    public y03 f(z03 z03Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z03Var)) == null) {
            File file = null;
            if (z03Var == null) {
                return null;
            }
            String str = z03Var.a;
            String str2 = z03Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            y03 y03Var = new y03();
            y03Var.a = str;
            y03Var.b = str2;
            if (g32.d()) {
                file = lo2.f.e();
            } else if (o13.H()) {
                file = lo2.b.e();
            } else if (o13.D()) {
                file = w22.d();
            } else {
                if (TextUtils.equals(z03Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = sx1.a(str);
                    File g = lo2.g();
                    String[] list = g.list();
                    if (list != null && g.length() != 0) {
                        String str3 = a2 + "_dev";
                        int i2 = -1;
                        for (String str4 : list) {
                            if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                                try {
                                    int parseInt = Integer.parseInt(str4.substring(str3.length()));
                                    if (parseInt > i2) {
                                        i2 = parseInt;
                                    }
                                } catch (NumberFormatException e) {
                                    h13.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            y03Var.a = str3 + i2;
                            y03Var.e = true;
                            File file2 = new File(g, y03Var.a + File.separator + i2);
                            y03Var.c = file2.getAbsolutePath();
                            y03Var.d = i2;
                            file = file2;
                        } else {
                            y03Var.e = false;
                            y03Var.c = null;
                        }
                    } else {
                        return y03Var;
                    }
                } else {
                    File file3 = new File(lo2.g(), str);
                    if (!file3.exists()) {
                        return y03Var;
                    }
                    String[] list2 = file3.list();
                    if (list2 != null && list2.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list2) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    h13.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            y03Var.d = i3;
                            y03Var.e = true;
                            file = new File(file3, str5);
                            y03Var.c = file.getAbsolutePath();
                        }
                    }
                    return y03Var;
                }
            }
            if (file == null) {
                return y03Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return y03Var;
            }
            y03Var.f = true;
            y03Var.c = file4.getAbsolutePath();
            return y03Var;
        }
        return (y03) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d13
    public qx1 j(String str, z03 z03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, z03Var)) == null) {
            if (z03Var == null) {
                return new qx1(201, "pay args is null");
            }
            SwanAppActivity w = o53.K().w();
            if (w == null) {
                return new qx1(1001, "runtime exception, try reopen this app");
            }
            y42 Y = w.Y();
            if (Y == null) {
                return new qx1(1001, "runtime exception, page manager breakdown");
            }
            h13.b("jump to fun page");
            o53.M().post(new a(this, str, z03Var, Y));
            return new qx1(0);
        }
        return (qx1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
            if (file == null || !file.exists() || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
