package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.im2;
import com.baidu.tieba.v22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cz2 extends az2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.az2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.az2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.az2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.az2
    public mv1 m(wy2 wy2Var, y42 y42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, wy2Var, y42Var)) == null) {
            return null;
        }
        return (mv1) invokeLL.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wy2 b;
        public final /* synthetic */ v22 c;

        public a(cz2 cz2Var, String str, wy2 wy2Var, v22 v22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz2Var, str, wy2Var, v22Var};
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
            this.b = wy2Var;
            this.c = v22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mt2 mt2Var = new mt2();
                mt2Var.c = this.a;
                mt2Var.b = xy2.a(this.b);
                v22.b i = this.c.i("navigateTo");
                i.n(v22.g, v22.i);
                i.k("pluginFunPage", mt2Var).a();
            }
        }
    }

    public cz2() {
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

    @Override // com.baidu.tieba.az2
    public mv1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new mv1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new mv1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new mv1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (mv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.az2
    public vy2 f(wy2 wy2Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wy2Var)) == null) {
            File file = null;
            if (wy2Var == null) {
                return null;
            }
            String str = wy2Var.a;
            String str2 = wy2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            vy2 vy2Var = new vy2();
            vy2Var.a = str;
            vy2Var.b = str2;
            if (d12.d()) {
                file = im2.f.e();
            } else if (lz2.H()) {
                file = im2.b.e();
            } else if (lz2.D()) {
                file = t02.d();
            } else {
                if (TextUtils.equals(wy2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = ov1.a(str);
                    File g = im2.g();
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
                                    ez2.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            vy2Var.a = str3 + i2;
                            vy2Var.e = true;
                            File file2 = new File(g, vy2Var.a + File.separator + i2);
                            vy2Var.c = file2.getAbsolutePath();
                            vy2Var.d = i2;
                            file = file2;
                        } else {
                            vy2Var.e = false;
                            vy2Var.c = null;
                        }
                    } else {
                        return vy2Var;
                    }
                } else {
                    File file3 = new File(im2.g(), str);
                    if (!file3.exists()) {
                        return vy2Var;
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
                                    ez2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            vy2Var.d = i3;
                            vy2Var.e = true;
                            file = new File(file3, str5);
                            vy2Var.c = file.getAbsolutePath();
                        }
                    }
                    return vy2Var;
                }
            }
            if (file == null) {
                return vy2Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return vy2Var;
            }
            vy2Var.f = true;
            vy2Var.c = file4.getAbsolutePath();
            return vy2Var;
        }
        return (vy2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.az2
    public mv1 j(String str, wy2 wy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, wy2Var)) == null) {
            if (wy2Var == null) {
                return new mv1(201, "pay args is null");
            }
            SwanAppActivity w = l33.K().w();
            if (w == null) {
                return new mv1(1001, "runtime exception, try reopen this app");
            }
            v22 X = w.X();
            if (X == null) {
                return new mv1(1001, "runtime exception, page manager breakdown");
            }
            ez2.b("jump to fun page");
            l33.M().post(new a(this, str, wy2Var, X));
            return new mv1(0);
        }
        return (mv1) invokeLL.objValue;
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
