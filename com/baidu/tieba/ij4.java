package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.cl4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface ij4 {
    jm4 A();

    int B();

    void C();

    void D(on4 on4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(co4 co4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    il4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    bs4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<sk4> l(String str, long j);

    void m(String str, String str2, cl4.c cVar);

    il4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, yk4 yk4Var, List<zk4> list);

    String q();

    boolean r(@Nullable al4 al4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(ro4 ro4Var, hp4 hp4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
