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
    private static c axQ = new c();
    private boolean axL;
    private int axM;
    private long axN;
    private final SparseArray<a> axO;
    private final HashSet<Integer> axP;
    private int axR;

    public static c Br() {
        return axQ;
    }

    private c() {
        super(1001);
        this.axM = 3;
        this.axN = ReportUserInfoModel.TIME_INTERVAL;
        this.axO = new SparseArray<>();
        this.axP = new HashSet<>();
        this.axR = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ez(int i) {
        this.axR = 0;
        if (this.axL) {
            this.axR = 3;
            return false;
        } else if (this.axP.contains(Integer.valueOf(i))) {
            this.axR = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.axR = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cU() > PingManager.Bv().Bx() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.axR = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.axO.get(i);
            if (aVar != null && aVar.axT) {
                if (Math.abs(System.currentTimeMillis() - aVar.axU) > this.axN) {
                    aVar.reset();
                } else {
                    this.axR = 4;
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
            if (i2 < this.axO.size()) {
                this.axO.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eA(int i) {
        a aVar = this.axO.get(i);
        if (aVar == null) {
            aVar = new a();
            this.axO.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.axM);
        }
        this.axR = 5;
    }

    public void eB(int i) {
        this.axO.remove(i);
    }

    public void br(boolean z) {
        this.axL = z;
    }

    public void g(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.axP.clear();
            for (int i : iArr) {
                this.axP.add(Integer.valueOf(i));
            }
        }
    }

    public void eC(int i) {
        this.axM = i;
    }

    public void P(long j) {
        this.axN = j;
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
        public int axS;
        public boolean axT;
        public long axU;

        private a() {
        }

        public void reset() {
            this.axS = 0;
            if (this.axT) {
                this.axT = false;
                this.axU = 0L;
            }
        }

        public void onError(int i) {
            this.axS++;
            if (!this.axT && this.axS >= i) {
                this.axT = true;
                this.axU = System.currentTimeMillis();
            }
        }
    }

    public int Bs() {
        return this.axR;
    }
}
