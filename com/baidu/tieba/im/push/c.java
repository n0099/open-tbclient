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
    private static c ePA = null;
    private long eAc = 0;
    private List<Long> ePB = new ArrayList();
    private final CustomMessageListener eOC = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.eOC);
    }

    public static c aSu() {
        if (ePA == null) {
            synchronized (c.class) {
                if (ePA == null) {
                    ePA = new c();
                }
            }
        }
        return ePA;
    }

    public synchronized void bK(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.eAc = com.baidu.adp.lib.g.b.d(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.ePB.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.eAc = 0L;
        this.ePB.clear();
    }

    public long getGid() {
        return this.eAc;
    }

    public Long aSv() {
        return com.baidu.tieba.im.memorycache.b.aRy().aRJ().get(this.eAc);
    }

    public synchronized List<Long> aSw() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.ePB) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.cB(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aSx() {
        this.ePB.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.ePB.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void l(long j, long j2) {
        if (this.eAc != 0 && this.eAc != j) {
            this.ePB.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.eAc);
        }
        this.eAc = j;
        Iterator<Long> it = this.ePB.iterator();
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

    public synchronized boolean aSy() {
        boolean z;
        if (this.eAc > 0) {
            z = this.ePB.size() > 0;
        }
        return z;
    }

    public synchronized boolean cv(long j) {
        boolean z;
        Iterator<Long> it = this.ePB.iterator();
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

    public synchronized String aSz() {
        String str;
        str = "";
        for (Long l : this.ePB) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
