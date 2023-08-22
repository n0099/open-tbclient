package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface am0<VIEW extends View> {
    void b(@NonNull ViewGroup viewGroup);

    @NonNull
    VIEW getRealView();

    void update(String str, @NonNull hl0 hl0Var);
}
