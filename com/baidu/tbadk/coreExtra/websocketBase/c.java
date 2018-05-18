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
    private static c aAt = new c();
    private boolean aAo;
    private int aAp;
    private long aAq;
    private final SparseArray<a> aAr;
    private final HashSet<Integer> aAs;
    private int aAu;

    public static c CG() {
        return aAt;
    }

    private c() {
        super(1001);
        this.aAp = 3;
        this.aAq = ReportUserInfoModel.TIME_INTERVAL;
        this.aAr = new SparseArray<>();
        this.aAs = new HashSet<>();
        this.aAu = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean es(int i) {
        this.aAu = 0;
        if (this.aAo) {
            this.aAu = 3;
            return false;
        } else if (this.aAs.contains(Integer.valueOf(i))) {
            this.aAu = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aAu = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cC() > PingManager.CK().CM() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aAu = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aAr.get(i);
            if (aVar != null && aVar.aAw) {
                if (Math.abs(System.currentTimeMillis() - aVar.aAx) > this.aAq) {
                    aVar.reset();
                } else {
                    this.aAu = 4;
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
            if (i2 < this.aAr.size()) {
                this.aAr.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void et(int i) {
        a aVar = this.aAr.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aAr.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aAp);
        }
        this.aAu = 5;
    }

    public void eu(int i) {
        this.aAr.remove(i);
    }

    public void bo(boolean z) {
        this.aAo = z;
    }

    public void g(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aAs.clear();
            for (int i : iArr) {
                this.aAs.add(Integer.valueOf(i));
            }
        }
    }

    public void ev(int i) {
        this.aAp = i;
    }

    public void S(long j) {
        this.aAq = j;
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
        public int aAv;
        public boolean aAw;
        public long aAx;

        private a() {
        }

        public void reset() {
            this.aAv = 0;
            if (this.aAw) {
                this.aAw = false;
                this.aAx = 0L;
            }
        }

        public void onError(int i) {
            this.aAv++;
            if (!this.aAw && this.aAv >= i) {
                this.aAw = true;
                this.aAx = System.currentTimeMillis();
            }
        }
    }

    public int CH() {
        return this.aAu;
    }
}
