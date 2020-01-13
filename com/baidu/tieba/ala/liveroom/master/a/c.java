package com.baidu.tieba.ala.liveroom.master.a;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
/* loaded from: classes2.dex */
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
                this.eQi.eWS.startRecord();
                this.eQi.eWT.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.eQi.eWT.a((short) 5, null);
                    return;
                } else {
                    this.eQi.eWT.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bni() {
        if (this.eQi != null && this.eQi.eWT != null && this.mCurrentState != 4) {
            this.eQi.eWT.a((short) 4, this.fbR);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void av(int i, String str) {
        if (i == 0) {
            this.eQi.eWT.a((short) 3, null);
        } else if (this.fdn != null) {
            this.fdn.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void g(short s) {
        super.g(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bnj() {
        super.bnj();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.eQi != null && this.eQi.eWS != null) {
            this.eQi.eWS.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bnk() {
        super.bnk();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.eQi != null && c.this.eQi.eWS != null) {
                    c.this.eQi.eWS.enterForeground();
                }
            }
        });
    }
}
