package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.tieba.ala.liveroom.data.f;
@Deprecated
/* loaded from: classes4.dex */
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
                this.gdS.glD.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bKK() {
        if (this.gdS != null && this.gdS.glA != null) {
            if (this.grG != null) {
                this.grG.rZ(2);
            }
            this.gdS.glA.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aW(int i, String str) {
        if (this.gdS != null && this.gdS.glA.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.gdS != null && this.gdS.glD != null && this.bGB != 4) {
                    this.gdS.glD.a((short) 4, this.gqi);
                }
            } else if (this.grF != null) {
                this.grF.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bKL() {
        super.bKL();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bKM() {
        super.bKM();
    }
}
