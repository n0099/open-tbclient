package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.c {
    private static c ayK = new c();
    private boolean ayF;
    private int ayG;
    private long ayH;
    private final SparseArray<a> ayI;
    private final HashSet<Integer> ayJ;
    private int ayL;

    public static c BU() {
        return ayK;
    }

    private c() {
        super(1001);
        this.ayG = 3;
        this.ayH = ReportUserInfoModel.TIME_INTERVAL;
        this.ayI = new SparseArray<>();
        this.ayJ = new HashSet<>();
        this.ayL = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ep(int i) {
        this.ayL = 0;
        if (this.ayF) {
            this.ayL = 3;
            return false;
        } else if (this.ayJ.contains(Integer.valueOf(i))) {
            this.ayL = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.ayL = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cU() > PingManager.BY().Ca() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.ayL = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.ayI.get(i);
            if (aVar != null && aVar.ayN) {
                if (Math.abs(System.currentTimeMillis() - aVar.ayO) > this.ayH) {
                    aVar.reset();
                } else {
                    this.ayL = 4;
                    return false;
                }
            }
            return true;
        }
    }

    public void reset() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ayI.size()) {
                this.ayI.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eq(int i) {
        a aVar = this.ayI.get(i);
        if (aVar == null) {
            aVar = new a();
            this.ayI.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.ayG);
        }
        this.ayL = 5;
    }

    public void er(int i) {
        this.ayI.remove(i);
    }

    public void bt(boolean z) {
        this.ayF = z;
    }

    public void e(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.ayJ.clear();
            for (int i : iArr) {
                this.ayJ.add(Integer.valueOf(i));
            }
        }
    }

    public void es(int i) {
        this.ayG = i;
    }

    public void O(long j) {
        this.ayH = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int ayM;
        public boolean ayN;
        public long ayO;

        private a() {
        }

        public void reset() {
            this.ayM = 0;
            if (this.ayN) {
                this.ayN = false;
                this.ayO = 0L;
            }
        }

        public void onError(int i) {
            this.ayM++;
            if (!this.ayN && this.ayM >= i) {
                this.ayN = true;
                this.ayO = System.currentTimeMillis();
            }
        }
    }

    public int BV() {
        return this.ayL;
    }
}
