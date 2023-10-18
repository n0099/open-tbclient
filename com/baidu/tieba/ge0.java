package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes6.dex */
public interface ge0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final ge0 b = new fe0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable he0 he0Var);

    void b(String str, String str2, je0 je0Var);

    String[] c();

    boolean d(Context context, String str);
}
