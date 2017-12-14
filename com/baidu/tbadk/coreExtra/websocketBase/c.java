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
    private static c azp = new c();
    private boolean azk;
    private int azl;
    private long azm;
    private final SparseArray<a> azn;
    private final HashSet<Integer> azo;
    private int azq;

    public static c Cc() {
        return azp;
    }

    private c() {
        super(1001);
        this.azl = 3;
        this.azm = ReportUserInfoModel.TIME_INTERVAL;
        this.azn = new SparseArray<>();
        this.azo = new HashSet<>();
        this.azq = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eA(int i) {
        this.azq = 0;
        if (this.azk) {
            this.azq = 3;
            return false;
        } else if (this.azo.contains(Integer.valueOf(i))) {
            this.azq = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.azq = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cU() > PingManager.Cg().Ci() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.azq = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.azn.get(i);
            if (aVar != null && aVar.azs) {
                if (Math.abs(System.currentTimeMillis() - aVar.azt) > this.azm) {
                    aVar.reset();
                } else {
                    this.azq = 4;
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
            if (i2 < this.azn.size()) {
                this.azn.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eB(int i) {
        a aVar = this.azn.get(i);
        if (aVar == null) {
            aVar = new a();
            this.azn.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.azl);
        }
        this.azq = 5;
    }

    public void eC(int i) {
        this.azn.remove(i);
    }

    public void bo(boolean z) {
        this.azk = z;
    }

    public void g(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.azo.clear();
            for (int i : iArr) {
                this.azo.add(Integer.valueOf(i));
            }
        }
    }

    public void eD(int i) {
        this.azl = i;
    }

    public void S(long j) {
        this.azm = j;
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
        public int azr;
        public boolean azs;
        public long azt;

        private a() {
        }

        public void reset() {
            this.azr = 0;
            if (this.azs) {
                this.azs = false;
                this.azt = 0L;
            }
        }

        public void onError(int i) {
            this.azr++;
            if (!this.azs && this.azr >= i) {
                this.azs = true;
                this.azt = System.currentTimeMillis();
            }
        }
    }

    public int Cd() {
        return this.azq;
    }
}
