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
                this.dYK.eff.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUt() {
        if (this.dYK != null && this.dYK.efe != null) {
            if (this.ekl != null) {
                this.ekl.nJ(2);
            }
            this.dYK.efe.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void ab(int i, String str) {
        if (this.dYK != null && this.dYK.efe.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.dYK != null && this.dYK.eff != null && this.mCurrentState != 4) {
                    this.dYK.eff.a((short) 4, this.eja);
                }
            } else if (this.ekk != null) {
                this.ekk.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUu() {
        super.aUu();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aUv() {
        super.aUv();
    }
}
