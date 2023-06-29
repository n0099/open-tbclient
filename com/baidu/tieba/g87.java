package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes5.dex */
public interface g87 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(k87 k87Var);

    void notifyDataSetChanged();

    void setList(List<? extends t87<?>> list);
}
