package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public interface g17 {

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view2, s17<?> s17Var, r17<?, ?> r17Var);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(@NonNull s17<?> s17Var);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(@NonNull s17<?> s17Var, @NonNull r17<?, ?> r17Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes4.dex */
    public interface d {
        boolean a(View view2, s17<?> s17Var, r17<?, ?> r17Var);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);
}
