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
                this.fNl.fTD.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEv() {
        if (this.fNl != null && this.fNl.fTB != null) {
            if (this.fZz != null) {
                this.fZz.rj(2);
            }
            this.fNl.fTB.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aQ(int i, String str) {
        if (this.fNl != null && this.fNl.fTB.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.fNl != null && this.fNl.fTD != null && this.mCurrentState != 4) {
                    this.fNl.fTD.a((short) 4, this.fXX);
                }
            } else if (this.fZy != null) {
                this.fZy.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEw() {
        super.bEw();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEx() {
        super.bEx();
    }
}
