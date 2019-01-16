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
    private static c aWE = new c();
    private int aWA;
    private long aWB;
    private final SparseArray<a> aWC;
    private final HashSet<Integer> aWD;
    private int aWF;
    private boolean aWz;

    public static c Lt() {
        return aWE;
    }

    private c() {
        super(1001);
        this.aWA = 3;
        this.aWB = ReportUserInfoModel.TIME_INTERVAL;
        this.aWC = new SparseArray<>();
        this.aWD = new HashSet<>();
        this.aWF = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean fx(int i) {
        this.aWF = 0;
        if (this.aWz) {
            this.aWF = 3;
            return false;
        } else if (this.aWD.contains(Integer.valueOf(i))) {
            this.aWF = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aWF = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().gQ() > PingManager.Lw().Ly() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aWF = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aWC.get(i);
            if (aVar != null && aVar.aWH) {
                if (Math.abs(System.currentTimeMillis() - aVar.aWI) > this.aWB) {
                    aVar.reset();
                } else {
                    this.aWF = 4;
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
            if (i2 < this.aWC.size()) {
                this.aWC.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void fy(int i) {
        a aVar = this.aWC.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aWC.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aWA);
        }
        this.aWF = 5;
    }

    public void fz(int i) {
        this.aWC.remove(i);
    }

    public void ci(boolean z) {
        this.aWz = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aWD.clear();
            for (int i : iArr) {
                this.aWD.add(Integer.valueOf(i));
            }
        }
    }

    public void fA(int i) {
        this.aWA = i;
    }

    public void ao(long j) {
        this.aWB = j;
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
        public int aWG;
        public boolean aWH;
        public long aWI;

        private a() {
        }

        public void reset() {
            this.aWG = 0;
            if (this.aWH) {
                this.aWH = false;
                this.aWI = 0L;
            }
        }

        public void onError(int i) {
            this.aWG++;
            if (!this.aWH && this.aWG >= i) {
                this.aWH = true;
                this.aWI = System.currentTimeMillis();
            }
        }
    }

    public int Lu() {
        return this.aWF;
    }
}
