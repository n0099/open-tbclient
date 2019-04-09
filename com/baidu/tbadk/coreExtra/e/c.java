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
    private static c cgc = new c();
    private boolean cfX;
    private int cfY;
    private long cfZ;
    private final SparseArray<a> cga;
    private final HashSet<Integer> cgb;
    private int cgd;

    public static c akR() {
        return cgc;
    }

    private c() {
        super(1001);
        this.cfY = 3;
        this.cfZ = ReportUserInfoModel.TIME_INTERVAL;
        this.cga = new SparseArray<>();
        this.cgb = new HashSet<>();
        this.cgd = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean jh(int i) {
        this.cgd = 0;
        if (this.cfX) {
            this.cgd = 3;
            return false;
        } else if (this.cgb.contains(Integer.valueOf(i))) {
            this.cgd = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.cgd = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().gN() > e.akU().akW() + 20000) {
            com.baidu.adp.framework.client.socket.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.cgd = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.cga.get(i);
            if (aVar != null && aVar.cgf) {
                if (Math.abs(System.currentTimeMillis() - aVar.cgg) > this.cfZ) {
                    aVar.reset();
                } else {
                    this.cgd = 4;
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
            if (i2 < this.cga.size()) {
                this.cga.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ji(int i) {
        a aVar = this.cga.get(i);
        if (aVar == null) {
            aVar = new a();
            this.cga.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.cfY);
        }
        this.cgd = 5;
    }

    public void jj(int i) {
        this.cga.remove(i);
    }

    public void ew(boolean z) {
        this.cfX = z;
    }

    public void i(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.cgb.clear();
            for (int i : iArr) {
                this.cgb.add(Integer.valueOf(i));
            }
        }
    }

    public void jk(int i) {
        this.cfY = i;
    }

    public void aQ(long j) {
        this.cfZ = j;
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
        public int cge;
        public boolean cgf;
        public long cgg;

        private a() {
        }

        public void reset() {
            this.cge = 0;
            if (this.cgf) {
                this.cgf = false;
                this.cgg = 0L;
            }
        }

        public void onError(int i) {
            this.cge++;
            if (!this.cgf && this.cge >= i) {
                this.cgf = true;
                this.cgg = System.currentTimeMillis();
            }
        }
    }

    public int akS() {
        return this.cgd;
    }
}
