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
    private static c gPu = null;
    private long gzP = 0;
    private List<Long> gPv = new ArrayList();
    private final CustomMessageListener gOu = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.gOu);
    }

    public static c bDF() {
        if (gPu == null) {
            synchronized (c.class) {
                if (gPu == null) {
                    gPu = new c();
                }
            }
        }
        return gPu;
    }

    public synchronized void cZ(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.gzP = com.baidu.adp.lib.g.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.gPv.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.gzP = 0L;
        this.gPv.clear();
    }

    public long getGid() {
        return this.gzP;
    }

    public Long bDG() {
        return com.baidu.tieba.im.memorycache.b.bCM().bCX().get(this.gzP);
    }

    public synchronized List<Long> bDH() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.gPv) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.dt(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void bDI() {
        this.gPv.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.gPv.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void w(long j, long j2) {
        if (this.gzP != 0 && this.gzP != j) {
            this.gPv.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gzP);
        }
        this.gzP = j;
        Iterator<Long> it = this.gPv.iterator();
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

    public synchronized boolean bDJ() {
        boolean z;
        if (this.gzP > 0) {
            z = this.gPv.size() > 0;
        }
        return z;
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized boolean m26do(long j) {
        boolean z;
        Iterator<Long> it = this.gPv.iterator();
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

    public synchronized String bDK() {
        String str;
        str = "";
        for (Long l : this.gPv) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
