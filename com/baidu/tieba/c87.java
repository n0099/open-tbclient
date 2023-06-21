package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes5.dex */
public interface c87 {

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view2, o87<?> o87Var, n87<?, ?> n87Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(@NonNull o87<?> o87Var);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(@NonNull o87<?> o87Var, @NonNull n87<?, ?> n87Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes5.dex */
    public interface d {
        boolean a(View view2, o87<?> o87Var, n87<?, ?> n87Var);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);
}
