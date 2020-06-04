package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e eMf;
    private c eMh;
    private HashMap<String, c> eMg = new HashMap<>();
    private List<c> eMi = new ArrayList();

    private e() {
    }

    public static e blB() {
        if (eMf == null) {
            synchronized (e.class) {
                if (eMf == null) {
                    eMf = new e();
                }
            }
        }
        return eMf;
    }

    public synchronized void s(c cVar) {
        j.D(TAG, "addPlayingCacheFile " + cVar);
        c cVar2 = this.eMg.get(cVar.getVideoUrl());
        if (cVar2 != null) {
            j.D(TAG, "got pre same CacheFile ****************************************************************");
            cVar2.close();
        }
        this.eMg.put(cVar.getVideoUrl(), cVar);
    }

    public synchronized void t(c cVar) {
        if (cVar != null) {
            if (cVar == this.eMg.get(cVar.getVideoUrl())) {
                cVar.close();
                this.eMg.remove(cVar.getVideoUrl());
            }
        }
    }

    public synchronized boolean u(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, c>> it = this.eMg.entrySet().iterator();
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

    public synchronized boolean zo(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = this.eMg.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(m.zz(next.getKey()))) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public void v(c cVar) {
        this.eMh = cVar;
    }

    public c blC() {
        return this.eMh;
    }

    public synchronized void w(c cVar) {
        this.eMi.add(cVar);
    }

    public synchronized void x(c cVar) {
        this.eMi.remove(cVar);
    }

    public synchronized void zp(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.eMi) {
                    if (cVar != null && str.equals(cVar.getVideoUrl())) {
                        cVar.close();
                        arrayList.add(cVar);
                    }
                }
                this.eMi.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean y(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<c> it = this.eMi.iterator();
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

    public synchronized boolean zq(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<c> it = this.eMi.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && str.equals(m.zz(next.getVideoUrl()))) {
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
        r3.eMg.remove(r4);
        com.baidu.tieba.VideoCache.j.D(com.baidu.tieba.VideoCache.e.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void zr(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.eMg.entrySet().iterator();
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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        r0.cT(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void v(String str, long j) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.eMg.entrySet().iterator();
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
