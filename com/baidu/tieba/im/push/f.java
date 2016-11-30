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
    private static f dqN = null;
    private int dqO = 0;
    private List<Long> dqP = new ArrayList();
    private final CustomMessageListener dpN = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.dpN);
    }

    public static f ayh() {
        if (dqN == null) {
            synchronized (f.class) {
                if (dqN == null) {
                    dqN = new f();
                }
            }
        }
        return dqN;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dqO = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.dqP.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.dqO = 0;
        this.dqP.clear();
    }

    public int getGid() {
        return this.dqO;
    }

    public Long ayi() {
        return com.baidu.tieba.im.memorycache.b.axj().axt().get(this.dqO);
    }

    public synchronized List<Long> ayj() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.dqP) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.cd(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void ayk() {
        this.dqP.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.dqP.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(int i, long j) {
        if (this.dqO != 0 && this.dqO != i) {
            this.dqP.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.dqO);
        }
        this.dqO = i;
        Iterator<Long> it = this.dqP.iterator();
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

    public synchronized boolean ayl() {
        boolean z;
        if (this.dqO > 0) {
            z = this.dqP.size() > 0;
        }
        return z;
    }

    public synchronized boolean bZ(long j) {
        boolean z;
        Iterator<Long> it = this.dqP.iterator();
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

    public synchronized String aym() {
        String str;
        str = "";
        for (Long l : this.dqP) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
