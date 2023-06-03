package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bl4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface hj4 {
    im4 A();

    int B();

    void C();

    void D(nn4 nn4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(bo4 bo4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    hl4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    as4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<rk4> l(String str, long j);

    void m(String str, String str2, bl4.c cVar);

    hl4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, xk4 xk4Var, List<yk4> list);

    String q();

    boolean r(@Nullable zk4 zk4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(qo4 qo4Var, gp4 gp4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
