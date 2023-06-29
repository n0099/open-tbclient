package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes5.dex */
public interface fk0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final fk0 b = new ek0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable gk0 gk0Var);

    void b(String str, String str2, ik0 ik0Var);

    String[] c();

    boolean d(Context context, String str);
}
