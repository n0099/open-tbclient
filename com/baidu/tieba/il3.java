package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.jl3;
import com.baidu.tieba.nl3;
import com.baidu.tieba.rk3;
import com.baidu.tieba.ym3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public interface il3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, rk1 rk1Var);

    gl3 d(Context context);

    void e(Activity activity, String str, String str2, hl3 hl3Var);

    void f(Context context, ym3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(tk1 tk1Var);

    void i(Context context, jl3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, hl3 hl3Var);

    void m(Activity activity, String str, nm3 nm3Var);

    void n(String str, ArrayList<String> arrayList, nl3.c cVar);

    void o(rk3.a aVar, String str, List<String> list);
}
