package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bb;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes3.dex */
public class b {
    private bb bNv;
    private f eiY;
    private boolean eiZ = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.bNv = new bb();
                this.bNv.a(cardInfo.thread_info);
                this.eiZ = false;
            }
            if (cardInfo.insert_floor != null) {
                this.eiY = new f();
                this.eiY.a(cardInfo.insert_floor);
                this.eiZ = true;
            }
        }
    }

    public bb ZR() {
        return this.bNv;
    }

    public f aIm() {
        return this.eiY;
    }

    public boolean aIn() {
        return this.eiZ;
    }
}
