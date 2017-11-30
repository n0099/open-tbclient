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
    private static c azk = new c();
    private boolean azf;
    private int azg;
    private long azh;
    private final SparseArray<a> azi;
    private final HashSet<Integer> azj;
    private int azl;

    public static c Cb() {
        return azk;
    }

    private c() {
        super(1001);
        this.azg = 3;
        this.azh = ReportUserInfoModel.TIME_INTERVAL;
        this.azi = new SparseArray<>();
        this.azj = new HashSet<>();
        this.azl = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eA(int i) {
        this.azl = 0;
        if (this.azf) {
            this.azl = 3;
            return false;
        } else if (this.azj.contains(Integer.valueOf(i))) {
            this.azl = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.azl = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cU() > PingManager.Cf().Ch() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.azl = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.azi.get(i);
            if (aVar != null && aVar.azn) {
                if (Math.abs(System.currentTimeMillis() - aVar.azo) > this.azh) {
                    aVar.reset();
                } else {
                    this.azl = 4;
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
            if (i2 < this.azi.size()) {
                this.azi.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eB(int i) {
        a aVar = this.azi.get(i);
        if (aVar == null) {
            aVar = new a();
            this.azi.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.azg);
        }
        this.azl = 5;
    }

    public void eC(int i) {
        this.azi.remove(i);
    }

    public void bn(boolean z) {
        this.azf = z;
    }

    public void g(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.azj.clear();
            for (int i : iArr) {
                this.azj.add(Integer.valueOf(i));
            }
        }
    }

    public void eD(int i) {
        this.azg = i;
    }

    public void S(long j) {
        this.azh = j;
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
        public int azm;
        public boolean azn;
        public long azo;

        private a() {
        }

        public void reset() {
            this.azm = 0;
            if (this.azn) {
                this.azn = false;
                this.azo = 0L;
            }
        }

        public void onError(int i) {
            this.azm++;
            if (!this.azn && this.azm >= i) {
                this.azn = true;
                this.azo = System.currentTimeMillis();
            }
        }
    }

    public int Cc() {
        return this.azl;
    }
}
