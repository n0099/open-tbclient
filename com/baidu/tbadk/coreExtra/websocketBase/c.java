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
    private static c bnG = new c();
    private boolean bnB;
    private int bnC;
    private long bnD;
    private final SparseArray<a> bnE;
    private final HashSet<Integer> bnF;
    private int bnH;

    public static c Jt() {
        return bnG;
    }

    private c() {
        super(1001);
        this.bnC = 3;
        this.bnD = ReportUserInfoModel.TIME_INTERVAL;
        this.bnE = new SparseArray<>();
        this.bnF = new HashSet<>();
        this.bnH = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean hu(int i) {
        this.bnH = 0;
        if (this.bnB) {
            this.bnH = 3;
            return false;
        } else if (this.bnF.contains(Integer.valueOf(i))) {
            this.bnH = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.bnH = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ky() > PingManager.Jx().Jz() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.bnH = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.bnE.get(i);
            if (aVar != null && aVar.bnJ) {
                if (Math.abs(System.currentTimeMillis() - aVar.bnK) > this.bnD) {
                    aVar.reset();
                } else {
                    this.bnH = 4;
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
            if (i2 < this.bnE.size()) {
                this.bnE.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hv(int i) {
        a aVar = this.bnE.get(i);
        if (aVar == null) {
            aVar = new a();
            this.bnE.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.bnC);
        }
        this.bnH = 5;
    }

    public void hw(int i) {
        this.bnE.remove(i);
    }

    public void bR(boolean z) {
        this.bnB = z;
    }

    public void n(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.bnF.clear();
            for (int i : iArr) {
                this.bnF.add(Integer.valueOf(i));
            }
        }
    }

    public void hx(int i) {
        this.bnC = i;
    }

    public void aa(long j) {
        this.bnD = j;
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
        public int bnI;
        public boolean bnJ;
        public long bnK;

        private a() {
        }

        public void reset() {
            this.bnI = 0;
            if (this.bnJ) {
                this.bnJ = false;
                this.bnK = 0L;
            }
        }

        public void onError(int i) {
            this.bnI++;
            if (!this.bnJ && this.bnI >= i) {
                this.bnJ = true;
                this.bnK = System.currentTimeMillis();
            }
        }
    }

    public int Ju() {
        return this.bnH;
    }
}
