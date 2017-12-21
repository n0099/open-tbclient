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
    private static c azs = new c();
    private boolean azn;
    private int azo;
    private long azp;
    private final SparseArray<a> azq;
    private final HashSet<Integer> azr;
    private int azt;

    public static c Cc() {
        return azs;
    }

    private c() {
        super(1001);
        this.azo = 3;
        this.azp = ReportUserInfoModel.TIME_INTERVAL;
        this.azq = new SparseArray<>();
        this.azr = new HashSet<>();
        this.azt = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eA(int i) {
        this.azt = 0;
        if (this.azn) {
            this.azt = 3;
            return false;
        } else if (this.azr.contains(Integer.valueOf(i))) {
            this.azt = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.azt = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cU() > PingManager.Cg().Ci() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.azt = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.azq.get(i);
            if (aVar != null && aVar.azv) {
                if (Math.abs(System.currentTimeMillis() - aVar.azw) > this.azp) {
                    aVar.reset();
                } else {
                    this.azt = 4;
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
            if (i2 < this.azq.size()) {
                this.azq.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eB(int i) {
        a aVar = this.azq.get(i);
        if (aVar == null) {
            aVar = new a();
            this.azq.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.azo);
        }
        this.azt = 5;
    }

    public void eC(int i) {
        this.azq.remove(i);
    }

    public void bo(boolean z) {
        this.azn = z;
    }

    public void g(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.azr.clear();
            for (int i : iArr) {
                this.azr.add(Integer.valueOf(i));
            }
        }
    }

    public void eD(int i) {
        this.azo = i;
    }

    public void S(long j) {
        this.azp = j;
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
        public int azu;
        public boolean azv;
        public long azw;

        private a() {
        }

        public void reset() {
            this.azu = 0;
            if (this.azv) {
                this.azv = false;
                this.azw = 0L;
            }
        }

        public void onError(int i) {
            this.azu++;
            if (!this.azv && this.azu >= i) {
                this.azv = true;
                this.azw = System.currentTimeMillis();
            }
        }
    }

    public int Cd() {
        return this.azt;
    }
}
