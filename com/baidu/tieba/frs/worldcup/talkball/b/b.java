package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bb;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes3.dex */
public class b {
    private bb buy;
    private f dLP;
    private boolean dLQ = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.buy = new bb();
                this.buy.a(cardInfo.thread_info);
                this.dLQ = false;
            }
            if (cardInfo.insert_floor != null) {
                this.dLP = new f();
                this.dLP.a(cardInfo.insert_floor);
                this.dLQ = true;
            }
        }
    }

    public bb Tg() {
        return this.buy;
    }

    public f aBx() {
        return this.dLP;
    }

    public boolean aBy() {
        return this.dLQ;
    }
}
