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
                this.fgw.g(obj instanceof g ? ((g) obj).faO : null);
                this.eTZ.faH.startRecord();
                this.eTZ.faJ.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.eTZ.faJ.a((short) 5, null);
                    return;
                } else {
                    this.eTZ.faJ.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boS() {
        if (this.eTZ != null && this.eTZ.faJ != null && this.mCurrentState != 4) {
            this.eTZ.faJ.a((short) 4, this.feZ);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aw(int i, String str) {
        if (i == 0) {
            this.eTZ.faJ.a((short) 3, null);
        } else if (this.fgw != null) {
            this.fgw.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boT() {
        super.boT();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.eTZ != null && this.eTZ.faH != null) {
            this.eTZ.faH.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boU() {
        super.boU();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.eTZ != null && c.this.eTZ.faH != null) {
                    c.this.eTZ.faH.enterForeground();
                }
            }
        });
    }
}
