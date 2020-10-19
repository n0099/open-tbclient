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
        int i = this.bUO;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.gWA.g(obj instanceof g ? ((g) obj).gPu : null);
                this.gHQ.gPm.startRecord();
                this.gHQ.gPp.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.gHQ.gPp.a((short) 5, null);
                    return;
                } else {
                    this.gHQ.gPp.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bZT() {
        if (this.gHQ != null && this.gHQ.gPp != null && this.bUO != 4) {
            this.gHQ.gPp.a((short) 4, this.gVf);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void be(int i, String str) {
        if (i == 0) {
            this.gHQ.gPp.a((short) 3, null);
        } else if (this.gWA != null) {
            this.gWA.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bZU() {
        super.bZU();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.gHQ != null && this.gHQ.gPm != null) {
            this.gHQ.gPm.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bZV() {
        super.bZV();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.gHQ != null && c.this.gHQ.gPm != null) {
                    c.this.gHQ.gPm.enterForeground();
                }
            }
        });
    }
}
