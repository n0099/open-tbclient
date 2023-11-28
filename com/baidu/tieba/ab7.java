package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes5.dex */
public interface ab7 {
    void c(@NonNull RecyclerView recyclerView, boolean z);

    void e(@NonNull RecyclerView recyclerView);

    void j(eb7 eb7Var);

    void notifyDataSetChanged();

    void setList(List<? extends nb7<?>> list);
}
