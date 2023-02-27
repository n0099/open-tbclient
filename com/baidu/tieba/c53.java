package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.is2;
import com.baidu.tieba.v82;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c53 extends a53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.a53
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a53
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a53
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a53
    public m12 m(w43 w43Var, ya2<x43> ya2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, w43Var, ya2Var)) == null) {
            return null;
        }
        return (m12) invokeLL.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ w43 b;
        public final /* synthetic */ v82 c;

        public a(c53 c53Var, String str, w43 w43Var, v82 v82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c53Var, str, w43Var, v82Var};
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
            this.b = w43Var;
            this.c = v82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mz2 mz2Var = new mz2();
                mz2Var.c = this.a;
                mz2Var.b = x43.a(this.b);
                v82.b i = this.c.i("navigateTo");
                i.n(v82.g, v82.i);
                i.k("pluginFunPage", mz2Var).a();
            }
        }
    }

    public c53() {
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

    @Override // com.baidu.tieba.a53
    public m12 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new m12(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new m12(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new m12(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (m12) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a53
    public v43 f(w43 w43Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w43Var)) == null) {
            File file = null;
            if (w43Var == null) {
                return null;
            }
            String str = w43Var.a;
            String str2 = w43Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            v43 v43Var = new v43();
            v43Var.a = str;
            v43Var.b = str2;
            if (d72.d()) {
                file = is2.f.e();
            } else if (l53.H()) {
                file = is2.b.e();
            } else if (l53.D()) {
                file = t62.d();
            } else {
                if (TextUtils.equals(w43Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = o12.a(str);
                    File g = is2.g();
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
                                    e53.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            v43Var.a = str3 + i2;
                            v43Var.e = true;
                            File file2 = new File(g, v43Var.a + File.separator + i2);
                            v43Var.c = file2.getAbsolutePath();
                            v43Var.d = i2;
                            file = file2;
                        } else {
                            v43Var.e = false;
                            v43Var.c = null;
                        }
                    } else {
                        return v43Var;
                    }
                } else {
                    File file3 = new File(is2.g(), str);
                    if (!file3.exists()) {
                        return v43Var;
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
                                    e53.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            v43Var.d = i3;
                            v43Var.e = true;
                            file = new File(file3, str5);
                            v43Var.c = file.getAbsolutePath();
                        }
                    }
                    return v43Var;
                }
            }
            if (file == null) {
                return v43Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return v43Var;
            }
            v43Var.f = true;
            v43Var.c = file4.getAbsolutePath();
            return v43Var;
        }
        return (v43) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a53
    public m12 j(String str, w43 w43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, w43Var)) == null) {
            if (w43Var == null) {
                return new m12(201, "pay args is null");
            }
            SwanAppActivity w = l93.K().w();
            if (w == null) {
                return new m12(1001, "runtime exception, try reopen this app");
            }
            v82 X = w.X();
            if (X == null) {
                return new m12(1001, "runtime exception, page manager breakdown");
            }
            e53.b("jump to fun page");
            l93.M().post(new a(this, str, w43Var, X));
            return new m12(0);
        }
        return (m12) invokeLL.objValue;
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
