package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.ala.recorder.video.VideoRecorderType;
@Deprecated
/* loaded from: classes4.dex */
public class e extends a {
    public e(com.baidu.tieba.ala.liveroom.data.e eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void a(short s, Object obj) {
        super.a(s, obj);
        switch (s) {
            case 1:
                this.gZr.hgF.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ceR() {
        if (this.gZr != null && this.gZr.hgB != null) {
            if (this.hnP != null) {
                this.hnP.ws(2);
            }
            this.gZr.hgB.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bi(int i, String str) {
        if (this.gZr != null && this.gZr.hgB.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.gZr != null && this.gZr.hgF != null && this.chm != 4) {
                    this.gZr.hgF.a((short) 4, this.hmx);
                }
            } else if (this.hnO != null) {
                this.hnO.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ceS() {
        super.ceS();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ceT() {
        super.ceT();
    }
}
