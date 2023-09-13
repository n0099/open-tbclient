package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface bm0<VIEW extends View> {
    void c(@NonNull ViewGroup viewGroup);

    @NonNull
    VIEW getRealView();

    void update(String str, @NonNull il0 il0Var);
}
