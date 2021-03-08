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
        int i = this.eBs;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.hKY.g(obj instanceof f ? ((f) obj).hDQ : null);
                this.hwy.hDH.startRecord();
                this.hwy.hDL.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.hwy.hDL.a((short) 5, null);
                    return;
                } else {
                    this.hwy.hDL.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ciP() {
        if (this.hwy != null && this.hwy.hDL != null && this.eBs != 4) {
            this.hwy.hDL.a((short) 4, this.hJD);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bq(int i, String str) {
        if (i == 0) {
            this.hwy.hDL.a((short) 3, null);
        } else if (this.hKY != null) {
            this.hKY.onError(i, str);
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
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.hwy != null && this.hwy.hDH != null) {
            this.hwy.hDH.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void markEnterForeground() {
        super.markEnterForeground();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hwy != null && c.this.hwy.hDH != null) {
                    c.this.hwy.hDH.enterForeground();
                }
            }
        });
    }
}
