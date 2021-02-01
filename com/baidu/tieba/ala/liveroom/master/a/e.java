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
                this.huB.hBO.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ciC() {
        if (this.huB != null && this.huB.hBK != null) {
            if (this.hJc != null) {
                this.hJc.vN(2);
            }
            this.huB.hBK.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bq(int i, String str) {
        if (this.huB != null && this.huB.hBK.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.huB != null && this.huB.hBO != null && this.ezR != 4) {
                    this.huB.hBO.a((short) 4, this.hHG);
                }
            } else if (this.hJb != null) {
                this.hJb.onError(i, str);
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
