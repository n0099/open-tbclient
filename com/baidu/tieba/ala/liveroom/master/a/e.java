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
                this.fzj.fFJ.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bys() {
        if (this.fzj != null && this.fzj.fFH != null) {
            if (this.fLB != null) {
                this.fLB.qI(2);
            }
            this.fzj.fFH.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aL(int i, String str) {
        if (this.fzj != null && this.fzj.fFH.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.fzj != null && this.fzj.fFJ != null && this.mCurrentState != 4) {
                    this.fzj.fFJ.a((short) 4, this.fJZ);
                }
            } else if (this.fLA != null) {
                this.fLA.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void byt() {
        super.byt();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void byu() {
        super.byu();
    }
}
