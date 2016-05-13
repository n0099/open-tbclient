package com.baidu.tieba.im.push;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static f cpM = null;
    private int cpN = 0;
    private List<Long> cpO = new ArrayList();
    private final CustomMessageListener coM = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.coM);
    }

    public static f ahX() {
        if (cpM == null) {
            synchronized (f.class) {
                if (cpM == null) {
                    cpM = new f();
                }
            }
        }
        return cpM;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.cpN = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.cpO.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.cpN = 0;
        this.cpO.clear();
    }

    public int getGid() {
        return this.cpN;
    }

    public Long ahY() {
        return com.baidu.tieba.im.memorycache.b.aha().ahk().get(this.cpN);
    }

    public synchronized List<Long> ahZ() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.cpO) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.bl(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aia() {
        this.cpO.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.cpO.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(int i, long j) {
        if (this.cpN != 0 && this.cpN != i) {
            this.cpO.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.cpN);
        }
        this.cpN = i;
        Iterator<Long> it = this.cpO.iterator();
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

    public synchronized boolean aib() {
        boolean z;
        if (this.cpN > 0) {
            z = this.cpO.size() > 0;
        }
        return z;
    }

    public synchronized boolean bh(long j) {
        boolean z;
        Iterator<Long> it = this.cpO.iterator();
        while (true) {
            if (it.hasNext()) {
                Long next = it.next();
                if (next != null && next.longValue() == j) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        return z;
    }

    public synchronized String aic() {
        String str;
        str = "";
        for (Long l : this.cpO) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
