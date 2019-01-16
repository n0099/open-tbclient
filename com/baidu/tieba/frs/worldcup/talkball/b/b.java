package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.data.bb;
import tbclient.TalkBall.CardInfo;
/* loaded from: classes3.dex */
public class b {
    private bb bOk;
    private f emu;
    private boolean emv = false;

    public void a(CardInfo cardInfo) {
        if (cardInfo != null) {
            if (cardInfo.thread_info != null) {
                this.bOk = new bb();
                this.bOk.a(cardInfo.thread_info);
                this.emv = false;
            }
            if (cardInfo.insert_floor != null) {
                this.emu = new f();
                this.emu.a(cardInfo.insert_floor);
                this.emv = true;
            }
        }
    }

    public bb aaq() {
        return this.bOk;
    }

    public f aJz() {
        return this.emu;
    }

    public boolean aJA() {
        return this.emv;
    }
}
