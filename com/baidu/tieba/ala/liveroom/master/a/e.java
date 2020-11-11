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
                this.gZK.hgY.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void cfy() {
        if (this.gZK != null && this.gZK.hgU != null) {
            if (this.hoi != null) {
                this.hoi.vU(2);
            }
            this.gZK.hgU.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bk(int i, String str) {
        if (this.gZK != null && this.gZK.hgU.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.gZK != null && this.gZK.hgY != null && this.ciY != 4) {
                    this.gZK.hgY.a((short) 4, this.hmQ);
                }
            } else if (this.hoh != null) {
                this.hoh.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void cfz() {
        super.cfz();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void cfA() {
        super.cfA();
    }
}
