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
    private static c kow = null;
    private long jWK = 0;
    private List<Long> kox = new ArrayList();
    private final CustomMessageListener knw = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.knw);
    }

    public static c cUm() {
        if (kow == null) {
            synchronized (c.class) {
                if (kow == null) {
                    kow = new c();
                }
            }
        }
        return kow;
    }

    public synchronized void dd(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.jWK = com.baidu.adp.lib.f.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.kox.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.jWK = 0L;
        this.kox.clear();
    }

    public long getGid() {
        return this.jWK;
    }

    public Long cUn() {
        return com.baidu.tieba.im.memorycache.b.cTq().cTB().get(this.jWK);
    }

    public synchronized List<Long> cUo() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.kox) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.gx(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void cUp() {
        this.kox.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.kox.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void C(long j, long j2) {
        if (this.jWK != 0 && this.jWK != j) {
            this.kox.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jWK);
        }
        this.jWK = j;
        Iterator<Long> it = this.kox.iterator();
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

    public synchronized boolean cUq() {
        boolean z;
        if (this.jWK > 0) {
            z = this.kox.size() > 0;
        }
        return z;
    }

    public synchronized boolean gs(long j) {
        boolean z;
        Iterator<Long> it = this.kox.iterator();
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

    public synchronized String cUr() {
        String str;
        str = "";
        for (Long l : this.kox) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
