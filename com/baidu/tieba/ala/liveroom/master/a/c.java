package com.baidu.tieba.ala.liveroom.master.a;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
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
                this.eOH.eUY.startRecord();
                this.eOH.eUZ.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.eOH.eUZ.a((short) 5, null);
                    return;
                } else {
                    this.eOH.eUZ.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bmk() {
        if (this.eOH != null && this.eOH.eUZ != null && this.mCurrentState != 4) {
            this.eOH.eUZ.a((short) 4, this.eZl);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aq(int i, String str) {
        if (i == 0) {
            this.eOH.eUZ.a((short) 3, null);
        } else if (this.faz != null) {
            this.faz.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void g(short s) {
        super.g(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bml() {
        super.bml();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.eOH != null && this.eOH.eUY != null) {
            this.eOH.eUY.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bmm() {
        super.bmm();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.eOH != null && c.this.eOH.eUY != null) {
                    c.this.eOH.eUY.enterForeground();
                }
            }
        });
    }
}
