package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bb;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes3.dex */
public class b {
    private bb bJG;
    private f ecv;
    private boolean ecw = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.bJG = new bb();
                this.bJG.a(cardInfo.thread_info);
                this.ecw = false;
            }
            if (cardInfo.insert_floor != null) {
                this.ecv = new f();
                this.ecv.a(cardInfo.insert_floor);
                this.ecw = true;
            }
        }
    }

    public bb YL() {
        return this.bJG;
    }

    public f aGA() {
        return this.ecv;
    }

    public boolean aGB() {
        return this.ecw;
    }
}
