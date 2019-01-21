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
    private static c aWF = new c();
    private boolean aWA;
    private int aWB;
    private long aWC;
    private final SparseArray<a> aWD;
    private final HashSet<Integer> aWE;
    private int aWG;

    public static c Lt() {
        return aWF;
    }

    private c() {
        super(1001);
        this.aWB = 3;
        this.aWC = ReportUserInfoModel.TIME_INTERVAL;
        this.aWD = new SparseArray<>();
        this.aWE = new HashSet<>();
        this.aWG = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean fx(int i) {
        this.aWG = 0;
        if (this.aWA) {
            this.aWG = 3;
            return false;
        } else if (this.aWE.contains(Integer.valueOf(i))) {
            this.aWG = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aWG = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().gQ() > PingManager.Lw().Ly() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aWG = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aWD.get(i);
            if (aVar != null && aVar.aWI) {
                if (Math.abs(System.currentTimeMillis() - aVar.aWJ) > this.aWC) {
                    aVar.reset();
                } else {
                    this.aWG = 4;
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
            if (i2 < this.aWD.size()) {
                this.aWD.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void fy(int i) {
        a aVar = this.aWD.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aWD.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aWB);
        }
        this.aWG = 5;
    }

    public void fz(int i) {
        this.aWD.remove(i);
    }

    public void ci(boolean z) {
        this.aWA = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aWE.clear();
            for (int i : iArr) {
                this.aWE.add(Integer.valueOf(i));
            }
        }
    }

    public void fA(int i) {
        this.aWB = i;
    }

    public void ao(long j) {
        this.aWC = j;
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
        public int aWH;
        public boolean aWI;
        public long aWJ;

        private a() {
        }

        public void reset() {
            this.aWH = 0;
            if (this.aWI) {
                this.aWI = false;
                this.aWJ = 0L;
            }
        }

        public void onError(int i) {
            this.aWH++;
            if (!this.aWI && this.aWH >= i) {
                this.aWI = true;
                this.aWJ = System.currentTimeMillis();
            }
        }
    }

    public int Lu() {
        return this.aWG;
    }
}
