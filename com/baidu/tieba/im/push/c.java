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
    private static c gOD = null;
    private long gyY = 0;
    private List<Long> gOE = new ArrayList();
    private final CustomMessageListener gND = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.gND);
    }

    public static c bDD() {
        if (gOD == null) {
            synchronized (c.class) {
                if (gOD == null) {
                    gOD = new c();
                }
            }
        }
        return gOD;
    }

    public synchronized void cZ(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.gyY = com.baidu.adp.lib.g.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.gOE.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.gyY = 0L;
        this.gOE.clear();
    }

    public long getGid() {
        return this.gyY;
    }

    public Long bDE() {
        return com.baidu.tieba.im.memorycache.b.bCK().bCV().get(this.gyY);
    }

    public synchronized List<Long> bDF() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.gOE) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.ds(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void bDG() {
        this.gOE.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.gOE.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void w(long j, long j2) {
        if (this.gyY != 0 && this.gyY != j) {
            this.gOE.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gyY);
        }
        this.gyY = j;
        Iterator<Long> it = this.gOE.iterator();
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

    public synchronized boolean bDH() {
        boolean z;
        if (this.gyY > 0) {
            z = this.gOE.size() > 0;
        }
        return z;
    }

    public synchronized boolean dn(long j) {
        boolean z;
        Iterator<Long> it = this.gOE.iterator();
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

    public synchronized String bDI() {
        String str;
        str = "";
        for (Long l : this.gOE) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
