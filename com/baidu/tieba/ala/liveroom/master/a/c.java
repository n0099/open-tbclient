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
        int i = this.chm;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.hnO.g(obj instanceof f ? ((f) obj).hgK : null);
                this.gZr.hgB.startRecord();
                this.gZr.hgF.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.gZr.hgF.a((short) 5, null);
                    return;
                } else {
                    this.gZr.hgF.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ceR() {
        if (this.gZr != null && this.gZr.hgF != null && this.chm != 4) {
            this.gZr.hgF.a((short) 4, this.hmx);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bi(int i, String str) {
        if (i == 0) {
            this.gZr.hgF.a((short) 3, null);
        } else if (this.hnO != null) {
            this.hnO.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void j(short s) {
        super.j(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ceS() {
        super.ceS();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.gZr != null && this.gZr.hgB != null) {
            this.gZr.hgB.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ceT() {
        super.ceT();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.gZr != null && c.this.gZr.hgB != null) {
                    c.this.gZr.hgB.enterForeground();
                }
            }
        });
    }
}
