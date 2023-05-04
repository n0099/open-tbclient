package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.bp3;
import com.baidu.tieba.fp3;
import com.baidu.tieba.jo3;
import com.baidu.tieba.qq3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public interface ap3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, jo1 jo1Var);

    yo3 d(Context context);

    void e(Activity activity, String str, String str2, zo3 zo3Var);

    void f(Context context, qq3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(lo1 lo1Var);

    void i(Context context, bp3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, zo3 zo3Var);

    void m(Activity activity, String str, fq3 fq3Var);

    void n(String str, ArrayList<String> arrayList, fp3.c cVar);

    void o(jo3.a aVar, String str, List<String> list);
}
