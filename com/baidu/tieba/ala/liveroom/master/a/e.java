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
                this.eTZ.faJ.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boS() {
        if (this.eTZ != null && this.eTZ.faH != null) {
            if (this.fgx != null) {
                this.fgx.qn(2);
            }
            this.eTZ.faH.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aw(int i, String str) {
        if (this.eTZ != null && this.eTZ.faH.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.eTZ != null && this.eTZ.faJ != null && this.mCurrentState != 4) {
                    this.eTZ.faJ.a((short) 4, this.feZ);
                }
            } else if (this.fgw != null) {
                this.fgw.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boT() {
        super.boT();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boU() {
        super.boU();
    }
}
