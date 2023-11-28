package com.baidu.tieba;

import androidx.annotation.FloatRange;
import androidx.fragment.app.FragmentActivity;
import com.baidu.tieba.gm7;
import java.util.List;
/* loaded from: classes6.dex */
public interface hm7<T extends gm7> {
    void a(@FloatRange(from = 0.0d, to = 1.0d) float f, float f2);

    void b(FragmentActivity fragmentActivity);

    void c(boolean z);

    void d(List<? extends fm7<T>> list);

    void e(T t);

    void f();

    void g();
}
