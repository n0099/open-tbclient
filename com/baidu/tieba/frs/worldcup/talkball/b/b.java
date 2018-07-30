package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bb;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes3.dex */
public class b {
    private bb buw;
    private f dLT;
    private boolean dLU = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.buw = new bb();
                this.buw.a(cardInfo.thread_info);
                this.dLU = false;
            }
            if (cardInfo.insert_floor != null) {
                this.dLT = new f();
                this.dLT.a(cardInfo.insert_floor);
                this.dLU = true;
            }
        }
    }

    public bb Td() {
        return this.buw;
    }

    public f aBA() {
        return this.dLT;
    }

    public boolean aBB() {
        return this.dLU;
    }
}
