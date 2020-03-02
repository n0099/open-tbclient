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
                this.eUa.faK.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boU() {
        if (this.eUa != null && this.eUa.faI != null) {
            if (this.fgy != null) {
                this.fgy.qn(2);
            }
            this.eUa.faI.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aw(int i, String str) {
        if (this.eUa != null && this.eUa.faI.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.eUa != null && this.eUa.faK != null && this.mCurrentState != 4) {
                    this.eUa.faK.a((short) 4, this.ffa);
                }
            } else if (this.fgx != null) {
                this.fgx.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boV() {
        super.boV();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void boW() {
        super.boW();
    }
}
