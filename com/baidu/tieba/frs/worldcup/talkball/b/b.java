package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bb;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes3.dex */
public class b {
    private bb bNy;
    private f elO;
    private boolean elP = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.bNy = new bb();
                this.bNy.a(cardInfo.thread_info);
                this.elP = false;
            }
            if (cardInfo.insert_floor != null) {
                this.elO = new f();
                this.elO.a(cardInfo.insert_floor);
                this.elP = true;
            }
        }
    }

    public bb ZT() {
        return this.bNy;
    }

    public f aJb() {
        return this.elO;
    }

    public boolean aJc() {
        return this.elP;
    }
}
