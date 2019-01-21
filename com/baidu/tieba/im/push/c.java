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
    private static c fbn = null;
    private long eLP = 0;
    private List<Long> fbo = new ArrayList();
    private final CustomMessageListener fap = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.fap);
    }

    public static c aUW() {
        if (fbn == null) {
            synchronized (c.class) {
                if (fbn == null) {
                    fbn = new c();
                }
            }
        }
        return fbn;
    }

    public synchronized void bQ(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.eLP = com.baidu.adp.lib.g.b.d(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.fbo.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.eLP = 0L;
        this.fbo.clear();
    }

    public long getGid() {
        return this.eLP;
    }

    public Long aUX() {
        return com.baidu.tieba.im.memorycache.b.aUa().aUl().get(this.eLP);
    }

    public synchronized List<Long> aUY() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.fbo) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.cI(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aUZ() {
        this.fbo.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.fbo.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(long j, long j2) {
        if (this.eLP != 0 && this.eLP != j) {
            this.fbo.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.eLP);
        }
        this.eLP = j;
        Iterator<Long> it = this.fbo.iterator();
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

    public synchronized boolean aVa() {
        boolean z;
        if (this.eLP > 0) {
            z = this.fbo.size() > 0;
        }
        return z;
    }

    public synchronized boolean cC(long j) {
        boolean z;
        Iterator<Long> it = this.fbo.iterator();
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

    public synchronized String aVb() {
        String str;
        str = "";
        for (Long l : this.fbo) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
