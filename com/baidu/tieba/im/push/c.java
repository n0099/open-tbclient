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
    private static c eFH = null;
    private int eFI = 0;
    private List<Long> eFJ = new ArrayList();
    private final CustomMessageListener eEJ = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.clear();
            }
        }
    };

    private c() {
        MessageManager.getInstance().registerListener(this.eEJ);
    }

    public static c aJM() {
        if (eFH == null) {
            synchronized (c.class) {
                if (eFH == null) {
                    eFH = new c();
                }
            }
        }
        return eFH;
    }

    public synchronized void init(String str, String str2) {
        clear();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.eFI = Integer.parseInt(str);
                try {
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i])) {
                                this.eFJ.add(Long.valueOf(Long.parseLong(split[i])));
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
        this.eFI = 0;
        this.eFJ.clear();
    }

    public int getGid() {
        return this.eFI;
    }

    public Long aJN() {
        return com.baidu.tieba.im.memorycache.b.aIQ().aJa().get(this.eFI);
    }

    public synchronized List<Long> aJO() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.eFJ) {
            if (l != null) {
                arrayList.add(Long.valueOf(com.baidu.tieba.im.util.d.ch(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized void aJP() {
        this.eFJ.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        r8.eFJ.add(java.lang.Long.valueOf(r10));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(int i, long j) {
        if (this.eFI != 0 && this.eFI != i) {
            this.eFJ.clear();
            i.a("PushIdsCacheManager", (Message<?>) null, 0, "addPushId", -1, "not equal original gid:" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.eFI);
        }
        this.eFI = i;
        Iterator<Long> it = this.eFJ.iterator();
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

    public synchronized boolean aJQ() {
        boolean z;
        if (this.eFI > 0) {
            z = this.eFJ.size() > 0;
        }
        return z;
    }

    public synchronized boolean cd(long j) {
        boolean z;
        Iterator<Long> it = this.eFJ.iterator();
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

    public synchronized String aJR() {
        String str;
        str = "";
        for (Long l : this.eFJ) {
            str = (l == null || l.longValue() == 0) ? str : (str + l.longValue()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str;
    }
}
