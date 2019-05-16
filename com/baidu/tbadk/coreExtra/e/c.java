package com.baidu.tbadk.coreExtra.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.c {
    private static c coj = new c();
    private boolean coe;
    private int cof;
    private long cog;
    private final SparseArray<a> coh;
    private final HashSet<Integer> coi;
    private int cok;

    public static c apU() {
        return coj;
    }

    private c() {
        super(1001);
        this.cof = 3;
        this.cog = ReportUserInfoModel.TIME_INTERVAL;
        this.coh = new SparseArray<>();
        this.coi = new HashSet<>();
        this.cok = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean jV(int i) {
        this.cok = 0;
        if (this.coe) {
            this.cok = 3;
            return false;
        } else if (this.coi.contains(Integer.valueOf(i))) {
            this.cok = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.cok = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().fG() > e.apX().apZ() + 20000) {
            com.baidu.adp.framework.client.socket.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.cok = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.coh.get(i);
            if (aVar != null && aVar.f4com) {
                if (Math.abs(System.currentTimeMillis() - aVar.con) > this.cog) {
                    aVar.reset();
                } else {
                    this.cok = 4;
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
            if (i2 < this.coh.size()) {
                this.coh.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void jW(int i) {
        a aVar = this.coh.get(i);
        if (aVar == null) {
            aVar = new a();
            this.coh.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.cof);
        }
        this.cok = 5;
    }

    public void jX(int i) {
        this.coh.remove(i);
    }

    public void eS(boolean z) {
        this.coe = z;
    }

    public void i(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.coi.clear();
            for (int i : iArr) {
                this.coi.add(Integer.valueOf(i));
            }
        }
    }

    public void jY(int i) {
        this.cof = i;
    }

    public void bf(long j) {
        this.cog = j;
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
        public int col;

        /* renamed from: com  reason: collision with root package name */
        public boolean f4com;
        public long con;

        private a() {
        }

        public void reset() {
            this.col = 0;
            if (this.f4com) {
                this.f4com = false;
                this.con = 0L;
            }
        }

        public void onError(int i) {
            this.col++;
            if (!this.f4com && this.col >= i) {
                this.f4com = true;
                this.con = System.currentTimeMillis();
            }
        }
    }

    public int apV() {
        return this.cok;
    }
}
