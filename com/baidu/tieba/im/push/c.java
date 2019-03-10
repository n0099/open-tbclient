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
    private static c gru = null;
    private long gbR = 0;
    private List<Long> grv = new ArrayList();
    private final CustomMessageListener gqw = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.gqw);
    }

    public static c bvC() {
        if (gru == null) {
            synchronized (c.class) {
                if (gru == null) {
                    gru = new c();
                }
            }
        }
        return gru;
    }

    public synchronized void cX(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.gbR = com.baidu.adp.lib.g.b.d(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.grv.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.gbR = 0L;
        this.grv.clear();
    }

    public long getGid() {
        return this.gbR;
    }

    public Long bvD() {
        return com.baidu.tieba.im.memorycache.b.buG().buR().get(this.gbR);
    }

    public synchronized List<Long> bvE() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.grv) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.dn(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void bvF() {
        this.grv.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.grv.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void q(long j, long j2) {
        if (this.gbR != 0 && this.gbR != j) {
            this.grv.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gbR);
        }
        this.gbR = j;
        Iterator<Long> it = this.grv.iterator();
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

    public synchronized boolean bvG() {
        boolean z;
        if (this.gbR > 0) {
            z = this.grv.size() > 0;
        }
        return z;
    }

    public synchronized boolean dh(long j) {
        boolean z;
        Iterator<Long> it = this.grv.iterator();
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

    public synchronized String bvH() {
        String str;
        str = "";
        for (Long l : this.grv) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
