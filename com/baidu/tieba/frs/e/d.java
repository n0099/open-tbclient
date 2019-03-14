package com.baidu.tieba.frs.e;

import android.app.Activity;
import android.util.LruCache;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.q;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static d fus;
    private LruCache<String, String> agL = new LruCache<>(10);
    private l<String> fur = com.baidu.tbadk.core.c.a.aaW().lv("tb.recently_vistited_forum_animation");

    public static d biy() {
        if (fus == null) {
            synchronized (d.class) {
                if (fus == null) {
                    fus = new d();
                }
            }
        }
        return fus;
    }

    private d() {
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.frs.e.d.1
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity != null && activity.getClass().getName().equals("FrsActivity")) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : d.this.agL.snapshot().entrySet()) {
                        sb.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                        d.this.fur.f("transition_cache_key", sb.toString());
                    }
                }
            }
        });
        this.fur.a("transition_cache_key", new l.a<String>() { // from class: com.baidu.tieba.frs.e.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.cache.l.a
            /* renamed from: cN */
            public void g(String str, String str2) {
                if (str2 != null && !str2.isEmpty()) {
                    for (String str3 : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        String[] split = str3.split("=");
                        if (split != null && split.length == 2) {
                            d.this.agL.put(split[0], split[1]);
                        }
                    }
                }
            }
        });
    }

    public void a(String str, e eVar) {
        this.agL.put(str, eVar.toString());
    }

    public e vJ(String str) {
        return str == null ? new e(null) : new e(this.agL.get(str));
    }
}
