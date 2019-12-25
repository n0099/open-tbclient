package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.ala.recorder.video.VideoRecorderType;
/* loaded from: classes2.dex */
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
                this.eOH.eUZ.a((short) 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bmk() {
        if (this.eOH != null && this.eOH.eUY != null) {
            if (this.faA != null) {
                this.faA.qa(2);
            }
            this.eOH.eUY.startRecord();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void aq(int i, String str) {
        if (this.eOH != null && this.eOH.eUY.getVideoRecorderType() == VideoRecorderType.SCREEN) {
            if (i == 0) {
                if (this.eOH != null && this.eOH.eUZ != null && this.mCurrentState != 4) {
                    this.eOH.eUZ.a((short) 4, this.eZl);
                }
            } else if (this.faz != null) {
                this.faz.onError(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bml() {
        super.bml();
    }

    @Override // com.baidu.tieba.ala.liveroom.master.a.a
    public void bmm() {
        super.bmm();
    }
}
