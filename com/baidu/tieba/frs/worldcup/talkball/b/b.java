package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bb;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes3.dex */
public class b {
    private bb bOl;
    private f emv;
    private boolean emw = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.bOl = new bb();
                this.bOl.a(cardInfo.thread_info);
                this.emw = false;
            }
            if (cardInfo.insert_floor != null) {
                this.emv = new f();
                this.emv.a(cardInfo.insert_floor);
                this.emw = true;
            }
        }
    }

    public bb aaq() {
        return this.bOl;
    }

    public f aJz() {
        return this.emv;
    }

    public boolean aJA() {
        return this.emw;
    }
}
