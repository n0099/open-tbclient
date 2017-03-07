package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static final String TAG = f.class.getSimpleName();
    private static f aUq;
    private c aUs;
    private HashMap<String, c> aUr = new HashMap<>();
    private List<c> aUt = new ArrayList();

    private f() {
    }

    public static f Lb() {
        if (aUq == null) {
            synchronized (f.class) {
                if (aUq == null) {
                    aUq = new f();
                }
            }
        }
        return aUq;
    }

    public synchronized void n(c cVar) {
        k.log(TAG, "addPlayingCacheFile " + cVar);
        c cVar2 = this.aUr.get(cVar.getVideoUrl());
        if (cVar2 != null) {
            k.log(TAG, "got pre same CacheFile ****************************************************************");
            cVar2.close();
        }
        this.aUr.put(cVar.getVideoUrl(), cVar);
    }

    public synchronized void o(c cVar) {
        if (cVar != null) {
            k.log(TAG, "removePlayingCacheFile: " + cVar);
            cVar.close();
            this.aUr.remove(cVar.getVideoUrl());
        }
    }

    public synchronized boolean p(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, c>> it = this.aUr.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String)) {
                        if (cVar.getVideoUrl().equals(next.getKey())) {
                            z = true;
                            break;
                        }
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean gF(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = this.aUr.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(o.gQ(next.getKey()))) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public void q(c cVar) {
        this.aUs = cVar;
    }

    public c Lc() {
        return this.aUs;
    }

    public synchronized void r(c cVar) {
        this.aUt.add(cVar);
    }

    public synchronized void s(c cVar) {
        this.aUt.remove(cVar);
    }

    public synchronized void gG(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.aUt) {
                    if (cVar != null && str.equals(cVar.getVideoUrl())) {
                        cVar.close();
                        arrayList.add(cVar);
                    }
                }
                this.aUt.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean t(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<c> it = this.aUt.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && cVar.getVideoUrl().equals(next.getVideoUrl())) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean gH(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<c> it = this.aUt.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && str.equals(o.gQ(next.getVideoUrl()))) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        r0.close();
        r3.aUr.remove(r4);
        com.baidu.tieba.VideoCache.k.log(com.baidu.tieba.VideoCache.f.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void gI(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.aUr.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, c> next = it.next();
                if (next != null && (next.getValue() instanceof c)) {
                    c value = next.getValue();
                    if (str.equals(value.getVideoUrl())) {
                        break;
                    }
                }
            }
        }
    }
}
