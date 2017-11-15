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
    private static c ayJ = new c();
    private boolean ayE;
    private int ayF;
    private long ayG;
    private final SparseArray<a> ayH;
    private final HashSet<Integer> ayI;
    private int ayK;

    public static c BR() {
        return ayJ;
    }

    private c() {
        super(1001);
        this.ayF = 3;
        this.ayG = ReportUserInfoModel.TIME_INTERVAL;
        this.ayH = new SparseArray<>();
        this.ayI = new HashSet<>();
        this.ayK = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ez(int i) {
        this.ayK = 0;
        if (this.ayE) {
            this.ayK = 3;
            return false;
        } else if (this.ayI.contains(Integer.valueOf(i))) {
            this.ayK = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.ayK = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cU() > PingManager.BV().BX() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.ayK = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.ayH.get(i);
            if (aVar != null && aVar.ayM) {
                if (Math.abs(System.currentTimeMillis() - aVar.ayN) > this.ayG) {
                    aVar.reset();
                } else {
                    this.ayK = 4;
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
            if (i2 < this.ayH.size()) {
                this.ayH.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eA(int i) {
        a aVar = this.ayH.get(i);
        if (aVar == null) {
            aVar = new a();
            this.ayH.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.ayF);
        }
        this.ayK = 5;
    }

    public void eB(int i) {
        this.ayH.remove(i);
    }

    public void bn(boolean z) {
        this.ayE = z;
    }

    public void g(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.ayI.clear();
            for (int i : iArr) {
                this.ayI.add(Integer.valueOf(i));
            }
        }
    }

    public void eC(int i) {
        this.ayF = i;
    }

    public void P(long j) {
        this.ayG = j;
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
        public int ayL;
        public boolean ayM;
        public long ayN;

        private a() {
        }

        public void reset() {
            this.ayL = 0;
            if (this.ayM) {
                this.ayM = false;
                this.ayN = 0L;
            }
        }

        public void onError(int i) {
            this.ayL++;
            if (!this.ayM && this.ayL >= i) {
                this.ayM = true;
                this.ayN = System.currentTimeMillis();
            }
        }
    }

    public int BS() {
        return this.ayK;
    }
}
