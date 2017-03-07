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
    private static f dfl = null;
    private int dfm = 0;
    private List<Long> dfn = new ArrayList();
    private final CustomMessageListener dek = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.dek);
    }

    public static f ath() {
        if (dfl == null) {
            synchronized (f.class) {
                if (dfl == null) {
                    dfl = new f();
                }
            }
        }
        return dfl;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dfm = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.dfn.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.dfm = 0;
        this.dfn.clear();
    }

    public int getGid() {
        return this.dfm;
    }

    public Long ati() {
        return com.baidu.tieba.im.memorycache.b.asj().ast().get(this.dfm);
    }

    public synchronized List<Long> atj() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.dfn) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.bN(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void atk() {
        this.dfn.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.dfn.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(int i, long j) {
        if (this.dfm != 0 && this.dfm != i) {
            this.dfn.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.dfm);
        }
        this.dfm = i;
        Iterator<Long> it = this.dfn.iterator();
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

    public synchronized boolean atl() {
        boolean z;
        if (this.dfm > 0) {
            z = this.dfn.size() > 0;
        }
        return z;
    }

    public synchronized boolean bJ(long j) {
        boolean z;
        Iterator<Long> it = this.dfn.iterator();
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

    public synchronized String atm() {
        String str;
        str = "";
        for (Long l : this.dfn) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
