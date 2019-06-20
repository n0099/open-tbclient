package com.baidu.tieba.aiapps.apps.s;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.media.a.b.c;
import com.baidu.swan.apps.u.b.h;
import java.io.File;
import rx.d;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes4.dex */
public class a implements h {
    @Override // com.baidu.swan.apps.u.b.h
    public void a(Context context, Bundle bundle, final c.a aVar) {
        final Bundle bundle2 = new Bundle();
        bundle2.putBoolean("success", true);
        final String string = bundle.getString("path");
        final String string2 = bundle.getString("outputPath");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            aVar.a(false, null);
        } else {
            d.bl("").b(Schedulers.io()).d(new f<String, Object>() { // from class: com.baidu.tieba.aiapps.apps.s.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: sT */
                public Object call(String str) {
                    com.baidu.swan.c.a.f(new File(string), new File(string2));
                    return null;
                }
            }).a(rx.a.b.a.cLq()).c(new rx.functions.b<Object>() { // from class: com.baidu.tieba.aiapps.apps.s.a.1
                @Override // rx.functions.b
                public void call(Object obj) {
                    bundle2.putString("path", string2);
                    aVar.a(true, bundle2);
                }
            });
        }
    }
}
