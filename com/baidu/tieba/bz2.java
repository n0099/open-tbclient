package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.hm2;
import com.baidu.tieba.u22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bz2 extends zy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vy2 b;
        public final /* synthetic */ u22 c;

        public a(bz2 bz2Var, String str, vy2 vy2Var, u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz2Var, str, vy2Var, u22Var};
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
            this.b = vy2Var;
            this.c = u22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lt2 lt2Var = new lt2();
                lt2Var.c = this.a;
                lt2Var.b = wy2.a(this.b);
                u22.b i = this.c.i("navigateTo");
                i.n(u22.g, u22.i);
                i.k("pluginFunPage", lt2Var).a();
            }
        }
    }

    public bz2() {
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

    @Override // com.baidu.tieba.zy2
    public lv1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new lv1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new lv1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new lv1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public uy2 f(vy2 vy2Var) {
        InterceptResult invokeL;
        String[] list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vy2Var)) == null) {
            File file = null;
            if (vy2Var == null) {
                return null;
            }
            String str = vy2Var.a;
            String str2 = vy2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            uy2 uy2Var = new uy2();
            uy2Var.a = str;
            uy2Var.b = str2;
            if (c12.d()) {
                file = hm2.f.e();
            } else if (kz2.H()) {
                file = hm2.b.e();
            } else if (kz2.D()) {
                file = s02.d();
            } else {
                if (TextUtils.equals(vy2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = nv1.a(str);
                    File g = hm2.g();
                    String[] list2 = g.list();
                    if (list2 == null || g.length() == 0) {
                        return uy2Var;
                    }
                    String str3 = a2 + "_dev";
                    int i2 = -1;
                    for (String str4 : list2) {
                        if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                            try {
                                int parseInt = Integer.parseInt(str4.substring(str3.length()));
                                if (parseInt > i2) {
                                    i2 = parseInt;
                                }
                            } catch (NumberFormatException e) {
                                dz2.b(Log.getStackTraceString(e));
                            }
                        }
                    }
                    if (i2 > -1) {
                        uy2Var.a = str3 + i2;
                        uy2Var.e = true;
                        File file2 = new File(g, uy2Var.a + File.separator + i2);
                        uy2Var.c = file2.getAbsolutePath();
                        uy2Var.d = i2;
                        file = file2;
                    } else {
                        uy2Var.e = false;
                        uy2Var.c = null;
                    }
                } else {
                    File file3 = new File(hm2.g(), str);
                    if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    dz2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            uy2Var.d = i3;
                            uy2Var.e = true;
                            file = new File(file3, str5);
                            uy2Var.c = file.getAbsolutePath();
                        }
                    }
                    return uy2Var;
                }
            }
            if (file == null) {
                return uy2Var;
            }
            File file4 = new File(file, str2);
            if (n(file4)) {
                uy2Var.f = true;
                uy2Var.c = file4.getAbsolutePath();
                return uy2Var;
            }
            return uy2Var;
        }
        return (uy2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public lv1 j(String str, vy2 vy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, vy2Var)) == null) {
            if (vy2Var == null) {
                return new lv1(201, "pay args is null");
            }
            SwanAppActivity w = k33.K().w();
            if (w == null) {
                return new lv1(1001, "runtime exception, try reopen this app");
            }
            u22 X = w.X();
            if (X == null) {
                return new lv1(1001, "runtime exception, page manager breakdown");
            }
            dz2.b("jump to fun page");
            k33.M().post(new a(this, str, vy2Var, X));
            return new lv1(0);
        }
        return (lv1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zy2
    public lv1 m(vy2 vy2Var, x42<wy2> x42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, vy2Var, x42Var)) == null) {
            return null;
        }
        return (lv1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) ? file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0 : invokeL.booleanValue;
    }
}
