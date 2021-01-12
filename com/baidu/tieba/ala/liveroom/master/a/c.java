package com.baidu.tieba.ala.liveroom.master.a;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
/* loaded from: classes10.dex */
public class c extends a {
    private final Handler mHandler;

    public c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        super(eVar);
        this.mHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void a(short s, Object obj) {
        int i = this.cqj;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.hEP.g(obj instanceof f ? ((f) obj).hxJ : null);
                this.hqr.hxA.startRecord();
                this.hqr.hxE.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.hqr.hxE.a((short) 5, null);
                    return;
                } else {
                    this.hqr.hxE.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void chJ() {
        if (this.hqr != null && this.hqr.hxE != null && this.cqj != 4) {
            this.hqr.hxE.a((short) 4, this.hDt);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bl(int i, String str) {
        if (i == 0) {
            this.hqr.hxE.a((short) 3, null);
        } else if (this.hEP != null) {
            this.hEP.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void j(short s) {
        super.j(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void markEnterBackground() {
        super.markEnterBackground();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.hqr != null && this.hqr.hxA != null) {
            this.hqr.hxA.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void markEnterForeground() {
        super.markEnterForeground();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hqr != null && c.this.hqr.hxA != null) {
                    c.this.hqr.hxA.enterForeground();
                }
            }
        });
    }
}
