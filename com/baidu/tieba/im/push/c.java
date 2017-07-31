package com.baidu.tieba.im.push;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c dxn = null;
    private int dxo = 0;
    private List<Long> dxp = new ArrayList();
    private final CustomMessageListener dwp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.dwp);
    }

    public static c axt() {
        if (dxn == null) {
            synchronized (c.class) {
                if (dxn == null) {
                    dxn = new c();
                }
            }
        }
        return dxn;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dxo = Integer.parseInt(str);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.dxp.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.dxo = 0;
        this.dxp.clear();
    }

    public int getGid() {
        return this.dxo;
    }

    public Long axu() {
        return com.baidu.tieba.im.memorycache.b.awy().awI().get(this.dxo);
    }

    public synchronized List<Long> axv() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.dxp) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.bR(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void axw() {
        this.dxp.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        r8.dxp.add(java.lang.Long.valueOf(r10));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(int i, long j) {
        if (this.dxo != 0 && this.dxo != i) {
            this.dxp.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.dxo);
        }
        this.dxo = i;
        Iterator<Long> it = this.dxp.iterator();
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

    public synchronized boolean axx() {
        boolean z;
        if (this.dxo > 0) {
            z = this.dxp.size() > 0;
        }
        return z;
    }

    public synchronized boolean bN(long j) {
        boolean z;
        Iterator<Long> it = this.dxp.iterator();
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

    public synchronized String axy() {
        String str;
        str = "";
        for (Long l : this.dxp) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
