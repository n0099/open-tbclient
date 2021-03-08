package com.baidu.tieba.frs.c;

import android.app.Activity;
import android.util.LruCache;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static d jKA;
    private LruCache<String, String> jKy = new LruCache<>(10);
    private l<String> jKz = com.baidu.tbadk.core.c.a.bqt().Az("tb.recently_vistited_forum_animation");

    public static d cKE() {
        if (jKA == null) {
            synchronized (d.class) {
                if (jKA == null) {
                    jKA = new d();
                }
            }
        }
        return jKA;
    }

    private d() {
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.frs.c.d.1
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity != null && activity.getClass().getName().equals("FrsActivity")) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : d.this.jKy.snapshot().entrySet()) {
                        sb.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append(",");
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                        d.this.jKz.asyncSetForever("transition_cache_key", sb.toString());
                    }
                }
            }
        });
        this.jKz.a("transition_cache_key", new l.a<String>() { // from class: com.baidu.tieba.frs.c.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.cache.l.a
            /* renamed from: fd */
            public void onItemGet(String str, String str2) {
                if (str2 != null && !str2.isEmpty()) {
                    for (String str3 : str2.split(",")) {
                        String[] split = str3.split("=");
                        if (split != null && split.length == 2) {
                            d.this.jKy.put(split[0], split[1]);
                        }
                    }
                }
            }
        });
    }

    public void a(String str, e eVar) {
        this.jKy.put(str, eVar.toString());
    }

    public e Lp(String str) {
        return str == null ? new e(null) : new e(this.jKy.get(str));
    }
}
