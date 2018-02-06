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
    private static c bqd = new c();
    private boolean bpY;
    private int bpZ;
    private long bqa;
    private final SparseArray<a> bqb;
    private final HashSet<Integer> bqc;
    private int bqe;

    public static c Kc() {
        return bqd;
    }

    private c() {
        super(1001);
        this.bpZ = 3;
        this.bqa = ReportUserInfoModel.TIME_INTERVAL;
        this.bqb = new SparseArray<>();
        this.bqc = new HashSet<>();
        this.bqe = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ht(int i) {
        this.bqe = 0;
        if (this.bpY) {
            this.bqe = 3;
            return false;
        } else if (this.bqc.contains(Integer.valueOf(i))) {
            this.bqe = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.bqe = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ky() > PingManager.Kg().Ki() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.bqe = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.bqb.get(i);
            if (aVar != null && aVar.bqg) {
                if (Math.abs(System.currentTimeMillis() - aVar.bqh) > this.bqa) {
                    aVar.reset();
                } else {
                    this.bqe = 4;
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
            if (i2 < this.bqb.size()) {
                this.bqb.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hu(int i) {
        a aVar = this.bqb.get(i);
        if (aVar == null) {
            aVar = new a();
            this.bqb.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.bpZ);
        }
        this.bqe = 5;
    }

    public void hv(int i) {
        this.bqb.remove(i);
    }

    public void bW(boolean z) {
        this.bpY = z;
    }

    public void m(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.bqc.clear();
            for (int i : iArr) {
                this.bqc.add(Integer.valueOf(i));
            }
        }
    }

    public void hw(int i) {
        this.bpZ = i;
    }

    public void aa(long j) {
        this.bqa = j;
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
        public int bqf;
        public boolean bqg;
        public long bqh;

        private a() {
        }

        public void reset() {
            this.bqf = 0;
            if (this.bqg) {
                this.bqg = false;
                this.bqh = 0L;
            }
        }

        public void onError(int i) {
            this.bqf++;
            if (!this.bqg && this.bqf >= i) {
                this.bqg = true;
                this.bqh = System.currentTimeMillis();
            }
        }
    }

    public int Kd() {
        return this.bqe;
    }
}
