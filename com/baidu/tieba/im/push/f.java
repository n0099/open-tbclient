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
    private static f cek = null;
    private int cel = 0;
    private List<Long> cem = new ArrayList();
    private final CustomMessageListener cdk = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.cdk);
    }

    public static f aev() {
        if (cek == null) {
            synchronized (f.class) {
                if (cek == null) {
                    cek = new f();
                }
            }
        }
        return cek;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.cel = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.cem.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.cel = 0;
        this.cem.clear();
    }

    public int getGid() {
        return this.cel;
    }

    public Long aew() {
        return com.baidu.tieba.im.memorycache.b.ady().adI().get(this.cel);
    }

    public synchronized List<Long> aex() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.cem) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.bf(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aey() {
        this.cem.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.cem.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(int i, long j) {
        if (this.cel != 0 && this.cel != i) {
            this.cem.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.cel);
        }
        this.cel = i;
        Iterator<Long> it = this.cem.iterator();
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

    public synchronized boolean aez() {
        boolean z;
        if (this.cel > 0) {
            z = this.cem.size() > 0;
        }
        return z;
    }

    public synchronized boolean bb(long j) {
        boolean z;
        Iterator<Long> it = this.cem.iterator();
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

    public synchronized String aeA() {
        String str;
        str = "";
        for (Long l : this.cem) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
