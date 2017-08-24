package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e aWn;
    private c aWp;
    private HashMap<String, c> aWo = new HashMap<>();
    private List<c> aWq = new ArrayList();

    private e() {
    }

    public static e Ku() {
        if (aWn == null) {
            synchronized (e.class) {
                if (aWn == null) {
                    aWn = new e();
                }
            }
        }
        return aWn;
    }

    public synchronized void n(c cVar) {
        j.at(TAG, "addPlayingCacheFile " + cVar);
        c cVar2 = this.aWo.get(cVar.getVideoUrl());
        if (cVar2 != null) {
            j.at(TAG, "got pre same CacheFile ****************************************************************");
            cVar2.close();
        }
        this.aWo.put(cVar.getVideoUrl(), cVar);
    }

    public synchronized void o(c cVar) {
        if (cVar != null) {
            j.at(TAG, "removePlayingCacheFile: " + cVar);
            cVar.close();
            this.aWo.remove(cVar.getVideoUrl());
        }
    }

    public synchronized boolean p(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, c>> it = this.aWo.entrySet().iterator();
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

    public synchronized boolean hn(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = this.aWo.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(m.hy(next.getKey()))) {
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
        this.aWp = cVar;
    }

    public c Kv() {
        return this.aWp;
    }

    public synchronized void r(c cVar) {
        this.aWq.add(cVar);
    }

    public synchronized void s(c cVar) {
        this.aWq.remove(cVar);
    }

    public synchronized void ho(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.aWq) {
                    if (cVar != null && str.equals(cVar.getVideoUrl())) {
                        cVar.close();
                        arrayList.add(cVar);
                    }
                }
                this.aWq.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean t(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<c> it = this.aWq.iterator();
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

    public synchronized boolean hp(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<c> it = this.aWq.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && str.equals(m.hy(next.getVideoUrl()))) {
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
        r3.aWo.remove(r4);
        com.baidu.tieba.VideoCache.j.at(com.baidu.tieba.VideoCache.e.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void hq(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.aWo.entrySet().iterator();
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
