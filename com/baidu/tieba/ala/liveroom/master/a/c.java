package com.baidu.tieba.ala.liveroom.master.a;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes7.dex */
public class c extends a {
    private final Handler mHandler;

    public c(f fVar) {
        super(fVar);
        this.mHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void a(short s, Object obj) {
        int i = this.bMf;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.gED.g(obj instanceof g ? ((g) obj).gxQ : null);
                this.gqf.gxI.startRecord();
                this.gqf.gxL.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.gqf.gxL.a((short) 5, null);
                    return;
                } else {
                    this.gqf.gxL.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUO() {
        if (this.gqf != null && this.gqf.gxL != null && this.bMf != 4) {
            this.gqf.gxL.a((short) 4, this.gDf);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aT(int i, String str) {
        if (i == 0) {
            this.gqf.gxL.a((short) 3, null);
        } else if (this.gED != null) {
            this.gED.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUP() {
        super.bUP();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.gqf != null && this.gqf.gxI != null) {
            this.gqf.gxI.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUQ() {
        super.bUQ();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.gqf != null && c.this.gqf.gxI != null) {
                    c.this.gqf.gxI.enterForeground();
                }
            }
        });
    }
}
