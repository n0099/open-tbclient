package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.dt3;
import com.baidu.tieba.ht3;
import com.baidu.tieba.ls3;
import com.baidu.tieba.su3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public interface ct3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, ls1 ls1Var);

    at3 d(Context context);

    void e(Activity activity, String str, String str2, bt3 bt3Var);

    void f(Context context, su3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(ns1 ns1Var);

    void i(Context context, dt3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, bt3 bt3Var);

    void m(Activity activity, String str, hu3 hu3Var);

    void n(String str, ArrayList<String> arrayList, ht3.c cVar);

    void o(ls3.a aVar, String str, List<String> list);
}
