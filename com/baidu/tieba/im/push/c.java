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
    private static c eAE = null;
    private long ekW = 0;
    private List<Long> eAF = new ArrayList();
    private final CustomMessageListener ezG = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.ezG);
    }

    public static c aMU() {
        if (eAE == null) {
            synchronized (c.class) {
                if (eAE == null) {
                    eAE = new c();
                }
            }
        }
        return eAE;
    }

    public synchronized void bq(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.ekW = com.baidu.adp.lib.g.b.c(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.eAF.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.ekW = 0L;
        this.eAF.clear();
    }

    public long getGid() {
        return this.ekW;
    }

    public Long aMV() {
        return com.baidu.tieba.im.memorycache.b.aLY().aMj().get(this.ekW);
    }

    public synchronized List<Long> aMW() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.eAF) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.cq(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aMX() {
        this.eAF.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.eAF.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(long j, long j2) {
        if (this.ekW != 0 && this.ekW != j) {
            this.eAF.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ekW);
        }
        this.ekW = j;
        Iterator<Long> it = this.eAF.iterator();
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

    public synchronized boolean aMY() {
        boolean z;
        if (this.ekW > 0) {
            z = this.eAF.size() > 0;
        }
        return z;
    }

    public synchronized boolean ck(long j) {
        boolean z;
        Iterator<Long> it = this.eAF.iterator();
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

    public synchronized String aMZ() {
        String str;
        str = "";
        for (Long l : this.eAF) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
