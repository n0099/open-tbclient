package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface ev1 {

    /* loaded from: classes5.dex */
    public interface a {
        void onFinish();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z);

        void b(Exception exc);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(boolean z);

        void b();
    }

    void a(a aVar);

    void b(Activity activity, Bundle bundle, tr1 tr1Var);

    void c(vr1 vr1Var);

    String d(@NonNull Context context);

    boolean e(Context context);

    String f(@NonNull Context context);

    void g(c cVar);

    String h(Context context);

    String i(@NonNull Context context);

    void j(tr1 tr1Var);
}
