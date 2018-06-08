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
    private static c aIO = new c();
    private boolean aIJ;
    private int aIK;
    private long aIL;
    private final SparseArray<a> aIM;
    private final HashSet<Integer> aIN;
    private int aIP;

    public static c Gj() {
        return aIO;
    }

    private c() {
        super(1001);
        this.aIK = 3;
        this.aIL = ReportUserInfoModel.TIME_INTERVAL;
        this.aIM = new SparseArray<>();
        this.aIN = new HashSet<>();
        this.aIP = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ew(int i) {
        this.aIP = 0;
        if (this.aIJ) {
            this.aIP = 3;
            return false;
        } else if (this.aIN.contains(Integer.valueOf(i))) {
            this.aIP = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aIP = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().fq() > PingManager.Gn().Gp() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aIP = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aIM.get(i);
            if (aVar != null && aVar.aIR) {
                if (Math.abs(System.currentTimeMillis() - aVar.aIS) > this.aIL) {
                    aVar.reset();
                } else {
                    this.aIP = 4;
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
            if (i2 < this.aIM.size()) {
                this.aIM.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ex(int i) {
        a aVar = this.aIM.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aIM.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aIK);
        }
        this.aIP = 5;
    }

    public void ey(int i) {
        this.aIM.remove(i);
    }

    public void bs(boolean z) {
        this.aIJ = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aIN.clear();
            for (int i : iArr) {
                this.aIN.add(Integer.valueOf(i));
            }
        }
    }

    public void ez(int i) {
        this.aIK = i;
    }

    public void V(long j) {
        this.aIL = j;
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
        public int aIQ;
        public boolean aIR;
        public long aIS;

        private a() {
        }

        public void reset() {
            this.aIQ = 0;
            if (this.aIR) {
                this.aIR = false;
                this.aIS = 0L;
            }
        }

        public void onError(int i) {
            this.aIQ++;
            if (!this.aIR && this.aIQ >= i) {
                this.aIR = true;
                this.aIS = System.currentTimeMillis();
            }
        }
    }

    public int Gk() {
        return this.aIP;
    }
}
