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
    private static c azy = new c();
    private boolean azt;
    private int azu;
    private long azv;
    private final SparseArray<a> azw;
    private final HashSet<Integer> azx;
    private int azz;

    public static c BZ() {
        return azy;
    }

    private c() {
        super(1001);
        this.azu = 3;
        this.azv = ReportUserInfoModel.TIME_INTERVAL;
        this.azw = new SparseArray<>();
        this.azx = new HashSet<>();
        this.azz = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eq(int i) {
        this.azz = 0;
        if (this.azt) {
            this.azz = 3;
            return false;
        } else if (this.azx.contains(Integer.valueOf(i))) {
            this.azz = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.azz = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().de() > PingManager.Cd().Cf() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.azz = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.azw.get(i);
            if (aVar != null && aVar.azB) {
                if (Math.abs(System.currentTimeMillis() - aVar.azC) > this.azv) {
                    aVar.reset();
                } else {
                    this.azz = 4;
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
            if (i2 < this.azw.size()) {
                this.azw.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void er(int i) {
        a aVar = this.azw.get(i);
        if (aVar == null) {
            aVar = new a();
            this.azw.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.azu);
        }
        this.azz = 5;
    }

    public void es(int i) {
        this.azw.remove(i);
    }

    public void bu(boolean z) {
        this.azt = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.azx.clear();
            for (int i : iArr) {
                this.azx.add(Integer.valueOf(i));
            }
        }
    }

    public void et(int i) {
        this.azu = i;
    }

    public void P(long j) {
        this.azv = j;
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
        public int azA;
        public boolean azB;
        public long azC;

        private a() {
        }

        public void reset() {
            this.azA = 0;
            if (this.azB) {
                this.azB = false;
                this.azC = 0L;
            }
        }

        public void onError(int i) {
            this.azA++;
            if (!this.azB && this.azA >= i) {
                this.azB = true;
                this.azC = System.currentTimeMillis();
            }
        }
    }

    public int Ca() {
        return this.azz;
    }
}
