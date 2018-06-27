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
    private static c aJL = new c();
    private boolean aJG;
    private int aJH;
    private long aJI;
    private final SparseArray<a> aJJ;
    private final HashSet<Integer> aJK;
    private int aJM;

    public static c GB() {
        return aJL;
    }

    private c() {
        super(1001);
        this.aJH = 3;
        this.aJI = ReportUserInfoModel.TIME_INTERVAL;
        this.aJJ = new SparseArray<>();
        this.aJK = new HashSet<>();
        this.aJM = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ex(int i) {
        this.aJM = 0;
        if (this.aJG) {
            this.aJM = 3;
            return false;
        } else if (this.aJK.contains(Integer.valueOf(i))) {
            this.aJM = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aJM = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().fq() > PingManager.GF().GH() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aJM = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aJJ.get(i);
            if (aVar != null && aVar.aJO) {
                if (Math.abs(System.currentTimeMillis() - aVar.aJP) > this.aJI) {
                    aVar.reset();
                } else {
                    this.aJM = 4;
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
            if (i2 < this.aJJ.size()) {
                this.aJJ.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ey(int i) {
        a aVar = this.aJJ.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aJJ.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aJH);
        }
        this.aJM = 5;
    }

    public void ez(int i) {
        this.aJJ.remove(i);
    }

    public void bv(boolean z) {
        this.aJG = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aJK.clear();
            for (int i : iArr) {
                this.aJK.add(Integer.valueOf(i));
            }
        }
    }

    public void eA(int i) {
        this.aJH = i;
    }

    public void W(long j) {
        this.aJI = j;
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
        public int aJN;
        public boolean aJO;
        public long aJP;

        private a() {
        }

        public void reset() {
            this.aJN = 0;
            if (this.aJO) {
                this.aJO = false;
                this.aJP = 0L;
            }
        }

        public void onError(int i) {
            this.aJN++;
            if (!this.aJO && this.aJN >= i) {
                this.aJO = true;
                this.aJP = System.currentTimeMillis();
            }
        }
    }

    public int GC() {
        return this.aJM;
    }
}
