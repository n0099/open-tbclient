package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.tieba.ala.liveroom.data.f;
/* loaded from: classes2.dex */
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
                this.eQi.eWT.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bni() {
        if (this.eQi != null && this.eQi.eWS != null) {
            if (this.fdo != null) {
                this.fdo.qf(2);
            }
            this.eQi.eWS.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void av(int i, String str) {
        if (this.eQi != null && this.eQi.eWS.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.eQi != null && this.eQi.eWT != null && this.mCurrentState != 4) {
                    this.eQi.eWT.a((short) 4, this.fbR);
                }
            } else if (this.fdn != null) {
                this.fdn.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bnj() {
        super.bnj();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bnk() {
        super.bnk();
    }
}
