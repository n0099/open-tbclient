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
    private static c bnx = new c();
    private boolean bns;
    private int bnt;
    private long bnu;
    private final SparseArray<a> bnv;
    private final HashSet<Integer> bnw;
    private int bny;

    public static c JE() {
        return bnx;
    }

    private c() {
        super(1001);
        this.bnt = 3;
        this.bnu = ReportUserInfoModel.TIME_INTERVAL;
        this.bnv = new SparseArray<>();
        this.bnw = new HashSet<>();
        this.bny = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean hy(int i) {
        this.bny = 0;
        if (this.bns) {
            this.bny = 3;
            return false;
        } else if (this.bnw.contains(Integer.valueOf(i))) {
            this.bny = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.bny = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ky() > PingManager.JI().JK() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.bny = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.bnv.get(i);
            if (aVar != null && aVar.bnA) {
                if (Math.abs(System.currentTimeMillis() - aVar.bnB) > this.bnu) {
                    aVar.reset();
                } else {
                    this.bny = 4;
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
            if (i2 < this.bnv.size()) {
                this.bnv.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void hz(int i) {
        a aVar = this.bnv.get(i);
        if (aVar == null) {
            aVar = new a();
            this.bnv.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.bnt);
        }
        this.bny = 5;
    }

    public void hA(int i) {
        this.bnv.remove(i);
    }

    public void bT(boolean z) {
        this.bns = z;
    }

    public void n(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.bnw.clear();
            for (int i : iArr) {
                this.bnw.add(Integer.valueOf(i));
            }
        }
    }

    public void hB(int i) {
        this.bnt = i;
    }

    public void aa(long j) {
        this.bnu = j;
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
        public boolean bnA;
        public long bnB;
        public int bnz;

        private a() {
        }

        public void reset() {
            this.bnz = 0;
            if (this.bnA) {
                this.bnA = false;
                this.bnB = 0L;
            }
        }

        public void onError(int i) {
            this.bnz++;
            if (!this.bnA && this.bnz >= i) {
                this.bnA = true;
                this.bnB = System.currentTimeMillis();
            }
        }
    }

    public int JF() {
        return this.bny;
    }
}
