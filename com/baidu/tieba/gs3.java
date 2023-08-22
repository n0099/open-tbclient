package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.hs3;
import com.baidu.tieba.ls3;
import com.baidu.tieba.pr3;
import com.baidu.tieba.wt3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public interface gs3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, pr1 pr1Var);

    es3 d(Context context);

    void e(Activity activity, String str, String str2, fs3 fs3Var);

    void f(Context context, wt3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(rr1 rr1Var);

    void i(Context context, hs3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, fs3 fs3Var);

    void m(Activity activity, String str, lt3 lt3Var);

    void n(String str, ArrayList<String> arrayList, ls3.c cVar);

    void o(pr3.a aVar, String str, List<String> list);
}
