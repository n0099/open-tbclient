package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.zh4;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface fg4 {
    gj4 A();

    int B();

    void C();

    void D(lk4 lk4Var);

    String E();

    int F(String str, int i);

    void G(String str, String str2, Throwable th);

    void H(zk4 zk4Var);

    String I();

    String J(int i);

    void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z);

    void L(String str, String str2, String str3, @Nullable Throwable th, boolean z);

    fi4 M();

    float a();

    String b();

    String c();

    void d(byte[] bArr);

    String e();

    CookieManager f();

    String g();

    String h();

    yo4 i();

    long j(int i);

    void k(JSONArray jSONArray, String str, String str2);

    List<ph4> l(String str, long j);

    void m(String str, String str2, zh4.c cVar);

    fi4 n();

    boolean o(boolean z, @NonNull JSONArray jSONArray);

    void p(String str, JSONObject jSONObject, vh4 vh4Var, List<wh4> list);

    String q();

    boolean r(@Nullable xh4 xh4Var);

    void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void t(ol4 ol4Var, em4 em4Var);

    String u();

    String v(int i);

    long w(int i);

    boolean x();

    void y(String str, String str2);

    void z(String str, String str2, String str3, boolean z);
}
