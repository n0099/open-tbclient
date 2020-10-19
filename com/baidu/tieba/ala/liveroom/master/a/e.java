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
                this.gHQ.gPp.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bZT() {
        if (this.gHQ != null && this.gHQ.gPm != null) {
            if (this.gWB != null) {
                this.gWB.vn(2);
            }
            this.gHQ.gPm.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void be(int i, String str) {
        if (this.gHQ != null && this.gHQ.gPm.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.gHQ != null && this.gHQ.gPp != null && this.bUO != 4) {
                    this.gHQ.gPp.a((short) 4, this.gVf);
                }
            } else if (this.gWA != null) {
                this.gWA.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bZU() {
        super.bZU();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bZV() {
        super.bZV();
    }
}
