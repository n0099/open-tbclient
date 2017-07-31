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
    private static c azx = new c();
    private boolean azs;
    private int azt;
    private long azu;
    private final SparseArray<a> azv;
    private final HashSet<Integer> azw;
    private int azy;

    public static c BZ() {
        return azx;
    }

    private c() {
        super(1001);
        this.azt = 3;
        this.azu = ReportUserInfoModel.TIME_INTERVAL;
        this.azv = new SparseArray<>();
        this.azw = new HashSet<>();
        this.azy = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eq(int i) {
        this.azy = 0;
        if (this.azs) {
            this.azy = 3;
            return false;
        } else if (this.azw.contains(Integer.valueOf(i))) {
            this.azy = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.azy = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().de() > PingManager.Cd().Cf() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.azy = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.azv.get(i);
            if (aVar != null && aVar.azA) {
                if (Math.abs(System.currentTimeMillis() - aVar.azB) > this.azu) {
                    aVar.reset();
                } else {
                    this.azy = 4;
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
            if (i2 < this.azv.size()) {
                this.azv.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void er(int i) {
        a aVar = this.azv.get(i);
        if (aVar == null) {
            aVar = new a();
            this.azv.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.azt);
        }
        this.azy = 5;
    }

    public void es(int i) {
        this.azv.remove(i);
    }

    public void bu(boolean z) {
        this.azs = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.azw.clear();
            for (int i : iArr) {
                this.azw.add(Integer.valueOf(i));
            }
        }
    }

    public void et(int i) {
        this.azt = i;
    }

    public void P(long j) {
        this.azu = j;
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
        public boolean azA;
        public long azB;
        public int azz;

        private a() {
        }

        public void reset() {
            this.azz = 0;
            if (this.azA) {
                this.azA = false;
                this.azB = 0L;
            }
        }

        public void onError(int i) {
            this.azz++;
            if (!this.azA && this.azz >= i) {
                this.azA = true;
                this.azB = System.currentTimeMillis();
            }
        }
    }

    public int Ca() {
        return this.azy;
    }
}
