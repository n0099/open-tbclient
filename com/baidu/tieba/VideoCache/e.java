package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e bwh;
    private c bwj;
    private HashMap<String, c> bwi = new HashMap<>();
    private List<c> bwk = new ArrayList();

    private e() {
    }

    public static e Ud() {
        if (bwh == null) {
            synchronized (e.class) {
                if (bwh == null) {
                    bwh = new e();
                }
            }
        }
        return bwh;
    }

    public synchronized void s(c cVar) {
        j.log(TAG, "addPlayingCacheFile " + cVar);
        c cVar2 = this.bwi.get(cVar.getVideoUrl());
        if (cVar2 != null) {
            j.log(TAG, "got pre same CacheFile ****************************************************************");
            cVar2.close();
        }
        this.bwi.put(cVar.getVideoUrl(), cVar);
    }

    public synchronized void t(c cVar) {
        if (cVar != null) {
            if (cVar == this.bwi.get(cVar.getVideoUrl())) {
                cVar.close();
                this.bwi.remove(cVar.getVideoUrl());
            }
        }
    }

    public synchronized boolean u(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, c>> it = this.bwi.entrySet().iterator();
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

    public synchronized boolean iV(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = this.bwi.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(m.jg(next.getKey()))) {
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
        this.bwj = cVar;
    }

    public c Ue() {
        return this.bwj;
    }

    public synchronized void w(c cVar) {
        this.bwk.add(cVar);
    }

    public synchronized void x(c cVar) {
        this.bwk.remove(cVar);
    }

    public synchronized void iW(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.bwk) {
                    if (cVar != null && str.equals(cVar.getVideoUrl())) {
                        cVar.close();
                        arrayList.add(cVar);
                    }
                }
                this.bwk.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean y(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<c> it = this.bwk.iterator();
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

    public synchronized boolean iX(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<c> it = this.bwk.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && str.equals(m.jg(next.getVideoUrl()))) {
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
        r3.bwi.remove(r4);
        com.baidu.tieba.VideoCache.j.log(com.baidu.tieba.VideoCache.e.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void iY(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.bwi.entrySet().iterator();
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
        r0.aI(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(String str, long j) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.bwi.entrySet().iterator();
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
