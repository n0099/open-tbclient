package com.baidu.tieba;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.u2a;
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
public final class b3a extends g3a {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public b3a() {
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

    public static void b(k2a k2aVar, o2a o2aVar, m2a m2aVar, e2a e2aVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{k2aVar, o2aVar, m2aVar, e2aVar, list, list2, list3}) == null) {
            int i3 = 0;
            if (list2.size() != 0) {
                i = list2.get(list2.size() - 1).getId();
            } else {
                i = 0;
            }
            k2aVar.b(i);
            o2aVar.a(d3a.e().I());
            if (list.size() != 0) {
                i2 = list.get(list.size() - 1).getId();
            } else {
                i2 = 0;
            }
            m2aVar.b(i2);
            if (list3.size() != 0) {
                i3 = list3.get(list3.size() - 1).getId();
            }
            e2aVar.b(i3);
        }
    }

    @Override // com.baidu.tieba.g3a
    public final void a() {
        u2a u2aVar;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u2aVar = u2a.a.a;
            if (u2aVar.a().size() == 0) {
                e3a.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(z2a.l(d2a.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            k2a k2aVar = new k2a();
            o2a o2aVar = new o2a();
            m2a m2aVar = new m2a();
            e2a e2aVar = new e2a();
            List<com.baidu.ubs.analytics.a.i> a2 = k2aVar.a();
            List<com.baidu.ubs.analytics.a.n> d = o2aVar.d();
            List<com.baidu.ubs.analytics.a.l> a3 = m2aVar.a();
            List<com.baidu.ubs.analytics.a.a> a4 = e2aVar.a();
            e3a.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                e3a.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            o2aVar.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = d2a.h().j();
            if (d2a.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : d2a.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        m3a.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(z2a.l(d2a.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(z2a.g(d2a.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(z2a.h(d2a.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            if (w2a.d()) {
                str = "1";
            } else {
                str = "0";
            }
            aVar.j(str);
            aVar.k(z2a.i(d2a.h().getContext()));
            aVar.m(z2a.j(d2a.h().getContext()));
            aVar.n(z2a.m());
            aVar.o(z2a.n());
            aVar.p(z2a.a());
            int f = z2a.f(d2a.h().getContext());
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
            d2a.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = k3a.a(bVar);
            String e2 = j3a.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (p2a.a(d2a.h().getContext(), stringBuffer2.toString())) {
                    e3a.b("上传成功，删除本地文件的       ");
                    j3a.b(a + "ABJson.log");
                    b(k2aVar, o2aVar, m2aVar, e2aVar, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (p2a.a(d2a.h().getContext(), stringBuffer3.toString())) {
                    b(k2aVar, o2aVar, m2aVar, e2aVar, a3, a2, a4);
                    return;
                } else if (j3a.d(a5, a, "ABJson.log")) {
                    b(k2aVar, o2aVar, m2aVar, e2aVar, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (p2a.a(d2a.h().getContext(), stringBuffer4.toString())) {
                b(k2aVar, o2aVar, m2aVar, e2aVar, a3, a2, a4);
            } else if (j3a.d(a5, a, "ABJson.log")) {
                b(k2aVar, o2aVar, m2aVar, e2aVar, a3, a2, a4);
            }
        }
    }
}
