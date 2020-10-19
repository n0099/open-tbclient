package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fRV = BdUniqueId.gen();
    public String entryName;
    public bw fRW;
    public boolean fRX;
    public boolean fRY;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean fRU = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fRV;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.fRW == null) {
            this.fRW = new bw();
        }
        this.fRW.a(threadInfo);
    }

    public bw bfG() {
        return this.fRW;
    }
}
