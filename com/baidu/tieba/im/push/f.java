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
    private static f dld = null;
    private int dle = 0;
    private List<Long> dlf = new ArrayList();
    private final CustomMessageListener dkd = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.dkd);
    }

    public static f awk() {
        if (dld == null) {
            synchronized (f.class) {
                if (dld == null) {
                    dld = new f();
                }
            }
        }
        return dld;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dle = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.dlf.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.dle = 0;
        this.dlf.clear();
    }

    public int getGid() {
        return this.dle;
    }

    public Long awl() {
        return com.baidu.tieba.im.memorycache.b.avm().avw().get(this.dle);
    }

    public synchronized List<Long> awm() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.dlf) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.ce(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void awn() {
        this.dlf.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.dlf.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(int i, long j) {
        if (this.dle != 0 && this.dle != i) {
            this.dlf.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.dle);
        }
        this.dle = i;
        Iterator<Long> it = this.dlf.iterator();
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

    public synchronized boolean awo() {
        boolean z;
        if (this.dle > 0) {
            z = this.dlf.size() > 0;
        }
        return z;
    }

    public synchronized boolean ca(long j) {
        boolean z;
        Iterator<Long> it = this.dlf.iterator();
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

    public synchronized String awp() {
        String str;
        str = "";
        for (Long l : this.dlf) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
