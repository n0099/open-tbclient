package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes5.dex */
public interface eb7 {
    void c(@NonNull RecyclerView recyclerView, boolean z);

    void e(@NonNull RecyclerView recyclerView);

    void j(ib7 ib7Var);

    void notifyDataSetChanged();

    void setList(List<? extends rb7<?>> list);
}
