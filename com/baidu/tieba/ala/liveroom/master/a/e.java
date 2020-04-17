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
                this.fze.fFE.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void byu() {
        if (this.fze != null && this.fze.fFC != null) {
            if (this.fLw != null) {
                this.fLw.qI(2);
            }
            this.fze.fFC.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aL(int i, String str) {
        if (this.fze != null && this.fze.fFC.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.fze != null && this.fze.fFE != null && this.mCurrentState != 4) {
                    this.fze.fFE.a((short) 4, this.fJU);
                }
            } else if (this.fLv != null) {
                this.fLv.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void byv() {
        super.byv();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void byw() {
        super.byw();
    }
}
