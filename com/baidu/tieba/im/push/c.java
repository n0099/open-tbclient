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
    private static c kKQ = null;
    private long kAA = 0;
    private List<Long> kKR = new ArrayList();
    private final CustomMessageListener kJI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.kJI);
    }

    public static c cXs() {
        if (kKQ == null) {
            synchronized (c.class) {
                if (kKQ == null) {
                    kKQ = new c();
                }
            }
        }
        return kKQ;
    }

    public synchronized void dc(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.kAA = com.baidu.adp.lib.f.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.kKR.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.kAA = 0L;
        this.kKR.clear();
    }

    public long getGid() {
        return this.kAA;
    }

    public Long cXt() {
        return com.baidu.tieba.im.memorycache.b.cWE().cWP().get(this.kAA);
    }

    public synchronized List<Long> cXu() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.kKR) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.b.he(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void cXv() {
        this.kKR.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.kKR.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void I(long j, long j2) {
        if (this.kAA != 0 && this.kAA != j) {
            this.kKR.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.kAA);
        }
        this.kAA = j;
        Iterator<Long> it = this.kKR.iterator();
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

    public synchronized boolean cXw() {
        boolean z;
        if (this.kAA > 0) {
            z = this.kKR.size() > 0;
        }
        return z;
    }

    public synchronized boolean gZ(long j) {
        boolean z;
        Iterator<Long> it = this.kKR.iterator();
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

    public synchronized String cXx() {
        String str;
        str = "";
        for (Long l : this.kKR) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + ",";
        }
        return str;
    }
}
