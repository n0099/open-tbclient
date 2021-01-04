package com.baidu.tieba.im.push;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c kHq = null;
    private long kwY = 0;
    private List<Long> kHr = new ArrayList();
    private final CustomMessageListener kGi = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.kGi);
    }

    public static c cZl() {
        if (kHq == null) {
            synchronized (c.class) {
                if (kHq == null) {
                    kHq = new c();
                }
            }
        }
        return kHq;
    }

    public synchronized void dj(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.kwY = com.baidu.adp.lib.f.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.kHr.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.kwY = 0L;
        this.kHr.clear();
    }

    public long getGid() {
        return this.kwY;
    }

    public Long cZm() {
        return com.baidu.tieba.im.memorycache.b.cYx().cYI().get(this.kwY);
    }

    public synchronized List<Long> cZn() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.kHr) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.b.gZ(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void cZo() {
        this.kHr.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.kHr.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void E(long j, long j2) {
        if (this.kwY != 0 && this.kwY != j) {
            this.kHr.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.kwY);
        }
        this.kwY = j;
        Iterator<Long> it = this.kHr.iterator();
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

    public synchronized boolean cZp() {
        boolean z;
        if (this.kwY > 0) {
            z = this.kHr.size() > 0;
        }
        return z;
    }

    public synchronized boolean gU(long j) {
        boolean z;
        Iterator<Long> it = this.kHr.iterator();
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

    public synchronized String cZq() {
        String str;
        str = "";
        for (Long l : this.kHr) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
