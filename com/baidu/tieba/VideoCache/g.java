package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static final String TAG = g.class.getSimpleName();
    private static g aQk;
    private d aQm;
    private HashMap<String, d> aQl = new HashMap<>();
    private List<d> aQn = new ArrayList();

    private g() {
    }

    public static g KO() {
        if (aQk == null) {
            synchronized (g.class) {
                if (aQk == null) {
                    aQk = new g();
                }
            }
        }
        return aQk;
    }

    public synchronized void n(d dVar) {
        m.log(TAG, "addPlayingCacheFile " + dVar);
        d dVar2 = this.aQl.get(dVar.getVideoUrl());
        if (dVar2 != null) {
            m.log(TAG, "got pre same CacheFile ****************************************************************");
            dVar2.close();
        }
        this.aQl.put(dVar.getVideoUrl(), dVar);
    }

    public synchronized void o(d dVar) {
        if (dVar != null) {
            m.log(TAG, "removePlayingCacheFile: " + dVar);
            dVar.close();
            this.aQl.remove(dVar.getVideoUrl());
        }
    }

    public synchronized boolean p(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, d>> it = this.aQl.entrySet().iterator();
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

    public synchronized boolean gU(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, d>> it = this.aQl.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, d> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(q.hf(next.getKey()))) {
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
        this.aQm = dVar;
    }

    public d KP() {
        return this.aQm;
    }

    public synchronized void r(d dVar) {
        this.aQn.add(dVar);
    }

    public synchronized void s(d dVar) {
        this.aQn.remove(dVar);
    }

    public synchronized void gV(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (d dVar : this.aQn) {
                    if (dVar != null && str.equals(dVar.getVideoUrl())) {
                        dVar.close();
                        arrayList.add(dVar);
                    }
                }
                this.aQn.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean t(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.getVideoUrl() != null) {
                Iterator<d> it = this.aQn.iterator();
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

    public synchronized boolean gW(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<d> it = this.aQn.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    d next = it.next();
                    if (next != null && str.equals(q.hf(next.getVideoUrl()))) {
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
        r3.aQl.remove(r4);
        com.baidu.tieba.VideoCache.m.log(com.baidu.tieba.VideoCache.g.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void gX(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, d>> it = this.aQl.entrySet().iterator();
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
