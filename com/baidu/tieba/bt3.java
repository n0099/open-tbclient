package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.ct3;
import com.baidu.tieba.gt3;
import com.baidu.tieba.ks3;
import com.baidu.tieba.ru3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public interface bt3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, ks1 ks1Var);

    zs3 d(Context context);

    void e(Activity activity, String str, String str2, at3 at3Var);

    void f(Context context, ru3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(ms1 ms1Var);

    void i(Context context, ct3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, at3 at3Var);

    void m(Activity activity, String str, gu3 gu3Var);

    void n(String str, ArrayList<String> arrayList, gt3.c cVar);

    void o(ks3.a aVar, String str, List<String> list);
}
