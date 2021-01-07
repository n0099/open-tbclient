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
                this.huX.hCk.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void clB() {
        if (this.huX != null && this.huX.hCg != null) {
            if (this.hJw != null) {
                this.hJw.xi(2);
            }
            this.huX.hCg.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bk(int i, String str) {
        if (this.huX != null && this.huX.hCg.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.huX != null && this.huX.hCk != null && this.cvb != 4) {
                    this.huX.hCk.a((short) 4, this.hHZ);
                }
            } else if (this.hJv != null) {
                this.hJv.onError(i, str);
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
