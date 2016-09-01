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
    private static f djG = null;
    private int djH = 0;
    private List<Long> djI = new ArrayList();
    private final CustomMessageListener diG = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.diG);
    }

    public static f avL() {
        if (djG == null) {
            synchronized (f.class) {
                if (djG == null) {
                    djG = new f();
                }
            }
        }
        return djG;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.djH = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.djI.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.djH = 0;
        this.djI.clear();
    }

    public int getGid() {
        return this.djH;
    }

    public Long avM() {
        return com.baidu.tieba.im.memorycache.b.auN().auX().get(this.djH);
    }

    public synchronized List<Long> avN() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.djI) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.ce(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void avO() {
        this.djI.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.djI.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(int i, long j) {
        if (this.djH != 0 && this.djH != i) {
            this.djI.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.djH);
        }
        this.djH = i;
        Iterator<Long> it = this.djI.iterator();
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

    public synchronized boolean avP() {
        boolean z;
        if (this.djH > 0) {
            z = this.djI.size() > 0;
        }
        return z;
    }

    public synchronized boolean ca(long j) {
        boolean z;
        Iterator<Long> it = this.djI.iterator();
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

    public synchronized String avQ() {
        String str;
        str = "";
        for (Long l : this.djI) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
