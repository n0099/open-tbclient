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
    private static c dGI = null;
    private int dGJ = 0;
    private List<Long> dGK = new ArrayList();
    private final CustomMessageListener dFK = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.dFK);
    }

    public static c azV() {
        if (dGI == null) {
            synchronized (c.class) {
                if (dGI == null) {
                    dGI = new c();
                }
            }
        }
        return dGI;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dGJ = Integer.parseInt(str);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.dGK.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.dGJ = 0;
        this.dGK.clear();
    }

    public int getGid() {
        return this.dGJ;
    }

    public Long azW() {
        return com.baidu.tieba.im.memorycache.b.aza().azk().get(this.dGJ);
    }

    public synchronized List<Long> azX() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.dGK) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.bR(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void azY() {
        this.dGK.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        r8.dGK.add(java.lang.Long.valueOf(r10));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void i(int i, long j) {
        if (this.dGJ != 0 && this.dGJ != i) {
            this.dGK.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.dGJ);
        }
        this.dGJ = i;
        Iterator<Long> it = this.dGK.iterator();
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

    public synchronized boolean azZ() {
        boolean z;
        if (this.dGJ > 0) {
            z = this.dGK.size() > 0;
        }
        return z;
    }

    public synchronized boolean bN(long j) {
        boolean z;
        Iterator<Long> it = this.dGK.iterator();
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

    public synchronized String aAa() {
        String str;
        str = "";
        for (Long l : this.dGK) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
