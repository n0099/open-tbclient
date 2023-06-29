package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.gt3;
import com.baidu.tieba.kt3;
import com.baidu.tieba.os3;
import com.baidu.tieba.vu3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public interface ft3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, os1 os1Var);

    dt3 d(Context context);

    void e(Activity activity, String str, String str2, et3 et3Var);

    void f(Context context, vu3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(qs1 qs1Var);

    void i(Context context, gt3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, et3 et3Var);

    void m(Activity activity, String str, ku3 ku3Var);

    void n(String str, ArrayList<String> arrayList, kt3.c cVar);

    void o(os3.a aVar, String str, List<String> list);
}
