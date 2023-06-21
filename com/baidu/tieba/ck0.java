package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes5.dex */
public interface ck0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final ck0 b = new bk0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable dk0 dk0Var);

    void b(String str, String str2, fk0 fk0Var);

    String[] c();

    boolean d(Context context, String str);
}
