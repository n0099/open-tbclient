package com.baidu.tieba;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.tca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.b;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ada extends fda {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public ada() {
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

    public static void b(jca jcaVar, nca ncaVar, lca lcaVar, dca dcaVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{jcaVar, ncaVar, lcaVar, dcaVar, list, list2, list3}) == null) {
            int i3 = 0;
            if (list2.size() != 0) {
                i = list2.get(list2.size() - 1).getId();
            } else {
                i = 0;
            }
            jcaVar.b(i);
            ncaVar.a(cda.e().I());
            if (list.size() != 0) {
                i2 = list.get(list.size() - 1).getId();
            } else {
                i2 = 0;
            }
            lcaVar.b(i2);
            if (list3.size() != 0) {
                i3 = list3.get(list3.size() - 1).getId();
            }
            dcaVar.b(i3);
        }
    }

    @Override // com.baidu.tieba.fda
    public final void a() {
        tca tcaVar;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tcaVar = tca.a.a;
            if (tcaVar.a().size() == 0) {
                dda.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(yca.l(cca.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            jca jcaVar = new jca();
            nca ncaVar = new nca();
            lca lcaVar = new lca();
            dca dcaVar = new dca();
            List<com.baidu.ubs.analytics.a.i> a2 = jcaVar.a();
            List<com.baidu.ubs.analytics.a.n> d = ncaVar.d();
            List<com.baidu.ubs.analytics.a.l> a3 = lcaVar.a();
            List<com.baidu.ubs.analytics.a.a> a4 = dcaVar.a();
            dda.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                dda.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            ncaVar.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = cca.h().j();
            if (cca.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : cca.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        lda.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(yca.l(cca.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(yca.g(cca.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(yca.h(cca.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            if (vca.d()) {
                str = "1";
            } else {
                str = "0";
            }
            aVar.j(str);
            aVar.k(yca.i(cca.h().getContext()));
            aVar.m(yca.j(cca.h().getContext()));
            aVar.n(yca.m());
            aVar.o(yca.n());
            aVar.p(yca.a());
            int f = yca.f(cca.h().getContext());
            if (f == 1) {
                str2 = "WIFI";
            } else if (f == 2) {
                str2 = "2G";
            } else if (f == 3) {
                str2 = "3G";
            } else if (f == 4) {
                str2 = "4G";
            } else if (f == 5) {
                str2 = "unKnow";
            } else {
                str2 = "noNet";
            }
            aVar.l(str2);
            cca.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = jda.a(bVar);
            String e2 = ida.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (oca.a(cca.h().getContext(), stringBuffer2.toString())) {
                    dda.b("上传成功，删除本地文件的       ");
                    ida.b(a + "ABJson.log");
                    b(jcaVar, ncaVar, lcaVar, dcaVar, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (oca.a(cca.h().getContext(), stringBuffer3.toString())) {
                    b(jcaVar, ncaVar, lcaVar, dcaVar, a3, a2, a4);
                    return;
                } else if (ida.d(a5, a, "ABJson.log")) {
                    b(jcaVar, ncaVar, lcaVar, dcaVar, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (oca.a(cca.h().getContext(), stringBuffer4.toString())) {
                b(jcaVar, ncaVar, lcaVar, dcaVar, a3, a2, a4);
            } else if (ida.d(a5, a, "ABJson.log")) {
                b(jcaVar, ncaVar, lcaVar, dcaVar, a3, a2, a4);
            }
        }
    }
}
