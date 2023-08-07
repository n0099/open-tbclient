package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public interface i97 {

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view2, u97<?> u97Var, t97<?, ?> t97Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(@NonNull u97<?> u97Var, int i);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(@NonNull u97<?> u97Var, @NonNull t97<?, ?> t97Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes6.dex */
    public interface d {
        boolean a(View view2, u97<?> u97Var, t97<?, ?> t97Var);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(@NonNull Object obj);
    }

    void b(b bVar);

    void e(c cVar);

    void i(a aVar);

    void k(e eVar);
}
