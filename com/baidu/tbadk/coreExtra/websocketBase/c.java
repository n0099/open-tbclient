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
    private static c aNe = new c();
    private boolean aMZ;
    private int aNa;
    private long aNb;
    private final SparseArray<a> aNc;
    private final HashSet<Integer> aNd;
    private int aNf;

    public static c HN() {
        return aNe;
    }

    private c() {
        super(1001);
        this.aNa = 3;
        this.aNb = ReportUserInfoModel.TIME_INTERVAL;
        this.aNc = new SparseArray<>();
        this.aNd = new HashSet<>();
        this.aNf = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eL(int i) {
        this.aNf = 0;
        if (this.aMZ) {
            this.aNf = 3;
            return false;
        } else if (this.aNd.contains(Integer.valueOf(i))) {
            this.aNf = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aNf = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().gy() > PingManager.HR().HT() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aNf = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aNc.get(i);
            if (aVar != null && aVar.aNh) {
                if (Math.abs(System.currentTimeMillis() - aVar.aNi) > this.aNb) {
                    aVar.reset();
                } else {
                    this.aNf = 4;
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
            if (i2 < this.aNc.size()) {
                this.aNc.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eM(int i) {
        a aVar = this.aNc.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aNc.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aNa);
        }
        this.aNf = 5;
    }

    public void eN(int i) {
        this.aNc.remove(i);
    }

    public void bG(boolean z) {
        this.aMZ = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aNd.clear();
            for (int i : iArr) {
                this.aNd.add(Integer.valueOf(i));
            }
        }
    }

    public void eO(int i) {
        this.aNa = i;
    }

    public void ac(long j) {
        this.aNb = j;
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
        public int aNg;
        public boolean aNh;
        public long aNi;

        private a() {
        }

        public void reset() {
            this.aNg = 0;
            if (this.aNh) {
                this.aNh = false;
                this.aNi = 0L;
            }
        }

        public void onError(int i) {
            this.aNg++;
            if (!this.aNh && this.aNg >= i) {
                this.aNh = true;
                this.aNi = System.currentTimeMillis();
            }
        }
    }

    public int HO() {
        return this.aNf;
    }
}
