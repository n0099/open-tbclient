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
    private static f ddH = null;
    private int ddI = 0;
    private List<Long> ddJ = new ArrayList();
    private final CustomMessageListener dcG = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    private f() {
        MessageManager.getInstance().registerListener(this.dcG);
    }

    public static f ata() {
        if (ddH == null) {
            synchronized (f.class) {
                if (ddH == null) {
                    ddH = new f();
                }
            }
        }
        return ddH;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.ddI = Integer.parseInt(str);
                try {
                    String[] split = str2.split(",");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.ddJ.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.ddI = 0;
        this.ddJ.clear();
    }

    public int getGid() {
        return this.ddI;
    }

    public Long atb() {
        return com.baidu.tieba.im.memorycache.b.asc().asm().get(this.ddI);
    }

    public synchronized List<Long> atc() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.ddJ) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.g.bN(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void atd() {
        this.ddJ.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        r7.ddJ.add(java.lang.Long.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(int i, long j) {
        if (this.ddI != 0 && this.ddI != i) {
            this.ddJ.clear();
            k.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + "-" + this.ddI);
        }
        this.ddI = i;
        Iterator<Long> it = this.ddJ.iterator();
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

    public synchronized boolean ate() {
        boolean z;
        if (this.ddI > 0) {
            z = this.ddJ.size() > 0;
        }
        return z;
    }

    public synchronized boolean bJ(long j) {
        boolean z;
        Iterator<Long> it = this.ddJ.iterator();
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

    public synchronized String atf() {
        String str;
        str = "";
        for (Long l : this.ddJ) {
            if (l != null && l.longValue() != 0) {
                str = String.valueOf(String.valueOf(str) + l.longValue()) + ",";
            }
        }
        return str;
    }
}
