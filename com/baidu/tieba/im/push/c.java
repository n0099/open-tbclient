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
    private static c dTv = null;
    private int dTw = 0;
    private List<Long> dTx = new ArrayList();
    private final CustomMessageListener dSx = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.dSx);
    }

    public static c aCK() {
        if (dTv == null) {
            synchronized (c.class) {
                if (dTv == null) {
                    dTv = new c();
                }
            }
        }
        return dTv;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dTw = Integer.parseInt(str);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.dTx.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.dTw = 0;
        this.dTx.clear();
    }

    public int getGid() {
        return this.dTw;
    }

    public Long aCL() {
        return com.baidu.tieba.im.memorycache.b.aBP().aBZ().get(this.dTw);
    }

    public synchronized List<Long> aCM() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.dTx) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.bY(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aCN() {
        this.dTx.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        r8.dTx.add(java.lang.Long.valueOf(r10));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(int i, long j) {
        if (this.dTw != 0 && this.dTw != i) {
            this.dTx.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.dTw);
        }
        this.dTw = i;
        Iterator<Long> it = this.dTx.iterator();
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

    public synchronized boolean aCO() {
        boolean z;
        if (this.dTw > 0) {
            z = this.dTx.size() > 0;
        }
        return z;
    }

    public synchronized boolean bU(long j) {
        boolean z;
        Iterator<Long> it = this.dTx.iterator();
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

    public synchronized String aCP() {
        String str;
        str = "";
        for (Long l : this.dTx) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
