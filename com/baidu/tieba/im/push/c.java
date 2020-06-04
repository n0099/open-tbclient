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
    private static c iJm = null;
    private long itL = 0;
    private List<Long> iJn = new ArrayList();
    private final CustomMessageListener iIm = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.iIm);
    }

    public static c cpa() {
        if (iJm == null) {
            synchronized (c.class) {
                if (iJm == null) {
                    iJm = new c();
                }
            }
        }
        return iJm;
    }

    public synchronized void ct(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.itL = com.baidu.adp.lib.f.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.iJn.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.itL = 0L;
        this.iJn.clear();
    }

    public long getGid() {
        return this.itL;
    }

    public Long cpb() {
        return com.baidu.tieba.im.memorycache.b.coh().cos().get(this.itL);
    }

    public synchronized List<Long> cpc() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.iJn) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.eO(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void cpd() {
        this.iJn.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.iJn.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void D(long j, long j2) {
        if (this.itL != 0 && this.itL != j) {
            this.iJn.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.itL);
        }
        this.itL = j;
        Iterator<Long> it = this.iJn.iterator();
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

    public synchronized boolean cpe() {
        boolean z;
        if (this.itL > 0) {
            z = this.iJn.size() > 0;
        }
        return z;
    }

    public synchronized boolean eJ(long j) {
        boolean z;
        Iterator<Long> it = this.iJn.iterator();
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

    public synchronized String cpf() {
        String str;
        str = "";
        for (Long l : this.iJn) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
