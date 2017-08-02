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
    private static c ayg = new c();
    private boolean ayb;
    private int ayc;
    private long ayd;
    private final SparseArray<a> aye;
    private final HashSet<Integer> ayf;
    private int ayh;

    public static c BR() {
        return ayg;
    }

    private c() {
        super(1001);
        this.ayc = 3;
        this.ayd = ReportUserInfoModel.TIME_INTERVAL;
        this.aye = new SparseArray<>();
        this.ayf = new HashSet<>();
        this.ayh = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eo(int i) {
        this.ayh = 0;
        if (this.ayb) {
            this.ayh = 3;
            return false;
        } else if (this.ayf.contains(Integer.valueOf(i))) {
            this.ayh = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.ayh = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cT() > PingManager.BV().BX() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.ayh = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aye.get(i);
            if (aVar != null && aVar.ayj) {
                if (Math.abs(System.currentTimeMillis() - aVar.ayk) > this.ayd) {
                    aVar.reset();
                } else {
                    this.ayh = 4;
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
            if (i2 < this.aye.size()) {
                this.aye.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ep(int i) {
        a aVar = this.aye.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aye.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.ayc);
        }
        this.ayh = 5;
    }

    public void eq(int i) {
        this.aye.remove(i);
    }

    public void bu(boolean z) {
        this.ayb = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.ayf.clear();
            for (int i : iArr) {
                this.ayf.add(Integer.valueOf(i));
            }
        }
    }

    public void er(int i) {
        this.ayc = i;
    }

    public void P(long j) {
        this.ayd = j;
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
        public int ayi;
        public boolean ayj;
        public long ayk;

        private a() {
        }

        public void reset() {
            this.ayi = 0;
            if (this.ayj) {
                this.ayj = false;
                this.ayk = 0L;
            }
        }

        public void onError(int i) {
            this.ayi++;
            if (!this.ayj && this.ayi >= i) {
                this.ayj = true;
                this.ayk = System.currentTimeMillis();
            }
        }
    }

    public int BS() {
        return this.ayh;
    }
}
