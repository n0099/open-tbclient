package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes5.dex */
public interface cc7 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(gc7 gc7Var);

    void notifyDataSetChanged();

    void setList(List<? extends pc7<?>> list);
}
