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
                this.fNw.fTO.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEx() {
        if (this.fNw != null && this.fNw.fTM != null) {
            if (this.fZK != null) {
                this.fZK.rl(2);
            }
            this.fNw.fTM.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aQ(int i, String str) {
        if (this.fNw != null && this.fNw.fTM.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.fNw != null && this.fNw.fTO != null && this.mCurrentState != 4) {
                    this.fNw.fTO.a((short) 4, this.fYi);
                }
            } else if (this.fZJ != null) {
                this.fZJ.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEy() {
        super.bEy();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bEz() {
        super.bEz();
    }
}
