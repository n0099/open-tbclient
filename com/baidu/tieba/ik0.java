package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes6.dex */
public interface ik0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final ik0 b = new hk0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable jk0 jk0Var);

    void b(String str, String str2, lk0 lk0Var);

    String[] c();

    boolean d(Context context, String str);
}
