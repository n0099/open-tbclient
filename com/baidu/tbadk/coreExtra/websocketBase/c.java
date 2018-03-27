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
    private static c bpT = new c();
    private boolean bpO;
    private int bpP;
    private long bpQ;
    private final SparseArray<a> bpR;
    private final HashSet<Integer> bpS;
    private int bpU;

    public static c Kc() {
        return bpT;
    }

    private c() {
        super(1001);
        this.bpP = 3;
        this.bpQ = ReportUserInfoModel.TIME_INTERVAL;
        this.bpR = new SparseArray<>();
        this.bpS = new HashSet<>();
        this.bpU = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ht(int i) {
        this.bpU = 0;
        if (this.bpO) {
            this.bpU = 3;
            return false;
        } else if (this.bpS.contains(Integer.valueOf(i))) {
            this.bpU = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.bpU = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ky() > PingManager.Kg().Ki() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.bpU = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.bpR.get(i);
            if (aVar != null && aVar.bpW) {
                if (Math.abs(System.currentTimeMillis() - aVar.bpX) > this.bpQ) {
                    aVar.reset();
                } else {
                    this.bpU = 4;
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
            if (i2 < this.bpR.size()) {
                this.bpR.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hu(int i) {
        a aVar = this.bpR.get(i);
        if (aVar == null) {
            aVar = new a();
            this.bpR.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.bpP);
        }
        this.bpU = 5;
    }

    public void hv(int i) {
        this.bpR.remove(i);
    }

    public void bW(boolean z) {
        this.bpO = z;
    }

    public void m(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.bpS.clear();
            for (int i : iArr) {
                this.bpS.add(Integer.valueOf(i));
            }
        }
    }

    public void hw(int i) {
        this.bpP = i;
    }

    public void aa(long j) {
        this.bpQ = j;
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
        public int bpV;
        public boolean bpW;
        public long bpX;

        private a() {
        }

        public void reset() {
            this.bpV = 0;
            if (this.bpW) {
                this.bpW = false;
                this.bpX = 0L;
            }
        }

        public void onError(int i) {
            this.bpV++;
            if (!this.bpW && this.bpV >= i) {
                this.bpW = true;
                this.bpX = System.currentTimeMillis();
            }
        }
    }

    public int Kd() {
        return this.bpU;
    }
}
