package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bc;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes2.dex */
public class b {
    private bc btP;
    private f dJe;
    private boolean dJf = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.btP = new bc();
                this.btP.a(cardInfo.thread_info);
                this.dJf = false;
            }
            if (cardInfo.insert_floor != null) {
                this.dJe = new f();
                this.dJe.a(cardInfo.insert_floor);
                this.dJf = true;
            }
        }
    }

    public bc SV() {
        return this.btP;
    }

    public f aAR() {
        return this.dJe;
    }

    public boolean aAS() {
        return this.dJf;
    }
}
