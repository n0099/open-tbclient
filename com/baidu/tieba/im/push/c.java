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
    private static c kBS = null;
    private long kkq = 0;
    private List<Long> kBT = new ArrayList();
    private final CustomMessageListener kAS = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.kAS);
    }

    public static c cZy() {
        if (kBS == null) {
            synchronized (c.class) {
                if (kBS == null) {
                    kBS = new c();
                }
            }
        }
        return kBS;
    }

    public synchronized void dk(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.kkq = com.baidu.adp.lib.f.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.kBT.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.kkq = 0L;
        this.kBT.clear();
    }

    public long getGid() {
        return this.kkq;
    }

    public Long cZz() {
        return com.baidu.tieba.im.memorycache.b.cYC().cYN().get(this.kkq);
    }

    public synchronized List<Long> cZA() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.kBT) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.hc(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void cZB() {
        this.kBT.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.kBT.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void B(long j, long j2) {
        if (this.kkq != 0 && this.kkq != j) {
            this.kBT.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.kkq);
        }
        this.kkq = j;
        Iterator<Long> it = this.kBT.iterator();
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

    public synchronized boolean cZC() {
        boolean z;
        if (this.kkq > 0) {
            z = this.kBT.size() > 0;
        }
        return z;
    }

    public synchronized boolean gX(long j) {
        boolean z;
        Iterator<Long> it = this.kBT.iterator();
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

    public synchronized String cZD() {
        String str;
        str = "";
        for (Long l : this.kBT) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
