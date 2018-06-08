package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bd;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes2.dex */
public class b {
    private bd bso;
    private f dFL;
    private boolean dFM = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.bso = new bd();
                this.bso.a(cardInfo.thread_info);
                this.dFM = false;
            }
            if (cardInfo.insert_floor != null) {
                this.dFL = new f();
                this.dFL.a(cardInfo.insert_floor);
                this.dFM = true;
            }
        }
    }

    public bd Sz() {
        return this.bso;
    }

    public f aAk() {
        return this.dFL;
    }

    public boolean aAl() {
        return this.dFM;
    }
}
