package com.baidu.tieba.im.push;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static f dns = null;
    private int dnt = 0;
    private List<Long> dnu = new ArrayList();
    private final CustomMessageListener dmu = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.dmu);
    }

    public static f avF() {
        if (dns == null) {
            synchronized (f.class) {
                if (dns == null) {
                    dns = new f();
                }
            }
        }
        return dns;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dnt = Integer.parseInt(str);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.dnu.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.dnt = 0;
        this.dnu.clear();
    }

    public int getGid() {
        return this.dnt;
    }

    public Long avG() {
        return com.baidu.tieba.im.memorycache.b.auI().auS().get(this.dnt);
    }

    public synchronized List<Long> avH() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.dnu) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.bP(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void avI() {
        this.dnu.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.dnu.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(int i, long j) {
        if (this.dnt != 0 && this.dnt != i) {
            this.dnu.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.dnt);
        }
        this.dnt = i;
        Iterator<Long> it = this.dnu.iterator();
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

    public synchronized boolean avJ() {
        boolean z;
        if (this.dnt > 0) {
            z = this.dnu.size() > 0;
        }
        return z;
    }

    public synchronized boolean bL(long j) {
        boolean z;
        Iterator<Long> it = this.dnu.iterator();
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

    public synchronized String avK() {
        String str;
        str = "";
        for (Long l : this.dnu) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
        }
        return str;
    }
}
