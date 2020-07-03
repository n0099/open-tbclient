package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.tieba.ala.liveroom.data.f;
@Deprecated
/* loaded from: classes3.dex */
public class e extends a {
    public e(f fVar) {
        super(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void a(short s, Object obj) {
        super.a(s, obj);
        switch (s) {
            case 1:
                this.fYL.ggv.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bHD() {
        if (this.fYL != null && this.fYL.ggs != null) {
            if (this.gmI != null) {
                this.gmI.rJ(2);
            }
            this.fYL.ggs.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aU(int i, String str) {
        if (this.fYL != null && this.fYL.ggs.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.fYL != null && this.fYL.ggv != null && this.mCurrentState != 4) {
                    this.fYL.ggv.a((short) 4, this.glk);
                }
            } else if (this.gmH != null) {
                this.gmH.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bHE() {
        super.bHE();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bHF() {
        super.bHF();
    }
}
