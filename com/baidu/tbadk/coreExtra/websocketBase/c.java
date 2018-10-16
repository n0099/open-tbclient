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
    private static c aRG = new c();
    private boolean aRB;
    private int aRC;
    private long aRD;
    private final SparseArray<a> aRE;
    private final HashSet<Integer> aRF;
    private int aRH;

    public static c JN() {
        return aRG;
    }

    private c() {
        super(1001);
        this.aRC = 3;
        this.aRD = ReportUserInfoModel.TIME_INTERVAL;
        this.aRE = new SparseArray<>();
        this.aRF = new HashSet<>();
        this.aRH = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eU(int i) {
        this.aRH = 0;
        if (this.aRB) {
            this.aRH = 3;
            return false;
        } else if (this.aRF.contains(Integer.valueOf(i))) {
            this.aRH = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aRH = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().gR() > PingManager.JQ().JS() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aRH = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aRE.get(i);
            if (aVar != null && aVar.aRJ) {
                if (Math.abs(System.currentTimeMillis() - aVar.aRK) > this.aRD) {
                    aVar.reset();
                } else {
                    this.aRH = 4;
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
            if (i2 < this.aRE.size()) {
                this.aRE.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eV(int i) {
        a aVar = this.aRE.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aRE.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aRC);
        }
        this.aRH = 5;
    }

    public void eW(int i) {
        this.aRE.remove(i);
    }

    public void bP(boolean z) {
        this.aRB = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aRF.clear();
            for (int i : iArr) {
                this.aRF.add(Integer.valueOf(i));
            }
        }
    }

    public void eX(int i) {
        this.aRC = i;
    }

    public void ae(long j) {
        this.aRD = j;
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
        public int aRI;
        public boolean aRJ;
        public long aRK;

        private a() {
        }

        public void reset() {
            this.aRI = 0;
            if (this.aRJ) {
                this.aRJ = false;
                this.aRK = 0L;
            }
        }

        public void onError(int i) {
            this.aRI++;
            if (!this.aRJ && this.aRI >= i) {
                this.aRJ = true;
                this.aRK = System.currentTimeMillis();
            }
        }
    }

    public int JO() {
        return this.aRH;
    }
}
