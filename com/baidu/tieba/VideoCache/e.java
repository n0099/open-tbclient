package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e bzE;
    private c bzG;
    private HashMap<String, c> bzF = new HashMap<>();
    private List<c> bzH = new ArrayList();

    private e() {
    }

    public static e Vj() {
        if (bzE == null) {
            synchronized (e.class) {
                if (bzE == null) {
                    bzE = new e();
                }
            }
        }
        return bzE;
    }

    public synchronized void s(c cVar) {
        j.log(TAG, "addPlayingCacheFile " + cVar);
        c cVar2 = this.bzF.get(cVar.getVideoUrl());
        if (cVar2 != null) {
            j.log(TAG, "got pre same CacheFile ****************************************************************");
            cVar2.close();
        }
        this.bzF.put(cVar.getVideoUrl(), cVar);
    }

    public synchronized void t(c cVar) {
        if (cVar != null) {
            if (cVar == this.bzF.get(cVar.getVideoUrl())) {
                cVar.close();
                this.bzF.remove(cVar.getVideoUrl());
            }
        }
    }

    public synchronized boolean u(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, c>> it = this.bzF.entrySet().iterator();
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

    public synchronized boolean jn(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = this.bzF.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(m.jy(next.getKey()))) {
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
        this.bzG = cVar;
    }

    public c Vk() {
        return this.bzG;
    }

    public synchronized void w(c cVar) {
        this.bzH.add(cVar);
    }

    public synchronized void x(c cVar) {
        this.bzH.remove(cVar);
    }

    public synchronized void jo(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.bzH) {
                    if (cVar != null && str.equals(cVar.getVideoUrl())) {
                        cVar.close();
                        arrayList.add(cVar);
                    }
                }
                this.bzH.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean y(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<c> it = this.bzH.iterator();
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

    public synchronized boolean jp(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<c> it = this.bzH.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && str.equals(m.jy(next.getVideoUrl()))) {
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
        r3.bzF.remove(r4);
        com.baidu.tieba.VideoCache.j.log(com.baidu.tieba.VideoCache.e.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void jq(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.bzF.entrySet().iterator();
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
        r0.aP(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void l(String str, long j) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.bzF.entrySet().iterator();
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
