package com.baidu.tieba.frs.e;

import android.app.Activity;
import android.util.LruCache;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes2.dex */
public class d {
    private static d ism;
    private LruCache<String, String> isk = new LruCache<>(10);
    private l<String> isl = com.baidu.tbadk.core.c.a.bhb().zx("tb.recently_vistited_forum_animation");

    public static d csG() {
        if (ism == null) {
            synchronized (d.class) {
                if (ism == null) {
                    ism = new d();
                }
            }
        }
        return ism;
    }

    private d() {
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.frs.e.d.1
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity != null && activity.getClass().getName().equals("FrsActivity")) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : d.this.isk.snapshot().entrySet()) {
                        sb.append((String) entry.getKey()).append(ETAG.EQUAL).append((String) entry.getValue()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                        d.this.isl.asyncSetForever("transition_cache_key", sb.toString());
                    }
                }
            }
        });
        this.isl.a("transition_cache_key", new l.a<String>() { // from class: com.baidu.tieba.frs.e.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.cache.l.a
            /* renamed from: eG */
            public void onItemGet(String str, String str2) {
                if (str2 != null && !str2.isEmpty()) {
                    for (String str3 : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        String[] split = str3.split(ETAG.EQUAL);
                        if (split != null && split.length == 2) {
                            d.this.isk.put(split[0], split[1]);
                        }
                    }
                }
            }
        });
    }

    public void a(String str, e eVar) {
        this.isk.put(str, eVar.toString());
    }

    public e IV(String str) {
        return str == null ? new e(null) : new e(this.isk.get(str));
    }
}
