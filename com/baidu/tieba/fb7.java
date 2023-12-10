package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes5.dex */
public interface fb7 {
    void c(@NonNull RecyclerView recyclerView, boolean z);

    void e(@NonNull RecyclerView recyclerView);

    void j(jb7 jb7Var);

    void notifyDataSetChanged();

    void setList(List<? extends sb7<?>> list);
}
