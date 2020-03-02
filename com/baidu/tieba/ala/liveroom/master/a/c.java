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
                this.fgx.g(obj instanceof g ? ((g) obj).faP : null);
                this.eUa.faI.startRecord();
                this.eUa.faK.a((short) 2, null);
                return;
            case 2:
            default:
                return;
            case 3:
                if (i == 7 || i == 5) {
                    this.eUa.faK.a((short) 5, null);
                    return;
                } else {
                    this.eUa.faK.a((short) 2, null);
                    return;
                }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boU() {
        if (this.eUa != null && this.eUa.faK != null && this.mCurrentState != 4) {
            this.eUa.faK.a((short) 4, this.ffa);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aw(int i, String str) {
        if (i == 0) {
            this.eUa.faK.a((short) 3, null);
        } else if (this.fgx != null) {
            this.fgx.onError(i, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void i(short s) {
        super.i(s);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boV() {
        super.boV();
        if (TbadkCoreApplication.getInst().getResumeNum() <= 0 && this.eUa != null && this.eUa.faI != null) {
            this.eUa.faI.enterBackground();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boW() {
        super.boW();
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.eUa != null && c.this.eUa.faI != null) {
                    c.this.eUa.faI.enterForeground();
                }
            }
        });
    }
}
