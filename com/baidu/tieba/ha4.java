package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bc4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface ha4 {
    id4 A();

    int B();

    void C();

    void D(ne4 ne4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(bf4 bf4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    hc4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    aj4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<rb4> l(String str, long j);

    void m(String str, String str2, bc4.c cVar);

    hc4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, xb4 xb4Var, List<yb4> list);

    String q();

    boolean r(@Nullable zb4 zb4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(qf4 qf4Var, gg4 gg4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
