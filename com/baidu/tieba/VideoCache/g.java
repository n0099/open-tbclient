package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static final String TAG = g.class.getSimpleName();
    private static g aOe;
    private d aOg;
    private HashMap<String, d> aOf = new HashMap<>();
    private List<d> aOh = new ArrayList();

    private g() {
    }

    public static g Kk() {
        if (aOe == null) {
            synchronized (g.class) {
                if (aOe == null) {
                    aOe = new g();
                }
            }
        }
        return aOe;
    }

    public synchronized void n(d dVar) {
        m.log(TAG, "addPlayingCacheFile " + dVar);
        d dVar2 = this.aOf.get(dVar.getVideoUrl());
        if (dVar2 != null) {
            m.log(TAG, "got pre same CacheFile ****************************************************************");
            dVar2.close();
        }
        this.aOf.put(dVar.getVideoUrl(), dVar);
    }

    public synchronized void o(d dVar) {
        if (dVar != null) {
            m.log(TAG, "removePlayingCacheFile: " + dVar);
            dVar.close();
            this.aOf.remove(dVar.getVideoUrl());
        }
    }

    public synchronized boolean p(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, d>> it = this.aOf.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, d> next = it.next();
                    if (next != null && (next.getKey() instanceof String)) {
                        if (dVar.getVideoUrl().equals(next.getKey())) {
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

    public synchronized boolean gT(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, d>> it = this.aOf.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, d> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(q.he(next.getKey()))) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public void q(d dVar) {
        this.aOg = dVar;
    }

    public d Kl() {
        return this.aOg;
    }

    public synchronized void r(d dVar) {
        this.aOh.add(dVar);
    }

    public synchronized void s(d dVar) {
        this.aOh.remove(dVar);
    }

    public synchronized void gU(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (d dVar : this.aOh) {
                    if (dVar != null && str.equals(dVar.getVideoUrl())) {
                        dVar.close();
                        arrayList.add(dVar);
                    }
                }
                this.aOh.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean t(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.getVideoUrl() != null) {
                Iterator<d> it = this.aOh.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    d next = it.next();
                    if (next != null && dVar.getVideoUrl().equals(next.getVideoUrl())) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean gV(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<d> it = this.aOh.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    d next = it.next();
                    if (next != null && str.equals(q.he(next.getVideoUrl()))) {
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
        r3.aOf.remove(r4);
        com.baidu.tieba.VideoCache.m.log(com.baidu.tieba.VideoCache.g.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void gW(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, d>> it = this.aOf.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, d> next = it.next();
                if (next != null && (next.getValue() instanceof d)) {
                    d value = next.getValue();
                    if (str.equals(value.getVideoUrl())) {
                        break;
                    }
                }
            }
        }
    }
}
