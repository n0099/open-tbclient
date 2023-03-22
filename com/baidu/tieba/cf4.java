package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.wg4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface cf4 {
    di4 A();

    int B();

    void C();

    void D(ij4 ij4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(wj4 wj4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    ch4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    vn4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<mg4> l(String str, long j);

    void m(String str, String str2, wg4.c cVar);

    ch4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, sg4 sg4Var, List<tg4> list);

    String q();

    boolean r(@Nullable ug4 ug4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(lk4 lk4Var, bl4 bl4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
