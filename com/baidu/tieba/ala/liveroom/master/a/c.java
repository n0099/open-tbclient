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
                this.fgK.g(obj instanceof g ? ((g) obj).fbc : null);
                this.eUn.faV.startRecord();
                this.eUn.faX.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.eUn.faX.a((short) 5, null);
                    return;
                } else {
                    this.eUn.faX.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boV() {
        if (this.eUn != null && this.eUn.faX != null && this.mCurrentState != 4) {
            this.eUn.faX.a((short) 4, this.ffn);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aw(int i, String str) {
        if (i == 0) {
            this.eUn.faX.a((short) 3, null);
        } else if (this.fgK != null) {
            this.fgK.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boW() {
        super.boW();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.eUn != null && this.eUn.faV != null) {
            this.eUn.faV.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boX() {
        super.boX();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.eUn != null && c.this.eUn.faV != null) {
                    c.this.eUn.faV.enterForeground();
                }
            }
        });
    }
}
