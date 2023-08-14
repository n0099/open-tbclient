package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public interface gv7 {
    lm<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    View b(@NonNull Context context, @NonNull BdUniqueId bdUniqueId);

    lm<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    lm<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    void e(@NonNull View view2);

    void f(@NonNull View view2, @Nullable pba pbaVar, @NonNull BdUniqueId bdUniqueId, String str, String str2, String str3, String str4, int i, View.OnClickListener onClickListener);

    lm<?, ?> g(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, String str);
}
