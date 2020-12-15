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
                this.hjc.hqo.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ciO() {
        if (this.hjc != null && this.hjc.hqk != null) {
            if (this.hxy != null) {
                this.hxy.wX(2);
            }
            this.hjc.hqk.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bi(int i, String str) {
        if (this.hjc != null && this.hjc.hqk.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.hjc != null && this.hjc.hqo != null && this.cnU != 4) {
                    this.hjc.hqo.a((short) 4, this.hwb);
                }
            } else if (this.hxx != null) {
                this.hxx.onError(i, str);
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
