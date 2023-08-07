package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes6.dex */
public interface gj0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final gj0 b = new fj0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable hj0 hj0Var);

    void b(String str, String str2, jj0 jj0Var);

    String[] c();

    boolean d(Context context, String str);
}
