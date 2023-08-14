package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes6.dex */
public interface i97 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(m97 m97Var);

    void notifyDataSetChanged();

    void setList(List<? extends v97<?>> list);
}
