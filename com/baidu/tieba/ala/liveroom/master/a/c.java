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
                this.fhj.g(obj instanceof g ? ((g) obj).fbA : null);
                this.eUL.fbt.startRecord();
                this.eUL.fbv.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.eUL.fbv.a((short) 5, null);
                    return;
                } else {
                    this.eUL.fbv.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bpa() {
        if (this.eUL != null && this.eUL.fbv != null && this.mCurrentState != 4) {
            this.eUL.fbv.a((short) 4, this.ffM);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aw(int i, String str) {
        if (i == 0) {
            this.eUL.fbv.a((short) 3, null);
        } else if (this.fhj != null) {
            this.fhj.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bpb() {
        super.bpb();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.eUL != null && this.eUL.fbt != null) {
            this.eUL.fbt.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bpc() {
        super.bpc();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.eUL != null && c.this.eUL.fbt != null) {
                    c.this.eUL.fbt.enterForeground();
                }
            }
        });
    }
}
