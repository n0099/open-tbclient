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
    private static c bpQ = new c();
    private boolean bpL;
    private int bpM;
    private long bpN;
    private final SparseArray<a> bpO;
    private final HashSet<Integer> bpP;
    private int bpR;

    public static c Kb() {
        return bpQ;
    }

    private c() {
        super(1001);
        this.bpM = 3;
        this.bpN = ReportUserInfoModel.TIME_INTERVAL;
        this.bpO = new SparseArray<>();
        this.bpP = new HashSet<>();
        this.bpR = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ht(int i) {
        this.bpR = 0;
        if (this.bpL) {
            this.bpR = 3;
            return false;
        } else if (this.bpP.contains(Integer.valueOf(i))) {
            this.bpR = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.bpR = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ky() > PingManager.Kf().Kh() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.bpR = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.bpO.get(i);
            if (aVar != null && aVar.bpT) {
                if (Math.abs(System.currentTimeMillis() - aVar.bpU) > this.bpN) {
                    aVar.reset();
                } else {
                    this.bpR = 4;
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
            if (i2 < this.bpO.size()) {
                this.bpO.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hu(int i) {
        a aVar = this.bpO.get(i);
        if (aVar == null) {
            aVar = new a();
            this.bpO.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.bpM);
        }
        this.bpR = 5;
    }

    public void hv(int i) {
        this.bpO.remove(i);
    }

    public void bW(boolean z) {
        this.bpL = z;
    }

    public void m(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.bpP.clear();
            for (int i : iArr) {
                this.bpP.add(Integer.valueOf(i));
            }
        }
    }

    public void hw(int i) {
        this.bpM = i;
    }

    public void aa(long j) {
        this.bpN = j;
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
        public int bpS;
        public boolean bpT;
        public long bpU;

        private a() {
        }

        public void reset() {
            this.bpS = 0;
            if (this.bpT) {
                this.bpT = false;
                this.bpU = 0L;
            }
        }

        public void onError(int i) {
            this.bpS++;
            if (!this.bpT && this.bpS >= i) {
                this.bpT = true;
                this.bpU = System.currentTimeMillis();
            }
        }
    }

    public int Kc() {
        return this.bpR;
    }
}
