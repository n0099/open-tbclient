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
    private static c bnP = new c();
    private boolean bnK;
    private int bnL;
    private long bnM;
    private final SparseArray<a> bnN;
    private final HashSet<Integer> bnO;
    private int bnQ;

    public static c Jv() {
        return bnP;
    }

    private c() {
        super(1001);
        this.bnL = 3;
        this.bnM = ReportUserInfoModel.TIME_INTERVAL;
        this.bnN = new SparseArray<>();
        this.bnO = new HashSet<>();
        this.bnQ = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean hu(int i) {
        this.bnQ = 0;
        if (this.bnK) {
            this.bnQ = 3;
            return false;
        } else if (this.bnO.contains(Integer.valueOf(i))) {
            this.bnQ = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.bnQ = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ky() > PingManager.Jz().JB() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.bnQ = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.bnN.get(i);
            if (aVar != null && aVar.bnS) {
                if (Math.abs(System.currentTimeMillis() - aVar.bnT) > this.bnM) {
                    aVar.reset();
                } else {
                    this.bnQ = 4;
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
            if (i2 < this.bnN.size()) {
                this.bnN.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hv(int i) {
        a aVar = this.bnN.get(i);
        if (aVar == null) {
            aVar = new a();
            this.bnN.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.bnL);
        }
        this.bnQ = 5;
    }

    public void hw(int i) {
        this.bnN.remove(i);
    }

    public void bS(boolean z) {
        this.bnK = z;
    }

    public void n(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.bnO.clear();
            for (int i : iArr) {
                this.bnO.add(Integer.valueOf(i));
            }
        }
    }

    public void hx(int i) {
        this.bnL = i;
    }

    public void aa(long j) {
        this.bnM = j;
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
        public int bnR;
        public boolean bnS;
        public long bnT;

        private a() {
        }

        public void reset() {
            this.bnR = 0;
            if (this.bnS) {
                this.bnS = false;
                this.bnT = 0L;
            }
        }

        public void onError(int i) {
            this.bnR++;
            if (!this.bnS && this.bnR >= i) {
                this.bnS = true;
                this.bnT = System.currentTimeMillis();
            }
        }
    }

    public int Jw() {
        return this.bnQ;
    }
}
