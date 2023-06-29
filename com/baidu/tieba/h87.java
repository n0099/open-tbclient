package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public interface h87 {

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view2, t87<?> t87Var, s87<?, ?> s87Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(@NonNull t87<?> t87Var);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(@NonNull t87<?> t87Var, @NonNull s87<?, ?> s87Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes6.dex */
    public interface d {
        boolean a(View view2, t87<?> t87Var, s87<?, ?> s87Var);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);
}
