package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.cs2;
import com.baidu.tieba.fs2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class bf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean e(cf2 cf2Var);

    public abstract String f(String str);

    public abstract String i();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ cf2 b;
        public final /* synthetic */ df2 c;
        public final /* synthetic */ bf2 d;

        public a(bf2 bf2Var, HybridUbcFlow hybridUbcFlow, cf2 cf2Var, df2 df2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bf2Var, hybridUbcFlow, cf2Var, df2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = bf2Var;
            this.a = hybridUbcFlow;
            this.b = cf2Var;
            this.c = df2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp#run-start");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                String f = this.d.f(this.b.g);
                if (TextUtils.isEmpty(f)) {
                    this.c.onFailed(0);
                    return;
                }
                JSONObject d = gm3.d(f);
                HybridUbcFlow hybridUbcFlow2 = this.a;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp#run-appInfoJson");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                PMSAppInfo l = this.d.l(this.b, d);
                if (l == null) {
                    this.c.onFailed(1);
                    return;
                }
                HybridUbcFlow hybridUbcFlow3 = this.a;
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("loadPresetApp#run-PMSAppInfo");
                ubcFlowEvent3.a(true);
                hybridUbcFlow3.F(ubcFlowEvent3);
                this.c.a(l);
                long currentTimeMillis = System.currentTimeMillis();
                boolean e = this.d.e(this.b);
                if (bf2.a) {
                    Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                }
                HybridUbcFlow hybridUbcFlow4 = this.a;
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("loadPresetApp#run-doUnzipBundle");
                ubcFlowEvent4.a(true);
                hybridUbcFlow4.F(ubcFlowEvent4);
                if (e) {
                    bf2 bf2Var = this.d;
                    cf2 cf2Var = this.b;
                    l.setOrientation(bf2Var.g(cf2Var.h, cf2Var.g, cf2Var.i));
                    l.updateInstallSrc(3);
                    dh4.i().a(this.b, l);
                    HybridUbcFlow hybridUbcFlow5 = this.a;
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("loadPresetApp#run-bulkInsert");
                    ubcFlowEvent5.a(true);
                    hybridUbcFlow5.F(ubcFlowEvent5);
                    this.c.b(l);
                } else {
                    this.c.onFailed(2);
                }
                HybridUbcFlow hybridUbcFlow6 = this.a;
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("loadPresetApp#run-return");
                ubcFlowEvent6.a(true);
                hybridUbcFlow6.F(ubcFlowEvent6);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947642971, "Lcom/baidu/tieba/bf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947642971, "Lcom/baidu/tieba/bf2;");
                return;
            }
        }
        a = qp1.a;
    }

    public bf2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean d(ReadableByteChannel readableByteChannel, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, readableByteChannel, str)) == null) {
            if (readableByteChannel != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean c = tm3.c(readableByteChannel, str);
                        if (a) {
                            Log.d("PresetController", "签名校验结果：" + c + " ,耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                        }
                        return c;
                    }
                } catch (IOException e) {
                    if (a) {
                        e.printStackTrace();
                    }
                    return false;
                } finally {
                    kp4.d(readableByteChannel);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void k(cf2 cf2Var, df2 df2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cf2Var, df2Var) == null) {
            HybridUbcFlow p = l23.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp-start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (df2Var == null) {
                return;
            }
            if (cf2Var == null) {
                df2Var.onFailed(0);
                return;
            }
            am3.k(new a(this, p, cf2Var, df2Var), "加载小程序预置包");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp-return");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public boolean n(BufferedInputStream bufferedInputStream, File file) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bufferedInputStream, file)) == null) {
            if (bufferedInputStream != null) {
                try {
                    if (file != null) {
                        fs2.c i = fs2.i(bufferedInputStream);
                        if (i != null && i.b != -1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            return fs2.d(bufferedInputStream, file, i.b).a;
                        }
                        return np4.d(bufferedInputStream, file.getPath());
                    }
                } catch (IOException e) {
                    if (a) {
                        e.printStackTrace();
                    }
                    return false;
                } finally {
                    kp4.d(bufferedInputStream);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final int g(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            if (i == 1) {
                return os2.i().u(str, j);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public HashMap<String, cf2> h() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String i = i();
            if (TextUtils.isEmpty(i) || (optJSONArray = gm3.d(i).optJSONArray("list")) == null) {
                return null;
            }
            HashMap<String, cf2> hashMap = new HashMap<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                cf2 m = m(optJSONArray.optJSONObject(i2));
                if (m != null) {
                    hashMap.put(m.g, m);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public File j(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            if (i == 0) {
                return cs2.e.i(str, String.valueOf(j));
            }
            if (i == 1) {
                return os2.g().a(str, String.valueOf(j));
            }
            return null;
        }
        return (File) invokeCommon.objValue;
    }

    public final PMSAppInfo l(cf2 cf2Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        PMSAppInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cf2Var, jSONObject)) == null) {
            if (jSONObject == null || cf2Var == null || (a2 = nm4.a(jSONObject)) == null) {
                return null;
            }
            a2.copyMainPkgInfo(cf2Var);
            a2.createTime = System.currentTimeMillis();
            return a2;
        }
        return (PMSAppInfo) invokeLL.objValue;
    }

    public final cf2 m(JSONObject jSONObject) {
        InterceptResult invokeL;
        cf2 cf2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
            if (jSONObject == null || (cf2Var = (cf2) nm4.j(jSONObject, new cf2())) == null) {
                return null;
            }
            cf2Var.o = jSONObject.optInt("pkg_type");
            cf2Var.q = jSONObject.optString("bundle_name");
            if (!cf2Var.a()) {
                return null;
            }
            return cf2Var;
        }
        return (cf2) invokeL.objValue;
    }
}
