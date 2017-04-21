package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.e {
    private static d awx = new d();
    private boolean aws;
    private int awt;
    private long awu;
    private final SparseArray<a> awv;
    private final HashSet<Integer> aww;
    private int awy;

    public static d Ch() {
        return awx;
    }

    private d() {
        super(1001);
        this.awt = 3;
        this.awu = ReportUserInfoModel.TIME_INTERVAL;
        this.awv = new SparseArray<>();
        this.aww = new HashSet<>();
        this.awy = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean el(int i) {
        this.awy = 0;
        if (this.aws) {
            this.awy = 3;
            return false;
        } else if (this.aww.contains(Integer.valueOf(i))) {
            this.awy = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.awy = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cT() > PingManager.Cl().Cn() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.awy = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.awv.get(i);
            if (aVar != null && aVar.awz) {
                if (Math.abs(System.currentTimeMillis() - aVar.awA) > this.awu) {
                    aVar.reset();
                } else {
                    this.awy = 4;
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
            if (i2 < this.awv.size()) {
                this.awv.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void em(int i) {
        a aVar = this.awv.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.awv.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.awt);
        }
        this.awy = 5;
    }

    public void en(int i) {
        this.awv.remove(i);
    }

    public void bu(boolean z) {
        this.aws = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aww.clear();
            for (int i : iArr) {
                this.aww.add(Integer.valueOf(i));
            }
        }
    }

    public void eo(int i) {
        this.awt = i;
    }

    public void M(long j) {
        this.awu = j;
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
        public long awA;
        public boolean awz;
        public int errorCount;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.errorCount = 0;
            if (this.awz) {
                this.awz = false;
                this.awA = 0L;
            }
        }

        public void onError(int i) {
            this.errorCount++;
            if (!this.awz && this.errorCount >= i) {
                this.awz = true;
                this.awA = System.currentTimeMillis();
            }
        }
    }

    public int Ci() {
        return this.awy;
    }
}
