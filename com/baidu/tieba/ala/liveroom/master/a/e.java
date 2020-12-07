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
                this.hja.hqm.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ciN() {
        if (this.hja != null && this.hja.hqi != null) {
            if (this.hxw != null) {
                this.hxw.wX(2);
            }
            this.hja.hqi.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bi(int i, String str) {
        if (this.hja != null && this.hja.hqi.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.hja != null && this.hja.hqm != null && this.cnU != 4) {
                    this.hja.hqm.a((short) 4, this.hvZ);
                }
            } else if (this.hxv != null) {
                this.hxv.onError(i, str);
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
