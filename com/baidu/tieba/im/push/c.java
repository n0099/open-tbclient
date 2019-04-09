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
    private static c grh = null;
    private long gbE = 0;
    private List<Long> gri = new ArrayList();
    private final CustomMessageListener gqj = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.gqj);
    }

    public static c bvy() {
        if (grh == null) {
            synchronized (c.class) {
                if (grh == null) {
                    grh = new c();
                }
            }
        }
        return grh;
    }

    public synchronized void cY(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.gbE = com.baidu.adp.lib.g.b.d(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.gri.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.gbE = 0L;
        this.gri.clear();
    }

    public long getGid() {
        return this.gbE;
    }

    public Long bvz() {
        return com.baidu.tieba.im.memorycache.b.buC().buN().get(this.gbE);
    }

    public synchronized List<Long> bvA() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.gri) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.dn(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void bvB() {
        this.gri.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.gri.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void q(long j, long j2) {
        if (this.gbE != 0 && this.gbE != j) {
            this.gri.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gbE);
        }
        this.gbE = j;
        Iterator<Long> it = this.gri.iterator();
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

    public synchronized boolean bvC() {
        boolean z;
        if (this.gbE > 0) {
            z = this.gri.size() > 0;
        }
        return z;
    }

    public synchronized boolean dh(long j) {
        boolean z;
        Iterator<Long> it = this.gri.iterator();
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

    public synchronized String bvD() {
        String str;
        str = "";
        for (Long l : this.gri) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
