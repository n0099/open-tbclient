package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e aVU;
    private c aVW;
    private HashMap<String, c> aVV = new HashMap<>();
    private List<c> aVX = new ArrayList();

    private e() {
    }

    public static e KD() {
        if (aVU == null) {
            synchronized (e.class) {
                if (aVU == null) {
                    aVU = new e();
                }
            }
        }
        return aVU;
    }

    public synchronized void n(c cVar) {
        j.aw(TAG, "addPlayingCacheFile " + cVar);
        c cVar2 = this.aVV.get(cVar.getVideoUrl());
        if (cVar2 != null) {
            j.aw(TAG, "got pre same CacheFile ****************************************************************");
            cVar2.close();
        }
        this.aVV.put(cVar.getVideoUrl(), cVar);
    }

    public synchronized void o(c cVar) {
        if (cVar != null) {
            j.aw(TAG, "removePlayingCacheFile: " + cVar);
            cVar.close();
            this.aVV.remove(cVar.getVideoUrl());
        }
    }

    public synchronized boolean p(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, c>> it = this.aVV.entrySet().iterator();
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

    public synchronized boolean hj(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = this.aVV.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(m.hu(next.getKey()))) {
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
        this.aVW = cVar;
    }

    public c KE() {
        return this.aVW;
    }

    public synchronized void r(c cVar) {
        this.aVX.add(cVar);
    }

    public synchronized void s(c cVar) {
        this.aVX.remove(cVar);
    }

    public synchronized void hk(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.aVX) {
                    if (cVar != null && str.equals(cVar.getVideoUrl())) {
                        cVar.close();
                        arrayList.add(cVar);
                    }
                }
                this.aVX.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean t(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<c> it = this.aVX.iterator();
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

    public synchronized boolean hl(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<c> it = this.aVX.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && str.equals(m.hu(next.getVideoUrl()))) {
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
        r3.aVV.remove(r4);
        com.baidu.tieba.VideoCache.j.aw(com.baidu.tieba.VideoCache.e.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void hm(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.aVV.entrySet().iterator();
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
