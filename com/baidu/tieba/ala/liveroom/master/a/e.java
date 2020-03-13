package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.tieba.ala.liveroom.data.f;
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
                this.eUn.faX.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boV() {
        if (this.eUn != null && this.eUn.faV != null) {
            if (this.fgL != null) {
                this.fgL.qn(2);
            }
            this.eUn.faV.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aw(int i, String str) {
        if (this.eUn != null && this.eUn.faV.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.eUn != null && this.eUn.faX != null && this.mCurrentState != 4) {
                    this.eUn.faX.a((short) 4, this.ffn);
                }
            } else if (this.fgK != null) {
                this.fgK.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boW() {
        super.boW();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boX() {
        super.boX();
    }
}
