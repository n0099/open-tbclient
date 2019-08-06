package com.baidu.tbadk.coreExtra.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.c {
    private static c cpE = new c();
    private int cpA;
    private long cpB;
    private final SparseArray<a> cpC;
    private final HashSet<Integer> cpD;
    private int cpF;
    private boolean cpz;

    public static c arb() {
        return cpE;
    }

    private c() {
        super(1001);
        this.cpA = 3;
        this.cpB = ReportUserInfoModel.TIME_INTERVAL;
        this.cpC = new SparseArray<>();
        this.cpD = new HashSet<>();
        this.cpF = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean kc(int i) {
        this.cpF = 0;
        if (this.cpz) {
            this.cpF = 3;
            return false;
        } else if (this.cpD.contains(Integer.valueOf(i))) {
            this.cpF = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.cpF = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().fO() > e.are().arg() + 20000) {
            com.baidu.adp.framework.client.socket.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.cpF = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.cpC.get(i);
            if (aVar != null && aVar.cpH) {
                if (Math.abs(System.currentTimeMillis() - aVar.cpI) > this.cpB) {
                    aVar.reset();
                } else {
                    this.cpF = 4;
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
            if (i2 < this.cpC.size()) {
                this.cpC.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void kd(int i) {
        a aVar = this.cpC.get(i);
        if (aVar == null) {
            aVar = new a();
            this.cpC.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.cpA);
        }
        this.cpF = 5;
    }

    public void ke(int i) {
        this.cpC.remove(i);
    }

    public void eW(boolean z) {
        this.cpz = z;
    }

    public void i(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.cpD.clear();
            for (int i : iArr) {
                this.cpD.add(Integer.valueOf(i));
            }
        }
    }

    public void kf(int i) {
        this.cpA = i;
    }

    public void bg(long j) {
        this.cpB = j;
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
        public int cpG;
        public boolean cpH;
        public long cpI;

        private a() {
        }

        public void reset() {
            this.cpG = 0;
            if (this.cpH) {
                this.cpH = false;
                this.cpI = 0L;
            }
        }

        public void onError(int i) {
            this.cpG++;
            if (!this.cpH && this.cpG >= i) {
                this.cpH = true;
                this.cpI = System.currentTimeMillis();
            }
        }
    }

    public int arc() {
        return this.cpF;
    }
}
