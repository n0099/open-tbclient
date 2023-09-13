package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes5.dex */
public interface dc7 {

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view2, pc7<?> pc7Var, oc7<?, ?> oc7Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(@NonNull pc7<?> pc7Var, int i);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(@NonNull pc7<?> pc7Var, @NonNull oc7<?, ?> oc7Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes5.dex */
    public interface d {
        boolean a(View view2, pc7<?> pc7Var, oc7<?, ?> oc7Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(@NonNull Object obj);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);

    void k(e eVar);
}
