package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes3.dex */
public interface ao1 {

    /* loaded from: classes3.dex */
    public interface a {
        void onResult(String str);
    }

    void a(HashMap hashMap, File file, a aVar, String str);

    void b(Context context, String str, String str2, String str3);

    void c(HashMap hashMap, File file, a aVar);

    void d(Bitmap bitmap, HashMap hashMap, File[] fileArr, a aVar);
}
