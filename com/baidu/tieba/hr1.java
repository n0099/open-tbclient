package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.xg4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface hr1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, xg4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull u73 u73Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, nm3<String> nm3Var);
}
