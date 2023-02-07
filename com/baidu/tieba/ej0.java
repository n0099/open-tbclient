package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes4.dex */
public interface ej0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final ej0 b = new dj0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable fj0 fj0Var);

    void b(String str, String str2, hj0 hj0Var);

    String[] c();

    boolean d(Context context, String str);
}
