package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.ala.recorder.video.VideoRecorderType;
@Deprecated
/* loaded from: classes11.dex */
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
                this.huP.hCc.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ciJ() {
        if (this.huP != null && this.huP.hBY != null) {
            if (this.hJq != null) {
                this.hJq.vN(2);
            }
            this.huP.hBY.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bq(int i, String str) {
        if (this.huP != null && this.huP.hBY.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.huP != null && this.huP.hCc != null && this.ezR != 4) {
                    this.huP.hCc.a((short) 4, this.hHU);
                }
            } else if (this.hJp != null) {
                this.hJp.onError(i, str);
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
