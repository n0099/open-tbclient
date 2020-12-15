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
    private static c kBU = null;
    private long kks = 0;
    private List<Long> kBV = new ArrayList();
    private final CustomMessageListener kAU = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.kAU);
    }

    public static c cZz() {
        if (kBU == null) {
            synchronized (c.class) {
                if (kBU == null) {
                    kBU = new c();
                }
            }
        }
        return kBU;
    }

    public synchronized void dk(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.kks = com.baidu.adp.lib.f.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.kBV.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.kks = 0L;
        this.kBV.clear();
    }

    public long getGid() {
        return this.kks;
    }

    public Long cZA() {
        return com.baidu.tieba.im.memorycache.b.cYD().cYO().get(this.kks);
    }

    public synchronized List<Long> cZB() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.kBV) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.hc(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void cZC() {
        this.kBV.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.kBV.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void B(long j, long j2) {
        if (this.kks != 0 && this.kks != j) {
            this.kBV.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.kks);
        }
        this.kks = j;
        Iterator<Long> it = this.kBV.iterator();
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

    public synchronized boolean cZD() {
        boolean z;
        if (this.kks > 0) {
            z = this.kBV.size() > 0;
        }
        return z;
    }

    public synchronized boolean gX(long j) {
        boolean z;
        Iterator<Long> it = this.kBV.iterator();
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

    public synchronized String cZE() {
        String str;
        str = "";
        for (Long l : this.kBV) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
