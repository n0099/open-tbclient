package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e aXv;
    private c aXx;
    private HashMap<String, c> aXw = new HashMap<>();
    private List<c> aXy = new ArrayList();

    private e() {
    }

    public static e KP() {
        if (aXv == null) {
            synchronized (e.class) {
                if (aXv == null) {
                    aXv = new e();
                }
            }
        }
        return aXv;
    }

    public synchronized void n(c cVar) {
        j.av(TAG, "addPlayingCacheFile " + cVar);
        c cVar2 = this.aXw.get(cVar.getVideoUrl());
        if (cVar2 != null) {
            j.av(TAG, "got pre same CacheFile ****************************************************************");
            cVar2.close();
        }
        this.aXw.put(cVar.getVideoUrl(), cVar);
    }

    public synchronized void o(c cVar) {
        if (cVar != null) {
            j.av(TAG, "removePlayingCacheFile: " + cVar);
            cVar.close();
            this.aXw.remove(cVar.getVideoUrl());
        }
    }

    public synchronized boolean p(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, c>> it = this.aXw.entrySet().iterator();
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

    public synchronized boolean hf(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = this.aXw.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(m.hq(next.getKey()))) {
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
        this.aXx = cVar;
    }

    public c KQ() {
        return this.aXx;
    }

    public synchronized void r(c cVar) {
        this.aXy.add(cVar);
    }

    public synchronized void s(c cVar) {
        this.aXy.remove(cVar);
    }

    public synchronized void hg(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.aXy) {
                    if (cVar != null && str.equals(cVar.getVideoUrl())) {
                        cVar.close();
                        arrayList.add(cVar);
                    }
                }
                this.aXy.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean t(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<c> it = this.aXy.iterator();
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

    public synchronized boolean hh(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<c> it = this.aXy.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && str.equals(m.hq(next.getVideoUrl()))) {
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
        r3.aXw.remove(r4);
        com.baidu.tieba.VideoCache.j.av(com.baidu.tieba.VideoCache.e.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void hi(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.aXw.entrySet().iterator();
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
