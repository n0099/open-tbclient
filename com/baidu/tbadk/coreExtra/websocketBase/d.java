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
    private static d awl = new d();
    private boolean awg;
    private int awh;
    private long awi;
    private final SparseArray<a> awj;
    private final HashSet<Integer> awk;
    private int awm;

    public static d Bl() {
        return awl;
    }

    private d() {
        super(1001);
        this.awh = 3;
        this.awi = ReportUserInfoModel.TIME_INTERVAL;
        this.awj = new SparseArray<>();
        this.awk = new HashSet<>();
        this.awm = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ek(int i) {
        this.awm = 0;
        if (this.awg) {
            this.awm = 3;
            return false;
        } else if (this.awk.contains(Integer.valueOf(i))) {
            this.awm = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.awm = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cT() > PingManager.Bp().Br() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.awm = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.awj.get(i);
            if (aVar != null && aVar.awo) {
                if (Math.abs(System.currentTimeMillis() - aVar.awp) > this.awi) {
                    aVar.reset();
                } else {
                    this.awm = 4;
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
            if (i2 < this.awj.size()) {
                this.awj.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void el(int i) {
        a aVar = this.awj.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.awj.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.awh);
        }
        this.awm = 5;
    }

    public void em(int i) {
        this.awj.remove(i);
    }

    public void br(boolean z) {
        this.awg = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.awk.clear();
            for (int i : iArr) {
                this.awk.add(Integer.valueOf(i));
            }
        }
    }

    public void en(int i) {
        this.awh = i;
    }

    public void N(long j) {
        this.awi = j;
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
        public int awn;
        public boolean awo;
        public long awp;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.awn = 0;
            if (this.awo) {
                this.awo = false;
                this.awp = 0L;
            }
        }

        public void onError(int i) {
            this.awn++;
            if (!this.awo && this.awn >= i) {
                this.awo = true;
                this.awp = System.currentTimeMillis();
            }
        }
    }

    public int Bm() {
        return this.awm;
    }
}
