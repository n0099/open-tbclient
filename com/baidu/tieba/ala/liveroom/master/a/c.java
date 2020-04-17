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
                this.fLv.g(obj instanceof g ? ((g) obj).fFJ : null);
                this.fze.fFC.startRecord();
                this.fze.fFE.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.fze.fFE.a((short) 5, null);
                    return;
                } else {
                    this.fze.fFE.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void byu() {
        if (this.fze != null && this.fze.fFE != null && this.mCurrentState != 4) {
            this.fze.fFE.a((short) 4, this.fJU);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aL(int i, String str) {
        if (i == 0) {
            this.fze.fFE.a((short) 3, null);
        } else if (this.fLv != null) {
            this.fLv.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void byv() {
        super.byv();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.fze != null && this.fze.fFC != null) {
            this.fze.fFC.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void byw() {
        super.byw();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.fze != null && c.this.fze.fFC != null) {
                    c.this.fze.fFC.enterForeground();
                }
            }
        });
    }
}
