package com.baidu.tieba;

import android.widget.FrameLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* loaded from: classes6.dex */
public interface gx7 {
    void a();

    void b(ScrollFragmentTabHost.s sVar);

    void c();

    int d(int i);

    void e(ScrollFragmentTabHost.s sVar);

    void f(boolean z);

    int getCurrentTabType();

    FrameLayout getFrameLayout();

    void setOnTabSelectedListener(ScrollFragmentTabHost.t tVar);
}
