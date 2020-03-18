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
                this.eUL.fbv.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bpa() {
        if (this.eUL != null && this.eUL.fbt != null) {
            if (this.fhk != null) {
                this.fhk.qp(2);
            }
            this.eUL.fbt.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aw(int i, String str) {
        if (this.eUL != null && this.eUL.fbt.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.eUL != null && this.eUL.fbv != null && this.mCurrentState != 4) {
                    this.eUL.fbv.a((short) 4, this.ffM);
                }
            } else if (this.fhj != null) {
                this.fhj.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bpb() {
        super.bpb();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bpc() {
        super.bpc();
    }
}
