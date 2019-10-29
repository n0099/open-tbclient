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
                this.dZB.efV.startRecord();
                this.dZB.efW.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.dZB.efW.a((short) 5, null);
                    return;
                } else {
                    this.dZB.efW.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUv() {
        if (this.dZB != null && this.dZB.efW != null && this.mCurrentState != 4) {
            this.dZB.efW.a((short) 4, this.ejR);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ac(int i, String str) {
        if (i == 0) {
            this.dZB.efW.a((short) 3, null);
        } else if (this.elb != null) {
            this.elb.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void g(short s) {
        super.g(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUw() {
        super.aUw();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.dZB != null && this.dZB.efV != null) {
            this.dZB.efV.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUx() {
        super.aUx();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.dZB != null && c.this.dZB.efV != null) {
                    c.this.dZB.efV.enterForeground();
                }
            }
        });
    }
}
