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
                this.gtv.gAW.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bWy() {
        if (this.gtv != null && this.gtv.gAT != null) {
            if (this.gIb != null) {
                this.gIb.uI(2);
            }
            this.gtv.gAT.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aU(int i, String str) {
        if (this.gtv != null && this.gtv.gAT.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.gtv != null && this.gtv.gAW != null && this.bOf != 4) {
                    this.gtv.gAW.a((short) 4, this.gGG);
                }
            } else if (this.gIa != null) {
                this.gIa.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bWz() {
        super.bWz();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bWA() {
        super.bWA();
    }
}
