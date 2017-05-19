package com.baidu.tieba.im.push;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static f cZY = null;
    private int cZZ = 0;
    private List<Long> daa = new ArrayList();
    private final CustomMessageListener cYY = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.cYY);
    }

    public static f aqV() {
        if (cZY == null) {
            synchronized (f.class) {
                if (cZY == null) {
                    cZY = new f();
                }
            }
        }
        return cZY;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.cZZ = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.daa.add(Long.valueOf(Long.parseLong(split[i])));
                            }
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public synchronized void clear() {
        this.cZZ = 0;
        this.daa.clear();
    }

    public int getGid() {
        return this.cZZ;
    }

    public Long aqW() {
        return com.baidu.tieba.im.memorycache.b.apX().aqh().get(this.cZZ);
    }

    public synchronized List<Long> aqX() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.daa) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.by(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aqY() {
        this.daa.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.daa.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(int i, long j) {
        if (this.cZZ != 0 && this.cZZ != i) {
            this.daa.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.cZZ);
        }
        this.cZZ = i;
        Iterator<Long> it = this.daa.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Long next = it.next();
            if (next != null && next.longValue() == j) {
                break;
            }
        }
    }

    public synchronized boolean aqZ() {
        boolean z;
        if (this.cZZ > 0) {
            z = this.daa.size() > 0;
        }
        return z;
    }

    public synchronized boolean bu(long j) {
        boolean z;
        Iterator<Long> it = this.daa.iterator();
        while (true) {
            if (it.hasNext()) {
                Long next = it.next();
                if (next != null && next.longValue() == j) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        return z;
    }

    public synchronized String ara() {
        String str;
        str = "";
        for (Long l : this.daa) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
