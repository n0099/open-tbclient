package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.e {
    private static d awB = new d();
    private final HashSet<Integer> awA;
    private int awC;
    private boolean aww;
    private int awx;
    private long awy;
    private final SparseArray<a> awz;

    public static d Bs() {
        return awB;
    }

    private d() {
        super(1001);
        this.awx = 3;
        this.awy = ReportUserInfoModel.TIME_INTERVAL;
        this.awz = new SparseArray<>();
        this.awA = new HashSet<>();
        this.awC = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ej(int i) {
        this.awC = 0;
        if (this.aww) {
            this.awC = 3;
            return false;
        } else if (this.awA.contains(Integer.valueOf(i))) {
            this.awC = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.awC = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cT() > PingManager.Bw().By() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.awC = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.awz.get(i);
            if (aVar != null && aVar.awE) {
                if (Math.abs(System.currentTimeMillis() - aVar.awF) > this.awy) {
                    aVar.reset();
                } else {
                    this.awC = 4;
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
            if (i2 < this.awz.size()) {
                this.awz.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ek(int i) {
        a aVar = this.awz.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.awz.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.awx);
        }
        this.awC = 5;
    }

    public void el(int i) {
        this.awz.remove(i);
    }

    public void bu(boolean z) {
        this.aww = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.awA.clear();
            for (int i : iArr) {
                this.awA.add(Integer.valueOf(i));
            }
        }
    }

    public void em(int i) {
        this.awx = i;
    }

    public void N(long j) {
        this.awy = j;
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
        public int awD;
        public boolean awE;
        public long awF;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.awD = 0;
            if (this.awE) {
                this.awE = false;
                this.awF = 0L;
            }
        }

        public void onError(int i) {
            this.awD++;
            if (!this.awE && this.awD >= i) {
                this.awE = true;
                this.awF = System.currentTimeMillis();
            }
        }
    }

    public int Bt() {
        return this.awC;
    }
}
