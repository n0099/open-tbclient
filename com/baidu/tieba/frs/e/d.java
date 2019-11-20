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
    private static d fRc;
    private LruCache<String, String> aBb = new LruCache<>(10);
    private l<String> fRb = com.baidu.tbadk.core.d.a.akL().nl("tb.recently_vistited_forum_animation");

    public static d bpU() {
        if (fRc == null) {
            synchronized (d.class) {
                if (fRc == null) {
                    fRc = new d();
                }
            }
        }
        return fRc;
    }

    private d() {
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.frs.e.d.1
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity != null && activity.getClass().getName().equals("FrsActivity")) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : d.this.aBb.snapshot().entrySet()) {
                        sb.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                        d.this.fRb.asyncSetForever("transition_cache_key", sb.toString());
                    }
                }
            }
        });
        this.fRb.a("transition_cache_key", new l.a<String>() { // from class: com.baidu.tieba.frs.e.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.cache.l.a
            /* renamed from: cP */
            public void onItemGet(String str, String str2) {
                if (str2 != null && !str2.isEmpty()) {
                    for (String str3 : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        String[] split = str3.split("=");
                        if (split != null && split.length == 2) {
                            d.this.aBb.put(split[0], split[1]);
                        }
                    }
                }
            }
        });
    }

    public void a(String str, e eVar) {
        this.aBb.put(str, eVar.toString());
    }

    public e ww(String str) {
        return str == null ? new e(null) : new e(this.aBb.get(str));
    }
}
