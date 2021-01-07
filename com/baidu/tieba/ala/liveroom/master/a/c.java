package com.baidu.tieba.ala.liveroom.master.a;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
/* loaded from: classes11.dex */
public class c extends a {
    private final Handler mHandler;

    public c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        super(eVar);
        this.mHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void a(short s, Object obj) {
        int i = this.cvb;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.hJv.g(obj instanceof f ? ((f) obj).hCp : null);
                this.huX.hCg.startRecord();
                this.huX.hCk.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.huX.hCk.a((short) 5, null);
                    return;
                } else {
                    this.huX.hCk.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void clB() {
        if (this.huX != null && this.huX.hCk != null && this.cvb != 4) {
            this.huX.hCk.a((short) 4, this.hHZ);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bk(int i, String str) {
        if (i == 0) {
            this.huX.hCk.a((short) 3, null);
        } else if (this.hJv != null) {
            this.hJv.onError(i, str);
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
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.huX != null && this.huX.hCg != null) {
            this.huX.hCg.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void markEnterForeground() {
        super.markEnterForeground();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.huX != null && c.this.huX.hCg != null) {
                    c.this.huX.hCg.enterForeground();
                }
            }
        });
    }
}
