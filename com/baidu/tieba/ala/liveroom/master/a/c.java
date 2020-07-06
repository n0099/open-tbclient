package com.baidu.tieba.ala.liveroom.master.a;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes3.dex */
public class c extends a {
    private final Handler mHandler;

    public c(f fVar) {
        super(fVar);
        this.mHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void a(short s, Object obj) {
        int i = this.mCurrentState;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.gmH.g(obj instanceof g ? ((g) obj).ggA : null);
                this.fYL.ggs.startRecord();
                this.fYL.ggv.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.fYL.ggv.a((short) 5, null);
                    return;
                } else {
                    this.fYL.ggv.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bHE() {
        if (this.fYL != null && this.fYL.ggv != null && this.mCurrentState != 4) {
            this.fYL.ggv.a((short) 4, this.glk);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aU(int i, String str) {
        if (i == 0) {
            this.fYL.ggv.a((short) 3, null);
        } else if (this.gmH != null) {
            this.gmH.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bHF() {
        super.bHF();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.fYL != null && this.fYL.ggs != null) {
            this.fYL.ggs.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bHG() {
        super.bHG();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.fYL != null && c.this.fYL.ggs != null) {
                    c.this.fYL.ggs.enterForeground();
                }
            }
        });
    }
}
