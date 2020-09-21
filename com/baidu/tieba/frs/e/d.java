package com.baidu.tieba.frs.e;

import android.app.Activity;
import android.util.LruCache;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static d izI;
    private LruCache<String, String> izG = new LruCache<>(10);
    private l<String> izH = com.baidu.tbadk.core.c.a.bhV().zT("tb.recently_vistited_forum_animation");

    public static d cvW() {
        if (izI == null) {
            synchronized (d.class) {
                if (izI == null) {
                    izI = new d();
                }
            }
        }
        return izI;
    }

    private d() {
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.frs.e.d.1
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity != null && activity.getClass().getName().equals("FrsActivity")) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : d.this.izG.snapshot().entrySet()) {
                        sb.append((String) entry.getKey()).append(ETAG.EQUAL).append((String) entry.getValue()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                        d.this.izH.asyncSetForever("transition_cache_key", sb.toString());
                    }
                }
            }
        });
        this.izH.a("transition_cache_key", new l.a<String>() { // from class: com.baidu.tieba.frs.e.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.cache.l.a
            /* renamed from: eL */
            public void onItemGet(String str, String str2) {
                if (str2 != null && !str2.isEmpty()) {
                    for (String str3 : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        String[] split = str3.split(ETAG.EQUAL);
                        if (split != null && split.length == 2) {
                            d.this.izG.put(split[0], split[1]);
                        }
                    }
                }
            }
        });
    }

    public void a(String str, e eVar) {
        this.izG.put(str, eVar.toString());
    }

    public e Ju(String str) {
        return str == null ? new e(null) : new e(this.izG.get(str));
    }
}
