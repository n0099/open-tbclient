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
                this.fZJ.g(obj instanceof g ? ((g) obj).fTT : null);
                this.fNw.fTM.startRecord();
                this.fNw.fTO.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.fNw.fTO.a((short) 5, null);
                    return;
                } else {
                    this.fNw.fTO.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEx() {
        if (this.fNw != null && this.fNw.fTO != null && this.mCurrentState != 4) {
            this.fNw.fTO.a((short) 4, this.fYi);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aQ(int i, String str) {
        if (i == 0) {
            this.fNw.fTO.a((short) 3, null);
        } else if (this.fZJ != null) {
            this.fZJ.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEy() {
        super.bEy();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.fNw != null && this.fNw.fTM != null) {
            this.fNw.fTM.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEz() {
        super.bEz();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.fNw != null && c.this.fNw.fTM != null) {
                    c.this.fNw.fTM.enterForeground();
                }
            }
        });
    }
}
