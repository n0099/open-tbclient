package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e bjq;
    private c bjs;
    private HashMap<String, c> bjr = new HashMap<>();
    private List<c> bjt = new ArrayList();

    private e() {
    }

    public static e PA() {
        if (bjq == null) {
            synchronized (e.class) {
                if (bjq == null) {
                    bjq = new e();
                }
            }
        }
        return bjq;
    }

    public synchronized void s(c cVar) {
        j.aB(TAG, "addPlayingCacheFile " + cVar);
        c cVar2 = this.bjr.get(cVar.getVideoUrl());
        if (cVar2 != null) {
            j.aB(TAG, "got pre same CacheFile ****************************************************************");
            cVar2.close();
        }
        this.bjr.put(cVar.getVideoUrl(), cVar);
    }

    public synchronized void t(c cVar) {
        if (cVar != null) {
            if (cVar == this.bjr.get(cVar.getVideoUrl())) {
                cVar.close();
                this.bjr.remove(cVar.getVideoUrl());
            }
        }
    }

    public synchronized boolean u(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<Map.Entry<String, c>> it = this.bjr.entrySet().iterator();
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

    public synchronized boolean ib(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<Map.Entry<String, c>> it = this.bjr.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (next != null && (next.getKey() instanceof String) && str.equals(m.in(next.getKey()))) {
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
        this.bjs = cVar;
    }

    public c PB() {
        return this.bjs;
    }

    public synchronized void w(c cVar) {
        this.bjt.add(cVar);
    }

    public synchronized void x(c cVar) {
        this.bjt.remove(cVar);
    }

    public synchronized void ic(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.bjt) {
                    if (cVar != null && str.equals(cVar.getVideoUrl())) {
                        cVar.close();
                        arrayList.add(cVar);
                    }
                }
                this.bjt.removeAll(arrayList);
            }
        }
    }

    public synchronized boolean y(c cVar) {
        boolean z;
        if (cVar != null) {
            if (cVar.getVideoUrl() != null) {
                Iterator<c> it = this.bjt.iterator();
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

    public synchronized boolean ie(String str) {
        boolean z;
        if (str != null) {
            if (!str.isEmpty()) {
                Iterator<c> it = this.bjt.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    c next = it.next();
                    if (next != null && str.equals(m.in(next.getVideoUrl()))) {
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
        r3.bjr.remove(r4);
        com.baidu.tieba.VideoCache.j.aB(com.baidu.tieba.VideoCache.e.TAG, "CacheFile close: " + r4);
     */
    /* renamed from: if  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m15if(String str) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.bjr.entrySet().iterator();
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
        r0.ax(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(String str, long j) {
        if (str != null) {
            Iterator<Map.Entry<String, c>> it = this.bjr.entrySet().iterator();
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
