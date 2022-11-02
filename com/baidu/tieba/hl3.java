package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.il3;
import com.baidu.tieba.ml3;
import com.baidu.tieba.qk3;
import com.baidu.tieba.xm3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public interface hl3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, qk1 qk1Var);

    fl3 d(Context context);

    void e(Activity activity, String str, String str2, gl3 gl3Var);

    void f(Context context, xm3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(sk1 sk1Var);

    void i(Context context, il3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, gl3 gl3Var);

    void m(Activity activity, String str, mm3 mm3Var);

    void n(String str, ArrayList<String> arrayList, ml3.c cVar);

    void o(qk3.a aVar, String str, List<String> list);
}
