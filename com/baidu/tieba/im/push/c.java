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
    private static c jVp = null;
    private long jDE = 0;
    private List<Long> jVq = new ArrayList();
    private final CustomMessageListener jUp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.jUp);
    }

    public static c cOY() {
        if (jVp == null) {
            synchronized (c.class) {
                if (jVp == null) {
                    jVp = new c();
                }
            }
        }
        return jVp;
    }

    public synchronized void cX(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.jDE = com.baidu.adp.lib.f.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.jVq.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.jDE = 0L;
        this.jVq.clear();
    }

    public long getGid() {
        return this.jDE;
    }

    public Long cOZ() {
        return com.baidu.tieba.im.memorycache.b.cOc().cOn().get(this.jDE);
    }

    public synchronized List<Long> cPa() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.jVq) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.fX(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void cPb() {
        this.jVq.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.jVq.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void A(long j, long j2) {
        if (this.jDE != 0 && this.jDE != j) {
            this.jVq.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jDE);
        }
        this.jDE = j;
        Iterator<Long> it = this.jVq.iterator();
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

    public synchronized boolean cPc() {
        boolean z;
        if (this.jDE > 0) {
            z = this.jVq.size() > 0;
        }
        return z;
    }

    public synchronized boolean fS(long j) {
        boolean z;
        Iterator<Long> it = this.jVq.iterator();
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

    public synchronized String cPd() {
        String str;
        str = "";
        for (Long l : this.jVq) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
