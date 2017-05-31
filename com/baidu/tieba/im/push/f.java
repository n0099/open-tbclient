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
    private static f dfx = null;
    private int dfy = 0;
    private List<Long> dfz = new ArrayList();
    private final CustomMessageListener dez = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.dez);
    }

    public static f arU() {
        if (dfx == null) {
            synchronized (f.class) {
                if (dfx == null) {
                    dfx = new f();
                }
            }
        }
        return dfx;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dfy = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.dfz.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.dfy = 0;
        this.dfz.clear();
    }

    public int getGid() {
        return this.dfy;
    }

    public Long arV() {
        return com.baidu.tieba.im.memorycache.b.aqX().arh().get(this.dfy);
    }

    public synchronized List<Long> arW() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.dfz) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.bB(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void arX() {
        this.dfz.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.dfz.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(int i, long j) {
        if (this.dfy != 0 && this.dfy != i) {
            this.dfz.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.dfy);
        }
        this.dfy = i;
        Iterator<Long> it = this.dfz.iterator();
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

    public synchronized boolean arY() {
        boolean z;
        if (this.dfy > 0) {
            z = this.dfz.size() > 0;
        }
        return z;
    }

    public synchronized boolean bx(long j) {
        boolean z;
        Iterator<Long> it = this.dfz.iterator();
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

    public synchronized String arZ() {
        String str;
        str = "";
        for (Long l : this.dfz) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
