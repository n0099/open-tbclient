package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.ck3;
import com.baidu.tieba.gk3;
import com.baidu.tieba.kj3;
import com.baidu.tieba.rl3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public interface bk3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, kj1 kj1Var);

    zj3 d(Context context);

    void e(Activity activity, String str, String str2, ak3 ak3Var);

    void f(Context context, rl3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(mj1 mj1Var);

    void i(Context context, ck3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, ak3 ak3Var);

    void m(Activity activity, String str, gl3 gl3Var);

    void n(String str, ArrayList<String> arrayList, gk3.c cVar);

    void o(kj3.a aVar, String str, List<String> list);
}
