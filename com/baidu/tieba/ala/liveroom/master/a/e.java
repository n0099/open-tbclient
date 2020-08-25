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
                this.gqb.gxH.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUN() {
        if (this.gqb != null && this.gqb.gxE != null) {
            if (this.gEA != null) {
                this.gEA.up(2);
            }
            this.gqb.gxE.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aU(int i, String str) {
        if (this.gqb != null && this.gqb.gxE.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.gqb != null && this.gqb.gxH != null && this.bMb != 4) {
                    this.gqb.gxH.a((short) 4, this.gDb);
                }
            } else if (this.gEz != null) {
                this.gEz.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUO() {
        super.bUO();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bUP() {
        super.bUP();
    }
}
