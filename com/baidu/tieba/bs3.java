package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.cs3;
import com.baidu.tieba.gs3;
import com.baidu.tieba.kr3;
import com.baidu.tieba.rt3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public interface bs3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, kr1 kr1Var);

    zr3 d(Context context);

    void e(Activity activity, String str, String str2, as3 as3Var);

    void f(Context context, rt3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(mr1 mr1Var);

    void i(Context context, cs3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, as3 as3Var);

    void m(Activity activity, String str, gt3 gt3Var);

    void n(String str, ArrayList<String> arrayList, gs3.c cVar);

    void o(kr3.a aVar, String str, List<String> list);
}
