package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.wg4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface gr1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, wg4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull t73 t73Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, mm3<String> mm3Var);
}
