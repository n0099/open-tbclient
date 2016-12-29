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
    private static f cVH = null;
    private int cVI = 0;
    private List<Long> cVJ = new ArrayList();
    private final CustomMessageListener cUH = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.cUH);
    }

    public static f asG() {
        if (cVH == null) {
            synchronized (f.class) {
                if (cVH == null) {
                    cVH = new f();
                }
            }
        }
        return cVH;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.cVI = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.cVJ.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.cVI = 0;
        this.cVJ.clear();
    }

    public int getGid() {
        return this.cVI;
    }

    public Long asH() {
        return com.baidu.tieba.im.memorycache.b.arI().arS().get(this.cVI);
    }

    public synchronized List<Long> asI() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.cVJ) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.bR(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void asJ() {
        this.cVJ.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.cVJ.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(int i, long j) {
        if (this.cVI != 0 && this.cVI != i) {
            this.cVJ.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.cVI);
        }
        this.cVI = i;
        Iterator<Long> it = this.cVJ.iterator();
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

    public synchronized boolean asK() {
        boolean z;
        if (this.cVI > 0) {
            z = this.cVJ.size() > 0;
        }
        return z;
    }

    public synchronized boolean bN(long j) {
        boolean z;
        Iterator<Long> it = this.cVJ.iterator();
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

    public synchronized String asL() {
        String str;
        str = "";
        for (Long l : this.cVJ) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
