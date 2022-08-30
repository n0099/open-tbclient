package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface c81 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, i81<JSONObject> i81Var);

    boolean b(Context context);

    void c(Activity activity, String str, x71 x71Var);

    void d(Context context, JSONObject jSONObject, x71 x71Var);

    void e(Activity activity, String str, x71 x71Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, x71 x71Var);

    String j(Context context);
}
