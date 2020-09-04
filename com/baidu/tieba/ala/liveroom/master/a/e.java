package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.tieba.ala.liveroom.data.f;
@Deprecated
/* loaded from: classes7.dex */
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
                this.gqf.gxL.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUO() {
        if (this.gqf != null && this.gqf.gxI != null) {
            if (this.gEE != null) {
                this.gEE.up(2);
            }
            this.gqf.gxI.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aT(int i, String str) {
        if (this.gqf != null && this.gqf.gxI.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.gqf != null && this.gqf.gxL != null && this.bMf != 4) {
                    this.gqf.gxL.a((short) 4, this.gDf);
                }
            } else if (this.gED != null) {
                this.gED.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUP() {
        super.bUP();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUQ() {
        super.bUQ();
    }
}
