package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bb;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes3.dex */
public class b {
    private bb bAn;
    private f dTh;
    private boolean dTi = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.bAn = new bb();
                this.bAn.a(cardInfo.thread_info);
                this.dTi = false;
            }
            if (cardInfo.insert_floor != null) {
                this.dTh = new f();
                this.dTh.a(cardInfo.insert_floor);
                this.dTi = true;
            }
        }
    }

    public bb UT() {
        return this.bAn;
    }

    public f aDK() {
        return this.dTh;
    }

    public boolean aDL() {
        return this.dTi;
    }
}
