package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface c91<View> {
    void a();

    void b(String str, boolean z);

    void c(boolean z);

    View getRealView();

    void setContainer(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams);

    void setCriusPopListener(@NonNull a91 a91Var);

    void setData(@NonNull an0 an0Var);
}
