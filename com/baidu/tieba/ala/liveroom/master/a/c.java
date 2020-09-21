package com.baidu.tieba.ala.liveroom.master.a;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes4.dex */
public class c extends a {
    private final Handler mHandler;

    public c(f fVar) {
        super(fVar);
        this.mHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void a(short s, Object obj) {
        int i = this.bOf;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.gIa.g(obj instanceof g ? ((g) obj).gBb : null);
                this.gtv.gAT.startRecord();
                this.gtv.gAW.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.gtv.gAW.a((short) 5, null);
                    return;
                } else {
                    this.gtv.gAW.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bWy() {
        if (this.gtv != null && this.gtv.gAW != null && this.bOf != 4) {
            this.gtv.gAW.a((short) 4, this.gGG);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aU(int i, String str) {
        if (i == 0) {
            this.gtv.gAW.a((short) 3, null);
        } else if (this.gIa != null) {
            this.gIa.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bWz() {
        super.bWz();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.gtv != null && this.gtv.gAT != null) {
            this.gtv.gAT.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bWA() {
        super.bWA();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.gtv != null && c.this.gtv.gAT != null) {
                    c.this.gtv.gAT.enterForeground();
                }
            }
        });
    }
}
