package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.di3;
import com.baidu.tieba.hi3;
import com.baidu.tieba.lh3;
import com.baidu.tieba.sj3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public interface ci3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, mh1 mh1Var);

    ai3 d(Context context);

    void e(Activity activity, String str, String str2, bi3 bi3Var);

    void f(Context context, sj3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(oh1 oh1Var);

    void i(Context context, di3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, bi3 bi3Var);

    void m(Activity activity, String str, hj3 hj3Var);

    void n(String str, ArrayList<String> arrayList, hi3.c cVar);

    void o(lh3.a aVar, String str, List<String> list);
}
