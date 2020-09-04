package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fCA = BdUniqueId.gen();
    public String entryName;
    public bw fCB;
    public boolean fCC;
    public boolean fCD;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean fCz = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fCA;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.fCB == null) {
            this.fCB = new bw();
        }
        this.fCB.a(threadInfo);
    }

    public bw bce() {
        return this.fCB;
    }
}
