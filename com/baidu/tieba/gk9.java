package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes4.dex */
public interface gk9 {
    void a(boolean z);

    void b(int i);

    void c();

    boolean d();

    void e();

    boolean f();

    int g();

    @NonNull
    BaseFragmentActivity getActivity();

    int getAdSource();

    @NonNull
    ViewGroup getRootView();

    BdUniqueId getUniqueId();

    boolean h();

    long i();
}
