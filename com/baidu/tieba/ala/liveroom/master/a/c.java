package com.baidu.tieba.ala.liveroom.master.a;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
/* loaded from: classes4.dex */
public class c extends a {
    private final Handler mHandler;

    public c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        super(eVar);
        this.mHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void a(short s, Object obj) {
        int i = this.cnU;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.hxx.g(obj instanceof f ? ((f) obj).hqt : null);
                this.hjc.hqk.startRecord();
                this.hjc.hqo.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.hjc.hqo.a((short) 5, null);
                    return;
                } else {
                    this.hjc.hqo.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ciO() {
        if (this.hjc != null && this.hjc.hqo != null && this.cnU != 4) {
            this.hjc.hqo.a((short) 4, this.hwb);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bi(int i, String str) {
        if (i == 0) {
            this.hjc.hqo.a((short) 3, null);
        } else if (this.hxx != null) {
            this.hxx.onError(i, str);
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
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.hjc != null && this.hjc.hqk != null) {
            this.hjc.hqk.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void markEnterForeground() {
        super.markEnterForeground();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hjc != null && c.this.hjc.hqk != null) {
                    c.this.hjc.hqk.enterForeground();
                }
            }
        });
    }
}
