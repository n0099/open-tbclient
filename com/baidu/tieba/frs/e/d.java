package com.baidu.tieba.frs.e;

import android.app.Activity;
import android.util.LruCache;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static d jvi;
    private LruCache<String, String> jvg = new LruCache<>(10);
    private l<String> jvh = com.baidu.tbadk.core.c.a.brq().Bo("tb.recently_vistited_forum_animation");

    public static d cJT() {
        if (jvi == null) {
            synchronized (d.class) {
                if (jvi == null) {
                    jvi = new d();
                }
            }
        }
        return jvi;
    }

    private d() {
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.frs.e.d.1
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity != null && activity.getClass().getName().equals("FrsActivity")) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : d.this.jvg.snapshot().entrySet()) {
                        sb.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append(",");
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                        d.this.jvh.asyncSetForever("transition_cache_key", sb.toString());
                    }
                }
            }
        });
        this.jvh.a("transition_cache_key", new l.a<String>() { // from class: com.baidu.tieba.frs.e.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.cache.l.a
            /* renamed from: fd */
            public void onItemGet(String str, String str2) {
                if (str2 != null && !str2.isEmpty()) {
                    for (String str3 : str2.split(",")) {
                        String[] split = str3.split("=");
                        if (split != null && split.length == 2) {
                            d.this.jvg.put(split[0], split[1]);
                        }
                    }
                }
            }
        });
    }

    public void a(String str, e eVar) {
        this.jvg.put(str, eVar.toString());
    }

    public e LF(String str) {
        return str == null ? new e(null) : new e(this.jvg.get(str));
    }
}
