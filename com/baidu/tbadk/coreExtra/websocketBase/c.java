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
    private static c aSw = new c();
    private boolean aSr;
    private int aSs;
    private long aSt;
    private final SparseArray<a> aSu;
    private final HashSet<Integer> aSv;
    private int aSx;

    public static c JZ() {
        return aSw;
    }

    private c() {
        super(1001);
        this.aSs = 3;
        this.aSt = ReportUserInfoModel.TIME_INTERVAL;
        this.aSu = new SparseArray<>();
        this.aSv = new HashSet<>();
        this.aSx = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean fi(int i) {
        this.aSx = 0;
        if (this.aSr) {
            this.aSx = 3;
            return false;
        } else if (this.aSv.contains(Integer.valueOf(i))) {
            this.aSx = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aSx = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().gQ() > PingManager.Kc().Ke() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aSx = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aSu.get(i);
            if (aVar != null && aVar.aSz) {
                if (Math.abs(System.currentTimeMillis() - aVar.aSA) > this.aSt) {
                    aVar.reset();
                } else {
                    this.aSx = 4;
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
            if (i2 < this.aSu.size()) {
                this.aSu.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void fj(int i) {
        a aVar = this.aSu.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aSu.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aSs);
        }
        this.aSx = 5;
    }

    public void fk(int i) {
        this.aSu.remove(i);
    }

    public void cg(boolean z) {
        this.aSr = z;
    }

    public void h(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aSv.clear();
            for (int i : iArr) {
                this.aSv.add(Integer.valueOf(i));
            }
        }
    }

    public void fl(int i) {
        this.aSs = i;
    }

    public void ag(long j) {
        this.aSt = j;
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
        public long aSA;
        public int aSy;
        public boolean aSz;

        private a() {
        }

        public void reset() {
            this.aSy = 0;
            if (this.aSz) {
                this.aSz = false;
                this.aSA = 0L;
            }
        }

        public void onError(int i) {
            this.aSy++;
            if (!this.aSz && this.aSy >= i) {
                this.aSz = true;
                this.aSA = System.currentTimeMillis();
            }
        }
    }

    public int Ka() {
        return this.aSx;
    }
}
