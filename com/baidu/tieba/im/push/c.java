package com.baidu.tieba.im.push;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c ewL = null;
    private long ehg = 0;
    private List<Long> ewM = new ArrayList();
    private final CustomMessageListener evN = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.evN);
    }

    public static c aLU() {
        if (ewL == null) {
            synchronized (c.class) {
                if (ewL == null) {
                    ewL = new c();
                }
            }
        }
        return ewL;
    }

    public synchronized void bs(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.ehg = com.baidu.adp.lib.g.b.c(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.ewM.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.ehg = 0L;
        this.ewM.clear();
    }

    public long getGid() {
        return this.ehg;
    }

    public Long aLV() {
        return com.baidu.tieba.im.memorycache.b.aKX().aLi().get(this.ehg);
    }

    public synchronized List<Long> aLW() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.ewM) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.cl(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aLX() {
        this.ewM.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.ewM.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(long j, long j2) {
        if (this.ehg != 0 && this.ehg != j) {
            this.ewM.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ehg);
        }
        this.ehg = j;
        Iterator<Long> it = this.ewM.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Long next = it.next();
            if (next != null && next.longValue() == j2) {
                break;
            }
        }
    }

    public synchronized boolean aLY() {
        boolean z;
        if (this.ehg > 0) {
            z = this.ewM.size() > 0;
        }
        return z;
    }

    public synchronized boolean cf(long j) {
        boolean z;
        Iterator<Long> it = this.ewM.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Long next = it.next();
            if (next != null && next.longValue() == j) {
                z = true;
                break;
            }
        }
        return z;
    }

    public synchronized String aLZ() {
        String str;
        str = "";
        for (Long l : this.ewM) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
