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
    private static c cfZ = new c();
    private boolean cfU;
    private int cfV;
    private long cfW;
    private final SparseArray<a> cfX;
    private final HashSet<Integer> cfY;
    private int cga;

    public static c akU() {
        return cfZ;
    }

    private c() {
        super(1001);
        this.cfV = 3;
        this.cfW = ReportUserInfoModel.TIME_INTERVAL;
        this.cfX = new SparseArray<>();
        this.cfY = new HashSet<>();
        this.cga = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ji(int i) {
        this.cga = 0;
        if (this.cfU) {
            this.cga = 3;
            return false;
        } else if (this.cfY.contains(Integer.valueOf(i))) {
            this.cga = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.cga = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().gN() > e.akX().akZ() + 20000) {
            com.baidu.adp.framework.client.socket.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.cga = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.cfX.get(i);
            if (aVar != null && aVar.cgc) {
                if (Math.abs(System.currentTimeMillis() - aVar.cgd) > this.cfW) {
                    aVar.reset();
                } else {
                    this.cga = 4;
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
            if (i2 < this.cfX.size()) {
                this.cfX.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void jj(int i) {
        a aVar = this.cfX.get(i);
        if (aVar == null) {
            aVar = new a();
            this.cfX.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.cfV);
        }
        this.cga = 5;
    }

    public void jk(int i) {
        this.cfX.remove(i);
    }

    public void ew(boolean z) {
        this.cfU = z;
    }

    public void i(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.cfY.clear();
            for (int i : iArr) {
                this.cfY.add(Integer.valueOf(i));
            }
        }
    }

    public void jl(int i) {
        this.cfV = i;
    }

    public void aQ(long j) {
        this.cfW = j;
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
        public int cgb;
        public boolean cgc;
        public long cgd;

        private a() {
        }

        public void reset() {
            this.cgb = 0;
            if (this.cgc) {
                this.cgc = false;
                this.cgd = 0L;
            }
        }

        public void onError(int i) {
            this.cgb++;
            if (!this.cgc && this.cgb >= i) {
                this.cgc = true;
                this.cgd = System.currentTimeMillis();
            }
        }
    }

    public int akV() {
        return this.cga;
    }
}
