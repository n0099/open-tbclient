package com.baidu.tieba.im.messageCenter;

import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static r f1806a = null;
    private int b = 0;

    public static r a() {
        if (f1806a == null) {
            synchronized (r.class) {
                if (f1806a == null) {
                    f1806a = new r();
                }
            }
        }
        return f1806a;
    }

    public synchronized void a(Map<String, String> map) {
        if (map != null) {
            try {
                this.b = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.a(e.getMessage());
                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(0, 0, "on connected", "SequenceManager: setSequenceId", "Seq-Id = " + map.get("Seq-Id"), 0, null));
                if (this.b == 0) {
                    this.b = new Random().nextInt();
                }
            }
        }
    }

    public synchronized int b() {
        int i;
        if (this.b == 0) {
            this.b++;
        }
        i = this.b;
        this.b = i + 1;
        return i;
    }
}
