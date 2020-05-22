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
                this.fZy.g(obj instanceof g ? ((g) obj).fTI : null);
                this.fNl.fTB.startRecord();
                this.fNl.fTD.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.fNl.fTD.a((short) 5, null);
                    return;
                } else {
                    this.fNl.fTD.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEv() {
        if (this.fNl != null && this.fNl.fTD != null && this.mCurrentState != 4) {
            this.fNl.fTD.a((short) 4, this.fXX);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aQ(int i, String str) {
        if (i == 0) {
            this.fNl.fTD.a((short) 3, null);
        } else if (this.fZy != null) {
            this.fZy.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEw() {
        super.bEw();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.fNl != null && this.fNl.fTB != null) {
            this.fNl.fTB.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEx() {
        super.bEx();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.fNl != null && c.this.fNl.fTB != null) {
                    c.this.fNl.fTB.enterForeground();
                }
            }
        });
    }
}
