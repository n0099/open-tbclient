package com.baidu.tieba.ala.liveroom.master.a;

import android.os.Handler;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes4.dex */
public class c extends a {
    private final Handler mHandler;

    public c(f fVar) {
        super(fVar);
        this.mHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void a(short s, Object obj) {
        int i = this.cdn;
        super.a(s, obj);
        switch (s) {
            case 1:
                this.hiq.g(obj instanceof g ? ((g) obj).hbi : null);
                this.gTF.hba.startRecord();
                this.gTF.hbd.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.gTF.hbd.a((short) 5, null);
                    return;
                } else {
                    this.gTF.hbd.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ccX() {
        if (this.gTF != null && this.gTF.hbd != null && this.cdn != 4) {
            this.gTF.hbd.a((short) 4, this.hgT);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bg(int i, String str) {
        if (i == 0) {
            this.gTF.hbd.a((short) 3, null);
        } else if (this.hiq != null) {
            this.hiq.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void j(short s) {
        super.j(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ccY() {
        super.ccY();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.gTF != null && this.gTF.hba != null) {
            this.gTF.hba.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ccZ() {
        super.ccZ();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.gTF != null && c.this.gTF.hba != null) {
                    c.this.gTF.hba.enterForeground();
                }
            }
        });
    }
}
