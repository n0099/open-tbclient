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
    private static c aVT = new c();
    private boolean aVO;
    private int aVP;
    private long aVQ;
    private final SparseArray<a> aVR;
    private final HashSet<Integer> aVS;
    private int aVU;

    public static c Ld() {
        return aVT;
    }

    private c() {
        super(1001);
        this.aVP = 3;
        this.aVQ = ReportUserInfoModel.TIME_INTERVAL;
        this.aVR = new SparseArray<>();
        this.aVS = new HashSet<>();
        this.aVU = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean fw(int i) {
        this.aVU = 0;
        if (this.aVO) {
            this.aVU = 3;
            return false;
        } else if (this.aVS.contains(Integer.valueOf(i))) {
            this.aVU = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aVU = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().gQ() > PingManager.Lg().Li() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aVU = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aVR.get(i);
            if (aVar != null && aVar.aVW) {
                if (Math.abs(System.currentTimeMillis() - aVar.aVX) > this.aVQ) {
                    aVar.reset();
                } else {
                    this.aVU = 4;
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
            if (i2 < this.aVR.size()) {
                this.aVR.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void fx(int i) {
        a aVar = this.aVR.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aVR.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aVP);
        }
        this.aVU = 5;
    }

    public void fy(int i) {
        this.aVR.remove(i);
    }

    public void ch(boolean z) {
        this.aVO = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aVS.clear();
            for (int i : iArr) {
                this.aVS.add(Integer.valueOf(i));
            }
        }
    }

    public void fz(int i) {
        this.aVP = i;
    }

    public void an(long j) {
        this.aVQ = j;
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
        public int aVV;
        public boolean aVW;
        public long aVX;

        private a() {
        }

        public void reset() {
            this.aVV = 0;
            if (this.aVW) {
                this.aVW = false;
                this.aVX = 0L;
            }
        }

        public void onError(int i) {
            this.aVV++;
            if (!this.aVW && this.aVV >= i) {
                this.aVW = true;
                this.aVX = System.currentTimeMillis();
            }
        }
    }

    public int Le() {
        return this.aVU;
    }
}
