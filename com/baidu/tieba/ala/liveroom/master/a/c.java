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
        int i = this.bGB;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.grF.g(obj instanceof g ? ((g) obj).glI : null);
                this.gdS.glA.startRecord();
                this.gdS.glD.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.gdS.glD.a((short) 5, null);
                    return;
                } else {
                    this.gdS.glD.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bKK() {
        if (this.gdS != null && this.gdS.glD != null && this.bGB != 4) {
            this.gdS.glD.a((short) 4, this.gqi);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aW(int i, String str) {
        if (i == 0) {
            this.gdS.glD.a((short) 3, null);
        } else if (this.grF != null) {
            this.grF.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bKL() {
        super.bKL();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.gdS != null && this.gdS.glA != null) {
            this.gdS.glA.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bKM() {
        super.bKM();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.gdS != null && c.this.gdS.glA != null) {
                    c.this.gdS.glA.enterForeground();
                }
            }
        });
    }
}
