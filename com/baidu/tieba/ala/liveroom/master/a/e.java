package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.ala.recorder.video.VideoRecorderType;
@Deprecated
/* loaded from: classes10.dex */
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
                this.hqr.hxE.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void chJ() {
        if (this.hqr != null && this.hqr.hxA != null) {
            if (this.hEQ != null) {
                this.hEQ.vC(2);
            }
            this.hqr.hxA.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bl(int i, String str) {
        if (this.hqr != null && this.hqr.hxA.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.hqr != null && this.hqr.hxE != null && this.cqj != 4) {
                    this.hqr.hxE.a((short) 4, this.hDt);
                }
            } else if (this.hEP != null) {
                this.hEP.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void markEnterBackground() {
        super.markEnterBackground();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void markEnterForeground() {
        super.markEnterForeground();
    }
}
