package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bb;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes3.dex */
public class b {
    private bb bIV;
    private f ebb;
    private boolean ebc = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.bIV = new bb();
                this.bIV.a(cardInfo.thread_info);
                this.ebc = false;
            }
            if (cardInfo.insert_floor != null) {
                this.ebb = new f();
                this.ebb.a(cardInfo.insert_floor);
                this.ebc = true;
            }
        }
    }

    public bb YB() {
        return this.bIV;
    }

    public f aHc() {
        return this.ebb;
    }

    public boolean aHd() {
        return this.ebc;
    }
}
