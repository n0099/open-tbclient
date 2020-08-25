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
/* loaded from: classes2.dex */
public class c {
    private static c jxK = null;
    private long jfV = 0;
    private List<Long> jxL = new ArrayList();
    private final CustomMessageListener jwK = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.jwK);
    }

    public static c cHJ() {
        if (jxK == null) {
            synchronized (c.class) {
                if (jxK == null) {
                    jxK = new c();
                }
            }
        }
        return jxK;
    }

    public synchronized void cS(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.jfV = com.baidu.adp.lib.f.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.jxL.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.jfV = 0L;
        this.jxL.clear();
    }

    public long getGid() {
        return this.jfV;
    }

    public Long cHK() {
        return com.baidu.tieba.im.memorycache.b.cGM().cGX().get(this.jfV);
    }

    public synchronized List<Long> cHL() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.jxL) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.fr(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void cHM() {
        this.jxL.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.jxL.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void D(long j, long j2) {
        if (this.jfV != 0 && this.jfV != j) {
            this.jxL.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jfV);
        }
        this.jfV = j;
        Iterator<Long> it = this.jxL.iterator();
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

    public synchronized boolean cHN() {
        boolean z;
        if (this.jfV > 0) {
            z = this.jxL.size() > 0;
        }
        return z;
    }

    public synchronized boolean fm(long j) {
        boolean z;
        Iterator<Long> it = this.jxL.iterator();
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

    public synchronized String cHO() {
        String str;
        str = "";
        for (Long l : this.jxL) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
