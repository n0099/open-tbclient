package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.se4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface dp1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, se4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull p53 p53Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, ik3<String> ik3Var);
}
