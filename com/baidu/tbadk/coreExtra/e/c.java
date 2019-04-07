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
    private static c cgb = new c();
    private boolean cfW;
    private int cfX;
    private long cfY;
    private final SparseArray<a> cfZ;
    private final HashSet<Integer> cga;
    private int cgc;

    public static c akR() {
        return cgb;
    }

    private c() {
        super(1001);
        this.cfX = 3;
        this.cfY = ReportUserInfoModel.TIME_INTERVAL;
        this.cfZ = new SparseArray<>();
        this.cga = new HashSet<>();
        this.cgc = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean jh(int i) {
        this.cgc = 0;
        if (this.cfW) {
            this.cgc = 3;
            return false;
        } else if (this.cga.contains(Integer.valueOf(i))) {
            this.cgc = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.cgc = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().gN() > e.akU().akW() + 20000) {
            com.baidu.adp.framework.client.socket.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.cgc = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.cfZ.get(i);
            if (aVar != null && aVar.cge) {
                if (Math.abs(System.currentTimeMillis() - aVar.cgf) > this.cfY) {
                    aVar.reset();
                } else {
                    this.cgc = 4;
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
            if (i2 < this.cfZ.size()) {
                this.cfZ.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ji(int i) {
        a aVar = this.cfZ.get(i);
        if (aVar == null) {
            aVar = new a();
            this.cfZ.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.cfX);
        }
        this.cgc = 5;
    }

    public void jj(int i) {
        this.cfZ.remove(i);
    }

    public void ew(boolean z) {
        this.cfW = z;
    }

    public void i(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.cga.clear();
            for (int i : iArr) {
                this.cga.add(Integer.valueOf(i));
            }
        }
    }

    public void jk(int i) {
        this.cfX = i;
    }

    public void aQ(long j) {
        this.cfY = j;
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
        public int cgd;
        public boolean cge;
        public long cgf;

        private a() {
        }

        public void reset() {
            this.cgd = 0;
            if (this.cge) {
                this.cge = false;
                this.cgf = 0L;
            }
        }

        public void onError(int i) {
            this.cgd++;
            if (!this.cge && this.cgd >= i) {
                this.cge = true;
                this.cgf = System.currentTimeMillis();
            }
        }
    }

    public int akS() {
        return this.cgc;
    }
}
