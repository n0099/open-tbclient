package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e aWl;
    private c aWn;
    private HashMap<String, c> aWm = new HashMap<>();
    private List<c> aWo = new ArrayList();

    private e() {
    }

    public static e Ku() {
        if (aWl == null) {
            synchronized (e.class) {
                if (aWl == null) {
                    aWl = new e();
                }
            }
        }
        return aWl;
    }

    public synchronized void n(c cVar) {
        j.log(TAG, "addPlayingCacheFile " + cVar);
        c cVar2 = this.aWm.get(cVar.getVideoUrl());
        if (cVar2 != null) {
            j.log(TAG, "got pre same CacheFile ****************************************************************");
            cVar2.close();
        }
        this.aWm.put(cVar.getVideoUrl(), cVar);
    }

    public synchronized void o(c cVar) {
        if (cVar != null) {
            j.log(TAG, "removePlayingCacheFile: " + cVar);
            cVar.close();
            this.aWm.remove(cVar.getVideoUrl());
        }
    }

    public synchronized boolean p(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, c>> it = this.aWm.entrySet().iterator();
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

    public synchronized boolean hk(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = this.aWm.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(m.hv(next.getKey()))) {
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
        this.aWn = cVar;
    }

    public c Kv() {
        return this.aWn;
    }

    public synchronized void r(c cVar) {
        this.aWo.add(cVar);
    }

    public synchronized void s(c cVar) {
        this.aWo.remove(cVar);
    }

    public synchronized void hl(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.aWo) {
                    if (cVar != null && str.equals(cVar.getVideoUrl())) {
                        cVar.close();
                        arrayList.add(cVar);
                    }
                }
                this.aWo.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean t(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<c> it = this.aWo.iterator();
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

    public synchronized boolean hm(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<c> it = this.aWo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && str.equals(m.hv(next.getVideoUrl()))) {
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
        r3.aWm.remove(r4);
        com.baidu.tieba.VideoCache.j.log(com.baidu.tieba.VideoCache.e.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void hn(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.aWm.entrySet().iterator();
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
