package com.baidu.tieba;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.yb9;
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
/* loaded from: classes4.dex */
public final class fc9 extends kc9 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public fc9() {
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

    public static void b(ob9 ob9Var, sb9 sb9Var, qb9 qb9Var, ib9 ib9Var, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ob9Var, sb9Var, qb9Var, ib9Var, list, list2, list3}) == null) {
            ob9Var.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            sb9Var.a(hc9.e().I());
            qb9Var.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            ib9Var.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // com.baidu.tieba.kc9
    public final void a() {
        yb9 yb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yb9Var = yb9.a.a;
            if (yb9Var.a().size() == 0) {
                ic9.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(dc9.l(hb9.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            ob9 ob9Var = new ob9();
            sb9 sb9Var = new sb9();
            qb9 qb9Var = new qb9();
            ib9 ib9Var = new ib9();
            List<com.baidu.ubs.analytics.a.i> a2 = ob9Var.a();
            List<com.baidu.ubs.analytics.a.n> d = sb9Var.d();
            List<com.baidu.ubs.analytics.a.l> a3 = qb9Var.a();
            List<com.baidu.ubs.analytics.a.a> a4 = ib9Var.a();
            ic9.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                ic9.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            sb9Var.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = hb9.h().j();
            if (hb9.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : hb9.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        qc9.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(dc9.l(hb9.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(dc9.g(hb9.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(dc9.h(hb9.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(ac9.d() ? "1" : "0");
            aVar.k(dc9.i(hb9.h().getContext()));
            aVar.m(dc9.j(hb9.h().getContext()));
            aVar.n(dc9.m());
            aVar.o(dc9.n());
            aVar.p(dc9.a());
            int f = dc9.f(hb9.h().getContext());
            aVar.l(f == 1 ? "WIFI" : f == 2 ? "2G" : f == 3 ? "3G" : f == 4 ? "4G" : f == 5 ? "unKnow" : "noNet");
            hb9.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = oc9.a(bVar);
            String e2 = nc9.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (tb9.a(hb9.h().getContext(), stringBuffer2.toString())) {
                    ic9.b("上传成功，删除本地文件的       ");
                    nc9.b(a + "ABJson.log");
                    b(ob9Var, sb9Var, qb9Var, ib9Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (tb9.a(hb9.h().getContext(), stringBuffer3.toString())) {
                    b(ob9Var, sb9Var, qb9Var, ib9Var, a3, a2, a4);
                    return;
                } else if (nc9.d(a5, a, "ABJson.log")) {
                    b(ob9Var, sb9Var, qb9Var, ib9Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (tb9.a(hb9.h().getContext(), stringBuffer4.toString())) {
                b(ob9Var, sb9Var, qb9Var, ib9Var, a3, a2, a4);
            } else if (nc9.d(a5, a, "ABJson.log")) {
                b(ob9Var, sb9Var, qb9Var, ib9Var, a3, a2, a4);
            }
        }
    }
}
