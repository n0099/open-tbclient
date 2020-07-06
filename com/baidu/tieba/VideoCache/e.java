package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e eWr;
    private c eWt;
    private HashMap<String, c> eWs = new HashMap<>();
    private List<c> eWu = new ArrayList();

    private e() {
    }

    public static e bob() {
        if (eWr == null) {
            synchronized (e.class) {
                if (eWr == null) {
                    eWr = new e();
                }
            }
        }
        return eWr;
    }

    public synchronized void s(c cVar) {
        j.D(TAG, "addPlayingCacheFile " + cVar);
        c cVar2 = this.eWs.get(cVar.getVideoUrl());
        if (cVar2 != null) {
            j.D(TAG, "got pre same CacheFile ****************************************************************");
            cVar2.close();
        }
        this.eWs.put(cVar.getVideoUrl(), cVar);
    }

    public synchronized void t(c cVar) {
        if (cVar != null) {
            if (cVar == this.eWs.get(cVar.getVideoUrl())) {
                cVar.close();
                this.eWs.remove(cVar.getVideoUrl());
            }
        }
    }

    public synchronized boolean u(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, c>> it = this.eWs.entrySet().iterator();
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

    public synchronized boolean zH(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = this.eWs.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(m.zS(next.getKey()))) {
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
        this.eWt = cVar;
    }

    public c boc() {
        return this.eWt;
    }

    public synchronized void w(c cVar) {
        this.eWu.add(cVar);
    }

    public synchronized void x(c cVar) {
        this.eWu.remove(cVar);
    }

    public synchronized void zI(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.eWu) {
                    if (cVar != null && str.equals(cVar.getVideoUrl())) {
                        cVar.close();
                        arrayList.add(cVar);
                    }
                }
                this.eWu.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean y(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<c> it = this.eWu.iterator();
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

    public synchronized boolean zJ(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<c> it = this.eWu.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && str.equals(m.zS(next.getVideoUrl()))) {
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
        r3.eWs.remove(r4);
        com.baidu.tieba.VideoCache.j.D(com.baidu.tieba.VideoCache.e.TAG, "CacheFile close: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void zK(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.eWs.entrySet().iterator();
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
        r0.cV(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void v(String str, long j) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.eWs.entrySet().iterator();
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
