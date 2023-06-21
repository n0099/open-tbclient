package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes5.dex */
public interface b87 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(f87 f87Var);

    void notifyDataSetChanged();

    void setList(List<? extends o87<?>> list);
}
