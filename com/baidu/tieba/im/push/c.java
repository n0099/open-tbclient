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
    private static c faz = null;
    private long eLc = 0;
    private List<Long> faA = new ArrayList();
    private final CustomMessageListener eZB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.eZB);
    }

    public static c aUw() {
        if (faz == null) {
            synchronized (c.class) {
                if (faz == null) {
                    faz = new c();
                }
            }
        }
        return faz;
    }

    public synchronized void bP(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.eLc = com.baidu.adp.lib.g.b.d(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.faA.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.eLc = 0L;
        this.faA.clear();
    }

    public long getGid() {
        return this.eLc;
    }

    public Long aUx() {
        return com.baidu.tieba.im.memorycache.b.aTA().aTL().get(this.eLc);
    }

    public synchronized List<Long> aUy() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.faA) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.cI(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aUz() {
        this.faA.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.faA.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(long j, long j2) {
        if (this.eLc != 0 && this.eLc != j) {
            this.faA.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.eLc);
        }
        this.eLc = j;
        Iterator<Long> it = this.faA.iterator();
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

    public synchronized boolean aUA() {
        boolean z;
        if (this.eLc > 0) {
            z = this.faA.size() > 0;
        }
        return z;
    }

    public synchronized boolean cC(long j) {
        boolean z;
        Iterator<Long> it = this.faA.iterator();
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

    public synchronized String aUB() {
        String str;
        str = "";
        for (Long l : this.faA) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
