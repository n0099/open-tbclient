package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bb;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes3.dex */
public class b {
    private bb bIV;
    private f eba;
    private boolean ebb = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.bIV = new bb();
                this.bIV.a(cardInfo.thread_info);
                this.ebb = false;
            }
            if (cardInfo.insert_floor != null) {
                this.eba = new f();
                this.eba.a(cardInfo.insert_floor);
                this.ebb = true;
            }
        }
    }

    public bb YA() {
        return this.bIV;
    }

    public f aHc() {
        return this.eba;
    }

    public boolean aHd() {
        return this.ebb;
    }
}
