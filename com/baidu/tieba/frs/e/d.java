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
    private static d gKP;
    private LruCache<String, String> gKN = new LruCache<>(10);
    private l<String> gKO = com.baidu.tbadk.core.c.a.aEB().sQ("tb.recently_vistited_forum_animation");

    public static d bJW() {
        if (gKP == null) {
            synchronized (d.class) {
                if (gKP == null) {
                    gKP = new d();
                }
            }
        }
        return gKP;
    }

    private d() {
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.e() { // from class: com.baidu.tieba.frs.e.d.1
            @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity != null && activity.getClass().getName().equals("FrsActivity")) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : d.this.gKN.snapshot().entrySet()) {
                        sb.append((String) entry.getKey()).append(ETAG.EQUAL).append((String) entry.getValue()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                        d.this.gKO.asyncSetForever("transition_cache_key", sb.toString());
                    }
                }
            }
        });
        this.gKO.a("transition_cache_key", new l.a<String>() { // from class: com.baidu.tieba.frs.e.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.cache.l.a
            /* renamed from: dt */
            public void onItemGet(String str, String str2) {
                if (str2 != null && !str2.isEmpty()) {
                    for (String str3 : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        String[] split = str3.split(ETAG.EQUAL);
                        if (split != null && split.length == 2) {
                            d.this.gKN.put(split[0], split[1]);
                        }
                    }
                }
            }
        });
    }

    public void a(String str, e eVar) {
        this.gKN.put(str, eVar.toString());
    }

    public e BM(String str) {
        return str == null ? new e(null) : new e(this.gKN.get(str));
    }
}
