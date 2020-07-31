package com.baidu.tieba.im.push;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c jiJ = null;
    private long iQW = 0;
    private List<Long> jiK = new ArrayList();
    private final CustomMessageListener jhI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.jhI);
    }

    public static c cwS() {
        if (jiJ == null) {
            synchronized (c.class) {
                if (jiJ == null) {
                    jiJ = new c();
                }
            }
        }
        return jiJ;
    }

    public synchronized void cy(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.iQW = com.baidu.adp.lib.f.b.toLong(str, 0L);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.jiK.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.iQW = 0L;
        this.jiK.clear();
    }

    public long getGid() {
        return this.iQW;
    }

    public Long cwT() {
        return com.baidu.tieba.im.memorycache.b.cvV().cwg().get(this.iQW);
    }

    public synchronized List<Long> cwU() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.jiK) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.ff(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void cwV() {
        this.jiK.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9.jiK.add(java.lang.Long.valueOf(r12));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void D(long j, long j2) {
        if (this.iQW != 0 && this.iQW != j) {
            this.jiK.clear();
            i.a("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.iQW);
        }
        this.iQW = j;
        Iterator<Long> it = this.jiK.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Long next = it.next();
            if (next != null && next.longValue() == j2) {
                break;
            }
        }
    }

    public synchronized boolean cwW() {
        boolean z;
        if (this.iQW > 0) {
            z = this.jiK.size() > 0;
        }
        return z;
    }

    public synchronized boolean fa(long j) {
        boolean z;
        Iterator<Long> it = this.jiK.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Long next = it.next();
            if (next != null && next.longValue() == j) {
                z = true;
                break;
            }
        }
        return z;
    }

    public synchronized String cwX() {
        String str;
        str = "";
        for (Long l : this.jiK) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
