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
        int i = this.ciY;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.hoh.g(obj instanceof f ? ((f) obj).hhd : null);
                this.gZK.hgU.startRecord();
                this.gZK.hgY.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.gZK.hgY.a((short) 5, null);
                    return;
                } else {
                    this.gZK.hgY.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void cfy() {
        if (this.gZK != null && this.gZK.hgY != null && this.ciY != 4) {
            this.gZK.hgY.a((short) 4, this.hmQ);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bk(int i, String str) {
        if (i == 0) {
            this.gZK.hgY.a((short) 3, null);
        } else if (this.hoh != null) {
            this.hoh.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void j(short s) {
        super.j(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void cfz() {
        super.cfz();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.gZK != null && this.gZK.hgU != null) {
            this.gZK.hgU.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void cfA() {
        super.cfA();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.gZK != null && c.this.gZK.hgU != null) {
                    c.this.gZK.hgU.enterForeground();
                }
            }
        });
    }
}
