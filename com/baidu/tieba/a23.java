package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.gp2;
import com.baidu.tieba.t52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a23 extends y13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.y13
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y13
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y13
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y13
    public ly1 m(u13 u13Var, w72<v13> w72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, u13Var, w72Var)) == null) {
            return null;
        }
        return (ly1) invokeLL.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ u13 b;
        public final /* synthetic */ t52 c;

        public a(a23 a23Var, String str, u13 u13Var, t52 t52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a23Var, str, u13Var, t52Var};
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
            this.b = u13Var;
            this.c = t52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kw2 kw2Var = new kw2();
                kw2Var.c = this.a;
                kw2Var.b = v13.a(this.b);
                t52.b i = this.c.i("navigateTo");
                i.n(t52.g, t52.i);
                i.k("pluginFunPage", kw2Var).a();
            }
        }
    }

    public a23() {
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

    @Override // com.baidu.tieba.y13
    public ly1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new ly1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new ly1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new ly1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (ly1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y13
    public t13 f(u13 u13Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u13Var)) == null) {
            File file = null;
            if (u13Var == null) {
                return null;
            }
            String str = u13Var.a;
            String str2 = u13Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            t13 t13Var = new t13();
            t13Var.a = str;
            t13Var.b = str2;
            if (b42.d()) {
                file = gp2.f.e();
            } else if (j23.H()) {
                file = gp2.b.e();
            } else if (j23.D()) {
                file = r32.d();
            } else {
                if (TextUtils.equals(u13Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = ny1.a(str);
                    File g = gp2.g();
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
                                    c23.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            t13Var.a = str3 + i2;
                            t13Var.e = true;
                            File file2 = new File(g, t13Var.a + File.separator + i2);
                            t13Var.c = file2.getAbsolutePath();
                            t13Var.d = i2;
                            file = file2;
                        } else {
                            t13Var.e = false;
                            t13Var.c = null;
                        }
                    } else {
                        return t13Var;
                    }
                } else {
                    File file3 = new File(gp2.g(), str);
                    if (!file3.exists()) {
                        return t13Var;
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
                                    c23.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            t13Var.d = i3;
                            t13Var.e = true;
                            file = new File(file3, str5);
                            t13Var.c = file.getAbsolutePath();
                        }
                    }
                    return t13Var;
                }
            }
            if (file == null) {
                return t13Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return t13Var;
            }
            t13Var.f = true;
            t13Var.c = file4.getAbsolutePath();
            return t13Var;
        }
        return (t13) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y13
    public ly1 j(String str, u13 u13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, u13Var)) == null) {
            if (u13Var == null) {
                return new ly1(201, "pay args is null");
            }
            SwanAppActivity w = j63.K().w();
            if (w == null) {
                return new ly1(1001, "runtime exception, try reopen this app");
            }
            t52 Y = w.Y();
            if (Y == null) {
                return new ly1(1001, "runtime exception, page manager breakdown");
            }
            c23.b("jump to fun page");
            j63.M().post(new a(this, str, u13Var, Y));
            return new ly1(0);
        }
        return (ly1) invokeLL.objValue;
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
