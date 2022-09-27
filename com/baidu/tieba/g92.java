package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.hm2;
import com.baidu.tieba.km2;
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
/* loaded from: classes4.dex */
public abstract class g92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ h92 b;
        public final /* synthetic */ i92 c;
        public final /* synthetic */ g92 d;

        public a(g92 g92Var, HybridUbcFlow hybridUbcFlow, h92 h92Var, i92 i92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var, hybridUbcFlow, h92Var, i92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = g92Var;
            this.a = hybridUbcFlow;
            this.b = h92Var;
            this.c = i92Var;
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
                JSONObject d = lg3.d(f);
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
                if (g92.a) {
                    Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                }
                HybridUbcFlow hybridUbcFlow4 = this.a;
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("loadPresetApp#run-doUnzipBundle");
                ubcFlowEvent4.a(true);
                hybridUbcFlow4.F(ubcFlowEvent4);
                if (e) {
                    g92 g92Var = this.d;
                    h92 h92Var = this.b;
                    l.setOrientation(g92Var.g(h92Var.h, h92Var.g, h92Var.i));
                    l.updateInstallSrc(3);
                    ib4.i().a(this.b, l);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748681, "Lcom/baidu/tieba/g92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748681, "Lcom/baidu/tieba/g92;");
                return;
            }
        }
        a = vj1.a;
    }

    public g92() {
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
                        boolean c = yg3.c(readableByteChannel, str);
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
                    pj4.d(readableByteChannel);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract boolean e(h92 h92Var);

    public abstract String f(String str);

    public final int g(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            if (i == 1) {
                return tm2.i().u(str, j);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public HashMap<String, h92> h() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String i = i();
            if (TextUtils.isEmpty(i) || (optJSONArray = lg3.d(i).optJSONArray("list")) == null) {
                return null;
            }
            HashMap<String, h92> hashMap = new HashMap<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                h92 m = m(optJSONArray.optJSONObject(i2));
                if (m != null) {
                    hashMap.put(m.g, m);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public abstract String i();

    public File j(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            if (i == 0) {
                return hm2.e.i(str, String.valueOf(j));
            }
            if (i == 1) {
                return tm2.g().a(str, String.valueOf(j));
            }
            return null;
        }
        return (File) invokeCommon.objValue;
    }

    public void k(h92 h92Var, i92 i92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, h92Var, i92Var) == null) {
            HybridUbcFlow p = qw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp-start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (i92Var == null) {
                return;
            }
            if (h92Var == null) {
                i92Var.onFailed(0);
                return;
            }
            fg3.k(new a(this, p, h92Var, i92Var), "加载小程序预置包");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp-return");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final PMSAppInfo l(h92 h92Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        PMSAppInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h92Var, jSONObject)) == null) {
            if (jSONObject == null || h92Var == null || (a2 = sg4.a(jSONObject)) == null) {
                return null;
            }
            a2.copyMainPkgInfo(h92Var);
            a2.createTime = System.currentTimeMillis();
            return a2;
        }
        return (PMSAppInfo) invokeLL.objValue;
    }

    public final h92 m(JSONObject jSONObject) {
        InterceptResult invokeL;
        h92 h92Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
            if (jSONObject == null || (h92Var = (h92) sg4.j(jSONObject, new h92())) == null) {
                return null;
            }
            h92Var.o = jSONObject.optInt("pkg_type");
            h92Var.q = jSONObject.optString("bundle_name");
            if (h92Var.a()) {
                return h92Var;
            }
            return null;
        }
        return (h92) invokeL.objValue;
    }

    public boolean n(BufferedInputStream bufferedInputStream, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bufferedInputStream, file)) == null) {
            if (bufferedInputStream != null) {
                try {
                    if (file != null) {
                        km2.c i = km2.i(bufferedInputStream);
                        if ((i == null || i.b == -1) ? false : true) {
                            return km2.d(bufferedInputStream, file, i.b).a;
                        }
                        return sj4.d(bufferedInputStream, file.getPath());
                    }
                } catch (IOException e) {
                    if (a) {
                        e.printStackTrace();
                    }
                    return false;
                } finally {
                    pj4.d(bufferedInputStream);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
