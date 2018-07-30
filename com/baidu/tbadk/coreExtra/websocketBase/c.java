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
    private static c aJR = new c();
    private boolean aJM;
    private int aJN;
    private long aJO;
    private final SparseArray<a> aJP;
    private final HashSet<Integer> aJQ;
    private int aJS;

    public static c Gx() {
        return aJR;
    }

    private c() {
        super(1001);
        this.aJN = 3;
        this.aJO = ReportUserInfoModel.TIME_INTERVAL;
        this.aJP = new SparseArray<>();
        this.aJQ = new HashSet<>();
        this.aJS = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eA(int i) {
        this.aJS = 0;
        if (this.aJM) {
            this.aJS = 3;
            return false;
        } else if (this.aJQ.contains(Integer.valueOf(i))) {
            this.aJS = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aJS = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().fp() > PingManager.GB().GD() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aJS = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aJP.get(i);
            if (aVar != null && aVar.aJU) {
                if (Math.abs(System.currentTimeMillis() - aVar.aJV) > this.aJO) {
                    aVar.reset();
                } else {
                    this.aJS = 4;
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
            if (i2 < this.aJP.size()) {
                this.aJP.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eB(int i) {
        a aVar = this.aJP.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aJP.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aJN);
        }
        this.aJS = 5;
    }

    public void eC(int i) {
        this.aJP.remove(i);
    }

    public void bt(boolean z) {
        this.aJM = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aJQ.clear();
            for (int i : iArr) {
                this.aJQ.add(Integer.valueOf(i));
            }
        }
    }

    public void eD(int i) {
        this.aJN = i;
    }

    public void Y(long j) {
        this.aJO = j;
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
        public int aJT;
        public boolean aJU;
        public long aJV;

        private a() {
        }

        public void reset() {
            this.aJT = 0;
            if (this.aJU) {
                this.aJU = false;
                this.aJV = 0L;
            }
        }

        public void onError(int i) {
            this.aJT++;
            if (!this.aJU && this.aJT >= i) {
                this.aJU = true;
                this.aJV = System.currentTimeMillis();
            }
        }
    }

    public int Gy() {
        return this.aJS;
    }
}
