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
        int i = this.bMb;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.gEz.g(obj instanceof g ? ((g) obj).gxM : null);
                this.gqb.gxE.startRecord();
                this.gqb.gxH.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.gqb.gxH.a((short) 5, null);
                    return;
                } else {
                    this.gqb.gxH.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUN() {
        if (this.gqb != null && this.gqb.gxH != null && this.bMb != 4) {
            this.gqb.gxH.a((short) 4, this.gDb);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aU(int i, String str) {
        if (i == 0) {
            this.gqb.gxH.a((short) 3, null);
        } else if (this.gEz != null) {
            this.gEz.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUO() {
        super.bUO();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.gqb != null && this.gqb.gxE != null) {
            this.gqb.gxE.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUP() {
        super.bUP();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.gqb != null && c.this.gqb.gxE != null) {
                    c.this.gqb.gxE.enterForeground();
                }
            }
        });
    }
}
