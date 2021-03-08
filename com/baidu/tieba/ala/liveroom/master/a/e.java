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
                this.hwy.hDL.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ciP() {
        if (this.hwy != null && this.hwy.hDH != null) {
            if (this.hKZ != null) {
                this.hKZ.vP(2);
            }
            this.hwy.hDH.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bq(int i, String str) {
        if (this.hwy != null && this.hwy.hDH.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.hwy != null && this.hwy.hDL != null && this.eBs != 4) {
                    this.hwy.hDL.a((short) 4, this.hJD);
                }
            } else if (this.hKY != null) {
                this.hKY.onError(i, str);
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
