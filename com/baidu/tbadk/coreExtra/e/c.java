package com.baidu.tbadk.coreExtra.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.c {
    private static c cqy = new c();
    private boolean cqt;
    private int cqu;
    private long cqv;
    private final SparseArray<a> cqw;
    private final HashSet<Integer> cqx;
    private int cqz;

    public static c arn() {
        return cqy;
    }

    private c() {
        super(1001);
        this.cqu = 3;
        this.cqv = ReportUserInfoModel.TIME_INTERVAL;
        this.cqw = new SparseArray<>();
        this.cqx = new HashSet<>();
        this.cqz = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean kf(int i) {
        this.cqz = 0;
        if (this.cqt) {
            this.cqz = 3;
            return false;
        } else if (this.cqx.contains(Integer.valueOf(i))) {
            this.cqz = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.cqz = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().fO() > e.arq().ars() + 20000) {
            com.baidu.adp.framework.client.socket.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.cqz = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.cqw.get(i);
            if (aVar != null && aVar.cqB) {
                if (Math.abs(System.currentTimeMillis() - aVar.cqC) > this.cqv) {
                    aVar.reset();
                } else {
                    this.cqz = 4;
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
            if (i2 < this.cqw.size()) {
                this.cqw.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void kg(int i) {
        a aVar = this.cqw.get(i);
        if (aVar == null) {
            aVar = new a();
            this.cqw.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.cqu);
        }
        this.cqz = 5;
    }

    public void kh(int i) {
        this.cqw.remove(i);
    }

    public void eZ(boolean z) {
        this.cqt = z;
    }

    public void i(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.cqx.clear();
            for (int i : iArr) {
                this.cqx.add(Integer.valueOf(i));
            }
        }
    }

    public void ki(int i) {
        this.cqu = i;
    }

    public void bj(long j) {
        this.cqv = j;
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
        public int cqA;
        public boolean cqB;
        public long cqC;

        private a() {
        }

        public void reset() {
            this.cqA = 0;
            if (this.cqB) {
                this.cqB = false;
                this.cqC = 0L;
            }
        }

        public void onError(int i) {
            this.cqA++;
            if (!this.cqB && this.cqA >= i) {
                this.cqB = true;
                this.cqC = System.currentTimeMillis();
            }
        }
    }

    public int aro() {
        return this.cqz;
    }
}
