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
    private static f dcS = null;
    private int dcT = 0;
    private List<Long> dcU = new ArrayList();
    private final CustomMessageListener dbR = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.dbR);
    }

    public static f atM() {
        if (dcS == null) {
            synchronized (f.class) {
                if (dcS == null) {
                    dcS = new f();
                }
            }
        }
        return dcS;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dcT = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.dcU.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.dcT = 0;
        this.dcU.clear();
    }

    public int getGid() {
        return this.dcT;
    }

    public Long atN() {
        return com.baidu.tieba.im.memorycache.b.asO().asY().get(this.dcT);
    }

    public synchronized List<Long> atO() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.dcU) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.bM(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void atP() {
        this.dcU.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.dcU.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(int i, long j) {
        if (this.dcT != 0 && this.dcT != i) {
            this.dcU.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.dcT);
        }
        this.dcT = i;
        Iterator<Long> it = this.dcU.iterator();
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

    public synchronized boolean atQ() {
        boolean z;
        if (this.dcT > 0) {
            z = this.dcU.size() > 0;
        }
        return z;
    }

    public synchronized boolean bI(long j) {
        boolean z;
        Iterator<Long> it = this.dcU.iterator();
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

    public synchronized String atR() {
        String str;
        str = "";
        for (Long l : this.dcU) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
