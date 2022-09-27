package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface d81<View> {
    void a();

    void b(String str, boolean z);

    void c(boolean z);

    View getRealView();

    void setContainer(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams);

    void setCriusPopListener(@NonNull b81 b81Var);

    void setData(@NonNull ap0 ap0Var);
}
