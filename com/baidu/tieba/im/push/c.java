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
    private static c gOH = null;
    private long gzi = 0;
    private List<Long> gOI = new ArrayList();
    private final CustomMessageListener gNJ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.gNJ);
    }

    public static c bFS() {
        if (gOH == null) {
            synchronized (c.class) {
                if (gOH == null) {
                    gOH = new c();
                }
            }
        }
        return gOH;
    }

    public synchronized void dm(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.gzi = com.baidu.adp.lib.g.b.c(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.gOI.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.gzi = 0L;
        this.gOI.clear();
    }

    public long getGid() {
        return this.gzi;
    }

    public Long bFT() {
        return com.baidu.tieba.im.memorycache.b.bEZ().bFk().get(this.gzi);
    }

    public synchronized List<Long> bFU() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.gOI) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.dU(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void bFV() {
        this.gOI.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.gOI.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void q(long j, long j2) {
        if (this.gzi != 0 && this.gzi != j) {
            this.gOI.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gzi);
        }
        this.gzi = j;
        Iterator<Long> it = this.gOI.iterator();
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

    public synchronized boolean bFW() {
        boolean z;
        if (this.gzi > 0) {
            z = this.gOI.size() > 0;
        }
        return z;
    }

    public synchronized boolean dO(long j) {
        boolean z;
        Iterator<Long> it = this.gOI.iterator();
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

    public synchronized String bFX() {
        String str;
        str = "";
        for (Long l : this.gOI) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
