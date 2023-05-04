package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes4.dex */
public interface f17 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(j17 j17Var);

    void notifyDataSetChanged();

    void setList(List<? extends s17<?>> list);
}
