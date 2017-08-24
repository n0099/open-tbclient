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
    private static c azz = new c();
    private int azA;
    private boolean azu;
    private int azv;
    private long azw;
    private final SparseArray<a> azx;
    private final HashSet<Integer> azy;

    public static c BZ() {
        return azz;
    }

    private c() {
        super(1001);
        this.azv = 3;
        this.azw = ReportUserInfoModel.TIME_INTERVAL;
        this.azx = new SparseArray<>();
        this.azy = new HashSet<>();
        this.azA = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eq(int i) {
        this.azA = 0;
        if (this.azu) {
            this.azA = 3;
            return false;
        } else if (this.azy.contains(Integer.valueOf(i))) {
            this.azA = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.azA = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().de() > PingManager.Cd().Cf() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.azA = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.azx.get(i);
            if (aVar != null && aVar.azC) {
                if (Math.abs(System.currentTimeMillis() - aVar.azD) > this.azw) {
                    aVar.reset();
                } else {
                    this.azA = 4;
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
            if (i2 < this.azx.size()) {
                this.azx.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void er(int i) {
        a aVar = this.azx.get(i);
        if (aVar == null) {
            aVar = new a();
            this.azx.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.azv);
        }
        this.azA = 5;
    }

    public void es(int i) {
        this.azx.remove(i);
    }

    public void bu(boolean z) {
        this.azu = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.azy.clear();
            for (int i : iArr) {
                this.azy.add(Integer.valueOf(i));
            }
        }
    }

    public void et(int i) {
        this.azv = i;
    }

    public void P(long j) {
        this.azw = j;
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
        public int azB;
        public boolean azC;
        public long azD;

        private a() {
        }

        public void reset() {
            this.azB = 0;
            if (this.azC) {
                this.azC = false;
                this.azD = 0L;
            }
        }

        public void onError(int i) {
            this.azB++;
            if (!this.azC && this.azB >= i) {
                this.azC = true;
                this.azD = System.currentTimeMillis();
            }
        }
    }

    public int Ca() {
        return this.azA;
    }
}
