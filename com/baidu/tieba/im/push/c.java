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
    private static c khP = null;
    private long jQd = 0;
    private List<Long> khQ = new ArrayList();
    private final CustomMessageListener kgP = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.kgP);
    }

    public static c cSf() {
        if (khP == null) {
            synchronized (c.class) {
                if (khP == null) {
                    khP = new c();
                }
            }
        }
        return khP;
    }

    public synchronized void de(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.jQd = com.baidu.adp.lib.f.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.khQ.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.jQd = 0L;
        this.khQ.clear();
    }

    public long getGid() {
        return this.jQd;
    }

    public Long cSg() {
        return com.baidu.tieba.im.memorycache.b.cRj().cRu().get(this.jQd);
    }

    public synchronized List<Long> cSh() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.khQ) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.fY(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void cSi() {
        this.khQ.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.khQ.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void B(long j, long j2) {
        if (this.jQd != 0 && this.jQd != j) {
            this.khQ.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jQd);
        }
        this.jQd = j;
        Iterator<Long> it = this.khQ.iterator();
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

    public synchronized boolean cSj() {
        boolean z;
        if (this.jQd > 0) {
            z = this.khQ.size() > 0;
        }
        return z;
    }

    public synchronized boolean fT(long j) {
        boolean z;
        Iterator<Long> it = this.khQ.iterator();
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

    public synchronized String cSk() {
        String str;
        str = "";
        for (Long l : this.khQ) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
