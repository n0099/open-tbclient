package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.ala.liveRecorder.video.VideoRecorderType;
/* loaded from: classes6.dex */
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
                this.dZB.efW.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUv() {
        if (this.dZB != null && this.dZB.efV != null) {
            if (this.elc != null) {
                this.elc.nK(2);
            }
            this.dZB.efV.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ac(int i, String str) {
        if (this.dZB != null && this.dZB.efV.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.dZB != null && this.dZB.efW != null && this.mCurrentState != 4) {
                    this.dZB.efW.a((short) 4, this.ejR);
                }
            } else if (this.elb != null) {
                this.elb.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUw() {
        super.aUw();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUx() {
        super.aUx();
    }
}
