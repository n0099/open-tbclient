package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes5.dex */
public interface fb7 {

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view2, rb7<?> rb7Var, qb7<?, ?> qb7Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(@NonNull rb7<?> rb7Var, int i);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(@NonNull rb7<?> rb7Var, @NonNull qb7<?, ?> qb7Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes5.dex */
    public interface d {
        boolean a(View view2, rb7<?> rb7Var, qb7<?, ?> qb7Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(@NonNull Object obj);
    }

    void b(b bVar);

    void d(c cVar);

    void i(a aVar);

    void k(e eVar);
}
