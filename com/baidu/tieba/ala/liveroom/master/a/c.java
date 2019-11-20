package com.baidu.tieba.ala.liveroom.master.a;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class c extends a {
    private final Handler mHandler;

    public c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        super(eVar);
        this.mHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void a(short s, Object obj) {
        int i = this.mCurrentState;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.dYK.efe.startRecord();
                this.dYK.eff.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.dYK.eff.a((short) 5, null);
                    return;
                } else {
                    this.dYK.eff.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUt() {
        if (this.dYK != null && this.dYK.eff != null && this.mCurrentState != 4) {
            this.dYK.eff.a((short) 4, this.eja);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ab(int i, String str) {
        if (i == 0) {
            this.dYK.eff.a((short) 3, null);
        } else if (this.ekk != null) {
            this.ekk.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void f(short s) {
        super.f(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUu() {
        super.aUu();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.dYK != null && this.dYK.efe != null) {
            this.dYK.efe.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUv() {
        super.aUv();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.dYK != null && c.this.dYK.efe != null) {
                    c.this.dYK.efe.enterForeground();
                }
            }
        });
    }
}
