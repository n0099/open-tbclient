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
    private static c eXI = null;
    private long eIl = 0;
    private List<Long> eXJ = new ArrayList();
    private final CustomMessageListener eWK = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.eWK);
    }

    public static c aTI() {
        if (eXI == null) {
            synchronized (c.class) {
                if (eXI == null) {
                    eXI = new c();
                }
            }
        }
        return eXI;
    }

    public synchronized void bP(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.eIl = com.baidu.adp.lib.g.b.d(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.eXJ.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.eIl = 0L;
        this.eXJ.clear();
    }

    public long getGid() {
        return this.eIl;
    }

    public Long aTJ() {
        return com.baidu.tieba.im.memorycache.b.aSM().aSX().get(this.eIl);
    }

    public synchronized List<Long> aTK() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.eXJ) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.cD(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aTL() {
        this.eXJ.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.eXJ.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(long j, long j2) {
        if (this.eIl != 0 && this.eIl != j) {
            this.eXJ.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.eIl);
        }
        this.eIl = j;
        Iterator<Long> it = this.eXJ.iterator();
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

    public synchronized boolean aTM() {
        boolean z;
        if (this.eIl > 0) {
            z = this.eXJ.size() > 0;
        }
        return z;
    }

    public synchronized boolean cx(long j) {
        boolean z;
        Iterator<Long> it = this.eXJ.iterator();
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

    public synchronized String aTN() {
        String str;
        str = "";
        for (Long l : this.eXJ) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
