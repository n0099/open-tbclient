package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.yg4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface ef4 {
    fi4 A();

    int B();

    void C();

    void D(kj4 kj4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(yj4 yj4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    eh4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    xn4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<og4> l(String str, long j);

    void m(String str, String str2, yg4.c cVar);

    eh4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, ug4 ug4Var, List<vg4> list);

    String q();

    boolean r(@Nullable wg4 wg4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(nk4 nk4Var, dl4 dl4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
