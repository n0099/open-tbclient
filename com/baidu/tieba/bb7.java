package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes5.dex */
public interface bb7 {

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view2, nb7<?> nb7Var, mb7<?, ?> mb7Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(@NonNull nb7<?> nb7Var, int i);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(@NonNull nb7<?> nb7Var, @NonNull mb7<?, ?> mb7Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes5.dex */
    public interface d {
        boolean a(View view2, nb7<?> nb7Var, mb7<?, ?> mb7Var);
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
