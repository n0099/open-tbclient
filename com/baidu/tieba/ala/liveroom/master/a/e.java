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
                this.gTF.hbd.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ccX() {
        if (this.gTF != null && this.gTF.hba != null) {
            if (this.hir != null) {
                this.hir.vH(2);
            }
            this.gTF.hba.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bg(int i, String str) {
        if (this.gTF != null && this.gTF.hba.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.gTF != null && this.gTF.hbd != null && this.cdn != 4) {
                    this.gTF.hbd.a((short) 4, this.hgT);
                }
            } else if (this.hiq != null) {
                this.hiq.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ccY() {
        super.ccY();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ccZ() {
        super.ccZ();
    }
}
