package com.baidu.tieba.im.push;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c dSq = null;
    private int dSr = 0;
    private List<Long> dSs = new ArrayList();
    private final CustomMessageListener dRs = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.dRs);
    }

    public static c aCB() {
        if (dSq == null) {
            synchronized (c.class) {
                if (dSq == null) {
                    dSq = new c();
                }
            }
        }
        return dSq;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dSr = Integer.parseInt(str);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.dSs.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.dSr = 0;
        this.dSs.clear();
    }

    public int getGid() {
        return this.dSr;
    }

    public Long aCC() {
        return com.baidu.tieba.im.memorycache.b.aBG().aBQ().get(this.dSr);
    }

    public synchronized List<Long> aCD() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.dSs) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.bY(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aCE() {
        this.dSs.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        r8.dSs.add(java.lang.Long.valueOf(r10));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(int i, long j) {
        if (this.dSr != 0 && this.dSr != i) {
            this.dSs.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.dSr);
        }
        this.dSr = i;
        Iterator<Long> it = this.dSs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Long next = it.next();
            if (next != null && next.longValue() == j) {
                break;
            }
        }
    }

    public synchronized boolean aCF() {
        boolean z;
        if (this.dSr > 0) {
            z = this.dSs.size() > 0;
        }
        return z;
    }

    public synchronized boolean bU(long j) {
        boolean z;
        Iterator<Long> it = this.dSs.iterator();
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

    public synchronized String aCG() {
        String str;
        str = "";
        for (Long l : this.dSs) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
