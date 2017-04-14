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
    private static d awv = new d();
    private boolean awq;
    private int awr;
    private long aws;
    private final SparseArray<a> awt;
    private final HashSet<Integer> awu;
    private int aww;

    public static d Ch() {
        return awv;
    }

    private d() {
        super(1001);
        this.awr = 3;
        this.aws = ReportUserInfoModel.TIME_INTERVAL;
        this.awt = new SparseArray<>();
        this.awu = new HashSet<>();
        this.aww = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean el(int i) {
        this.aww = 0;
        if (this.awq) {
            this.aww = 3;
            return false;
        } else if (this.awu.contains(Integer.valueOf(i))) {
            this.aww = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aww = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cT() > PingManager.Cl().Cn() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aww = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.awt.get(i);
            if (aVar != null && aVar.awx) {
                if (Math.abs(System.currentTimeMillis() - aVar.awy) > this.aws) {
                    aVar.reset();
                } else {
                    this.aww = 4;
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
            if (i2 < this.awt.size()) {
                this.awt.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void em(int i) {
        a aVar = this.awt.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.awt.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.awr);
        }
        this.aww = 5;
    }

    public void en(int i) {
        this.awt.remove(i);
    }

    public void bu(boolean z) {
        this.awq = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.awu.clear();
            for (int i : iArr) {
                this.awu.add(Integer.valueOf(i));
            }
        }
    }

    public void eo(int i) {
        this.awr = i;
    }

    public void M(long j) {
        this.aws = j;
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
        public boolean awx;
        public long awy;
        public int errorCount;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.errorCount = 0;
            if (this.awx) {
                this.awx = false;
                this.awy = 0L;
            }
        }

        public void onError(int i) {
            this.errorCount++;
            if (!this.awx && this.errorCount >= i) {
                this.awx = true;
                this.awy = System.currentTimeMillis();
            }
        }
    }

    public int Ci() {
        return this.aww;
    }
}
