package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface eb1 {
    void a(Activity activity, String str, String str2);

    void aLiAuth(Activity activity, String str, lb1<JSONObject> lb1Var);

    boolean b(Context context);

    void c(Activity activity, String str, za1 za1Var);

    void d(Context context, JSONObject jSONObject, za1 za1Var);

    void e(Activity activity, String str, za1 za1Var);

    void f(Context context, JSONObject jSONObject);

    void g(Bundle bundle);

    void h(String str);

    void i(Activity activity, JSONObject jSONObject, za1 za1Var);

    String j(Context context);
}
