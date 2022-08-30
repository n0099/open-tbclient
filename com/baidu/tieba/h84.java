package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ba4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface h84 {
    ib4 A();

    int B();

    void C();

    void D(nc4 nc4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(bd4 bd4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    ha4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    ah4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<r94> l(String str, long j);

    void m(String str, String str2, ba4.c cVar);

    ha4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, x94 x94Var, List<y94> list);

    String q();

    boolean r(@Nullable z94 z94Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(qd4 qd4Var, ge4 ge4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
