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
    private static c aJO = new c();
    private boolean aJJ;
    private int aJK;
    private long aJL;
    private final SparseArray<a> aJM;
    private final HashSet<Integer> aJN;
    private int aJP;

    public static c Gx() {
        return aJO;
    }

    private c() {
        super(1001);
        this.aJK = 3;
        this.aJL = ReportUserInfoModel.TIME_INTERVAL;
        this.aJM = new SparseArray<>();
        this.aJN = new HashSet<>();
        this.aJP = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ez(int i) {
        this.aJP = 0;
        if (this.aJJ) {
            this.aJP = 3;
            return false;
        } else if (this.aJN.contains(Integer.valueOf(i))) {
            this.aJP = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aJP = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().fp() > PingManager.GB().GD() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aJP = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aJM.get(i);
            if (aVar != null && aVar.aJR) {
                if (Math.abs(System.currentTimeMillis() - aVar.aJS) > this.aJL) {
                    aVar.reset();
                } else {
                    this.aJP = 4;
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
            if (i2 < this.aJM.size()) {
                this.aJM.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eA(int i) {
        a aVar = this.aJM.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aJM.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aJK);
        }
        this.aJP = 5;
    }

    public void eB(int i) {
        this.aJM.remove(i);
    }

    public void bu(boolean z) {
        this.aJJ = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aJN.clear();
            for (int i : iArr) {
                this.aJN.add(Integer.valueOf(i));
            }
        }
    }

    public void eC(int i) {
        this.aJK = i;
    }

    public void Y(long j) {
        this.aJL = j;
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
        public int aJQ;
        public boolean aJR;
        public long aJS;

        private a() {
        }

        public void reset() {
            this.aJQ = 0;
            if (this.aJR) {
                this.aJR = false;
                this.aJS = 0L;
            }
        }

        public void onError(int i) {
            this.aJQ++;
            if (!this.aJR && this.aJQ >= i) {
                this.aJR = true;
                this.aJS = System.currentTimeMillis();
            }
        }
    }

    public int Gy() {
        return this.aJP;
    }
}
