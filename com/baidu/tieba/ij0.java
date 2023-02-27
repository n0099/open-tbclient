package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes4.dex */
public interface ij0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final ij0 b = new hj0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable jj0 jj0Var);

    void b(String str, String str2, lj0 lj0Var);

    String[] c();

    boolean d(Context context, String str);
}
