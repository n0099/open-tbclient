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
    private static c aVW = new c();
    private boolean aVR;
    private int aVS;
    private long aVT;
    private final SparseArray<a> aVU;
    private final HashSet<Integer> aVV;
    private int aVX;

    public static c Le() {
        return aVW;
    }

    private c() {
        super(1001);
        this.aVS = 3;
        this.aVT = ReportUserInfoModel.TIME_INTERVAL;
        this.aVU = new SparseArray<>();
        this.aVV = new HashSet<>();
        this.aVX = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean fx(int i) {
        this.aVX = 0;
        if (this.aVR) {
            this.aVX = 3;
            return false;
        } else if (this.aVV.contains(Integer.valueOf(i))) {
            this.aVX = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aVX = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().gQ() > PingManager.Lh().Lj() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aVX = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aVU.get(i);
            if (aVar != null && aVar.aVZ) {
                if (Math.abs(System.currentTimeMillis() - aVar.aWa) > this.aVT) {
                    aVar.reset();
                } else {
                    this.aVX = 4;
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
            if (i2 < this.aVU.size()) {
                this.aVU.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void fy(int i) {
        a aVar = this.aVU.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aVU.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aVS);
        }
        this.aVX = 5;
    }

    public void fz(int i) {
        this.aVU.remove(i);
    }

    public void ch(boolean z) {
        this.aVR = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aVV.clear();
            for (int i : iArr) {
                this.aVV.add(Integer.valueOf(i));
            }
        }
    }

    public void fA(int i) {
        this.aVS = i;
    }

    public void ao(long j) {
        this.aVT = j;
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
        public int aVY;
        public boolean aVZ;
        public long aWa;

        private a() {
        }

        public void reset() {
            this.aVY = 0;
            if (this.aVZ) {
                this.aVZ = false;
                this.aWa = 0L;
            }
        }

        public void onError(int i) {
            this.aVY++;
            if (!this.aVZ && this.aVY >= i) {
                this.aVZ = true;
                this.aWa = System.currentTimeMillis();
            }
        }
    }

    public int Lf() {
        return this.aVX;
    }
}
