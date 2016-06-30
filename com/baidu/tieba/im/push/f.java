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
    private static f cVc = null;
    private int cVd = 0;
    private List<Long> cVe = new ArrayList();
    private final CustomMessageListener cUb = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.cUb);
    }

    public static f aql() {
        if (cVc == null) {
            synchronized (f.class) {
                if (cVc == null) {
                    cVc = new f();
                }
            }
        }
        return cVc;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.cVd = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.cVe.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.cVd = 0;
        this.cVe.clear();
    }

    public int getGid() {
        return this.cVd;
    }

    public Long aqm() {
        return com.baidu.tieba.im.memorycache.b.apn().apx().get(this.cVd);
    }

    public synchronized List<Long> aqn() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.cVe) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.bN(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aqo() {
        this.cVe.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.cVe.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(int i, long j) {
        if (this.cVd != 0 && this.cVd != i) {
            this.cVe.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.cVd);
        }
        this.cVd = i;
        Iterator<Long> it = this.cVe.iterator();
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

    public synchronized boolean aqp() {
        boolean z;
        if (this.cVd > 0) {
            z = this.cVe.size() > 0;
        }
        return z;
    }

    public synchronized boolean bJ(long j) {
        boolean z;
        Iterator<Long> it = this.cVe.iterator();
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

    public synchronized String aqq() {
        String str;
        str = "";
        for (Long l : this.cVe) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
