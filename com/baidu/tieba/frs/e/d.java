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
    private static d ieg;
    private LruCache<String, String> iee = new LruCache<>(10);
    private l<String> ief = com.baidu.tbadk.core.c.a.aYG().xj("tb.recently_vistited_forum_animation");

    public static d cic() {
        if (ieg == null) {
            synchronized (d.class) {
                if (ieg == null) {
                    ieg = new d();
                }
            }
        }
        return ieg;
    }

    private d() {
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.frs.e.d.1
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity != null && activity.getClass().getName().equals("FrsActivity")) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : d.this.iee.snapshot().entrySet()) {
                        sb.append((String) entry.getKey()).append(ETAG.EQUAL).append((String) entry.getValue()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                        d.this.ief.asyncSetForever("transition_cache_key", sb.toString());
                    }
                }
            }
        });
        this.ief.a("transition_cache_key", new l.a<String>() { // from class: com.baidu.tieba.frs.e.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.cache.l.a
            /* renamed from: ep */
            public void onItemGet(String str, String str2) {
                if (str2 != null && !str2.isEmpty()) {
                    for (String str3 : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        String[] split = str3.split(ETAG.EQUAL);
                        if (split != null && split.length == 2) {
                            d.this.iee.put(split[0], split[1]);
                        }
                    }
                }
            }
        });
    }

    public void a(String str, e eVar) {
        this.iee.put(str, eVar.toString());
    }

    public e Gt(String str) {
        return str == null ? new e(null) : new e(this.iee.get(str));
    }
}
