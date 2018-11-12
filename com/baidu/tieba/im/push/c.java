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
    private static c eQT = null;
    private long eBw = 0;
    private List<Long> eQU = new ArrayList();
    private final CustomMessageListener ePV = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.ePV);
    }

    public static c aRR() {
        if (eQT == null) {
            synchronized (c.class) {
                if (eQT == null) {
                    eQT = new c();
                }
            }
        }
        return eQT;
    }

    public synchronized void bK(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.eBw = com.baidu.adp.lib.g.b.d(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.eQU.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.eBw = 0L;
        this.eQU.clear();
    }

    public long getGid() {
        return this.eBw;
    }

    public Long aRS() {
        return com.baidu.tieba.im.memorycache.b.aQV().aRg().get(this.eBw);
    }

    public synchronized List<Long> aRT() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.eQU) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.cw(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aRU() {
        this.eQU.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.eQU.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(long j, long j2) {
        if (this.eBw != 0 && this.eBw != j) {
            this.eQU.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.eBw);
        }
        this.eBw = j;
        Iterator<Long> it = this.eQU.iterator();
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

    public synchronized boolean aRV() {
        boolean z;
        if (this.eBw > 0) {
            z = this.eQU.size() > 0;
        }
        return z;
    }

    public synchronized boolean cq(long j) {
        boolean z;
        Iterator<Long> it = this.eQU.iterator();
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

    public synchronized String aRW() {
        String str;
        str = "";
        for (Long l : this.eQU) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
