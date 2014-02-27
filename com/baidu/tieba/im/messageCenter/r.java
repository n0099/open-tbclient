package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.util.cb;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class r {
    private static r a = null;
    private int b = 0;

    public static r a() {
        if (a == null) {
            synchronized (r.class) {
                if (a == null) {
                    a = new r();
                }
            }
        }
        return a;
    }

    public final synchronized void a(Map<String, String> map) {
        if (map != null) {
            try {
                this.b = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(e.getMessage());
                cb.a(0, 0, "on connected", "SequenceManager: setSequenceId", "Seq-Id = " + map.get("Seq-Id"), 0, null);
                if (this.b == 0) {
                    this.b = new Random().nextInt();
                }
            }
        }
    }

    public final synchronized int b() {
        int i;
        if (this.b == 0) {
            this.b++;
        }
        i = this.b;
        this.b = i + 1;
        return i;
    }
}
